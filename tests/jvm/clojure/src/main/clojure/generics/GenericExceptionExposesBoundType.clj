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

(ns generics.GenericExceptionExposesBoundType
  (:gen-class)
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector]
           [system Console Environment]))

;; Exercises the exception-specific fallback: a generic .NET exception (e.g.
;; FaultException<TDetail>) can never become a generic Java class, so its class-level
;; type parameter is always exposed as its bound, IJCOBridgeReflected.
(defn- test-generic-exception-exposes-bound-type []
  (let [^Class ex (try
                    (Class/forName "system.servicemodel.FaultException_1" false
                                   (.getClassLoader JCOReflector))
                    (catch ClassNotFoundException _
                      nil))]
    (if (nil? ex)
      (Console/WriteLine "FaultException_1 not available in this framework, skipping")
      (do
        ;; A generic Java class can't extend Throwable, so it must be plain, non-generic...
        (when-not (zero? (count (.getTypeParameters ex)))
          (throw (AssertionError. "FaultException_1 must not be generic")))
        ;; ...and its class-level type parameter is exposed as the bound.
        (when-not (identical? (.getReturnType (.getMethod ex "getDetail" (into-array Class [])))
                              IJCOBridgeReflected)
          (throw (AssertionError. "getDetail() must return IJCOBridgeReflected")))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-exception-exposes-bound-type)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
