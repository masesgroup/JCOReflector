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

package system.security.permissions;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Security.Permissions.ReflectionPermissionFlag, System.Security.Permissions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Permissions.ReflectionPermissionFlag" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Permissions.ReflectionPermissionFlag</a>
 */
public class ReflectionPermissionFlag extends NetObject  {
    /**
     * Fully assembly qualified name: System.Security.Permissions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Security.Permissions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Security.Permissions
     */
    public static final String assemblyShortName = "System.Security.Permissions";
    /**
     * Qualified class name: System.Security.Permissions.ReflectionPermissionFlag
     */
    public static final String className = "System.Security.Permissions.ReflectionPermissionFlag";
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

    public ReflectionPermissionFlag(Object instance) {
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

    public ReflectionPermissionFlag() {
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

    final static ReflectionPermissionFlag getFrom(JCEnum object, String value) {
        try {
            return new ReflectionPermissionFlag(object.fromValue(value));
        } catch (JCException e) {
            return new ReflectionPermissionFlag(object);
        }
    }

    // Enum fields section
    
    public static ReflectionPermissionFlag NoFlags = getFrom(enumReflected, "NoFlags");
    public static ReflectionPermissionFlag TypeInformation = getFrom(enumReflected, "TypeInformation");
    public static ReflectionPermissionFlag MemberAccess = getFrom(enumReflected, "MemberAccess");
    public static ReflectionPermissionFlag ReflectionEmit = getFrom(enumReflected, "ReflectionEmit");
    public static ReflectionPermissionFlag AllFlags = getFrom(enumReflected, "AllFlags");
    public static ReflectionPermissionFlag RestrictedMemberAccess = getFrom(enumReflected, "RestrictedMemberAccess");


    // Flags management section

    public final ReflectionPermissionFlag add(ReflectionPermissionFlag val) throws Throwable {
        return new ReflectionPermissionFlag(NetEnum.add(classInstance, val.classInstance));
    }

    public final ReflectionPermissionFlag remove(ReflectionPermissionFlag val) throws Throwable {
        return new ReflectionPermissionFlag(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(ReflectionPermissionFlag val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(ReflectionPermissionFlag val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}