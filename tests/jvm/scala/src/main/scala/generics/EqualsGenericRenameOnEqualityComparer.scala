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

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented. They are written as plain static methods on purpose,
 * so they can be dropped into whatever test harness the project actually uses (JUnit, plain
 * {@code main}, or something else) without depending on a particular framework.
 * <p>
 */
object EqualsGenericRenameOnEqualityComparer {
  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testEqualsGenericRenameOnEqualityComparer()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises the EqualsGeneric() rename: a class-level Equals(T[,T]) that would otherwise
   * erase to the same signature as NetObject.Equals(IJCOBridgeReflected[,IJCOBridgeReflected])
   * is exposed under a different name so both remain callable.
   */
  @throws[Exception]
  private[generics] def testEqualsGenericRenameOnEqualityComparer(): Unit = {
    val cl = getClass.getClassLoader
    val comparer = Class.forName("system.collections.generic.IEqualityComparer_1", false, cl)
    comparer.getMethod("EqualsGeneric", classOf[IJCOBridgeReflected], classOf[IJCOBridgeReflected])
    assertMissing(comparer, "Equals", classOf[IJCOBridgeReflected], classOf[IJCOBridgeReflected])
    val equatable = Class.forName("system.IEquatable_1", false, cl)
    equatable.getMethod("EqualsGeneric", classOf[IJCOBridgeReflected])
    assertMissing(equatable, "Equals", classOf[IJCOBridgeReflected])
  }

  private[generics] def assertMissing(c: Class[_], name: String, params: Class[_]*): Unit = {
    try {
      c.getMethod(name, params: _*)
      throw new AssertionError(c.getSimpleName + "." + name + " should have been renamed")
    } catch {
      case expected: NoSuchMethodException =>

    }
  }
}
