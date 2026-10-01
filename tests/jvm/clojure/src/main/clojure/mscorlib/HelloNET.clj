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

(ns mscorlib.HelloNET
  (:gen-class)
  (:import [org.mases.jcobridge.netreflection JCOReflector NetObject]
           [system Console Environment]
           [system.io File FileNotFoundException]
           [system.text Encoding]))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (let [filename "test.txt"]
      (when-not (File/Exists filename)
        (File/WriteAllText filename "First Java string"))
      (let [content (File/ReadAllText filename)
            _       (Console/WriteLine content)
            result  (str content " Java Execution")
            _       (File/WriteAllText filename result)
            byte-count (.GetByteCount (Encoding/getASCII) ^String result)
            res-byte   (File/ReadAllBytes filename)]
        (when (= byte-count (alength res-byte))
          (Console/WriteLine "{0} and result have equals array lengths. The length is {1}"
                             (NetObject. filename)
                             (NetObject. (Integer/valueOf (int byte-count)))))
        (Console/WriteLine "Writing array on file.")
        (File/WriteAllBytes "test2.txt" res-byte)
        (Console/WriteLine result)
        (Console/WriteLine "Exiting with success")
        (Environment/Exit 0)))
    (catch FileNotFoundException fnfe
      (.printStackTrace fnfe)
      (System/exit -1))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))