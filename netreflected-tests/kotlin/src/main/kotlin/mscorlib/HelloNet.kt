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
package mscorlib

import org.mases.jcobridge.netreflection.JCOReflector
import org.mases.jcobridge.netreflection.NetObject
import system.Console
import system.Environment
import system.io.File
import system.io.FileNotFoundException
import system.text.Encoding

object HelloNET {
    @JvmStatic
    fun main(args: Array<String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            val filename = "test.txt"
            if (!File.Exists(filename)) {
                File.WriteAllText(filename, "First Java string")
            }
            var result: String = File.ReadAllText(filename)
            Console.WriteLine(result)
            result = "$result Java Execution"
            File.WriteAllText(filename, result)
            val byteCount = Encoding.getASCII().GetByteCount(result)
            val resByte = File.ReadAllBytes(filename)
            if (byteCount == resByte.size) {
                Console.WriteLine(
                    "{0} and result have equals array lengths. The length is {1}",
                    NetObject(filename),
                    NetObject(byteCount)
                )
            }
            Console.WriteLine("Writing array on file.")
            File.WriteAllBytes("test2.txt", resByte)
            Console.WriteLine(result)
            Console.WriteLine("Exiting")
            Environment.Exit(0)
        } catch (fnfe: FileNotFoundException) {
            fnfe.printStackTrace()
        } catch (tre: Throwable) {
            tre.printStackTrace()
        }
    }
}