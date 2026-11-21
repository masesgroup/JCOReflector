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
import system.runtime.exceptionservices.*
import kotlin.system.exitProcess

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 *
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 */
object GenericClosedEventHandlerTypeIsResolved {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericClosedEventHandlerTypeIsResolved()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises an event whose handler is a fully closed generic delegate:
     * AppDomain.FirstChanceException is an EventHandler<FirstChanceExceptionEventArgs>. Such events used
     * to be dropped altogether. The registration must take an EventHandler_1<FirstChanceExceptionEventArgs>
     * and the Java handler must really be invoked by the CLR: a failing Int32.Parse raises a first-chance
     * exception on the .NET side.
     */
    @Throws(Throwable::class)
    fun testGenericClosedEventHandlerTypeIsResolved() {
        // the signature carries the closed type argument...
        val parameter = AppDomain::class.java.getMethod("addFirstChanceException", EventHandler_1::class.java).genericParameterTypes[0]
        if (parameter !is java.lang.reflect.ParameterizedType)
            throw AssertionError("Expected EventHandler_1<FirstChanceExceptionEventArgs>, got $parameter")
        if (parameter.rawType != EventHandler_1::class.java)
            throw AssertionError("Expected an EventHandler_1, got ${parameter.rawType}")
        if (parameter.actualTypeArguments[0] != FirstChanceExceptionEventArgs::class.java)
            throw AssertionError("Expected FirstChanceExceptionEventArgs, got ${parameter.actualTypeArguments[0]}")

        // ...and the handler is really called back by the runtime
        val calls = java.util.concurrent.atomic.AtomicInteger()

        val handler = object : EventHandler_1<FirstChanceExceptionEventArgs>() {
            override fun Invoke(sender: NetObject?, e: FirstChanceExceptionEventArgs?) {
                // keep it minimal: this handler runs for every first-chance exception of the process,
                // and it must not raise one itself or it would re-enter
                try {
                    calls.incrementAndGet()
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        }

        val domain = AppDomain.getCurrentDomain()
        domain.addFirstChanceException(handler)
        try {
            try {
                system.Int32.Parse("not a number")
            } catch (expected: system.FormatException) {
            }
        } finally {
            domain.removeFirstChanceException(handler)
        }

        if (calls.get() == 0) throw AssertionError("The Java handler was never invoked")
    }
}
