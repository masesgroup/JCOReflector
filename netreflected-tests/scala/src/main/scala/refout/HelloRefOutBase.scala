/*
 *  MIT License
 *
 *  Copyright (c) 2021 MASES s.r.l.
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

package refout

import java.util.concurrent.atomic._

object HelloRefOutBase {
  def main(args: Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      var isOK = true
      var testVal = ""
      val checkBoolean = true
      testVal = checkBoolean.toString
      val valBoolean = new AtomicBoolean(false)
      system.Boolean.TryParse(testVal, JCORefOut.Create(valBoolean))
      if (valBoolean.get == system.Boolean.Parse(testVal)) System.out.println("Test Boolean is OK")
      else {
        System.out.println(String.format("Test Boolean not OK: %b", valBoolean))
        isOK &= false
      }
      val checkByte = 10
      testVal = checkByte.toString
      val valByte = 4: Byte
      val valRefByte = new AtomicReference[Byte](valByte)
      system.Byte.TryParse(testVal, JCORefOut.Create(valRefByte))
      if (valRefByte.get == system.Byte.Parse(testVal)) System.out.println("Test Byte is OK")
      else {
        System.out.println(String.format("Test Byte not OK: %d", valByte))
        isOK &= false
      }
      val checkDouble = 10.1
      testVal = checkDouble.toString
      val valDouble = 4.3
      val valRefDouble = new AtomicReference[Double](valDouble)
      system.Double.TryParse(testVal, JCORefOut.Create(valRefDouble))
      if (valRefDouble.get == system.Double.Parse(testVal)) System.out.println("Test Double is OK")
      else {
        System.out.println(String.format("Test Double not OK: %f", valDouble))
        isOK &= false
      }
      val checkShort = 10
      testVal = checkShort.toString
      val valShort = 4: Short
      val valRefShort = new AtomicReference[Short](valShort)
      system.Int16.TryParse(testVal, JCORefOut.Create(valRefShort))
      if (valRefShort.get == system.Int16.Parse(testVal)) System.out.println("Test Int16 is OK")
      else {
        System.out.println(String.format("Test Int16 not OK: %d", valShort))
        isOK &= false
      }
      val checkInteger = 10
      testVal = checkInteger.toString
      val valInteger = new AtomicInteger(4)
      system.Int32.TryParse(testVal, JCORefOut.Create(valInteger))
      if (valInteger.get == system.Int32.Parse(testVal)) System.out.println("Test Int32 is OK")
      else {
        System.out.println(String.format("Test Int32 not OK: %d", valInteger))
        isOK &= false
      }
      val checkLong = 10L
      testVal = checkLong.toString
      val valLong = new AtomicLong(4L)
      system.Int64.TryParse(testVal, JCORefOut.Create(valLong))
      if (valLong.get == system.Int64.Parse(testVal)) System.out.println("Test Int64 is OK")
      else {
        System.out.println(String.format("Test Int64 not OK: %d", valLong))
        isOK &= false
      }
      System.exit(if (isOK) 0
      else -1)
    } catch {
      case tre: Throwable =>
        tre.printStackTrace()
        System.exit(-1)
    }
  }
}
