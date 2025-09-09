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

package nettest;

import org.mases.jcobridge.netreflection.*;

import system.*;
import system.net.*;
import system.net.sockets.*;
import system.threading.*;
import system.text.*;

// Based on examples from:
// https://docs.microsoft.com/en-us/dotnet/framework/network-programming/using-an-asynchronous-client-socket

public class HelloNETSocketClientAsync {
    // The port number for the remote device.
    private static int port = 80;

    // ManualResetEvent instances signal completion.
    static ManualResetEvent connectDone;
    static ManualResetEvent sendDone;
    static ManualResetEvent receiveDone;

    // The response from the remote device.
    static String response = "";

    static StateObject State = new StateObject();

    private static void StartClient() throws Throwable {
        // Connect to a remote device.
        try {
            // Establish the remote endpoint for the socket.
            // The name of the remote device is "host.contoso.com".
            IPHostEntry ipHostInfo = Dns.GetHostEntry("www.jcobridge.com");
            IPAddress ipAddress = ipHostInfo.getAddressList()[0];
            IPEndPoint remoteEP = new IPEndPoint(ipAddress, port);

            // Create a TCP/IP socket.
            Socket client = new Socket(ipAddress.getAddressFamily(), SocketType.Stream, ProtocolType.Tcp);

            EndPoint endpoint = EndPoint.cast(remoteEP);

            // Connect to the remote endpoint.
            client.BeginConnect(endpoint, new ConnectCallback(), client);
            connectDone.WaitOne();

            // Send test data to the remote device.
            Send(client, "GET / HTTP/1.1\r\n\0");
            sendDone.WaitOne();

            // Receive the response from the remote device.
            Receive(client);
            receiveDone.WaitOne();

            // Write the response to the console.
            Console.WriteLine("Response received : {0}", new NetObject(response));

            // Release the socket.
            client.Shutdown(SocketShutdown.Both);
            client.Close(0);

        } catch (Exception e) {
            Console.WriteLine(e.getMessage());
        }
    }

    private static IAsyncResult Receive(Socket client) throws Throwable {
        try {
            // Create the state object.
            HelloNETSocketClientAsync.State = new StateObject();
            HelloNETSocketClientAsync.State.workSocket = client;
            // Begin receiving the data from the remote device.
            return client.BeginReceive(HelloNETSocketClientAsync.State.buffer, 0,
                    HelloNETSocketClientAsync.State.BufferSize, SocketFlags.None, new ReceiveCallback(), null);
        } catch (Exception e) {
            Console.WriteLine(e.getMessage());
        }
        return null;
    }

    private static void Send(Socket client, String data) throws Throwable {
        // Convert the string data to byte data using ASCII encoding.
        byte[] byteData = Encoding.getASCII().GetBytes(data);

        // Begin sending the data to the remote device.
        client.BeginSend(byteData, 0, byteData.length, SocketFlags.None, new SendCallback(), client);
    }

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            connectDone = new ManualResetEvent(false);
            sendDone = new ManualResetEvent(false);
            receiveDone = new ManualResetEvent(false);
            StartClient();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}