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