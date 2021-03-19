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

package system.security;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.PermissionSet;
import system.security.policy.Evidence;
import system.security.policy.ApplicationTrust;
import system.security.policy.TrustManagerContext;
import system.reflection.Assembly;
import system.security.policy.EvidenceBase;
import system.security.HostSecurityManagerOptions;
import system.security.policy.PolicyLevel;


/**
 * The base .NET class managing System.Security.HostSecurityManager, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.HostSecurityManager" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.HostSecurityManager</a>
 */
public class HostSecurityManager extends NetObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Security.HostSecurityManager
     */
    public static final String className = "System.Security.HostSecurityManager";
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

    public HostSecurityManager(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HostSecurityManager}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HostSecurityManager} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HostSecurityManager cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HostSecurityManager(from.getJCOInstance());
    }

    // Constructors section
    
    public HostSecurityManager() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public PermissionSet ResolvePolicy(Evidence evidence) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.NullReferenceException, system.IndexOutOfRangeException, system.NotImplementedException, system.io.PathTooLongException, system.MemberAccessException, system.security.XmlSyntaxException, system.InvalidCastException, system.security.SecurityException, system.security.policy.PolicyException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objResolvePolicy = (JCObject)classInstance.Invoke("ResolvePolicy", evidence == null ? null : evidence.getJCOInstance());
            return new PermissionSet(objResolvePolicy);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ApplicationTrust DetermineApplicationTrust(Evidence applicationEvidence, Evidence activatorEvidence, TrustManagerContext context) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.NotSupportedException, system.NullReferenceException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.IndexOutOfRangeException, system.security.policy.PolicyException, system.OverflowException, system.RankException, system.NotImplementedException, system.MemberAccessException, system.reflection.TargetException, system.reflection.TargetParameterCountException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDetermineApplicationTrust = (JCObject)classInstance.Invoke("DetermineApplicationTrust", applicationEvidence == null ? null : applicationEvidence.getJCOInstance(), activatorEvidence == null ? null : activatorEvidence.getJCOInstance(), context == null ? null : context.getJCOInstance());
            return new ApplicationTrust(objDetermineApplicationTrust);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Evidence ProvideAppDomainEvidence(Evidence inputEvidence) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProvideAppDomainEvidence = (JCObject)classInstance.Invoke("ProvideAppDomainEvidence", inputEvidence == null ? null : inputEvidence.getJCOInstance());
            return new Evidence(objProvideAppDomainEvidence);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Evidence ProvideAssemblyEvidence(Assembly loadedAssembly, Evidence inputEvidence) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProvideAssemblyEvidence = (JCObject)classInstance.Invoke("ProvideAssemblyEvidence", loadedAssembly == null ? null : loadedAssembly.getJCOInstance(), inputEvidence == null ? null : inputEvidence.getJCOInstance());
            return new Evidence(objProvideAssemblyEvidence);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EvidenceBase GenerateAppDomainEvidence(NetType evidenceType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGenerateAppDomainEvidence = (JCObject)classInstance.Invoke("GenerateAppDomainEvidence", evidenceType == null ? null : evidenceType.getJCOInstance());
            return new EvidenceBase(objGenerateAppDomainEvidence);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EvidenceBase GenerateAssemblyEvidence(NetType evidenceType, Assembly assembly) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGenerateAssemblyEvidence = (JCObject)classInstance.Invoke("GenerateAssemblyEvidence", evidenceType == null ? null : evidenceType.getJCOInstance(), assembly == null ? null : assembly.getJCOInstance());
            return new EvidenceBase(objGenerateAssemblyEvidence);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType[] GetHostSuppliedAppDomainEvidenceTypes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetType> resultingArrayList = new ArrayList<NetType>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetHostSuppliedAppDomainEvidenceTypes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetType(resultingObject));
            }
            NetType[] resultingArray = new NetType[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType[] GetHostSuppliedAssemblyEvidenceTypes(Assembly assembly) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetType> resultingArrayList = new ArrayList<NetType>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetHostSuppliedAssemblyEvidenceTypes", assembly == null ? null : assembly.getJCOInstance());
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetType(resultingObject));
            }
            NetType[] resultingArray = new NetType[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public HostSecurityManagerOptions getFlags() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Flags");
            return new HostSecurityManagerOptions(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PolicyLevel getDomainPolicy() throws Throwable, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DomainPolicy");
            return new PolicyLevel(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}