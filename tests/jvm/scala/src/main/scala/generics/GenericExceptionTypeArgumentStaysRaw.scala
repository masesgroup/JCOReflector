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
import system.collections.generic.IEnumerable_1
import system.threading.tasks.TaskCompletionSource_1

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericExceptionTypeArgumentStaysRaw {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericExceptionTypeArgumentStaysRaw()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exceptions are generated as Java Throwables, they are not IJCOBridgeReflected and there is no
   * system.Exception class: they can never be a type argument. TaskCompletionSource<TResult>.SetException
   * takes an IEnumerable<Exception>, which must therefore keep the raw IEnumerable_1.
   */
  @throws[Throwable]
  private[generics] def testGenericExceptionTypeArgumentStaysRaw(): Unit = {
    val parameter = classOf[TaskCompletionSource_1[_ <: R]].getMethod("SetException", classOf[IEnumerable_1[_ <: R]]).getGenericParameterTypes()(0)
    if (parameter ne classOf[IEnumerable_1[_ <: R]])
      throw new AssertionError("IEnumerable<Exception> must stay the raw IEnumerable_1, got " + parameter)
  }
}
