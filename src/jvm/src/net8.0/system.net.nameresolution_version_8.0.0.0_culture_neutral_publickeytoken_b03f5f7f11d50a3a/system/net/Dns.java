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

package system.net;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.IAsyncResult;
import system.IAsyncResultImplementation;
import system.AsyncCallback;
import system.net.IPAddress;
import system.net.sockets.AddressFamily;
import system.net.IPHostEntry;


/**
 * The base .NET class managing System.Net.Dns, System.Net.NameResolution, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.Dns" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.Dns</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class Dns extends NetObject  {
    /**
     * Fully assembly qualified name: System.Net.NameResolution, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Net.NameResolution, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Net.NameResolution
     */
    public static final String assemblyShortName = "System.Net.NameResolution";
    /**
     * Qualified class name: System.Net.Dns
     */
    public static final String className = "System.Net.Dns";
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
    public Dns(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Dns}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Dns} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Dns cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Dns(from.getJCOInstance());
    }

    // Constructors section
    
    public Dns() throws Throwable {
    }

    
    // Methods section
    
    public static IAsyncResult BeginGetHostAddresses(java.lang.String hostNameOrAddress, AsyncCallback requestCallback, NetObject state) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ObjectDisposedException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBeginGetHostAddresses = (JCObject)classType.Invoke("BeginGetHostAddresses", hostNameOrAddress, requestCallback, state == null ? null : state.getJCOInstance());
            return new IAsyncResultImplementation(objBeginGetHostAddresses);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IAsyncResult BeginGetHostByName(java.lang.String hostName, AsyncCallback requestCallback, NetObject stateObject) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ObjectDisposedException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBeginGetHostByName = (JCObject)classType.Invoke("BeginGetHostByName", hostName, requestCallback, stateObject == null ? null : stateObject.getJCOInstance());
            return new IAsyncResultImplementation(objBeginGetHostByName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IAsyncResult BeginGetHostEntry(IPAddress address, AsyncCallback requestCallback, NetObject stateObject) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBeginGetHostEntry = (JCObject)classType.Invoke("BeginGetHostEntry", address == null ? null : address.getJCOInstance(), requestCallback, stateObject == null ? null : stateObject.getJCOInstance());
            return new IAsyncResultImplementation(objBeginGetHostEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IAsyncResult BeginGetHostEntry(java.lang.String hostNameOrAddress, AsyncCallback requestCallback, NetObject stateObject) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentException, system.FormatException, system.OutOfMemoryException, system.net.sockets.SocketException, system.IndexOutOfRangeException, system.threading.tasks.TaskSchedulerException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBeginGetHostEntry = (JCObject)classType.Invoke("BeginGetHostEntry", hostNameOrAddress, requestCallback, stateObject == null ? null : stateObject.getJCOInstance());
            return new IAsyncResultImplementation(objBeginGetHostEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IAsyncResult BeginResolve(java.lang.String hostName, AsyncCallback requestCallback, NetObject stateObject) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.ObjectDisposedException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBeginResolve = (JCObject)classType.Invoke("BeginResolve", hostName, requestCallback, stateObject == null ? null : stateObject.getJCOInstance());
            return new IAsyncResultImplementation(objBeginResolve);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPAddress[] EndGetHostAddresses(IAsyncResult asyncResult) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<IPAddress> resultingArrayList = new ArrayList<IPAddress>();
            JCObject resultingObjects = (JCObject)classType.Invoke("EndGetHostAddresses", asyncResult == null ? null : asyncResult.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IPAddress(resultingObject));
            }
            IPAddress[] resultingArray = new IPAddress[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPAddress[] GetHostAddresses(java.lang.String hostNameOrAddress, AddressFamily family) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<IPAddress> resultingArrayList = new ArrayList<IPAddress>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetHostAddresses", hostNameOrAddress, family == null ? null : family.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IPAddress(resultingObject));
            }
            IPAddress[] resultingArray = new IPAddress[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPAddress[] GetHostAddresses(java.lang.String hostNameOrAddress) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<IPAddress> resultingArrayList = new ArrayList<IPAddress>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetHostAddresses", hostNameOrAddress);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IPAddress(resultingObject));
            }
            IPAddress[] resultingArray = new IPAddress[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry EndGetHostByName(IAsyncResult asyncResult) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objEndGetHostByName = (JCObject)classType.Invoke("EndGetHostByName", asyncResult == null ? null : asyncResult.getJCOInstance());
            return new IPHostEntry(objEndGetHostByName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry EndGetHostEntry(IAsyncResult asyncResult) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objEndGetHostEntry = (JCObject)classType.Invoke("EndGetHostEntry", asyncResult == null ? null : asyncResult.getJCOInstance());
            return new IPHostEntry(objEndGetHostEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry EndResolve(IAsyncResult asyncResult) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.diagnostics.tracing.EventSourceException, system.InvalidOperationException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objEndResolve = (JCObject)classType.Invoke("EndResolve", asyncResult == null ? null : asyncResult.getJCOInstance());
            return new IPHostEntry(objEndResolve);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry GetHostByAddress(IPAddress address) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.IndexOutOfRangeException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetHostByAddress = (JCObject)classType.Invoke("GetHostByAddress", address == null ? null : address.getJCOInstance());
            return new IPHostEntry(objGetHostByAddress);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry GetHostByAddress(java.lang.String address) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetHostByAddress = (JCObject)classType.Invoke("GetHostByAddress", address);
            return new IPHostEntry(objGetHostByAddress);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry GetHostByName(java.lang.String hostName) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetHostByName = (JCObject)classType.Invoke("GetHostByName", hostName);
            return new IPHostEntry(objGetHostByName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry GetHostEntry(IPAddress address) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetHostEntry = (JCObject)classType.Invoke("GetHostEntry", address == null ? null : address.getJCOInstance());
            return new IPHostEntry(objGetHostEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry GetHostEntry(java.lang.String hostNameOrAddress, AddressFamily family) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetHostEntry = (JCObject)classType.Invoke("GetHostEntry", hostNameOrAddress, family == null ? null : family.getJCOInstance());
            return new IPHostEntry(objGetHostEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry GetHostEntry(java.lang.String hostNameOrAddress) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetHostEntry = (JCObject)classType.Invoke("GetHostEntry", hostNameOrAddress);
            return new IPHostEntry(objGetHostEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPHostEntry Resolve(java.lang.String hostName) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objResolve = (JCObject)classType.Invoke("Resolve", hostName);
            return new IPHostEntry(objResolve);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String GetHostName() throws Throwable, system.PlatformNotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException, system.net.sockets.SocketException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("GetHostName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}