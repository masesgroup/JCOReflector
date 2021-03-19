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

package system.runtime.remoting;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.runtime.remoting.ActivatedClientTypeEntry;
import system.runtime.remoting.ActivatedServiceTypeEntry;
import system.runtime.remoting.WellKnownClientTypeEntry;
import system.runtime.remoting.WellKnownServiceTypeEntry;
import system.runtime.remoting.WellKnownObjectMode;
import system.runtime.remoting.CustomErrorsModes;


/**
 * The base .NET class managing System.Runtime.Remoting.RemotingConfiguration, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Remoting.RemotingConfiguration" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Remoting.RemotingConfiguration</a>
 */
public class RemotingConfiguration extends NetObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Runtime.Remoting.RemotingConfiguration
     */
    public static final String className = "System.Runtime.Remoting.RemotingConfiguration";
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

    public RemotingConfiguration(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link RemotingConfiguration}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link RemotingConfiguration} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static RemotingConfiguration cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new RemotingConfiguration(from.getJCOInstance());
    }

    // Constructors section
    
    public RemotingConfiguration() throws Throwable {
    }

    
    // Methods section
    
    public static boolean CustomErrorsEnabled(boolean isLocalRequest) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("CustomErrorsEnabled", isLocalRequest);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsActivationAllowed(NetType svrType) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsActivationAllowed", svrType == null ? null : svrType.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ActivatedClientTypeEntry IsRemotelyActivatedClientType(java.lang.String typeName, java.lang.String assemblyName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.runtime.remoting.RemotingException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objIsRemotelyActivatedClientType = (JCObject)classType.Invoke("IsRemotelyActivatedClientType", typeName, assemblyName);
            return new ActivatedClientTypeEntry(objIsRemotelyActivatedClientType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ActivatedClientTypeEntry IsRemotelyActivatedClientType(NetType svrType) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.runtime.remoting.RemotingException, system.NotImplementedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objIsRemotelyActivatedClientType = (JCObject)classType.Invoke("IsRemotelyActivatedClientType", svrType == null ? null : svrType.getJCOInstance());
            return new ActivatedClientTypeEntry(objIsRemotelyActivatedClientType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ActivatedClientTypeEntry[] GetRegisteredActivatedClientTypes() throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<ActivatedClientTypeEntry> resultingArrayList = new ArrayList<ActivatedClientTypeEntry>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetRegisteredActivatedClientTypes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ActivatedClientTypeEntry(resultingObject));
            }
            ActivatedClientTypeEntry[] resultingArray = new ActivatedClientTypeEntry[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ActivatedServiceTypeEntry[] GetRegisteredActivatedServiceTypes() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<ActivatedServiceTypeEntry> resultingArrayList = new ArrayList<ActivatedServiceTypeEntry>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetRegisteredActivatedServiceTypes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ActivatedServiceTypeEntry(resultingObject));
            }
            ActivatedServiceTypeEntry[] resultingArray = new ActivatedServiceTypeEntry[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WellKnownClientTypeEntry IsWellKnownClientType(java.lang.String typeName, java.lang.String assemblyName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objIsWellKnownClientType = (JCObject)classType.Invoke("IsWellKnownClientType", typeName, assemblyName);
            return new WellKnownClientTypeEntry(objIsWellKnownClientType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WellKnownClientTypeEntry IsWellKnownClientType(NetType svrType) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objIsWellKnownClientType = (JCObject)classType.Invoke("IsWellKnownClientType", svrType == null ? null : svrType.getJCOInstance());
            return new WellKnownClientTypeEntry(objIsWellKnownClientType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WellKnownClientTypeEntry[] GetRegisteredWellKnownClientTypes() throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<WellKnownClientTypeEntry> resultingArrayList = new ArrayList<WellKnownClientTypeEntry>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetRegisteredWellKnownClientTypes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new WellKnownClientTypeEntry(resultingObject));
            }
            WellKnownClientTypeEntry[] resultingArray = new WellKnownClientTypeEntry[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static WellKnownServiceTypeEntry[] GetRegisteredWellKnownServiceTypes() throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<WellKnownServiceTypeEntry> resultingArrayList = new ArrayList<WellKnownServiceTypeEntry>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetRegisteredWellKnownServiceTypes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new WellKnownServiceTypeEntry(resultingObject));
            }
            WellKnownServiceTypeEntry[] resultingArray = new WellKnownServiceTypeEntry[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Configure(java.lang.String filename) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentNullException, system.FormatException, system.runtime.remoting.RemotingException, system.NullReferenceException, system.NotSupportedException, system.security.SecurityException, system.NotImplementedException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ApplicationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Configure", filename);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Configure(java.lang.String filename, boolean ensureSecurity) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentNullException, system.FormatException, system.runtime.remoting.RemotingException, system.NullReferenceException, system.OverflowException, system.IndexOutOfRangeException, system.NotSupportedException, system.security.SecurityException, system.MissingMethodException, system.NotImplementedException, system.ApplicationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Configure", filename, ensureSecurity);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterActivatedClientType(ActivatedClientTypeEntry entry) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ArgumentException, system.FormatException, system.runtime.remoting.RemotingException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterActivatedClientType", entry == null ? null : entry.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterActivatedClientType(NetType type, java.lang.String appUrl) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.FormatException, system.runtime.remoting.RemotingException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterActivatedClientType", type == null ? null : type.getJCOInstance(), appUrl);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterActivatedServiceType(ActivatedServiceTypeEntry entry) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ArgumentException, system.FormatException, system.runtime.remoting.RemotingException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterActivatedServiceType", entry == null ? null : entry.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterActivatedServiceType(NetType type) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.FormatException, system.runtime.remoting.RemotingException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterActivatedServiceType", type == null ? null : type.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterWellKnownClientType(WellKnownClientTypeEntry entry) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ArgumentException, system.FormatException, system.runtime.remoting.RemotingException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterWellKnownClientType", entry == null ? null : entry.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterWellKnownClientType(NetType type, java.lang.String objectUrl) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.FormatException, system.runtime.remoting.RemotingException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterWellKnownClientType", type == null ? null : type.getJCOInstance(), objectUrl);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterWellKnownServiceType(WellKnownServiceTypeEntry entry) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.FormatException, system.runtime.remoting.RemotingException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterWellKnownServiceType", entry == null ? null : entry.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterWellKnownServiceType(NetType type, java.lang.String objectUri, WellKnownObjectMode mode) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.FormatException, system.runtime.remoting.RemotingException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterWellKnownServiceType", type == null ? null : type.getJCOInstance(), objectUri, mode == null ? null : mode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static CustomErrorsModes getCustomErrorsMode() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("CustomErrorsMode");
            return new CustomErrorsModes(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setCustomErrorsMode(CustomErrorsModes CustomErrorsMode) throws Throwable, system.runtime.remoting.RemotingException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("CustomErrorsMode", CustomErrorsMode == null ? null : CustomErrorsMode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String getApplicationId() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Get("ApplicationId");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String getApplicationName() throws Throwable, system.runtime.remoting.RemotingException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Get("ApplicationName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setApplicationName(java.lang.String ApplicationName) throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.runtime.remoting.RemotingException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("ApplicationName", ApplicationName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String getProcessId() throws Throwable, system.ArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Get("ProcessId");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}