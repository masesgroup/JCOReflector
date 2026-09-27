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
 * NOT YET WIRED INTO THE REAL TEST SUITE — this is a starting point to discuss and adapt
 * once the real test project structure/conventions are confirmed.
 */
public class GenericDictionaryWithTwoTypeArguments {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericDictionaryWithTwoTypeArguments();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Exercises a class with TWO class-level type parameters (Dictionary<TKey,TValue>) —
     * both type arguments must be reflected types (IJCOBridgeReflected bound), so this also
     * documents that a Dictionary keyed by a native type (e.g. String) is only usable in its
     * raw, unparameterized form (see the "Bound limitations" section of the generics article).
     */
    static void testGenericDictionaryWithTwoTypeArguments() throws Throwable {
        Dictionary_2<system.Object, system.Object> dict = new Dictionary_2<system.Object, system.Object>() {
            @Override
            public void Add(system.Object key, system.Object value) throws Throwable {
                super.Add(key, value);
            }
            @Override
            public boolean ContainsKey(system.Object key) throws Throwable {
                return super.ContainsKey(key);
            }
        };
        system.Object key = new system.Object();
        system.Object value = new system.Object();
        dict.Add(key, value);
        if (dict.getCount() != 1) throw new AssertionError("Expected 1 entry after Add");
    }
}
