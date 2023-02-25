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


/**
 * The base .NET class managing System.Net.NetworkInformation.IcmpV6Statistics, System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.NetworkInformation.IcmpV6Statistics" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.NetworkInformation.IcmpV6Statistics</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class IcmpV6Statistics extends NetObject  {
    /**
     * Fully assembly qualified name: System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System
     */
    public static final String assemblyShortName = "System";
    /**
     * Qualified class name: System.Net.NetworkInformation.IcmpV6Statistics
     */
    public static final String className = "System.Net.NetworkInformation.IcmpV6Statistics";
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
    public IcmpV6Statistics(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IcmpV6Statistics}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IcmpV6Statistics} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IcmpV6Statistics cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IcmpV6Statistics(from.getJCOInstance());
    }

    // Constructors section
    
    public IcmpV6Statistics() throws Throwable {
    }

    
    // Methods section
    

    
    // Properties section
    
    public long getDestinationUnreachableMessagesReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("DestinationUnreachableMessagesReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getDestinationUnreachableMessagesSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("DestinationUnreachableMessagesSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getEchoRepliesReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("EchoRepliesReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getEchoRepliesSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("EchoRepliesSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getEchoRequestsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("EchoRequestsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getEchoRequestsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("EchoRequestsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getErrorsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("ErrorsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getErrorsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("ErrorsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMembershipQueriesReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MembershipQueriesReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMembershipQueriesSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MembershipQueriesSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMembershipReductionsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MembershipReductionsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMembershipReductionsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MembershipReductionsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMembershipReportsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MembershipReportsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMembershipReportsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MembershipReportsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMessagesReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MessagesReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMessagesSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MessagesSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getNeighborAdvertisementsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("NeighborAdvertisementsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getNeighborAdvertisementsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("NeighborAdvertisementsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getNeighborSolicitsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("NeighborSolicitsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getNeighborSolicitsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("NeighborSolicitsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getPacketTooBigMessagesReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("PacketTooBigMessagesReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getPacketTooBigMessagesSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("PacketTooBigMessagesSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getParameterProblemsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("ParameterProblemsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getParameterProblemsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("ParameterProblemsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getRedirectsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("RedirectsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getRedirectsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("RedirectsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getRouterAdvertisementsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("RouterAdvertisementsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getRouterAdvertisementsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("RouterAdvertisementsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getRouterSolicitsReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("RouterSolicitsReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getRouterSolicitsSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("RouterSolicitsSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getTimeExceededMessagesReceived() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("TimeExceededMessagesReceived");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getTimeExceededMessagesSent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("TimeExceededMessagesSent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}