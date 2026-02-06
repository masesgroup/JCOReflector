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
package refout

import org.mases.jcobridge.netreflection.JCORefOut
import org.mases.jcobridge.netreflection.JCOReflector
import system.Double
import system.Int16
import system.Int32
import system.Int64
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference

object HelloRefOutBase {
    @JvmStatic
    fun main(args: Array<String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            var isOK = true
            var testVal: String
            val checkBoolean = true
            testVal = checkBoolean.toString()
            val valBoolean = AtomicBoolean(false)
            system.Boolean.TryParse(testVal, JCORefOut.Create(valBoolean))
            if (valBoolean.get() == system.Boolean.Parse(testVal)) println("Test Boolean is OK") else {
                println(String.format("Test Boolean not OK: %b", valBoolean))
                isOK = isOK and false
            }
            val checkByte: Byte = 10
            testVal = checkByte.toString()
            val valByte: Byte = 4
            val valRefByte = AtomicReference(valByte)
            system.Byte.TryParse(testVal, JCORefOut.Create(valRefByte))
            if (valRefByte.get() == system.Byte.Parse(testVal)) println("Test Byte is OK") else {
                println(String.format("Test Byte not OK: %d", valByte))
                isOK = isOK and false
            }
            val checkDouble = 10.1
            testVal = checkDouble.toString()
            val valDouble = 4.3
            val valRefDouble = AtomicReference(valDouble)
            Double.TryParse(testVal, JCORefOut.Create(valRefDouble))
            if (valRefDouble.get() == Double.Parse(testVal)) println("Test Double is OK") else {
                println(String.format("Test Double not OK: %f", valDouble))
                isOK = isOK and false
            }
            val checkShort: Short = 10
            testVal = checkShort.toString()
            val valShort: Short = 4
            val valRefShort = AtomicReference(valShort)
            Int16.TryParse(testVal, JCORefOut.Create(valRefShort))
            if (valRefShort.get() == Int16.Parse(testVal)) println("Test Int16 is OK") else {
                println(String.format("Test Int16 not OK: %d", valShort))
                isOK = isOK and false
            }
            val checkInteger = 10
            testVal = checkInteger.toString()
            val valInteger = AtomicInteger(4)
            Int32.TryParse(testVal, JCORefOut.Create(valInteger))
            if (valInteger.get() == Int32.Parse(testVal)) println("Test Int32 is OK") else {
                println(String.format("Test Int32 not OK: %d", valInteger))
                isOK = isOK and false
            }
            val checkLong = 10L
            testVal = checkLong.toString()
            val valLong = AtomicLong(4L)
            Int64.TryParse(testVal, JCORefOut.Create(valLong))
            if (valLong.get() == Int64.Parse(testVal)) println("Test Int64 is OK") else {
                println(String.format("Test Int64 not OK: %d", valLong))
                isOK = isOK and false
            }
            System.exit(if (isOK) 0 else -1)
        } catch (tre: Throwable) {
            tre.printStackTrace()
            System.exit(-1)
        }
    }
}