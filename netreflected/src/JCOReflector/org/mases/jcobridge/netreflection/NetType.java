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
 * The base .NET class managing System.Type, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}
 */
public class NetType extends NetObject {
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public final String className = "System.Type";
    IJCOBridgeReflected classInstance = null;
    static JCType classType = null;
    static JCEnum enumInstance = null;

    public NetType(Object instance) throws Throwable {
        if (instance instanceof IJCOBridgeReflected) {
            classInstance = (IJCOBridgeReflected) instance;
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
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    public Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    static boolean IsAssignableFrom(IJCOBridgeReflected first, IJCOBridgeReflected second) throws Throwable {
        return IsAssignableFrom(first.getJCOType(), second.getJCOType());
    }

    static boolean IsAssignableFrom(JCType first, JCType second) throws Throwable {
        try {
            return (boolean) first.Invoke("IsAssignableFrom", second); // doesn't work, evolution/bug fixing/feature
                                                                       // requested to the JCOBridge Core team
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    static boolean IsSubclassOf(IJCOBridgeReflected first, IJCOBridgeReflected second) throws Throwable {
        return IsSubclassOf(first.getJCOType(), second.getJCOType());
    }

    static boolean IsSubclassOf(JCType first, JCType second) throws Throwable {
        try {
            return (boolean) first.Invoke("IsSubclassOf", second); // doesn't work, evolution/bug fixing/feature
                                                                   // requested to the JCOBridge Core team
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }
}