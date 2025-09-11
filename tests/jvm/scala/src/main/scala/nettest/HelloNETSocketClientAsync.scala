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

import org.mases.jcobridge.netreflection._
import system._
import system.net._
import system.net.sockets._
import system.threading._
import system.text._

// Based on examples from:
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket

object HelloNETSocketClientAsync { // The port number for the remote device.
  private val port = 80
  // ManualResetEvent instances signal completion.
  private[nettest] var connectDone:ManualResetEvent  = null
  private[nettest] var sendDone:ManualResetEvent = null
  private[nettest] var receiveDone:ManualResetEvent = null
  // The response from the remote device.
  private[nettest] var response = ""
  private[nettest] var State = new StateObject

  @throws[Throwable]
  private def StartClient(): Unit = { // Connect to a remote device.
    try { // Establish the remote endpoint for the socket.
      // The name of the remote device is "host.contoso.com".
      val ipHostInfo = Dns.GetHostEntry("www.jcobridge.com")
      val ipAddress = ipHostInfo.getAddressList()(0)
      val remoteEP = new IPEndPoint(ipAddress, port)
      // Create a TCP/IP socket.
      val client = new Socket(ipAddress.getAddressFamily, SocketType.Stream, ProtocolType.Tcp)
      val endpoint = EndPoint.cast(remoteEP)
      // Connect to the remote endpoint.
      client.BeginConnect(endpoint, new ConnectCallback, client)
      connectDone.WaitOne
      // Send test data to the remote device.
      Send(client, "GET / HTTP/1.1\r\n\u0000")
      sendDone.WaitOne
      // Receive the response from the remote device.
      Receive(client)
      receiveDone.WaitOne
      // Write the response to the console.
      Console.WriteLine("Response received : {0}", new NetObject(response))
      // Release the socket.
      client.Shutdown(SocketShutdown.Both)
      client.Close(0)
    } catch {
      case e: Exception =>
        Console.WriteLine(e.getMessage)
    }
  }

  @throws[Throwable]
  private def Receive(client: Socket): IAsyncResult = {
    try { // Create the state object.
      HelloNETSocketClientAsync.State = new StateObject
      HelloNETSocketClientAsync.State.workSocket = client
      // Begin receiving the data from the remote device.
      return client.BeginReceive(HelloNETSocketClientAsync.State.buffer, 0, HelloNETSocketClientAsync.State.BufferSize, SocketFlags.None, new ReceiveCallback, null)
    } catch {
      case e: Exception =>
        Console.WriteLine(e.getMessage)
        System.exit(-1)
    }
    null
  }

  @throws[Throwable]
  private def Send(client: Socket, data: String): Unit = { // Convert the string data to byte data using ASCII encoding.
    val byteData = Encoding.getASCII.GetBytes(data)
    // Begin sending the data to the remote device.
    client.BeginSend(byteData, 0, byteData.length, SocketFlags.None, new SendCallback, client)
  }

  @throws[Throwable]
  def main(args: scala.Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
        connectDone = new ManualResetEvent(false)
        sendDone = new ManualResetEvent(false)
        receiveDone = new ManualResetEvent(false)
        StartClient()
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }
}