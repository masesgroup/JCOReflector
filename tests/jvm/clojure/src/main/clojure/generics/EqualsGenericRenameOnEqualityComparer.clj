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

(ns generics.EqualsGenericRenameOnEqualityComparer
  (:gen-class)
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector]
           [system Console Environment]))

(defn- assert-missing [^Class c ^String method-name & params]
  (let [found? (try
                 (.getMethod c method-name (into-array Class params))
                 true
                 (catch NoSuchMethodException _
                   false))]
    (when found?
      (throw (AssertionError.
              (str (.getSimpleName c) "." method-name " should have been renamed"))))))

;; Exercises the EqualsGeneric() rename: a class-level Equals(T[,T]) that would otherwise
;; erase to the same signature as NetObject.Equals(IJCOBridgeReflected[,IJCOBridgeReflected])
;; is exposed under a different name so both remain callable.
(defn- test-equals-generic-rename-on-equality-comparer []
  (let [cl (.getClassLoader JCOReflector)
        comparer (Class/forName "system.collections.generic.IEqualityComparer_1" false cl)]
    (.getMethod comparer "EqualsGeneric" (into-array Class [IJCOBridgeReflected IJCOBridgeReflected]))
    (assert-missing comparer "Equals" IJCOBridgeReflected IJCOBridgeReflected)

    (let [equatable (Class/forName "system.IEquatable_1" false cl)]
      (.getMethod equatable "EqualsGeneric" (into-array Class [IJCOBridgeReflected]))
      (assert-missing equatable "Equals" IJCOBridgeReflected))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-equals-generic-rename-on-equality-comparer)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
