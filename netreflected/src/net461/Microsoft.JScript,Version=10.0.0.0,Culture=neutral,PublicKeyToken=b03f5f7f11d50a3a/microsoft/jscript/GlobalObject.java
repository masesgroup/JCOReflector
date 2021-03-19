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

package microsoft.jscript;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import microsoft.jscript.ActiveXObjectConstructor;
import microsoft.jscript.ArrayConstructor;
import microsoft.jscript.BooleanConstructor;
import microsoft.jscript.DateConstructor;
import microsoft.jscript.EnumeratorConstructor;
import microsoft.jscript.ErrorConstructor;
import microsoft.jscript.FunctionConstructor;
import microsoft.jscript.MathObject;
import microsoft.jscript.NumberConstructor;
import microsoft.jscript.ObjectConstructor;
import microsoft.jscript.RegExpConstructor;
import microsoft.jscript.StringConstructor;
import microsoft.jscript.VBArrayConstructor;


/**
 * The base .NET class managing Microsoft.JScript.GlobalObject, Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.GlobalObject" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.GlobalObject</a>
 */
public class GlobalObject extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.JScript
     */
    public static final String assemblyShortName = "Microsoft.JScript";
    /**
     * Qualified class name: Microsoft.JScript.GlobalObject
     */
    public static final String className = "Microsoft.JScript.GlobalObject";
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

    public GlobalObject(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link GlobalObject}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link GlobalObject} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static GlobalObject cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new GlobalObject(from.getJCOInstance());
    }

    // Constructors section
    
    public GlobalObject() throws Throwable {
    }



    
    // Methods section
    
    public static boolean isFinite(double number) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("isFinite", number);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean isNaN(NetObject num) throws Throwable, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, microsoft.jscript.JScriptException, system.IndexOutOfRangeException, system.ArgumentNullException, system.MissingMethodException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("isNaN", num == null ? null : num.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double parseFloat(NetObject string) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.NullReferenceException, system.OverflowException, system.OutOfMemoryException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("parseFloat", string == null ? null : string.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double parseInt(NetObject string, NetObject radix) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.NullReferenceException, system.OverflowException, system.OutOfMemoryException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("parseInt", string == null ? null : string.getJCOInstance(), radix == null ? null : radix.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int ScriptEngineBuildVersion() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("ScriptEngineBuildVersion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int ScriptEngineMajorVersion() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("ScriptEngineMajorVersion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int ScriptEngineMinorVersion() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("ScriptEngineMinorVersion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject eval(NetObject x) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objeval = (JCObject)classType.Invoke("eval", x == null ? null : x.getJCOInstance());
            return new NetObject(objeval);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetObject(NetObject moniker, NetObject progId) throws Throwable, system.NotImplementedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentException, microsoft.jscript.JScriptException, system.NullReferenceException, microsoft.jscript.EndOfFile, system.MissingMethodException, system.OverflowException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetObject = (JCObject)classType.Invoke("GetObject", moniker == null ? null : moniker.getJCOInstance(), progId == null ? null : progId.getJCOInstance());
            return new NetObject(objGetObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String decodeURI(NetObject encodedURI) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("decodeURI", encodedURI == null ? null : encodedURI.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String decodeURIComponent(NetObject encodedURI) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("decodeURIComponent", encodedURI == null ? null : encodedURI.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String encodeURI(NetObject uri) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("encodeURI", uri == null ? null : uri.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String encodeURIComponent(NetObject uriComponent) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("encodeURIComponent", uriComponent == null ? null : uriComponent.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String escape(NetObject string) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.NullReferenceException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("escape", string == null ? null : string.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String ScriptEngine() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("ScriptEngine");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String unescape(NetObject string) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException, system.FormatException, microsoft.jscript.JScriptException, system.NotImplementedException, system.MissingMethodException, system.NullReferenceException, system.OverflowException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("unescape", string == null ? null : string.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void CollectGarbage() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("CollectGarbage");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static ActiveXObjectConstructor getActiveXObject() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("ActiveXObject");
            return new ActiveXObjectConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ArrayConstructor getArray() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Array");
            return new ArrayConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static BooleanConstructor getBoolean() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Boolean");
            return new BooleanConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateConstructor getDate() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Date");
            return new DateConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static EnumeratorConstructor getEnumerator() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Enumerator");
            return new EnumeratorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Error");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getEvalError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("EvalError");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getRangeError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("RangeError");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getReferenceError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("ReferenceError");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getSyntaxError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("SyntaxError");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getTypeError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("TypeError");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ErrorConstructor getURIError() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("URIError");
            return new ErrorConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static FunctionConstructor getFunction() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Function");
            return new FunctionConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static MathObject getMath() throws Throwable, system.NotImplementedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Math");
            return new MathObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NumberConstructor getNumber() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Number");
            return new NumberConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ObjectConstructor getObject() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Object");
            return new ObjectConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static RegExpConstructor getRegExp() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("RegExp");
            return new RegExpConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static StringConstructor getString() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("String");
            return new StringConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static VBArrayConstructor getVBArray() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("VBArray");
            return new VBArrayConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getboolean() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("boolean");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getbyte() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("byte");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getchar() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("char");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getdecimal() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("decimal");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getdouble() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("double");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getfloat() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("float");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getint() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("int");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getlong() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("long");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getsbyte() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("sbyte");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getshort() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("short");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getuint() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("uint");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getulong() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("ulong");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getushort() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("ushort");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType getvoid() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("void");
            return new NetType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}