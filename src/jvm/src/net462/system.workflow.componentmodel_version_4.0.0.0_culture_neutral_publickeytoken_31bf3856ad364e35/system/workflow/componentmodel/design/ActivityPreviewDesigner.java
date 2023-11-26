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

package system.workflow.componentmodel.design;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.workflow.componentmodel.design.SequentialActivityDesigner;
import system.workflow.componentmodel.design.ActivityDesigner;
import system.workflow.componentmodel.design.DesignerNavigationDirection;
import system.workflow.componentmodel.design.HitTestInfo;
import system.drawing.Point;
import system.windows.forms.AccessibleObject;


/**
 * The base .NET class managing System.Workflow.ComponentModel.Design.ActivityPreviewDesigner, System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.ComponentModel.Design.ActivityPreviewDesigner" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.ComponentModel.Design.ActivityPreviewDesigner</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ActivityPreviewDesigner extends SequentialActivityDesigner  {
    /**
     * Fully assembly qualified name: System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Workflow.ComponentModel
     */
    public static final String assemblyShortName = "System.Workflow.ComponentModel";
    /**
     * Qualified class name: System.Workflow.ComponentModel.Design.ActivityPreviewDesigner
     */
    public static final String className = "System.Workflow.ComponentModel.Design.ActivityPreviewDesigner";
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
    public ActivityPreviewDesigner(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ActivityPreviewDesigner}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ActivityPreviewDesigner} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ActivityPreviewDesigner cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ActivityPreviewDesigner(from.getJCOInstance());
    }

    // Constructors section
    
    public ActivityPreviewDesigner() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentException, system.MulticastNotSupportedException, system.NotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean IsContainedDesignerVisible(ActivityDesigner containedDesigner) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.MissingMethodException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsContainedDesignerVisible", containedDesigner == null ? null : containedDesigner.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetNextSelectableObject(NetObject obj, DesignerNavigationDirection direction) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.MissingMethodException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.MulticastNotSupportedException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetNextSelectableObject = (JCObject)classInstance.Invoke("GetNextSelectableObject", obj == null ? null : obj.getJCOInstance(), direction == null ? null : direction.getJCOInstance());
            return new NetObject(objGetNextSelectableObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HitTestInfo HitTest(Point point) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.MissingMethodException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objHitTest = (JCObject)classInstance.Invoke("HitTest", point == null ? null : point.getJCOInstance());
            return new HitTestInfo(objHitTest);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void EnsureVisibleContainedDesigner(ActivityDesigner containedDesigner) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("EnsureVisibleContainedDesigner", containedDesigner == null ? null : containedDesigner.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RefreshPreview() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArgumentException, system.OutOfMemoryException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ObjectDisposedException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RefreshPreview");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getShowPreview() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ShowPreview");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setShowPreview(boolean ShowPreview) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ShowPreview", ShowPreview);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActivityDesigner getPreviewedDesigner() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("PreviewedDesigner");
            return new ActivityDesigner(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}