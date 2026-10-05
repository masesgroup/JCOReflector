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
import system.Comparison_1
import system.Console
import system.Environment
import system.UInt32
import system.collections.generic._
import system.collections.objectmodel._


/**
 * Smoke tests for JCOReflector's experimental generics support.
 * <p>
 * testGenericComparisonDelegateSortsAList exercises a generic delegate with a primitive
 * (non-generic-parameter) return type, Comparison<T> returns int, passed as a synchronous,
 * value-returning callback to a generic method (List<T>.Sort). Both List_1 and Comparison_1 are
 * constructed with the anonymous-subclass idiom ({@code new X[T]() {}}); the generated
 * Comparison_1 class resolves its own closed CLR delegate type lazily via NetGenericHelper, so no
 * manual type-name bookkeeping is needed here.
 * <p>
 * The other tests cover native types: testNativeTypesInGenericMembers checks native int and
 * boolean values crossing the bridge in the members of a generic class,
 * testNativeWrapperTypesAsTypeArguments uses the reflected wrapper of a native value type (UInt32)
 * as a type argument, and testNativeJavaTypesCannotBeTypeArguments checks the bound that keeps
 * plain Java types (String, int, boolean...) out of the type arguments.
 */
object GenericComparisonDelegateSortsAList {
  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericComparisonDelegateSortsAList()
      testNativeTypesInGenericMembers()
      testNativeWrapperTypesAsTypeArguments()
      testNativeJavaTypesCannotBeTypeArguments()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises a generic delegate with a primitive (non-generic-parameter) return type -
   * Comparison<T> returns int, which required its own "Native" generic delegate template
   * distinct from the generic-parameter-return case.
   */
  @throws[Throwable]
  private[generics] def testGenericComparisonDelegateSortsAList(): Unit = {
    val list = new List_1[system.Object]() {}
    list.Add(new system.Object())
    list.Add(new system.Object())

    val calls = new java.util.concurrent.atomic.AtomicInteger()

    val comparison = new Comparison_1[system.Object]() {
      override def Invoke(x: system.Object, y: system.Object): Int = {
        calls.incrementAndGet()
        0
      }
    }
    list.Sort(comparison)

    if (calls.get() == 0) throw new AssertionError("Java comparison never invoked")
  }

  /**
   * Adds the pair to the dictionary and returns false when the key is already present.
   * Dictionary.TryAdd does not exist on .NET Framework (net462), so the duplicate is detected
   * through the ArgumentException thrown by Add.
   */
  @throws[Throwable]
  private def addIfAbsent[K <: IJCOBridgeReflected, V <: IJCOBridgeReflected](dict: Dictionary_2[K, V], key: K, value: V): Boolean = {
    try {
      dict.Add(key, value)
      true
    } catch {
      case _: system.ArgumentException => false
    }
  }

  /**
   * Native types in the members of a generic class: an int parameter in a generic constructor,
   * boolean and int return values of generic methods, and an int property.
   */
  @throws[Throwable]
  private[generics] def testNativeTypesInGenericMembers(): Unit = {
    // native int parameter of a generic constructor
    val dict = new Dictionary_2[system.Object, system.Object](16) {}

    val key = new system.Object()
    val value = new system.Object()

    // native boolean return values of generic methods
    if (!addIfAbsent(dict, key, value)) throw new AssertionError("Add of a new key must succeed")
    if (addIfAbsent(dict, key, value)) throw new AssertionError("Add of an existing key must throw ArgumentException")
    if (!dict.ContainsKey(key)) throw new AssertionError("ContainsKey must find the added key")
    if (!dict.ContainsValue(value)) throw new AssertionError("ContainsValue must find the added value")

    // native int return value of a generic property
    if (dict.getCount() != 1) throw new AssertionError("Count must be 1 after one Add")

    if (!dict.Remove(key)) throw new AssertionError("Remove of an existing key must return true")
    if (dict.getCount() != 0) throw new AssertionError("Count must be 0 after Remove")
  }

  /**
   * UInt32 is the reflected wrapper of a native value type. Being a reflected class it is a
   * valid type argument, and the CLR compares the values, not the wrappers.
   */
  @throws[Throwable]
  private[generics] def testNativeWrapperTypesAsTypeArguments(): Unit = {
    val dict = new Dictionary_2[UInt32, UInt32]() {}
    if (!addIfAbsent(dict, UInt32.Parse("1"), UInt32.Parse("10"))) throw new AssertionError("Add of a new key must succeed")

    // a different wrapper holding the same number is the same key
    if (!dict.ContainsKey(UInt32.Parse("1"))) throw new AssertionError("ContainsKey must compare keys by value")
    if (dict.ContainsKey(UInt32.Parse("2"))) throw new AssertionError("ContainsKey must not find a missing key")
    if (addIfAbsent(dict, UInt32.Parse("1"), UInt32.Parse("11"))) throw new AssertionError("Add of an equal key must throw ArgumentException")

    // out parameter of a type-argument type: the result comes back through the instance supplied
    val found = UInt32.Parse("0")
    if (!dict.TryGetValue(UInt32.Parse("1"), JCORefOut.Create(found))) throw new AssertionError("TryGetValue must find the key")
    if (found.CompareTo(UInt32.Parse("10")) != 0) throw new AssertionError("TryGetValue must return the stored value in the out parameter")

    // generic delegate whose arguments are value-type wrappers
    val list = new List_1[UInt32]() {}
    list.Add(UInt32.Parse("3"))
    list.Add(UInt32.Parse("1"))
    list.Add(UInt32.Parse("2"))

    val calls = new java.util.concurrent.atomic.AtomicInteger()

    val comparison = new Comparison_1[UInt32]() {
      override def Invoke(x: UInt32, y: UInt32): Int = {
        calls.incrementAndGet()
        x.CompareTo(y)
      }
    }
    list.Sort(comparison)

    if (calls.get() == 0) throw new AssertionError("Java comparison never invoked")
    if (list.IndexOf(UInt32.Parse("1")) != 0) throw new AssertionError("1 must be the first element after Sort")
    if (list.IndexOf(UInt32.Parse("3")) != 2) throw new AssertionError("3 must be the last element after Sort")
  }

  /**
   * Plain Java types (String, int, boolean...) are not reflected classes, so they cannot fill a
   * type parameter: every type parameter is bounded by IJCOBridgeReflected, which none of them
   * implements. Using one is a compile-time error, so the check is made on the bound itself.
   */
  private[generics] def testNativeJavaTypesCannotBeTypeArguments(): Unit = {
    val bounds = classOf[List_1[system.Object]].getTypeParameters()(0).getBounds()
    if (bounds.length != 1 || bounds(0) != classOf[IJCOBridgeReflected])
      throw new AssertionError("The type parameter of List_1 must be bounded by IJCOBridgeReflected")

    if (classOf[IJCOBridgeReflected].isAssignableFrom(classOf[java.lang.String])
      || classOf[IJCOBridgeReflected].isAssignableFrom(classOf[java.lang.Integer])
      || classOf[IJCOBridgeReflected].isAssignableFrom(classOf[java.lang.Boolean]))
      throw new AssertionError("Plain Java types must not satisfy the IJCOBridgeReflected bound")
  }
}
