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

(ns generics.GenericConstructedReturnTypeIsResolved
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]
           [system.collections.generic List_1]
           [system.collections.objectmodel ReadOnlyCollection_1]))

;; Exercises a method whose return type is a constructed generic over a class-level type
;; parameter: List<T>.AsReadOnly() returns ReadOnlyCollection<T> and List<T>.GetRange(...)
;; returns List<T>. They must be declared as ReadOnlyCollection_1<T> / List_1<T>, not as the raw
;; classes, while the returned instance is still wrapped correctly.
(defn- test-generic-constructed-return-type-is-resolved []
  (gs/assert-parameterized (.getGenericReturnType (.getMethod List_1 "AsReadOnly" (into-array Class [])))
                        ReadOnlyCollection_1 List_1 "T")
  (gs/assert-parameterized (.getGenericReturnType (.getMethod List_1 "GetRange" (into-array Class [Integer/TYPE Integer/TYPE])))
                        List_1 List_1 "T")

  ;; the typed results are usable end to end
  (let [^List_1 lst (gs/new-generic List_1 [system.Object])
        a (system.Object.)
        b (system.Object.)]
    (.Add lst ^IJCOBridgeReflected a)
    (.Add lst ^IJCOBridgeReflected b)
    (let [^ReadOnlyCollection_1 read-only (.AsReadOnly lst)]
      (when-not (= 2 (.getCount read-only))
        (throw (AssertionError. "Expected 2 elements in the read-only view"))))
    (let [^List_1 range (.GetRange lst 0 1)]
      (when-not (= 1 (.getCount range))
        (throw (AssertionError. "Expected 1 element in the range"))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-constructed-return-type-is-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
