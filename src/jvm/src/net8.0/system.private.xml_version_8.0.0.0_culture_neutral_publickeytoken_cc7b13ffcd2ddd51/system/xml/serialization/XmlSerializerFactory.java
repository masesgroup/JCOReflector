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

package system.xml.serialization;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.xml.serialization.XmlSerializer;
import system.xml.serialization.XmlAttributeOverrides;
import system.xml.serialization.XmlRootAttribute;
import system.xml.serialization.XmlTypeMapping;


/**
 * The base .NET class managing System.Xml.Serialization.XmlSerializerFactory, System.Private.Xml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Xml.Serialization.XmlSerializerFactory" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Xml.Serialization.XmlSerializerFactory</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class XmlSerializerFactory extends NetObject  {
    /**
     * Fully assembly qualified name: System.Private.Xml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Private.Xml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Private.Xml
     */
    public static final String assemblyShortName = "System.Private.Xml";
    /**
     * Qualified class name: System.Xml.Serialization.XmlSerializerFactory
     */
    public static final String className = "System.Xml.Serialization.XmlSerializerFactory";
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
    public XmlSerializerFactory(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link XmlSerializerFactory}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link XmlSerializerFactory} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static XmlSerializerFactory cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new XmlSerializerFactory(from.getJCOInstance());
    }

    // Constructors section
    
    public XmlSerializerFactory() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public XmlSerializer CreateSerializer(NetType type, java.lang.String defaultNamespace) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.FormatException, system.ArrayTypeMismatchException, system.security.cryptography.CryptographicException, system.OutOfMemoryException, system.io.FileNotFoundException, system.RankException, system.diagnostics.tracing.EventSourceException, system.globalization.CultureNotFoundException, system.MulticastNotSupportedException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.io.FileLoadException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance(), defaultNamespace);
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(NetType type, NetType[] extraTypes) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance(), toObjectFromArray(extraTypes));
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(NetType type, XmlAttributeOverrides overrides, NetType[] extraTypes, XmlRootAttribute root, java.lang.String defaultNamespace, java.lang.String location) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException, system.FormatException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance(), overrides == null ? null : overrides.getJCOInstance(), toObjectFromArray(extraTypes), root == null ? null : root.getJCOInstance(), defaultNamespace, location);
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(NetType type, XmlAttributeOverrides overrides, NetType[] extraTypes, XmlRootAttribute root, java.lang.String defaultNamespace) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance(), overrides == null ? null : overrides.getJCOInstance(), toObjectFromArray(extraTypes), root == null ? null : root.getJCOInstance(), defaultNamespace);
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(NetType type, XmlAttributeOverrides overrides) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance(), overrides == null ? null : overrides.getJCOInstance());
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(NetType type, XmlRootAttribute root) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance(), root == null ? null : root.getJCOInstance());
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(NetType type) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.io.FileNotFoundException, system.diagnostics.tracing.EventSourceException, system.globalization.CultureNotFoundException, system.MulticastNotSupportedException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.io.FileLoadException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", type == null ? null : type.getJCOInstance());
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlSerializer CreateSerializer(XmlTypeMapping xmlTypeMapping) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSerializer = (JCObject)classInstance.Invoke("CreateSerializer", xmlTypeMapping == null ? null : xmlTypeMapping.getJCOInstance());
            return new XmlSerializer(objCreateSerializer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}