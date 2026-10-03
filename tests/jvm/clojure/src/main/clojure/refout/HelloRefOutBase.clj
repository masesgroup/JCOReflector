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

(ns refout.HelloRefOutBase
  (:gen-class)
  (:import [java.util.concurrent.atomic AtomicBoolean AtomicInteger AtomicLong AtomicReference]
           [org.mases.jcobridge.netreflection JCOReflector JCORefOut]))

;; system.Boolean, system.Byte, system.Double ... are always written with the
;; fully qualified name: importing them would clash with the java.lang classes.

(defn- check
  "Prints the outcome of one TryParse/Parse comparison and returns true when it matches."
  [type-name actual expected]
  (if (= actual expected)
    (do (println (str "Test " type-name " is OK"))
        true)
    (do (println (str "Test " type-name " not OK: " actual))
        false)))

(defn- test-boolean []
  (let [test-val (str true)
        val-boolean (AtomicBoolean. false)]
    (system.Boolean/TryParse test-val (JCORefOut/Create val-boolean))
    (check "Boolean" (.get val-boolean) (system.Boolean/Parse test-val))))

(defn- test-byte []
  (let [test-val (str (byte 10))
        val-ref (AtomicReference. (byte 4))]
    (system.Byte/TryParse test-val (JCORefOut/Create val-ref))
    (check "Byte" (.get val-ref) (system.Byte/Parse test-val))))

(defn- test-double []
  (let [test-val (str 10.1)
        val-ref (AtomicReference. 4.3)]
    (system.Double/TryParse test-val (JCORefOut/Create val-ref))
    (check "Double" (.get val-ref) (system.Double/Parse test-val))))

(defn- test-int16 []
  (let [test-val (str (short 10))
        val-ref (AtomicReference. (short 4))]
    (system.Int16/TryParse test-val (JCORefOut/Create val-ref))
    (check "Int16" (.get val-ref) (system.Int16/Parse test-val))))

(defn- test-int32 []
  (let [test-val (str 10)
        val-int (AtomicInteger. 4)]
    (system.Int32/TryParse test-val (JCORefOut/Create val-int))
    (check "Int32" (.get val-int) (system.Int32/Parse test-val))))

(defn- test-int64 []
  (let [test-val (str 10)
        val-long (AtomicLong. 4)]
    (system.Int64/TryParse test-val (JCORefOut/Create val-long))
    (check "Int64" (.get val-long) (system.Int64/Parse test-val))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    ;; the vector forces every test to run, so all the messages are printed
    (let [results [(test-boolean) (test-byte) (test-double)
                   (test-int16) (test-int32) (test-int64)]]
      (System/exit (if (every? true? results) 0 -1)))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
