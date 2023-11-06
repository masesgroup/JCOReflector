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

import system.AsyncCallback
import system.IAsyncResult
import system.net.sockets.SocketFlags
import system.text.Encoding

class ReceiveCallback extends AsyncCallback {
  override def Invoke(ar: IAsyncResult): Unit = {
    try { // Retrieve the state object and the client socket
      // from the asynchronous state object.
      val client = HelloNETSocketClientAsync.State.workSocket
      // Read data from the remote device.
      val bytesRead = client.EndReceive(ar)
      if (bytesRead > 0) { // There might be more data, so store the data received so far.
        HelloNETSocketClientAsync.State.sb.append(Encoding.getASCII.GetString(HelloNETSocketClientAsync.State.buffer, 0, bytesRead))
        // Get the rest of the data.
        client.BeginReceive(HelloNETSocketClientAsync.State.buffer, 0, HelloNETSocketClientAsync.State.BufferSize, SocketFlags.None, new ReceiveCallback, null)
      }
      else { // All the data has arrived; put it in response.
        if (HelloNETSocketClientAsync.State.sb.length > 1) HelloNETSocketClientAsync.response = HelloNETSocketClientAsync.State.sb.toString
        // Signal that all bytes have been received.
        HelloNETSocketClientAsync.receiveDone.Set
      }
    } catch {
      case e: Throwable =>
        e.printStackTrace()
        System.exit(-1)
    }
  }
}