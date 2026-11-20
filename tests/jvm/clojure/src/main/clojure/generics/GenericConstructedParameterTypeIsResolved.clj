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

(ns generics.GenericConstructedParameterTypeIsResolved
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Action_1 Console Environment]
           [system.collections.generic List_1]))

;; Exercises a method parameter that is itself a constructed generic type over a class-level
;; type parameter: List<T>.ForEach(Action<T>). The parameter must be exposed as Action_1<T>,
;; not as the raw Action_1, otherwise the type argument is lost.
(defn- test-generic-constructed-parameter-type-is-resolved []
  ;; the signature carries the type argument...
  (let [for-each (.getMethod List_1 "ForEach" (into-array Class [Action_1]))
        parameter (aget (.getGenericParameterTypes for-each) 0)]
    (when-not (instance? ParameterizedType parameter)
      (throw (AssertionError. (str "ForEach parameter must be Action_1<T>, got " parameter))))
    (when-not (identical? (.getRawType ^ParameterizedType parameter) Action_1)
      (throw (AssertionError. (str "ForEach parameter must be an Action_1, got " (.getRawType ^ParameterizedType parameter)))))
    (let [argument (aget (.getActualTypeArguments ^ParameterizedType parameter) 0)]
      (when-not (and (instance? TypeVariable argument)
                     (identical? (.getGenericDeclaration ^TypeVariable argument) List_1))
        (throw (AssertionError. (str "The type argument must be the type parameter of List_1, got " argument))))))

  ;; ...and the call still works end to end
  (let [^List_1 lst (gs/new-generic List_1 [system.Object])
        a (system.Object.)
        b (system.Object.)
        calls (atom 0)
        action (gs/new-generic Action_1 [system.Object]
                               {"Invoke" (fn [x] (swap! calls inc) nil)})]
    (.Add lst ^IJCOBridgeReflected a)
    (.Add lst ^IJCOBridgeReflected b)
    (.ForEach lst action)
    (when-not (= 2 @calls)
      (throw (AssertionError. (str "Java action must be invoked once per element, got " @calls))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-constructed-parameter-type-is-resolved)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
