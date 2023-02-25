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

package microsoft.jscript;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import microsoft.jscript.AST;
import system.Single;
import system.TypeCode;
import microsoft.jscript.vsa.VsaEngine;
import system.RuntimeTypeHandle;


/**
 * The base .NET class managing Microsoft.JScript.Convert, Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.Convert" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.Convert</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class Convert extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.JScript
     */
    public static final String assemblyShortName = "Microsoft.JScript";
    /**
     * Qualified class name: Microsoft.JScript.Convert
     */
    public static final String className = "Microsoft.JScript.Convert";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

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
    public Convert(java.lang.Object instance) throws Throwable {
        super(instance);
        if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new Exception("Cannot manage object, it is not a JCObject");
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

    public void setJCOInstance(JCObject instance) {
        classInstance = instance;
        super.setJCOInstance(classInstance);
    }

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Convert}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Convert} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Convert cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Convert(from.getJCOInstance());
    }

    // Constructors section
    
    public Convert() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public static boolean IsBadIndex(AST ast) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidCastException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.NullReferenceException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.FormatException, system.OverflowException, system.IndexOutOfRangeException, system.security.SecurityException, system.reflection.TargetInvocationException, microsoft.jscript.vsa.JSVsaException, microsoft.jscript.EndOfFile {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsBadIndex", ast == null ? null : ast.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean ToBoolean(double d) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("ToBoolean", d);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean ToBoolean(NetObject value) throws Throwable, system.ArgumentNullException, system.NotImplementedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("ToBoolean", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean ToBoolean(NetObject value, boolean explicitConversion) throws Throwable, system.ArgumentNullException, system.NotImplementedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("ToBoolean", value == null ? null : value.getJCOInstance(), explicitConversion);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double CheckIfDoubleIsInteger(double d) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("CheckIfDoubleIsInteger", d);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double ToNumber(NetObject value) throws Throwable, system.NotImplementedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentException, microsoft.jscript.JScriptException, microsoft.jscript.EndOfFile, system.ArgumentNullException, system.MissingMethodException, system.OverflowException, system.FormatException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("ToNumber", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double ToNumber(java.lang.String str) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException, microsoft.jscript.JScriptException, system.IndexOutOfRangeException, system.NotImplementedException, system.MissingMethodException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("ToNumber", str);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int ToInt32(NetObject value) throws Throwable, system.ArithmeticException, system.ArgumentOutOfRangeException, system.ArgumentException, system.OverflowException, system.NotImplementedException, system.NotSupportedException, system.InvalidOperationException, microsoft.jscript.JScriptException, microsoft.jscript.EndOfFile, system.ArgumentNullException, system.MissingMethodException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("ToInt32", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Single CheckIfSingleIsInteger(Single s) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCheckIfSingleIsInteger = (JCObject)classType.Invoke("CheckIfSingleIsInteger", s == null ? null : s.getJCOInstance());
            return new Single(objCheckIfSingleIsInteger);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject Coerce(NetObject value, NetObject type) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.IndexOutOfRangeException, system.NotImplementedException, system.NullReferenceException, system.InvalidOperationException, microsoft.jscript.vsa.JSVsaException, microsoft.jscript.EndOfFile, system.ArgumentOutOfRangeException, microsoft.jscript.JScriptException, system.NotSupportedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCoerce = (JCObject)classType.Invoke("Coerce", value == null ? null : value.getJCOInstance(), type == null ? null : type.getJCOInstance());
            return new NetObject(objCoerce);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject Coerce2(NetObject value, TypeCode target, boolean truncationPermitted) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.NotSupportedException, system.InvalidOperationException, microsoft.jscript.JScriptException, system.IndexOutOfRangeException, system.MissingMethodException, system.ArgumentException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException, system.globalization.CultureNotFoundException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCoerce2 = (JCObject)classType.Invoke("Coerce2", value == null ? null : value.getJCOInstance(), target == null ? null : target.getJCOInstance(), truncationPermitted);
            return new NetObject(objCoerce2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject CoerceT(NetObject value, NetType t, boolean explicitOK) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.InvalidCastException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.NullReferenceException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.ArithmeticException, system.OverflowException, system.OutOfMemoryException, system.TypeInitializationException, system.security.SecurityException, system.reflection.TargetInvocationException, microsoft.jscript.vsa.JSVsaException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCoerceT = (JCObject)classType.Invoke("CoerceT", value == null ? null : value.getJCOInstance(), t == null ? null : t.getJCOInstance(), explicitOK);
            return new NetObject(objCoerceT);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject ToForInObject(NetObject value, VsaEngine engine) throws Throwable, system.ArgumentNullException, system.NotImplementedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objToForInObject = (JCObject)classType.Invoke("ToForInObject", value == null ? null : value.getJCOInstance(), engine == null ? null : engine.getJCOInstance());
            return new NetObject(objToForInObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject ToNativeArray(NetObject value, RuntimeTypeHandle handle) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException, system.InvalidCastException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.NotImplementedException, system.MissingMethodException, system.FormatException, system.OverflowException, system.reflection.TargetInvocationException, microsoft.jscript.vsa.JSVsaException, microsoft.jscript.EndOfFile {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objToNativeArray = (JCObject)classType.Invoke("ToNativeArray", value == null ? null : value.getJCOInstance(), handle == null ? null : handle.getJCOInstance());
            return new NetObject(objToNativeArray);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject ToObject(NetObject value, VsaEngine engine) throws Throwable, system.ArgumentNullException, system.NotImplementedException, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objToObject = (JCObject)classType.Invoke("ToObject", value == null ? null : value.getJCOInstance(), engine == null ? null : engine.getJCOInstance());
            return new NetObject(objToObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject ToObject2(NetObject value, VsaEngine engine) throws Throwable, system.ArgumentNullException, system.NotImplementedException, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objToObject2 = (JCObject)classType.Invoke("ToObject2", value == null ? null : value.getJCOInstance(), engine == null ? null : engine.getJCOInstance());
            return new NetObject(objToObject2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String ToString(boolean b) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("ToString", b);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String ToString(double d) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("ToString", d);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String ToString(NetObject value, boolean explicitOK) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.NotSupportedException, system.FormatException, system.NotImplementedException, microsoft.jscript.JScriptException, system.MissingMethodException, system.NullReferenceException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("ToString", value == null ? null : value.getJCOInstance(), explicitOK);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ThrowTypeMismatch(NetObject val) throws Throwable, microsoft.jscript.vsa.JSVsaException, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ThrowTypeMismatch", val == null ? null : val.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}