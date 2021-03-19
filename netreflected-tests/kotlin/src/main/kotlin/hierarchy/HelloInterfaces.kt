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

package hierarchy

import org.mases.jcobridge.netreflection.JCOReflector
import org.mases.jcobridge.netreflection.NetObject
import system.Console
import system.Environment
import system.collections.SortedList

object HelloInterfaces {
    @JvmStatic
    fun main(args: Array<String>) {
        JCOReflector.setCommandLineArgs(args)
        try {
            //Create and populate a sorted array
            val sr = SortedList()
            sr.Add(NetObject("Hello"), NetObject("test"))
            sr.Add(NetObject("Hello2"), NetObject("test2"))
            sr.Add(NetObject("Hello3"), NetObject("test3"))
            // Get the IList interface
            val keyList = sr.GetKeyList()
            val valueList = sr.GetValueList()

            //operate on interface
            for (netObject in keyList) {
                Console.WriteLine(netObject.ToString())
            }
            for (netObject in valueList) {
                Console.WriteLine(netObject.ToString())
            }
            val ev = Environment.GetEnvironmentVariables()
            for (netObject in ev.keys) {
                Console.WriteLine(netObject.ToString())
                //System.out.println(netObject.ToString()); viable Alternative
            }
            Environment.Exit(0)
        } catch (tre: Throwable) {
            tre.printStackTrace()
        }
    }
}