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
 *      This code was generated from a template using JCOReflector version 1.1.0.0
 * 
 *      Manual changes to this file may cause unexpected behavior in your application.
 *      Manual changes to this file will be overwritten if the code is regenerated.
 * </auto-generated>
 *************************************************************************************/

package system.workflow.runtime.debugengine;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.Guid;
import system.workflow.componentmodel.ActivityExecutionStatus;
import system.workflow.runtime.debugengine.ActivityHandlerDescriptor;


/**
 * The base .NET class managing System.Workflow.Runtime.DebugEngine.IWorkflowDebugger, System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Implements {@link IJCOBridgeReflected}.
 */
public interface IWorkflowDebugger extends IJCOBridgeReflected {

    public static IWorkflowDebugger ToIWorkflowDebugger(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35");
        JCType classType = bridge.GetType("System.Workflow.Runtime.DebugEngine.IWorkflowDebugger, " + (JCOBridgeInstance.getUseFullAssemblyName() ? "System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" : "System.Workflow.Runtime"));
        NetType.AssertCast(classType, from);
        return new IWorkflowDebuggerImplementation(from.getJCOInstance());
    }

    /**
     * Returns the reflected Assembly name
     * 
     * @return A {@link String} representing the Fullname of reflected Assembly
     */
    public String getJCOAssemblyName();

    /**
     * Returns the reflected Class name
     * 
     * @return A {@link String} representing the Fullname of reflected Class
     */
    public String getJCOClassName();

    /**
     * Returns the reflected Class name used to build the object
     * 
     * @return A {@link String} representing the name used to allocated the object
     *         in CLR context
     */
    public String getJCOObjectName();

    /**
     * Returns the instantiated class
     * 
     * @return An {@link Object} representing the instance of the instantiated Class
     */
    public Object getJCOInstance();

    /**
     * Returns the instantiated class Type
     * 
     * @return A {@link JCType} representing the Type of the instantiated Class
     */
    public JCType getJCOType();

    // Methods section
    
    public void InstanceCreated(Guid programId, Guid instanceId, Guid scheduleTypeId) throws Throwable;

    public void InstanceDynamicallyUpdated(Guid programId, Guid instanceId, Guid scheduleTypeId) throws Throwable;

    public void InstanceCompleted(Guid programId, Guid instanceId) throws Throwable;

    public void BeforeActivityStatusChanged(Guid programId, Guid scheduleTypeId, Guid instanceId, java.lang.String activityQualifiedName, java.lang.String hierarchicalActivityId, ActivityExecutionStatus status, int stateReaderId) throws Throwable;

    public void ActivityStatusChanged(Guid programId, Guid scheduleTypeId, Guid instanceId, java.lang.String activityQualifiedName, java.lang.String hierarchicalActivityId, ActivityExecutionStatus status, int stateReaderId) throws Throwable;

    public void SetInitialActivityStatus(Guid programId, Guid scheduleTypeId, Guid instanceId, java.lang.String activityQualifiedName, java.lang.String hierarchicalActivityId, ActivityExecutionStatus status, int stateReaderId) throws Throwable;

    public void ScheduleTypeLoaded(Guid programId, Guid scheduleTypeId, java.lang.String assemblyFullName, java.lang.String fileName, java.lang.String md5Digest, boolean isDynamic, java.lang.String scheduleNamespace, java.lang.String scheduleName, java.lang.String workflowMarkup) throws Throwable;

    public void AssemblyLoaded(Guid programId, java.lang.String assemblyPath, boolean fromGlobalAssemblyCache) throws Throwable;

    public void HandlerInvoked(Guid programId, Guid instanceId, int threadId, java.lang.String activityQualifiedName) throws Throwable;

    public void BeforeHandlerInvoked(Guid programId, Guid scheduleTypeId, java.lang.String activityQualifiedName, ActivityHandlerDescriptor handlerMethod) throws Throwable;


    
    // Properties section
    


    // Instance Events section
    

}