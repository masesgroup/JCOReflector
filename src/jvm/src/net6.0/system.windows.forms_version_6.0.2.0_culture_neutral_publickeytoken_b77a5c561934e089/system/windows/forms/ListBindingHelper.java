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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.PropertyDescriptorCollection;
import system.componentmodel.PropertyDescriptor;


/**
 * The base .NET class managing System.Windows.Forms.ListBindingHelper, System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.ListBindingHelper" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.ListBindingHelper</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ListBindingHelper extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.ListBindingHelper
     */
    public static final String className = "System.Windows.Forms.ListBindingHelper";
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
    public ListBindingHelper(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ListBindingHelper}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ListBindingHelper} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ListBindingHelper cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ListBindingHelper(from.getJCOInstance());
    }

    // Constructors section
    
    public ListBindingHelper() throws Throwable {
    }

    
    // Methods section
    
    public static PropertyDescriptorCollection GetListItemProperties(NetObject list, PropertyDescriptor[] listAccessors) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetListItemProperties = (JCObject)classType.Invoke("GetListItemProperties", list == null ? null : list.getJCOInstance(), toObjectFromArray(listAccessors));
            return new PropertyDescriptorCollection(objGetListItemProperties);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static PropertyDescriptorCollection GetListItemProperties(NetObject dataSource, java.lang.String dataMember, PropertyDescriptor[] listAccessors) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetListItemProperties = (JCObject)classType.Invoke("GetListItemProperties", dataSource == null ? null : dataSource.getJCOInstance(), dataMember, toObjectFromArray(listAccessors));
            return new PropertyDescriptorCollection(objGetListItemProperties);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static PropertyDescriptorCollection GetListItemProperties(NetObject list) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.IndexOutOfRangeException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetListItemProperties = (JCObject)classType.Invoke("GetListItemProperties", list == null ? null : list.getJCOInstance());
            return new PropertyDescriptorCollection(objGetListItemProperties);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetList(NetObject dataSource, java.lang.String dataMember) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetList = (JCObject)classType.Invoke("GetList", dataSource == null ? null : dataSource.getJCOInstance(), dataMember);
            return new NetObject(objGetList);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetList(NetObject list) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetList = (JCObject)classType.Invoke("GetList", list == null ? null : list.getJCOInstance());
            return new NetObject(objGetList);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String GetListName(NetObject list, PropertyDescriptor[] listAccessors) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("GetListName", list == null ? null : list.getJCOInstance(), toObjectFromArray(listAccessors));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType GetListItemType(NetObject dataSource, java.lang.String dataMember) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetListItemType = (JCObject)classType.Invoke("GetListItemType", dataSource == null ? null : dataSource.getJCOInstance(), dataMember);
            return new NetType(objGetListItemType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType GetListItemType(NetObject list) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetListItemType = (JCObject)classType.Invoke("GetListItemType", list == null ? null : list.getJCOInstance());
            return new NetType(objGetListItemType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}