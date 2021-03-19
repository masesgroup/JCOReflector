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

package system.web.ui.design.webcontrols.webparts;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.web.ui.design.webcontrols.webparts.WebPartZoneBaseDesigner;
import system.web.ui.design.DesignerRegionCollection;
import system.web.ui.design.EditableDesignerRegion;
import system.componentmodel.IComponent;
import system.componentmodel.IComponentImplementation;
import system.web.ui.design.DesignerAutoFormatCollection;
import system.web.ui.design.TemplateGroupCollection;


/**
 * The base .NET class managing System.Web.UI.Design.WebControls.WebParts.WebPartZoneDesigner, System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.Design.WebControls.WebParts.WebPartZoneDesigner" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.Design.WebControls.WebParts.WebPartZoneDesigner</a>
 */
public class WebPartZoneDesigner extends WebPartZoneBaseDesigner  {
    /**
     * Fully assembly qualified name: System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Design
     */
    public static final String assemblyShortName = "System.Design";
    /**
     * Qualified class name: System.Web.UI.Design.WebControls.WebParts.WebPartZoneDesigner
     */
    public static final String className = "System.Web.UI.Design.WebControls.WebParts.WebPartZoneDesigner";
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

    public WebPartZoneDesigner(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link WebPartZoneDesigner}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link WebPartZoneDesigner} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static WebPartZoneDesigner cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new WebPartZoneDesigner(from.getJCOInstance());
    }

    // Constructors section
    
    public WebPartZoneDesigner() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public java.lang.String GetDesignTimeHtml() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.NullReferenceException, system.NotImplementedException, system.web.HttpException, system.OverflowException, system.web.HttpRequestValidationException, system.PlatformNotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetDesignTimeHtml");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String GetDesignTimeHtml(DesignerRegionCollection regions) throws Throwable, system.ArgumentNullException, system.IndexOutOfRangeException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.NullReferenceException, system.TypeLoadException, system.NotImplementedException, system.OutOfMemoryException, system.web.HttpException, system.OverflowException, system.web.HttpRequestValidationException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetDesignTimeHtml", regions == null ? null : regions.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String GetEditableDesignerRegionContent(EditableDesignerRegion region) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.NullReferenceException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetEditableDesignerRegionContent", region == null ? null : region.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Initialize(IComponent component) throws Throwable, system.InvalidOperationException, system.ArgumentNullException, system.TypeLoadException, system.ArgumentException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.MulticastNotSupportedException, system.configuration.ConfigurationException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Initialize", component == null ? null : component.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetEditableDesignerRegionContent(EditableDesignerRegion region, java.lang.String content) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.configuration.ConfigurationException, system.web.HttpException, system.NotSupportedException, system.web.HttpParseException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetEditableDesignerRegionContent", region == null ? null : region.getJCOInstance(), content);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}