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
 * while this feature was implemented.
 * <p>
 */
object GenericAlternateEqualityComparerIsReflected {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericAlternateEqualityComparerIsReflected()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * IAlternateEqualityComparer<TAlternate,T> (.NET 9+) was kept out of the reflected types. Its
   * Equals(TAlternate, T) takes two different type parameters and erases to the same signature as
   * NetObject.Equals(IJCOBridgeReflected, IJCOBridgeReflected): like Equals(T, T) of IEqualityComparer<T>,
   * it is exposed as EqualsGeneric so that both remain callable.
   */
  @throws[Throwable]
  private[generics] def testGenericAlternateEqualityComparerIsReflected(): Unit = {
    val comparer =
      try Some(Class.forName("system.collections.generic.IAlternateEqualityComparer_2", false, getClass.getClassLoader))
      catch { case _: ClassNotFoundException => None }

    comparer match {
      case None =>
        Console.WriteLine("IAlternateEqualityComparer_2 not available in this framework (.NET 9+), skipping")
      case Some(c) =>
        if (c.getTypeParameters.length != 2)
          throw new AssertionError("IAlternateEqualityComparer_2 must have two type parameters")

        val reflected = classOf[IJCOBridgeReflected]
        c.getMethod("EqualsGeneric", reflected, reflected)
        assertMissing(c, "Equals", reflected, reflected)
        c.getMethod("Create", reflected)
        c.getMethod("GetHashCode", reflected)
    }
  }

  private def assertMissing(c: Class[_], name: String, params: Class[_]*): Unit = {
    val found =
      try { c.getMethod(name, params: _*); true }
      catch { case _: NoSuchMethodException => false }
    if (found) throw new AssertionError(c.getSimpleName + "." + name + " should have been renamed")
  }
}
