/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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
 * The base .NET class managing System.Runtime.InteropServices.TypeLibTypeFlags, System.Runtime.InteropServices, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.TypeLibTypeFlags" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.TypeLibTypeFlags</a>
 */
public class TypeLibTypeFlags extends NetObject  {
    /**
     * Fully assembly qualified name: System.Runtime.InteropServices, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Runtime.InteropServices, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Runtime.InteropServices
     */
    public static final String assemblyShortName = "System.Runtime.InteropServices";
    /**
     * Qualified class name: System.Runtime.InteropServices.TypeLibTypeFlags
     */
    public static final String className = "System.Runtime.InteropServices.TypeLibTypeFlags";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
            return null;
        }
    }

    static JCEnum createEnum() {
        try {
            return bridge.GetEnum(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
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

    public TypeLibTypeFlags(Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            try {
                String enumName = NetEnum.GetName(classType, (JCObject)instance);
                classInstance = enumReflected.fromValue(enumName);
            } catch (Throwable t) {
                if (JCOBridgeInstance.getDebug())
                    t.printStackTrace();
                classInstance = enumReflected;
            }
        } else if (instance instanceof JCEnum) {
            classInstance = (JCEnum)instance;
        }
    }

    public TypeLibTypeFlags() {
        super();
        // add reference to assemblyName.dll file
        try {
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
        } catch (Throwable jcne) {
            if (JCOBridgeInstance.getDebug())
                jcne.printStackTrace();
        }
    }

    public String getJCOAssemblyName() {
        return assemblyFullName;
    }

    public String getJCOClassName() {
        return className;
    }

    public String getJCOObjectName() {
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    public Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    final static TypeLibTypeFlags getFrom(JCEnum object, String value) {
        try {
            return new TypeLibTypeFlags(object.fromValue(value));
        } catch (JCException e) {
            return new TypeLibTypeFlags(object);
        }
    }

    // Enum fields section
    
    public static TypeLibTypeFlags FAppObject = getFrom(enumReflected, "FAppObject");
    public static TypeLibTypeFlags FCanCreate = getFrom(enumReflected, "FCanCreate");
    public static TypeLibTypeFlags FLicensed = getFrom(enumReflected, "FLicensed");
    public static TypeLibTypeFlags FPreDeclId = getFrom(enumReflected, "FPreDeclId");
    public static TypeLibTypeFlags FHidden = getFrom(enumReflected, "FHidden");
    public static TypeLibTypeFlags FControl = getFrom(enumReflected, "FControl");
    public static TypeLibTypeFlags FDual = getFrom(enumReflected, "FDual");
    public static TypeLibTypeFlags FNonExtensible = getFrom(enumReflected, "FNonExtensible");
    public static TypeLibTypeFlags FOleAutomation = getFrom(enumReflected, "FOleAutomation");
    public static TypeLibTypeFlags FRestricted = getFrom(enumReflected, "FRestricted");
    public static TypeLibTypeFlags FAggregatable = getFrom(enumReflected, "FAggregatable");
    public static TypeLibTypeFlags FReplaceable = getFrom(enumReflected, "FReplaceable");
    public static TypeLibTypeFlags FDispatchable = getFrom(enumReflected, "FDispatchable");
    public static TypeLibTypeFlags FReverseBind = getFrom(enumReflected, "FReverseBind");


    // Flags management section

    public final TypeLibTypeFlags add(TypeLibTypeFlags val) throws Throwable {
        return new TypeLibTypeFlags(NetEnum.add(classInstance, val.classInstance));
    }

    public final TypeLibTypeFlags remove(TypeLibTypeFlags val) throws Throwable {
        return new TypeLibTypeFlags(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(TypeLibTypeFlags val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(TypeLibTypeFlags val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}