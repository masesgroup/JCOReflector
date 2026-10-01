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

(ns generics.GenericComparisonDelegateSortsAList
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.util.concurrent.atomic AtomicInteger]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector]
           [system Comparison_1 Console Environment]
           [system.collections.generic List_1]))

;; Exercises a generic delegate with a primitive return type (Comparison<T> returns int).
;; The delegate is a generated subclass whose Invoke is forwarded to the Clojure fn.
;; The arguments are hinted as IJCOBridgeReflected on purpose: javac picks Add(T) from the
;; generic parameter, while Clojure only sees the erased overloads and would otherwise choose
;; the more specific explicit-interface Add(...) that throws UnsupportedOperationException.
(defn- test-generic-comparison-delegate-sorts-a-list []
  (let [^List_1 lst (gs/new-generic List_1 [system.Object])
        calls (AtomicInteger.)
        a (system.Object.)
        b (system.Object.)]
    (.Add lst ^IJCOBridgeReflected a)
    (.Add lst ^IJCOBridgeReflected b)
    (let [^Comparison_1 comparison (gs/new-generic Comparison_1 [system.Object]
                                                   {"Invoke" (fn [_ _]
                                                               (.incrementAndGet calls)
                                                               0)})]
      ;; Sort is selected by reflection on purpose: javac resolves Sort(Comparison_1<T>) from the
      ;; static type, but Clojure compiled the call against Sort(IComparer_1) (ClassCastException).
      (let [sort-method (.getMethod List_1 "Sort" (into-array Class [Comparison_1]))]
        (try
          (.invoke sort-method lst (object-array [comparison]))
          (catch java.lang.reflect.InvocationTargetException e
            (throw (.getCause e)))))
      (when (zero? (.get calls))
        (throw (AssertionError. "Java comparison never invoked"))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-comparison-delegate-sorts-a-list)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
