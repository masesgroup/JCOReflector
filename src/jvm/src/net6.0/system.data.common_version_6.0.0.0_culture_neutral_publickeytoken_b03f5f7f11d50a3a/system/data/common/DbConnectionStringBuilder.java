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

package system.data.common;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.data.common.DbConnectionStringBuilder;
import system.text.StringBuilder;
import system.Array;
import system.componentmodel.AttributeCollection;
import system.componentmodel.EventDescriptor;
import system.componentmodel.EventDescriptorCollection;
import system.Attribute;
import system.componentmodel.PropertyDescriptor;
import system.componentmodel.PropertyDescriptorCollection;
import system.componentmodel.TypeConverter;
import system.collections.ICollection;
import system.collections.ICollectionImplementation;
import system.componentmodel.ICustomTypeDescriptor;
import system.componentmodel.ICustomTypeDescriptorImplementation;


/**
 * The base .NET class managing System.Data.Common.DbConnectionStringBuilder, System.Data.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Data.Common.DbConnectionStringBuilder" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Data.Common.DbConnectionStringBuilder</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class DbConnectionStringBuilder extends NetObjectEnumerable implements system.componentmodel.ICustomTypeDescriptor {
    /**
     * Fully assembly qualified name: System.Data.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Data.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Data.Common
     */
    public static final String assemblyShortName = "System.Data.Common";
    /**
     * Qualified class name: System.Data.Common.DbConnectionStringBuilder
     */
    public static final String className = "System.Data.Common.DbConnectionStringBuilder";
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
    public DbConnectionStringBuilder(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DbConnectionStringBuilder}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DbConnectionStringBuilder} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DbConnectionStringBuilder cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DbConnectionStringBuilder(from.getJCOInstance());
    }

    // Constructors section
    
    public DbConnectionStringBuilder() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DbConnectionStringBuilder(boolean useOdbcRules) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(useOdbcRules));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean ContainsKey(java.lang.String keyword) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("ContainsKey", keyword);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean EquivalentTo(DbConnectionStringBuilder connectionStringBuilder) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("EquivalentTo", connectionStringBuilder == null ? null : connectionStringBuilder.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Remove(java.lang.String keyword) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Remove", keyword);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean ShouldSerialize(java.lang.String keyword) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("ShouldSerialize", keyword);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean TryGetValue(java.lang.String keyword, JCORefOut<NetObject> value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("TryGetValue", keyword, value.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Add(java.lang.String keyword, NetObject value) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.OverflowException, system.text.regularexpressions.RegexMatchTimeoutException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Add", keyword, value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AppendKeyValuePair(StringBuilder builder, java.lang.String keyword, java.lang.String value, boolean useOdbcRules) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.OverflowException, system.text.regularexpressions.RegexMatchTimeoutException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.ArrayTypeMismatchException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AppendKeyValuePair", builder == null ? null : builder.getJCOInstance(), keyword, value, useOdbcRules);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AppendKeyValuePair(StringBuilder builder, java.lang.String keyword, java.lang.String value) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.OverflowException, system.text.regularexpressions.RegexMatchTimeoutException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.ArrayTypeMismatchException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AppendKeyValuePair", builder == null ? null : builder.getJCOInstance(), keyword, value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Clear() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.diagnostics.tracing.EventSourceException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Clear");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIDictionary method available in IDictionary to obtain an object with an invocable method
     */
    @Deprecated 
    public boolean Contains(NetObject key) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIDictionary to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIDictionary method available in IDictionary to obtain an object with an invocable method
     */
    @Deprecated 
    public void Add(NetObject key, NetObject value) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIDictionary to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIDictionary method available in IDictionary to obtain an object with an invocable method
     */
    @Deprecated 
    public void Remove(NetObject key) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIDictionary to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICollection method available in ICollection to obtain an object with an invocable method
     */
    @Deprecated 
    public void CopyTo(Array array, int index) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICollection to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public AttributeCollection GetAttributes() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public EventDescriptor GetDefaultEvent() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public EventDescriptorCollection GetEvents() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public EventDescriptorCollection GetEvents(Attribute[] attributes) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public PropertyDescriptor GetDefaultProperty() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public PropertyDescriptorCollection GetProperties() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public PropertyDescriptorCollection GetProperties(Attribute[] attributes) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public TypeConverter GetConverter() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public NetObject GetEditor(NetType editorBaseType) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public NetObject GetPropertyOwner(PropertyDescriptor pd) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public java.lang.String GetClassName() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToICustomTypeDescriptor method available in ICustomTypeDescriptor to obtain an object with an invocable method
     */
    @Deprecated 
    public java.lang.String GetComponentName() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToICustomTypeDescriptor to obtain the full interface.");
    }


    
    // Properties section
    
    public boolean getBrowsableConnectionString() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("BrowsableConnectionString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setBrowsableConnectionString(boolean BrowsableConnectionString) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("BrowsableConnectionString", BrowsableConnectionString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsFixedSize() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsFixedSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsReadOnly() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsReadOnly");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getCount() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Count");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ICollection getKeys() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Keys");
            return new ICollectionImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ICollection getValues() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Values");
            return new ICollectionImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getConnectionString() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.OutOfMemoryException, system.OverflowException, system.text.regularexpressions.RegexMatchTimeoutException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ConnectionString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setConnectionString(java.lang.String ConnectionString) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.text.regularexpressions.RegexMatchTimeoutException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ConnectionString", ConnectionString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}