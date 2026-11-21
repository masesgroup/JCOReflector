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
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 */
object GenericConstructedReturnTypeIsResolved {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericConstructedReturnTypeIsResolved()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises a method whose return type is a constructed generic over a class-level type
     * parameter: List<T>.AsReadOnly() returns ReadOnlyCollection<T> and List<T>.GetRange(...)
     * returns List<T>. They must be declared as ReadOnlyCollection_1<T> / List_1<T>, not as the raw
     * classes, while the returned instance is still wrapped correctly.
     */
    @Throws(Throwable::class)
    fun testGenericConstructedReturnTypeIsResolved() {
        assertParameterized(List_1::class.java.getMethod("AsReadOnly").genericReturnType,
            ReadOnlyCollection_1::class.java, List_1::class.java, "T")
        assertParameterized(List_1::class.java.getMethod("GetRange", java.lang.Integer.TYPE, java.lang.Integer.TYPE).genericReturnType,
            List_1::class.java, List_1::class.java, "T")

        // the typed results are usable end to end
        val list = object : List_1<system.Object>() {}
        list.Add(system.Object())
        list.Add(system.Object())

        val readOnly: ReadOnlyCollection_1<system.Object> = list.AsReadOnly()
        if (readOnly.getCount() != 2) throw AssertionError("Expected 2 elements in the read-only view")

        val range: List_1<system.Object> = list.GetRange(0, 1)
        if (range.getCount() != 1) throw AssertionError("Expected 1 element in the range")
    }

    private fun assertParameterized(type: java.lang.reflect.Type, raw: Class<*>, declaring: Class<*>, variableName: kotlin.String) {
        if (type !is java.lang.reflect.ParameterizedType)
            throw AssertionError("Expected ${raw.simpleName}<$variableName>, got $type")
        if (type.rawType != raw)
            throw AssertionError("Expected raw type ${raw.simpleName}, got ${type.rawType}")
        val argument = type.actualTypeArguments[0]
        if (argument !is java.lang.reflect.TypeVariable<*> || argument.genericDeclaration != declaring || argument.name != variableName)
            throw AssertionError("Expected type variable $variableName of ${declaring.simpleName}, got $argument")
    }
}
