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

package system.web.ui.htmlcontrols;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.web.ui.Control;
import system.web.ui.AttributeCollection;
import system.web.ui.CssStyleCollection;
import system.web.ui.IAttributeAccessor;
import system.web.ui.IAttributeAccessorImplementation;


/**
 * The base .NET class managing System.Web.UI.HtmlControls.HtmlControl, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.HtmlControls.HtmlControl" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.HtmlControls.HtmlControl</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class HtmlControl extends Control implements system.web.ui.IAttributeAccessor {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.UI.HtmlControls.HtmlControl
     */
    public static final String className = "System.Web.UI.HtmlControls.HtmlControl";
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
    public HtmlControl(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HtmlControl}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HtmlControl} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HtmlControl cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HtmlControl(from.getJCOInstance());
    }

    // Constructors section
    
    public HtmlControl() throws Throwable {
    }

    
    // Methods section
    
    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIAttributeAccessor method available in IAttributeAccessor to obtain an object with an invocable method
     */
    @Deprecated 
    public java.lang.String GetAttribute(java.lang.String key) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIAttributeAccessor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIAttributeAccessor method available in IAttributeAccessor to obtain an object with an invocable method
     */
    @Deprecated 
    public void SetAttribute(java.lang.String key, java.lang.String value) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIAttributeAccessor to obtain the full interface.");
    }


    
    // Properties section
    
    public boolean getDisabled() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ObjectDisposedException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.IndexOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Disabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDisabled(boolean Disabled) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.resources.MissingManifestResourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Disabled", Disabled);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTagName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("TagName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AttributeCollection getAttributes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Attributes");
            return new AttributeCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CssStyleCollection getStyle() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Style");
            return new CssStyleCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    


}