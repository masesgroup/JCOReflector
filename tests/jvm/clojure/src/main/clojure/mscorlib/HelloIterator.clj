(ns mscorlib.HelloIterator
  (:import (org.mases.jcobridge.netreflection JCOReflector)
           (system Console Environment))
  (:gen-class
   :name mscorlib.HelloIterator
   :main true))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    ;; Get an iterable array and populate a sorted array
    (let [ld (Environment/GetLogicalDrives)]
      (doseq [^String drive ld]
        (Console/WriteLine drive)
        ;; (println drive) viable alternative
        ))
    (Console/WriteLine "Exiting with success")
    (Environment/Exit (int 0))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))