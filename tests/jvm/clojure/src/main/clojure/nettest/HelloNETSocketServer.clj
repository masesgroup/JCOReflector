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
  (:import [org.mases.jcobridge.netreflection JCORefOut NetObject]
           [system Console]
           [system.net Dns EndPoint IPAddress IPEndPoint IPHostEntry]
           [system.net.sockets ProtocolType Socket SocketAsyncEventArgs SocketError SocketShutdown SocketType]
           [system.text Encoding]))

(defn- net-str ^NetObject [^String s] (NetObject. s))
(defn- net-int ^NetObject [n] (NetObject. (Integer/valueOf (int n))))

(defn start-listening [async-mode ^String address port]
  (try
    (let [^IPHostEntry host-info (Dns/GetHostEntry (Dns/GetHostName))]
      (println "SERVER: List of available IP Endpoints:")
      (doseq [a (.getAddressList host-info)]
        (println a)))
    (catch Throwable e
      (.printStackTrace e)))

  (let [bytes (byte-array 1024)
        run (atom true)
        data (atom "")
        x (atom 1)]
    (try
      (let [ip-address (IPAddress/Parse address)
            local-end-point (IPEndPoint. ip-address (int port))
            listener (Socket. (.getAddressFamily ip-address) SocketType/Stream ProtocolType/Tcp)]
        (.Bind listener (EndPoint/cast local-end-point))
        (.Listen listener (int 10))
        (while @run
          (Console/WriteLine "SERVER: Waiting for a connection... Step {0}" (net-int @x))
          (let [^Socket handler (.Accept listener)
                receive (atom true)]
            (println (str "SERVER: Server connected to client: " (.ToString (.getRemoteEndPoint handler))))
            (reset! data "")
            (while (and @receive @run)
              (let [^String data-new
                    (if async-mode
                      (let [asea (SocketAsyncEventArgs.)]
                        (.SetBuffer asea bytes (int 0) (alength bytes))
                        (.ReceiveAsync handler asea)
                        (loop []
                          (when (and (zero? (.getBytesTransferred asea)) @run)
                            (if-not (.equalsIgnoreCase (.ToString (.getSocketError asea))
                                                       (.ToString SocketError/Success))
                              (reset! receive false)
                              (recur))))
                        (.GetString (Encoding/getASCII) (.getBuffer asea) (int 0) (.getBytesTransferred asea)))
                      (let [rec-bytes (.Receive handler (JCORefOut/Create bytes))]
                        (.GetString (Encoding/getASCII) bytes (int 0) rec-bytes)))]
                (swap! data str data-new)
                (println (str "SERVER: Received from Client " data-new))
                (swap! x inc)
                (.Send handler (.getBytes data-new))
                (when (and (> (count @data) 4) (.contains ^String @data "exit"))
                  (Console/WriteLine "SERVER: Connection Closed by the client")
                  (reset! receive false))
                (when (and (> (count @data) 4) (.contains ^String @data "abort"))
                  (Console/WriteLine "SERVER: Server shutdown requested by the client")
                  (reset! run false))))
            (Console/WriteLine "SERVER: Text received : {0}" (net-str @data))
            (.Shutdown handler SocketShutdown/Both)
            (.Close handler (int 10)))))
      (catch Throwable e
        (.printStackTrace e)
        (System/exit -1)))
    (println "SERVER: Server exited correctly")))