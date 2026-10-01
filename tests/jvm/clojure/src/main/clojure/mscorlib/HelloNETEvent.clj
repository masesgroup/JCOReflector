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

(ns mscorlib.HelloNETEvent
  (:require mscorlib.TimerElapsed)
  (:import (mscorlib TimerElapsed)
           (org.mases.jcobridge.netreflection JCOReflector)
           (system Console Environment)
           (system.threading ThreadStart)
           (system.timers Timer))
  (:gen-class
   :name mscorlib.HelloNETEvent
   :main true))

(defn -main [& args]
  (JCOReflector/setCommandLineArgs (into-array String args))
  (try
    (with-open [^Timer timer (Timer.)]
      (let [elapsed (TimerElapsed.)
            thread  (system.threading.Thread.
                     (proxy [ThreadStart] []
                       (Invoke []
                         (try
                           (println "Running thread.")
                           (.setEnabled timer true)
                           (catch Throwable e
                             (.printStackTrace e))))))]
        (.addElapsed timer elapsed)
        (.setInterval timer 1000.0)
        (.Start thread)
        (system.threading.Thread/Sleep (int 10000))
        (.Stop timer)
        (.removeElapsed timer elapsed)
        (Console/WriteLine "Exiting with success")
        (Environment/Exit (int 0))))
    (catch Throwable tre
      (.printStackTrace tre)
      (System/exit -1))))