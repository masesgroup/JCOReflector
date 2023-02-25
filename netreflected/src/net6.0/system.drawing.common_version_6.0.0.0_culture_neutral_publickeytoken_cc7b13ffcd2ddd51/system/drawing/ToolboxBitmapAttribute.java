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

package system.drawing;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.Attribute;
import system.drawing.Image;


/**
 * The base .NET class managing System.Drawing.ToolboxBitmapAttribute, System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.ToolboxBitmapAttribute" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.ToolboxBitmapAttribute</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class ToolboxBitmapAttribute extends Attribute  {
    /**
     * Fully assembly qualified name: System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Drawing.Common
     */
    public static final String assemblyShortName = "System.Drawing.Common";
    /**
     * Qualified class name: System.Drawing.ToolboxBitmapAttribute
     */
    public static final String className = "System.Drawing.ToolboxBitmapAttribute";
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
    public ToolboxBitmapAttribute(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ToolboxBitmapAttribute}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ToolboxBitmapAttribute} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ToolboxBitmapAttribute cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ToolboxBitmapAttribute(from.getJCOInstance());
    }

    // Constructors section
    
    public ToolboxBitmapAttribute() throws Throwable {
    }

    public ToolboxBitmapAttribute(java.lang.String imageFile) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.NotSupportedException, system.runtime.serialization.SerializationException, system.InvalidOperationException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.io.FileNotFoundException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(imageFile));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxBitmapAttribute(NetType t, java.lang.String name) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(t == null ? null : t.getJCOInstance(), name));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxBitmapAttribute(NetType t) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(t == null ? null : t.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public Image GetImage(NetObject component, boolean large) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetImage = (JCObject)classInstance.Invoke("GetImage", component == null ? null : component.getJCOInstance(), large);
            return new Image(objGetImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Image GetImage(NetObject component) throws Throwable, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetImage = (JCObject)classInstance.Invoke("GetImage", component == null ? null : component.getJCOInstance());
            return new Image(objGetImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Image GetImage(NetType type, boolean large) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetImage = (JCObject)classInstance.Invoke("GetImage", type == null ? null : type.getJCOInstance(), large);
            return new Image(objGetImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Image GetImage(NetType type, java.lang.String imgName, boolean large) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetImage = (JCObject)classInstance.Invoke("GetImage", type == null ? null : type.getJCOInstance(), imgName, large);
            return new Image(objGetImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Image GetImage(NetType type) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetImage = (JCObject)classInstance.Invoke("GetImage", type == null ? null : type.getJCOInstance());
            return new Image(objGetImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Image GetImageFromResource(NetType t, java.lang.String imageName, boolean large) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.OverflowException, system.componentmodel.Win32Exception {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetImageFromResource = (JCObject)classType.Invoke("GetImageFromResource", t == null ? null : t.getJCOInstance(), imageName, large);
            return new Image(objGetImageFromResource);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}