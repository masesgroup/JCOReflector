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
object GenericNestedConstructedArgumentsAreResolved {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericNestedConstructedArgumentsAreResolved()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises the recursive resolution of nested type arguments: the constructor
     * ConcurrentDictionary<TKey,TValue>(IEnumerable<KeyValuePair<TKey,TValue>>) must be exposed as
     * IEnumerable_1<KeyValuePair_2<TKey,TValue>>, with both inner arguments being the type
     * parameters of the class, not the raw IEnumerable_1 and not a raw KeyValuePair_2.
     */
    @Throws(Throwable::class)
    fun testGenericNestedConstructedArgumentsAreResolved() {
        val dictionary = try {
            Class.forName("system.collections.concurrent.ConcurrentDictionary_2", false, GenericNestedConstructedArgumentsAreResolved::class.java.getClassLoader())
        } catch (notAvailable: ClassNotFoundException) {
            null
        }
        if (dictionary == null) {
            Console.WriteLine("ConcurrentDictionary_2 not available in this framework, skipping")
            return
        }

        val parameter = dictionary.getConstructor(IEnumerable_1::class.java).genericParameterTypes[0]
        if (parameter !is java.lang.reflect.ParameterizedType)
            throw AssertionError("Constructor parameter must be IEnumerable_1<...>, got $parameter")
        if (parameter.rawType != IEnumerable_1::class.java)
            throw AssertionError("Constructor parameter must be an IEnumerable_1, got ${parameter.rawType}")

        val element = parameter.actualTypeArguments[0]
        if (element !is java.lang.reflect.ParameterizedType)
            throw AssertionError("Element type must be KeyValuePair_2<TKey,TValue>, got $element")
        if (element.rawType != KeyValuePair_2::class.java)
            throw AssertionError("Element type must be a KeyValuePair_2, got ${element.rawType}")

        listOf("TKey", "TValue").forEachIndexed { i, expected ->
            val argument = element.actualTypeArguments[i]
            if (argument !is java.lang.reflect.TypeVariable<*> || argument.genericDeclaration != dictionary || argument.name != expected)
                throw AssertionError("Expected type variable $expected of the dictionary, got $argument")
        }
    }
}
