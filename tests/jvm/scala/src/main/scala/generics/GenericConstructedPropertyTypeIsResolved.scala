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
import system.collections.concurrent.ConcurrentDictionary_2
import system.collections.generic.{ICollection_1, IDictionary_2}

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericConstructedPropertyTypeIsResolved {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericConstructedPropertyTypeIsResolved()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises a property whose type is a constructed generic over the type parameters in scope:
   * IDictionary<TKey,TValue>.Keys is ICollection<TKey> and .Values is ICollection<TValue>, and the
   * same holds for the public ConcurrentDictionary<TKey,TValue>.Keys/Values. They must be exposed
   * as ICollection_1<TKey> / ICollection_1<TValue>, not as the raw ICollection_1.
   */
  @throws[Throwable]
  private[generics] def testGenericConstructedPropertyTypeIsResolved(): Unit = {
    assertParameterized(classOf[IDictionary_2[_ <: R, _ <: R]].getMethod("getKeys").getGenericReturnType,
      classOf[ICollection_1[_ <: R]], classOf[IDictionary_2[_ <: R, _ <: R]], "TKey")
    assertParameterized(classOf[IDictionary_2[_ <: R, _ <: R]].getMethod("getValues").getGenericReturnType,
      classOf[ICollection_1[_ <: R]], classOf[IDictionary_2[_ <: R, _ <: R]], "TValue")

    assertParameterized(classOf[ConcurrentDictionary_2[_ <: R, _ <: R]].getMethod("getKeys").getGenericReturnType,
      classOf[ICollection_1[_ <: R]], classOf[ConcurrentDictionary_2[_ <: R, _ <: R]], "TKey")
    assertParameterized(classOf[ConcurrentDictionary_2[_ <: R, _ <: R]].getMethod("getValues").getGenericReturnType,
      classOf[ICollection_1[_ <: R]], classOf[ConcurrentDictionary_2[_ <: R, _ <: R]], "TValue")

    // the typed property is usable end to end
    val dict = new ConcurrentDictionary_2[system.Object, system.Object]() {}
    if (!dict.TryAdd(new system.Object(), new system.Object())) throw new AssertionError("TryAdd of a new key must succeed")

    val keys: ICollection_1[system.Object] = dict.getKeys()
    val values: ICollection_1[system.Object] = dict.getValues()
    if (keys.getCount() != 1) throw new AssertionError("Expected 1 key")
    if (values.getCount() != 1) throw new AssertionError("Expected 1 value")
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
