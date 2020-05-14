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

import java.util.ArrayList;
import java.util.Collection;

/**
 * The base .NET class managing System.Object, mscorlib, Version=4.0.0.0,
 * Culture=neutral, PublicKeyToken=b77a5c561934e089. Implements
 * {@link IJCOBridgeReflected}
 */
public class NetObject implements IJCOBridgeReflected {
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public final static String className = "System.Object";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    Object classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", "
                    + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
            return null;
        }
    }

    public NetObject() {
        super();
    }

    public NetObject(Object instance) {
        classInstance = instance;
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

    public static NetObject castFrom(IJCOBridgeReflected from) throws Throwable {
        return new NetObject(from.getJCOInstance());
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        String clrEx = ne.getCLRType();
        int index = clrEx.lastIndexOf('.');
        String nameSpace = clrEx.substring(0, index).toLowerCase();
        clrEx = nameSpace + clrEx.substring(index, clrEx.length());
        if (clrEx != null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(clrEx);
            } catch (ClassNotFoundException cnfe) {
                return ne;
            }
            Object obj = clazz.newInstance();
            if (obj instanceof NetException) {
                NetException netEx = (NetException) obj;
                netEx.setJCNativeException(ne);
                return netEx;
            }
        }
        return ne;
    }

    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        Object[] returnArray = new Object[input.length];
        ArrayList<Object> lst = new ArrayList<Object>();
        for (T t : input) {
            IJCOBridgeReflected obj = (IJCOBridgeReflected) t;
            lst.add(obj.getJCOInstance());
        }
        return lst.toArray();
    }

    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[][] input) {
        throw new java.lang.UnsupportedOperationException("Not managed");
    }

    public boolean Equals(IJCOBridgeReflected other) {
        return getJCOInstance().equals(other.getJCOInstance());
    }

    public static boolean Equals(IJCOBridgeReflected first, IJCOBridgeReflected other) {
        return first.getJCOInstance().equals(other.getJCOInstance());
    }

    @Override
    public int hashCode() {
        return getJCOInstance().hashCode();
    }

    public int GetHashCode() {
        return hashCode();
    }

    @Override
    public String toString() {
        return getJCOInstance().toString();
    }

    public String ToString() {
        return toString();
    }

    public NetType GetType() throws Throwable {
        return new NetType(getJCOType());
    }

    boolean IsAssignableFrom(IJCOBridgeReflected second) throws Throwable {
        return NetType.IsAssignableFrom(this, second);
    }

    boolean IsAssignableFrom(JCType second) throws Throwable {
        return NetType.IsAssignableFrom(getJCOType(), second);
    }

    boolean IsSubclassOf(IJCOBridgeReflected second) throws Throwable {
        return NetType.IsSubclassOf(this, second);
    }

    boolean IsSubclassOf(JCType second) throws Throwable {
        return NetType.IsSubclassOf(getJCOType(), second);
    }
}