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

package microsoft.csharp.runtimebinder;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing Microsoft.CSharp.RuntimeBinder.CSharpBinderFlags, Microsoft.CSharp, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.CSharp.RuntimeBinder.CSharpBinderFlags" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.CSharp.RuntimeBinder.CSharpBinderFlags</a>
 */
public class CSharpBinderFlags extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.CSharp, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.CSharp, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.CSharp
     */
    public static final String assemblyShortName = "Microsoft.CSharp";
    /**
     * Qualified class name: Microsoft.CSharp.RuntimeBinder.CSharpBinderFlags
     */
    public static final String className = "Microsoft.CSharp.RuntimeBinder.CSharpBinderFlags";
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

    public CSharpBinderFlags(Object instance) {
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

    public CSharpBinderFlags() {
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

    final static CSharpBinderFlags getFrom(JCEnum object, String value) {
        try {
            return new CSharpBinderFlags(object.fromValue(value));
        } catch (JCException e) {
            return new CSharpBinderFlags(object);
        }
    }

    // Enum fields section
    
    public static CSharpBinderFlags None = getFrom(enumReflected, "None");
    public static CSharpBinderFlags CheckedContext = getFrom(enumReflected, "CheckedContext");
    public static CSharpBinderFlags InvokeSimpleName = getFrom(enumReflected, "InvokeSimpleName");
    public static CSharpBinderFlags InvokeSpecialName = getFrom(enumReflected, "InvokeSpecialName");
    public static CSharpBinderFlags BinaryOperationLogical = getFrom(enumReflected, "BinaryOperationLogical");
    public static CSharpBinderFlags ConvertExplicit = getFrom(enumReflected, "ConvertExplicit");
    public static CSharpBinderFlags ConvertArrayIndex = getFrom(enumReflected, "ConvertArrayIndex");
    public static CSharpBinderFlags ResultIndexed = getFrom(enumReflected, "ResultIndexed");
    public static CSharpBinderFlags ValueFromCompoundAssignment = getFrom(enumReflected, "ValueFromCompoundAssignment");
    public static CSharpBinderFlags ResultDiscarded = getFrom(enumReflected, "ResultDiscarded");


    // Flags management section

    public final CSharpBinderFlags add(CSharpBinderFlags val) throws Throwable {
        return new CSharpBinderFlags(NetEnum.add(classInstance, val.classInstance));
    }

    public final CSharpBinderFlags remove(CSharpBinderFlags val) throws Throwable {
        return new CSharpBinderFlags(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(CSharpBinderFlags val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(CSharpBinderFlags val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}