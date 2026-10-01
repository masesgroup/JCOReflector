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
object RemoveByKeyRenameOnKeyedCollection {
  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testRemoveByKeyRenameOnKeyedCollection()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises the RemoveByKey()/ContainsByKey() rename on KeyedCollection<TKey,TItem>-derived
   * types, which would otherwise erase to the same signature as the inherited
   * Collection<TItem>.Remove(TItem)/Contains(TItem).
   */
  @throws[Exception]
  private[generics] def testRemoveByKeyRenameOnKeyedCollection(): Unit = {
    val cl = getClass.getClassLoader
    val keyed = Class.forName("system.collections.objectmodel.KeyedCollection_2", false, cl)
    val collection = Class.forName("system.collections.objectmodel.Collection_1", false, cl)
    keyed.getMethod("RemoveByKey", classOf[IJCOBridgeReflected])
    keyed.getMethod("ContainsByKey", classOf[IJCOBridgeReflected])
    // Remove/Contains must now resolve to the base class, i.e. not be hidden by the keyed overloads.
    if (keyed.getMethod("Remove", classOf[IJCOBridgeReflected]).getDeclaringClass ne collection) throw new AssertionError("KeyedCollection_2 still redeclares Remove(T)")
    if (keyed.getMethod("Contains", classOf[IJCOBridgeReflected]).getDeclaringClass ne collection) throw new AssertionError("KeyedCollection_2 still redeclares Contains(T)")
  }
}
