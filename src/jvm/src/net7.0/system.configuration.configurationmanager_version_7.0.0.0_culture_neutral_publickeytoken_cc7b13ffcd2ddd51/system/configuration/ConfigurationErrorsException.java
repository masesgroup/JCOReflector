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

package system.configuration;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.configuration.ConfigurationException;
import system.xml.XmlNode;
import system.xml.XmlReader;
import system.runtime.serialization.SerializationInfo;
import system.runtime.serialization.StreamingContext;
import system.collections.ICollection;
import system.collections.ICollectionImplementation;

/**
 * The base .NET class managing System.Configuration.ConfigurationErrorsException, System.Configuration.ConfigurationManager, Version=7.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.ConfigurationErrorsException" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.ConfigurationErrorsException</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ConfigurationErrorsException extends ConfigurationException {
    /**
     * Fully assembly qualified name: System.Configuration.ConfigurationManager, Version=7.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Configuration.ConfigurationManager, Version=7.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Configuration.ConfigurationManager
     */
    public static final String assemblyShortName = "System.Configuration.ConfigurationManager";
    /**
     * Qualified class name: System.Configuration.ConfigurationErrorsException
     */
    public static final String className = "System.Configuration.ConfigurationErrorsException";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;
    JCNativeException jcNativeException = null;

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
        } catch (JCException jce) {
            JCOReflector.writeLog(jce);
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

    public ConfigurationErrorsException() {
        super();
    }
    /**
     * Internal constructor. Use with caution 
     */
    public ConfigurationErrorsException(java.lang.Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else if (instance instanceof JCNativeException) {
            jcNativeException = (JCNativeException) instance;
            classInstance = jcNativeException.getCLRException();
        }
    }

    public ConfigurationErrorsException(String message) {
        super(message);
    }

    public ConfigurationErrorsException(NetException cause) {
        super(cause);
    }

    public ConfigurationErrorsException(String message, NetException cause) {
        super(message, cause);
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ConfigurationErrorsException}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ConfigurationErrorsException} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ConfigurationErrorsException cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ConfigurationErrorsException(from.getJCOInstance());
    }

    // Constructors section
    
    public ConfigurationErrorsException(java.lang.String message, NetException inner, java.lang.String filename, int line) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, inner == null ? null : inner.getJCOInstance(), filename, line));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationErrorsException(java.lang.String message, NetException inner, XmlNode node) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, inner == null ? null : inner.getJCOInstance(), node == null ? null : node.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationErrorsException(java.lang.String message, NetException inner, XmlReader reader) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, inner == null ? null : inner.getJCOInstance(), reader == null ? null : reader.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationErrorsException(java.lang.String message, java.lang.String filename, int line) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, filename, line));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationErrorsException(java.lang.String message, XmlNode node) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, node == null ? null : node.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ConfigurationErrorsException(java.lang.String message, XmlReader reader) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, reader == null ? null : reader.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public static int GetLineNumber(XmlNode node) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("GetLineNumber", node == null ? null : node.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int GetLineNumber(XmlReader reader) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("GetLineNumber", reader == null ? null : reader.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String GetFilename(XmlNode node) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("GetFilename", node == null ? null : node.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String GetFilename(XmlReader reader) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("GetFilename", reader == null ? null : reader.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void GetObjectData(SerializationInfo info, StreamingContext context) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.runtime.serialization.SerializationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.FormatException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetObjectData", info == null ? null : info.getJCOInstance(), context == null ? null : context.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public ICollection getErrors() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Errors");
            return new ICollectionImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}