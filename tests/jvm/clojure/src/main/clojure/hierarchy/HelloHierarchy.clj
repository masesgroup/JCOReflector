(ns hierarchy.HelloHierarchy
  (:import (org.mases.jcobridge.netreflection JCORefOut JCOReflector)
           (system Console Environment)
           (system.io File FileMode FileNotFoundException FileStream SeekOrigin Stream)
           (system.text Encoding))
  (:gen-class
   :name hierarchy.HelloHierarchy
   :main true))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (let [fileinputname  "input.txt"
          fileoutputname "output.txt"
          fileText       "| Java input string |"]
      (when-not (File/Exists fileinputname)
        (File/WriteAllText fileinputname fileText))

      ;; emulate the using directive (.net) with a try...finally:
      ;; with-open closes both streams, and the body returns the result
      ;; and the base stream, which are checked after the dispose.
      ;; The base stream is named "stream" to avoid shadowing clojure.core/str.
      (let [[result ^Stream stream]
            (with-open [^FileStream sourceStream      (File/Open fileinputname FileMode/Open)
                        ^FileStream destinationStream (File/Create fileoutputname)]
              ;; Cast the destination stream to stream base class
              (let [^Stream stream (cast Stream destinationStream)]
                ;; Copy the Source content to the destination stream using the casted object
                (.CopyTo sourceStream stream)
                ;; Cast the base stream to the FileStream and assign to a FileStream
                (let [^FileStream destinationStreamInstance (cast FileStream stream)
                      ;; Write using the casted stream
                      toWrite (.GetBytes (Encoding/getASCII) fileText)]
                  (.Write destinationStreamInstance toWrite (int 0) (int (alength toWrite))))

                ;; Verify that the stream used where correct reading from the original destination stream
                (let [bytes (byte-array 1024)
                      ;; use the JCORefOut special class to retrieve data passed as parameter
                      data  (JCORefOut/Create bytes)]
                  (.Seek destinationStream 0 SeekOrigin/Begin)
                  (.Read destinationStream data (int 0) (int 1024))
                  (let [expectedText (str fileText fileText)]
                    ;; do the check
                    (if (.equalsIgnoreCase (.trim (.GetString (Encoding/getASCII) data))
                                           (.trim expectedText))
                      ["Hierarchy OK" stream]
                      (do
                        (Console/WriteLine "File Content:")
                        (Console/WriteLine (.GetString (Encoding/getASCII) data))
                        (Console/WriteLine "Expected Text:")
                        (Console/WriteLine expectedText)
                        ["Something goes wrong!" stream]))))))

            ;; check if the dispose affected the casted class
            result (cond-> result
                     (.getCanRead stream)  (str " Hierarchy dispose NOT OK")
                     (.getCanWrite stream) (str " Hierarchy dispose NOT OK"))]
        (Console/WriteLine ^String result))
      (Console/WriteLine "Exiting with success")
      (Environment/Exit (int 0)))
    (catch FileNotFoundException fnfe
      (.printStackTrace fnfe))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))