(ns nettest.HelloNETSocket
  (:require [nettest.HelloNETSocketClient :as client]
            nettest.HelloNETSocketServer)
  (:import (nettest HelloNETSocketClient HelloNETSocketServer)
           (org.mases.jcobridge.netreflection JCOReflector)
           (system Console Environment)
           (system.threading ThreadStart))
  (:gen-class
   :name nettest.HelloNETSocket
   :main true))

;; system.threading.Thread keeps its fully qualified name to avoid the clash
;; with java.lang.Thread, which is imported by default in every Clojure namespace.

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (let [args (vec args)
          [asyncMode ^String serverAddress]
          (loop [x 0 asyncMode false serverAddress "0.0.0.0"]
            (if (< x (count args))
              (let [arg (nth args x)]
                (cond
                  (= arg "-async")  (recur (inc x) true serverAddress)
                  (= arg "-server") (recur (+ x 2) asyncMode (nth args (inc x)))
                  :else             (recur (inc x) asyncMode serverAddress)))
              [asyncMode serverAddress]))

          ;; create the server thread
          threadServer (system.threading.Thread.
                        (proxy [ThreadStart] []
                          (Invoke []
                            (HelloNETSocketServer/StartListening (boolean asyncMode) serverAddress (int 11000)))))
          ;; create the client thread
          threadClient (system.threading.Thread.
                        (proxy [ThreadStart] []
                          (Invoke []
                            (HelloNETSocketClient/StartClient (boolean asyncMode) "localhost" (int 11000)))))]
      ;; start threads
      (.Start threadServer)
      (system.threading.Thread/Sleep (int 5000))
      (.Start threadClient)
      ;; let it communicate
      (system.threading.Thread/Sleep (int 5000))
      ;; trigger the thread closing procedure
      (reset! client/run false)
      (system.threading.Thread/Sleep (int 1000))
      ;; wait for thread join, if not, close the test
      (.Join threadServer (int 5000))
      (.Join threadClient (int 5000))
      ;; close the application
      (Console/WriteLine "Exiting with success")
      (Environment/Exit (int 0)))
    (catch Throwable e
      (.printStackTrace e)
      (System/exit -1))))