/*
 *  MIT License
 *
 *  Copyright (c) 2020-2026 MASES s.r.l.
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

import org.mases.jcobridge.netreflection._
import system.ArgumentNullException
import system.Environment
import system.InvalidOperationException
import system.security.SecurityException
import system.threading.Thread
import system.threading.ThreadStart

object HelloNETSocket {
  private[nettest] var asyncMode = false : scala.Boolean
  private[nettest] var serverAddress = "0.0.0.0"

  @throws[ArgumentNullException]
  @throws[InvalidOperationException]
  @throws[SecurityException]
  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
        var x = 0
        while ( {
          x < args.length
        }) {
          val arg = args(x)
          if (arg eq "-async") asyncMode = true
          if (arg eq "-server") {
            serverAddress = args(x + 1)
            x += 1
          }

          x += 1
        }
        // create the server thread
        val threadServer = new Thread(new ThreadStart() {
          override def Invoke(): Unit = {
            HelloNETSocketServer.StartListening(asyncMode, serverAddress, 11000)
          }
        })
        // create the client thread
        val threadClient = new Thread(new ThreadStart() {
          override def Invoke(): Unit = {
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
        // wait for thread join, if not, close the test
        threadServer.Join(5000)
        threadClient.Join(5000)
        // close the application
        Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }
}
