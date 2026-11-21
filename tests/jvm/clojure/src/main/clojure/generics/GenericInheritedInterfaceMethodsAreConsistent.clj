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

(ns generics.GenericInheritedInterfaceMethodsAreConsistent
  (:gen-class)
  (:import [java.lang.reflect ParameterizedType TypeVariable]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector NetObject]
           [system Console Environment]))

;; A method inherited from a generic base interface must be declared the same way by the interface that
;; declares it and by the "...Implementation" class of a derived interface, otherwise Java sees a name
;; clash (same erasure, neither overrides the other) as soon as another parameter is a type variable.
;; ITargetBlock<TInput>.OfferMessage(header, TInput, ISourceBlock<TInput>, bool) is the case: its third
;; parameter must be ISourceBlock_1<TInput> both in ITargetBlock_1 and in IPropagatorBlock_2Implementation.
(defn- assert-offer-message-is-parameterized [^Class c]
  (let [found (atom false)]
    (doseq [^java.lang.reflect.Method m (.getMethods c)
            :when (= "OfferMessage" (.getName m))]
      (reset! found true)
      (let [source (aget (.getGenericParameterTypes m) 2)]
        (when-not (instance? ParameterizedType source)
          (throw (AssertionError. (str (.getSimpleName c) ".OfferMessage must take ISourceBlock_1<TInput>, got " source))))))
    (when-not @found
      (throw (AssertionError. (str (.getSimpleName c) " has no OfferMessage method"))))))

(defn- test-generic-inherited-interface-methods-are-consistent []
  (let [cl (.getClassLoader JCOReflector)
        load (fn [n] (try (Class/forName n false cl) (catch ClassNotFoundException _ nil)))
        target (load "system.threading.tasks.dataflow.ITargetBlock_1")
        implementation (load "system.threading.tasks.dataflow.IPropagatorBlock_2Implementation")]
    (if (or (nil? target) (nil? implementation))
      (Console/WriteLine "Dataflow types not available in this framework, skipping")
      (do
        (assert-offer-message-is-parameterized target)
        (assert-offer-message-is-parameterized implementation)))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-inherited-interface-methods-are-consistent)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
