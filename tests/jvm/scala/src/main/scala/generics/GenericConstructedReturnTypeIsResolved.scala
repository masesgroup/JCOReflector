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
import system.collections.generic.List_1
import system.collections.objectmodel.ReadOnlyCollection_1

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericConstructedReturnTypeIsResolved {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericConstructedReturnTypeIsResolved()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises a method whose return type is a constructed generic over a class-level type
   * parameter: List<T>.AsReadOnly() returns ReadOnlyCollection<T> and List<T>.GetRange(...)
   * returns List<T>. They must be declared as ReadOnlyCollection_1<T> / List_1<T>, not as the raw
   * classes, while the returned instance is still wrapped correctly.
   */
  @throws[Throwable]
  private[generics] def testGenericConstructedReturnTypeIsResolved(): Unit = {
    assertParameterized(classOf[List_1[_ <: R]].getMethod("AsReadOnly").getGenericReturnType,
      classOf[ReadOnlyCollection_1[_ <: R]], classOf[List_1[_ <: R]], "T")
    assertParameterized(classOf[List_1[_ <: R]].getMethod("GetRange", java.lang.Integer.TYPE, java.lang.Integer.TYPE).getGenericReturnType,
      classOf[List_1[_ <: R]], classOf[List_1[_ <: R]], "T")

    // the typed results are usable end to end
    val list = new List_1[system.Object]() {}
    list.Add(new system.Object())
    list.Add(new system.Object())

    val readOnly: ReadOnlyCollection_1[system.Object] = list.AsReadOnly()
    if (readOnly.getCount() != 2) throw new AssertionError("Expected 2 elements in the read-only view")

    val range: List_1[system.Object] = list.GetRange(0, 1)
    if (range.getCount() != 1) throw new AssertionError("Expected 1 element in the range")
  }

  private def assertParameterized(tpe: java.lang.reflect.Type, raw: Class[_], declaring: Class[_], variableName: String): Unit = tpe match {
    case p: java.lang.reflect.ParameterizedType =>
      if (p.getRawType ne raw)
        throw new AssertionError("Expected raw type " + raw.getSimpleName + ", got " + p.getRawType)
      p.getActualTypeArguments()(0) match {
        case v: java.lang.reflect.TypeVariable[_] =>
          if ((v.getGenericDeclaration ne declaring) || v.getName != variableName)
            throw new AssertionError("Expected type variable " + variableName + " of " + declaring.getSimpleName + ", got " + v)
        case other =>
          throw new AssertionError("Expected type variable " + variableName + ", got " + other)
      }
    case other =>
      throw new AssertionError("Expected " + raw.getSimpleName + "<" + variableName + ">, got " + other)
  }
}
