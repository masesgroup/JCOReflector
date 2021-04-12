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

package system.web.configuration;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.configuration.Configuration;
import system.configuration.ConfigurationFileMap;
import system.web.configuration.WebConfigurationFileMap;
import system.collections.specialized.NameValueCollection;
import system.configuration.ConnectionStringSettingsCollection;


/**
 * The base .NET class managing System.Web.Configuration.WebConfigurationManager, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.Configuration.WebConfigurationManager" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.Configuration.WebConfigurationManager</a>
 */
public class WebConfigurationManager extends NetObject  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.Configuration.WebConfigurationManager
     */
    public static final String className = "System.Web.Configuration.WebConfigurationManager";
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

    public WebConfigurationManager(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link WebConfigurationManager}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link WebConfigurationManager} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static WebConfigurationManager cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new WebConfigurationManager(from.getJCOInstance());
    }

    // Constructors section
    
    public WebConfigurationManager() throws Throwable {
    }

    
    // Methods section
    
    public static Configuration OpenMachineConfiguration() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMachineConfiguration = (JCObject)classType.Invoke("OpenMachineConfiguration");
            return new Configuration(objOpenMachineConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMachineConfiguration(java.lang.String locationSubPath) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMachineConfiguration = (JCObject)classType.Invoke("OpenMachineConfiguration", locationSubPath);
            return new Configuration(objOpenMachineConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMachineConfiguration(java.lang.String locationSubPath, java.lang.String server) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMachineConfiguration = (JCObject)classType.Invoke("OpenMachineConfiguration", locationSubPath, server);
            return new Configuration(objOpenMachineConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMachineConfiguration(java.lang.String locationSubPath, java.lang.String server, java.lang.String userName, java.lang.String password) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMachineConfiguration = (JCObject)classType.Invoke("OpenMachineConfiguration", locationSubPath, server, userName, password);
            return new Configuration(objOpenMachineConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMappedMachineConfiguration(ConfigurationFileMap fileMap) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMappedMachineConfiguration = (JCObject)classType.Invoke("OpenMappedMachineConfiguration", fileMap == null ? null : fileMap.getJCOInstance());
            return new Configuration(objOpenMappedMachineConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMappedMachineConfiguration(ConfigurationFileMap fileMap, java.lang.String locationSubPath) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMappedMachineConfiguration = (JCObject)classType.Invoke("OpenMappedMachineConfiguration", fileMap == null ? null : fileMap.getJCOInstance(), locationSubPath);
            return new Configuration(objOpenMappedMachineConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMappedWebConfiguration(WebConfigurationFileMap fileMap, java.lang.String path) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMappedWebConfiguration = (JCObject)classType.Invoke("OpenMappedWebConfiguration", fileMap == null ? null : fileMap.getJCOInstance(), path);
            return new Configuration(objOpenMappedWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMappedWebConfiguration(WebConfigurationFileMap fileMap, java.lang.String path, java.lang.String site) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMappedWebConfiguration = (JCObject)classType.Invoke("OpenMappedWebConfiguration", fileMap == null ? null : fileMap.getJCOInstance(), path, site);
            return new Configuration(objOpenMappedWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenMappedWebConfiguration(WebConfigurationFileMap fileMap, java.lang.String path, java.lang.String site, java.lang.String locationSubPath) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenMappedWebConfiguration = (JCObject)classType.Invoke("OpenMappedWebConfiguration", fileMap == null ? null : fileMap.getJCOInstance(), path, site, locationSubPath);
            return new Configuration(objOpenMappedWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenWebConfiguration(java.lang.String path) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenWebConfiguration = (JCObject)classType.Invoke("OpenWebConfiguration", path);
            return new Configuration(objOpenWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenWebConfiguration(java.lang.String path, java.lang.String site) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenWebConfiguration = (JCObject)classType.Invoke("OpenWebConfiguration", path, site);
            return new Configuration(objOpenWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenWebConfiguration(java.lang.String path, java.lang.String site, java.lang.String locationSubPath) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenWebConfiguration = (JCObject)classType.Invoke("OpenWebConfiguration", path, site, locationSubPath);
            return new Configuration(objOpenWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenWebConfiguration(java.lang.String path, java.lang.String site, java.lang.String locationSubPath, java.lang.String server) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenWebConfiguration = (JCObject)classType.Invoke("OpenWebConfiguration", path, site, locationSubPath, server);
            return new Configuration(objOpenWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Configuration OpenWebConfiguration(java.lang.String path, java.lang.String site, java.lang.String locationSubPath, java.lang.String server, java.lang.String userName, java.lang.String password) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpenWebConfiguration = (JCObject)classType.Invoke("OpenWebConfiguration", path, site, locationSubPath, server, userName, password);
            return new Configuration(objOpenWebConfiguration);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetSection(java.lang.String sectionName) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.web.HttpException, system.web.HttpRequestValidationException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetSection = (JCObject)classType.Invoke("GetSection", sectionName);
            return new NetObject(objGetSection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetSection(java.lang.String sectionName, java.lang.String path) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException, system.configuration.provider.ProviderException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetSection = (JCObject)classType.Invoke("GetSection", sectionName, path);
            return new NetObject(objGetSection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetWebApplicationSection(java.lang.String sectionName) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.web.HttpException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.configuration.ConfigurationException, system.configuration.provider.ProviderException, system.NotSupportedException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetWebApplicationSection = (JCObject)classType.Invoke("GetWebApplicationSection", sectionName);
            return new NetObject(objGetWebApplicationSection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static NameValueCollection getAppSettings() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("AppSettings");
            return new NameValueCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ConnectionStringSettingsCollection getConnectionStrings() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.configuration.ConfigurationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("ConnectionStrings");
            return new ConnectionStringSettingsCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}