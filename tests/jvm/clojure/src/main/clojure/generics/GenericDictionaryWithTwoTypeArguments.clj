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

(ns generics.GenericDictionaryWithTwoTypeArguments
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector]
           [system Console Environment]
           [system.collections.generic Dictionary_2]))

;; Exercises a class with TWO class-level type parameters (Dictionary<TKey,TValue>);
;; both type arguments must be reflected types.
;; The arguments are hinted as IJCOBridgeReflected on purpose: javac picks Add(T) from the
;; generic parameter, while Clojure only sees the erased overloads and would otherwise choose
;; the more specific explicit-interface Add(...) that throws UnsupportedOperationException.
(defn- test-generic-dictionary-with-two-type-arguments []
  (let [^Dictionary_2 dict (gs/new-generic Dictionary_2 [system.Object system.Object])
        k (system.Object.)
        v (system.Object.)]
    (.Add dict ^IJCOBridgeReflected k ^IJCOBridgeReflected v)
    (when-not (= 1 (.getCount dict))
      (throw (AssertionError. "Expected 1 entry after Add")))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-dictionary-with-two-type-arguments)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
