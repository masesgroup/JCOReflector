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

package system.management;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.management.ManagementOptions;
import system.security.SecureString;
import system.management.ImpersonationLevel;
import system.management.AuthenticationLevel;
import system.management.ManagementNamedValueCollection;
import system.TimeSpan;


/**
 * The base .NET class managing System.Management.ConnectionOptions, System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Management.ConnectionOptions" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Management.ConnectionOptions</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ConnectionOptions extends ManagementOptions  {
    /**
     * Fully assembly qualified name: System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Management
     */
    public static final String assemblyShortName = "System.Management";
    /**
     * Qualified class name: System.Management.ConnectionOptions
     */
    public static final String className = "System.Management.ConnectionOptions";
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
    public ConnectionOptions(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ConnectionOptions}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ConnectionOptions} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ConnectionOptions cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ConnectionOptions(from.getJCOInstance());
    }

    // Constructors section
    
    public ConnectionOptions() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.MulticastNotSupportedException, system.OutOfMemoryException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConnectionOptions(java.lang.String locale, java.lang.String username, SecureString password, java.lang.String authority, ImpersonationLevel impersonation, AuthenticationLevel authentication, boolean enablePrivileges, ManagementNamedValueCollection context, TimeSpan timeout) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.ArgumentException, system.MulticastNotSupportedException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(locale, username, password == null ? null : password.getJCOInstance(), authority, impersonation == null ? null : impersonation.getJCOInstance(), authentication == null ? null : authentication.getJCOInstance(), enablePrivileges, context == null ? null : context.getJCOInstance(), timeout == null ? null : timeout.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConnectionOptions(java.lang.String locale, java.lang.String username, java.lang.String password, java.lang.String authority, ImpersonationLevel impersonation, AuthenticationLevel authentication, boolean enablePrivileges, ManagementNamedValueCollection context, TimeSpan timeout) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.ArgumentException, system.MulticastNotSupportedException, system.OutOfMemoryException, system.security.cryptography.CryptographicException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(locale, username, password, authority, impersonation == null ? null : impersonation.getJCOInstance(), authentication == null ? null : authentication.getJCOInstance(), enablePrivileges, context == null ? null : context.getJCOInstance(), timeout == null ? null : timeout.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public NetObject Clone() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotSupportedException, system.OutOfMemoryException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objClone = (JCObject)classInstance.Invoke("Clone");
            return new NetObject(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getEnablePrivileges() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("EnablePrivileges");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEnablePrivileges(boolean EnablePrivileges) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EnablePrivileges", EnablePrivileges);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AuthenticationLevel getAuthentication() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Authentication");
            return new AuthenticationLevel(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAuthentication(AuthenticationLevel Authentication) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Authentication", Authentication == null ? null : Authentication.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ImpersonationLevel getImpersonation() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Impersonation");
            return new ImpersonationLevel(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setImpersonation(ImpersonationLevel Impersonation) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Impersonation", Impersonation == null ? null : Impersonation.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSecurePassword(SecureString SecurePassword) throws Throwable, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SecurePassword", SecurePassword == null ? null : SecurePassword.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getAuthority() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Authority");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAuthority(java.lang.String Authority) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Authority", Authority);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getLocale() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Locale");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLocale(java.lang.String Locale) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Locale", Locale);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPassword(java.lang.String Password) throws Throwable, system.NotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.OutOfMemoryException, system.ObjectDisposedException, system.ArgumentNullException, system.security.cryptography.CryptographicException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Password", Password);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getUsername() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Username");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setUsername(java.lang.String Username) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Username", Username);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}