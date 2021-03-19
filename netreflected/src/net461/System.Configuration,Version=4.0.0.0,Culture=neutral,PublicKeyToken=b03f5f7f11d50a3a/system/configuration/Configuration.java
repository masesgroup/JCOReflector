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

package system.configuration;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.configuration.ConfigurationSection;
import system.configuration.ConfigurationSectionGroup;
import system.configuration.ConfigurationSaveMode;
import system.configuration.AppSettingsSection;
import system.configuration.ConfigurationLocationCollection;
import system.configuration.ConfigurationSectionCollection;
import system.configuration.ConfigurationSectionGroupCollection;
import system.configuration.ConnectionStringsSection;
import system.configuration.ContextInformation;
import system.runtime.versioning.FrameworkName;


/**
 * The base .NET class managing System.Configuration.Configuration, System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.Configuration" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.Configuration</a>
 */
public class Configuration extends NetObject  {
    /**
     * Fully assembly qualified name: System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Configuration
     */
    public static final String assemblyShortName = "System.Configuration";
    /**
     * Qualified class name: System.Configuration.Configuration
     */
    public static final String className = "System.Configuration.Configuration";
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

    public Configuration(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Configuration}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Configuration} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Configuration cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Configuration(from.getJCOInstance());
    }

    // Constructors section
    
    public Configuration() throws Throwable {
    }



    
    // Methods section
    
    public ConfigurationSection GetSection(java.lang.String sectionName) throws Throwable, system.configuration.ConfigurationErrorsException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.NotImplementedException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.collections.generic.KeyNotFoundException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSection = (JCObject)classInstance.Invoke("GetSection", sectionName);
            return new ConfigurationSection(objGetSection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationSectionGroup GetSectionGroup(java.lang.String sectionGroupName) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.configuration.ConfigurationErrorsException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.TypeLoadException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSectionGroup = (JCObject)classInstance.Invoke("GetSectionGroup", sectionGroupName);
            return new ConfigurationSectionGroup(objGetSectionGroup);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Save() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.io.PathTooLongException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.security.SecurityException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NullReferenceException, system.configuration.ConfigurationException, system.xml.XmlException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Save");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Save(ConfigurationSaveMode saveMode) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.io.PathTooLongException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.security.SecurityException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NullReferenceException, system.configuration.ConfigurationException, system.xml.XmlException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Save", saveMode == null ? null : saveMode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Save(ConfigurationSaveMode saveMode, boolean forceSaveAll) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.io.PathTooLongException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.security.SecurityException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NullReferenceException, system.configuration.ConfigurationException, system.xml.XmlException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Save", saveMode == null ? null : saveMode.getJCOInstance(), forceSaveAll);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SaveAs(java.lang.String filename) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.configuration.ConfigurationErrorsException, system.security.SecurityException, system.TypeLoadException, system.NullReferenceException, system.configuration.ConfigurationException, system.xml.XmlException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SaveAs", filename);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SaveAs(java.lang.String filename, ConfigurationSaveMode saveMode) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.configuration.ConfigurationErrorsException, system.security.SecurityException, system.TypeLoadException, system.NullReferenceException, system.configuration.ConfigurationException, system.xml.XmlException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SaveAs", filename, saveMode == null ? null : saveMode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SaveAs(java.lang.String filename, ConfigurationSaveMode saveMode, boolean forceSaveAll) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.NotSupportedException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.security.SecurityException, system.TypeLoadException, system.NullReferenceException, system.configuration.ConfigurationException, system.xml.XmlException, system.io.IOException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SaveAs", filename, saveMode == null ? null : saveMode.getJCOInstance(), forceSaveAll);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getHasFile() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasFile");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getNamespaceDeclared() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("NamespaceDeclared");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setNamespaceDeclared(boolean NamespaceDeclared) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("NamespaceDeclared", NamespaceDeclared);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AppSettingsSection getAppSettings() throws Throwable, system.configuration.ConfigurationErrorsException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.NotImplementedException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("AppSettings");
            return new AppSettingsSection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationLocationCollection getLocations() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Locations");
            return new ConfigurationLocationCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationSectionCollection getSections() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Sections");
            return new ConfigurationSectionCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationSectionGroup getRootSectionGroup() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RootSectionGroup");
            return new ConfigurationSectionGroup(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationSectionGroupCollection getSectionGroups() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SectionGroups");
            return new ConfigurationSectionGroupCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConnectionStringsSection getConnectionStrings() throws Throwable, system.configuration.ConfigurationErrorsException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.NotImplementedException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ConnectionStrings");
            return new ConnectionStringsSection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ContextInformation getEvaluationContext() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("EvaluationContext");
            return new ContextInformation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FrameworkName getTargetFramework() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TargetFramework");
            return new FrameworkName(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTargetFramework(FrameworkName TargetFramework) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TargetFramework", TargetFramework == null ? null : TargetFramework.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getFilePath() throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("FilePath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}