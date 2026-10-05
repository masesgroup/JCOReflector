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
 * Smoke tests for JCOReflector's experimental generics support.
 * <p>
 * {@link #testGenericComparisonDelegateSortsAList()} exercises a generic delegate with a
 * primitive (non-generic-parameter) return type — Comparison<T> returns int — passed as a
 * synchronous, value-returning callback to a generic method (List<T>.Sort). Both List_1 and
 * Comparison_1 are constructed with the anonymous-subclass idiom ({@code new X<T>() {}});
 * the generated Comparison_1 class resolves its own closed CLR delegate type lazily via
 * NetGenericHelper, so no manual type-name bookkeeping is needed here.
 * <p>
 * The other tests cover native types: {@link #testNativeTypesInGenericMembers()} checks
 * native int and boolean values crossing the bridge in the members of a generic class,
 * {@link #testNativeWrapperTypesAsTypeArguments()} uses the reflected wrapper of a native
 * value type (UInt32) as a type argument, and
 * {@link #testNativeJavaTypesCannotBeTypeArguments()} checks the bound that keeps plain
 * Java types (String, int, boolean...) out of the type arguments.
 */
public class GenericComparisonDelegateSortsAList {

    public static void main(String[] args) throws Throwable {
        JCOReflector.setCommandLineArgs(args);
        try {
            testGenericComparisonDelegateSortsAList();
            testNativeTypesInGenericMembers();
            testNativeWrapperTypesAsTypeArguments();
            testNativeJavaTypesCannotBeTypeArguments();
            Console.WriteLine("Exiting with success");
            Environment.Exit(0);
        } catch (Throwable tre) {
            tre.printStackTrace();
            System.exit(-1);
        }
    }

    static void testGenericComparisonDelegateSortsAList() throws Throwable {
		Console.WriteLine("testGenericComparisonDelegateSortsAList");
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

    /**
     * Native types in the members of a generic class: an int parameter in a generic constructor
     * and in a generic method, int and boolean return values, and an int property.
     */
    static void testNativeTypesInGenericMembers() throws Throwable {
		Console.WriteLine("testNativeTypesInGenericMembers");
        // native int parameter of a generic constructor
        Dictionary_2<system.Object, system.Object> dict = new Dictionary_2<system.Object, system.Object>(16) {};

        // native int parameter and return value of a generic method
        if (dict.EnsureCapacity(16) < 16) throw new AssertionError("EnsureCapacity returned a capacity lower than requested");

        system.Object key = new system.Object();
        system.Object value = new system.Object();

        // native boolean return values of generic methods
        if (!dict.TryAdd(key, value)) throw new AssertionError("TryAdd of a new key must return true");
        if (dict.TryAdd(key, value)) throw new AssertionError("TryAdd of an existing key must return false");
        if (!dict.ContainsKey(key)) throw new AssertionError("ContainsKey must find the added key");
        if (!dict.ContainsValue(value)) throw new AssertionError("ContainsValue must find the added value");

        // native int return value of a generic property
        if (dict.getCount() != 1) throw new AssertionError("Count must be 1 after one TryAdd");

        if (!dict.Remove(key)) throw new AssertionError("Remove of an existing key must return true");
        if (dict.getCount() != 0) throw new AssertionError("Count must be 0 after Remove");
    }

    /**
     * UInt32 is the reflected wrapper of a native value type. Being a reflected class it is a
     * valid type argument, and the CLR compares the values, not the wrappers.
     */
    static void testNativeWrapperTypesAsTypeArguments() throws Throwable {
		Console.WriteLine("testNativeWrapperTypesAsTypeArguments");
        Dictionary_2<UInt32, UInt32> dict = new Dictionary_2<UInt32, UInt32>() {};
        if (!dict.TryAdd(UInt32.Parse("1"), UInt32.Parse("10"))) throw new AssertionError("TryAdd of a new key must return true");

        // a different wrapper holding the same number is the same key
        if (!dict.ContainsKey(UInt32.Parse("1"))) throw new AssertionError("ContainsKey must compare keys by value");
        if (dict.ContainsKey(UInt32.Parse("2"))) throw new AssertionError("ContainsKey must not find a missing key");
        if (dict.TryAdd(UInt32.Parse("1"), UInt32.Parse("11"))) throw new AssertionError("TryAdd of an equal key must return false");

        // out parameter of a type-argument type: the result comes back through the instance supplied
        UInt32 found = UInt32.Parse("0");
        if (!dict.TryGetValue(UInt32.Parse("1"), JCORefOut.Create(found))) throw new AssertionError("TryGetValue must find the key");
        if (found.CompareTo(UInt32.Parse("10")) != 0) throw new AssertionError("TryGetValue must return the stored value in the out parameter");

        // generic delegate whose arguments are value-type wrappers
        List_1<UInt32> list = new List_1<UInt32>() {};
        list.Add(UInt32.Parse("3"));
        list.Add(UInt32.Parse("1"));
        list.Add(UInt32.Parse("2"));

        final java.util.concurrent.atomic.AtomicInteger calls = new java.util.concurrent.atomic.AtomicInteger();

        Comparison_1<UInt32> comparison = new Comparison_1<UInt32>() {
            @Override
            public int Invoke(UInt32 x, UInt32 y) {
                calls.incrementAndGet();
                try {
                    return x.CompareTo(y);
                } catch (Throwable t) {
                    throw new java.lang.RuntimeException(t);
                }
            }
        };
        list.Sort(comparison);

        if (calls.get() == 0) throw new AssertionError("Java comparison never invoked");
        if (list.IndexOf(UInt32.Parse("1")) != 0) throw new AssertionError("1 must be the first element after Sort");
        if (list.IndexOf(UInt32.Parse("3")) != 2) throw new AssertionError("3 must be the last element after Sort");
    }

    /**
     * Plain Java types (String, int, boolean...) are not reflected classes, so they cannot fill a
     * type parameter: every type parameter is bounded by IJCOBridgeReflected, which none of them
     * implements. Using one is a compile-time error, so the check is made on the bound itself.
     */
    static void testNativeJavaTypesCannotBeTypeArguments() throws Throwable {
		Console.WriteLine("testNativeJavaTypesCannotBeTypeArguments");
        java.lang.reflect.Type[] bounds = List_1.class.getTypeParameters()[0].getBounds();
        if (bounds.length != 1 || bounds[0] != IJCOBridgeReflected.class)
            throw new AssertionError("The type parameter of List_1 must be bounded by IJCOBridgeReflected");

        if (IJCOBridgeReflected.class.isAssignableFrom(java.lang.String.class)
                || IJCOBridgeReflected.class.isAssignableFrom(java.lang.Integer.class)
                || IJCOBridgeReflected.class.isAssignableFrom(java.lang.Boolean.class))
            throw new AssertionError("Plain Java types must not satisfy the IJCOBridgeReflected bound");
    }
}
