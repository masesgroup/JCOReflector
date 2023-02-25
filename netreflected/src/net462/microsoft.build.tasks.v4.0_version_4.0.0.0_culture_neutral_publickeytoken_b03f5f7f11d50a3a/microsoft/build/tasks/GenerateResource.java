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

package microsoft.build.tasks;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import microsoft.build.tasks.TaskExtension;
import microsoft.build.framework.ITaskItem;
import microsoft.build.framework.ITaskItemImplementation;


/**
 * The base .NET class managing Microsoft.Build.Tasks.GenerateResource, Microsoft.Build.Tasks.v4.0, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.Build.Tasks.GenerateResource" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.Build.Tasks.GenerateResource</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class GenerateResource extends TaskExtension  {
    /**
     * Fully assembly qualified name: Microsoft.Build.Tasks.v4.0, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.Build.Tasks.v4.0, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.Build.Tasks.v4.0
     */
    public static final String assemblyShortName = "Microsoft.Build.Tasks.v4.0";
    /**
     * Qualified class name: Microsoft.Build.Tasks.GenerateResource
     */
    public static final String className = "Microsoft.Build.Tasks.GenerateResource";
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
    public GenerateResource(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link GenerateResource}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link GenerateResource} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static GenerateResource cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new GenerateResource(from.getJCOInstance());
    }

    // Constructors section
    
    public GenerateResource() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean Execute() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.TypeLoadException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.NullReferenceException, system.security.SecurityException, system.io.IOException, system.runtime.serialization.SerializationException, system.FormatException, system.io.PathTooLongException, system.OverflowException, system.configuration.ConfigurationErrorsException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.UnauthorizedAccessException, system.xml.XmlException, system.MulticastNotSupportedException, system.BadImageFormatException, system.RankException, system.CannotUnloadAppDomainException, system.runtime.remoting.RemotingException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Execute");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getExecuteAsTool() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ExecuteAsTool");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExecuteAsTool(boolean ExecuteAsTool) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ExecuteAsTool", ExecuteAsTool);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getExtractResWFiles() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ExtractResWFiles");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExtractResWFiles(boolean ExtractResWFiles) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ExtractResWFiles", ExtractResWFiles);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getMinimalRebuildFromTracking() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("MinimalRebuildFromTracking");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setMinimalRebuildFromTracking(boolean MinimalRebuildFromTracking) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("MinimalRebuildFromTracking", MinimalRebuildFromTracking);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getNeverLockTypeAssemblies() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("NeverLockTypeAssemblies");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setNeverLockTypeAssemblies(boolean NeverLockTypeAssemblies) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("NeverLockTypeAssemblies", NeverLockTypeAssemblies);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getPublicClass() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("PublicClass");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPublicClass(boolean PublicClass) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("PublicClass", PublicClass);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getTrackFileAccess() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("TrackFileAccess");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTrackFileAccess(boolean TrackFileAccess) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TrackFileAccess", TrackFileAccess);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getUseSourcePath() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("UseSourcePath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setUseSourcePath(boolean UseSourcePath) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("UseSourcePath", UseSourcePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ITaskItem getStateFile() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("StateFile");
            return new ITaskItemImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStateFile(ITaskItem StateFile) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StateFile", StateFile == null ? null : StateFile.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getAdditionalInputs() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("AdditionalInputs");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAdditionalInputs(ITaskItem[] AdditionalInputs) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AdditionalInputs", toObjectFromArray(AdditionalInputs));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getExcludedInputPaths() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("ExcludedInputPaths");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExcludedInputPaths(ITaskItem[] ExcludedInputPaths) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ExcludedInputPaths", toObjectFromArray(ExcludedInputPaths));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getFilesWritten() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("FilesWritten");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getOutputResources() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("OutputResources");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOutputResources(ITaskItem[] OutputResources) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("OutputResources", toObjectFromArray(OutputResources));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getReferences() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("References");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReferences(ITaskItem[] References) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("References", toObjectFromArray(References));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getSources() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("Sources");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSources(ITaskItem[] Sources) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Sources", toObjectFromArray(Sources));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getTLogReadFiles() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("TLogReadFiles");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final ITaskItem[] getTLogWriteFiles() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ITaskItem> resultingArrayList = new ArrayList<ITaskItem>();
            JCObject resultingObjects = (JCObject)classInstance.Get("TLogWriteFiles");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ITaskItemImplementation(resultingObject));
            }
            ITaskItem[] resultingArray = new ITaskItem[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getOutputDirectory() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("OutputDirectory");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOutputDirectory(java.lang.String OutputDirectory) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("OutputDirectory", OutputDirectory);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSdkToolsPath() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("SdkToolsPath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSdkToolsPath(java.lang.String SdkToolsPath) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SdkToolsPath", SdkToolsPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getStronglyTypedClassName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("StronglyTypedClassName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStronglyTypedClassName(java.lang.String StronglyTypedClassName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StronglyTypedClassName", StronglyTypedClassName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getStronglyTypedFileName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("StronglyTypedFileName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStronglyTypedFileName(java.lang.String StronglyTypedFileName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StronglyTypedFileName", StronglyTypedFileName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getStronglyTypedLanguage() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("StronglyTypedLanguage");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStronglyTypedLanguage(java.lang.String StronglyTypedLanguage) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StronglyTypedLanguage", StronglyTypedLanguage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getStronglyTypedManifestPrefix() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("StronglyTypedManifestPrefix");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStronglyTypedManifestPrefix(java.lang.String StronglyTypedManifestPrefix) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StronglyTypedManifestPrefix", StronglyTypedManifestPrefix);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getStronglyTypedNamespace() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("StronglyTypedNamespace");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStronglyTypedNamespace(java.lang.String StronglyTypedNamespace) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StronglyTypedNamespace", StronglyTypedNamespace);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getToolArchitecture() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ToolArchitecture");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setToolArchitecture(java.lang.String ToolArchitecture) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ToolArchitecture", ToolArchitecture);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTrackerFrameworkPath() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("TrackerFrameworkPath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTrackerFrameworkPath(java.lang.String TrackerFrameworkPath) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TrackerFrameworkPath", TrackerFrameworkPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTrackerLogDirectory() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("TrackerLogDirectory");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTrackerLogDirectory(java.lang.String TrackerLogDirectory) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TrackerLogDirectory", TrackerLogDirectory);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTrackerSdkPath() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("TrackerSdkPath");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTrackerSdkPath(java.lang.String TrackerSdkPath) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TrackerSdkPath", TrackerSdkPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String[] getEnvironmentVariables() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("EnvironmentVariables");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexEnvironmentVariables = 0; indexEnvironmentVariables < resultingArrayList.size(); indexEnvironmentVariables++ ) {
				resultingArray[indexEnvironmentVariables] = (java.lang.String)resultingArrayList.get(indexEnvironmentVariables);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEnvironmentVariables(java.lang.String[] EnvironmentVariables) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EnvironmentVariables", EnvironmentVariables);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}