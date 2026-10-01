(ns mscorlib.HelloLock
  (:import (java.util.concurrent.atomic AtomicBoolean)
           (org.mases.jcobridge.netreflection JCORefOut JCOReflector)
           (system.threading Monitor))
  (:gen-class
   :name mscorlib.HelloLock
   :main true))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (let [object     (system.Object.)
          lockTaken  (AtomicBoolean. false)]
      (try
        (Monitor/Enter object (JCORefOut/Create lockTaken))
        (if (.get lockTaken)
          (println "Lock taken")
          (do
            (println "Failed to acquire lock")
            (System/exit -1)))
        (finally
          (Monitor/Exit object)))
      (println "Exiting with success")
      (System/exit 0))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))