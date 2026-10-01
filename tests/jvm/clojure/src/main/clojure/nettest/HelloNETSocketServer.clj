;;  MIT License
;;
;;  Copyright (c) 2020-2026 MASES s.r.l.
;;
;;  Permission is hereby granted, free of charge, to any person obtaining a copy
;;  of this software and associated documentation files (the "Software"), to deal
;;  in the Software without restriction, including without limitation the rights
;;  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;;  copies of the Software, and to permit persons to whom the Software is
;;  furnished to do so, subject to the following conditions:
;;
;;  The above copyright notice and this permission notice shall be included in all
;;  copies or substantial portions of the Software.
;;
;;  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;;  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;;  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;;  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;;  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;;  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;;  SOFTWARE.

(ns nettest.HelloNETSocketServer
  (:import (org.mases.jcobridge.netreflection JCORefOut NetObject)
           (system Console)
           (system.net Dns EndPoint IPAddress IPEndPoint)
           (system.net.sockets ProtocolType Socket SocketAsyncEventArgs
                               SocketError SocketShutdown SocketType)
           (system.text Encoding))
  (:gen-class
   :name nettest.HelloNETSocketServer
   :main false
   :methods [^:static [StartListening [boolean String int] void]]))

;; Based on examples from:
;; https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-a-synchronous-server-socket
;; https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-server-socket

(def run (atom true))
;; Incoming data from the client.
(def data (atom nil))

(defn -StartListening [asyncMode ^String address port]
  (try
    (let [ipHostInfo (Dns/GetHostEntry (Dns/GetHostName))]
      ;; print available endpoints
      (println "SERVER: List of available IP Endpoints:")
      (doseq [^IPAddress ipAddressAvailable (.getAddressList ipHostInfo)]
        (.println System/out ipAddressAvailable)))
    (catch Throwable e
      (.printStackTrace e)))

  ;; Data buffer for incoming data.
  (let [bytes (byte-array 1024)]
    ;; Establish the local endpoint for the socket.
    ;; Dns.GetHostName returns the name of the host running the application.
    (try
      ;; parse ip address
      (let [ipAddress     (IPAddress/Parse address)
            localEndPoint (IPEndPoint. ipAddress (int port))
            ;; Create a TCP/IP socket.
            listener      (Socket. (.getAddressFamily ipAddress) SocketType/Stream ProtocolType/Tcp)
            ;; connection counter
            x             (volatile! 1)]
        ;; Bind the socket to the local endpoint and
        ;; listen for incoming connections.
        (.Bind listener (EndPoint/cast localEndPoint))
        (.Listen listener (int 10))
        ;; Start listening for connections.
        (while @run
          (Console/WriteLine "SERVER: Waiting for a connection... Step {0}"
                             (NetObject. (Integer/valueOf (int @x))))
          ;; Program is suspended while waiting for an incoming connection.
          (let [handler (.Accept listener)]
            (println (str "SERVER: Server connected to client: " (.ToString (.getRemoteEndPoint handler))))
            (reset! data "")

            ;; An incoming connection needs to be processed.
            (let [receive (volatile! true)]
              (while (and @receive @run)
                (let [^String dataNew
                      (if asyncMode
                        (let [asea (SocketAsyncEventArgs.)]
                          (.SetBuffer asea bytes 0 (alength bytes))
                          (.ReceiveAsync handler asea)
                          (loop []
                            (when (and (zero? (.getBytesTransferred asea)) @run)
                              (if-not (.equalsIgnoreCase (.ToString (.getSocketError asea))
                                                         (.ToString SocketError/Success))
                                (vreset! receive false)
                                (recur))))
                          (.GetString (Encoding/getASCII) (.getBuffer asea) 0 (.getBytesTransferred asea)))
                        (let [recBytes (.Receive handler (JCORefOut/Create bytes))]
                          (.GetString (Encoding/getASCII) bytes 0 recBytes)))]

                  (swap! data str dataNew)
                  (println (str "SERVER: Received from Client " dataNew))
                  (vswap! x inc)
                  ;; echo received data
                  (.Send handler (.getBytes dataNew))

                  (let [^String d @data]
                    (when (and (> (.length d) 4) (> (.indexOf d "exit") -1))
                      (Console/WriteLine "SERVER: Connection Closed by the client")
                      (vreset! receive false))
                    (when (and (> (.length d) 4) (> (.indexOf d "abort") -1))
                      (Console/WriteLine "SERVER: Server shutdown requested by the client")
                      (reset! run false))))))
            ;; Show the data on the console.
            (when-let [d @data]
              (Console/WriteLine "SERVER: Text received : {0}" (NetObject. d)))
            (.Shutdown handler SocketShutdown/Both)
            (.Close handler (int 10)))))
      (catch Throwable e
        (.printStackTrace e)
        (System/exit -1))))
  (println "SERVER: Server exited correctly"))