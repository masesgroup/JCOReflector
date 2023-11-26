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

package system.runtime.serialization.datacontracts;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.runtime.serialization.datacontracts.DataContract;
import system.xml.XmlQualifiedName;
import system.xml.XmlDictionaryString;


/**
 * The base .NET class managing System.Runtime.Serialization.DataContracts.DataContract, System.Private.DataContractSerialization, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Serialization.DataContracts.DataContract" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Serialization.DataContracts.DataContract</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class DataContract extends NetObject  {
    /**
     * Fully assembly qualified name: System.Private.DataContractSerialization, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Private.DataContractSerialization, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Private.DataContractSerialization
     */
    public static final String assemblyShortName = "System.Private.DataContractSerialization";
    /**
     * Qualified class name: System.Runtime.Serialization.DataContracts.DataContract
     */
    public static final String className = "System.Runtime.Serialization.DataContracts.DataContract";
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
    public DataContract(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DataContract}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DataContract} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DataContract cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DataContract(from.getJCOInstance());
    }

    // Constructors section
    
    public DataContract() throws Throwable {
    }

    
    // Methods section
    
    public boolean IsDictionaryLike(JCORefOut keyName, JCORefOut valueName, JCORefOut itemName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsDictionaryLike", keyName.getJCRefOut(), valueName.getJCRefOut(), itemName.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DataContract GetBuiltInDataContract(java.lang.String name, java.lang.String ns) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.runtime.serialization.InvalidDataContractException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetBuiltInDataContract = (JCObject)classType.Invoke("GetBuiltInDataContract", name, ns);
            return new DataContract(objGetBuiltInDataContract);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlQualifiedName GetArrayTypeName(boolean isNullable) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.xml.schema.XmlSchemaException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.runtime.serialization.InvalidDataContractException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotImplementedException, system.text.regularexpressions.RegexMatchTimeoutException, system.ArrayTypeMismatchException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetArrayTypeName = (JCObject)classInstance.Invoke("GetArrayTypeName", isNullable);
            return new XmlQualifiedName(objGetArrayTypeName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlQualifiedName GetXmlName(NetType type) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.runtime.serialization.InvalidDataContractException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetXmlName = (JCObject)classType.Invoke("GetXmlName", type == null ? null : type.getJCOInstance());
            return new XmlQualifiedName(objGetXmlName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getIsBuiltInDataContract() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsBuiltInDataContract");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsISerializable() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsISerializable");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIsISerializable(boolean IsISerializable) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.NotSupportedException, system.runtime.serialization.InvalidDataContractException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IsISerializable", IsISerializable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsReference() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsReference");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIsReference(boolean IsReference) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IsReference", IsReference);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsValueType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsValueType");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIsValueType(boolean IsValueType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IsValueType", IsValueType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DataContract getBaseContract() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("BaseContract");
            return new DataContract(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getContractType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ContractType");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType getOriginalUnderlyingType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("OriginalUnderlyingType");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType getUnderlyingType() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("UnderlyingType");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlDictionaryString getTopLevelElementName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TopLevelElementName");
            return new XmlDictionaryString(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTopLevelElementName(XmlDictionaryString TopLevelElementName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TopLevelElementName", TopLevelElementName == null ? null : TopLevelElementName.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlDictionaryString getTopLevelElementNamespace() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TopLevelElementNamespace");
            return new XmlDictionaryString(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTopLevelElementNamespace(XmlDictionaryString TopLevelElementNamespace) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TopLevelElementNamespace", TopLevelElementNamespace == null ? null : TopLevelElementNamespace.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlQualifiedName getXmlName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("XmlName");
            return new XmlQualifiedName(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setXmlName(XmlQualifiedName XmlName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("XmlName", XmlName == null ? null : XmlName.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}