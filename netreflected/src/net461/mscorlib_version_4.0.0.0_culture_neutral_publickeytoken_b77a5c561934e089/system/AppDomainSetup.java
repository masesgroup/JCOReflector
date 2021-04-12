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

package system;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.ActivationContext;
import system.runtime.hosting.ActivationArguments;
import system.AppDomainInitializer;
import system.LoaderOptimization;
import system.security.policy.ApplicationTrust;


/**
 * The base .NET class managing System.AppDomainSetup, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.AppDomainSetup" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.AppDomainSetup</a>
 */
public class AppDomainSetup extends NetObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.AppDomainSetup
     */
    public static final String className = "System.AppDomainSetup";
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

    public AppDomainSetup(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link AppDomainSetup}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link AppDomainSetup} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static AppDomainSetup cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new AppDomainSetup(from.getJCOInstance());
    }

    // Constructors section
    
    public AppDomainSetup() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AppDomainSetup(ActivationContext activationContext) throws Throwable, system.InvalidOperationException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.io.PathTooLongException, system.IndexOutOfRangeException, system.MemberAccessException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(activationContext == null ? null : activationContext.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AppDomainSetup(ActivationArguments activationArguments) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.IndexOutOfRangeException, system.MemberAccessException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(activationArguments == null ? null : activationArguments.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public byte[] GetConfigurationBytes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetConfigurationBytes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexGetConfigurationBytes = 0; indexGetConfigurationBytes < resultingArrayList.size(); indexGetConfigurationBytes++ ) {
				resultingArray[indexGetConfigurationBytes] = (byte)resultingArrayList.get(indexGetConfigurationBytes);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetConfigurationBytes(byte[] value) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetConfigurationBytes", (Object)value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetConfigurationBytes(JCORefOut dupParam0) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetConfigurationBytes", (Object)dupParam0.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getDisallowApplicationBaseProbing() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DisallowApplicationBaseProbing");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDisallowApplicationBaseProbing(boolean DisallowApplicationBaseProbing) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DisallowApplicationBaseProbing", DisallowApplicationBaseProbing);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDisallowBindingRedirects() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DisallowBindingRedirects");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDisallowBindingRedirects(boolean DisallowBindingRedirects) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DisallowBindingRedirects", DisallowBindingRedirects);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDisallowCodeDownload() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DisallowCodeDownload");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDisallowCodeDownload(boolean DisallowCodeDownload) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DisallowCodeDownload", DisallowCodeDownload);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDisallowPublisherPolicy() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DisallowPublisherPolicy");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDisallowPublisherPolicy(boolean DisallowPublisherPolicy) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DisallowPublisherPolicy", DisallowPublisherPolicy);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSandboxInterop() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SandboxInterop");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSandboxInterop(boolean SandboxInterop) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SandboxInterop", SandboxInterop);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AppDomainInitializer getAppDomainInitializer() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (AppDomainInitializer)classInstance.Get("AppDomainInitializer");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAppDomainInitializer(AppDomainInitializer AppDomainInitializer) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AppDomainInitializer", AppDomainInitializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public LoaderOptimization getLoaderOptimization() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LoaderOptimization");
            return new LoaderOptimization(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLoaderOptimization(LoaderOptimization LoaderOptimization) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LoaderOptimization", LoaderOptimization == null ? null : LoaderOptimization.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActivationArguments getActivationArguments() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ActivationArguments");
            return new ActivationArguments(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setActivationArguments(ActivationArguments ActivationArguments) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ActivationArguments", ActivationArguments == null ? null : ActivationArguments.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ApplicationTrust getApplicationTrust() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.security.XmlSyntaxException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.InvalidOperationException, system.NullReferenceException, system.InvalidCastException, system.RankException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ApplicationTrust");
            return new ApplicationTrust(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setApplicationTrust(ApplicationTrust ApplicationTrust) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.NullReferenceException, system.security.SecurityException, system.runtime.serialization.SerializationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ApplicationTrust", ApplicationTrust == null ? null : ApplicationTrust.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getAppDomainManagerAssembly() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("AppDomainManagerAssembly");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAppDomainManagerAssembly(java.lang.String AppDomainManagerAssembly) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AppDomainManagerAssembly", AppDomainManagerAssembly);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getAppDomainManagerType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("AppDomainManagerType");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAppDomainManagerType(java.lang.String AppDomainManagerType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AppDomainManagerType", AppDomainManagerType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getApplicationBase() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ApplicationBase");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setApplicationBase(java.lang.String ApplicationBase) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.io.PathTooLongException, system.MemberAccessException, system.OutOfMemoryException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ApplicationBase", ApplicationBase);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getApplicationName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ApplicationName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setApplicationName(java.lang.String ApplicationName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ApplicationName", ApplicationName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getCachePath() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("CachePath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCachePath(java.lang.String CachePath) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.io.PathTooLongException, system.MemberAccessException, system.OutOfMemoryException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CachePath", CachePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getConfigurationFile() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ConfigurationFile");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setConfigurationFile(java.lang.String ConfigurationFile) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ConfigurationFile", ConfigurationFile);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDynamicBase() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DynamicBase");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDynamicBase(java.lang.String DynamicBase) throws Throwable, system.MemberAccessException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.io.PathTooLongException, system.OutOfMemoryException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DynamicBase", DynamicBase);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getLicenseFile() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("LicenseFile");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLicenseFile(java.lang.String LicenseFile) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LicenseFile", LicenseFile);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getPrivateBinPath() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("PrivateBinPath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPrivateBinPath(java.lang.String PrivateBinPath) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("PrivateBinPath", PrivateBinPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getPrivateBinPathProbe() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("PrivateBinPathProbe");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPrivateBinPathProbe(java.lang.String PrivateBinPathProbe) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("PrivateBinPathProbe", PrivateBinPathProbe);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getShadowCopyDirectories() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ShadowCopyDirectories");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setShadowCopyDirectories(java.lang.String ShadowCopyDirectories) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ShadowCopyDirectories", ShadowCopyDirectories);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getShadowCopyFiles() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ShadowCopyFiles");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setShadowCopyFiles(java.lang.String ShadowCopyFiles) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.TypeLoadException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ShadowCopyFiles", ShadowCopyFiles);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTargetFrameworkName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("TargetFrameworkName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTargetFrameworkName(java.lang.String TargetFrameworkName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TargetFrameworkName", TargetFrameworkName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String[] getAppDomainInitializerArguments() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("AppDomainInitializerArguments");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexAppDomainInitializerArguments = 0; indexAppDomainInitializerArguments < resultingArrayList.size(); indexAppDomainInitializerArguments++ ) {
				resultingArray[indexAppDomainInitializerArguments] = (java.lang.String)resultingArrayList.get(indexAppDomainInitializerArguments);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAppDomainInitializerArguments(java.lang.String[] AppDomainInitializerArguments) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AppDomainInitializerArguments", AppDomainInitializerArguments);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String[] getPartialTrustVisibleAssemblies() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("PartialTrustVisibleAssemblies");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexPartialTrustVisibleAssemblies = 0; indexPartialTrustVisibleAssemblies < resultingArrayList.size(); indexPartialTrustVisibleAssemblies++ ) {
				resultingArray[indexPartialTrustVisibleAssemblies] = (java.lang.String)resultingArrayList.get(indexPartialTrustVisibleAssemblies);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPartialTrustVisibleAssemblies(java.lang.String[] PartialTrustVisibleAssemblies) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("PartialTrustVisibleAssemblies", PartialTrustVisibleAssemblies);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}