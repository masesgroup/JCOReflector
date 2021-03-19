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

package system.linq.expressions;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Linq.Expressions.ExpressionType, System.Linq.Expressions, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Linq.Expressions.ExpressionType" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Linq.Expressions.ExpressionType</a>
 */
public class ExpressionType extends NetObject  {
    /**
     * Fully assembly qualified name: System.Linq.Expressions, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Linq.Expressions, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Linq.Expressions
     */
    public static final String assemblyShortName = "System.Linq.Expressions";
    /**
     * Qualified class name: System.Linq.Expressions.ExpressionType
     */
    public static final String className = "System.Linq.Expressions.ExpressionType";
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

    public ExpressionType(Object instance) {
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

    public ExpressionType() {
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

    final static ExpressionType getFrom(JCEnum object, String value) {
        try {
            return new ExpressionType(object.fromValue(value));
        } catch (JCException e) {
            return new ExpressionType(object);
        }
    }

    // Enum fields section
    
    public static ExpressionType Add = getFrom(enumReflected, "Add");
    public static ExpressionType AddChecked = getFrom(enumReflected, "AddChecked");
    public static ExpressionType And = getFrom(enumReflected, "And");
    public static ExpressionType AndAlso = getFrom(enumReflected, "AndAlso");
    public static ExpressionType ArrayLength = getFrom(enumReflected, "ArrayLength");
    public static ExpressionType ArrayIndex = getFrom(enumReflected, "ArrayIndex");
    public static ExpressionType Call = getFrom(enumReflected, "Call");
    public static ExpressionType Coalesce = getFrom(enumReflected, "Coalesce");
    public static ExpressionType Conditional = getFrom(enumReflected, "Conditional");
    public static ExpressionType Constant = getFrom(enumReflected, "Constant");
    public static ExpressionType Convert = getFrom(enumReflected, "Convert");
    public static ExpressionType ConvertChecked = getFrom(enumReflected, "ConvertChecked");
    public static ExpressionType Divide = getFrom(enumReflected, "Divide");
    public static ExpressionType Equal = getFrom(enumReflected, "Equal");
    public static ExpressionType ExclusiveOr = getFrom(enumReflected, "ExclusiveOr");
    public static ExpressionType GreaterThan = getFrom(enumReflected, "GreaterThan");
    public static ExpressionType GreaterThanOrEqual = getFrom(enumReflected, "GreaterThanOrEqual");
    public static ExpressionType Invoke = getFrom(enumReflected, "Invoke");
    public static ExpressionType Lambda = getFrom(enumReflected, "Lambda");
    public static ExpressionType LeftShift = getFrom(enumReflected, "LeftShift");
    public static ExpressionType LessThan = getFrom(enumReflected, "LessThan");
    public static ExpressionType LessThanOrEqual = getFrom(enumReflected, "LessThanOrEqual");
    public static ExpressionType ListInit = getFrom(enumReflected, "ListInit");
    public static ExpressionType MemberAccess = getFrom(enumReflected, "MemberAccess");
    public static ExpressionType MemberInit = getFrom(enumReflected, "MemberInit");
    public static ExpressionType Modulo = getFrom(enumReflected, "Modulo");
    public static ExpressionType Multiply = getFrom(enumReflected, "Multiply");
    public static ExpressionType MultiplyChecked = getFrom(enumReflected, "MultiplyChecked");
    public static ExpressionType Negate = getFrom(enumReflected, "Negate");
    public static ExpressionType UnaryPlus = getFrom(enumReflected, "UnaryPlus");
    public static ExpressionType NegateChecked = getFrom(enumReflected, "NegateChecked");
    public static ExpressionType New = getFrom(enumReflected, "New");
    public static ExpressionType NewArrayInit = getFrom(enumReflected, "NewArrayInit");
    public static ExpressionType NewArrayBounds = getFrom(enumReflected, "NewArrayBounds");
    public static ExpressionType Not = getFrom(enumReflected, "Not");
    public static ExpressionType NotEqual = getFrom(enumReflected, "NotEqual");
    public static ExpressionType Or = getFrom(enumReflected, "Or");
    public static ExpressionType OrElse = getFrom(enumReflected, "OrElse");
    public static ExpressionType Parameter = getFrom(enumReflected, "Parameter");
    public static ExpressionType Power = getFrom(enumReflected, "Power");
    public static ExpressionType Quote = getFrom(enumReflected, "Quote");
    public static ExpressionType RightShift = getFrom(enumReflected, "RightShift");
    public static ExpressionType Subtract = getFrom(enumReflected, "Subtract");
    public static ExpressionType SubtractChecked = getFrom(enumReflected, "SubtractChecked");
    public static ExpressionType TypeAs = getFrom(enumReflected, "TypeAs");
    public static ExpressionType TypeIs = getFrom(enumReflected, "TypeIs");
    public static ExpressionType Assign = getFrom(enumReflected, "Assign");
    public static ExpressionType Block = getFrom(enumReflected, "Block");
    public static ExpressionType DebugInfo = getFrom(enumReflected, "DebugInfo");
    public static ExpressionType Decrement = getFrom(enumReflected, "Decrement");
    public static ExpressionType Dynamic = getFrom(enumReflected, "Dynamic");
    public static ExpressionType Default = getFrom(enumReflected, "Default");
    public static ExpressionType Extension = getFrom(enumReflected, "Extension");
    public static ExpressionType Goto = getFrom(enumReflected, "Goto");
    public static ExpressionType Increment = getFrom(enumReflected, "Increment");
    public static ExpressionType Index = getFrom(enumReflected, "Index");
    public static ExpressionType Label = getFrom(enumReflected, "Label");
    public static ExpressionType RuntimeVariables = getFrom(enumReflected, "RuntimeVariables");
    public static ExpressionType Loop = getFrom(enumReflected, "Loop");
    public static ExpressionType Switch = getFrom(enumReflected, "Switch");
    public static ExpressionType Throw = getFrom(enumReflected, "Throw");
    public static ExpressionType Try = getFrom(enumReflected, "Try");
    public static ExpressionType Unbox = getFrom(enumReflected, "Unbox");
    public static ExpressionType AddAssign = getFrom(enumReflected, "AddAssign");
    public static ExpressionType AndAssign = getFrom(enumReflected, "AndAssign");
    public static ExpressionType DivideAssign = getFrom(enumReflected, "DivideAssign");
    public static ExpressionType ExclusiveOrAssign = getFrom(enumReflected, "ExclusiveOrAssign");
    public static ExpressionType LeftShiftAssign = getFrom(enumReflected, "LeftShiftAssign");
    public static ExpressionType ModuloAssign = getFrom(enumReflected, "ModuloAssign");
    public static ExpressionType MultiplyAssign = getFrom(enumReflected, "MultiplyAssign");
    public static ExpressionType OrAssign = getFrom(enumReflected, "OrAssign");
    public static ExpressionType PowerAssign = getFrom(enumReflected, "PowerAssign");
    public static ExpressionType RightShiftAssign = getFrom(enumReflected, "RightShiftAssign");
    public static ExpressionType SubtractAssign = getFrom(enumReflected, "SubtractAssign");
    public static ExpressionType AddAssignChecked = getFrom(enumReflected, "AddAssignChecked");
    public static ExpressionType MultiplyAssignChecked = getFrom(enumReflected, "MultiplyAssignChecked");
    public static ExpressionType SubtractAssignChecked = getFrom(enumReflected, "SubtractAssignChecked");
    public static ExpressionType PreIncrementAssign = getFrom(enumReflected, "PreIncrementAssign");
    public static ExpressionType PreDecrementAssign = getFrom(enumReflected, "PreDecrementAssign");
    public static ExpressionType PostIncrementAssign = getFrom(enumReflected, "PostIncrementAssign");
    public static ExpressionType PostDecrementAssign = getFrom(enumReflected, "PostDecrementAssign");
    public static ExpressionType TypeEqual = getFrom(enumReflected, "TypeEqual");
    public static ExpressionType OnesComplement = getFrom(enumReflected, "OnesComplement");
    public static ExpressionType IsTrue = getFrom(enumReflected, "IsTrue");
    public static ExpressionType IsFalse = getFrom(enumReflected, "IsFalse");


    // Flags management section


}