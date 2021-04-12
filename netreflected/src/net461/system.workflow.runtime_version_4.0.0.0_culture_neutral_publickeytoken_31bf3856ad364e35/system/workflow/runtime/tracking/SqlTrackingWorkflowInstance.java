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

package system.workflow.runtime.tracking;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.DateTime;
import system.Guid;
import system.workflow.componentmodel.Activity;
import system.workflow.runtime.WorkflowStatus;


/**
 * The base .NET class managing System.Workflow.Runtime.Tracking.SqlTrackingWorkflowInstance, System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.Runtime.Tracking.SqlTrackingWorkflowInstance" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.Runtime.Tracking.SqlTrackingWorkflowInstance</a>
 */
public class SqlTrackingWorkflowInstance extends NetObject  {
    /**
     * Fully assembly qualified name: System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Workflow.Runtime
     */
    public static final String assemblyShortName = "System.Workflow.Runtime";
    /**
     * Qualified class name: System.Workflow.Runtime.Tracking.SqlTrackingWorkflowInstance
     */
    public static final String className = "System.Workflow.Runtime.Tracking.SqlTrackingWorkflowInstance";
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

    public SqlTrackingWorkflowInstance(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SqlTrackingWorkflowInstance}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SqlTrackingWorkflowInstance} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SqlTrackingWorkflowInstance cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SqlTrackingWorkflowInstance(from.getJCOInstance());
    }

    // Constructors section
    
    public SqlTrackingWorkflowInstance() throws Throwable {
    }



    
    // Methods section
    
    public void Refresh() throws Throwable, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Refresh");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAutoRefresh() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AutoRefresh");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAutoRefresh(boolean AutoRefresh) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AutoRefresh", AutoRefresh);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getWorkflowDefinitionUpdated() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.xml.XmlException, system.configuration.ConfigurationErrorsException, system.FormatException, system.OutOfMemoryException, system.NotSupportedException, system.NullReferenceException, system.IndexOutOfRangeException, system.InvalidCastException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("WorkflowDefinitionUpdated");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getWorkflowInstanceInternalId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("WorkflowInstanceInternalId");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWorkflowInstanceInternalId(long WorkflowInstanceInternalId) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("WorkflowInstanceInternalId", WorkflowInstanceInternalId);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getInitialized() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Initialized");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInitialized(DateTime Initialized) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Initialized", Initialized == null ? null : Initialized.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Guid getInvokingWorkflowInstanceId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InvokingWorkflowInstanceId");
            return new Guid(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInvokingWorkflowInstanceId(Guid InvokingWorkflowInstanceId) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InvokingWorkflowInstanceId", InvokingWorkflowInstanceId == null ? null : InvokingWorkflowInstanceId.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Guid getWorkflowInstanceId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("WorkflowInstanceId");
            return new Guid(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWorkflowInstanceId(Guid WorkflowInstanceId) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("WorkflowInstanceId", WorkflowInstanceId == null ? null : WorkflowInstanceId.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType getWorkflowType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("WorkflowType");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWorkflowType(NetType WorkflowType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("WorkflowType", WorkflowType == null ? null : WorkflowType.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Activity getWorkflowDefinition() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.xml.XmlException, system.configuration.ConfigurationErrorsException, system.FormatException, system.OutOfMemoryException, system.NotSupportedException, system.NullReferenceException, system.IndexOutOfRangeException, system.InvalidCastException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("WorkflowDefinition");
            return new Activity(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WorkflowStatus getStatus() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Status");
            return new WorkflowStatus(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStatus(WorkflowStatus Status) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Status", Status == null ? null : Status.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}