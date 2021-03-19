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
package nettest

import org.mases.jcobridge.netreflection.JCOReflector
import system.ArgumentNullException
import system.Environment
import system.InvalidOperationException
import system.security.SecurityException
import system.threading.Thread
import system.threading.ThreadStart

object HelloNETSocket {
    var asyncMode = false
    var serverAddress = "0.0.0.0"

    @Throws(
        ArgumentNullException::class,
        InvalidOperationException::class,
        SecurityException::class,
        Throwable::class
    )
    @JvmStatic
    fun main(args: Array<String>) {
        JCOReflector.setCommandLineArgs(args)
        var x = 0
        while (x < args.size) {
            val arg = args[x]
            if (arg === "-async") asyncMode = true
            if (arg === "-server") {
                serverAddress = args[x + 1]
                x++
            }
            x++
        }
        // create the server thread
        val threadServer = Thread(object : ThreadStart() {
            override fun Invoke() {
                HelloNETSocketServer.StartListening(asyncMode, serverAddress, 11000)
            }
        })
        // create the client thread
        val threadClient = Thread(object : ThreadStart() {
            override fun Invoke() {
                HelloNETSocketClient.StartClient(asyncMode, "localhost", 11000)
            }
        })
        // start threads
        threadServer.Start()
        Thread.Sleep(5000)
        threadClient.Start()
        // let it communicate
        Thread.Sleep(5000)
        // trigger the thread closing procedure
        HelloNETSocketClient.run = false
        Thread.Sleep(1000)
        // wait for thread join
        threadServer.Join()
        threadClient.Join()
        // close the application
        Environment.Exit(0)
        return
    }
}