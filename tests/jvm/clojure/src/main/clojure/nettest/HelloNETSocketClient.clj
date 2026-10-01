(ns nettest.HelloNETSocketClient
  (:import (java.util Arrays)
           (org.mases.jcobridge.netreflection JCORefOut NetObject)
           (system ArgumentNullException Console)
           (system.net Dns IPAddress IPEndPoint)
           (system.net.sockets AddressFamily ProtocolType Socket
                               SocketAsyncEventArgs SocketException SocketType)
           (system.text Encoding))
  (:gen-class
   :name nettest.HelloNETSocketClient
   :main false
   :methods [^:static [StartClient [boolean String int] void]]))

;; Based on examples from:
;; https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-a-synchronous-client-socket
;; https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket

(def run (atom true))
;; Incoming data from the client.
(def data (atom nil))

(defn- report [^Throwable e]
  (Console/WriteLine (.getMessage e)))

(defn -StartClient [asyncMode ^String address port]
  ;; Data buffer for incoming data.
  (let [bytes (byte-array 1024)]
    ;; Connect to a remote device.
    (try
      ;; Establish the remote endpoint for the socket.
      ;; resolve the given ip address
      (let [ipHostInfo           (Dns/GetHostEntry address)
            ^IPAddress ipAddress (loop [addrs (seq (.getAddressList ipHostInfo))]
                                   (when-let [^IPAddress available (first addrs)]
                                     (.println System/out available)
                                     (if (= (.ToString (.getAddressFamily available))
                                            (.ToString AddressFamily/InterNetwork))
                                       available
                                       (recur (next addrs)))))]
        (if (nil? ipAddress)
          (Console/WriteLine (str "CLIENT: No Ip resolved for the address: " address))
          (let [remoteEP (IPEndPoint. ipAddress (int port))
                ;; connection counter
                x        (volatile! 1)
                exit     (volatile! false)]
            (while (not @exit)
              (try
                ;; Create a TCP/IP socket.
                (let [sender (Socket. (.getAddressFamily ipAddress) SocketType/Stream ProtocolType/Tcp)]
                  ;; Connect the socket to the remote endpoint. Catch any errors.
                  (.Connect sender (.getAddress remoteEP) (.getPort remoteEP)) ;; ipAddress, 80);
                  (Console/WriteLine (str "CLIENT: Client connection #" @x))
                  (Console/WriteLine (str "CLIENT: Client socket connected to " (.toString ipAddress)))
                  ;; Encode the data string into a byte array.
                  (let [^bytes msg (if @run
                                     (.getBytes "Communication OK please exit")
                                     (do
                                       ;; Do another run to Ask the server to close
                                       (reset! run true)
                                       (vreset! exit true)
                                       (.getBytes "Communication OK please abort")))]
                    (Console/WriteLine (str "CLIENT: Sent msg = " (Arrays/toString msg)))
                    ;; Send the data through the socket.
                    (.Send sender msg))
                  ;; Receive the response from the remote device.
                  (while (and (zero? (.getAvailable sender))
                              (not (and @run @exit)))
                    (Thread/sleep 1))
                  (Console/WriteLine (str "CLIENT: Client bytes received " (.getAvailable sender)))
                  (if asyncMode
                    (let [;; define the async event object
                          asea (SocketAsyncEventArgs.)]
                      (.SetBuffer asea bytes 0 (alength bytes))
                      (.ReceiveAsync sender asea)
                      ;; decode and display the received data
                      (let [^String message (.GetString (Encoding/getASCII) (.getBuffer asea) 0
                                                        (.getBytesTransferred asea))]
                        (when message
                          (Console/WriteLine "CLIENT: Client data received {0}" (NetObject. message)))))
                    (let [recBytes (.Receive sender (JCORefOut/Create bytes))
                          ^String message (.GetString (Encoding/getASCII) bytes 0 recBytes)]
                      (when message
                        (Console/WriteLine "CLIENT: Client data received {0}" (NetObject. message)))))
                  (vswap! x inc)
                  ;; force a closure after 50 connections if no external closure happened before
                  (when (zero? (mod @x 50))
                    (reset! run false)))
                (catch ArgumentNullException e (report e))
                (catch SocketException e (report e))))
            (println "CLIENT: Client exited correctly"))))
      (catch Throwable e
        (.printStackTrace e)
        (System/exit -1)))))