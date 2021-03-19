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

package system.runtime.intrinsics.x86;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Runtime.Intrinsics.X86.FloatComparisonMode, System.Private.CoreLib, Version=5.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Intrinsics.X86.FloatComparisonMode" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Intrinsics.X86.FloatComparisonMode</a>
 */
public class FloatComparisonMode extends NetObject  {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=5.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=5.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.Runtime.Intrinsics.X86.FloatComparisonMode
     */
    public static final String className = "System.Runtime.Intrinsics.X86.FloatComparisonMode";
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

    public FloatComparisonMode(Object instance) {
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

    public FloatComparisonMode() {
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

    final static FloatComparisonMode getFrom(JCEnum object, String value) {
        try {
            return new FloatComparisonMode(object.fromValue(value));
        } catch (JCException e) {
            return new FloatComparisonMode(object);
        }
    }

    // Enum fields section
    
    public static FloatComparisonMode OrderedEqualNonSignaling = getFrom(enumReflected, "OrderedEqualNonSignaling");
    public static FloatComparisonMode OrderedLessThanSignaling = getFrom(enumReflected, "OrderedLessThanSignaling");
    public static FloatComparisonMode OrderedLessThanOrEqualSignaling = getFrom(enumReflected, "OrderedLessThanOrEqualSignaling");
    public static FloatComparisonMode UnorderedNonSignaling = getFrom(enumReflected, "UnorderedNonSignaling");
    public static FloatComparisonMode UnorderedNotEqualNonSignaling = getFrom(enumReflected, "UnorderedNotEqualNonSignaling");
    public static FloatComparisonMode UnorderedNotLessThanSignaling = getFrom(enumReflected, "UnorderedNotLessThanSignaling");
    public static FloatComparisonMode UnorderedNotLessThanOrEqualSignaling = getFrom(enumReflected, "UnorderedNotLessThanOrEqualSignaling");
    public static FloatComparisonMode OrderedNonSignaling = getFrom(enumReflected, "OrderedNonSignaling");
    public static FloatComparisonMode UnorderedEqualNonSignaling = getFrom(enumReflected, "UnorderedEqualNonSignaling");
    public static FloatComparisonMode UnorderedNotGreaterThanOrEqualSignaling = getFrom(enumReflected, "UnorderedNotGreaterThanOrEqualSignaling");
    public static FloatComparisonMode UnorderedNotGreaterThanSignaling = getFrom(enumReflected, "UnorderedNotGreaterThanSignaling");
    public static FloatComparisonMode OrderedFalseNonSignaling = getFrom(enumReflected, "OrderedFalseNonSignaling");
    public static FloatComparisonMode OrderedNotEqualNonSignaling = getFrom(enumReflected, "OrderedNotEqualNonSignaling");
    public static FloatComparisonMode OrderedGreaterThanOrEqualSignaling = getFrom(enumReflected, "OrderedGreaterThanOrEqualSignaling");
    public static FloatComparisonMode OrderedGreaterThanSignaling = getFrom(enumReflected, "OrderedGreaterThanSignaling");
    public static FloatComparisonMode UnorderedTrueNonSignaling = getFrom(enumReflected, "UnorderedTrueNonSignaling");
    public static FloatComparisonMode OrderedEqualSignaling = getFrom(enumReflected, "OrderedEqualSignaling");
    public static FloatComparisonMode OrderedLessThanNonSignaling = getFrom(enumReflected, "OrderedLessThanNonSignaling");
    public static FloatComparisonMode OrderedLessThanOrEqualNonSignaling = getFrom(enumReflected, "OrderedLessThanOrEqualNonSignaling");
    public static FloatComparisonMode UnorderedSignaling = getFrom(enumReflected, "UnorderedSignaling");
    public static FloatComparisonMode UnorderedNotEqualSignaling = getFrom(enumReflected, "UnorderedNotEqualSignaling");
    public static FloatComparisonMode UnorderedNotLessThanNonSignaling = getFrom(enumReflected, "UnorderedNotLessThanNonSignaling");
    public static FloatComparisonMode UnorderedNotLessThanOrEqualNonSignaling = getFrom(enumReflected, "UnorderedNotLessThanOrEqualNonSignaling");
    public static FloatComparisonMode OrderedSignaling = getFrom(enumReflected, "OrderedSignaling");
    public static FloatComparisonMode UnorderedEqualSignaling = getFrom(enumReflected, "UnorderedEqualSignaling");
    public static FloatComparisonMode UnorderedNotGreaterThanOrEqualNonSignaling = getFrom(enumReflected, "UnorderedNotGreaterThanOrEqualNonSignaling");
    public static FloatComparisonMode UnorderedNotGreaterThanNonSignaling = getFrom(enumReflected, "UnorderedNotGreaterThanNonSignaling");
    public static FloatComparisonMode OrderedFalseSignaling = getFrom(enumReflected, "OrderedFalseSignaling");
    public static FloatComparisonMode OrderedNotEqualSignaling = getFrom(enumReflected, "OrderedNotEqualSignaling");
    public static FloatComparisonMode OrderedGreaterThanOrEqualNonSignaling = getFrom(enumReflected, "OrderedGreaterThanOrEqualNonSignaling");
    public static FloatComparisonMode OrderedGreaterThanNonSignaling = getFrom(enumReflected, "OrderedGreaterThanNonSignaling");
    public static FloatComparisonMode UnorderedTrueSignaling = getFrom(enumReflected, "UnorderedTrueSignaling");


    // Flags management section


}