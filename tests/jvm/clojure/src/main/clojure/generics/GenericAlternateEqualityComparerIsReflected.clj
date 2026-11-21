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

(ns generics.GenericAlternateEqualityComparerIsReflected
  (:gen-class)
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]))

;; IAlternateEqualityComparer<TAlternate,T> (.NET 9+) was kept out of the reflected types. Its
;; Equals(TAlternate, T) takes two different type parameters and erases to the same signature as
;; NetObject.Equals(IJCOBridgeReflected, IJCOBridgeReflected): like Equals(T, T) of IEqualityComparer<T>,
;; it is exposed as EqualsGeneric so that both remain callable.
(defn- assert-missing [^Class c name & params]
  (let [found (try (.getMethod c ^String name (into-array Class params)) true
                   (catch NoSuchMethodException _ false))]
    (when found
      (throw (AssertionError. (str (.getSimpleName c) "." name " should have been renamed"))))))

(defn- test-generic-alternate-equality-comparer-is-reflected []
  (let [comparer (try (Class/forName "system.collections.generic.IAlternateEqualityComparer_2" false (.getClassLoader JCOReflector))
                      (catch ClassNotFoundException _ nil))]
    (if (nil? comparer)
      (Console/WriteLine "IAlternateEqualityComparer_2 not available in this framework (.NET 9+), skipping")
      (let [^Class c comparer]
        (when-not (= 2 (alength (.getTypeParameters c)))
          (throw (AssertionError. "IAlternateEqualityComparer_2 must have two type parameters")))
        (.getMethod c "EqualsGeneric" (into-array Class [IJCOBridgeReflected IJCOBridgeReflected]))
        (assert-missing c "Equals" IJCOBridgeReflected IJCOBridgeReflected)
        (.getMethod c "Create" (into-array Class [IJCOBridgeReflected]))
        (.getMethod c "GetHashCode" (into-array Class [IJCOBridgeReflected]))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-alternate-equality-comparer-is-reflected)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
