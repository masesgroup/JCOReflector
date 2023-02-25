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

package system.xml.xsl.runtime;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.xml.schema.XmlAtomicValue;
import system.xml.xsl.runtime.XmlQueryRuntime;
import system.DateTime;
import system.Decimal;
import system.Single;
import system.TimeSpan;
import system.xml.XmlQualifiedName;


/**
 * The base .NET class managing System.Xml.Xsl.Runtime.XmlILStorageConverter, System.Data.SqlXml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Xml.Xsl.Runtime.XmlILStorageConverter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Xml.Xsl.Runtime.XmlILStorageConverter</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class XmlILStorageConverter extends NetObject  {
    /**
     * Fully assembly qualified name: System.Data.SqlXml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Data.SqlXml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Data.SqlXml
     */
    public static final String assemblyShortName = "System.Data.SqlXml";
    /**
     * Qualified class name: System.Xml.Xsl.Runtime.XmlILStorageConverter
     */
    public static final String className = "System.Xml.Xsl.Runtime.XmlILStorageConverter";
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
    public XmlILStorageConverter(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link XmlILStorageConverter}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link XmlILStorageConverter} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static XmlILStorageConverter cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new XmlILStorageConverter(from.getJCOInstance());
    }

    // Constructors section
    
    public XmlILStorageConverter() throws Throwable {
    }

    
    // Methods section
    
    public static XmlAtomicValue BooleanToAtomicValue(boolean value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBooleanToAtomicValue = (JCObject)classType.Invoke("BooleanToAtomicValue", value, index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objBooleanToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue BytesToAtomicValue(byte[] value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBytesToAtomicValue = (JCObject)classType.Invoke("BytesToAtomicValue", value, index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objBytesToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue BytesToAtomicValue(JCORefOut dupParam0, int dupParam1, XmlQueryRuntime dupParam2) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objBytesToAtomicValue = (JCObject)classType.Invoke("BytesToAtomicValue", dupParam0.getJCRefOut(), dupParam1, dupParam2 == null ? null : dupParam2.getJCOInstance());
            return new XmlAtomicValue(objBytesToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue DateTimeToAtomicValue(DateTime value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objDateTimeToAtomicValue = (JCObject)classType.Invoke("DateTimeToAtomicValue", value == null ? null : value.getJCOInstance(), index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objDateTimeToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue DecimalToAtomicValue(Decimal value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objDecimalToAtomicValue = (JCObject)classType.Invoke("DecimalToAtomicValue", value == null ? null : value.getJCOInstance(), index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objDecimalToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue DoubleToAtomicValue(double value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objDoubleToAtomicValue = (JCObject)classType.Invoke("DoubleToAtomicValue", value, index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objDoubleToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue Int32ToAtomicValue(int value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objInt32ToAtomicValue = (JCObject)classType.Invoke("Int32ToAtomicValue", value, index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objInt32ToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue Int64ToAtomicValue(long value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objInt64ToAtomicValue = (JCObject)classType.Invoke("Int64ToAtomicValue", value, index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objInt64ToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue SingleToAtomicValue(Single value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objSingleToAtomicValue = (JCObject)classType.Invoke("SingleToAtomicValue", value == null ? null : value.getJCOInstance(), index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objSingleToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue StringToAtomicValue(java.lang.String value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objStringToAtomicValue = (JCObject)classType.Invoke("StringToAtomicValue", value, index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objStringToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue TimeSpanToAtomicValue(TimeSpan value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objTimeSpanToAtomicValue = (JCObject)classType.Invoke("TimeSpanToAtomicValue", value == null ? null : value.getJCOInstance(), index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objTimeSpanToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XmlAtomicValue XmlQualifiedNameToAtomicValue(XmlQualifiedName value, int index, XmlQueryRuntime runtime) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objXmlQualifiedNameToAtomicValue = (JCObject)classType.Invoke("XmlQualifiedNameToAtomicValue", value == null ? null : value.getJCOInstance(), index, runtime == null ? null : runtime.getJCOInstance());
            return new XmlAtomicValue(objXmlQualifiedNameToAtomicValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}