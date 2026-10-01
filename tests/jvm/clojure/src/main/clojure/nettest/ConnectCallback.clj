(ns nettest.ConnectCallback
  (:import (org.mases.jcobridge.netreflection NetObject)
           (system Console IAsyncResult)
           (system.net.sockets Socket)
           (system.threading ManualResetEvent))
  (:gen-class
   :name nettest.ConnectCallback
   :main false
   :extends system.AsyncCallback))

(defn- client-atom [sym]
  @(requiring-resolve (symbol "nettest.HelloNETSocketClientAsync" (name sym))))

(defn -Invoke [this ^IAsyncResult ar]
  (try
    ;; Retrieve the socket from the state object.
    (let [^Socket client (Socket/cast (.getAsyncState ar))]
      ;; Complete the connection.
      (.EndConnect client ar)

      (Console/WriteLine "Socket connected to {0}"
                         (NetObject. (.ToString (.getRemoteEndPoint client))))

      ;; Signal that the connection has been made.
      (.Set ^ManualResetEvent @(client-atom 'connectDone)))
    (catch Throwable e
      (.printStackTrace e)
      (System/exit -1))))