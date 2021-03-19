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
 * The base .NET class managing System.Reflection.BindingFlags, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.BindingFlags" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.BindingFlags</a>
 */
public class BindingFlags extends NetObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Reflection.BindingFlags
     */
    public static final String className = "System.Reflection.BindingFlags";
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

    public BindingFlags(Object instance) {
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

    public BindingFlags() {
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

    final static BindingFlags getFrom(JCEnum object, String value) {
        try {
            return new BindingFlags(object.fromValue(value));
        } catch (JCException e) {
            return new BindingFlags(object);
        }
    }

    // Enum fields section
    
    public static BindingFlags Default = getFrom(enumReflected, "Default");
    public static BindingFlags IgnoreCase = getFrom(enumReflected, "IgnoreCase");
    public static BindingFlags DeclaredOnly = getFrom(enumReflected, "DeclaredOnly");
    public static BindingFlags Instance = getFrom(enumReflected, "Instance");
    public static BindingFlags Static = getFrom(enumReflected, "Static");
    public static BindingFlags Public = getFrom(enumReflected, "Public");
    public static BindingFlags NonPublic = getFrom(enumReflected, "NonPublic");
    public static BindingFlags FlattenHierarchy = getFrom(enumReflected, "FlattenHierarchy");
    public static BindingFlags InvokeMethod = getFrom(enumReflected, "InvokeMethod");
    public static BindingFlags CreateInstance = getFrom(enumReflected, "CreateInstance");
    public static BindingFlags GetField = getFrom(enumReflected, "GetField");
    public static BindingFlags SetField = getFrom(enumReflected, "SetField");
    public static BindingFlags GetProperty = getFrom(enumReflected, "GetProperty");
    public static BindingFlags SetProperty = getFrom(enumReflected, "SetProperty");
    public static BindingFlags PutDispProperty = getFrom(enumReflected, "PutDispProperty");
    public static BindingFlags PutRefDispProperty = getFrom(enumReflected, "PutRefDispProperty");
    public static BindingFlags ExactBinding = getFrom(enumReflected, "ExactBinding");
    public static BindingFlags SuppressChangeType = getFrom(enumReflected, "SuppressChangeType");
    public static BindingFlags OptionalParamBinding = getFrom(enumReflected, "OptionalParamBinding");
    public static BindingFlags IgnoreReturn = getFrom(enumReflected, "IgnoreReturn");


    // Flags management section

    public final BindingFlags add(BindingFlags val) throws Throwable {
        return new BindingFlags(NetEnum.add(classInstance, val.classInstance));
    }

    public final BindingFlags remove(BindingFlags val) throws Throwable {
        return new BindingFlags(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(BindingFlags val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(BindingFlags val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}