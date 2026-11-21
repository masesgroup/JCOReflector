;;  MIT License
;;
;;  Copyright (c) 2020-2026 MASES s.r.l.
;;
;;  Permission is hereby granted, free of charge, to any person obtaining a copy
;;  of this software and associated documentation files (the "Software"), to deal
;;  in the Software without restriction, including without limitation the rights
;;  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;;  copies of the Software, and to permit persons to whom the Software is
;;  furnished to do so, subject to the following conditions:
;;
;;  The above copyright notice and this permission notice shall be included in all
;;  copies or substantial portions of the Software.
;;
;;  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;;  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;;  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;;  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;;  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;;  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;;  SOFTWARE.

(ns generics.GenericClosedEventHandlerTypeIsResolved
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system AppDomain Console Environment EventHandler_1 FormatException Int32]
           [system.runtime.exceptionservices FirstChanceExceptionEventArgs]))

;; Exercises an event whose handler is a fully closed generic delegate:
;; AppDomain.FirstChanceException is an EventHandler<FirstChanceExceptionEventArgs>. Such events used
;; to be dropped altogether. The registration must take an EventHandler_1<FirstChanceExceptionEventArgs>
;; and the Java handler must really be invoked by the CLR: a failing Int32.Parse raises a first-chance
;; exception on the .NET side.
(defn- test-generic-closed-event-handler-type-is-resolved []
  ;; the signature carries the closed type argument...
  (let [parameter (aget (.getGenericParameterTypes (.getMethod AppDomain "addFirstChanceException" (into-array Class [EventHandler_1]))) 0)]
    (when-not (instance? ParameterizedType parameter)
      (throw (AssertionError. (str "Expected EventHandler_1<FirstChanceExceptionEventArgs>, got " parameter))))
    (when-not (identical? (.getRawType ^ParameterizedType parameter) EventHandler_1)
      (throw (AssertionError. (str "Expected an EventHandler_1, got " (.getRawType ^ParameterizedType parameter)))))
    (when-not (identical? (aget (.getActualTypeArguments ^ParameterizedType parameter) 0) FirstChanceExceptionEventArgs)
      (throw (AssertionError. (str "Expected FirstChanceExceptionEventArgs, got " (aget (.getActualTypeArguments ^ParameterizedType parameter) 0))))))

  ;; ...and the handler is really called back by the runtime
  (let [calls (atom 0)
        ;; keep it minimal: this handler runs for every first-chance exception of the process
        handler (gs/new-generic EventHandler_1 [FirstChanceExceptionEventArgs]
                                {"Invoke" (fn [sender e]
                                           (try (swap! calls inc)
                                                (catch Throwable t (.printStackTrace t)))
                                           nil)})
        domain (AppDomain/getCurrentDomain)]
    (.addFirstChanceException domain handler)
    (try
      (try
        (Int32/Parse "not a number")
        (catch FormatException _ nil))
      (finally
        (.removeFirstChanceException domain handler)))
    (when (zero? @calls)
      (throw (AssertionError. "The Java handler was never invoked")))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-closed-event-handler-type-is-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
