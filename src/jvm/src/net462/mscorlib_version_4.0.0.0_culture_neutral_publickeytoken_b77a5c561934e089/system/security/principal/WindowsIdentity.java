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

package system.security.principal;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.claims.ClaimsIdentity;
import system.runtime.serialization.SerializationInfo;
import system.runtime.serialization.StreamingContext;
import system.security.principal.WindowsIdentity;
import system.security.principal.TokenAccessLevels;
import system.security.principal.WindowsImpersonationContext;
import microsoft.win32.safehandles.SafeAccessTokenHandle;
import system.Action;
import system.security.principal.IdentityReferenceCollection;
import system.security.principal.SecurityIdentifier;
import system.security.principal.TokenImpersonationLevel;
import system.runtime.serialization.ISerializable;
import system.runtime.serialization.ISerializableImplementation;
import system.runtime.serialization.IDeserializationCallback;
import system.runtime.serialization.IDeserializationCallbackImplementation;


/**
 * The base .NET class managing System.Security.Principal.WindowsIdentity, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Principal.WindowsIdentity" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Principal.WindowsIdentity</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class WindowsIdentity extends ClaimsIdentity implements system.runtime.serialization.ISerializable, system.runtime.serialization.IDeserializationCallback, AutoCloseable {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Security.Principal.WindowsIdentity
     */
    public static final String className = "System.Security.Principal.WindowsIdentity";
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
    public WindowsIdentity(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link WindowsIdentity}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link WindowsIdentity} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static WindowsIdentity cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new WindowsIdentity(from.getJCOInstance());
    }

    // Constructors section
    
    public WindowsIdentity() throws Throwable {
    }

    public WindowsIdentity(SerializationInfo info, StreamingContext context) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.FormatException, system.runtime.serialization.SerializationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(info == null ? null : info.getJCOInstance(), context == null ? null : context.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WindowsIdentity(java.lang.String sUserPrincipalName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.UnauthorizedAccessException, system.FormatException, system.security.accesscontrol.PrivilegeNotHeldException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(sUserPrincipalName));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WindowsIdentity(java.lang.String sUserPrincipalName, java.lang.String type) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.UnauthorizedAccessException, system.FormatException, system.security.accesscontrol.PrivilegeNotHeldException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(sUserPrincipalName, type));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public ClaimsIdentity Clone() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.FormatException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objClone = (JCObject)classInstance.Invoke("Clone");
            return new ClaimsIdentity(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WindowsIdentity GetAnonymous() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetAnonymous = (JCObject)classType.Invoke("GetAnonymous");
            return new WindowsIdentity(objGetAnonymous);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WindowsIdentity GetCurrent() throws Throwable, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentNullException, system.security.SecurityException, system.ArgumentException, system.InvalidOperationException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetCurrent = (JCObject)classType.Invoke("GetCurrent");
            return new WindowsIdentity(objGetCurrent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WindowsIdentity GetCurrent(boolean ifImpersonating) throws Throwable, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentNullException, system.security.SecurityException, system.ArgumentException, system.InvalidOperationException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetCurrent = (JCObject)classType.Invoke("GetCurrent", ifImpersonating);
            return new WindowsIdentity(objGetCurrent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WindowsIdentity GetCurrent(TokenAccessLevels desiredAccess) throws Throwable, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentNullException, system.security.SecurityException, system.ArgumentException, system.InvalidOperationException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetCurrent = (JCObject)classType.Invoke("GetCurrent", desiredAccess == null ? null : desiredAccess.getJCOInstance());
            return new WindowsIdentity(objGetCurrent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WindowsImpersonationContext Impersonate() throws Throwable, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentNullException, system.security.SecurityException, system.ArgumentException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objImpersonate = (JCObject)classInstance.Invoke("Impersonate");
            return new WindowsImpersonationContext(objImpersonate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RunImpersonated(SafeAccessTokenHandle safeAccessTokenHandle, Action action) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.security.SecurityException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RunImpersonated", safeAccessTokenHandle == null ? null : safeAccessTokenHandle.getJCOInstance(), action);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToISerializable method available in ISerializable to obtain an object with an invocable method
     */
    @Deprecated 
    public void GetObjectData(SerializationInfo info, StreamingContext context) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToISerializable to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIDeserializationCallback method available in IDeserializationCallback to obtain an object with an invocable method
     */
    @Deprecated 
    public void OnDeserialization(NetObject sender) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIDeserializationCallback to obtain the full interface.");
    }

    public void close() throws Exception {
        try {
            if (classInstance == null)
                throw new UnsupportedOperationException("classInstance is null.");
            try {
                classInstance.Invoke("Dispose");
            }
            catch (JCNativeException jcne) {
                throw translateException(jcne);
            }
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }
    
    // Properties section
    
    public boolean getIsAnonymous() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.OutOfMemoryException, system.security.SecurityException, system.AccessViolationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsAnonymous");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsGuest() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.OutOfMemoryException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsGuest");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsSystem() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.OutOfMemoryException, system.security.SecurityException, system.AccessViolationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsSystem");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SafeAccessTokenHandle getAccessToken() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("AccessToken");
            return new SafeAccessTokenHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IdentityReferenceCollection getGroups() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.OutOfMemoryException, system.security.SecurityException, system.AccessViolationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Groups");
            return new IdentityReferenceCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityIdentifier getOwner() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.security.SecurityException, system.AccessViolationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Owner");
            return new SecurityIdentifier(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityIdentifier getUser() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.security.SecurityException, system.AccessViolationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("User");
            return new SecurityIdentifier(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TokenImpersonationLevel getImpersonationLevel() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ImpersonationLevel");
            return new TokenImpersonationLevel(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}