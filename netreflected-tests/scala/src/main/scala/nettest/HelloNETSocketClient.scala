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

import java.util
import org.mases.jcobridge.netreflection.JCORefOut
import org.mases.jcobridge.netreflection.NetObject
import system.diagnostics.tracing.EventSourceException
import system.net._
import system.net.sockets._
import system.resources.MissingManifestResourceException
import system.text.Encoding

// import package
import scala.util.control.Breaks._

// Based on examples from:
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-a-synchronous-client-socket
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket

object HelloNETSocketClient {
  var run = true
  // Incoming data from the client.
  var data: String = null

  def StartClient(asyncMode: scala.Boolean, address: String, port: Int): Unit = { // Data buffer for incoming data
    // Connect to a remote device.
    val bytes: scala.Array[scala.Byte] = new scala.Array[scala.Byte](1024)

    try { // Establish the remote endpoint for the socket.
      var ipAddress: IPAddress = null
      // resolve the given ip address
      val ipHostInfo = Dns.GetHostEntry(address)
      val ipAddresses = ipHostInfo.getAddressList
      // create a Breaks object
      breakable {
        for (ipAddressAvailable <- ipAddresses) {
          System.out.println(ipAddressAvailable)
          if (ipAddressAvailable.getAddressFamily.ToString == AddressFamily.InterNetwork.ToString) {
            ipAddress = ipAddressAvailable
            break
          }
        }
      }
      if (ipAddress == null) {
        Console.WriteLine("No Ip resolved for the address: " + address)
        return
      }
      val remoteEP = new IPEndPoint(ipAddress, port)
      // connection counter
      var x = 1
      var exit = false
      while ( {
        !exit
      }) try { // Create a TCP/IP socket.
        val sender = new Socket(ipAddress.getAddressFamily, SocketType.Stream, ProtocolType.Tcp)
        // Connect the socket to the remote endpoint. Catch any errors.
        sender.Connect(remoteEP.getAddress, remoteEP.getPort) // ipAddress, 80);

        Console.WriteLine("Client connection #" + x)
        Console.WriteLine("Client socket connected to " + ipAddress.toString)
        // Encode the data string into a byte array.
        var msg: scala.Array[scala.Byte] = null
        msg = "Communication OK please exit".getBytes
        if (!run) { // Do another run to Ask the server to close
          msg = "Communication OK please abort".getBytes
          run = true
          exit = true
        }
        Console.WriteLine("Sent msg = " + util.Arrays.toString(msg))
        // Send the data through the socket.
        sender.Send(msg)
        // Receive the response from the remote device.
        while ( {
          sender.getAvailable == 0 && !(run && exit)
        }) {}
        Console.WriteLine("Client bytes received " + sender.getAvailable)
        if (asyncMode) { // define the async event object
          val asea = new SocketAsyncEventArgs
          asea.SetBuffer(bytes, 0, bytes.length)
          sender.ReceiveAsync(asea)
          // decode and display the received data
          val message = Encoding.getASCII.GetString(asea.getBuffer, 0, asea.getBytesTransferred)
          if (message != null) Console.WriteLine("Client data received {0}", new NetObject(message))
        }
        else {
          val recBytes = sender.Receive(JCORefOut.Create(bytes))
          val message = Encoding.getASCII.GetString(bytes, 0, recBytes)
          if (message != null) Console.WriteLine("Client data received {0}", new NetObject(message))
        }
        x += 1
        //force a closure after 50 connections if no external closure happened before 
        if((x % 50) == 0) run = false
      } catch {
        case e@(_: ArgumentNullException | _: SocketException) =>
          Console.WriteLine(e.getMessage)
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
      case e@(_: ArgumentException | _: InvalidOperationException | _: IndexOutOfRangeException | _: NotSupportedException | _: MissingManifestResourceException | _: FormatException | _: EventSourceException) =>
        e.printStackTrace()
      case e: Throwable =>
        e.printStackTrace()
    }
    System.out.println("Client exited correctly")
  }
}
