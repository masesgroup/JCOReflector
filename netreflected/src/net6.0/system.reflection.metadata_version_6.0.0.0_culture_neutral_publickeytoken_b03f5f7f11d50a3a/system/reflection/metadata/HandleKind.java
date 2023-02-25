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

package system.reflection.metadata;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Reflection.Metadata.HandleKind, System.Reflection.Metadata, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.Metadata.HandleKind" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.Metadata.HandleKind</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class HandleKind extends NetObject  {
    /**
     * Fully assembly qualified name: System.Reflection.Metadata, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Reflection.Metadata, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Reflection.Metadata
     */
    public static final String assemblyShortName = "System.Reflection.Metadata";
    /**
     * Qualified class name: System.Reflection.Metadata.HandleKind
     */
    public static final String className = "System.Reflection.Metadata.HandleKind";
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
    public HandleKind(java.lang.Object instance) {
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

    public HandleKind() {
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

    final static HandleKind getFrom(JCEnum object, String value) {
        try {
            return new HandleKind(object.fromValue(value));
        } catch (JCException e) {
            return new HandleKind(object);
        }
    }

    // Enum fields section
    
    public static HandleKind ModuleDefinition = getFrom(enumReflected, "ModuleDefinition");
    public static HandleKind TypeReference = getFrom(enumReflected, "TypeReference");
    public static HandleKind TypeDefinition = getFrom(enumReflected, "TypeDefinition");
    public static HandleKind FieldDefinition = getFrom(enumReflected, "FieldDefinition");
    public static HandleKind MethodDefinition = getFrom(enumReflected, "MethodDefinition");
    public static HandleKind Parameter = getFrom(enumReflected, "Parameter");
    public static HandleKind InterfaceImplementation = getFrom(enumReflected, "InterfaceImplementation");
    public static HandleKind MemberReference = getFrom(enumReflected, "MemberReference");
    public static HandleKind Constant = getFrom(enumReflected, "Constant");
    public static HandleKind CustomAttribute = getFrom(enumReflected, "CustomAttribute");
    public static HandleKind DeclarativeSecurityAttribute = getFrom(enumReflected, "DeclarativeSecurityAttribute");
    public static HandleKind StandaloneSignature = getFrom(enumReflected, "StandaloneSignature");
    public static HandleKind EventDefinition = getFrom(enumReflected, "EventDefinition");
    public static HandleKind PropertyDefinition = getFrom(enumReflected, "PropertyDefinition");
    public static HandleKind MethodImplementation = getFrom(enumReflected, "MethodImplementation");
    public static HandleKind ModuleReference = getFrom(enumReflected, "ModuleReference");
    public static HandleKind TypeSpecification = getFrom(enumReflected, "TypeSpecification");
    public static HandleKind AssemblyDefinition = getFrom(enumReflected, "AssemblyDefinition");
    public static HandleKind AssemblyReference = getFrom(enumReflected, "AssemblyReference");
    public static HandleKind AssemblyFile = getFrom(enumReflected, "AssemblyFile");
    public static HandleKind ExportedType = getFrom(enumReflected, "ExportedType");
    public static HandleKind ManifestResource = getFrom(enumReflected, "ManifestResource");
    public static HandleKind GenericParameter = getFrom(enumReflected, "GenericParameter");
    public static HandleKind MethodSpecification = getFrom(enumReflected, "MethodSpecification");
    public static HandleKind GenericParameterConstraint = getFrom(enumReflected, "GenericParameterConstraint");
    public static HandleKind Document = getFrom(enumReflected, "Document");
    public static HandleKind MethodDebugInformation = getFrom(enumReflected, "MethodDebugInformation");
    public static HandleKind LocalScope = getFrom(enumReflected, "LocalScope");
    public static HandleKind LocalVariable = getFrom(enumReflected, "LocalVariable");
    public static HandleKind LocalConstant = getFrom(enumReflected, "LocalConstant");
    public static HandleKind ImportScope = getFrom(enumReflected, "ImportScope");
    public static HandleKind CustomDebugInformation = getFrom(enumReflected, "CustomDebugInformation");
    public static HandleKind UserString = getFrom(enumReflected, "UserString");
    public static HandleKind Blob = getFrom(enumReflected, "Blob");
    public static HandleKind Guid = getFrom(enumReflected, "Guid");
    public static HandleKind String = getFrom(enumReflected, "String");
    public static HandleKind NamespaceDefinition = getFrom(enumReflected, "NamespaceDefinition");


    // Flags management section


}