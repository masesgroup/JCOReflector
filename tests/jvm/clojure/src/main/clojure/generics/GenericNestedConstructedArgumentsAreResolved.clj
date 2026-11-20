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

(ns generics.GenericNestedConstructedArgumentsAreResolved
  (:gen-class)
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]
           [system.collections.generic IEnumerable_1 KeyValuePair_2]))

;; Exercises the recursive resolution of nested type arguments: the constructor
;; ConcurrentDictionary<TKey,TValue>(IEnumerable<KeyValuePair<TKey,TValue>>) must be exposed as
;; IEnumerable_1<KeyValuePair_2<TKey,TValue>>, with both inner arguments being the type
;; parameters of the class, not the raw IEnumerable_1 and not a raw KeyValuePair_2.
(defn- test-generic-nested-constructed-arguments-are-resolved []
  (let [dictionary (try (Class/forName "system.collections.concurrent.ConcurrentDictionary_2" false (.getClassLoader JCOReflector))
                        (catch ClassNotFoundException _ nil))]
    (if (nil? dictionary)
      (Console/WriteLine "ConcurrentDictionary_2 not available in this framework, skipping")
      (let [parameter (aget (.getGenericParameterTypes (.getConstructor ^Class dictionary (into-array Class [IEnumerable_1]))) 0)]
        (when-not (instance? ParameterizedType parameter)
          (throw (AssertionError. (str "Constructor parameter must be IEnumerable_1<...>, got " parameter))))
        (when-not (identical? (.getRawType ^ParameterizedType parameter) IEnumerable_1)
          (throw (AssertionError. (str "Constructor parameter must be an IEnumerable_1, got " (.getRawType ^ParameterizedType parameter)))))
        (let [element (aget (.getActualTypeArguments ^ParameterizedType parameter) 0)]
          (when-not (instance? ParameterizedType element)
            (throw (AssertionError. (str "Element type must be KeyValuePair_2<TKey,TValue>, got " element))))
          (when-not (identical? (.getRawType ^ParameterizedType element) KeyValuePair_2)
            (throw (AssertionError. (str "Element type must be a KeyValuePair_2, got " (.getRawType ^ParameterizedType element)))))
          (doseq [[i expected] (map-indexed vector ["TKey" "TValue"])]
            (let [argument (aget (.getActualTypeArguments ^ParameterizedType element) i)]
              (when-not (and (instance? TypeVariable argument)
                             (identical? (.getGenericDeclaration ^TypeVariable argument) dictionary)
                             (= (.getName ^TypeVariable argument) expected))
                (throw (AssertionError. (str "Expected type variable " expected " of the dictionary, got " argument)))))))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-nested-constructed-arguments-are-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
