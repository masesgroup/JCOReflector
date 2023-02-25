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
import system.threading.tasks.Task;
import system.net.sockets.Socket;
import system.net.EndPoint;
import system.net.IPAddress;
import system.threading.tasks.ValueTask;
import system.threading.CancellationToken;


/**
 * The base .NET class managing System.Net.Sockets.SocketTaskExtensions, System.Net.Sockets, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.Sockets.SocketTaskExtensions" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.Sockets.SocketTaskExtensions</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class SocketTaskExtensions extends NetObject  {
    /**
     * Fully assembly qualified name: System.Net.Sockets, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Net.Sockets, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Net.Sockets
     */
    public static final String assemblyShortName = "System.Net.Sockets";
    /**
     * Qualified class name: System.Net.Sockets.SocketTaskExtensions
     */
    public static final String className = "System.Net.Sockets.SocketTaskExtensions";
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
    public SocketTaskExtensions(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SocketTaskExtensions}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SocketTaskExtensions} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SocketTaskExtensions cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SocketTaskExtensions(from.getJCOInstance());
    }

    // Constructors section
    
    public SocketTaskExtensions() throws Throwable {
    }

    
    // Methods section
    
    public static Task ConnectAsync(Socket socket, EndPoint remoteEP) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.ArgumentException, system.InvalidOperationException, system.net.sockets.SocketException, system.NotSupportedException, system.FormatException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), remoteEP == null ? null : remoteEP.getJCOInstance());
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Task ConnectAsync(Socket socket, IPAddress address, int port) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), address == null ? null : address.getJCOInstance(), port);
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Task ConnectAsync(Socket socket, IPAddress[] addresses, int port) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.net.sockets.SocketException, system.PlatformNotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), toObjectFromArray(addresses), port);
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Task ConnectAsync(Socket socket, java.lang.String host, int port) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), host, port);
            return new Task(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ValueTask ConnectAsync(Socket socket, EndPoint remoteEP, CancellationToken cancellationToken) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), remoteEP == null ? null : remoteEP.getJCOInstance(), cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ValueTask ConnectAsync(Socket socket, IPAddress address, int port, CancellationToken cancellationToken) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.net.sockets.SocketException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), address == null ? null : address.getJCOInstance(), port, cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ValueTask ConnectAsync(Socket socket, IPAddress[] addresses, int port, CancellationToken cancellationToken) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), toObjectFromArray(addresses), port, cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ValueTask ConnectAsync(Socket socket, java.lang.String host, int port, CancellationToken cancellationToken) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConnectAsync = (JCObject)classType.Invoke("ConnectAsync", socket == null ? null : socket.getJCOInstance(), host, port, cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new ValueTask(objConnectAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}