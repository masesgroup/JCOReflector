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

(ns hierarchy.HelloInterfaces
  (:import (org.mases.jcobridge.netreflection JCOReflector NetObject)
           (system Console Environment)
           (system.collections IDictionary IList SortedList))
  (:gen-class
   :name hierarchy.HelloInterfaces
   :main true))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    ;; Create and populate a sorted array
    (let [sr (SortedList.)]
      (.Add sr (NetObject. "Hello") (NetObject. "test"))
      (.Add sr (NetObject. "Hello2") (NetObject. "test2"))
      (.Add sr (NetObject. "Hello3") (NetObject. "test3"))
      ;; Get the IList interface
      (let [^IList keyList   (.GetKeyList sr)
            ^IList valueList (.GetValueList sr)]
        ;; operate on interface
        (doseq [^NetObject netObject keyList]
          (Console/WriteLine (.ToString netObject)))
        (doseq [^NetObject netObject valueList]
          (Console/WriteLine (.ToString netObject)))))
    (let [^IDictionary ev (Environment/GetEnvironmentVariables)]
      (doseq [^NetObject netObject (.getKeys ev)]
        (Console/WriteLine (.ToString netObject))
        ;; (println (.ToString netObject)) viable alternative
        ))
    (Console/WriteLine "Exiting with success")
    (Environment/Exit (int 0))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))