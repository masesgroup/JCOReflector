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

(ns generics.GenericComparisonDelegateSortsAList
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [java.util.concurrent.atomic AtomicInteger]
           [org.mases.jcobridge.netreflection IJCOBridgeReflected JCORefOut JCOReflector]
           [system Comparison_1 Console Environment UInt32]
           [system.collections.generic Dictionary_2 List_1]))

;; Sort is selected by reflection on purpose: javac resolves Sort(Comparison_1<T>) from the
;; static type, but Clojure compiled the call against Sort(IComparer_1) (ClassCastException).
(defn- sort-list [^List_1 lst ^Comparison_1 comparison]
  (let [sort-method (.getMethod List_1 "Sort" (into-array Class [Comparison_1]))]
    (try
      (.invoke sort-method lst (object-array [comparison]))
      (catch java.lang.reflect.InvocationTargetException e
        (throw (.getCause e))))))

;; Exercises a generic delegate with a primitive return type (Comparison<T> returns int).
;; The delegate is a generated subclass whose Invoke is forwarded to the Clojure fn.
;; The arguments are hinted as IJCOBridgeReflected on purpose: javac picks Add(T) from the
;; generic parameter, while Clojure only sees the erased overloads and would otherwise choose
;; the more specific explicit-interface Add(...) that throws UnsupportedOperationException.
(defn- test-generic-comparison-delegate-sorts-a-list []
  (let [^List_1 lst (gs/new-generic List_1 [system.Object])
        calls (AtomicInteger.)
        a (system.Object.)
        b (system.Object.)]
    (.Add lst ^IJCOBridgeReflected a)
    (.Add lst ^IJCOBridgeReflected b)
    (let [^Comparison_1 comparison (gs/new-generic Comparison_1 [system.Object]
                                                   {"Invoke" (fn [_ _]
                                                               (.incrementAndGet calls)
                                                               0)})]
      (sort-list lst comparison)
      (when (zero? (.get calls))
        (throw (AssertionError. "Java comparison never invoked"))))))

;; Adds the pair to the dictionary and returns false when the key is already present.
;; Dictionary.TryAdd does not exist on .NET Framework (net462), so the duplicate is detected
;; through the ArgumentException thrown by Add.
(defn- add-if-absent [^Dictionary_2 dict k v]
  (try
    (.Add dict ^IJCOBridgeReflected k ^IJCOBridgeReflected v)
    true
    (catch system.ArgumentException _
      false)))

;; Native types in the members of a generic class: boolean and int return values of generic
;; methods, and an int property. The native int parameter of a generic constructor is not
;; covered here: gs/new-generic only calls the no-argument constructor.
(defn- test-native-types-in-generic-members []
  (let [^Dictionary_2 dict (gs/new-generic Dictionary_2 [system.Object system.Object])
        the-key (system.Object.)
        the-value (system.Object.)]
    ;; native boolean return values of generic methods
    (when-not (add-if-absent dict the-key the-value)
      (throw (AssertionError. "Add of a new key must succeed")))
    (when (add-if-absent dict the-key the-value)
      (throw (AssertionError. "Add of an existing key must throw ArgumentException")))
    (when-not (.ContainsKey dict ^IJCOBridgeReflected the-key)
      (throw (AssertionError. "ContainsKey must find the added key")))
    (when-not (.ContainsValue dict ^IJCOBridgeReflected the-value)
      (throw (AssertionError. "ContainsValue must find the added value")))

    ;; native int return value of a generic property
    (when-not (= 1 (.getCount dict))
      (throw (AssertionError. "Count must be 1 after one Add")))

    (when-not (.Remove dict ^IJCOBridgeReflected the-key)
      (throw (AssertionError. "Remove of an existing key must return true")))
    (when-not (zero? (.getCount dict))
      (throw (AssertionError. "Count must be 0 after Remove")))))

;; UInt32 is the reflected wrapper of a native value type. Being a reflected class it is a
;; valid type argument, and the CLR compares the values, not the wrappers.
(defn- test-native-wrapper-types-as-type-arguments []
  (let [^Dictionary_2 dict (gs/new-generic Dictionary_2 [system.UInt32 system.UInt32])]
    (when-not (add-if-absent dict (UInt32/Parse "1") (UInt32/Parse "10"))
      (throw (AssertionError. "Add of a new key must succeed")))

    ;; a different wrapper holding the same number is the same key
    (when-not (.ContainsKey dict ^IJCOBridgeReflected (UInt32/Parse "1"))
      (throw (AssertionError. "ContainsKey must compare keys by value")))
    (when (.ContainsKey dict ^IJCOBridgeReflected (UInt32/Parse "2"))
      (throw (AssertionError. "ContainsKey must not find a missing key")))
    (when (add-if-absent dict (UInt32/Parse "1") (UInt32/Parse "11"))
      (throw (AssertionError. "Add of an equal key must throw ArgumentException")))

    ;; out parameter of a type-argument type: the result comes back through the instance supplied
    (let [found (UInt32/Parse "0")]
      (when-not (.TryGetValue dict ^IJCOBridgeReflected (UInt32/Parse "1") (JCORefOut/Create found))
        (throw (AssertionError. "TryGetValue must find the key")))
      (when-not (zero? (.CompareTo found (UInt32/Parse "10")))
        (throw (AssertionError. "TryGetValue must return the stored value in the out parameter"))))

    ;; generic delegate whose arguments are value-type wrappers
    (let [^List_1 lst (gs/new-generic List_1 [system.UInt32])
          calls (AtomicInteger.)]
      (.Add lst ^IJCOBridgeReflected (UInt32/Parse "3"))
      (.Add lst ^IJCOBridgeReflected (UInt32/Parse "1"))
      (.Add lst ^IJCOBridgeReflected (UInt32/Parse "2"))
      (let [^Comparison_1 comparison (gs/new-generic Comparison_1 [system.UInt32]
                                                     {"Invoke" (fn [x y]
                                                                 (.incrementAndGet calls)
                                                                 (.CompareTo ^UInt32 x ^UInt32 y))})]
        (sort-list lst comparison)
        (when (zero? (.get calls))
          (throw (AssertionError. "Java comparison never invoked")))
        (when-not (zero? (.IndexOf lst ^IJCOBridgeReflected (UInt32/Parse "1")))
          (throw (AssertionError. "1 must be the first element after Sort")))
        (when-not (= 2 (.IndexOf lst ^IJCOBridgeReflected (UInt32/Parse "3")))
          (throw (AssertionError. "3 must be the last element after Sort")))))))

;; Plain Java types (String, int, boolean...) are not reflected classes, so they cannot fill a
;; type parameter: every type parameter is bounded by IJCOBridgeReflected, which none of them
;; implements. Using one is a compile-time error, so the check is made on the bound itself.
(defn- test-native-java-types-cannot-be-type-arguments []
  (let [bounds (.getBounds ^java.lang.reflect.TypeVariable (first (.getTypeParameters List_1)))]
    (when (or (not= 1 (count bounds))
              (not (identical? IJCOBridgeReflected (first bounds))))
      (throw (AssertionError. "The type parameter of List_1 must be bounded by IJCOBridgeReflected")))
    (when (some #(.isAssignableFrom IJCOBridgeReflected %) [String Integer Boolean])
      (throw (AssertionError. "Plain Java types must not satisfy the IJCOBridgeReflected bound")))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-comparison-delegate-sorts-a-list)
    (test-native-types-in-generic-members)
    (test-native-wrapper-types-as-type-arguments)
    (test-native-java-types-cannot-be-type-arguments)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
