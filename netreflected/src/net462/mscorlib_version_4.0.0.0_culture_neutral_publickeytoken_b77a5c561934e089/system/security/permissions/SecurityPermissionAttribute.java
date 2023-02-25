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

package system.security.permissions;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.permissions.CodeAccessSecurityAttribute;
import system.security.permissions.SecurityAction;
import system.security.IPermission;
import system.security.IPermissionImplementation;
import system.security.permissions.SecurityPermissionFlag;


/**
 * The base .NET class managing System.Security.Permissions.SecurityPermissionAttribute, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Permissions.SecurityPermissionAttribute" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Permissions.SecurityPermissionAttribute</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class SecurityPermissionAttribute extends CodeAccessSecurityAttribute  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Security.Permissions.SecurityPermissionAttribute
     */
    public static final String className = "System.Security.Permissions.SecurityPermissionAttribute";
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
    public SecurityPermissionAttribute(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SecurityPermissionAttribute}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SecurityPermissionAttribute} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SecurityPermissionAttribute cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SecurityPermissionAttribute(from.getJCOInstance());
    }

    // Constructors section
    
    public SecurityPermissionAttribute() throws Throwable {
    }

    public SecurityPermissionAttribute(SecurityAction action) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(action == null ? null : action.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public IPermission CreatePermission() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreatePermission = (JCObject)classInstance.Invoke("CreatePermission");
            return new IPermissionImplementation(objCreatePermission);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAssertion() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Assertion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAssertion(boolean Assertion) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Assertion", Assertion);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getBindingRedirects() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("BindingRedirects");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setBindingRedirects(boolean BindingRedirects) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("BindingRedirects", BindingRedirects);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getControlAppDomain() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ControlAppDomain");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setControlAppDomain(boolean ControlAppDomain) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ControlAppDomain", ControlAppDomain);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getControlDomainPolicy() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ControlDomainPolicy");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setControlDomainPolicy(boolean ControlDomainPolicy) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ControlDomainPolicy", ControlDomainPolicy);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getControlEvidence() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ControlEvidence");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setControlEvidence(boolean ControlEvidence) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ControlEvidence", ControlEvidence);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getControlPolicy() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ControlPolicy");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setControlPolicy(boolean ControlPolicy) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ControlPolicy", ControlPolicy);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getControlPrincipal() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ControlPrincipal");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setControlPrincipal(boolean ControlPrincipal) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ControlPrincipal", ControlPrincipal);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getControlThread() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ControlThread");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setControlThread(boolean ControlThread) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ControlThread", ControlThread);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getExecution() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Execution");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExecution(boolean Execution) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Execution", Execution);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getInfrastructure() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Infrastructure");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInfrastructure(boolean Infrastructure) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Infrastructure", Infrastructure);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getRemotingConfiguration() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("RemotingConfiguration");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRemotingConfiguration(boolean RemotingConfiguration) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("RemotingConfiguration", RemotingConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSerializationFormatter() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SerializationFormatter");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSerializationFormatter(boolean SerializationFormatter) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SerializationFormatter", SerializationFormatter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSkipVerification() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SkipVerification");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSkipVerification(boolean SkipVerification) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SkipVerification", SkipVerification);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getUnmanagedCode() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("UnmanagedCode");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setUnmanagedCode(boolean UnmanagedCode) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("UnmanagedCode", UnmanagedCode);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityPermissionFlag getFlags() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Flags");
            return new SecurityPermissionFlag(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFlags(SecurityPermissionFlag Flags) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Flags", Flags == null ? null : Flags.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}