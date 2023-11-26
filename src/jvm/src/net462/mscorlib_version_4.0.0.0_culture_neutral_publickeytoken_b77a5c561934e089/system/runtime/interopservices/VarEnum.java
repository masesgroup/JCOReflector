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

package system.runtime.interopservices;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Runtime.InteropServices.VarEnum, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.VarEnum" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.VarEnum</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class VarEnum extends NetObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Runtime.InteropServices.VarEnum
     */
    public static final String className = "System.Runtime.InteropServices.VarEnum";
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
    /**
     * Internal constructor. Use with caution 
     */
    public VarEnum(java.lang.Object instance) {
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

    public VarEnum() {
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

    public java.lang.Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    final static VarEnum getFrom(JCEnum object, String value) {
        try {
            return new VarEnum(object.fromValue(value));
        } catch (JCException e) {
            return new VarEnum(object);
        }
    }

    // Enum fields section
    
    public static VarEnum VT_EMPTY = getFrom(enumReflected, "VT_EMPTY");
    public static VarEnum VT_NULL = getFrom(enumReflected, "VT_NULL");
    public static VarEnum VT_I2 = getFrom(enumReflected, "VT_I2");
    public static VarEnum VT_I4 = getFrom(enumReflected, "VT_I4");
    public static VarEnum VT_R4 = getFrom(enumReflected, "VT_R4");
    public static VarEnum VT_R8 = getFrom(enumReflected, "VT_R8");
    public static VarEnum VT_CY = getFrom(enumReflected, "VT_CY");
    public static VarEnum VT_DATE = getFrom(enumReflected, "VT_DATE");
    public static VarEnum VT_BSTR = getFrom(enumReflected, "VT_BSTR");
    public static VarEnum VT_DISPATCH = getFrom(enumReflected, "VT_DISPATCH");
    public static VarEnum VT_ERROR = getFrom(enumReflected, "VT_ERROR");
    public static VarEnum VT_BOOL = getFrom(enumReflected, "VT_BOOL");
    public static VarEnum VT_VARIANT = getFrom(enumReflected, "VT_VARIANT");
    public static VarEnum VT_UNKNOWN = getFrom(enumReflected, "VT_UNKNOWN");
    public static VarEnum VT_DECIMAL = getFrom(enumReflected, "VT_DECIMAL");
    public static VarEnum VT_I1 = getFrom(enumReflected, "VT_I1");
    public static VarEnum VT_UI1 = getFrom(enumReflected, "VT_UI1");
    public static VarEnum VT_UI2 = getFrom(enumReflected, "VT_UI2");
    public static VarEnum VT_UI4 = getFrom(enumReflected, "VT_UI4");
    public static VarEnum VT_I8 = getFrom(enumReflected, "VT_I8");
    public static VarEnum VT_UI8 = getFrom(enumReflected, "VT_UI8");
    public static VarEnum VT_INT = getFrom(enumReflected, "VT_INT");
    public static VarEnum VT_UINT = getFrom(enumReflected, "VT_UINT");
    public static VarEnum VT_VOID = getFrom(enumReflected, "VT_VOID");
    public static VarEnum VT_HRESULT = getFrom(enumReflected, "VT_HRESULT");
    public static VarEnum VT_PTR = getFrom(enumReflected, "VT_PTR");
    public static VarEnum VT_SAFEARRAY = getFrom(enumReflected, "VT_SAFEARRAY");
    public static VarEnum VT_CARRAY = getFrom(enumReflected, "VT_CARRAY");
    public static VarEnum VT_USERDEFINED = getFrom(enumReflected, "VT_USERDEFINED");
    public static VarEnum VT_LPSTR = getFrom(enumReflected, "VT_LPSTR");
    public static VarEnum VT_LPWSTR = getFrom(enumReflected, "VT_LPWSTR");
    public static VarEnum VT_RECORD = getFrom(enumReflected, "VT_RECORD");
    public static VarEnum VT_FILETIME = getFrom(enumReflected, "VT_FILETIME");
    public static VarEnum VT_BLOB = getFrom(enumReflected, "VT_BLOB");
    public static VarEnum VT_STREAM = getFrom(enumReflected, "VT_STREAM");
    public static VarEnum VT_STORAGE = getFrom(enumReflected, "VT_STORAGE");
    public static VarEnum VT_STREAMED_OBJECT = getFrom(enumReflected, "VT_STREAMED_OBJECT");
    public static VarEnum VT_STORED_OBJECT = getFrom(enumReflected, "VT_STORED_OBJECT");
    public static VarEnum VT_BLOB_OBJECT = getFrom(enumReflected, "VT_BLOB_OBJECT");
    public static VarEnum VT_CF = getFrom(enumReflected, "VT_CF");
    public static VarEnum VT_CLSID = getFrom(enumReflected, "VT_CLSID");
    public static VarEnum VT_VECTOR = getFrom(enumReflected, "VT_VECTOR");
    public static VarEnum VT_ARRAY = getFrom(enumReflected, "VT_ARRAY");
    public static VarEnum VT_BYREF = getFrom(enumReflected, "VT_BYREF");


    // Flags management section


}