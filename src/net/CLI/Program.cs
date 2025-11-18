/*
 *  MIT License
 *
 *  Copyright (c) 2020-2025 MASES s.r.l.
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

using MASES.JCOReflector.Engine;
using System;

namespace MASES.JCOReflector.CLI
{
    class Program
    {
        static void showHelp(string errorString = null)
        {
            var assembly = typeof(Program).Assembly;
#if NET6_0
            var title = "JCOReflector CLI - CLI interface for JCOReflector Engine (.NET 6)";
#elif NET7_0
            var title = "JCOReflector CLI - CLI interface for JCOReflector Engine (.NET 7)";
#elif NET8_0
            var title = "JCOReflector CLI - CLI interface for JCOReflector Engine (.NET 8)";
#elif NET9_0
            var title = "JCOReflector CLI - CLI interface for JCOReflector Engine (.NET 9)";
#elif NET10_0
            var title = "JCOReflector CLI - CLI interface for JCOReflector Engine (.NET 10)";
#elif NETFRAMEWORK
            var title = "JCOReflector CLI - CLI interface for JCOReflector Engine (.NET Framework)";
#else
#error Unable to identify .NET engine
#endif

            Console.WriteLine(title + " - Version " + assembly.GetName().Version.ToString());
            Console.WriteLine(assembly.GetName().Name + " -JobType <> ...");
            Console.WriteLine();
            if (!string.IsNullOrEmpty(errorString))
            {
                Console.WriteLine("Error: {0}", errorString);
            }
            Console.WriteLine();
#if !GITHUB_ACTIONS
            Console.WriteLine(JobManager.GetArgumentHelp());
#endif
        }

        static void Main(string[] args)
        {
            if (args.Length == 0)
            {
                showHelp();
                Environment.ExitCode = -1;
                return;
            }

            JobManager.SetHandler(AppendToConsole, EndOperation);
            CommonEventArgs job = null;
            try
            {
                job = JobManager.FromArgs(args);
            }
            catch (Exception ex)
            {
                showHelp(ex.Message);
                Environment.ExitCode = -1;
                return;
            }

            try
            {
                JobManager.RunJob(job, true);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Environment.ExitCode = -1;
                return;
            }
        }
        static void AppendToConsole(string format, params object[] args)
        {
            Console.WriteLine(format, args);
        }

        static void EndOperation(object sender, EndOperationEventArgs args)
        {
            Console.WriteLine(args.Report);
            if (args.Failed) Environment.ExitCode = -1;
        }
    }
}
