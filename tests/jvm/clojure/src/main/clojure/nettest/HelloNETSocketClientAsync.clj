(ns nettest.HelloNETSocketClientAsync
  (:require nettest.ConnectCallback nettest.SendCallback
            nettest.ReceiveCallback nettest.StateObject)
  (:import (nettest ConnectCallback ReceiveCallback SendCallback StateObject)
           (org.mases.jcobridge.netreflection JCOReflector NetObject)
           (system Console)
           (system.net Dns EndPoint IPAddress IPEndPoint)
           (system.net.sockets ProtocolType Socket SocketFlags SocketShutdown SocketType)
           (system.text Encoding)
           (system.threading ManualResetEvent))
  (:gen-class
   :name nettest.HelloNETSocketClientAsync
   :main true))

;; Based on examples from:
;; https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket

;; The port number for the remote device.
(def ^:private port 80)

;; ManualResetEvent instances signal completion.
(def connectDone (atom nil))
(def sendDone (atom nil))
(def receiveDone (atom nil))

;; The response from the remote device.
(def response (atom ""))

(def State (atom (StateObject.)))

(defn- Send [^Socket client ^String data]
  ;; Convert the string data to byte data using ASCII encoding.
  (let [byteData (.GetBytes (Encoding/getASCII) data)]
    ;; Begin sending the data to the remote device.
    (.BeginSend client byteData 0 (alength byteData) SocketFlags/None (SendCallback.) client)
    nil))

(defn- Receive [^Socket client]
  (try
    ;; Create the state object.
    (reset! State (StateObject.))
    (let [^StateObject state @State]
      (.setWorkSocket state client)
      ;; Begin receiving the data from the remote device.
      (.BeginReceive client (.getBuffer state) 0 (.getBufferSize state)
                     SocketFlags/None (ReceiveCallback.) nil))
    (catch Exception e
      (Console/WriteLine (.getMessage e))
      nil)))

(defn- StartClient []
  ;; Connect to a remote device.
  (try
    ;; Establish the remote endpoint for the socket.
    ;; The name of the remote device is "host.contoso.com".
    (let [ipHostInfo           (Dns/GetHostEntry "www.jcobridge.com")
          ^IPAddress ipAddress (first (.getAddressList ipHostInfo))
          remoteEP             (IPEndPoint. ipAddress (int port))
          ;; Create a TCP/IP socket.
          client               (Socket. (.getAddressFamily ipAddress) SocketType/Stream ProtocolType/Tcp)
          endpoint             (EndPoint/cast remoteEP)]

      ;; Connect to the remote endpoint.
      (.BeginConnect client endpoint (ConnectCallback.) client)
      (.WaitOne ^ManualResetEvent @connectDone)

      ;; Send test data to the remote device.
      (Send client "GET / HTTP/1.1\r\n\u0000")
      (.WaitOne ^ManualResetEvent @sendDone)

      ;; Receive the response from the remote device.
      (Receive client)
      (.WaitOne ^ManualResetEvent @receiveDone)

      ;; Write the response to the console.
      (Console/WriteLine "Response received : {0}" (NetObject. @response))

      ;; Release the socket.
      (.Shutdown client SocketShutdown/Both)
      (.Close client (int 0)))
    (catch Exception e
      (Console/WriteLine (.getMessage e)))))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (reset! connectDone (ManualResetEvent. false))
    (reset! sendDone (ManualResetEvent. false))
    (reset! receiveDone (ManualResetEvent. false))
    (StartClient)
    (catch Throwable e
      (.printStackTrace e)
      (System/exit -1))))