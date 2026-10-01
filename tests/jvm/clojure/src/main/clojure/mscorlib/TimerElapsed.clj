(ns mscorlib.TimerElapsed
  (:import (system.timers ElapsedEventArgs)
           (org.mases.jcobridge.netreflection NetObject))
  (:gen-class
   :name mscorlib.TimerElapsed
   :extends system.timers.ElapsedEventHandler))

(defn -Invoke [this ^NetObject arg0 ^ElapsedEventArgs arg1]
  (try
    (println (format "Timer elapsed at %s" (.toString (.getSignalTime arg1))))
    (catch Throwable e
      (.printStackTrace e)
      (System/exit -1))))