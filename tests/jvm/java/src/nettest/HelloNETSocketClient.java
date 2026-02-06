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

package nettest;

//import java 
import java.util.Arrays;

import org.mases.jcobridge.netreflection.JCORefOut;
import org.mases.jcobridge.netreflection.NetObject;
//import .NET

import system.*;
import system.diagnostics.tracing.EventSourceException;
import system.net.*;
import system.net.sockets.*;
import system.resources.MissingManifestResourceException;
import system.text.Encoding;

// Based on examples from:
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-a-synchronous-client-socket
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket

public class HelloNETSocketClient {
    public static volatile boolean run = true;
    // Incoming data from the client.
    public static String data = null;

    public static void StartClient(boolean asyncMode, String address, int port) {
        // Data buffer for incoming data.
        byte[] bytes = new byte[1024];

        // Connect to a remote device.
        try {
            // Establish the remote endpoint for the socket.
            IPAddress ipAddress = null;
            // resolve the given ip address
            IPHostEntry ipHostInfo = Dns.GetHostEntry(address);
            IPAddress[] ipAddresses = ipHostInfo.getAddressList();
            for (IPAddress ipAddressAvailable : ipAddresses) {
                System.out.println(ipAddressAvailable);
                if (ipAddressAvailable.getAddressFamily().ToString().equals(AddressFamily.InterNetwork.ToString())) {
                    ipAddress = ipAddressAvailable;
                    break;
                }
            }
            if (ipAddress == null) {
                Console.WriteLine("CLIENT: No Ip resolved for the address: " + address);
                return;
            }
            IPEndPoint remoteEP = new IPEndPoint(ipAddress, port);
            // connection counter
            int x = 1;
            boolean exit = false;
            while (!exit) {
                try {
                    // Create a TCP/IP socket.
                    Socket sender = new Socket(ipAddress.getAddressFamily(), SocketType.Stream, ProtocolType.Tcp);
                    // Connect the socket to the remote endpoint. Catch any errors.
                    sender.Connect(remoteEP.getAddress(), remoteEP.getPort());// ipAddress, 80);
                    Console.WriteLine("CLIENT: Client connection #" + x);
                    Console.WriteLine("CLIENT: Client socket connected to " + ipAddress.toString());
                    // Encode the data string into a byte array.
                    byte[] msg;
                    msg = "Communication OK please exit".getBytes();
                    if (!run) {
                        // Do another run to Ask the server to close
                        msg = "Communication OK please abort".getBytes();
                        run = true;
                        exit = true;
                    }
                    Console.WriteLine("CLIENT: Sent msg = " + Arrays.toString(msg));
                    // Send the data through the socket.
                    sender.Send(msg);
                    // Receive the response from the remote device.
                    while (sender.getAvailable() == 0 && !(run && exit)) { java.lang.Thread.sleep(1); };
                    Console.WriteLine("CLIENT: Client bytes received " + sender.getAvailable());
                    if (asyncMode) {
                        // define the async event object
                        SocketAsyncEventArgs asea = new SocketAsyncEventArgs();
                        asea.SetBuffer(bytes, 0, bytes.length);
                        sender.ReceiveAsync(asea);
                        // decode and display the received data
                        String message = Encoding.getASCII().GetString(asea.getBuffer(), 0, asea.getBytesTransferred());
                        if (message != null) Console.WriteLine("CLIENT: Client data received {0}", new NetObject(message));
                    } else {
                        int recBytes = sender.Receive(JCORefOut.Create(bytes));
                        String message = Encoding.getASCII().GetString(bytes, 0, recBytes);
                        if (message != null) Console.WriteLine("CLIENT: Client data received {0}", new NetObject(message));
                    }
                    x++;
                    //force a closure after 50 connections if no external closure happened before 
                    if((x % 50) == 0) run = false;
                } catch (ArgumentNullException | SocketException e) {
                    Console.WriteLine(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (ArgumentException | InvalidOperationException
                 | IndexOutOfRangeException | NotSupportedException
                | MissingManifestResourceException  | FormatException
                | EventSourceException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("CLIENT: Client exited correctly");
    }
}
