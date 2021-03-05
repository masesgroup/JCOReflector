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

import scala.util.{Try, Using}

import org.mases.jcobridge.netreflection._
import system._
import system.io._
import system.text._

object HelloHierarchy {
  def main(args: scala.Array[String]): Unit = {
    JCOReflector.setCommandLineArgs(args)
    try {
      val fileinputname = "input.txt"
      val fileoutputname = "output.txt"
      val fileText = "| Java input string |"
      var result = ""
      if (!File.Exists(fileinputname)) File.WriteAllText(fileinputname, fileText)
      //emulate the using directive (.net) with a try...finally
      Using.Manager {
        use => {
          val sourceStream = use(File.Open(fileinputname, FileMode.Open))
          val destinationStream = use(File.Create(fileoutputname))
          //Cast the destination stream to stream base class
          val str = destinationStream.asInstanceOf[Stream]
          //Copy the Source content to the destination stream using the casted object
          sourceStream.CopyTo(str)
          //Cast the base stream to the FileStream and assign to a Filestream
          val destinationStreamInstance = str.asInstanceOf[FileStream]
          //Write using the casted stream
          val toWrite = Encoding.getASCII.GetBytes(fileText)
          destinationStreamInstance.Write(toWrite, 0, toWrite.length)
          //Verify that the stream used where correct reading from the original destination stream
          val bytes = new scala.Array[Byte](1024)
          //use the JCORefOut special class to retrieve data passed as parameter
          val data = JCORefOut.Create(bytes)
          destinationStream.Seek(0, SeekOrigin.Begin)
          destinationStream.Read(data, 0, 1024)
          val expectedText = fileText + fileText
          //do the check
          if (Encoding.getASCII.GetString(data).trim.equalsIgnoreCase(expectedText.trim)) result = "Hierarchy OK"
          else {
            result = "Something goes wrong!"
            Console.WriteLine("File Content:")
            Console.WriteLine(Encoding.getASCII.GetString(data))
            Console.WriteLine("Expected Text:")
            Console.WriteLine(expectedText)
          }

          //check if the dispose affected the casted class
          if (str.getCanRead) result += " Hierarchy dispose NOT OK"
          if (str.getCanWrite) result += " Hierarchy dispose NOT OK"
        }
      }
      Console.WriteLine(result)
      Console.WriteLine("Exiting")
      Environment.Exit(0)
    } catch {
      case fnfe: FileNotFoundException =>
        fnfe.printStackTrace()
      case tre: Throwable =>
        tre.printStackTrace()
    }
  }
}