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

(ns nettest.HelloNETSocketClient
  (:import [java.util Arrays]
           [org.mases.jcobridge.netreflection JCORefOut NetObject]
           [system ArgumentNullException Console]
           [system.net Dns IPAddress IPEndPoint IPHostEntry]
           [system.net.sockets AddressFamily ProtocolType Socket SocketAsyncEventArgs SocketException SocketType]
           [system.text Encoding]))

;; set to false by HelloNETSocket to ask the client to send the "abort" message
(def run? (atom true))

(defn- net-str ^NetObject [^String s] (NetObject. s))

(defn start-client [async-mode ^String address port]
  (let [bytes (byte-array 1024)]
    (try
      (let [^IPHostEntry host-info (Dns/GetHostEntry address)
            ip-address (some (fn [^IPAddress a]
                               (println a)
                               (when (= (.ToString (.getAddressFamily a))
                                        (.ToString AddressFamily/InterNetwork))
                                 a))
                             (.getAddressList host-info))]
        (if (nil? ip-address)
          (Console/WriteLine (str "CLIENT: No Ip resolved for the address: " address))
          (let [^IPAddress ip-address ip-address
                remote-ep (IPEndPoint. ip-address (int port))
                x (atom 1)
                exit (atom false)]
            (while (not @exit)
              (try
                (let [^Socket sender (Socket. (.getAddressFamily ip-address) SocketType/Stream ProtocolType/Tcp)]
                  (.Connect sender (.getAddress remote-ep) (.getPort remote-ep))
                  (Console/WriteLine (str "CLIENT: Client connection #" @x))
                  (Console/WriteLine (str "CLIENT: Client socket connected to " (.toString ip-address)))
                  (let [abort? (not @run?)
                        msg (.getBytes ^String (if abort?
                                                 "Communication OK please abort"
                                                 "Communication OK please exit"))]
                    (when abort?
                      (reset! run? true)
                      (reset! exit true))
                    (Console/WriteLine (str "CLIENT: Sent msg = " (Arrays/toString msg)))
                    (.Send sender msg)
                    (loop []
                      (when (and (zero? (.getAvailable sender))
                                 (not (and @run? @exit)))
                        (Thread/sleep 1)
                        (recur)))
                    (Console/WriteLine (str "CLIENT: Client bytes received " (.getAvailable sender)))
                    (let [^String message
                          (if async-mode
                            (let [asea (SocketAsyncEventArgs.)]
                              (.SetBuffer asea bytes (int 0) (alength bytes))
                              (.ReceiveAsync sender asea)
                              (.GetString (Encoding/getASCII) (.getBuffer asea) (int 0) (.getBytesTransferred asea)))
                            (let [rec-bytes (.Receive sender (JCORefOut/Create bytes))]
                              (.GetString (Encoding/getASCII) bytes (int 0) rec-bytes)))]
                      (when message
                        (Console/WriteLine "CLIENT: Client data received {0}" (net-str message))))
                    (swap! x inc)
                    (when (zero? (mod @x 50))
                      (reset! run? false))))
                (catch ArgumentNullException e
                  (Console/WriteLine (.getMessage e)))
                (catch SocketException e
                  (Console/WriteLine (.getMessage e)))))
            (println "CLIENT: Client exited correctly"))))
      (catch Throwable e
        (.printStackTrace e)
        (System/exit -1)))))