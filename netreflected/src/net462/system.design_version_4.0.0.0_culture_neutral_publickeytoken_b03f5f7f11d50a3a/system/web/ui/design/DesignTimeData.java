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

package system.web.ui.design;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.IListSource;
import system.componentmodel.IListSourceImplementation;
import system.data.DataTable;
import system.componentmodel.IComponent;
import system.componentmodel.IComponentImplementation;
import system.componentmodel.PropertyDescriptorCollection;


/**
 * The base .NET class managing System.Web.UI.Design.DesignTimeData, System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.Design.DesignTimeData" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.Design.DesignTimeData</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class DesignTimeData extends NetObject  {
    /**
     * Fully assembly qualified name: System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Design
     */
    public static final String assemblyShortName = "System.Design";
    /**
     * Qualified class name: System.Web.UI.Design.DesignTimeData
     */
    public static final String className = "System.Web.UI.Design.DesignTimeData";
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
    public DesignTimeData(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DesignTimeData}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DesignTimeData} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DesignTimeData cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DesignTimeData(from.getJCOInstance());
    }

    // Constructors section
    
    public DesignTimeData() throws Throwable {
    }



    
    // Methods section
    
    public static IEnumerable GetDataMember(IListSource dataSource, java.lang.String dataMember) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetDataMember = (JCObject)classType.Invoke("GetDataMember", dataSource == null ? null : dataSource.getJCOInstance(), dataMember);
            return new IEnumerableImplementation(objGetDataMember);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IEnumerable GetDesignTimeDataSource(DataTable dataTable, int minimumRows) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.InvalidTimeZoneException, system.OverflowException, system.data.DataException, system.MulticastNotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetDesignTimeDataSource = (JCObject)classType.Invoke("GetDesignTimeDataSource", dataTable == null ? null : dataTable.getJCOInstance(), minimumRows);
            return new IEnumerableImplementation(objGetDesignTimeDataSource);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IEnumerable GetSelectedDataSource(IComponent component, java.lang.String dataSource, java.lang.String dataMember) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetSelectedDataSource = (JCObject)classType.Invoke("GetSelectedDataSource", component == null ? null : component.getJCOInstance(), dataSource, dataMember);
            return new IEnumerableImplementation(objGetSelectedDataSource);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static PropertyDescriptorCollection GetDataFields(IEnumerable dataSource) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.TypeLoadException, system.security.SecurityException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetDataFields = (JCObject)classType.Invoke("GetDataFields", dataSource == null ? null : dataSource.getJCOInstance());
            return new PropertyDescriptorCollection(objGetDataFields);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DataTable CreateDummyDataBoundDataTable() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.NotSupportedException, system.NullReferenceException, system.configuration.ConfigurationErrorsException, system.data.DataException, system.OverflowException, system.InvalidCastException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateDummyDataBoundDataTable = (JCObject)classType.Invoke("CreateDummyDataBoundDataTable");
            return new DataTable(objCreateDummyDataBoundDataTable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DataTable CreateDummyDataTable() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.NotSupportedException, system.NullReferenceException, system.configuration.ConfigurationErrorsException, system.data.DataException, system.OverflowException, system.InvalidCastException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateDummyDataTable = (JCObject)classType.Invoke("CreateDummyDataTable");
            return new DataTable(objCreateDummyDataTable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DataTable CreateSampleDataTable(IEnumerable referenceData) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.security.SecurityException, system.NullReferenceException, system.NotSupportedException, system.data.DataException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateSampleDataTable = (JCObject)classType.Invoke("CreateSampleDataTable", referenceData == null ? null : referenceData.getJCOInstance());
            return new DataTable(objCreateSampleDataTable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DataTable CreateSampleDataTable(IEnumerable referenceData, boolean useDataBoundData) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.security.SecurityException, system.NullReferenceException, system.NotSupportedException, system.data.DataException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateSampleDataTable = (JCObject)classType.Invoke("CreateSampleDataTable", referenceData == null ? null : referenceData.getJCOInstance(), useDataBoundData);
            return new DataTable(objCreateSampleDataTable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetSelectedDataSource(IComponent component, java.lang.String dataSource) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetSelectedDataSource = (JCObject)classType.Invoke("GetSelectedDataSource", component == null ? null : component.getJCOInstance(), dataSource);
            return new NetObject(objGetSelectedDataSource);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String[] GetDataMembers(NetObject dataSource) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.RankException, system.NullReferenceException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetDataMembers", dataSource == null ? null : dataSource.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
            for(int indexGetDataMembers = 0; indexGetDataMembers < resultingArrayList.size(); indexGetDataMembers++ ) {
				resultingArray[indexGetDataMembers] = (java.lang.String)resultingArrayList.get(indexGetDataMembers);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}