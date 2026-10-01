(ns nettest.StateObject
  (:gen-class
   :name nettest.StateObject
   :main false
   :state state
   :init init
   :constructors {[] []}
   :methods [[getWorkSocket [] system.net.sockets.Socket]
             [setWorkSocket [system.net.sockets.Socket] void]
             [getBufferSize [] int]
             [getBuffer [] "[B"]
             [getSb [] java.lang.StringBuilder]]))

;; State object for receiving data from remote device.
(defn -init []
  (let [buffer-size 256]
    [[] {;; Client socket.
         :workSocket (atom nil)
         ;; Size of receive buffer.
         :bufferSize buffer-size
         ;; Receive buffer.
         :buffer     (byte-array buffer-size)
         ;; Received data string.
         :sb         (StringBuilder.)}]))

(defn -getWorkSocket [this] @(:workSocket (.state this)))
(defn -setWorkSocket [this socket] (reset! (:workSocket (.state this)) socket))
(defn -getBufferSize [this] (:bufferSize (.state this)))
(defn -getBuffer [this] (:buffer (.state this)))
(defn -getSb [this] (:sb (.state this)))