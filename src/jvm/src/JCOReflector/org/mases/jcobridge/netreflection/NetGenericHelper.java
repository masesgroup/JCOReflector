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

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Helper for the generic classes that do not extend {@link NetObject}, such as the generic delegates.
 * <p>
 * It offers the same logic used by {@link NetObject}: it reads the type arguments from the anonymous subclass
 * of a generic class ({@code new Foo<Bar>() {}}), builds the name of the closed CLR type and instantiates the
 * type arguments reflectively.
 */
public final class NetGenericHelper {
    private static final ConcurrentHashMap<Class<?>, Class<?>[]> cache = new ConcurrentHashMap<>();

    private NetGenericHelper() {}

    /**
     * Returns the type arguments captured by the anonymous subclass, as in {@code new Foo<Bar>() {}}.
     * The result is cached for each class.
     *
     * @param instanceClass the class of the instance: it must be an anonymous subclass of a generic class
     * @return the classes of the type arguments, in declaration order
     * @throws IllegalArgumentException if the instance was not created with the anonymous subclass syntax, or if a type argument is not a plain class
     */
    public static Class<?>[] resolveTypeArguments(Class<?> instanceClass) {
        Class<?>[] resolved = cache.get(instanceClass);
        if (resolved != null) return resolved;
        Type superclass = instanceClass.getGenericSuperclass();
        if (!(superclass instanceof ParameterizedType))
            throw new IllegalArgumentException(
                "JCOReflector Error: Generic instances require the anonymous class curly braces syntax {}.\n" +
                "Correct example: new " + instanceClass.getSuperclass().getSimpleName() + "<T>() {}");
        Type[] actual = ((ParameterizedType) superclass).getActualTypeArguments();
        resolved = new Class<?>[actual.length];
        for (int i = 0; i < actual.length; i++) {
            if (!(actual[i] instanceof Class<?>))
                throw new IllegalArgumentException("JCOReflector Error: unsupported generic argument " + actual[i]);
            resolved[i] = (Class<?>) actual[i];
        }
        cache.put(instanceClass, resolved);
        return resolved;
    }

    /**
     * Builds the name of a closed generic CLR type, for example {@code System.Collections.Generic.List`1[System.Object]}.
     * The name of each type argument is read from its public static {@code className} field.
     *
     * @param openClrName the name of the open generic type, for example {@code System.Collections.Generic.List`1}
     * @param typeArguments the classes of the type arguments
     * @return the name of the closed generic type
     * @throws IllegalArgumentException if a type argument does not expose a public static {@code className} field
     */
    public static String buildClosedClrName(String openClrName, Class<?>[] typeArguments) {
        StringBuilder sb = new StringBuilder(openClrName).append('[');
        for (int i = 0; i < typeArguments.length; i++) {
            try {
                sb.append((String) typeArguments[i].getField("className").get(null));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new IllegalArgumentException("JCOReflector Error: generic type argument " +
                    typeArguments[i].getName() + " does not expose a public static 'className' field.", e);
            }
            if (i < typeArguments.length - 1) sb.append(", ");
        }
        return sb.append(']').toString();
    }

    /**
     * Reflectively builds an instance of a type argument, wrapping a native handle returned from the bridge.
     * It uses the public constructor of the type argument that accepts a single {@code Object}.
     *
     * @param <X> the type of the instance to build
     * @param typeArguments the classes of the type arguments
     * @param index the position of the type argument to instantiate
     * @param nativeHandle the native object returned from the bridge
     * @return the new instance of the type argument
     * @throws Throwable if the type argument has no public constructor accepting a single {@code Object}, or if that constructor fails
     */
    @SuppressWarnings("unchecked")
    public static <X> X instantiate(Class<?>[] typeArguments, int index, Object nativeHandle) throws Throwable {
        try {
            return (X) typeArguments[index].getConstructor(Object.class).newInstance(nativeHandle);
        } catch (java.lang.reflect.InvocationTargetException ite) {
            throw ite.getCause() != null ? ite.getCause() : ite;
        }
    }
}