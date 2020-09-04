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

using System;
using System.IO;

namespace MASES.C2JReflector
{
    class Program
    {
        static void Main(string[] args)
        {
            string RepositoryRoot;
            string tbJDKFolder = string.Empty;
            try
            {
                var assemblyLoc = typeof(Program).Assembly.Location;
                assemblyLoc = Path.GetDirectoryName(assemblyLoc);
                RepositoryRoot = Path.Combine(assemblyLoc, @"..\..\");

                JDKVersion cbTarget = JDKVersion.Version8;
                LogLevel cbLogLevel = LogLevel.Info;

                string tbDestinationFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, Const.FileNameAndDirectory.RootDirectory));
                string tbJarDestinationFolder = assemblyLoc;
#if DEBUG
                tbJDKFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, "jdk-14.0.1"));
#endif
                Reflector.AppendToConsoleHandler = appendToConsole;
                Reflector.EndOperationHandler = endOperation;
                JavaBuilder.AppendToConsoleHandler = appendToConsole;
                JavaBuilder.EndOperationHandler = endOperation;


            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine("Press any key.");
                Console.ReadKey();
            }
        }

        static void appendToConsole(string format, params object[] args)
        {
            Console.WriteLine(format, args);
        }

        static void endOperation(object sender, EndOperationEventArgs args)
        {
            Console.WriteLine(args.Report);
        }
    }
}
