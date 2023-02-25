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

package system.runtime.interopservices.javascript;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.runtime.interopservices.javascript.JSMarshalerType;


/**
 * The base .NET class managing System.Runtime.InteropServices.JavaScript.JSMarshalerType, System.Runtime.InteropServices.JavaScript, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.JavaScript.JSMarshalerType" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.JavaScript.JSMarshalerType</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class JSMarshalerType extends NetObject  {
    /**
     * Fully assembly qualified name: System.Runtime.InteropServices.JavaScript, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Runtime.InteropServices.JavaScript, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Runtime.InteropServices.JavaScript
     */
    public static final String assemblyShortName = "System.Runtime.InteropServices.JavaScript";
    /**
     * Qualified class name: System.Runtime.InteropServices.JavaScript.JSMarshalerType
     */
    public static final String className = "System.Runtime.InteropServices.JavaScript.JSMarshalerType";
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
    public JSMarshalerType(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link JSMarshalerType}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link JSMarshalerType} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static JSMarshalerType cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new JSMarshalerType(from.getJCOInstance());
    }

    // Constructors section
    
    public JSMarshalerType() throws Throwable {
    }



    
    // Methods section
    
    public static JSMarshalerType Action() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAction = (JCObject)classType.Invoke("Action");
            return new JSMarshalerType(objAction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Action(JSMarshalerType arg1, JSMarshalerType arg2, JSMarshalerType arg3) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAction = (JCObject)classType.Invoke("Action", arg1 == null ? null : arg1.getJCOInstance(), arg2 == null ? null : arg2.getJCOInstance(), arg3 == null ? null : arg3.getJCOInstance());
            return new JSMarshalerType(objAction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Action(JSMarshalerType arg1, JSMarshalerType arg2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAction = (JCObject)classType.Invoke("Action", arg1 == null ? null : arg1.getJCOInstance(), arg2 == null ? null : arg2.getJCOInstance());
            return new JSMarshalerType(objAction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Action(JSMarshalerType arg1) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAction = (JCObject)classType.Invoke("Action", arg1 == null ? null : arg1.getJCOInstance());
            return new JSMarshalerType(objAction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Array(JSMarshalerType element) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objArray = (JCObject)classType.Invoke("Array", element == null ? null : element.getJCOInstance());
            return new JSMarshalerType(objArray);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType ArraySegment(JSMarshalerType element) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objArraySegment = (JCObject)classType.Invoke("ArraySegment", element == null ? null : element.getJCOInstance());
            return new JSMarshalerType(objArraySegment);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Function(JSMarshalerType arg1, JSMarshalerType arg2, JSMarshalerType arg3, JSMarshalerType result) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFunction = (JCObject)classType.Invoke("Function", arg1 == null ? null : arg1.getJCOInstance(), arg2 == null ? null : arg2.getJCOInstance(), arg3 == null ? null : arg3.getJCOInstance(), result == null ? null : result.getJCOInstance());
            return new JSMarshalerType(objFunction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Function(JSMarshalerType arg1, JSMarshalerType arg2, JSMarshalerType result) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFunction = (JCObject)classType.Invoke("Function", arg1 == null ? null : arg1.getJCOInstance(), arg2 == null ? null : arg2.getJCOInstance(), result == null ? null : result.getJCOInstance());
            return new JSMarshalerType(objFunction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Function(JSMarshalerType arg1, JSMarshalerType result) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFunction = (JCObject)classType.Invoke("Function", arg1 == null ? null : arg1.getJCOInstance(), result == null ? null : result.getJCOInstance());
            return new JSMarshalerType(objFunction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Function(JSMarshalerType result) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFunction = (JCObject)classType.Invoke("Function", result == null ? null : result.getJCOInstance());
            return new JSMarshalerType(objFunction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Nullable(JSMarshalerType primitive) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objNullable = (JCObject)classType.Invoke("Nullable", primitive == null ? null : primitive.getJCOInstance());
            return new JSMarshalerType(objNullable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Span(JSMarshalerType element) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objSpan = (JCObject)classType.Invoke("Span", element == null ? null : element.getJCOInstance());
            return new JSMarshalerType(objSpan);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Task() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objTask = (JCObject)classType.Invoke("Task");
            return new JSMarshalerType(objTask);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType Task(JSMarshalerType result) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objTask = (JCObject)classType.Invoke("Task", result == null ? null : result.getJCOInstance());
            return new JSMarshalerType(objTask);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static JSMarshalerType getBigInt64() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("BigInt64");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getBoolean() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Boolean");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getByte() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Byte");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getChar() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Char");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getDateTime() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("DateTime");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getDateTimeOffset() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("DateTimeOffset");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getDiscard() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Discard");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getDouble() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Double");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getException() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Exception");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getInt16() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Int16");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getInt32() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Int32");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getInt52() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Int52");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getIntPtr() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("IntPtr");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getJSObject() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("JSObject");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getObject() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Object");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getSingle() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Single");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getString() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("String");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static JSMarshalerType getVoid() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Void");
            return new JSMarshalerType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}