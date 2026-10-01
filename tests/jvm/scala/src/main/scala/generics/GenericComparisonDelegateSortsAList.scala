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
import org.mases.jcobridge._
import system.Console
import system.Environment
import system.collections.generic._
import system.collections.objectmodel._


/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented. They are written as plain static methods on purpose,
 * so they can be dropped into whatever test harness the project actually uses (JUnit, plain
 * {@code main}, or something else) without depending on a particular framework.
 * <p>
 */
object GenericComparisonDelegateSortsAList {
  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericComparisonDelegateSortsAList()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises a generic delegate with a primitive (non-generic-parameter) return type —
   * Comparison<T> returns int, which required its own "Native" generic delegate template
   * distinct from the generic-parameter-return case.
   */
  @throws[Throwable]
  private[generics] def testGenericComparisonDelegateSortsAList(): Unit = {
    val list = new List_1[system.Object]() {}
    val calls = new AtomicInteger
    val closedName = "System.Comparison`1[System.Object]"
    val comparison = new Comparison_1[system.Object]() {
      def getDelegateTypeName: String = {
        val delegateTypeName = closedName + ", " + Comparison_1.assemblyFullName
        delegateTypeName
      }

      def getDelegateType: JCType = try {
        val delegateTypeName = getDelegateTypeName
        JCOBridgeInstance.getInstance(Comparison_1.assemblyFullName).GetType(delegateTypeName)
      } catch {
        case t: Throwable =>
          throw new IllegalStateException(t)
      }

      def Invoke(x: system.Object, y: system.Object): Int = {
        calls.incrementAndGet
        0
      }
    }
    list.Add(new system.Object)
    list.Add(new system.Object)
    list.Sort(comparison)
    if (calls.get == 0) throw new AssertionError("Java comparison never invoked")
  }
}
