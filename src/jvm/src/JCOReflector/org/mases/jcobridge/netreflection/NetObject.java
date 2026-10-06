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
    /**
     * Full name of the assembly that contains {@code System.Object}.
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Short name of the assembly that contains {@code System.Object}.
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Full name of the .NET type managed by this class.
     */
    public static final String className = "System.Object";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The {@link JCType} of the .NET type managed by this class, or {@code null} if it cannot be created.
     */
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

    /**
     * The concrete classes resolved for each generic type argument, captured once in
     * {@link #initializeGenericArguments(String, Object...)} through the anonymous subclass syntax.
     * <p>
     * It is needed because {@code new T(...)} is never legal Java: erasure removes the type at runtime,
     * so any code that must instantiate a wrapper of a type argument has to go through here.
     */
    protected Class<?>[] genericArgumentClasses;

    /**
     * Reflectively builds an instance of the i-th generic type argument, wrapping a native handle
     * returned from the bridge. It is the equivalent of {@code new T(nativeHandle)}, which is illegal Java.
     *
     * @param <X> the type of the instance to build
     * @param index the position of the type argument
     * @param nativeHandle the native object returned from the bridge
     * @return the new instance of the type argument
     * @throws IllegalStateException if the type arguments were never resolved
     * @throws IllegalArgumentException if the type argument has no public constructor accepting a single {@code Object}
     * @throws Throwable if the constructor of the type argument fails
     */
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
     * @return the {@code JCObject} that wraps the new CLR instance of the closed generic type
     * @throws Throwable if the instance was not created with the anonymous subclass syntax, if a type argument is not a reflected class, or if the CLR constructor fails
     */
    protected JCObject initializeGenericArguments(String genericJCOClassName, Object... constructorArgs) throws Throwable {
        Class<?> currentClass = getClass();
        
        // Check the cache to see if this anonymous class has already been analyzed
        String fullGenericClrName = clrGenericNameCache.get(currentClass);
        
        if (fullGenericClrName == null) {
            java.lang.reflect.Type superclass = currentClass.getGenericSuperclass();
            
            if (superclass instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterized = (java.lang.reflect.ParameterizedType) superclass;
                java.lang.reflect.Type[] actualTypeArguments = parameterized.getActualTypeArguments();
                
                StringBuilder clrGenericsSpec = new StringBuilder("[");
                Class<?>[] resolvedClasses = new Class<?>[actualTypeArguments.length];
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    java.lang.Class<?> actualClass = (java.lang.Class<?>) actualTypeArguments[i];
                    resolvedClasses[i] = actualClass;

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
            return (JCObject) concreteType.NewObject(constructorArgs);
        } catch (JCNativeException e) {
            throw translateException(e);
        }
    }

    /**
     * A shared instance without an underlying .NET object.
     */
    public final static NetObject Null = new NetObject();

    /**
     * Initializes a new {@link NetObject} without an underlying .NET object.
     */
    public NetObject() {
    }

    /**
     * Initializes a new {@link NetObject} using the given instance.
     *
     * @param instance a reflected object, whose underlying {@code JCObject} is shared, or any other object accepted by the bridge, such as a boxed native value
     */
    public NetObject(Object instance) {
        if (instance instanceof IJCOBridgeReflected) {
            if (((IJCOBridgeReflected) instance).getJCOInstance() instanceof JCObject)
                classInstance = (JCObject) ((IJCOBridgeReflected) instance).getJCOInstance();
        } else {
            classInstance = instance;
        }
    }

    /**
     * Returns the full name of the assembly of the .NET type.
     *
     * @return the full assembly name
     */
    public String getJCOAssemblyName() {
        return assemblyFullName;
    }

    /**
     * Returns the full name of the .NET type.
     *
     * @return the full class name
     */
    public String getJCOClassName() {
        return className;
    }

    /**
     * Returns the name of the .NET type qualified with its assembly.
     *
     * @return the assembly qualified name
     */
    public String getJCOObjectName() {
        return className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    /**
     * Returns the underlying object managed by the bridge.
     *
     * @return the underlying object, or {@code null} if there is none
     */
    public java.lang.Object getJCOInstance() {
        return classInstance;
    }

    /**
     * Sets the underlying object managed by the bridge.
     *
     * @param instance the new underlying object
     */
    public void setJCOInstance(JCObject instance) {
        classInstance = instance;
    }

    /**
     * Returns the {@link JCType} of the .NET type.
     *
     * @return the type of the .NET class
     */
    public JCType getJCOType() {
        return classType;
    }

    /**
     * Casts a reflected object to {@link NetObject}.
     *
     * @param from the object to cast
     * @return a {@link NetObject} that shares the underlying instance of {@code from}
     * @throws UnsupportedOperationException if {@code from} cannot be cast to the .NET type
     * @throws Throwable if the check made by the bridge fails
     */
    public static NetObject cast(IJCOBridgeReflected from) throws Throwable {
        if (!NetType.CanCast(classType, from.getJCOType())) {
            throw new UnsupportedOperationException(String.format("%s cannot be casted to %s", from.getJCOObjectName(),
                    (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName)));
        }
        return new NetObject(from.getJCOInstance());
    }

    /**
     * Translates the exception raised by the CLR into the corresponding reflected Java exception.
     *
     * @param ne the exception raised by the CLR
     * @return the reflected Java exception, or {@code ne} itself if there is no corresponding class
     * @throws IllegalArgumentException if {@code ne} is {@code null}
     * @throws Throwable if the reflected exception cannot be created
     */
    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    /**
     * Converts an array of reflected objects into the array of their underlying instances, as expected by the bridge.
     *
     * @param <T> the type of the reflected objects
     * @param input the array to convert
     * @return an array with the underlying instance of each object, empty if {@code input} is {@code null}
     */
    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
    }

    /**
     * Not managed: arrays of arrays cannot be converted.
     *
     * @param <T> the type of the reflected objects
     * @param input the array to convert
     * @return never returns normally
     * @throws UnsupportedOperationException always
     */
    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[][] input) {
        throw new java.lang.UnsupportedOperationException("Not managed");
    }

    /**
     * Determines whether the underlying instance is equal to the one of another object.
     *
     * @param other the object to compare with
     * @return {@code true} if the underlying instances are equal
     */
    public boolean Equals(IJCOBridgeReflected other) {
        return getJCOInstance().equals(other.getJCOInstance());
    }

    /**
     * Determines whether the underlying instances of two objects are equal.
     *
     * @param first the first object
     * @param other the second object
     * @return {@code true} if the underlying instances are equal
     */
    public static boolean Equals(IJCOBridgeReflected first, IJCOBridgeReflected other) {
        return first.getJCOInstance().equals(other.getJCOInstance());
    }

    @Override
    public int hashCode() {
        return getJCOInstance().hashCode();
    }

    /**
     * Returns the hash code of the underlying instance.
     *
     * @return the hash code
     */
    public int GetHashCode() {
        return hashCode();
    }

    @Override
    public String toString() {
        return getJCOInstance().toString();
    }

    /**
     * Returns the string representation of the underlying instance.
     *
     * @return the string representation
     */
    public String ToString() {
        return toString();
    }

    /**
     * Returns the .NET type of the underlying instance, or the type managed by this class if there is none.
     *
     * @return the {@link NetType} of the object
     * @throws Throwable if the type cannot be obtained from the bridge
     */
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