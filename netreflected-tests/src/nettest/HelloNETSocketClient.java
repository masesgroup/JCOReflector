/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

import org.mases.jcobridge.*;
//import .NET
import org.mases.jcobridge.netreflection.NetObject;
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
    public static boolean run = true;
    // Incoming data from the client.
    public static String data = null;

    static int Receive(Socket sender, JCRefOut ref) throws JCNativeException, Throwable {
        // from https://github.com/masesgroup/JCOReflector/issues/10#issuecomment-652572559
        JCObject jco = (JCObject) sender.getJCOInstance();
        int bytesRec = (int) jco.Invoke("Receive", ref, sender.getAvailable(), SocketFlags.None.getJCOInstance());

        return bytesRec;
    }

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
                Console.WriteLine("No Ip resolved for the address: " + address);
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
                    Console.WriteLine("Client connection #" + x);
                    Console.WriteLine("Client socket connected to " + ipAddress.toString());
                    // Encode the data string into a byte array.
                    byte[] msg;
                    msg = "Communication OK please exit".getBytes();
                    if (!run) {
                        // Do another run to Ask the server to close
                        msg = "Communication OK please abort".getBytes();
                        run = true;
                        exit = true;
                    }
                    Console.WriteLine("Sent msg = " + Arrays.toString(msg));
                    // Send the data through the socket.
                    sender.Send(msg);
                    // Receive the response from the remote device.
                    while (sender.getAvailable() == 0 && !(run && exit));
                    Console.WriteLine("Client bytes received " + sender.getAvailable());
                    if (asyncMode) {
                        // define the async event object
                        SocketAsyncEventArgs asea = new SocketAsyncEventArgs();
                        asea.SetBuffer(bytes, 0, bytes.length);
                        sender.ReceiveAsync(asea);
                        // decode and display the received data
                        String message = Encoding.getASCII().GetString(asea.getBuffer(), 0, asea.getBytesTransferred());
                        Console.WriteLine("Client data received {0}", new NetObject(message));
                    } else {
                        int recBytes = Receive(sender, JCRefOut.Create(bytes));
                        String message = Encoding.getASCII().GetString(bytes, 0, recBytes);
                        Console.WriteLine("Client data received {0}", new NetObject(message));
                    }
                    x++;
                } catch (ArgumentNullException | SocketException e) {
                    Console.WriteLine(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (ArgumentException | ArgumentOutOfRangeException | ArgumentNullException | InvalidOperationException
                | PlatformNotSupportedException | IndexOutOfRangeException | NotSupportedException
                | MissingManifestResourceException | ObjectDisposedException | FormatException
                | EventSourceException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Client exited correctly");
    }
}