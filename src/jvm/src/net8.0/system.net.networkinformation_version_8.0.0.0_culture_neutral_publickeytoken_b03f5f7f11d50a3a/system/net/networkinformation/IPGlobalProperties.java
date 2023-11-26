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

package system.net.networkinformation;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.IAsyncResult;
import system.IAsyncResultImplementation;
import system.AsyncCallback;
import system.net.IPEndPoint;
import system.net.networkinformation.IcmpV4Statistics;
import system.net.networkinformation.IcmpV6Statistics;
import system.net.networkinformation.IPGlobalProperties;
import system.net.networkinformation.IPGlobalStatistics;
import system.net.networkinformation.TcpConnectionInformation;
import system.net.networkinformation.TcpStatistics;
import system.net.networkinformation.UdpStatistics;
import system.net.networkinformation.UnicastIPAddressInformationCollection;
import system.net.networkinformation.NetBiosNodeType;


/**
 * The base .NET class managing System.Net.NetworkInformation.IPGlobalProperties, System.Net.NetworkInformation, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.NetworkInformation.IPGlobalProperties" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.NetworkInformation.IPGlobalProperties</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class IPGlobalProperties extends NetObject  {
    /**
     * Fully assembly qualified name: System.Net.NetworkInformation, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Net.NetworkInformation, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Net.NetworkInformation
     */
    public static final String assemblyShortName = "System.Net.NetworkInformation";
    /**
     * Qualified class name: System.Net.NetworkInformation.IPGlobalProperties
     */
    public static final String className = "System.Net.NetworkInformation.IPGlobalProperties";
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
    public IPGlobalProperties(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IPGlobalProperties}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IPGlobalProperties} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IPGlobalProperties cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IPGlobalProperties(from.getJCOInstance());
    }

    // Constructors section
    
    public IPGlobalProperties() throws Throwable {
    }

    
    // Methods section
    
    public IAsyncResult BeginGetUnicastAddresses(AsyncCallback callback, NetObject state) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objBeginGetUnicastAddresses = (JCObject)classInstance.Invoke("BeginGetUnicastAddresses", callback, state == null ? null : state.getJCOInstance());
            return new IAsyncResultImplementation(objBeginGetUnicastAddresses);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPEndPoint[] GetActiveTcpListeners() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<IPEndPoint> resultingArrayList = new ArrayList<IPEndPoint>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetActiveTcpListeners");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IPEndPoint(resultingObject));
            }
            IPEndPoint[] resultingArray = new IPEndPoint[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPEndPoint[] GetActiveUdpListeners() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<IPEndPoint> resultingArrayList = new ArrayList<IPEndPoint>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetActiveUdpListeners");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IPEndPoint(resultingObject));
            }
            IPEndPoint[] resultingArray = new IPEndPoint[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IcmpV4Statistics GetIcmpV4Statistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetIcmpV4Statistics = (JCObject)classInstance.Invoke("GetIcmpV4Statistics");
            return new IcmpV4Statistics(objGetIcmpV4Statistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IcmpV6Statistics GetIcmpV6Statistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetIcmpV6Statistics = (JCObject)classInstance.Invoke("GetIcmpV6Statistics");
            return new IcmpV6Statistics(objGetIcmpV6Statistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPGlobalProperties GetIPGlobalProperties() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetIPGlobalProperties = (JCObject)classType.Invoke("GetIPGlobalProperties");
            return new IPGlobalProperties(objGetIPGlobalProperties);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPGlobalStatistics GetIPv4GlobalStatistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetIPv4GlobalStatistics = (JCObject)classInstance.Invoke("GetIPv4GlobalStatistics");
            return new IPGlobalStatistics(objGetIPv4GlobalStatistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPGlobalStatistics GetIPv6GlobalStatistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetIPv6GlobalStatistics = (JCObject)classInstance.Invoke("GetIPv6GlobalStatistics");
            return new IPGlobalStatistics(objGetIPv6GlobalStatistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TcpConnectionInformation[] GetActiveTcpConnections() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<TcpConnectionInformation> resultingArrayList = new ArrayList<TcpConnectionInformation>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetActiveTcpConnections");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new TcpConnectionInformation(resultingObject));
            }
            TcpConnectionInformation[] resultingArray = new TcpConnectionInformation[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TcpStatistics GetTcpIPv4Statistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetTcpIPv4Statistics = (JCObject)classInstance.Invoke("GetTcpIPv4Statistics");
            return new TcpStatistics(objGetTcpIPv4Statistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TcpStatistics GetTcpIPv6Statistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetTcpIPv6Statistics = (JCObject)classInstance.Invoke("GetTcpIPv6Statistics");
            return new TcpStatistics(objGetTcpIPv6Statistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UdpStatistics GetUdpIPv4Statistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetUdpIPv4Statistics = (JCObject)classInstance.Invoke("GetUdpIPv4Statistics");
            return new UdpStatistics(objGetUdpIPv4Statistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UdpStatistics GetUdpIPv6Statistics() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetUdpIPv6Statistics = (JCObject)classInstance.Invoke("GetUdpIPv6Statistics");
            return new UdpStatistics(objGetUdpIPv6Statistics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UnicastIPAddressInformationCollection EndGetUnicastAddresses(IAsyncResult asyncResult) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objEndGetUnicastAddresses = (JCObject)classInstance.Invoke("EndGetUnicastAddresses", asyncResult == null ? null : asyncResult.getJCOInstance());
            return new UnicastIPAddressInformationCollection(objEndGetUnicastAddresses);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UnicastIPAddressInformationCollection GetUnicastAddresses() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetUnicastAddresses = (JCObject)classInstance.Invoke("GetUnicastAddresses");
            return new UnicastIPAddressInformationCollection(objGetUnicastAddresses);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getIsWinsProxy() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsWinsProxy");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetBiosNodeType getNodeType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("NodeType");
            return new NetBiosNodeType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDhcpScopeName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DhcpScopeName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDomainName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DomainName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getHostName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("HostName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}