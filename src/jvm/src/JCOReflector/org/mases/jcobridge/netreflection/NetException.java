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
import org.mases.jcobridge.netreflection.JCOBridgeInstance;

import java.util.ArrayList;

/**
 * The base .NET class managing System.Exception, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link Throwable}.
 * Implements {@link IJCOBridgeReflected}
 */
public class NetException extends Throwable implements IJCOBridgeReflected {
    static long serialVersionUID = 6575785859373L;
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public static final String className = "System.Exception";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
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
        } catch (JCException e) {
            JCOReflector.writeLog(e);
            return null;
        }
    }

    public NetException() {
        super();
    }

    public NetException(Object instance) {
        if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else if (instance instanceof JCNativeException) {
            jcNativeException = (JCNativeException) instance;
            classInstance = jcNativeException.getCLRException();
        }
    }

    public NetException(String message) {
        super(message, null, false, false);
    }

    public NetException(NetException cause) {
        super(null, cause, false, false);
    }

    public NetException(String message, NetException cause) {
        super(message, cause, false, false);
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
    }

    public JCType getJCOType() {
        return classType;
    }

    /*
     * public final void setJCNativeException(JCNativeException jcne) {
     * jcNativeException = jcne; }
     */
    public static NetException cast(IJCOBridgeReflected from) throws Throwable {
        return new NetException(from.getJCOInstance());
    }

    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    // Instance Properties section
    @Override
    public final java.lang.String getMessage() {
        try {
            Object genericInstance = getJCOInstance();
            if (genericInstance != null) {
                JCObject objectInstance = (JCObject) genericInstance;
                return (java.lang.String) objectInstance.Get("Message");
            } else if (jcNativeException != null) {
                return jcNativeException.getMessage();
            } else
                return super.getMessage();
        } catch (JCNativeException jcne) {
            JCOReflector.writeLog(jcne);
            return null;
        }
    }

    @Override
    public final StackTraceElement[] getStackTrace() {
        try {
            Object genericInstance = getJCOInstance();
            if (genericInstance != null) {
                JCObject objectInstance = (JCObject) genericInstance;
                String stackTrace = (java.lang.String) objectInstance.Get("StackTrace");
                String lines[] = stackTrace.split("\\r?\\n");
                ArrayList<StackTraceElement> elems = new ArrayList<StackTraceElement>();
                for (String string : lines) {
                    elems.add(new StackTraceElement("declaringClass", "methodName", "fileName", 0));
                }
                StackTraceElement[] elemsArray = new StackTraceElement[elems.size()];
                elemsArray = elems.toArray(elemsArray);
                return elemsArray;
            } else if (jcNativeException != null) {
                return jcNativeException.getStackTrace();
            } else
                return super.getStackTrace();
        } catch (JCNativeException jcne) {
            JCOReflector.writeLog(jcne);
            return null;
        }
    }

    public boolean Equals(IJCOBridgeReflected other) {
        return getJCOInstance().equals(other.getJCOInstance());
    }

    public static boolean Equals(IJCOBridgeReflected first, IJCOBridgeReflected other) {
        return first.getJCOInstance().equals(other.getJCOInstance());
    }

    @Override
    public int hashCode() {
        Object genericInstance = getJCOInstance();
        if (genericInstance != null) {
            JCObject objectInstance = (JCObject) genericInstance;
            return objectInstance.hashCode();
        } else if (jcNativeException != null) {
            return jcNativeException.hashCode();
        } else
            return super.hashCode();
    }

    public int GetHashCode() {
        return hashCode();
    }

    @Override
    public String toString() {
        Object genericInstance = getJCOInstance();
        if (genericInstance != null) {
            JCObject objectInstance = (JCObject) genericInstance;
            return objectInstance.toString();
        } else if (jcNativeException != null) {
            return jcNativeException.toString();
        } else
            return super.toString();
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
        return NetType.IsAssignableFrom(this.getJCOType(), second);
    }

    boolean IsSubclassOf(IJCOBridgeReflected second) throws Throwable {
        return NetType.IsSubclassOf(this, second);
    }

    boolean IsSubclassOf(JCType second) throws Throwable {
        return NetType.IsSubclassOf(this.getJCOType(), second);
    }
}