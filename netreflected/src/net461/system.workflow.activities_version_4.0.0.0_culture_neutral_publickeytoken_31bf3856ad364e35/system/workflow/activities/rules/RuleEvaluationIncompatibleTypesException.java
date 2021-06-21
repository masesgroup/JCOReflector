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

package system.workflow.activities.rules;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.workflow.activities.rules.RuleException;
import system.codedom.CodeBinaryOperatorType;
import system.runtime.serialization.SerializationInfo;
import system.runtime.serialization.StreamingContext;

/**
 * The base .NET class managing System.Workflow.Activities.Rules.RuleEvaluationIncompatibleTypesException, System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link RuleException}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.Activities.Rules.RuleEvaluationIncompatibleTypesException" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.Activities.Rules.RuleEvaluationIncompatibleTypesException</a>
 */
public class RuleEvaluationIncompatibleTypesException extends RuleException {
    /**
     * Fully assembly qualified name: System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Workflow.Activities
     */
    public static final String assemblyShortName = "System.Workflow.Activities";
    /**
     * Qualified class name: System.Workflow.Activities.Rules.RuleEvaluationIncompatibleTypesException
     */
    public static final String className = "System.Workflow.Activities.Rules.RuleEvaluationIncompatibleTypesException";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;
    JCNativeException jcNativeException = null;

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
        } catch (JCException jce) {
            JCOReflector.writeLog(jce);
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

    public RuleEvaluationIncompatibleTypesException() {
        super();
    }

    public RuleEvaluationIncompatibleTypesException(Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else if (instance instanceof JCNativeException) {
            jcNativeException = (JCNativeException) instance;
            classInstance = jcNativeException.getCLRException();
        }
    }

    public RuleEvaluationIncompatibleTypesException(String message) {
        super(message);
    }

    public RuleEvaluationIncompatibleTypesException(NetException cause) {
        super(cause);
    }

    public RuleEvaluationIncompatibleTypesException(String message, NetException cause) {
        super(message, cause);
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

    public void setJCOInstance(JCObject instance) {
        classInstance = instance;
        super.setJCOInstance(classInstance);
    }

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link RuleEvaluationIncompatibleTypesException}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link RuleEvaluationIncompatibleTypesException} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static RuleEvaluationIncompatibleTypesException cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new RuleEvaluationIncompatibleTypesException(from.getJCOInstance());
    }

    // Constructors section
    
    public RuleEvaluationIncompatibleTypesException(java.lang.String message, NetType left, CodeBinaryOperatorType op, NetType right) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, left == null ? null : left.getJCOInstance(), op == null ? null : op.getJCOInstance(), right == null ? null : right.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RuleEvaluationIncompatibleTypesException(java.lang.String message, NetType left, CodeBinaryOperatorType op, NetType right, NetException ex) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(message, left == null ? null : left.getJCOInstance(), op == null ? null : op.getJCOInstance(), right == null ? null : right.getJCOInstance(), ex == null ? null : ex.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public void GetObjectData(SerializationInfo info, StreamingContext context) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.security.SecurityException, system.TypeLoadException, system.NotSupportedException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.NotImplementedException, system.runtime.serialization.SerializationException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetObjectData", info == null ? null : info.getJCOInstance(), context == null ? null : context.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public CodeBinaryOperatorType getOperator() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Operator");
            return new CodeBinaryOperatorType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOperator(CodeBinaryOperatorType Operator) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Operator", Operator == null ? null : Operator.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType getLeft() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Left");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLeft(NetType Left) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Left", Left == null ? null : Left.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType getRight() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Right");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRight(NetType Right) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Right", Right == null ? null : Right.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}