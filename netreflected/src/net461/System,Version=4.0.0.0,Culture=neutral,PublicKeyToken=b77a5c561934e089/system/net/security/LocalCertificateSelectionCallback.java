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

package system.net.security;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.cryptography.x509certificates.X509Certificate;
import system.security.cryptography.x509certificates.X509CertificateCollection;
import system.net.security.ILocalCertificateSelectionCallback;
/**
 * The base .NET class managing System.Net.Security.LocalCertificateSelectionCallback, System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link JCDelegate}. Implements {@link IJCEventEmit}, {@link IJCOBridgeReflected}
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.Security.LocalCertificateSelectionCallback" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.Security.LocalCertificateSelectionCallback</a>
 */
public class LocalCertificateSelectionCallback extends JCDelegate implements IJCEventEmit, IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System
     */
    public static final String assemblyShortName = "System";
    /**
     * Qualified class name: System.Net.Security.LocalCertificateSelectionCallback
     */
    public static final String className = "System.Net.Security.LocalCertificateSelectionCallback";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    JCObject classInstance = null;
    ILocalCertificateSelectionCallback callerInstance = null;

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

    public Object getJCOInstance() {
        return this;
    }

    public JCType getJCOType() {
        return classType;
    }

    public final Object EventRaised(Object... argsFromJCOBridge) {
        try
        {
            NetObject sender = argsFromJCOBridge[0] == null ? null : new NetObject(argsFromJCOBridge[0]);
            java.lang.String targetHost = argsFromJCOBridge[1] == null ? null : (java.lang.String)argsFromJCOBridge[1];
            X509CertificateCollection localCertificates = argsFromJCOBridge[2] == null ? null : new X509CertificateCollection(argsFromJCOBridge[2]);
            X509Certificate remoteCertificate = argsFromJCOBridge[3] == null ? null : new X509Certificate(argsFromJCOBridge[3]);
            java.lang.String[] acceptableIssuers = null;
            if (argsFromJCOBridge[4] != null) {
                ArrayList<Object> resultingArrayList4 = new ArrayList<Object>();
                JCObject resultingObjects = (JCObject)argsFromJCOBridge[4];
                for (Object resultingObject4 : resultingObjects) {
                    resultingArrayList4.add(resultingObject4);
                }
                acceptableIssuers = new java.lang.String[resultingArrayList4.size()];
		    	  for(int index4 = 0; index4 < resultingArrayList4.size(); index4++ ) {
	                  acceptableIssuers[index4] = (java.lang.String)resultingArrayList4.get(index4);
                }
            }



            X509Certificate retVal;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(sender, targetHost, localCertificates, remoteCertificate, acceptableIssuers);
            } else {
                retVal = Invoke(sender, targetHost, localCertificates, remoteCertificate, acceptableIssuers);
            }
            return (retVal == null) ? null : retVal.getJCOInstance();
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
			return null;
        }
    }

    public final Object DelegateInvoked(Object... argsFromJCOBridge) {
        try
        {
            NetObject sender = argsFromJCOBridge[0] == null ? null : new NetObject(argsFromJCOBridge[0]);
            java.lang.String targetHost = argsFromJCOBridge[1] == null ? null : (java.lang.String)argsFromJCOBridge[1];
            X509CertificateCollection localCertificates = argsFromJCOBridge[2] == null ? null : new X509CertificateCollection(argsFromJCOBridge[2]);
            X509Certificate remoteCertificate = argsFromJCOBridge[3] == null ? null : new X509Certificate(argsFromJCOBridge[3]);
            java.lang.String[] acceptableIssuers = null;
            if (argsFromJCOBridge[4] != null) {
                ArrayList<Object> resultingArrayList4 = new ArrayList<Object>();
                JCObject resultingObjects = (JCObject)argsFromJCOBridge[4];
                for (Object resultingObject4 : resultingObjects) {
                    resultingArrayList4.add(resultingObject4);
                }
                acceptableIssuers = new java.lang.String[resultingArrayList4.size()];
		    	  for(int index4 = 0; index4 < resultingArrayList4.size(); index4++ ) {
	                  acceptableIssuers[index4] = (java.lang.String)resultingArrayList4.get(index4);
                }
            }



            X509Certificate retVal;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(sender, targetHost, localCertificates, remoteCertificate, acceptableIssuers);
            } else {
                retVal = Invoke(sender, targetHost, localCertificates, remoteCertificate, acceptableIssuers);
            }
            return (retVal == null) ? null : retVal.getJCOInstance();
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
			return null;
        }
    }

    public LocalCertificateSelectionCallback() {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
    }

    public LocalCertificateSelectionCallback(ILocalCertificateSelectionCallback instance) {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        callerInstance = instance;
    }

    public LocalCertificateSelectionCallback(Object instance) throws Throwable {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        if (instance == null) throw new IllegalArgumentException("Instance cannot be null");
        if (instance instanceof ILocalCertificateSelectionCallback) {
            callerInstance = (ILocalCertificateSelectionCallback) instance;
        } else if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new UnsupportedOperationException(
                    String.format("Class %s is not supported.", instance.getClass().getTypeName()));
    }

    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    public X509Certificate DynamicInvoke(NetObject sender, java.lang.String targetHost, X509CertificateCollection localCertificates, X509Certificate remoteCertificate, java.lang.String[] acceptableIssuers) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDynamicInvoke = (JCObject)classInstance.Invoke("DynamicInvoke", sender == null ? null : sender.getJCOInstance(), targetHost, localCertificates == null ? null : localCertificates.getJCOInstance(), remoteCertificate == null ? null : remoteCertificate.getJCOInstance(), acceptableIssuers);
            return new X509Certificate(objDynamicInvoke);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * Methods invoked in JVM when an event is raised in CLR 
     */
    public X509Certificate Invoke(NetObject sender, java.lang.String targetHost, X509CertificateCollection localCertificates, X509Certificate remoteCertificate, java.lang.String[] acceptableIssuers) {
        return null;
    }
}