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
import system.reflection.*;
import system.threading.tasks.*;

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented. They are written as plain static methods on purpose,
 * so they can be dropped into whatever test harness the project actually uses (JUnit, plain
 * {@code main}, or something else) without depending on a particular framework.
 * <p>
 */
public class GenericClosedTypeArgumentsAreResolved {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericClosedTypeArgumentsAreResolved();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises fully closed generic types in member signatures, whose type arguments are reflected
     * classes: Task.WhenAll(IEnumerable<Task>) as a parameter, Assembly.DefinedTypes
     * (IEnumerable<TypeInfo>) as a property and Assembly.GetCustomAttributesData()
     * (IList<CustomAttributeData>) as a return type. They used to be declared with the raw type.
     * Arguments that are not reflected classes (string, int...) keep the raw type, as before.
     */
    static void testGenericClosedTypeArgumentsAreResolved() throws Throwable {
        assertClosed(Task.class.getMethod("WhenAll", IEnumerable_1.class).getGenericParameterTypes()[0],
                IEnumerable_1.class, Task.class);
        assertClosed(Assembly.class.getMethod("getDefinedTypes").getGenericReturnType(),
                IEnumerable_1.class, TypeInfo.class);
        assertClosed(Assembly.class.getMethod("GetCustomAttributesData").getGenericReturnType(),
                IList_1.class, CustomAttributeData.class);

        // a typed property is usable end to end
        Assembly assembly = Assembly.GetExecutingAssembly();
        IEnumerable_1<TypeInfo> types = assembly.getDefinedTypes();
        if (types == null) throw new AssertionError("Expected a non-null collection of defined types");
    }

    static void assertClosed(java.lang.reflect.Type type, Class<?> raw, Class<?> argument) {
        if (!(type instanceof java.lang.reflect.ParameterizedType))
            throw new AssertionError("Expected " + raw.getSimpleName() + "<" + argument.getSimpleName() + ">, got " + type);
        java.lang.reflect.ParameterizedType parameterized = (java.lang.reflect.ParameterizedType) type;
        if (parameterized.getRawType() != raw)
            throw new AssertionError("Expected raw type " + raw.getSimpleName() + ", got " + parameterized.getRawType());
        if (parameterized.getActualTypeArguments()[0] != argument)
            throw new AssertionError("Expected type argument " + argument.getSimpleName() + ", got " + parameterized.getActualTypeArguments()[0]);
    }
}
