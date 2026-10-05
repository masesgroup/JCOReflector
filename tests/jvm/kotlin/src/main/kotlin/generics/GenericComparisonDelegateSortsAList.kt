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
package generics

import org.mases.jcobridge.*
import org.mases.jcobridge.netreflection.*
import system.*
import system.collections.generic.*
import system.collections.objectmodel.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.exitProcess

/**
 * Smoke tests for JCOReflector's experimental generics support.
 *
 * testGenericComparisonDelegateSortsAList exercises a generic delegate with a primitive
 * (non-generic-parameter) return type, Comparison<T> returns int, passed as a synchronous,
 * value-returning callback to a generic method (List<T>.Sort). Both List_1 and Comparison_1 are
 * constructed with the anonymous-object idiom (`object : X<T>() {}`); the generated Comparison_1
 * class resolves its own closed CLR delegate type lazily via NetGenericHelper, so no manual
 * type-name bookkeeping is needed here.
 *
 * The other tests cover native types: testNativeTypesInGenericMembers checks native int and
 * boolean values crossing the bridge in the members of a generic class,
 * testNativeWrapperTypesAsTypeArguments uses the reflected wrapper of a native value type (UInt32)
 * as a type argument, and testNativeJavaTypesCannotBeTypeArguments checks the bound that keeps
 * plain Java types (String, int, boolean...) out of the type arguments.
 */
object GenericComparisonDelegateSortsAList {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericComparisonDelegateSortsAList()
            testNativeTypesInGenericMembers()
            testNativeWrapperTypesAsTypeArguments()
            testNativeJavaTypesCannotBeTypeArguments()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises a generic delegate with a primitive (non-generic-parameter) return type -
     * Comparison<T> returns int, which required its own "Native" generic delegate template
     * distinct from the generic-parameter-return case.
     */
    @Throws(Throwable::class)
    fun testGenericComparisonDelegateSortsAList() {
        val list = object : List_1<system.Object>() {}
        list.Add(system.Object())
        list.Add(system.Object())

        val calls = AtomicInteger()

        val comparison = object : Comparison_1<system.Object>() {
            override fun Invoke(x: system.Object, y: system.Object): Int {
                calls.incrementAndGet()
                return 0
            }
        }
        list.Sort(comparison)

        if (calls.get() == 0) throw AssertionError("Java comparison never invoked")
    }

    /**
     * Adds the pair to the dictionary and returns false when the key is already present.
     * Dictionary.TryAdd does not exist on .NET Framework (net462), so the duplicate is detected
     * through the ArgumentException thrown by Add.
     */
    @Throws(Throwable::class)
    private fun <K : IJCOBridgeReflected, V : IJCOBridgeReflected> addIfAbsent(dict: Dictionary_2<K, V>, key: K, value: V): kotlin.Boolean {
        return try {
            dict.Add(key, value)
            true
        } catch (e: system.ArgumentException) {
            false
        }
    }

    /**
     * Native types in the members of a generic class: an int parameter in a generic constructor,
     * boolean and int return values of generic methods, and an int property.
     */
    @Throws(Throwable::class)
    fun testNativeTypesInGenericMembers() {
        // native int parameter of a generic constructor
        val dict = object : Dictionary_2<system.Object, system.Object>(16) {}

        val key = system.Object()
        val value = system.Object()

        // native boolean return values of generic methods
        if (!addIfAbsent(dict, key, value)) throw AssertionError("Add of a new key must succeed")
        if (addIfAbsent(dict, key, value)) throw AssertionError("Add of an existing key must throw ArgumentException")
        if (!dict.ContainsKey(key)) throw AssertionError("ContainsKey must find the added key")
        if (!dict.ContainsValue(value)) throw AssertionError("ContainsValue must find the added value")

        // native int return value of a generic property
        if (dict.getCount() != 1) throw AssertionError("Count must be 1 after one Add")

        if (!dict.Remove(key)) throw AssertionError("Remove of an existing key must return true")
        if (dict.getCount() != 0) throw AssertionError("Count must be 0 after Remove")
    }

    /**
     * UInt32 is the reflected wrapper of a native value type. Being a reflected class it is a
     * valid type argument, and the CLR compares the values, not the wrappers.
     */
    @Throws(Throwable::class)
    fun testNativeWrapperTypesAsTypeArguments() {
        val dict = object : Dictionary_2<UInt32, UInt32>() {}
        if (!addIfAbsent(dict, UInt32.Parse("1"), UInt32.Parse("10"))) throw AssertionError("Add of a new key must succeed")

        // a different wrapper holding the same number is the same key
        if (!dict.ContainsKey(UInt32.Parse("1"))) throw AssertionError("ContainsKey must compare keys by value")
        if (dict.ContainsKey(UInt32.Parse("2"))) throw AssertionError("ContainsKey must not find a missing key")
        if (addIfAbsent(dict, UInt32.Parse("1"), UInt32.Parse("11"))) throw AssertionError("Add of an equal key must throw ArgumentException")

        // out parameter of a type-argument type: the result comes back through the instance supplied
        val found = UInt32.Parse("0")
        if (!dict.TryGetValue(UInt32.Parse("1"), JCORefOut.Create(found))) throw AssertionError("TryGetValue must find the key")
        if (found.CompareTo(UInt32.Parse("10")) != 0) throw AssertionError("TryGetValue must return the stored value in the out parameter")

        // generic delegate whose arguments are value-type wrappers
        val list = object : List_1<UInt32>() {}
        list.Add(UInt32.Parse("3"))
        list.Add(UInt32.Parse("1"))
        list.Add(UInt32.Parse("2"))

        val calls = AtomicInteger()

        val comparison = object : Comparison_1<UInt32>() {
            override fun Invoke(x: UInt32, y: UInt32): Int {
                calls.incrementAndGet()
                return x.CompareTo(y)
            }
        }
        list.Sort(comparison)

        if (calls.get() == 0) throw AssertionError("Java comparison never invoked")
        if (list.IndexOf(UInt32.Parse("1")) != 0) throw AssertionError("1 must be the first element after Sort")
        if (list.IndexOf(UInt32.Parse("3")) != 2) throw AssertionError("3 must be the last element after Sort")
    }

    /**
     * Plain Java types (String, int, boolean...) are not reflected classes, so they cannot fill a
     * type parameter: every type parameter is bounded by IJCOBridgeReflected, which none of them
     * implements. Using one is a compile-time error, so the check is made on the bound itself.
     */
    fun testNativeJavaTypesCannotBeTypeArguments() {
        val bounds = List_1::class.java.typeParameters[0].bounds
        if (bounds.size != 1 || bounds[0] != IJCOBridgeReflected::class.java)
            throw AssertionError("The type parameter of List_1 must be bounded by IJCOBridgeReflected")

        if (IJCOBridgeReflected::class.java.isAssignableFrom(kotlin.String::class.java)
            || IJCOBridgeReflected::class.java.isAssignableFrom(Int::class.javaObjectType)
            || IJCOBridgeReflected::class.java.isAssignableFrom(kotlin.Boolean::class.javaObjectType))
            throw AssertionError("Plain Java types must not satisfy the IJCOBridgeReflected bound")
    }
}
