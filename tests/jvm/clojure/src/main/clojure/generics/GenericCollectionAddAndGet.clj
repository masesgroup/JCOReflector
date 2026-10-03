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

(ns generics.GenericCollectionAddAndGet
  (:gen-class)
  (:require [generics.GenericSupport :as gs])
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected JCOReflector]
           [system Console Environment Guid]
           [system.collections.generic List_1]))

;; Exercises the basic class-level generic parameter path: Add/get on a generic
;; collection whose element type is itself a reflected class.
;; The arguments are hinted as IJCOBridgeReflected on purpose: javac picks Add(T) from the
;; generic parameter, while Clojure only sees the erased overloads and would otherwise choose
;; the more specific explicit-interface Add(...) that throws UnsupportedOperationException.
(defn- test-generic-collection-add-and-get []
  (let [^List_1 lst (gs/new-generic List_1 [Guid])
        item (Guid. "{4E601116-3051-49CA-BA2B-5C47DF33B4C2}")]
    (.Add lst ^IJCOBridgeReflected item)
    (when-not (= 1 (.getCount lst))
      (throw (AssertionError. "Expected 1 element after Add")))
    (let [array (.ToArray lst)
          ^Guid fetched (aget ^objects array 0)]
      (when (nil? fetched)
        (throw (AssertionError. "Expected a non-null element back")))
      (when-not (.Equals fetched item)
        (throw (AssertionError. "Fetched element differs from the added on"))))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (test-generic-collection-add-and-get)
    (Console/WriteLine "Exiting with success")
    (Environment/Exit 0)
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
