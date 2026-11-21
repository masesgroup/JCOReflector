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
import system.reflection.*
import system.threading.tasks.*
import kotlin.system.exitProcess

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 *
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 */
object GenericClosedTypeArgumentsAreResolved {
    @Throws(Throwable::class)
    @JvmStatic
    fun main(args: Array<kotlin.String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            testGenericClosedTypeArgumentsAreResolved()
            Console.WriteLine("Exiting with success")
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            exitProcess(-1)
        }
    }

    /**
     * Exercises fully closed generic types in member signatures, whose type arguments are reflected
     * classes: Task.WhenAll(IEnumerable<Task>) as a parameter, Assembly.DefinedTypes
     * (IEnumerable<TypeInfo>) as a property and Assembly.GetCustomAttributesData()
     * (IList<CustomAttributeData>) as a return type. They used to be declared with the raw type.
     * Arguments that are not reflected classes (string, int...) keep the raw type, as before.
     */
    @Throws(Throwable::class)
    fun testGenericClosedTypeArgumentsAreResolved() {
        assertClosed(Task::class.java.getMethod("WhenAll", IEnumerable_1::class.java).genericParameterTypes[0],
            IEnumerable_1::class.java, Task::class.java)
        assertClosed(Assembly::class.java.getMethod("getDefinedTypes").genericReturnType,
            IEnumerable_1::class.java, TypeInfo::class.java)
        assertClosed(Assembly::class.java.getMethod("GetCustomAttributesData").genericReturnType,
            IList_1::class.java, CustomAttributeData::class.java)

        // a typed property is usable end to end
        val assembly = Assembly.GetExecutingAssembly()
        val types: IEnumerable_1<TypeInfo>? = assembly.getDefinedTypes()
        if (types == null) throw AssertionError("Expected a non-null collection of defined types")
    }

    private fun assertClosed(type: java.lang.reflect.Type, raw: Class<*>, argument: Class<*>) {
        if (type !is java.lang.reflect.ParameterizedType)
            throw AssertionError("Expected ${raw.simpleName}<${argument.simpleName}>, got $type")
        if (type.rawType != raw)
            throw AssertionError("Expected raw type ${raw.simpleName}, got ${type.rawType}")
        if (type.actualTypeArguments[0] != argument)
            throw AssertionError("Expected type argument ${argument.simpleName}, got ${type.actualTypeArguments[0]}")
    }
}
