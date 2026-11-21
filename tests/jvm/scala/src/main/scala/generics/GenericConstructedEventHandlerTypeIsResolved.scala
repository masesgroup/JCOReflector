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
import system.{EventHandler_1, Progress_1}

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericConstructedEventHandlerTypeIsResolved {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericConstructedEventHandlerTypeIsResolved()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises an event whose handler is a constructed generic delegate over a class-level type
   * parameter: Progress<T>.ProgressChanged is an EventHandler<T>. Such events used to be dropped
   * altogether (only non-generic delegate types were accepted); now addProgressChanged and
   * removeProgressChanged are generated and take an EventHandler_1<T>.
   */
  @throws[Throwable]
  private[generics] def testGenericConstructedEventHandlerTypeIsResolved(): Unit = {
    assertParameterized(classOf[Progress_1[_ <: R]].getMethod("addProgressChanged", classOf[EventHandler_1[_ <: R]]).getGenericParameterTypes()(0),
      classOf[EventHandler_1[_ <: R]], classOf[Progress_1[_ <: R]], "T")
    assertParameterized(classOf[Progress_1[_ <: R]].getMethod("removeProgressChanged", classOf[EventHandler_1[_ <: R]]).getGenericParameterTypes()(0),
      classOf[EventHandler_1[_ <: R]], classOf[Progress_1[_ <: R]], "T")
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
