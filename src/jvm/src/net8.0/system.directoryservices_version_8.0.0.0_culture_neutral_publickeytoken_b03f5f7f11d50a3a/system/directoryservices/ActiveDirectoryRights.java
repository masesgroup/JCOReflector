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

package system.directoryservices;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.DirectoryServices.ActiveDirectoryRights, System.DirectoryServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.ActiveDirectoryRights" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.ActiveDirectoryRights</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ActiveDirectoryRights extends NetObject  {
    /**
     * Fully assembly qualified name: System.DirectoryServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.DirectoryServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.DirectoryServices
     */
    public static final String assemblyShortName = "System.DirectoryServices";
    /**
     * Qualified class name: System.DirectoryServices.ActiveDirectoryRights
     */
    public static final String className = "System.DirectoryServices.ActiveDirectoryRights";
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
    public ActiveDirectoryRights(java.lang.Object instance) {
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

    public ActiveDirectoryRights() {
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

    final static ActiveDirectoryRights getFrom(JCEnum object, String value) {
        try {
            return new ActiveDirectoryRights(object.fromValue(value));
        } catch (JCException e) {
            return new ActiveDirectoryRights(object);
        }
    }

    // Enum fields section
    
    public static ActiveDirectoryRights CreateChild = getFrom(enumReflected, "CreateChild");
    public static ActiveDirectoryRights DeleteChild = getFrom(enumReflected, "DeleteChild");
    public static ActiveDirectoryRights ListChildren = getFrom(enumReflected, "ListChildren");
    public static ActiveDirectoryRights Self = getFrom(enumReflected, "Self");
    public static ActiveDirectoryRights ReadProperty = getFrom(enumReflected, "ReadProperty");
    public static ActiveDirectoryRights WriteProperty = getFrom(enumReflected, "WriteProperty");
    public static ActiveDirectoryRights DeleteTree = getFrom(enumReflected, "DeleteTree");
    public static ActiveDirectoryRights ListObject = getFrom(enumReflected, "ListObject");
    public static ActiveDirectoryRights ExtendedRight = getFrom(enumReflected, "ExtendedRight");
    public static ActiveDirectoryRights Delete = getFrom(enumReflected, "Delete");
    public static ActiveDirectoryRights ReadControl = getFrom(enumReflected, "ReadControl");
    public static ActiveDirectoryRights GenericExecute = getFrom(enumReflected, "GenericExecute");
    public static ActiveDirectoryRights GenericWrite = getFrom(enumReflected, "GenericWrite");
    public static ActiveDirectoryRights GenericRead = getFrom(enumReflected, "GenericRead");
    public static ActiveDirectoryRights WriteDacl = getFrom(enumReflected, "WriteDacl");
    public static ActiveDirectoryRights WriteOwner = getFrom(enumReflected, "WriteOwner");
    public static ActiveDirectoryRights GenericAll = getFrom(enumReflected, "GenericAll");
    public static ActiveDirectoryRights Synchronize = getFrom(enumReflected, "Synchronize");
    public static ActiveDirectoryRights AccessSystemSecurity = getFrom(enumReflected, "AccessSystemSecurity");


    // Flags management section

    public final ActiveDirectoryRights add(ActiveDirectoryRights val) throws Throwable {
        return new ActiveDirectoryRights(NetEnum.add(classInstance, val.classInstance));
    }

    public final ActiveDirectoryRights remove(ActiveDirectoryRights val) throws Throwable {
        return new ActiveDirectoryRights(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(ActiveDirectoryRights val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(ActiveDirectoryRights val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}