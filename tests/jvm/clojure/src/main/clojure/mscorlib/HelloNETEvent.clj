(ns mscorlib.HelloNETEvent
  (:import [org.mases.jcobridge.netreflection JCOReflector]
           [system Console Environment]
           [system.threading ThreadStart]
           [system.timers Timer ElapsedEventHandler ElapsedEventArgs]))

(defn- timer-elapsed []
  (proxy [ElapsedEventHandler] []
    (Invoke [_ ^ElapsedEventArgs arg1]
      (try
        (println (format "Timer elapsed at %s" (.toString (.getSignalTime arg1))))
        (catch Throwable e
          (.printStackTrace e)
          (System/exit -1))))))

(ns mscorlib.HelloNETEvent
  (:gen-class)
  (:import [org.mases.jcobridge.netreflection JCOReflector]
           [system Console Environment]
           [system.threading ThreadStart]
           [system.timers Timer ElapsedEventHandler]))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (with-open [^Timer timer (Timer.)]
      (^ElapsedEventHandler elapsed (timer-elapsed)
	  
            ^ThreadStart starter
            (proxy [ThreadStart] []
              (Invoke []
                (try
                  (println "Running thread.")
                  (.setEnabled timer true)
                  (catch Throwable e
                    (.printStackTrace ^Throwable e)))))

            thread (system.threading.Thread. starter)]
        (.Start thread)
        (system.threading.Thread/Sleep (int 10000))
        (.Stop timer)
        (.removeElapsed timer elapsed)
        (Console/WriteLine "Exiting with success")
        (Environment/Exit 0)))
    (catch Throwable tre
      (.printStackTrace ^Throwable tre)
      (System/exit -1))))