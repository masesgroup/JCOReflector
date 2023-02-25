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

package microsoft.build.framework;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import microsoft.build.framework.IBuildEngine3;
import microsoft.build.framework.IBuildEngine3Implementation;
import microsoft.build.framework.IBuildEngine2;
import microsoft.build.framework.IBuildEngine2Implementation;
import microsoft.build.framework.IBuildEngine;
import microsoft.build.framework.IBuildEngineImplementation;
import system.collections.IDictionary;
import system.collections.IDictionaryImplementation;
import microsoft.build.framework.BuildEngineResult;
import microsoft.build.framework.RegisteredTaskObjectLifetime;
import microsoft.build.framework.CustomBuildEventArgs;
import microsoft.build.framework.BuildErrorEventArgs;
import microsoft.build.framework.BuildMessageEventArgs;
import microsoft.build.framework.BuildWarningEventArgs;


/**
 * The base .NET class managing Microsoft.Build.Framework.IBuildEngine4, Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.Build.Framework.IBuildEngine4" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.Build.Framework.IBuildEngine4</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class IBuildEngine4Implementation extends NetObject implements IBuildEngine4 {
    /**
     * Fully assembly qualified name: Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.Build.Framework
     */
    public static final String assemblyShortName = "Microsoft.Build.Framework";
    /**
     * Qualified class name: Microsoft.Build.Framework.IBuildEngine4
     */
    public static final String className = "Microsoft.Build.Framework.IBuildEngine4";
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
    public IBuildEngine4Implementation(java.lang.Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IBuildEngine4}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IBuildEngine4} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IBuildEngine4 ToIBuildEngine4(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IBuildEngine4Implementation(from.getJCOInstance());
    }

    // Methods section
    
    public boolean BuildProjectFile(java.lang.String projectFileName, java.lang.String[] targetNames, IDictionary globalProperties, IDictionary targetOutputs) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("BuildProjectFile", projectFileName, targetNames, globalProperties == null ? null : globalProperties.getJCOInstance(), targetOutputs == null ? null : targetOutputs.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean BuildProjectFile(java.lang.String dupParam0, JCORefOut dupParam1, IDictionary dupParam2, IDictionary dupParam3) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("BuildProjectFile", dupParam0, dupParam1.getJCRefOut(), dupParam2 == null ? null : dupParam2.getJCOInstance(), dupParam3 == null ? null : dupParam3.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean BuildProjectFile(java.lang.String projectFileName, java.lang.String[] targetNames, IDictionary globalProperties, IDictionary targetOutputs, java.lang.String toolsVersion) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("BuildProjectFile", projectFileName, targetNames, globalProperties == null ? null : globalProperties.getJCOInstance(), targetOutputs == null ? null : targetOutputs.getJCOInstance(), toolsVersion);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean BuildProjectFile(java.lang.String dupParam0, JCORefOut dupParam1, IDictionary dupParam2, IDictionary dupParam3, java.lang.String dupParam4) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("BuildProjectFile", dupParam0, dupParam1.getJCRefOut(), dupParam2 == null ? null : dupParam2.getJCOInstance(), dupParam3 == null ? null : dupParam3.getJCOInstance(), dupParam4);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean BuildProjectFilesInParallel(java.lang.String[] projectFileNames, java.lang.String[] targetNames, IDictionary[] globalProperties, IDictionary[] targetOutputsPerProject, java.lang.String[] toolsVersion, boolean useResultsCache, boolean unloadProjectsOnCompletion) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("BuildProjectFilesInParallel", projectFileNames, targetNames, toObjectFromArray(globalProperties), toObjectFromArray(targetOutputsPerProject), toolsVersion, useResultsCache, unloadProjectsOnCompletion);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean BuildProjectFilesInParallel(JCORefOut dupParam0, JCORefOut dupParam1, IDictionary[] dupParam2, IDictionary[] dupParam3, JCORefOut dupParam4, boolean dupParam5, boolean dupParam6) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("BuildProjectFilesInParallel", dupParam0.getJCRefOut(), dupParam1.getJCRefOut(), toObjectFromArray(dupParam2), toObjectFromArray(dupParam3), dupParam4.getJCRefOut(), dupParam5, dupParam6);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetRegisteredTaskObject(NetObject key, RegisteredTaskObjectLifetime lifetime) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRegisteredTaskObject = (JCObject)classInstance.Invoke("GetRegisteredTaskObject", key == null ? null : key.getJCOInstance(), lifetime == null ? null : lifetime.getJCOInstance());
            return new NetObject(objGetRegisteredTaskObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject UnregisterTaskObject(NetObject key, RegisteredTaskObjectLifetime lifetime) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objUnregisterTaskObject = (JCObject)classInstance.Invoke("UnregisterTaskObject", key == null ? null : key.getJCOInstance(), lifetime == null ? null : lifetime.getJCOInstance());
            return new NetObject(objUnregisterTaskObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LogCustomEvent(CustomBuildEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LogCustomEvent", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LogErrorEvent(BuildErrorEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LogErrorEvent", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LogMessageEvent(BuildMessageEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LogMessageEvent", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LogWarningEvent(BuildWarningEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LogWarningEvent", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Reacquire() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Reacquire");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RegisterTaskObject(NetObject key, NetObject obj, RegisteredTaskObjectLifetime lifetime, boolean allowEarlyCollection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RegisterTaskObject", key == null ? null : key.getJCOInstance(), obj == null ? null : obj.getJCOInstance(), lifetime == null ? null : lifetime.getJCOInstance(), allowEarlyCollection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Yield() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Yield");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getContinueOnError() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ContinueOnError");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsRunningMultipleNodes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsRunningMultipleNodes");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getColumnNumberOfTaskNode() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ColumnNumberOfTaskNode");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getLineNumberOfTaskNode() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("LineNumberOfTaskNode");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getProjectFileOfTaskNode() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ProjectFileOfTaskNode");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}