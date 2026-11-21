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

(ns generics.GenericConstructedPropertyTypeIsResolved
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]
           [system.collections.concurrent ConcurrentDictionary_2]
           [system.collections.generic ICollection_1 IDictionary_2]))

;; Exercises a property whose type is a constructed generic over the type parameters in scope:
;; IDictionary<TKey,TValue>.Keys is ICollection<TKey> and .Values is ICollection<TValue>, and the
;; same holds for the public ConcurrentDictionary<TKey,TValue>.Keys/Values. They must be exposed
;; as ICollection_1<TKey> / ICollection_1<TValue>, not as the raw ICollection_1.
(defn- test-generic-constructed-property-type-is-resolved []
  (gs/assert-parameterized (.getGenericReturnType (.getMethod IDictionary_2 "getKeys" (into-array Class [])))
                           ICollection_1 IDictionary_2 "TKey")
  (gs/assert-parameterized (.getGenericReturnType (.getMethod IDictionary_2 "getValues" (into-array Class [])))
                           ICollection_1 IDictionary_2 "TValue")
  (gs/assert-parameterized (.getGenericReturnType (.getMethod ConcurrentDictionary_2 "getKeys" (into-array Class [])))
                           ICollection_1 ConcurrentDictionary_2 "TKey")
  (gs/assert-parameterized (.getGenericReturnType (.getMethod ConcurrentDictionary_2 "getValues" (into-array Class [])))
                           ICollection_1 ConcurrentDictionary_2 "TValue")

  ;; the typed property is usable end to end
  (let [^ConcurrentDictionary_2 dict (gs/new-generic ConcurrentDictionary_2 [system.Object system.Object])
        k (system.Object.)
        v (system.Object.)]
    (when-not (.TryAdd dict ^IJCOBridgeReflected k ^IJCOBridgeReflected v)
      (throw (AssertionError. "TryAdd of a new key must succeed")))
    (let [^ICollection_1 keys (.getKeys dict)
          ^ICollection_1 values (.getValues dict)]
      (when-not (= 1 (.getCount keys)) (throw (AssertionError. "Expected 1 key")))
      (when-not (= 1 (.getCount values)) (throw (AssertionError. "Expected 1 value"))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-constructed-property-type-is-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
