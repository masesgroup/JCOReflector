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

package generics;

import org.mases.jcobridge.netreflection.*;

import system.*;
import system.collections.generic.*;
import system.collections.objectmodel.*;

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented. They are written as plain static methods on purpose,
 * so they can be dropped into whatever test harness the project actually uses (JUnit, plain
 * {@code main}, or something else) without depending on a particular framework.
 * <p>
 */
public class GenericAlternateEqualityComparerIsReflected {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericAlternateEqualityComparerIsReflected();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * IAlternateEqualityComparer<TAlternate,T> (.NET 9+) was kept out of the reflected types. Its
     * Equals(TAlternate, T) takes two different type parameters and erases to the same signature as
     * NetObject.Equals(IJCOBridgeReflected, IJCOBridgeReflected): like Equals(T, T) of IEqualityComparer<T>,
     * it is exposed as EqualsGeneric so that both remain callable.
     */
    static void testGenericAlternateEqualityComparerIsReflected() throws Throwable {
        Class<?> comparer;
        try {
            comparer = Class.forName("system.collections.generic.IAlternateEqualityComparer_2", false,
                    GenericAlternateEqualityComparerIsReflected.class.getClassLoader());
        } catch (ClassNotFoundException notAvailable) {
            Console.WriteLine("IAlternateEqualityComparer_2 not available in this framework (.NET 9+), skipping");
            return;
        }

        if (comparer.getTypeParameters().length != 2)
            throw new AssertionError("IAlternateEqualityComparer_2 must have two type parameters");

        comparer.getMethod("EqualsGeneric", IJCOBridgeReflected.class, IJCOBridgeReflected.class);
        assertMissing(comparer, "Equals", IJCOBridgeReflected.class, IJCOBridgeReflected.class);
        comparer.getMethod("Create", IJCOBridgeReflected.class);
        comparer.getMethod("GetHashCode", IJCOBridgeReflected.class);
    }

    static void assertMissing(Class<?> c, String name, Class<?>... params) {
        try {
            c.getMethod(name, params);
            throw new AssertionError(c.getSimpleName() + "." + name + " should have been renamed");
        } catch (NoSuchMethodException expected) {
        }
    }
}
