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

package system.windows.controls;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.UIElement;
import system.windows.FrameworkElement;
import system.Array;


/**
 * The base .NET class managing System.Windows.Controls.UIElementCollection, PresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Controls.UIElementCollection" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Controls.UIElementCollection</a>
 */
public class UIElementCollection extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationFramework
     */
    public static final String assemblyShortName = "PresentationFramework";
    /**
     * Qualified class name: System.Windows.Controls.UIElementCollection
     */
    public static final String className = "System.Windows.Controls.UIElementCollection";
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

    public UIElementCollection(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link UIElementCollection}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link UIElementCollection} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static UIElementCollection cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new UIElementCollection(from.getJCOInstance());
    }

    // Constructors section
    
    public UIElementCollection() throws Throwable {
    }

    public UIElementCollection(UIElement visualParent, FrameworkElement logicalParent) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(visualParent == null ? null : visualParent.getJCOInstance(), logicalParent == null ? null : logicalParent.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Contains(UIElement element) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Contains", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int Add(UIElement element) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("Add", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int IndexOf(UIElement element) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("IndexOf", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Clear() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException, system.MulticastNotSupportedException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Clear");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CopyTo(Array array, int index) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CopyTo", array == null ? null : array.getJCOInstance(), index);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CopyTo(UIElement[] array, int index) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CopyTo", toObjectFromArray(array), index);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Insert(int index, UIElement element) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Insert", index, element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Remove(UIElement element) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Remove", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveAt(int index) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.security.SecurityException, system.ObjectDisposedException, system.OutOfMemoryException, system.MulticastNotSupportedException, system.InvalidCastException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveAt", index);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveRange(int index, int count) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.ObjectDisposedException, system.MulticastNotSupportedException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveRange", index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getIsSynchronized() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsSynchronized");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getCapacity() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Capacity");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCapacity(int Capacity) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.OverflowException, system.componentmodel.Win32Exception, system.security.SecurityException, system.ObjectDisposedException, system.OutOfMemoryException, system.MulticastNotSupportedException, system.InvalidCastException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Capacity", Capacity);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getCount() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Count");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject getSyncRoot() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SyncRoot");
            return new NetObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}