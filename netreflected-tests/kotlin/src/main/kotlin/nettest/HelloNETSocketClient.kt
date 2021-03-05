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
import system.*
import system.diagnostics.tracing.EventSourceException
import system.net.Dns
import system.net.IPAddress
import system.net.IPEndPoint
import system.net.sockets.*
import system.resources.MissingManifestResourceException
import system.text.Encoding
import java.lang.Exception
import java.util.*

//import java
//import .NET
// Based on examples from:
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-a-synchronous-client-socket
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket
object HelloNETSocketClient {
    @Volatile
    var run = true

    // Incoming data from the client.
    var data: String? = null
    fun StartClient(asyncMode: Boolean, address: String, port: Int) {
        // Data buffer for incoming data.
        val bytes = ByteArray(1024)

        // Connect to a remote device.
        try {
            // Establish the remote endpoint for the socket.
            var ipAddress: IPAddress? = null
            // resolve the given ip address
            val ipHostInfo = Dns.GetHostEntry(address)
            val ipAddresses = ipHostInfo.addressList
            for (ipAddressAvailable in ipAddresses) {
                println(ipAddressAvailable)
                if (ipAddressAvailable.addressFamily.ToString() == AddressFamily.InterNetwork.ToString()) {
                    ipAddress = ipAddressAvailable
                    break
                }
            }
            if (ipAddress == null) {
                Console.WriteLine("No Ip resolved for the address: $address")
                return
            }
            val remoteEP = IPEndPoint(ipAddress, port)
            // connection counter
            var x = 1
            var exit = false
            while (!exit) {
                try {
                    // Create a TCP/IP socket.
                    val sender = Socket(ipAddress.addressFamily, SocketType.Stream, ProtocolType.Tcp)
                    // Connect the socket to the remote endpoint. Catch any errors.
                    sender.Connect(remoteEP.address, remoteEP.port) // ipAddress, 80);
                    Console.WriteLine("Client connection #$x")
                    Console.WriteLine("Client socket connected to $ipAddress")
                    // Encode the data string into a byte array.
                    var msg: ByteArray
                    msg = "Communication OK please exit".toByteArray()
                    if (!run) {
                        // Do another run to Ask the server to close
                        msg = "Communication OK please abort".toByteArray()
                        run = true
                        exit = true
                    }
                    Console.WriteLine("Sent msg = " + Arrays.toString(msg))
                    // Send the data through the socket.
                    sender.Send(msg)
                    // Receive the response from the remote device.
                    while (sender.available == 0 && !(run && exit));
                    Console.WriteLine("Client bytes received " + sender.available)
                    if (asyncMode) {
                        // define the async event object
                        val asea = SocketAsyncEventArgs()
                        asea.SetBuffer(bytes, 0, bytes.size)
                        sender.ReceiveAsync(asea)
                        // decode and display the received data
                        val message = Encoding.getASCII().GetString(asea.buffer, 0, asea.bytesTransferred)
                        if (message != null) Console.WriteLine("Client data received {0}", NetObject(message))
                    } else {
                        val recBytes = sender.Receive(JCORefOut.Create(bytes))
                        val message = Encoding.getASCII().GetString(bytes, 0, recBytes)
                        if (message != null) Console.WriteLine("Client data received {0}", NetObject(message))
                    }
                    x++
                } catch (e: ArgumentNullException) {
                    Console.WriteLine(e.message)
                } catch (e: SocketException) {
                    Console.WriteLine(e.message)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } catch (e: ArgumentException) {
            e.printStackTrace()
        } catch (e: InvalidOperationException) {
            e.printStackTrace()
        } catch (e: IndexOutOfRangeException) {
            e.printStackTrace()
        } catch (e: NotSupportedException) {
            e.printStackTrace()
        } catch (e: MissingManifestResourceException) {
            e.printStackTrace()
        } catch (e: FormatException) {
            e.printStackTrace()
        } catch (e: EventSourceException) {
            e.printStackTrace()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        println("Client exited correctly")
    }
}