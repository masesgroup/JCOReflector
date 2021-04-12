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

package system.reflection.metadata;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.ValueType;
import system.reflection.AssemblyName;
import system.reflection.metadata.CustomAttributeHandleCollection;
import system.reflection.metadata.DeclarativeSecurityAttributeHandleCollection;
import system.reflection.AssemblyFlags;
import system.reflection.AssemblyHashAlgorithm;
import system.reflection.metadata.BlobHandle;
import system.reflection.metadata.StringHandle;
import system.Version;


/**
 * The base .NET class managing System.Reflection.Metadata.AssemblyDefinition, System.Reflection.Metadata, Version=1.4.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.Metadata.AssemblyDefinition" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.Metadata.AssemblyDefinition</a>
 */
public class AssemblyDefinition extends ValueType  {
    /**
     * Fully assembly qualified name: System.Reflection.Metadata, Version=1.4.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Reflection.Metadata, Version=1.4.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Reflection.Metadata
     */
    public static final String assemblyShortName = "System.Reflection.Metadata";
    /**
     * Qualified class name: System.Reflection.Metadata.AssemblyDefinition
     */
    public static final String className = "System.Reflection.Metadata.AssemblyDefinition";
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

    public AssemblyDefinition(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link AssemblyDefinition}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link AssemblyDefinition} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static AssemblyDefinition cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new AssemblyDefinition(from.getJCOInstance());
    }

    // Constructors section
    
    public AssemblyDefinition() throws Throwable {
    }



    
    // Methods section
    
    public AssemblyName GetAssemblyName() throws Throwable, system.BadImageFormatException, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.FormatException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetAssemblyName = (JCObject)classInstance.Invoke("GetAssemblyName");
            return new AssemblyName(objGetAssemblyName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CustomAttributeHandleCollection GetCustomAttributes() throws Throwable, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetCustomAttributes = (JCObject)classInstance.Invoke("GetCustomAttributes");
            return new CustomAttributeHandleCollection(objGetCustomAttributes);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DeclarativeSecurityAttributeHandleCollection GetDeclarativeSecurityAttributes() throws Throwable, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetDeclarativeSecurityAttributes = (JCObject)classInstance.Invoke("GetDeclarativeSecurityAttributes");
            return new DeclarativeSecurityAttributeHandleCollection(objGetDeclarativeSecurityAttributes);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public AssemblyFlags getFlags() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Flags");
            return new AssemblyFlags(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AssemblyHashAlgorithm getHashAlgorithm() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("HashAlgorithm");
            return new AssemblyHashAlgorithm(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public BlobHandle getPublicKey() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("PublicKey");
            return new BlobHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StringHandle getCulture() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Culture");
            return new StringHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StringHandle getName() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.BadImageFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Name");
            return new StringHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Version getVersion() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.BadImageFormatException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Version");
            return new Version(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}