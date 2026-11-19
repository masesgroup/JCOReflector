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
public class GenericConstructedPropertyTypeIsResolved {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericConstructedPropertyTypeIsResolved();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises a property whose type is a constructed generic over the interface's own type
     * parameters: IDictionary<TKey,TValue>.Keys is ICollection<TKey> and .Values is ICollection<TValue>.
     * They must be exposed as ICollection_1<TKey> / ICollection_1<TValue>, not as the raw ICollection_1.
     */
    static void testGenericConstructedPropertyTypeIsResolved() throws Throwable {
        assertParameterized(IDictionary_2.class.getMethod("getKeys").getGenericReturnType(),
                ICollection_1.class, IDictionary_2.class, "TKey");
        assertParameterized(IDictionary_2.class.getMethod("getValues").getGenericReturnType(),
                ICollection_1.class, IDictionary_2.class, "TValue");

        // the typed property is usable end to end
        Dictionary_2<system.Object, system.Object> dict = new Dictionary_2<system.Object, system.Object>() {};
        dict.Add(new system.Object(), new system.Object());

        IDictionary_2<system.Object, system.Object> idict = IDictionary_2.ToIDictionary_2(dict);
        ICollection_1<system.Object> keys = idict.getKeys();
        ICollection_1<system.Object> values = idict.getValues();
        if (keys.getCount() != 1) throw new AssertionError("Expected 1 key");
        if (values.getCount() != 1) throw new AssertionError("Expected 1 value");
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
