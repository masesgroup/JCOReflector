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

(ns generics.GenericCastToGenericTypes
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]
           [system.collections.generic Dictionary_2 IDictionary_2 List_1]))

;; Exercises the cast of a reflected generic instance. The wrapper of a generic type reports the open
;; generic definition as its type, so a cast to a generic interface (ToIDictionary_2) used to be refused with
;; an UnsupportedOperationException even when the instance implements it. The cast is now accepted when the
;; runtime type of the instance, one of its base types or one of its interfaces is built from the target
;; definition, and it is still refused for an instance that is not.
(defn- test-generic-cast-to-generic-types []
  (let [^Dictionary_2 dict (gs/new-generic Dictionary_2 [system.Object system.Object])
        k (system.Object.)
        v (system.Object.)]
    (.Add dict ^IJCOBridgeReflected k ^IJCOBridgeReflected v)

    ;; a generic interface the instance implements
    (let [as-interface (IDictionary_2/ToIDictionary_2 dict)]
      (when (nil? as-interface)
        (throw (AssertionError. "The cast to IDictionary_2 must return an instance")))
      (when-not (.ContainsKey ^IDictionary_2 as-interface ^IJCOBridgeReflected k)
        (throw (AssertionError. "The casted instance must see the added key"))))

    ;; the generic class itself
    (when (nil? (Dictionary_2/cast dict))
      (throw (AssertionError. "The cast to Dictionary_2 must return an instance"))))

  ;; an instance that does not implement the interface is still refused, and the message names the target
  (let [^List_1 lst (gs/new-generic List_1 [system.Object])
        message (try (IDictionary_2/ToIDictionary_2 lst)
                     (throw (AssertionError. "A List_1 must not be castable to IDictionary_2"))
                     (catch UnsupportedOperationException e (.getMessage e)))]
    (when (or (nil? message) (not (.contains ^String message "IDictionary")))
      (throw (AssertionError. (str "The message must name the target type, got: " message))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-cast-to-generic-types)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
