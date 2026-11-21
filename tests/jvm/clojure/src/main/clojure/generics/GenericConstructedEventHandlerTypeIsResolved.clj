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

(ns generics.GenericConstructedEventHandlerTypeIsResolved
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment EventHandler_1 Progress_1]))

;; Exercises an event whose handler is a constructed generic delegate over a class-level type
;; parameter: Progress<T>.ProgressChanged is an EventHandler<T>. Such events used to be dropped
;; altogether (only non-generic delegate types were accepted); now addProgressChanged and
;; removeProgressChanged are generated and take an EventHandler_1<T>.
(defn- test-generic-constructed-event-handler-type-is-resolved []
  (gs/assert-parameterized (aget (.getGenericParameterTypes (.getMethod Progress_1 "addProgressChanged" (into-array Class [EventHandler_1]))) 0)
                        EventHandler_1 Progress_1 "T")
  (gs/assert-parameterized (aget (.getGenericParameterTypes (.getMethod Progress_1 "removeProgressChanged" (into-array Class [EventHandler_1]))) 0)
                        EventHandler_1 Progress_1 "T"))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-constructed-event-handler-type-is-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
