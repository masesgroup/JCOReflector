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

import org.mases.jcobridge.netreflection.*
import system.*
import kotlin.system.exitProcess

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 *
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 */
object GenericAlternateEqualityComparerIsReflected {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericAlternateEqualityComparerIsReflected()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * IAlternateEqualityComparer<TAlternate,T> (.NET 9+) was kept out of the reflected types. Its
     * Equals(TAlternate, T) takes two different type parameters and erases to the same signature as
     * NetObject.Equals(IJCOBridgeReflected, IJCOBridgeReflected): like Equals(T, T) of IEqualityComparer<T>,
     * it is exposed as EqualsGeneric so that both remain callable.
     */
    @Throws(Throwable::class)
    fun testGenericAlternateEqualityComparerIsReflected() {
        val comparer = try {
            Class.forName("system.collections.generic.IAlternateEqualityComparer_2", false, GenericAlternateEqualityComparerIsReflected::class.java.getClassLoader())
        } catch (notAvailable: ClassNotFoundException) {
            null
        }
        if (comparer == null) {
            Console.WriteLine("IAlternateEqualityComparer_2 not available in this framework (.NET 9+), skipping")
            return
        }

        if (comparer.typeParameters.size != 2)
            throw AssertionError("IAlternateEqualityComparer_2 must have two type parameters")

        val reflected = IJCOBridgeReflected::class.java
        comparer.getMethod("EqualsGeneric", reflected, reflected)
        assertMissing(comparer, "Equals", reflected, reflected)
        comparer.getMethod("Create", reflected)
        comparer.getMethod("GetHashCode", reflected)
    }

    private fun assertMissing(c: Class<*>, name: kotlin.String, vararg params: Class<*>) {
        try {
            c.getMethod(name, *params)
            throw AssertionError("${c.simpleName}.$name should have been renamed")
        } catch (expected: NoSuchMethodException) {
        }
    }
}
