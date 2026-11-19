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
public class GenericConstructedParameterTypeInConstructor {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericConstructedParameterTypeInConstructor();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises a constructor parameter that is a constructed generic type over a class-level
     * type parameter: List<T>(IEnumerable<T>). The parameter must be exposed as IEnumerable_1<T>,
     * not as the raw IEnumerable_1, the same rule applied to method parameters.
     */
    static void testGenericConstructedParameterTypeInConstructor() throws Throwable {
        java.lang.reflect.Constructor<?> ctor = List_1.class.getConstructor(IEnumerable_1.class);
        java.lang.reflect.Type parameter = ctor.getGenericParameterTypes()[0];
        if (!(parameter instanceof java.lang.reflect.ParameterizedType))
            throw new AssertionError("Constructor parameter must be IEnumerable_1<T>, got " + parameter);

        java.lang.reflect.ParameterizedType parameterized = (java.lang.reflect.ParameterizedType) parameter;
        if (parameterized.getRawType() != IEnumerable_1.class)
            throw new AssertionError("Constructor parameter must be an IEnumerable_1, got " + parameterized.getRawType());

        java.lang.reflect.Type argument = parameterized.getActualTypeArguments()[0];
        if (!(argument instanceof java.lang.reflect.TypeVariable)
                || ((java.lang.reflect.TypeVariable<?>) argument).getGenericDeclaration() != List_1.class)
            throw new AssertionError("The type argument must be the type parameter of List_1, got " + argument);

        // the other constructors are untouched
        List_1.class.getConstructor();
        List_1.class.getConstructor(int.class);
    }
}
