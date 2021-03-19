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

package system.reflection;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Reflection.FieldAttributes, System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.FieldAttributes" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.FieldAttributes</a>
 */
public class FieldAttributes extends NetObject  {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.Reflection.FieldAttributes
     */
    public static final String className = "System.Reflection.FieldAttributes";
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

    public FieldAttributes(Object instance) {
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

    public FieldAttributes() {
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

    final static FieldAttributes getFrom(JCEnum object, String value) {
        try {
            return new FieldAttributes(object.fromValue(value));
        } catch (JCException e) {
            return new FieldAttributes(object);
        }
    }

    // Enum fields section
    
    public static FieldAttributes PrivateScope = getFrom(enumReflected, "PrivateScope");
    public static FieldAttributes Private = getFrom(enumReflected, "Private");
    public static FieldAttributes FamANDAssem = getFrom(enumReflected, "FamANDAssem");
    public static FieldAttributes Assembly = getFrom(enumReflected, "Assembly");
    public static FieldAttributes Family = getFrom(enumReflected, "Family");
    public static FieldAttributes FamORAssem = getFrom(enumReflected, "FamORAssem");
    public static FieldAttributes Public = getFrom(enumReflected, "Public");
    public static FieldAttributes FieldAccessMask = getFrom(enumReflected, "FieldAccessMask");
    public static FieldAttributes Static = getFrom(enumReflected, "Static");
    public static FieldAttributes InitOnly = getFrom(enumReflected, "InitOnly");
    public static FieldAttributes Literal = getFrom(enumReflected, "Literal");
    public static FieldAttributes NotSerialized = getFrom(enumReflected, "NotSerialized");
    public static FieldAttributes HasFieldRVA = getFrom(enumReflected, "HasFieldRVA");
    public static FieldAttributes SpecialName = getFrom(enumReflected, "SpecialName");
    public static FieldAttributes RTSpecialName = getFrom(enumReflected, "RTSpecialName");
    public static FieldAttributes HasFieldMarshal = getFrom(enumReflected, "HasFieldMarshal");
    public static FieldAttributes PinvokeImpl = getFrom(enumReflected, "PinvokeImpl");
    public static FieldAttributes HasDefault = getFrom(enumReflected, "HasDefault");
    public static FieldAttributes ReservedMask = getFrom(enumReflected, "ReservedMask");


    // Flags management section

    public final FieldAttributes add(FieldAttributes val) throws Throwable {
        return new FieldAttributes(NetEnum.add(classInstance, val.classInstance));
    }

    public final FieldAttributes remove(FieldAttributes val) throws Throwable {
        return new FieldAttributes(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(FieldAttributes val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(FieldAttributes val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}