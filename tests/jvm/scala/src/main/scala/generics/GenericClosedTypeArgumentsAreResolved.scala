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

import org.mases.jcobridge.netreflection._
import system.Console
import system.Environment
import system.collections.generic.{IEnumerable_1, IList_1}
import system.reflection.{Assembly, CustomAttributeData, TypeInfo}
import system.threading.tasks.Task

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericClosedTypeArgumentsAreResolved {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericClosedTypeArgumentsAreResolved()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises fully closed generic types in member signatures, whose type arguments are reflected
   * classes: Task.WhenAll(IEnumerable<Task>) as a parameter, Assembly.DefinedTypes
   * (IEnumerable<TypeInfo>) as a property and Assembly.GetCustomAttributesData()
   * (IList<CustomAttributeData>) as a return type. They used to be declared with the raw type.
   * Arguments that are not reflected classes (string, int...) keep the raw type, as before.
   */
  @throws[Throwable]
  private[generics] def testGenericClosedTypeArgumentsAreResolved(): Unit = {
    assertClosed(classOf[Task].getMethod("WhenAll", classOf[IEnumerable_1[_ <: R]]).getGenericParameterTypes()(0),
      classOf[IEnumerable_1[_ <: R]], classOf[Task])
    assertClosed(classOf[Assembly].getMethod("getDefinedTypes").getGenericReturnType,
      classOf[IEnumerable_1[_ <: R]], classOf[TypeInfo])
    assertClosed(classOf[Assembly].getMethod("GetCustomAttributesData").getGenericReturnType,
      classOf[IList_1[_ <: R]], classOf[CustomAttributeData])

    // a typed property is usable end to end
    val assembly = Assembly.GetExecutingAssembly()
    val types: IEnumerable_1[TypeInfo] = assembly.getDefinedTypes()
    if (types == null) throw new AssertionError("Expected a non-null collection of defined types")
  }

  private def assertClosed(tpe: java.lang.reflect.Type, raw: Class[_], argument: Class[_]): Unit = tpe match {
    case p: java.lang.reflect.ParameterizedType =>
      if (p.getRawType ne raw)
        throw new AssertionError("Expected raw type " + raw.getSimpleName + ", got " + p.getRawType)
      if (p.getActualTypeArguments()(0) ne argument)
        throw new AssertionError("Expected type argument " + argument.getSimpleName + ", got " + p.getActualTypeArguments()(0))
    case other =>
      throw new AssertionError("Expected " + raw.getSimpleName + "<" + argument.getSimpleName + ">, got " + other)
  }
}
