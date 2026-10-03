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

(ns generics.RemoveByKeyRenameOnKeyedCollection
  (:gen-class)
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector]
           [system Console Environment]))

;; Exercises the RemoveByKey()/ContainsByKey() rename on KeyedCollection<TKey,TItem>-derived
;; types, which would otherwise erase to the same signature as the inherited
;; Collection<TItem>.Remove(TItem)/Contains(TItem).
(defn- test-remove-by-key-rename-on-keyed-collection []
  (let [cl (.getClassLoader JCOReflector)
        keyed (Class/forName "system.collections.objectmodel.KeyedCollection_2" false cl)
        collection (Class/forName "system.collections.objectmodel.Collection_1" false cl)
        one-arg (into-array Class [IJCOBridgeReflected])]
    (.getMethod keyed "RemoveByKey" one-arg)
    (.getMethod keyed "ContainsByKey" one-arg)

    ;; Remove/Contains must now resolve to the base class, i.e. not be hidden by the keyed overloads.
    (when-not (identical? (.getDeclaringClass (.getMethod keyed "Remove" one-arg)) collection)
      (throw (AssertionError. "KeyedCollection_2 still redeclares Remove(T)")))
    (when-not (identical? (.getDeclaringClass (.getMethod keyed "Contains" one-arg)) collection)
      (throw (AssertionError. "KeyedCollection_2 still redeclares Contains(T)")))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-remove-by-key-rename-on-keyed-collection)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
