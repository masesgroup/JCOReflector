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

package system.xml.schema;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Xml.Schema.XmlTypeCode, System.Private.Xml, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Xml.Schema.XmlTypeCode" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Xml.Schema.XmlTypeCode</a>
 */
public class XmlTypeCode extends NetObject  {
    /**
     * Fully assembly qualified name: System.Private.Xml, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Private.Xml, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Private.Xml
     */
    public static final String assemblyShortName = "System.Private.Xml";
    /**
     * Qualified class name: System.Xml.Schema.XmlTypeCode
     */
    public static final String className = "System.Xml.Schema.XmlTypeCode";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

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

    static JCEnum createEnum() {
        try {
            String enumToCreate = className + ", "
                    + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Creating Enum %s", enumToCreate);
            JCEnum enumCreated = bridge.GetEnum(enumToCreate);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Created Enum: %s",
                        (enumCreated != null) ? enumCreated.toString() : "Returned null value");
            return enumCreated;
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

    public XmlTypeCode(Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            try {
                String enumName = NetEnum.GetName(classType, (JCObject)instance);
                classInstance = enumReflected.fromValue(enumName);
            } catch (Throwable t) {
                JCOReflector.writeLog(t);
                classInstance = enumReflected;
            }
        } else if (instance instanceof JCEnum) {
            classInstance = (JCEnum)instance;
        }
    }

    public XmlTypeCode() {
        super();
        // add reference to assemblyName.dll file
        try {
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
        } catch (Throwable jcne) {
            JCOReflector.writeLog(jcne);
        }
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

    public JCType getJCOType() {
        return classType;
    }

    final static XmlTypeCode getFrom(JCEnum object, String value) {
        try {
            return new XmlTypeCode(object.fromValue(value));
        } catch (JCException e) {
            return new XmlTypeCode(object);
        }
    }

    // Enum fields section
    
    public static XmlTypeCode None = getFrom(enumReflected, "None");
    public static XmlTypeCode Item = getFrom(enumReflected, "Item");
    public static XmlTypeCode Node = getFrom(enumReflected, "Node");
    public static XmlTypeCode Document = getFrom(enumReflected, "Document");
    public static XmlTypeCode Element = getFrom(enumReflected, "Element");
    public static XmlTypeCode Attribute = getFrom(enumReflected, "Attribute");
    public static XmlTypeCode Namespace = getFrom(enumReflected, "Namespace");
    public static XmlTypeCode ProcessingInstruction = getFrom(enumReflected, "ProcessingInstruction");
    public static XmlTypeCode Comment = getFrom(enumReflected, "Comment");
    public static XmlTypeCode Text = getFrom(enumReflected, "Text");
    public static XmlTypeCode AnyAtomicType = getFrom(enumReflected, "AnyAtomicType");
    public static XmlTypeCode UntypedAtomic = getFrom(enumReflected, "UntypedAtomic");
    public static XmlTypeCode String = getFrom(enumReflected, "String");
    public static XmlTypeCode Boolean = getFrom(enumReflected, "Boolean");
    public static XmlTypeCode Decimal = getFrom(enumReflected, "Decimal");
    public static XmlTypeCode Float = getFrom(enumReflected, "Float");
    public static XmlTypeCode Double = getFrom(enumReflected, "Double");
    public static XmlTypeCode Duration = getFrom(enumReflected, "Duration");
    public static XmlTypeCode DateTime = getFrom(enumReflected, "DateTime");
    public static XmlTypeCode Time = getFrom(enumReflected, "Time");
    public static XmlTypeCode Date = getFrom(enumReflected, "Date");
    public static XmlTypeCode GYearMonth = getFrom(enumReflected, "GYearMonth");
    public static XmlTypeCode GYear = getFrom(enumReflected, "GYear");
    public static XmlTypeCode GMonthDay = getFrom(enumReflected, "GMonthDay");
    public static XmlTypeCode GDay = getFrom(enumReflected, "GDay");
    public static XmlTypeCode GMonth = getFrom(enumReflected, "GMonth");
    public static XmlTypeCode HexBinary = getFrom(enumReflected, "HexBinary");
    public static XmlTypeCode Base64Binary = getFrom(enumReflected, "Base64Binary");
    public static XmlTypeCode AnyUri = getFrom(enumReflected, "AnyUri");
    public static XmlTypeCode QName = getFrom(enumReflected, "QName");
    public static XmlTypeCode Notation = getFrom(enumReflected, "Notation");
    public static XmlTypeCode NormalizedString = getFrom(enumReflected, "NormalizedString");
    public static XmlTypeCode Token = getFrom(enumReflected, "Token");
    public static XmlTypeCode Language = getFrom(enumReflected, "Language");
    public static XmlTypeCode NmToken = getFrom(enumReflected, "NmToken");
    public static XmlTypeCode Name = getFrom(enumReflected, "Name");
    public static XmlTypeCode NCName = getFrom(enumReflected, "NCName");
    public static XmlTypeCode Id = getFrom(enumReflected, "Id");
    public static XmlTypeCode Idref = getFrom(enumReflected, "Idref");
    public static XmlTypeCode Entity = getFrom(enumReflected, "Entity");
    public static XmlTypeCode Integer = getFrom(enumReflected, "Integer");
    public static XmlTypeCode NonPositiveInteger = getFrom(enumReflected, "NonPositiveInteger");
    public static XmlTypeCode NegativeInteger = getFrom(enumReflected, "NegativeInteger");
    public static XmlTypeCode Long = getFrom(enumReflected, "Long");
    public static XmlTypeCode Int = getFrom(enumReflected, "Int");
    public static XmlTypeCode Short = getFrom(enumReflected, "Short");
    public static XmlTypeCode Byte = getFrom(enumReflected, "Byte");
    public static XmlTypeCode NonNegativeInteger = getFrom(enumReflected, "NonNegativeInteger");
    public static XmlTypeCode UnsignedLong = getFrom(enumReflected, "UnsignedLong");
    public static XmlTypeCode UnsignedInt = getFrom(enumReflected, "UnsignedInt");
    public static XmlTypeCode UnsignedShort = getFrom(enumReflected, "UnsignedShort");
    public static XmlTypeCode UnsignedByte = getFrom(enumReflected, "UnsignedByte");
    public static XmlTypeCode PositiveInteger = getFrom(enumReflected, "PositiveInteger");
    public static XmlTypeCode YearMonthDuration = getFrom(enumReflected, "YearMonthDuration");
    public static XmlTypeCode DayTimeDuration = getFrom(enumReflected, "DayTimeDuration");


    // Flags management section


}