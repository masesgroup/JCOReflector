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
import system.collections.specialized.NameValueCollection;


/**
 * The base .NET class managing System.Configuration.ConfigurationSettings, System.Configuration.ConfigurationManager, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.ConfigurationSettings" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.ConfigurationSettings</a>
 */
public class ConfigurationSettings extends NetObject  {
    /**
     * Fully assembly qualified name: System.Configuration.ConfigurationManager, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Configuration.ConfigurationManager, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Configuration.ConfigurationManager
     */
    public static final String assemblyShortName = "System.Configuration.ConfigurationManager";
    /**
     * Qualified class name: System.Configuration.ConfigurationSettings
     */
    public static final String className = "System.Configuration.ConfigurationSettings";
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

    public ConfigurationSettings(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ConfigurationSettings}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ConfigurationSettings} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ConfigurationSettings cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ConfigurationSettings(from.getJCOInstance());
    }

    // Constructors section
    
    public ConfigurationSettings() throws Throwable {
    }



    
    // Methods section
    
    public static NetObject GetConfig(java.lang.String sectionName) throws Throwable, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetConfig = (JCObject)classType.Invoke("GetConfig", sectionName);
            return new NetObject(objGetConfig);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static NameValueCollection getAppSettings() throws Throwable, system.ArgumentException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("AppSettings");
            return new NameValueCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}