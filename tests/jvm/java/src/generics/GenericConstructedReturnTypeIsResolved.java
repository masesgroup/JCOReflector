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
public class GenericConstructedReturnTypeIsResolved {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericConstructedReturnTypeIsResolved();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises a method whose return type is a constructed generic over a class-level type
     * parameter: List<T>.AsReadOnly() returns ReadOnlyCollection<T> and List<T>.GetRange(...)
     * returns List<T>. They must be declared as ReadOnlyCollection_1<T> / List_1<T>, not as the raw
     * classes, while the returned instance is still wrapped correctly.
     */
    static void testGenericConstructedReturnTypeIsResolved() throws Throwable {
        assertParameterized(List_1.class.getMethod("AsReadOnly").getGenericReturnType(), ReadOnlyCollection_1.class, List_1.class, "T");
        assertParameterized(List_1.class.getMethod("GetRange", int.class, int.class).getGenericReturnType(), List_1.class, List_1.class, "T");

        // the typed results are usable end to end
        List_1<system.Object> list = new List_1<system.Object>() {};
        list.Add(new system.Object());
        list.Add(new system.Object());

        ReadOnlyCollection_1<system.Object> readOnly = list.AsReadOnly();
        if (readOnly.getCount() != 2) throw new AssertionError("Expected 2 elements in the read-only view");

        List_1<system.Object> range = list.GetRange(0, 1);
        if (range.getCount() != 1) throw new AssertionError("Expected 1 element in the range");
    }

    static void assertParameterized(java.lang.reflect.Type type, Class<?> raw, Class<?> declaring, String variableName) {
        if (!(type instanceof java.lang.reflect.ParameterizedType))
            throw new AssertionError("Expected " + raw.getSimpleName() + "<" + variableName + ">, got " + type);
        java.lang.reflect.ParameterizedType parameterized = (java.lang.reflect.ParameterizedType) type;
        if (parameterized.getRawType() != raw)
            throw new AssertionError("Expected raw type " + raw.getSimpleName() + ", got " + parameterized.getRawType());
        java.lang.reflect.Type argument = parameterized.getActualTypeArguments()[0];
        if (!(argument instanceof java.lang.reflect.TypeVariable)
                || ((java.lang.reflect.TypeVariable<?>) argument).getGenericDeclaration() != declaring
                || !((java.lang.reflect.TypeVariable<?>) argument).getName().equals(variableName))
            throw new AssertionError("Expected type variable " + variableName + " of " + declaring.getSimpleName() + ", got " + argument);
    }
}
