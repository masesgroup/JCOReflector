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
import microsoft.jscript.DateObject;
import microsoft.jscript.DateConstructor;


/**
 * The base .NET class managing Microsoft.JScript.DatePrototype, Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.DatePrototype" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.DatePrototype</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class DatePrototype extends DateObject  {
    /**
     * Fully assembly qualified name: Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.JScript
     */
    public static final String assemblyShortName = "Microsoft.JScript";
    /**
     * Qualified class name: Microsoft.JScript.DatePrototype
     */
    public static final String className = "Microsoft.JScript.DatePrototype";
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
    public DatePrototype(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DatePrototype}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DatePrototype} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DatePrototype cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DatePrototype(from.getJCOInstance());
    }

    // Constructors section
    
    public DatePrototype() throws Throwable {
    }



    
    // Methods section
    
    public static double getDate(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getDate", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getDay(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getDay", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getFullYear(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getFullYear", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getHours(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getHours", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getMilliseconds(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getMilliseconds", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getMinutes(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getMinutes", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getMonth(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getMonth", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getSeconds(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getSeconds", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getTime(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getTime", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getTimezoneOffset(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getTimezoneOffset", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCDate(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCDate", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCDay(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCDay", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCFullYear(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCFullYear", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCHours(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCHours", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCMilliseconds(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCMilliseconds", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCMinutes(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCMinutes", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCMonth(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCMonth", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getUTCSeconds(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getUTCSeconds", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double getYear(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("getYear", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setDate(NetObject thisob, double ddate) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setDate", thisob == null ? null : thisob.getJCOInstance(), ddate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setFullYear(NetObject thisob, double dyear, NetObject month, NetObject date) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.MissingMethodException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setFullYear", thisob == null ? null : thisob.getJCOInstance(), dyear, month == null ? null : month.getJCOInstance(), date == null ? null : date.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setHours(NetObject thisob, double dhour, NetObject min, NetObject sec, NetObject msec) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.MissingMethodException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setHours", thisob == null ? null : thisob.getJCOInstance(), dhour, min == null ? null : min.getJCOInstance(), sec == null ? null : sec.getJCOInstance(), msec == null ? null : msec.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setMilliseconds(NetObject thisob, double dmsec) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setMilliseconds", thisob == null ? null : thisob.getJCOInstance(), dmsec);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setMinutes(NetObject thisob, double dmin, NetObject sec, NetObject msec) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.MissingMethodException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setMinutes", thisob == null ? null : thisob.getJCOInstance(), dmin, sec == null ? null : sec.getJCOInstance(), msec == null ? null : msec.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setMonth(NetObject thisob, double dmonth, NetObject date) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.MissingMethodException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setMonth", thisob == null ? null : thisob.getJCOInstance(), dmonth, date == null ? null : date.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setSeconds(NetObject thisob, double dsec, NetObject msec) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.MissingMethodException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setSeconds", thisob == null ? null : thisob.getJCOInstance(), dsec, msec == null ? null : msec.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setTime(NetObject thisob, double time) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setTime", thisob == null ? null : thisob.getJCOInstance(), time);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCDate(NetObject thisob, double ddate) throws Throwable, microsoft.jscript.JScriptException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCDate", thisob == null ? null : thisob.getJCOInstance(), ddate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCFullYear(NetObject thisob, double dyear, NetObject month, NetObject date) throws Throwable, microsoft.jscript.JScriptException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.MissingMethodException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCFullYear", thisob == null ? null : thisob.getJCOInstance(), dyear, month == null ? null : month.getJCOInstance(), date == null ? null : date.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCHours(NetObject thisob, double dhour, NetObject min, NetObject sec, NetObject msec) throws Throwable, microsoft.jscript.JScriptException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.MissingMethodException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCHours", thisob == null ? null : thisob.getJCOInstance(), dhour, min == null ? null : min.getJCOInstance(), sec == null ? null : sec.getJCOInstance(), msec == null ? null : msec.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCMilliseconds(NetObject thisob, double dmsec) throws Throwable, microsoft.jscript.JScriptException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCMilliseconds", thisob == null ? null : thisob.getJCOInstance(), dmsec);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCMinutes(NetObject thisob, double dmin, NetObject sec, NetObject msec) throws Throwable, microsoft.jscript.JScriptException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.MissingMethodException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCMinutes", thisob == null ? null : thisob.getJCOInstance(), dmin, sec == null ? null : sec.getJCOInstance(), msec == null ? null : msec.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCMonth(NetObject thisob, double dmonth, NetObject date) throws Throwable, microsoft.jscript.JScriptException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.MissingMethodException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCMonth", thisob == null ? null : thisob.getJCOInstance(), dmonth, date == null ? null : date.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setUTCSeconds(NetObject thisob, double dsec, NetObject msec) throws Throwable, microsoft.jscript.JScriptException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.MissingMethodException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.FormatException, system.OverflowException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setUTCSeconds", thisob == null ? null : thisob.getJCOInstance(), dsec, msec == null ? null : msec.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double setYear(NetObject thisob, double dyear) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArithmeticException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("setYear", thisob == null ? null : thisob.getJCOInstance(), dyear);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static double valueOf(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("valueOf", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject getVarDate(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objgetVarDate = (JCObject)classType.Invoke("getVarDate", thisob == null ? null : thisob.getJCOInstance());
            return new NetObject(objgetVarDate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toDateString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toDateString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toGMTString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toGMTString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toLocaleDateString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.TypeInitializationException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.OverflowException, system.FormatException, system.globalization.CultureNotFoundException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toLocaleDateString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toLocaleString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.TypeInitializationException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.OverflowException, system.FormatException, system.globalization.CultureNotFoundException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toLocaleString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toLocaleTimeString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.TypeInitializationException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.OverflowException, system.FormatException, system.globalization.CultureNotFoundException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toLocaleTimeString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toTimeString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toTimeString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String toUTCString(NetObject thisob) throws Throwable, microsoft.jscript.JScriptException, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("toUTCString", thisob == null ? null : thisob.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static DateConstructor getconstructor() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("constructor");
            return new DateConstructor(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}