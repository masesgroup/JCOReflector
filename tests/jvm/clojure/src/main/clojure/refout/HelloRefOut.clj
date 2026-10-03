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

(ns refout.HelloRefOut
  (:gen-class)
  (:import [org.mases.jcobridge.netreflection JCOReflector JCORefOut]
           [system Console Environment UInt32]))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (let [^UInt32 i (UInt32/Parse "0")]
      (dotimes [value 1000]
        (let [value-str (str value)]
          (UInt32/TryParse value-str (JCORefOut/Create i))
          (when-not (zero? (.CompareTo i (UInt32/Parse value-str)))
            (Console/WriteLine "Error in parsing")
            (Environment/Exit -1))))
      (Console/WriteLine "Exiting with success")
      (Environment/Exit 0))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))
