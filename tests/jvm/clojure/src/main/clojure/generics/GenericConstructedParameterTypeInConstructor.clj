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

(ns generics.GenericConstructedParameterTypeInConstructor
  (:gen-class)
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]
           [system.collections.generic IEnumerable_1 List_1]))

;; Exercises a constructor parameter that is a constructed generic type over a class-level
;; type parameter: List<T>(IEnumerable<T>). The parameter must be exposed as IEnumerable_1<T>,
;; not as the raw IEnumerable_1, the same rule applied to method parameters.
(defn- test-generic-constructed-parameter-type-in-constructor []
  (let [parameter (aget (.getGenericParameterTypes (.getConstructor List_1 (into-array Class [IEnumerable_1]))) 0)]
    (when-not (instance? ParameterizedType parameter)
      (throw (AssertionError. (str "Constructor parameter must be IEnumerable_1<T>, got " parameter))))
    (when-not (identical? (.getRawType ^ParameterizedType parameter) IEnumerable_1)
      (throw (AssertionError. (str "Constructor parameter must be an IEnumerable_1, got " (.getRawType ^ParameterizedType parameter)))))
    (let [argument (aget (.getActualTypeArguments ^ParameterizedType parameter) 0)]
      (when-not (and (instance? TypeVariable argument)
                     (identical? (.getGenericDeclaration ^TypeVariable argument) List_1))
        (throw (AssertionError. (str "The type argument must be the type parameter of List_1, got " argument))))))

  ;; the other constructors are untouched
  (.getConstructor List_1 (into-array Class []))
  (.getConstructor List_1 (into-array Class [Integer/TYPE])))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-constructed-parameter-type-in-constructor)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
