(ns mscorlib.HelloNETEvent
  (:require mscorlib.TimerElapsed)
  (:import (mscorlib TimerElapsed)
           (org.mases.jcobridge.netreflection JCOReflector)
           (system Console Environment)
           (system.threading ThreadStart)
           (system.timers Timer))
  (:gen-class
   :name mscorlib.HelloNETEvent
   :main true))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (with-open [^Timer timer (Timer.)]
      (let [elapsed (TimerElapsed.)
            thread  (system.threading.Thread.
                     (proxy [ThreadStart] []
                       (Invoke []
                         (try
                           (println "Running thread.")
                           (.setEnabled timer true)
                           (catch Throwable e
                             (.printStackTrace e))))))]
        (.addElapsed timer elapsed)
        (.setInterval timer 1000.0)
        (.Start thread)
        (system.threading.Thread/Sleep (int 10000))
        (.Stop timer)
        (.removeElapsed timer elapsed)
        (Console/WriteLine "Exiting with success")
        (Environment/Exit (int 0))))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))