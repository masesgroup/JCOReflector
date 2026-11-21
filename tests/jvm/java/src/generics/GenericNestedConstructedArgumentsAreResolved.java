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
public class GenericNestedConstructedArgumentsAreResolved {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericNestedConstructedArgumentsAreResolved();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises the recursive resolution of nested type arguments: the constructor
     * ConcurrentDictionary<TKey,TValue>(IEnumerable<KeyValuePair<TKey,TValue>>) must be exposed as
     * IEnumerable_1<KeyValuePair_2<TKey,TValue>>, with both inner arguments being the type
     * parameters of the class, not the raw IEnumerable_1 and not a raw KeyValuePair_2.
     */
    static void testGenericNestedConstructedArgumentsAreResolved() throws Throwable {
        Class<?> dictionary;
        try {
            dictionary = Class.forName("system.collections.concurrent.ConcurrentDictionary_2", false,
                    GenericNestedConstructedArgumentsAreResolved.class.getClassLoader());
        } catch (ClassNotFoundException notAvailable) {
            Console.WriteLine("ConcurrentDictionary_2 not available in this framework, skipping");
            return;
        }

        java.lang.reflect.Type parameter = dictionary.getConstructor(IEnumerable_1.class).getGenericParameterTypes()[0];
        if (!(parameter instanceof java.lang.reflect.ParameterizedType))
            throw new AssertionError("Constructor parameter must be IEnumerable_1<...>, got " + parameter);

        java.lang.reflect.ParameterizedType outer = (java.lang.reflect.ParameterizedType) parameter;
        if (outer.getRawType() != IEnumerable_1.class)
            throw new AssertionError("Constructor parameter must be an IEnumerable_1, got " + outer.getRawType());

        java.lang.reflect.Type element = outer.getActualTypeArguments()[0];
        if (!(element instanceof java.lang.reflect.ParameterizedType))
            throw new AssertionError("Element type must be KeyValuePair_2<TKey,TValue>, got " + element);

        java.lang.reflect.ParameterizedType pair = (java.lang.reflect.ParameterizedType) element;
        if (pair.getRawType() != KeyValuePair_2.class)
            throw new AssertionError("Element type must be a KeyValuePair_2, got " + pair.getRawType());

        String[] expected = { "TKey", "TValue" };
        for (int i = 0; i < expected.length; i++) {
            java.lang.reflect.Type argument = pair.getActualTypeArguments()[i];
            if (!(argument instanceof java.lang.reflect.TypeVariable)
                    || ((java.lang.reflect.TypeVariable<?>) argument).getGenericDeclaration() != dictionary
                    || !((java.lang.reflect.TypeVariable<?>) argument).getName().equals(expected[i]))
                throw new AssertionError("Expected type variable " + expected[i] + " of the dictionary, got " + argument);
        }
    }
}
