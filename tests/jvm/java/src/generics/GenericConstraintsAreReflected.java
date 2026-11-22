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
public class GenericConstraintsAreReflected {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericConstraintsAreReflected();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises the constraints that Java can express. Nullable<T> is declared in .NET with "where T : struct":
     * the C# compiler records it as a ValueType constraint, so the Java type parameter is bounded by ValueType
     * and not only by IJCOBridgeReflected. A type parameter without a constraint, like the one of List<T>,
     * keeps the plain bound. The reflected struct wrappers must extend ValueType, otherwise a valid type
     * argument would be rejected by javac.
     */
    static void testGenericConstraintsAreReflected() throws Throwable {
        ClassLoader cl = GenericConstraintsAreReflected.class.getClassLoader();
        Class<?> nullable;
        Class<?> valueType;
        Class<?> uint32;
        try {
            nullable = Class.forName("system.Nullable_1", false, cl);
            valueType = Class.forName("system.ValueType", false, cl);
            uint32 = Class.forName("system.UInt32", false, cl);
        } catch (ClassNotFoundException notAvailable) {
            Console.WriteLine("Nullable_1 or ValueType not available in this framework, skipping");
            return;
        }

        // where T : struct
        java.lang.reflect.Type[] bounds = nullable.getTypeParameters()[0].getBounds();
        if (bounds.length != 1 || bounds[0] != valueType)
            throw new AssertionError("The type parameter of Nullable_1 must be bounded by ValueType, got " + java.util.Arrays.toString(bounds));

        // the struct wrappers satisfy that bound
        if (!valueType.isAssignableFrom(uint32))
            throw new AssertionError("UInt32 must extend ValueType, or it could not be a type argument of Nullable_1");

        // no constraint: the plain bound
        java.lang.reflect.Type[] listBounds = List_1.class.getTypeParameters()[0].getBounds();
        if (listBounds.length != 1 || listBounds[0] != IJCOBridgeReflected.class)
            throw new AssertionError("The type parameter of List_1 must keep the IJCOBridgeReflected bound, got " + java.util.Arrays.toString(listBounds));
    }
}
