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
import system.collections.concurrent.*
import system.collections.generic.*
import kotlin.system.exitProcess

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 *
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 */
object GenericConstructedPropertyTypeIsResolved {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericConstructedPropertyTypeIsResolved()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises a property whose type is a constructed generic over the type parameters in scope:
     * IDictionary<TKey,TValue>.Keys is ICollection<TKey> and .Values is ICollection<TValue>, and the
     * same holds for the public ConcurrentDictionary<TKey,TValue>.Keys/Values. They must be exposed
     * as ICollection_1<TKey> / ICollection_1<TValue>, not as the raw ICollection_1.
     */
    @Throws(Throwable::class)
    fun testGenericConstructedPropertyTypeIsResolved() {
        assertParameterized(IDictionary_2::class.java.getMethod("getKeys").genericReturnType,
            ICollection_1::class.java, IDictionary_2::class.java, "TKey")
        assertParameterized(IDictionary_2::class.java.getMethod("getValues").genericReturnType,
            ICollection_1::class.java, IDictionary_2::class.java, "TValue")

        assertParameterized(ConcurrentDictionary_2::class.java.getMethod("getKeys").genericReturnType,
            ICollection_1::class.java, ConcurrentDictionary_2::class.java, "TKey")
        assertParameterized(ConcurrentDictionary_2::class.java.getMethod("getValues").genericReturnType,
            ICollection_1::class.java, ConcurrentDictionary_2::class.java, "TValue")

        // the typed property is usable end to end
        val dict = object : ConcurrentDictionary_2<system.Object, system.Object>() {}
        if (!dict.TryAdd(system.Object(), system.Object())) throw AssertionError("TryAdd of a new key must succeed")

        val keys: ICollection_1<system.Object> = dict.getKeys()
        val values: ICollection_1<system.Object> = dict.getValues()
        if (keys.getCount() != 1) throw AssertionError("Expected 1 key")
        if (values.getCount() != 1) throw AssertionError("Expected 1 value")
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
