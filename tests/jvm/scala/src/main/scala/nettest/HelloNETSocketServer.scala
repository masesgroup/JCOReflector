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

import org.mases.jcobridge.netreflection.JCORefOut
import org.mases.jcobridge.netreflection.NetObject
import system._
import system.net._
import system.net.sockets._
import system.text.Encoding

// import package
import scala.util.control.Breaks._

// Based on examples from:
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-a-synchronous-server-socket
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-server-socket

object HelloNETSocketServer {
  var run = true
  // Incoming data from the client.
  var data: String = null

  def StartListening(asyncMode: scala.Boolean, address: String, port: Int): Unit = { // Data buffer for incoming data.
    val bytes = new scala.Array[scala.Byte](1024)
    var ipAddress : IPAddress = null
    // Establish the local endpoint for the socket.
    // Dns.GetHostName returns the name of the host running the application.
    try {
      val ipHostInfo = Dns.GetHostEntry(Dns.GetHostName)
      val ipAddresses = ipHostInfo.getAddressList
      // print available endpoints
      System.out.println("List of available IP Endpoints:")
      for (ipAddressAvailable <- ipAddresses) {
        System.out.println(ipAddressAvailable)
      }
      // parse ip address
      ipAddress = IPAddress.Parse(address)
      val localEndPoint = new IPEndPoint(ipAddress, port)
      // Create a TCP/IP socket.
      val listener = new Socket(ipAddress.getAddressFamily, SocketType.Stream, ProtocolType.Tcp)
      // Bind the socket to the local endpoint and
      // listen for incoming connections.
      listener.Bind(EndPoint.cast(localEndPoint))
      listener.Listen(10)
      // connection counter
      var x = 1
      // Start listening for connections.
      while ( {
        run
      }) {
        Console.WriteLine("Waiting for a connection... Step {0}", new NetObject(x))
        // Program is suspended while waiting for an incoming connection.
        val handler = listener.Accept
        System.out.println("Server connected to client: " + handler.getRemoteEndPoint.ToString)
        data = ""
        // An incoming connection needs to be processed.
        var receive = true

        breakable {
          while ( {
            receive && run
          }) {
            var dataNew = ""
            if (asyncMode) {
              val asea = new SocketAsyncEventArgs
              asea.SetBuffer(bytes, 0, bytes.length)
              handler.ReceiveAsync(asea)
              while ( {
                asea.getBytesTransferred == 0 && run
              }) {
                if (!asea.getSocketError.ToString.equalsIgnoreCase(SocketError.Success.ToString)) {
                  receive = false
                  break
                }
              }
              dataNew = Encoding.getASCII.GetString(asea.getBuffer, 0, asea.getBytesTransferred)
            }
            else {
              val recBytes = handler.Receive(JCORefOut.Create(bytes))
              dataNew = Encoding.getASCII.GetString(bytes, 0, recBytes)
            }
            data += dataNew
            System.out.println("Received from Client " + dataNew)
            x += 1
            val msg = dataNew.getBytes
            // echo received data
            handler.Send(msg)
            if (data.length > 4 && data.indexOf("exit") > -1) {
              Console.WriteLine("Connection Closed by the client")
              receive = false
            }
            if (data.length > 4 && data.indexOf("abort") > -1) {
              Console.WriteLine("Server shutdown requested by the client")
              run = false
            }
          }
        }
        // Show the data on the console.
        if (data != null) Console.WriteLine("Text received : {0}", new NetObject(data))
        handler.Shutdown(SocketShutdown.Both)
        handler.Close(10)
      }
    } catch {
      case e@(_: Exception | _: PlatformNotSupportedException | _: ArgumentException | _: InvalidOperationException | _: ArrayTypeMismatchException) =>
        e.printStackTrace()
        System.exit(-1)
      case e: Throwable =>
        e.printStackTrace()
        System.exit(-1)
    }
    System.out.println("Server exited correctly")
  }
}