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

(ns generics.GenericClosedTypeArgumentsAreResolved
  (:gen-class)
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]
           [system.collections.generic IEnumerable_1 IList_1]
           [system.reflection Assembly CustomAttributeData TypeInfo]
           [system.threading.tasks Task]))

;; Exercises fully closed generic types in member signatures, whose type arguments are reflected
;; classes: Task.WhenAll(IEnumerable<Task>) as a parameter, Assembly.DefinedTypes
;; (IEnumerable<TypeInfo>) as a property and Assembly.GetCustomAttributesData()
;; (IList<CustomAttributeData>) as a return type. They used to be declared with the raw type.
;; Arguments that are not reflected classes (string, int...) keep the raw type, as before.
(defn- test-generic-closed-type-arguments-are-resolved []
  (assert-closed (aget (.getGenericParameterTypes (.getMethod Task "WhenAll" (into-array Class [IEnumerable_1]))) 0)
                 IEnumerable_1 Task)
  (assert-closed (.getGenericReturnType (.getMethod Assembly "getDefinedTypes" (into-array Class [])))
                 IEnumerable_1 TypeInfo)
  (assert-closed (.getGenericReturnType (.getMethod Assembly "GetCustomAttributesData" (into-array Class [])))
                 IList_1 CustomAttributeData)

  ;; a typed property is usable end to end
  (let [assembly (Assembly/GetExecutingAssembly)]
    (when (nil? (.getDefinedTypes assembly))
      (throw (AssertionError. "Expected a non-null collection of defined types")))))

(defn- assert-closed [tp raw argument]
  (when-not (instance? ParameterizedType tp)
    (throw (AssertionError. (str "Expected " (.getSimpleName ^Class raw) "<" (.getSimpleName ^Class argument) ">, got " tp))))
  (when-not (identical? (.getRawType ^ParameterizedType tp) raw)
    (throw (AssertionError. (str "Expected raw type " (.getSimpleName ^Class raw) ", got " (.getRawType ^ParameterizedType tp)))))
  (when-not (identical? (aget (.getActualTypeArguments ^ParameterizedType tp) 0) argument)
    (throw (AssertionError. (str "Expected type argument " (.getSimpleName ^Class argument) ", got " (aget (.getActualTypeArguments ^ParameterizedType tp) 0))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-closed-type-arguments-are-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
