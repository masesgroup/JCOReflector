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
public class GenericConstructedEventHandlerTypeIsResolved {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericConstructedEventHandlerTypeIsResolved();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises an event whose handler is a constructed generic delegate over a class-level type
     * parameter: Progress<T>.ProgressChanged is an EventHandler<T>. Such events used to be dropped
     * altogether (only non-generic delegate types were accepted); now addProgressChanged and
     * removeProgressChanged are generated and take an EventHandler_1<T>.
     */
    static void testGenericConstructedEventHandlerTypeIsResolved() throws Throwable {
        assertParameterized(Progress_1.class.getMethod("addProgressChanged", EventHandler_1.class).getGenericParameterTypes()[0],
                EventHandler_1.class, Progress_1.class, "T");
        assertParameterized(Progress_1.class.getMethod("removeProgressChanged", EventHandler_1.class).getGenericParameterTypes()[0],
                EventHandler_1.class, Progress_1.class, "T");
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
