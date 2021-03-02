/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

package hierarchy;

import org.mases.jcobridge.netreflection.*;

import org.mases.jcobridge.JCRefOut;
import system.*;
import system.io.*;
import system.text.Encoding;

public class HelloHierarchy {
    public static void main(String[] args) {
        JCOReflector.setCommandLineArgs(args);
        try {
            String fileinputname = "input.txt";
            String fileoutputname = "output.txt";
            String fileText = "| Java input string |";
            String result = "";
            if (!File.Exists(fileinputname)) {
                File.WriteAllText(fileinputname, fileText);
            }

            Stream str;

            //emulate the using directive (.net) with a try...finally  
            try(FileStream sourceStream = File.Open(fileinputname, FileMode.Open) ; 
            FileStream destinationStream = File.Create(fileoutputname);)
            {
                //Cast to destination stream to stream base class
                str = (Stream) destinationStream;
                //Copy the Source content to the destination stream using the casted object
                sourceStream.CopyTo(str);
                //Cast the base stram to the FileStream and assign to a Filestream
                FileStream destinationStreamInstance = (FileStream) str;
                //Write using the casted stream
                byte[] toWrite = Encoding.getASCII().GetBytes(fileText);
                destinationStreamInstance.Write(toWrite,0,toWrite.length);

                //Verify that the stream used where correct reading from the original destination stream
                byte[] bytes = new byte[1024];
                //use theJCRefOut special class to retrieve data passed as parameter
                JCRefOut<byte[]> data = JCRefOut.Create(bytes);
                destinationStream.Seek(0, SeekOrigin.Begin);
                destinationStream.Read(data, 0, 1024);
                String expectedText= fileText + fileText;
                //do the check
                if(Encoding.getASCII().GetString(data).trim().equalsIgnoreCase(expectedText.trim()))
                {
                    result = "Hierarchy OK";
                }
                else
                {
                    result = "Something goes wrong!";
                    Console.WriteLine("File Content:");
                    Console.WriteLine(Encoding.getASCII().GetString(data));
                    Console.WriteLine("Expected Text:");
                    Console.WriteLine(expectedText);
                }
            }
            
            //check if the dispose affected the casted class
            if(str.getCanRead() == true) result += " Hierarchy dispose NOT OK";
            if(str.getCanWrite() == true) result += " Hierarchy dispose NOT OK";
            
            Console.WriteLine(result);
            Console.WriteLine("Exiting");
            Environment.Exit(0);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (Throwable tre) {
            tre.printStackTrace();
        }
    }
}