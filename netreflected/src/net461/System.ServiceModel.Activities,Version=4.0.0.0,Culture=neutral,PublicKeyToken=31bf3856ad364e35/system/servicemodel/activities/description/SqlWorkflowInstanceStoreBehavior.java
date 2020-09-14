/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

package system.servicemodel.activities.description;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.servicemodel.description.ServiceDescription;
import system.servicemodel.ServiceHostBase;
import system.activities.durableinstancing.InstanceCompletionAction;
import system.activities.durableinstancing.InstanceEncodingOption;
import system.activities.durableinstancing.InstanceLockedExceptionAction;
import system.TimeSpan;


/**
 * The base .NET class managing System.ServiceModel.Activities.Description.SqlWorkflowInstanceStoreBehavior, System.ServiceModel.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.Activities.Description.SqlWorkflowInstanceStoreBehavior" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.Activities.Description.SqlWorkflowInstanceStoreBehavior</a>
 */
public class SqlWorkflowInstanceStoreBehavior extends NetObject  {
    /**
     * Fully assembly qualified name: System.ServiceModel.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.ServiceModel.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.ServiceModel.Activities
     */
    public static final String assemblyShortName = "System.ServiceModel.Activities";
    /**
     * Qualified class name: System.ServiceModel.Activities.Description.SqlWorkflowInstanceStoreBehavior
     */
    public static final String className = "System.ServiceModel.Activities.Description.SqlWorkflowInstanceStoreBehavior";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
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

    public SqlWorkflowInstanceStoreBehavior(Object instance) throws Throwable {
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
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SqlWorkflowInstanceStoreBehavior}, a cast assert is made to check if types are compatible.
     */
    public static SqlWorkflowInstanceStoreBehavior cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SqlWorkflowInstanceStoreBehavior(from.getJCOInstance());
    }

    // Constructors section
    
    public SqlWorkflowInstanceStoreBehavior() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.runtime.durableinstancing.InstancePersistenceCommandException, system.configuration.ConfigurationErrorsException, system.OverflowException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SqlWorkflowInstanceStoreBehavior(java.lang.String connectionString) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.runtime.durableinstancing.InstancePersistenceCommandException, system.threading.WaitHandleCannotBeOpenedException, system.OverflowException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(connectionString));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public void ApplyDispatchBehavior(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ApplyDispatchBehavior", serviceDescription == null ? null : serviceDescription.getJCOInstance(), serviceHostBase == null ? null : serviceHostBase.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Validate(ServiceDescription serviceDescription, ServiceHostBase serviceHostBase) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Validate", serviceDescription == null ? null : serviceDescription.getJCOInstance(), serviceHostBase == null ? null : serviceHostBase.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getMaxConnectionRetries() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("MaxConnectionRetries");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setMaxConnectionRetries(int MaxConnectionRetries) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("MaxConnectionRetries", MaxConnectionRetries);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public InstanceCompletionAction getInstanceCompletionAction() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InstanceCompletionAction");
            return new InstanceCompletionAction(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInstanceCompletionAction(InstanceCompletionAction InstanceCompletionAction) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InstanceCompletionAction", InstanceCompletionAction == null ? null : InstanceCompletionAction.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public InstanceEncodingOption getInstanceEncodingOption() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InstanceEncodingOption");
            return new InstanceEncodingOption(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInstanceEncodingOption(InstanceEncodingOption InstanceEncodingOption) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InstanceEncodingOption", InstanceEncodingOption == null ? null : InstanceEncodingOption.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public InstanceLockedExceptionAction getInstanceLockedExceptionAction() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InstanceLockedExceptionAction");
            return new InstanceLockedExceptionAction(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInstanceLockedExceptionAction(InstanceLockedExceptionAction InstanceLockedExceptionAction) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InstanceLockedExceptionAction", InstanceLockedExceptionAction == null ? null : InstanceLockedExceptionAction.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getConnectionString() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ConnectionString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setConnectionString(java.lang.String ConnectionString) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ConnectionString", ConnectionString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan getHostLockRenewalPeriod() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("HostLockRenewalPeriod");
            return new TimeSpan(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setHostLockRenewalPeriod(TimeSpan HostLockRenewalPeriod) throws Throwable, system.IndexOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("HostLockRenewalPeriod", HostLockRenewalPeriod == null ? null : HostLockRenewalPeriod.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan getRunnableInstancesDetectionPeriod() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RunnableInstancesDetectionPeriod");
            return new TimeSpan(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRunnableInstancesDetectionPeriod(TimeSpan RunnableInstancesDetectionPeriod) throws Throwable, system.IndexOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("RunnableInstancesDetectionPeriod", RunnableInstancesDetectionPeriod == null ? null : RunnableInstancesDetectionPeriod.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}