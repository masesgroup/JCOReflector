/*
 *  MIT License
 *
 *  Copyright (c) 2023 MASES s.r.l.
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

/**************************************************************************************
 * <auto-generated>
 *      This code was generated from a template using JCOReflector
 * 
 *      Manual changes to this file may cause unexpected behavior in your application.
 *      Manual changes to this file will be overwritten if the code is regenerated.
 * </auto-generated>
 *************************************************************************************/

package system.net.sockets;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.net.IPEndPoint;
import system.net.sockets.AddressFamily;
import system.IAsyncResult;
import system.IAsyncResultImplementation;
import system.net.IPAddress;
import system.AsyncCallback;
import system.net.sockets.NetworkStream;
import system.threading.tasks.Task;
import system.threading.tasks.ValueTask;
import system.threading.CancellationToken;
import system.net.sockets.LingerOption;
import system.net.sockets.Socket;


/**
 * The base .NET class managing System.Net.Sockets.TcpClient, System.Net.Sockets, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.Sockets.TcpClient" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.Sockets.TcpClient</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class TcpClient extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: System.Net.Sockets, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Net.Sockets, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Net.Sockets
     */
    public static final String assemblyShortName = "System.Net.Sockets";
    /**
     * Qualified class name: System.Net.Sockets.TcpClient
     */
    public static final String className = "System.Net.Sockets.TcpClient";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            String classToCreate = className + ", "
                    + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Creating %s", classToCreate);
            JCType typeCreated = bridge.GetType(classToCreate);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Created: %s",
                        (typeCreated != null) ? typeCreated.toString() : "Returned null value");
            return typeCreated;
        } catch (JCException e) {
            JCOReflector.writeLog(e);
            return null;
        }
    }

    void addReference(String ref) throws Throwable {
        try {
            bridge.AddReference(ref);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }
    /**
     * Internal constructor. Use with caution 
     */
    public TcpClient(java.lang.Object instance) throws Throwable {
        super(instance);
        if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new Exception("Cannot manage object, it is not a JCObject");
    }

    public String getJCOAssemblyName() {
        return assemblyFullName;
    }

    public String getJCOClassName() {
        return className;
    }

    public String getJCOObjectName() {
        return className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    public java.lang.Object getJCOInstance() {
        return classInstance;
    }

    public void setJCOInstance(JCObject instance) {
        classInstance = instance;
        super.setJCOInstance(classInstance);
    }

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link TcpClient}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link TcpClient} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static TcpClient cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new TcpClient(from.getJCOInstance());
    }

    // Constructors section
    
    public TcpClient() throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.ArgumentException, system.ArrayTypeMismatchException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.net.sockets.SocketException, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TcpClient(IPEndPoint localEP) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(localEP == null ? null : localEP.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TcpClient(AddressFamily family) throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ArgumentNullException, system.ObjectDisposedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(family == null ? null : family.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TcpClient(java.lang.String hostname, int port) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.ArgumentException, system.ArrayTypeMismatchException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.net.sockets.SocketException, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(hostname, port));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public IAsyncResult BeginConnect(IPAddress address, int port, AsyncCallback requestCallback, NetObject state) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.ArgumentException, system.InvalidOperationException, system.net.sockets.SocketException, system.NotSupportedException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objBeginConnect = (JCObject)classInstance.Invoke("BeginConnect", address == null ? null : address.getJCOInstance(), port, requestCallback, state == null ? null : state.getJCOInstance());
            return new IAsyncResultImplementation(objBeginConnect);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IAsyncResult BeginConnect(IPAddress[] addresses, int port, AsyncCallback requestCallback, NetObject state) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objBeginConnect = (JCObject)classInstance.Invoke("BeginConnect", toObjectFromArray(addresses), port, requestCallback, state == null ? null : state.getJCOInstance());
            return new IAsyncResultImplementation(objBeginConnect);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IAsyncResult BeginConnect(java.lang.String host, int port, AsyncCallback requestCallback, NetObject state) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.NotSupportedException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objBeginConnect = (JCObject)classInstance.Invoke("BeginConnect", host, port, requestCallback, state == null ? null : state.getJCOInstance());
            return new IAsyncResultImplementation(objBeginConnect);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetworkStream GetStream() throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetStream = (JCObject)classInstance.Invoke("GetStream");
            return new NetworkStream(objGetStream);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task ConnectAsync(IPAddress address, int port) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", address == null ? null : address.getJCOInstance(), port);
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task ConnectAsync(IPAddress[] addresses, int port) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", toObjectFromArray(addresses), port);
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task ConnectAsync(IPEndPoint remoteEP) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.ArgumentException, system.InvalidOperationException, system.net.sockets.SocketException, system.NotSupportedException, system.FormatException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", remoteEP == null ? null : remoteEP.getJCOInstance());
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task ConnectAsync(java.lang.String host, int port) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", host, port);
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ValueTask ConnectAsync(IPAddress address, int port, CancellationToken cancellationToken) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.net.sockets.SocketException, system.FormatException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", address == null ? null : address.getJCOInstance(), port, cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ValueTask ConnectAsync(IPAddress[] addresses, int port, CancellationToken cancellationToken) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.net.sockets.SocketException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", toObjectFromArray(addresses), port, cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ValueTask ConnectAsync(IPEndPoint remoteEP, CancellationToken cancellationToken) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.InvalidOperationException, system.OutOfMemoryException, system.ObjectDisposedException, system.net.sockets.SocketException, system.FormatException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", remoteEP == null ? null : remoteEP.getJCOInstance(), cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ValueTask ConnectAsync(java.lang.String host, int port, CancellationToken cancellationToken) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConnectAsync = (JCObject)classInstance.Invoke("ConnectAsync", host, port, cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Close() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.ArgumentException, system.FormatException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Connect(IPAddress address, int port) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.net.sockets.SocketException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Connect", address == null ? null : address.getJCOInstance(), port);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Connect(IPAddress[] ipAddresses, int port) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.net.sockets.SocketException, system.PlatformNotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.IndexOutOfRangeException, system.FormatException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Connect", toObjectFromArray(ipAddresses), port);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Connect(IPEndPoint remoteEP) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.net.sockets.SocketException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Connect", remoteEP == null ? null : remoteEP.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Connect(java.lang.String hostname, int port) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Connect", hostname, port);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.ArrayTypeMismatchException, system.ArgumentException, system.FormatException, system.ArgumentOutOfRangeException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void EndConnect(IAsyncResult asyncResult) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.threading.tasks.TaskSchedulerException, system.PlatformNotSupportedException, system.threading.tasks.TaskCanceledException, system.ArgumentOutOfRangeException, system.AggregateException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("EndConnect", asyncResult == null ? null : asyncResult.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void close() throws Exception {
        try {
            if (classInstance == null)
                throw new UnsupportedOperationException("classInstance is null.");
            try {
                classInstance.Invoke("Dispose");
            }
            catch (JCNativeException jcne) {
                throw translateException(jcne);
            }
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }
    
    // Properties section
    
    public boolean getConnected() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.diagnostics.tracing.EventSourceException, system.ObjectDisposedException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Connected");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getExclusiveAddressUse() throws Throwable, system.ObjectDisposedException, system.PlatformNotSupportedException, system.ArgumentNullException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.ArgumentException, system.FormatException, system.InvalidOperationException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ExclusiveAddressUse");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExclusiveAddressUse(boolean ExclusiveAddressUse) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ExclusiveAddressUse", ExclusiveAddressUse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getNoDelay() throws Throwable, system.ObjectDisposedException, system.PlatformNotSupportedException, system.ArgumentNullException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.ArgumentException, system.FormatException, system.InvalidOperationException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("NoDelay");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setNoDelay(boolean NoDelay) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.ArgumentException, system.FormatException, system.ArgumentOutOfRangeException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("NoDelay", NoDelay);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getAvailable() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Available");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getReceiveBufferSize() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ReceiveBufferSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReceiveBufferSize(int ReceiveBufferSize) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ReceiveBufferSize", ReceiveBufferSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getReceiveTimeout() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ReceiveTimeout");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReceiveTimeout(int ReceiveTimeout) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ReceiveTimeout", ReceiveTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getSendBufferSize() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("SendBufferSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSendBufferSize(int SendBufferSize) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SendBufferSize", SendBufferSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getSendTimeout() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("SendTimeout");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSendTimeout(int SendTimeout) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SendTimeout", SendTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public LingerOption getLingerState() throws Throwable, system.ObjectDisposedException, system.PlatformNotSupportedException, system.ArgumentNullException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.ArgumentException, system.FormatException, system.InvalidOperationException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LingerState");
            return new LingerOption(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLingerState(LingerOption LingerState) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.ArgumentException, system.FormatException, system.ArgumentOutOfRangeException, system.diagnostics.tracing.EventSourceException, system.globalization.CultureNotFoundException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LingerState", LingerState == null ? null : LingerState.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Socket getClient() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Client");
            return new Socket(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setClient(Socket Client) throws Throwable, system.OutOfMemoryException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.ArgumentException, system.InvalidOperationException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ObjectDisposedException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Client", Client == null ? null : Client.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}