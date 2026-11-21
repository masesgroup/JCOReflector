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
public class GenericInheritedInterfaceMethodsAreConsistent {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericInheritedInterfaceMethodsAreConsistent();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * A method inherited from a generic base interface must be declared the same way by the interface that
     * declares it and by the "...Implementation" class of a derived interface, otherwise Java sees a name
     * clash (same erasure, neither overrides the other) as soon as another parameter is a type variable.
     * ITargetBlock<TInput>.OfferMessage(header, TInput, ISourceBlock<TInput>, bool) is the case: its third
     * parameter must be ISourceBlock_1<TInput> both in ITargetBlock_1 and in IPropagatorBlock_2Implementation.
     */
    static void testGenericInheritedInterfaceMethodsAreConsistent() throws Throwable {
        ClassLoader cl = GenericInheritedInterfaceMethodsAreConsistent.class.getClassLoader();
        Class<?> target;
        Class<?> implementation;
        try {
            target = Class.forName("system.threading.tasks.dataflow.ITargetBlock_1", false, cl);
            implementation = Class.forName("system.threading.tasks.dataflow.IPropagatorBlock_2Implementation", false, cl);
        } catch (ClassNotFoundException notAvailable) {
            Console.WriteLine("Dataflow types not available in this framework, skipping");
            return;
        }
        assertOfferMessageIsParameterized(target);
        assertOfferMessageIsParameterized(implementation);
    }

    static void assertOfferMessageIsParameterized(Class<?> c) {
        boolean found = false;
        for (java.lang.reflect.Method m : c.getMethods()) {
            if (!m.getName().equals("OfferMessage")) continue;
            found = true;
            java.lang.reflect.Type source = m.getGenericParameterTypes()[2];
            if (!(source instanceof java.lang.reflect.ParameterizedType))
                throw new AssertionError(c.getSimpleName() + ".OfferMessage must take ISourceBlock_1<TInput>, got " + source);
        }
        if (!found) throw new AssertionError(c.getSimpleName() + " has no OfferMessage method");
    }
}
