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
object GenericConstructedParameterTypeIsResolved {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericConstructedParameterTypeIsResolved()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises a method parameter that is itself a constructed generic type over a class-level
     * type parameter: List<T>.ForEach(Action<T>). The parameter must be exposed as Action_1<T>,
     * not as the raw Action_1, otherwise the type argument is lost.
     */
    @Throws(Throwable::class)
    fun testGenericConstructedParameterTypeIsResolved() {
        // the signature carries the type argument...
        val forEach = List_1::class.java.getMethod("ForEach", Action_1::class.java)
        val parameter = forEach.genericParameterTypes[0]
        if (parameter !is java.lang.reflect.ParameterizedType)
            throw AssertionError("ForEach parameter must be Action_1<T>, got $parameter")
        if (parameter.rawType != Action_1::class.java)
            throw AssertionError("ForEach parameter must be an Action_1, got ${parameter.rawType}")
        val argument = parameter.actualTypeArguments[0]
        if (argument !is java.lang.reflect.TypeVariable<*> || argument.genericDeclaration != List_1::class.java)
            throw AssertionError("The type argument must be the type parameter of List_1, got $argument")

        // ...and the call still works end to end
        val list = object : List_1<system.Object>() {}
        list.Add(system.Object())
        list.Add(system.Object())

        val calls = java.util.concurrent.atomic.AtomicInteger()
        val action = object : Action_1<system.Object>() {
            override fun Invoke(obj: system.Object) {
                calls.incrementAndGet()
            }
        }
        list.ForEach(action)

        if (calls.get() != 2) throw AssertionError("Java action must be invoked once per element, got ${calls.get()}")
    }
}
