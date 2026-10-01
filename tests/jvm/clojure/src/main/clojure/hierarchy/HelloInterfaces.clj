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