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

package system.directoryservices.protocols;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.directoryservices.protocols.LdapConnection;
import system.directoryservices.protocols.LdapDirectoryIdentifier;
import system.net.NetworkCredential;
import system.directoryservices.protocols.INotifyOfNewConnectionCallback;

/**
 * The base .NET class managing System.DirectoryServices.Protocols.NotifyOfNewConnectionCallback, System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link JCDelegate}.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.Protocols.NotifyOfNewConnectionCallback" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.Protocols.NotifyOfNewConnectionCallback</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class NotifyOfNewConnectionCallback extends JCDelegate implements IJCEventEmit, IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.DirectoryServices.Protocols
     */
    public static final String assemblyShortName = "System.DirectoryServices.Protocols";
    /**
     * Qualified class name: System.DirectoryServices.Protocols.NotifyOfNewConnectionCallback
     */
    public static final String className = "System.DirectoryServices.Protocols.NotifyOfNewConnectionCallback";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    JCObject classInstance = null;
    INotifyOfNewConnectionCallback callerInstance = null;

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
        return this;
    }

    public JCType getJCOType() {
        return classType;
    }

    public final java.lang.Object EventRaised(java.lang.Object... argsFromJCOBridge) {
        try
        {
            LdapConnection primaryConnection = argsFromJCOBridge[0] == null ? null : new LdapConnection(argsFromJCOBridge[0]);
            LdapConnection referralFromConnection = argsFromJCOBridge[1] == null ? null : new LdapConnection(argsFromJCOBridge[1]);
            java.lang.String newDistinguishedName = argsFromJCOBridge[2] == null ? null : (java.lang.String)argsFromJCOBridge[2];
            LdapDirectoryIdentifier identifier = argsFromJCOBridge[3] == null ? null : new LdapDirectoryIdentifier(argsFromJCOBridge[3]);
            LdapConnection newConnection = argsFromJCOBridge[4] == null ? null : new LdapConnection(argsFromJCOBridge[4]);
            NetworkCredential credential = argsFromJCOBridge[5] == null ? null : new NetworkCredential(argsFromJCOBridge[5]);
            long currentUserToken = argsFromJCOBridge[6] == null ? null : (long)argsFromJCOBridge[6];
            int errorCodeFromBind = argsFromJCOBridge[7] == null ? null : (int)argsFromJCOBridge[7];


            java.lang.Object retVal = null;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(primaryConnection, referralFromConnection, newDistinguishedName, identifier, newConnection, credential, currentUserToken, errorCodeFromBind);
            } else {
                retVal = Invoke(primaryConnection, referralFromConnection, newDistinguishedName, identifier, newConnection, credential, currentUserToken, errorCodeFromBind);
            }
            return retVal;
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
            return false;
        }
    }

    public final java.lang.Object DelegateInvoked(java.lang.Object... argsFromJCOBridge) {
        try
        {
            LdapConnection primaryConnection = argsFromJCOBridge[0] == null ? null : new LdapConnection(argsFromJCOBridge[0]);
            LdapConnection referralFromConnection = argsFromJCOBridge[1] == null ? null : new LdapConnection(argsFromJCOBridge[1]);
            java.lang.String newDistinguishedName = argsFromJCOBridge[2] == null ? null : (java.lang.String)argsFromJCOBridge[2];
            LdapDirectoryIdentifier identifier = argsFromJCOBridge[3] == null ? null : new LdapDirectoryIdentifier(argsFromJCOBridge[3]);
            LdapConnection newConnection = argsFromJCOBridge[4] == null ? null : new LdapConnection(argsFromJCOBridge[4]);
            NetworkCredential credential = argsFromJCOBridge[5] == null ? null : new NetworkCredential(argsFromJCOBridge[5]);
            long currentUserToken = argsFromJCOBridge[6] == null ? null : (long)argsFromJCOBridge[6];
            int errorCodeFromBind = argsFromJCOBridge[7] == null ? null : (int)argsFromJCOBridge[7];


            java.lang.Object retVal = null;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(primaryConnection, referralFromConnection, newDistinguishedName, identifier, newConnection, credential, currentUserToken, errorCodeFromBind);
            } else {
                retVal = Invoke(primaryConnection, referralFromConnection, newDistinguishedName, identifier, newConnection, credential, currentUserToken, errorCodeFromBind);
            }
            return retVal;
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
            return false;
        }
    }

    public NotifyOfNewConnectionCallback() {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
    }

    public NotifyOfNewConnectionCallback(INotifyOfNewConnectionCallback instance) {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        callerInstance = instance;
    }
    /**
     * Internal constructor. Use with caution 
     */
    public NotifyOfNewConnectionCallback(java.lang.Object instance) throws Throwable {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        if (instance == null) throw new IllegalArgumentException("Instance cannot be null");
        if (instance instanceof INotifyOfNewConnectionCallback) {
            callerInstance = (INotifyOfNewConnectionCallback) instance;
        } else if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new UnsupportedOperationException(
                    String.format("Class %s is not supported.", instance.getClass().getTypeName()));
    }

    protected final static <T extends IJCOBridgeReflected> java.lang.Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    public boolean DynamicInvoke(LdapConnection primaryConnection, LdapConnection referralFromConnection, java.lang.String newDistinguishedName, LdapDirectoryIdentifier identifier, LdapConnection newConnection, NetworkCredential credential, long currentUserToken, int errorCodeFromBind) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("DynamicInvoke", primaryConnection == null ? null : primaryConnection.getJCOInstance(), referralFromConnection == null ? null : referralFromConnection.getJCOInstance(), newDistinguishedName, identifier == null ? null : identifier.getJCOInstance(), newConnection == null ? null : newConnection.getJCOInstance(), credential == null ? null : credential.getJCOInstance(), currentUserToken, errorCodeFromBind);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * Methods invoked in JVM when an event is raised in CLR 
     */
    public boolean Invoke(LdapConnection primaryConnection, LdapConnection referralFromConnection, java.lang.String newDistinguishedName, LdapDirectoryIdentifier identifier, LdapConnection newConnection, NetworkCredential credential, long currentUserToken, int errorCodeFromBind) {
        return false;
    }
}