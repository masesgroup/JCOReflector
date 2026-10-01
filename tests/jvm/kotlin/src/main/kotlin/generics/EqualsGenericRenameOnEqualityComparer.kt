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
import system.collections.generic.*
import system.collections.objectmodel.*
import kotlin.system.exitProcess

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * 
 * 
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented. They are written as plain static methods on purpose,
 * so they can be dropped into whatever test harness the project actually uses (JUnit, plain
 * `main`, or something else) without depending on a particular framework.
 * 
 * 
 */
object EqualsGenericRenameOnEqualityComparer {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testEqualsGenericRenameOnEqualityComparer()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises the EqualsGeneric() rename: a class-level Equals(T[,T]) that would otherwise
     * erase to the same signature as NetObject.Equals(IJCOBridgeReflected[,IJCOBridgeReflected])
     * is exposed under a different name so both remain callable.
     */
    @Throws(Exception::class)
    fun testEqualsGenericRenameOnEqualityComparer() {
        val cl = EqualsGenericRenameOnEqualityComparer::class.java.classLoader
        val comparer = Class.forName("system.collections.generic.IEqualityComparer_1", false, cl)
        comparer.getMethod("EqualsGeneric", IJCOBridgeReflected::class.java, IJCOBridgeReflected::class.java)
        assertMissing(comparer, "Equals", IJCOBridgeReflected::class.java, IJCOBridgeReflected::class.java)

        val equatable = Class.forName("system.IEquatable_1", false, cl)
        equatable.getMethod("EqualsGeneric", IJCOBridgeReflected::class.java)
        assertMissing(equatable, "Equals", IJCOBridgeReflected::class.java)
    }

    private fun assertMissing(c: Class<*>, name: kotlin.String, vararg params: Class<*>) {
        try {
            c.getMethod(name, *params)
        } catch (expected: NoSuchMethodException) {
            return
        }
        throw AssertionError(c.simpleName + "." + name + " should have been renamed")
    }
}