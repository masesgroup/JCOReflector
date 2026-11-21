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
import system.collections.generic.{IEnumerable_1, KeyValuePair_2}

/**
 * Draft smoke tests for JCOReflector's experimental generics support.
 * <p>
 * Each method is a self-contained, independent check for one specific mechanism discussed
 * while this feature was implemented.
 * <p>
 */
object GenericNestedConstructedArgumentsAreResolved {
  private type R = IJCOBridgeReflected

  @throws[Throwable]
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      testGenericNestedConstructedArgumentsAreResolved()
      Console.WriteLine("Exiting with success")
      Environment.Exit(0)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }

  /**
   * Exercises the recursive resolution of nested type arguments: the constructor
   * ConcurrentDictionary<TKey,TValue>(IEnumerable<KeyValuePair<TKey,TValue>>) must be exposed as
   * IEnumerable_1<KeyValuePair_2<TKey,TValue>>, with both inner arguments being the type
   * parameters of the class, not the raw IEnumerable_1 and not a raw KeyValuePair_2.
   */
  @throws[Throwable]
  private[generics] def testGenericNestedConstructedArgumentsAreResolved(): Unit = {
    val dictionary =
      try Some(Class.forName("system.collections.concurrent.ConcurrentDictionary_2", false, getClass.getClassLoader))
      catch { case _: ClassNotFoundException => None }

    dictionary match {
      case None =>
        Console.WriteLine("ConcurrentDictionary_2 not available in this framework, skipping")
      case Some(dict) =>
        dict.getConstructor(classOf[IEnumerable_1[_ <: R]]).getGenericParameterTypes()(0) match {
          case outer: java.lang.reflect.ParameterizedType =>
            if (outer.getRawType ne classOf[IEnumerable_1[_ <: R]])
              throw new AssertionError("Constructor parameter must be an IEnumerable_1, got " + outer.getRawType)
            outer.getActualTypeArguments()(0) match {
              case pair: java.lang.reflect.ParameterizedType =>
                if (pair.getRawType ne classOf[KeyValuePair_2[_ <: R, _ <: R]])
                  throw new AssertionError("Element type must be a KeyValuePair_2, got " + pair.getRawType)
                Seq("TKey", "TValue").zipWithIndex.foreach { case (expected, i) =>
                  pair.getActualTypeArguments()(i) match {
                    case v: java.lang.reflect.TypeVariable[_] =>
                      if ((v.getGenericDeclaration ne dict) || v.getName != expected)
                        throw new AssertionError("Expected type variable " + expected + " of the dictionary, got " + v)
                    case other =>
                      throw new AssertionError("Expected type variable " + expected + " of the dictionary, got " + other)
                  }
                }
              case other =>
                throw new AssertionError("Element type must be KeyValuePair_2<TKey,TValue>, got " + other)
            }
          case other =>
            throw new AssertionError("Constructor parameter must be IEnumerable_1<...>, got " + other)
        }
    }
  }
}
