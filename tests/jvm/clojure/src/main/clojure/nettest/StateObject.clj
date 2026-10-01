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