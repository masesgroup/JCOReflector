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
import system.collections.generic.{IEnumerable_1, List_1}

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericConstructedParameterTypeInConstructor {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericConstructedParameterTypeInConstructor()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises a constructor parameter that is a constructed generic type over a class-level
   * type parameter: List<T>(IEnumerable<T>). The parameter must be exposed as IEnumerable_1<T>,
   * not as the raw IEnumerable_1, the same rule applied to method parameters.
   */
  @throws[Throwable]
  private[generics] def testGenericConstructedParameterTypeInConstructor(): Unit = {
    classOf[List_1[_ <: R]].getConstructor(classOf[IEnumerable_1[_ <: R]]).getGenericParameterTypes()(0) match {
      case parameterized: java.lang.reflect.ParameterizedType =>
        if (parameterized.getRawType ne classOf[IEnumerable_1[_ <: R]])
          throw new AssertionError("Constructor parameter must be an IEnumerable_1, got " + parameterized.getRawType)
        parameterized.getActualTypeArguments()(0) match {
          case variable: java.lang.reflect.TypeVariable[_] =>
            if (variable.getGenericDeclaration ne classOf[List_1[_ <: R]])
              throw new AssertionError("The type argument must be the type parameter of List_1, got " + variable)
          case other =>
            throw new AssertionError("The type argument must be a type variable, got " + other)
        }
      case other =>
        throw new AssertionError("Constructor parameter must be IEnumerable_1<T>, got " + other)
    }

    // the other constructors are untouched
    classOf[List_1[_ <: R]].getConstructor()
    classOf[List_1[_ <: R]].getConstructor(java.lang.Integer.TYPE)
  }
}
