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
import org.mases.jcobridge.netreflection.IJCOBridgeReflected;
import org.mases.jcobridge.netreflection.JCOBridgeInstance;
import org.mases.jcobridge.netreflection.NetType;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The base .NET class managing System.Object, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Implements
 * {@link IJCOBridgeReflected}
 */
public class NetObject implements IJCOBridgeReflected {
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public static final String className = "System.Object";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    Object classInstance = null;

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

    // --- COLD-PATH AND HOT-PATH MANAGEMENT FOR CLR GENERICS ---
    private static final java.util.concurrent.ConcurrentHashMap<Class<?>, String> clrGenericNameCache = new java.util.concurrent.ConcurrentHashMap<>();

    // Stores the concrete Class<?> resolved for each generic type argument (T, K, ...),
    // captured once in initializeGenericArguments via the anonymous-subclass trick.
    // Needed because "new T(...)" is never legal Java: erasure removes T at runtime,
    // so any later code that must instantiate a wrapper of type T has to go through here.
    protected Class<?>[] genericArgumentClasses;

    // Reflectively builds an instance of the i-th generic type argument, wrapping a native
    // handle returned from the bridge. Equivalent to "new T(nativeHandle)" where "new T(...)"
    // itself is illegal Java.
    @SuppressWarnings("unchecked")
    protected <X> X instantiateGenericArgument(int index, Object nativeHandle) throws Throwable {
        if (genericArgumentClasses == null || index >= genericArgumentClasses.length) {
            throw new IllegalStateException(
                "JCOReflector Error: generic argument classes were never resolved (was initializeGenericArguments called?).");
        }
        try {
            java.lang.reflect.Constructor<?> ctor = genericArgumentClasses[index].getConstructor(java.lang.Object.class);
            return (X) ctor.newInstance(nativeHandle);
        } catch (java.lang.reflect.InvocationTargetException ite) {
            Throwable cause = ite.getCause();
            throw (cause != null) ? cause : ite;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(
                "JCOReflector Error: generic type argument " + genericArgumentClasses[index].getName() +
                " does not expose a public constructor accepting a single Object parameter.", e);
        }
    }

    /**
     * Dynamically initializes the native CLR instance by resolving type parameters and calling NewObject with constructor arguments.
     * @param genericJCOClassName The full name of the .NET generic type (e.g., "System.Collections.Generic.List`1")
     * @param constructorArgs The parameters to pass to the CLR constructor
     */
    protected void initializeGenericArguments(String genericJCOClassName, Object... constructorArgs) throws Throwable {
        Class<?> currentClass = getClass();
        
        // Check the cache to see if this anonymous class has already been analyzed
        String fullGenericClrName = clrGenericNameCache.get(currentClass);
        
        if (fullGenericClrName == null) {
            java.lang.reflect.Type superclass = currentClass.getGenericSuperclass();
            
            if (superclass instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterized = (java.lang.reflect.ParameterizedType) superclass;
                java.lang.reflect.Type[] actualTypeArguments = parameterized.getActualTypeArguments();
                
                StringBuilder clrGenericsSpec = new StringBuilder("[");
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    java.lang.Class<?> actualClass = (java.lang.Class<?>) actualTypeArguments[i];

                    // Read the static "className" field via reflection instead of instantiating a throwaway
                    // object: works for interfaces, exceptions, or any class without a no-arg constructor.
                    String typeClrName;
                    try {
                        typeClrName = (String) actualClass.getField("className").get(null);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new IllegalArgumentException(
                            "JCOReflector Error: generic type argument " + actualClass.getName() +
                            " does not expose a public static 'className' field (is it a reflected .NET type?).", e);
                    }
                    clrGenericsSpec.append(typeClrName);

                    if (i < actualTypeArguments.length - 1) {
                        clrGenericsSpec.append(", ");
                    }
                }
                StringBuilder clrGenericsSpec = new StringBuilder("[");
                Class<?>[] resolvedClasses = new Class<?>[actualTypeArguments.length];
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    java.lang.Class<?> actualClass = (java.lang.Class<?>) actualTypeArguments[i];
                    resolvedClasses[i] = actualClass;
                    ...
                }
                clrGenericsSpec.append("]");
                this.genericArgumentClasses = resolvedClasses; // cache for later "new T(...)" replacements
                
                // Compose the final name (e.g., "System.Collections.Generic.List`1[System.String]")
                fullGenericClrName = genericJCOClassName + clrGenericsSpec.toString();
                clrGenericNameCache.put(currentClass, fullGenericClrName);
            } else {
                throw new IllegalArgumentException(
                    "JCOReflector Error: Generic instances require the anonymous class curly braces syntax {}.\n" +
                    "Correct example: new " + currentClass.getSuperclass().getSimpleName() + "<T>() {}"
                );
            }
        }
        
        // Get the concrete type dynamically from the bridge and invoke NewObject correctly
        try {
            JCType concreteType = JCOBridgeInstance.getInstance(getJCOAssemblyName()).GetType(fullGenericClrName);
            this.classInstance = (JCObject) concreteType.NewObject(constructorArgs);
        } catch (JCNativeException e) {
            throw translateException(e);
        }
    }

    public final static NetObject Null = new NetObject();

    public NetObject() {
    }

    public NetObject(Object instance) {
        if (instance instanceof IJCOBridgeReflected) {
            if (((IJCOBridgeReflected) instance).getJCOInstance() instanceof JCObject)
                classInstance = (JCObject) ((IJCOBridgeReflected) instance).getJCOInstance();
        } else {
            classInstance = instance;
        }
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

    public static NetObject cast(IJCOBridgeReflected from) throws Throwable {
        if (!NetType.CanCast(classType, from.getJCOType())) {
            throw new UnsupportedOperationException(String.format("%s cannot be casted to %s", from.getJCOObjectName(),
                    (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName)));
        }
        return new NetObject(from.getJCOInstance());
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
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
        if (classInstance instanceof JCObject || classInstance instanceof IJCOBridgeReflected) {
            return new NetType(classInstance);
        }
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