/*
 *  MIT License
 *
 *  Copyright (c) 2020-2026 MASES s.r.l.
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

package org.mases.jcobridge.netreflection;

import org.mases.jcobridge.*;

/**
 * The base .NET class managing System.Type, mscorlib, Version=4.0.0.0,
 * Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}
 */
public class NetType extends NetObject {
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public static final String className = "System.Type";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCType classInstance = null;

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

    public NetType(Object instance) throws Throwable {
        if (instance instanceof IJCOBridgeReflected) {
            JCObject obj = (JCObject) ((IJCOBridgeReflected) instance).getJCOInstance();
            classInstance = (JCType) obj.Invoke("GetType");
        } else if (instance instanceof JCType) {
            classInstance = (JCType) instance;
        } else if (instance instanceof JCObject) {
            JCObject obj = (JCObject) instance;
            classInstance = (JCType) obj.Invoke("GetType");
        } else
            throw new Exception("Cannot manage object, cannot found a JCType");
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

    public static void AssertCast(IJCOBridgeReflected to, IJCOBridgeReflected from) throws Throwable {
        if (!NetType.CanCast(to, from)) {
            throw new UnsupportedOperationException(String.format("%s cannot be casted to %s", from.getJCOObjectName(),
                    to.getJCOObjectName()));
        }
    }

    public static void AssertCast(JCType to, IJCOBridgeReflected from) throws Throwable {
        if (!NetType.CanCast(to, from)) {
            throw new UnsupportedOperationException(String.format("%s cannot be casted to %s", from.getJCOObjectName(),
                    to.toString()));
        }
    }

    public static boolean CanCast(IJCOBridgeReflected to, IJCOBridgeReflected from) throws Throwable {
        return CanCast(to.getJCOType(), from);
    }

    /**
     * Checks if {@code from} can be casted to the type {@code to}.
     * <p>
     * The wrapper of a generic type returns from {@code getJCOType()} the type created from its class name, that is
     * the <b>open</b> generic definition (for example {@code Dictionary`2}), never the closed type of the instance.
     * {@code Type.IsAssignableFrom} is always false between open generic definitions, so, when the quick check
     * fails and {@code to} is a generic type definition, the runtime type of the instance is inspected
     * (see {@link #IsInstanceOfGenericDefinition(JCType, IJCOBridgeReflected)}).
     */
    public static boolean CanCast(JCType to, IJCOBridgeReflected from) throws Throwable {
        return IsAssignableFrom(to, from.getJCOType()) || IsSubclassOf(to, from.getJCOType())
                || IsInstanceOfGenericDefinition(to, from);
    }

    /**
     * Checks if the runtime type of {@code from} is built from the generic type definition {@code to}, either because
     * the type itself, one of its base types or one of the interfaces it implements is a constructed form of it:
     * {@code Dictionary<string, int>} is an instance of the definition {@code IDictionary`2}.
     */
    static boolean IsInstanceOfGenericDefinition(JCType to, IJCOBridgeReflected from) throws Throwable {
        try {
            if (!(boolean) to.GetOnType("IsGenericTypeDefinition"))
                return false;
            Object instance = from.getJCOInstance();
            if (!(instance instanceof JCObject))
                return false;

            // the real, closed, type of the instance
            Object runtimeType = ((JCObject) instance).Invoke("GetType");

            // the type and its base types
            for (Object current = runtimeType; current != null; current = TypeGet(current, "BaseType")) {
                if (IsConstructedFrom(to, current))
                    return true;
            }
            // every interface the type implements, inherited ones included
            Object interfaces = TypeInvoke(runtimeType, "GetInterfaces");
            if (interfaces instanceof JCObject) {
                JCObject array = (JCObject) interfaces;
                int length = (int) array.Get("Length");
                for (int i = 0; i < length; i++) {
                    Object item = array.Invoke("GetValue", i);
                    if (item != null && IsConstructedFrom(to, item))
                        return true;
                }
            }
            return false;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    // the CLR type objects can be returned as JCType or as JCObject: the same member is read in the two ways
    private static Object TypeGet(Object type, String property) throws JCNativeException {
        return (type instanceof JCType) ? ((JCType) type).GetOnType(property) : ((JCObject) type).Get(property);
    }

    private static Object TypeInvoke(Object type, String method, Object... params) throws JCNativeException {
        return (type instanceof JCType) ? ((JCType) type).InvokeOnType(method, params) : ((JCObject) type).Invoke(method, params);
    }

    private static boolean IsConstructedFrom(JCType definition, Object type) throws JCNativeException {
        if (!(boolean) TypeGet(type, "IsGenericType"))
            return false;
        Object typeDefinition = TypeInvoke(type, "GetGenericTypeDefinition");
        return (boolean) definition.InvokeOnType("Equals", typeDefinition);
    }

    public static boolean CanCast(JCType to, JCType from) throws Throwable {
        return IsAssignableFrom(to, from) || IsSubclassOf(to, from);
    }

    public static boolean IsAssignableFrom(IJCOBridgeReflected to, IJCOBridgeReflected from) throws Throwable {
        return IsAssignableFrom(to.getJCOType(), from.getJCOType());
    }

    public static boolean IsAssignableFrom(JCType to, JCType from) throws Throwable {
        try {
            return (boolean) to.InvokeOnType("IsAssignableFrom", from);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsSubclassOf(IJCOBridgeReflected first, IJCOBridgeReflected second) throws Throwable {
        return IsSubclassOf(first.getJCOType(), second.getJCOType());
    }

    public static boolean IsSubclassOf(JCType first, JCType second) throws Throwable {
        try {
            return (boolean) first.InvokeOnType("IsSubclassOf", second);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static <T extends IJCOBridgeReflected> String GetType(Class<T> tClass)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        String TClassname = (String) tClass.getField("className").get(null);
        String assemblyName = JCOReflector.getUseFullAssemblyName() ? "assemblyFullName" : "assemblyShortName";
        String TAssemblyname = (String) tClass.getField(assemblyName).get(null);

        return TClassname + ", " + TAssemblyname;
    }
}