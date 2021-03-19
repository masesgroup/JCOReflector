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

/**************************************************************************************
 * <auto-generated>
 *      This code was generated from a template using JCOReflector
 * 
 *      Manual changes to this file may cause unexpected behavior in your application.
 *      Manual changes to this file will be overwritten if the code is regenerated.
 * </auto-generated>
 *************************************************************************************/

package system.net.networkinformation;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.Component;
import system.net.networkinformation.PingReply;
import system.net.IPAddress;
import system.net.networkinformation.PingOptions;
import system.net.networkinformation.PingCompletedEventHandler;


/**
 * The base .NET class managing System.Net.NetworkInformation.Ping, System.Net.Ping, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.NetworkInformation.Ping" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.NetworkInformation.Ping</a>
 */
public class Ping extends Component  {
    /**
     * Fully assembly qualified name: System.Net.Ping, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Net.Ping, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Net.Ping
     */
    public static final String assemblyShortName = "System.Net.Ping";
    /**
     * Qualified class name: System.Net.NetworkInformation.Ping
     */
    public static final String className = "System.Net.NetworkInformation.Ping";
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

    public Ping(Object instance) throws Throwable {
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

    public Object getJCOInstance() {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Ping}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Ping} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Ping cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Ping(from.getJCOInstance());
    }

    // Constructors section
    
    public Ping() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public PingReply Send(IPAddress address) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", address == null ? null : address.getJCOInstance());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(IPAddress address, int timeout) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", address == null ? null : address.getJCOInstance(), timeout);
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(IPAddress address, int timeout, byte[] buffer) throws Throwable, system.ArgumentException, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", address == null ? null : address.getJCOInstance(), timeout, buffer);
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(IPAddress dupParam0, int dupParam1, JCORefOut dupParam2) throws Throwable, system.ArgumentException, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1, dupParam2.getJCRefOut());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(IPAddress address, int timeout, byte[] buffer, PingOptions options) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.InvalidOperationException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", address == null ? null : address.getJCOInstance(), timeout, buffer, options == null ? null : options.getJCOInstance());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(IPAddress dupParam0, int dupParam1, JCORefOut dupParam2, PingOptions dupParam3) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.InvalidOperationException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1, dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(java.lang.String hostNameOrAddress) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", hostNameOrAddress);
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(java.lang.String hostNameOrAddress, int timeout) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", hostNameOrAddress, timeout);
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(java.lang.String hostNameOrAddress, int timeout, byte[] buffer) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", hostNameOrAddress, timeout, buffer);
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(java.lang.String dupParam0, int dupParam1, JCORefOut dupParam2) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", dupParam0, dupParam1, dupParam2.getJCRefOut());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(java.lang.String hostNameOrAddress, int timeout, byte[] buffer, PingOptions options) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", hostNameOrAddress, timeout, buffer, options == null ? null : options.getJCOInstance());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PingReply Send(java.lang.String dupParam0, int dupParam1, JCORefOut dupParam2, PingOptions dupParam3) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.net.sockets.SocketException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.threading.WaitHandleCannotBeOpenedException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.net.networkinformation.PingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSend = (JCObject)classInstance.Invoke("Send", dupParam0, dupParam1, dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance());
            return new PingReply(objSend);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(IPAddress address, int timeout, byte[] buffer, PingOptions options, NetObject userToken) throws Throwable, system.ArgumentException, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.InvalidOperationException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", address == null ? null : address.getJCOInstance(), timeout, buffer, options == null ? null : options.getJCOInstance(), userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(IPAddress dupParam0, int dupParam1, JCORefOut dupParam2, PingOptions dupParam3, NetObject dupParam4) throws Throwable, system.ArgumentException, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.InvalidOperationException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1, dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance(), dupParam4 == null ? null : dupParam4.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(IPAddress address, int timeout, byte[] buffer, NetObject userToken) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", address == null ? null : address.getJCOInstance(), timeout, buffer, userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(IPAddress dupParam0, int dupParam1, JCORefOut dupParam2, NetObject dupParam3) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.net.sockets.SocketException, system.NotSupportedException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1, dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(IPAddress address, int timeout, NetObject userToken) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.net.sockets.SocketException, system.NotSupportedException, system.threading.tasks.TaskSchedulerException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", address == null ? null : address.getJCOInstance(), timeout, userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(IPAddress address, NetObject userToken) throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.net.sockets.SocketException, system.NotSupportedException, system.threading.tasks.TaskSchedulerException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", address == null ? null : address.getJCOInstance(), userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(java.lang.String hostNameOrAddress, int timeout, byte[] buffer, PingOptions options, NetObject userToken) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.net.sockets.SocketException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", hostNameOrAddress, timeout, buffer, options == null ? null : options.getJCOInstance(), userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(java.lang.String dupParam0, int dupParam1, JCORefOut dupParam2, PingOptions dupParam3, NetObject dupParam4) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.net.sockets.SocketException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", dupParam0, dupParam1, dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance(), dupParam4 == null ? null : dupParam4.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(java.lang.String hostNameOrAddress, int timeout, byte[] buffer, NetObject userToken) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", hostNameOrAddress, timeout, buffer, userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(java.lang.String dupParam0, int dupParam1, JCORefOut dupParam2, NetObject dupParam3) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", dupParam0, dupParam1, dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(java.lang.String hostNameOrAddress, int timeout, NetObject userToken) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", hostNameOrAddress, timeout, userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsync(java.lang.String hostNameOrAddress, NetObject userToken) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.ObjectDisposedException, system.net.sockets.SocketException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsync", hostNameOrAddress, userToken == null ? null : userToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SendAsyncCancel() throws Throwable, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.OperationCanceledException, system.threading.LockRecursionException, system.threading.SynchronizationLockException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SendAsyncCancel");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

    public void addPingCompleted(PingCompletedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("PingCompleted", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removePingCompleted(PingCompletedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("PingCompleted", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}