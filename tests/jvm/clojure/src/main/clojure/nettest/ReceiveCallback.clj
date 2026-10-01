(ns nettest.ReceiveCallback
  (:require nettest.StateObject)
  (:import (nettest StateObject)
           (system AsyncCallback IAsyncResult)
           (system.net.sockets Socket SocketFlags)
           (system.text Encoding)
           (system.threading ManualResetEvent))
  (:gen-class
   :name nettest.ReceiveCallback
   :main false
   :extends system.AsyncCallback))

(defn- client-atom [sym]
  @(requiring-resolve (symbol "nettest.HelloNETSocketClientAsync" (name sym))))

(defn -Invoke [this ^IAsyncResult ar]
  (try
    ;; Retrieve the state object and the client socket
    ;; from the asynchronous state object.
    (let [^StateObject state @(client-atom 'State)
          ^Socket client     (.getWorkSocket state)
          ;; Read data from the remote device.
          bytesRead          (.EndReceive client ar)]
      (if (> bytesRead 0)
        (let [^AsyncCallback callback (.newInstance ^Class (class this))]
          ;; There might be more data, so store the data received so far.
          (.append (.getSb state)
                   (.GetString (Encoding/getASCII) (.getBuffer state) 0 bytesRead))

          ;; Get the rest of the data.
          (.BeginReceive client (.getBuffer state) 0 (.getBufferSize state)
                         SocketFlags/None callback nil))
        (do
          ;; All the data has arrived; put it in response.
          (when (> (.length (.getSb state)) 1)
            (reset! (client-atom 'response) (.toString (.getSb state))))
          ;; Signal that all bytes have been received.
          (.Set ^ManualResetEvent @(client-atom 'receiveDone)))))
    (catch Throwable e
      (.printStackTrace e)
      (System/exit -1))))