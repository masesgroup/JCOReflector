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
object GenericRefStructTypesAreNotExported {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericRefStructTypesAreNotExported()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Span<T> and ReadOnlySpan<T> are ref structs: they cannot be boxed, so they are excluded as whole
     * types when generics are enabled (and so is every member taking or returning one). This is why no
     * per-member avoidance, such as GetPinnableReference, is needed for them.
     */
    fun testGenericRefStructTypesAreNotExported() {
        val cl = GenericRefStructTypesAreNotExported::class.java.getClassLoader()
        for (name in arrayOf("system.Span_1", "system.ReadOnlySpan_1")) {
            var exported = true
            try {
                Class.forName(name, false, cl)
            } catch (expected: ClassNotFoundException) {
                exported = false
            }
            if (exported) throw AssertionError("$name is a ref struct and must not be exported")
        }
    }
}
