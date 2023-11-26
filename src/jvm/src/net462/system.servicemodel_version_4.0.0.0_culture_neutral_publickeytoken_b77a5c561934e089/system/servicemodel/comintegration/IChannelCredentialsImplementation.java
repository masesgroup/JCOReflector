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

package system.servicemodel.comintegration;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section


/**
 * The base .NET class managing System.ServiceModel.ComIntegration.IChannelCredentials, System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.ComIntegration.IChannelCredentials" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.ComIntegration.IChannelCredentials</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class IChannelCredentialsImplementation extends NetObject implements IChannelCredentials {
    /**
     * Fully assembly qualified name: System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.ServiceModel
     */
    public static final String assemblyShortName = "System.ServiceModel";
    /**
     * Qualified class name: System.ServiceModel.ComIntegration.IChannelCredentials
     */
    public static final String className = "System.ServiceModel.ComIntegration.IChannelCredentials";
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
    public IChannelCredentialsImplementation(java.lang.Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IChannelCredentials}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IChannelCredentials} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IChannelCredentials ToIChannelCredentials(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IChannelCredentialsImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public void SetClientCertificateFromFile(java.lang.String fileName, java.lang.String password, java.lang.String keyStorageFlags) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetClientCertificateFromFile", fileName, password, keyStorageFlags);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetClientCertificateFromStore(java.lang.String storeLocation, java.lang.String storeName, java.lang.String findType, NetObject findValue) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetClientCertificateFromStore", storeLocation, storeName, findType, findValue == null ? null : findValue.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetClientCertificateFromStoreByName(java.lang.String subjectName, java.lang.String storeLocation, java.lang.String storeName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetClientCertificateFromStoreByName", subjectName, storeLocation, storeName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetDefaultServiceCertificateFromFile(java.lang.String fileName, java.lang.String password, java.lang.String keyStorageFlags) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetDefaultServiceCertificateFromFile", fileName, password, keyStorageFlags);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetDefaultServiceCertificateFromStore(java.lang.String storeLocation, java.lang.String storeName, java.lang.String findType, NetObject findValue) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetDefaultServiceCertificateFromStore", storeLocation, storeName, findType, findValue == null ? null : findValue.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetDefaultServiceCertificateFromStoreByName(java.lang.String subjectName, java.lang.String storeLocation, java.lang.String storeName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetDefaultServiceCertificateFromStoreByName", subjectName, storeLocation, storeName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetIssuedToken(java.lang.String localIssuerAddres, java.lang.String localIssuerBindingType, java.lang.String localIssuerBinding) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetIssuedToken", localIssuerAddres, localIssuerBindingType, localIssuerBinding);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetServiceCertificateAuthentication(java.lang.String storeLocation, java.lang.String revocationMode, java.lang.String certificationValidationMode) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetServiceCertificateAuthentication", storeLocation, revocationMode, certificationValidationMode);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetUserNameCredential(java.lang.String userName, java.lang.String password) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetUserNameCredential", userName, password);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetWindowsCredential(java.lang.String domain, java.lang.String userName, java.lang.String password, int impersonationLevel, boolean allowNtlm) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetWindowsCredential", domain, userName, password, impersonationLevel, allowNtlm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}