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
import system.security.cryptography.x509certificates.X509Certificate;
import system.directoryservices.protocols.IVerifyServerCertificateCallback;

/**
 * The base .NET class managing System.DirectoryServices.Protocols.VerifyServerCertificateCallback, System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link JCDelegate}.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.Protocols.VerifyServerCertificateCallback" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.Protocols.VerifyServerCertificateCallback</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class VerifyServerCertificateCallback extends JCDelegate implements IJCEventEmit, IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.DirectoryServices.Protocols
     */
    public static final String assemblyShortName = "System.DirectoryServices.Protocols";
    /**
     * Qualified class name: System.DirectoryServices.Protocols.VerifyServerCertificateCallback
     */
    public static final String className = "System.DirectoryServices.Protocols.VerifyServerCertificateCallback";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    JCObject classInstance = null;
    IVerifyServerCertificateCallback callerInstance = null;

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
            LdapConnection connection = argsFromJCOBridge[0] == null ? null : new LdapConnection(argsFromJCOBridge[0]);
            X509Certificate certificate = argsFromJCOBridge[1] == null ? null : new X509Certificate(argsFromJCOBridge[1]);


            java.lang.Object retVal = null;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(connection, certificate);
            } else {
                retVal = Invoke(connection, certificate);
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
            LdapConnection connection = argsFromJCOBridge[0] == null ? null : new LdapConnection(argsFromJCOBridge[0]);
            X509Certificate certificate = argsFromJCOBridge[1] == null ? null : new X509Certificate(argsFromJCOBridge[1]);


            java.lang.Object retVal = null;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(connection, certificate);
            } else {
                retVal = Invoke(connection, certificate);
            }
            return retVal;
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
            return false;
        }
    }

    public VerifyServerCertificateCallback() {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
    }

    public VerifyServerCertificateCallback(IVerifyServerCertificateCallback instance) {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        callerInstance = instance;
    }
    /**
     * Internal constructor. Use with caution 
     */
    public VerifyServerCertificateCallback(java.lang.Object instance) throws Throwable {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        if (instance == null) throw new IllegalArgumentException("Instance cannot be null");
        if (instance instanceof IVerifyServerCertificateCallback) {
            callerInstance = (IVerifyServerCertificateCallback) instance;
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

    public boolean DynamicInvoke(LdapConnection connection, X509Certificate certificate) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("DynamicInvoke", connection == null ? null : connection.getJCOInstance(), certificate == null ? null : certificate.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * Methods invoked in JVM when an event is raised in CLR 
     */
    public boolean Invoke(LdapConnection connection, X509Certificate certificate) {
        return false;
    }
}