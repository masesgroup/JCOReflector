/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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
            return bridge.GetType(className + ", "
                    + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
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
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    public Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    public static void AssertCast(IJCOBridgeReflected to, IJCOBridgeReflected from) throws Throwable {
        if (!NetType.CanCast(to, from)) {
            throw new UnsupportedOperationException(String.format("%s cannot be casted to %s", from.getJCOObjectName(),
                    (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName)));
        }
    }

    public static void AssertCast(JCType to, IJCOBridgeReflected from) throws Throwable {
        if (!NetType.CanCast(to, from)) {
            throw new UnsupportedOperationException(String.format("%s cannot be casted to %s", from.getJCOObjectName(),
                    (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName)));
        }
    }

    public static boolean CanCast(IJCOBridgeReflected to, IJCOBridgeReflected from) throws Throwable {
        return IsAssignableFrom(to.getJCOType(), from.getJCOType()) || IsSubclassOf(to.getJCOType(), from.getJCOType());
    }

    public static boolean CanCast(JCType to, IJCOBridgeReflected from) throws Throwable {
        return IsAssignableFrom(to, from.getJCOType()) || IsSubclassOf(to, from.getJCOType());
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
        String assemblyName = JCOBridgeInstance.getUseFullAssemblyName() ? "assemblyFullName" : "assemblyShortName";
        String TAssemblyname = (String) tClass.getField(assemblyName).get(null);

        return TClassname + ", " + TAssemblyname;
    }
}