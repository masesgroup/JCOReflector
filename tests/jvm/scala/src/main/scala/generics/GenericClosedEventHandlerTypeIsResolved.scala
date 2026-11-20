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
import system.{AppDomain, EventHandler_1}
import system.runtime.exceptionservices.FirstChanceExceptionEventArgs

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericClosedEventHandlerTypeIsResolved {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericClosedEventHandlerTypeIsResolved()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises an event whose handler is a fully closed generic delegate:
   * AppDomain.FirstChanceException is an EventHandler<FirstChanceExceptionEventArgs>. Such events used
   * to be dropped altogether. The registration must take an EventHandler_1<FirstChanceExceptionEventArgs>
   * and the Java handler must really be invoked by the CLR: a failing Int32.Parse raises a first-chance
   * exception on the .NET side.
   */
  @throws[Throwable]
  private[generics] def testGenericClosedEventHandlerTypeIsResolved(): Unit = {
    // the signature carries the closed type argument...
      classOf[AppDomain].getMethod("addFirstChanceException", classOf[EventHandler_1[_ <: R]]).getGenericParameterTypes()(0) match {
      case parameterized: java.lang.reflect.ParameterizedType =>
        if (parameterized.getRawType ne classOf[EventHandler_1[_ <: R]])
          throw new AssertionError("Expected an EventHandler_1, got " + parameterized.getRawType)
        if (parameterized.getActualTypeArguments()(0) ne classOf[FirstChanceExceptionEventArgs])
          throw new AssertionError("Expected FirstChanceExceptionEventArgs, got " + parameterized.getActualTypeArguments()(0))
      case other =>
        throw new AssertionError("Expected EventHandler_1<FirstChanceExceptionEventArgs>, got " + other)
    }

    // ...and the handler is really called back by the runtime
    val calls = new java.util.concurrent.atomic.AtomicInteger()

    val handler = new EventHandler_1[FirstChanceExceptionEventArgs]() {
      override def Invoke(sender: NetObject, e: FirstChanceExceptionEventArgs): Unit = {
        // keep it minimal: this handler runs for every first-chance exception of the process
        calls.incrementAndGet()
      }
    }

    val domain = AppDomain.getCurrentDomain()
    domain.addFirstChanceException(handler)
    try {
      try {
        system.Int32.Parse("not a number")
      } catch {
        case _: system.FormatException =>
      }
    } finally {
      domain.removeFirstChanceException(handler)
    }

    if (calls.get() == 0) throw new AssertionError("The Java handler was never invoked")
  }
}
