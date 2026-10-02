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

import org.mases.jcobridge.*;
import system.*;
import system.collections.generic.*;
import system.collections.objectmodel.*;

/**
 * Smoke test for JCOReflector's experimental generics support.
 * <p>
 * Exercises a generic delegate with a primitive (non-generic-parameter) return type —
 * Comparison<T> returns int — passed as a synchronous, value-returning callback to a
 * generic method (List<T>.Sort). Both List_1 and Comparison_1 are constructed with the
 * anonymous-subclass idiom ({@code new X<T>() {}}); the generated Comparison_1 class
 * resolves its own closed CLR delegate type lazily via NetGenericHelper, so no manual
 * type-name bookkeeping is needed here.
 */
public class GenericComparisonDelegateSortsAList {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericComparisonDelegateSortsAList();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    static void testGenericComparisonDelegateSortsAList() throws Throwable {
        List_1<system.Object> list = new List_1<system.Object>() {};
        list.Add(new system.Object());
        list.Add(new system.Object());

        final java.util.concurrent.atomic.AtomicInteger calls = new java.util.concurrent.atomic.AtomicInteger();

        Comparison_1<system.Object> comparison = new Comparison_1<system.Object>() {
            @Override
            public int Invoke(system.Object x, system.Object y) {
                calls.incrementAndGet();
                return 0;
            }
        };
        list.Sort(comparison);

        if (calls.get() == 0) throw new AssertionError("Java comparison never invoked");
    }
}
