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
object GenericInheritedInterfaceMethodsAreConsistent {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericInheritedInterfaceMethodsAreConsistent()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * A method inherited from a generic base interface must be declared the same way by the interface that
     * declares it and by the "...Implementation" class of a derived interface, otherwise Java sees a name
     * clash (same erasure, neither overrides the other) as soon as another parameter is a type variable.
     * ITargetBlock<TInput>.OfferMessage(header, TInput, ISourceBlock<TInput>, bool) is the case: its third
     * parameter must be ISourceBlock_1<TInput> both in ITargetBlock_1 and in IPropagatorBlock_2Implementation.
     */
    @Throws(Throwable::class)
    fun testGenericInheritedInterfaceMethodsAreConsistent() {
        val cl = GenericInheritedInterfaceMethodsAreConsistent::class.java.getClassLoader()
        val target = try {
            Class.forName("system.threading.tasks.dataflow.ITargetBlock_1", false, cl)
        } catch (notAvailable: ClassNotFoundException) {
            null
        }
        val implementation = try {
            Class.forName("system.threading.tasks.dataflow.IPropagatorBlock_2Implementation", false, cl)
        } catch (notAvailable: ClassNotFoundException) {
            null
        }
        if (target == null || implementation == null) {
            Console.WriteLine("Dataflow types not available in this framework, skipping")
            return
        }
        assertOfferMessageIsParameterized(target)
        assertOfferMessageIsParameterized(implementation)
    }

    private fun assertOfferMessageIsParameterized(c: Class<*>) {
        var found = false
        for (m in c.methods) {
            if (m.name != "OfferMessage") continue
            found = true
            val source = m.genericParameterTypes[2]
            if (source !is java.lang.reflect.ParameterizedType)
                throw AssertionError("${c.simpleName}.OfferMessage must take ISourceBlock_1<TInput>, got $source")
        }
        if (!found) throw AssertionError("${c.simpleName} has no OfferMessage method")
    }
}
