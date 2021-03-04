/*
 *  MIT License
 *
 *  Copyright (c) 2021 MASES s.r.l.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package mscorlib

import org.mases.jcobridge.netreflection.JCOReflector
import system.Environment
import system.threading.Thread
import system.threading.ThreadStart
import system.timers.Timer

object HelloNETEvent {
    @JvmStatic
    fun main(args: Array<String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            Timer().use { timer ->
                val elapsed = TimerElapsed()
                timer.addElapsed(elapsed)
                timer.interval = 1000.0
                val thread = Thread(object : ThreadStart() {
                    override fun Invoke() {
                        try {
                            println("Running thread.")
                            timer.enabled = true
                        } catch (e: Throwable) {
                            e.printStackTrace()
                        }
                    }
                })
                thread.Start()
                Thread.Sleep(10000)
                timer.Stop()
                timer.removeElapsed(elapsed)
                Environment.Exit(0)
            }
        } catch (tre: Throwable) {
            tre.printStackTrace()
        }
    }
}