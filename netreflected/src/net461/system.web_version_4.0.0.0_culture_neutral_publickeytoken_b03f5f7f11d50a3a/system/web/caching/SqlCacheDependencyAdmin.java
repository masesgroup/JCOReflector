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

package system.web.caching;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section


/**
 * The base .NET class managing System.Web.Caching.SqlCacheDependencyAdmin, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.Caching.SqlCacheDependencyAdmin" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.Caching.SqlCacheDependencyAdmin</a>
 */
public class SqlCacheDependencyAdmin extends NetObject  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.Caching.SqlCacheDependencyAdmin
     */
    public static final String className = "System.Web.Caching.SqlCacheDependencyAdmin";
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

    public SqlCacheDependencyAdmin(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SqlCacheDependencyAdmin}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SqlCacheDependencyAdmin} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SqlCacheDependencyAdmin cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SqlCacheDependencyAdmin(from.getJCOInstance());
    }

    // Constructors section
    
    public SqlCacheDependencyAdmin() throws Throwable {
    }

    
    // Methods section
    
    public static java.lang.String[] GetTablesEnabledForNotifications(java.lang.String connectionString) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.diagnostics.tracing.EventSourceException, system.NotSupportedException, system.collections.generic.KeyNotFoundException, system.FormatException, system.data.sqltypes.SqlNullValueException, system.InvalidCastException, system.data.sqlclient.SqlException, system.threading.tasks.TaskSchedulerException, system.web.caching.DatabaseNotEnabledForNotificationException, system.web.HttpException, system.TypeLoadException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classType.Invoke("GetTablesEnabledForNotifications", connectionString);
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
            for(int indexGetTablesEnabledForNotifications = 0; indexGetTablesEnabledForNotifications < resultingArrayList.size(); indexGetTablesEnabledForNotifications++ ) {
				resultingArray[indexGetTablesEnabledForNotifications] = (java.lang.String)resultingArrayList.get(indexGetTablesEnabledForNotifications);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DisableNotifications(java.lang.String connectionString) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DisableNotifications", connectionString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DisableTableForNotifications(java.lang.String connectionString, java.lang.String table) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DisableTableForNotifications", connectionString, table);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DisableTableForNotifications(java.lang.String connectionString, java.lang.String[] tables) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DisableTableForNotifications", connectionString, tables);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DisableTableForNotifications(java.lang.String dupParam0, JCORefOut dupParam1) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DisableTableForNotifications", dupParam0, dupParam1.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EnableNotifications(java.lang.String connectionString) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EnableNotifications", connectionString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EnableTableForNotifications(java.lang.String connectionString, java.lang.String table) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EnableTableForNotifications", connectionString, table);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EnableTableForNotifications(java.lang.String connectionString, java.lang.String[] tables) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EnableTableForNotifications", connectionString, tables);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EnableTableForNotifications(java.lang.String dupParam0, JCORefOut dupParam1) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException, system.FormatException, system.web.caching.DatabaseNotEnabledForNotificationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EnableTableForNotifications", dupParam0, dupParam1.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}