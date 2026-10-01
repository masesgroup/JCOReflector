(ns nettest.SendCallback
  (:import (org.mases.jcobridge.netreflection NetObject)
           (system Console IAsyncResult)
           (system.net.sockets Socket)
           (system.threading ManualResetEvent))
  (:gen-class
   :name nettest.SendCallback
   :main false
   :extends system.AsyncCallback))

(defn- client-atom [sym]
  @(requiring-resolve (symbol "nettest.HelloNETSocketClientAsync" (name sym))))

(defn -Invoke [this ^IAsyncResult ar]
  (try
    ;; Retrieve the socket from the state object.
    (let [^Socket client (Socket/cast (.getAsyncState ar))
          ;; Complete sending the data to the remote device.
          bytesSent (.EndSend client ar)]
      (Console/WriteLine "Sent {0} bytes to server."
                         (NetObject. (Integer/valueOf (int bytesSent))))

      ;; Signal that all bytes have been sent.
      (.Set ^ManualResetEvent @(client-atom 'sendDone)))
    (catch Throwable e
      (.printStackTrace e)
      (System/exit -1))))