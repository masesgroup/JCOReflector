/*
 *  MIT License
 *
 *  Copyright (c) 2020-2025 MASES s.r.l.
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

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.mases.jcobridge.*;

/**
 * The base .NET class managing System.Enum, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}
 */
public class NetEnum extends NetObject {
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public final static String className = "System.Enum";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
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

    // Constructors section
    // Internal ctor: never use it!!!
    public NetEnum(Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }

    public static JCEnum add(JCEnum first, JCEnum second) throws Throwable {
        String[] a = first.getValues();
        String[] b = second.getValues();

        ArrayList<String> newList = new ArrayList<String>();

        for (String string : a) {
            if (!newList.contains(string))
                newList.add(string);
        }

        for (String string : b) {
            if (!newList.contains(string))
                newList.add(string);
        }
        String[] result = new String[newList.size()];
        result = newList.toArray(result);
        return first.fromValues(result);
    }

    public static JCEnum remove(JCEnum first, JCEnum second) throws Throwable {
        String[] a = first.getValues();
        String[] b = second.getValues();

        ArrayList<String> newList = new ArrayList<String>();

        for (String string : a) {
            newList.add(string);
        }

        for (String string : b) {
            if (newList.contains(string))
                newList.remove(string);
        }
        String[] result = new String[newList.size()];
        result = newList.toArray(result);
        return first.fromValues(result);
    }

    public static boolean is(JCEnum first, JCEnum second) throws Throwable {
        String[] a = first.getValues();
        String[] b = second.getValues();

        ArrayList<String> newList = new ArrayList<String>();

        for (String string : a) {
            newList.add(string);
        }
        int index = 0;
        for (String string : b) {
            if (newList.contains(string))
                index++;
        }

        return a.length == index;
    }

    public static boolean has(JCEnum first, JCEnum second) throws Throwable {
        String[] a = first.getValues();
        String[] b = second.getValues();

        ArrayList<String> newList = new ArrayList<String>();

        for (String string : a) {
            newList.add(string);
        }
        for (String string : b) {
            if (newList.contains(string))
                return true;
        }

        return false;
    }

    // Constructors section

    // Methods section

    public static java.lang.String GetName(JCType type, JCObject obj) throws Throwable {
        try {
            return (java.lang.String) classType.Invoke("GetName", type, obj);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    // Instance Properties section

    // Static Properties section

}