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

package system.windows;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.DataTemplate;
import system.windows.controls.DataTemplateSelector;
import system.windows.controls.StyleSelector;
import system.windows.data.BindingBase;
import system.windows.data.BindingGroup;
import system.windows.Style;


/**
 * The base .NET class managing System.Windows.HierarchicalDataTemplate, PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.HierarchicalDataTemplate" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.HierarchicalDataTemplate</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class HierarchicalDataTemplate extends DataTemplate  {
    /**
     * Fully assembly qualified name: PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationFramework
     */
    public static final String assemblyShortName = "PresentationFramework";
    /**
     * Qualified class name: System.Windows.HierarchicalDataTemplate
     */
    public static final String className = "System.Windows.HierarchicalDataTemplate";
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
    public HierarchicalDataTemplate(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HierarchicalDataTemplate}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HierarchicalDataTemplate} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HierarchicalDataTemplate cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HierarchicalDataTemplate(from.getJCOInstance());
    }

    // Constructors section
    
    public HierarchicalDataTemplate() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HierarchicalDataTemplate(NetObject dataType) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(dataType == null ? null : dataType.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    

    
    // Properties section
    
    public int getAlternationCount() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("AlternationCount");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAlternationCount(int AlternationCount) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AlternationCount", AlternationCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getItemStringFormat() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ItemStringFormat");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemStringFormat(java.lang.String ItemStringFormat) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemStringFormat", ItemStringFormat);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DataTemplateSelector getItemTemplateSelector() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ItemTemplateSelector");
            return new DataTemplateSelector(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemTemplateSelector(DataTemplateSelector ItemTemplateSelector) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemTemplateSelector", ItemTemplateSelector == null ? null : ItemTemplateSelector.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StyleSelector getItemContainerStyleSelector() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ItemContainerStyleSelector");
            return new StyleSelector(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemContainerStyleSelector(StyleSelector ItemContainerStyleSelector) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemContainerStyleSelector", ItemContainerStyleSelector == null ? null : ItemContainerStyleSelector.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public BindingBase getItemsSource() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ItemsSource");
            return new BindingBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemsSource(BindingBase ItemsSource) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemsSource", ItemsSource == null ? null : ItemsSource.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public BindingGroup getItemBindingGroup() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ItemBindingGroup");
            return new BindingGroup(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemBindingGroup(BindingGroup ItemBindingGroup) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemBindingGroup", ItemBindingGroup == null ? null : ItemBindingGroup.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DataTemplate getItemTemplate() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ItemTemplate");
            return new DataTemplate(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemTemplate(DataTemplate ItemTemplate) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemTemplate", ItemTemplate == null ? null : ItemTemplate.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Style getItemContainerStyle() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ItemContainerStyle");
            return new Style(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setItemContainerStyle(Style ItemContainerStyle) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ItemContainerStyle", ItemContainerStyle == null ? null : ItemContainerStyle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}