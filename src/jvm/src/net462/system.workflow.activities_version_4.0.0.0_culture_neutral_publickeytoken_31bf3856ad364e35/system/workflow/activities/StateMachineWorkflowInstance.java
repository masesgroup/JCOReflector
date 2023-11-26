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

package system.workflow.activities;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.workflow.runtime.WorkflowRuntime;
import system.Guid;
import system.IComparable;
import system.IComparableImplementation;
import system.workflow.runtime.IPendingWork;
import system.workflow.runtime.IPendingWorkImplementation;
import system.workflow.activities.StateActivity;
import system.workflow.activities.StateMachineWorkflowActivity;
import system.workflow.runtime.WorkflowInstance;


/**
 * The base .NET class managing System.Workflow.Activities.StateMachineWorkflowInstance, System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.Activities.StateMachineWorkflowInstance" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.Activities.StateMachineWorkflowInstance</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class StateMachineWorkflowInstance extends NetObject  {
    /**
     * Fully assembly qualified name: System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Workflow.Activities
     */
    public static final String assemblyShortName = "System.Workflow.Activities";
    /**
     * Qualified class name: System.Workflow.Activities.StateMachineWorkflowInstance
     */
    public static final String className = "System.Workflow.Activities.StateMachineWorkflowInstance";
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
    public StateMachineWorkflowInstance(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link StateMachineWorkflowInstance}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link StateMachineWorkflowInstance} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static StateMachineWorkflowInstance cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new StateMachineWorkflowInstance(from.getJCOInstance());
    }

    // Constructors section
    
    public StateMachineWorkflowInstance() throws Throwable {
    }

    public StateMachineWorkflowInstance(WorkflowRuntime runtime, Guid instanceId) throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.IndexOutOfRangeException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.UnauthorizedAccessException, system.PlatformNotSupportedException, system.security.cryptography.CryptographicException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.InvalidCastException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(runtime == null ? null : runtime.getJCOInstance(), instanceId == null ? null : instanceId.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public void EnqueueItem(IComparable queueName, NetObject item) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.InvalidCastException, system.NullReferenceException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.NotImplementedException, system.InvalidOperationException, system.ObjectDisposedException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.NotSupportedException, system.UnauthorizedAccessException, system.PlatformNotSupportedException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("EnqueueItem", queueName == null ? null : queueName.getJCOInstance(), item == null ? null : item.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void EnqueueItem(IComparable queueName, NetObject item, IPendingWork pendingWork, NetObject workItem) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ObjectDisposedException, system.NotSupportedException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.InvalidOperationException, system.NotImplementedException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.UnauthorizedAccessException, system.PlatformNotSupportedException, system.security.cryptography.CryptographicException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("EnqueueItem", queueName == null ? null : queueName.getJCOInstance(), item == null ? null : item.getJCOInstance(), pendingWork == null ? null : pendingWork.getJCOInstance(), workItem == null ? null : workItem.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetState(java.lang.String targetStateName) throws Throwable, system.ArgumentNullException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.NotSupportedException, system.UnauthorizedAccessException, system.configuration.ConfigurationErrorsException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetState", targetStateName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetState(StateActivity targetState) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.UnauthorizedAccessException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetState", targetState == null ? null : targetState.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public Guid getInstanceId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InstanceId");
            return new Guid(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getCurrentStateName() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.IndexOutOfRangeException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.NotSupportedException, system.UnauthorizedAccessException, system.ObjectDisposedException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("CurrentStateName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StateActivity getCurrentState() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.NotSupportedException, system.UnauthorizedAccessException, system.PlatformNotSupportedException, system.security.cryptography.CryptographicException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CurrentState");
            return new StateActivity(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StateMachineWorkflowActivity getStateMachineWorkflow() throws Throwable, system.OverflowException, system.ArgumentNullException, system.collections.generic.KeyNotFoundException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.workflow.componentmodel.compiler.WorkflowValidationFailedException, system.xml.XmlException, system.UnauthorizedAccessException, system.PlatformNotSupportedException, system.security.cryptography.CryptographicException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("StateMachineWorkflow");
            return new StateMachineWorkflowActivity(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WorkflowInstance getWorkflowInstance() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("WorkflowInstance");
            return new WorkflowInstance(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}