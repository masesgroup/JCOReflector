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