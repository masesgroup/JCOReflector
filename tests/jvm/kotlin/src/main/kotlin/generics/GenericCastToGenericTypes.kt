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
import kotlin.system.exitProcess

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 *
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 */
object GenericCastToGenericTypes {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericCastToGenericTypes()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises the cast of a reflected generic instance. The wrapper of a generic type reports the open
     * generic definition as its type, so a cast to a generic interface (ToIDictionary_2) used to be refused with
     * an UnsupportedOperationException even when the instance implements it. The cast is now accepted when the
     * runtime type of the instance, one of its base types or one of its interfaces is built from the target
     * definition, and it is still refused for an instance that is not.
     */
    @Throws(Throwable::class)
    fun testGenericCastToGenericTypes() {
        val dict = object : Dictionary_2<system.Object, system.Object>() {}
        val key = system.Object()
        dict.Add(key, system.Object())

        // a generic interface the instance implements
        @Suppress("UNCHECKED_CAST")
        val asInterface = IDictionary_2.ToIDictionary_2(dict) as IDictionary_2<system.Object, system.Object>?
        if (asInterface == null) throw AssertionError("The cast to IDictionary_2 must return an instance")
        if (!asInterface.ContainsKey(key)) throw AssertionError("The casted instance must see the added key")

        // the generic class itself
        if (Dictionary_2.cast(dict) == null) throw AssertionError("The cast to Dictionary_2 must return an instance")

        // an instance that does not implement the interface is still refused, and the message names the target
        val list = object : List_1<system.Object>() {}
        try {
            IDictionary_2.ToIDictionary_2(list)
            throw AssertionError("A List_1 must not be castable to IDictionary_2")
        } catch (expected: UnsupportedOperationException) {
            val message = expected.message
            if (message == null || !message.contains("IDictionary"))
                throw AssertionError("The message must name the target type, got: $message")
        }
    }
}
