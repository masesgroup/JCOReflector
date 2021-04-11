﻿/*
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

using System;
using System.IO;
using System.Threading;
using System.Threading.Tasks;

namespace MASES.C2JReflector
{
    class Program
    {
        static void Main(string[] args)
        {
            const string REFLECT = "reflect";
            const string BUILD = "build";
            const string BUILDDOCS = "builddocs";
            const string CREATEJARS = "createjars";
            const string CREATESNAPSHOTPOMS = "createsnapshotpoms";
            const string CREATERELEASEPOMS = "createreleasepoms";
            const string DEFAULTJDK = "jdk-14.0.1";
            const string JDKPARAM = "-jdk=";

            if (args.Length < 2)
            {
                showHelp();
                Environment.ExitCode = -1;
                return;
            }

            string RepositoryRoot;
            string tbJDKFolder = string.Empty;

            for (int index = 2; index < args.Length; index++)
            {
                var arg = args[index];
                if (arg.StartsWith(JDKPARAM))
                {
                    tbJDKFolder = arg.Substring(JDKPARAM.Length);
                    tbJDKFolder = Path.GetFullPath(tbJDKFolder);
                }
            }

            try
            {
                var assemblyLoc = typeof(Program).Assembly.Location;
                assemblyLoc = Path.GetDirectoryName(assemblyLoc);
                RepositoryRoot = Path.GetFullPath(Path.Combine(assemblyLoc, @".." + Path.DirectorySeparatorChar + @".." + Path.DirectorySeparatorChar));

                string tbDestinationFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, Const.FileNameAndDirectory.RootDirectory));
                string tbJarDestinationFolder = Const.FileNameAndDirectory.GetRelativePath(assemblyLoc, RepositoryRoot);

                Reflector.AppendToConsoleHandler = appendToConsole;
                Reflector.EndOperationHandler = endOperation;
                JavaBuilder.AppendToConsoleHandler = appendToConsole;
                JavaBuilder.EndOperationHandler = endOperation;

                switch (args[0])
                {
                    case REFLECT:
                        {
                            var input = readInput<ReflectorEventArgs>(args[1]);
                            input.CancellationToken = new CancellationTokenSource().Token;
                            input.RootFolder = RepositoryRoot;
                            if (input.SrcDestinationFolder == null)
                            {
                                input.SrcDestinationFolder = Path.GetFullPath(tbDestinationFolder);
                            }

                            Task.Factory.StartNew(Reflector.ExecuteAction, input).Wait();
                        }
                        break;
                    case BUILD:
                        {
                            var input = readInput<JavaBuilderEventArgs>(args[1]);
                            input.CancellationToken = new CancellationTokenSource().Token;
                            input.RootFolder = RepositoryRoot;
                            if (string.IsNullOrEmpty(input.SourceFolder))
                            {
                                input.SourceFolder = Path.GetFullPath(tbDestinationFolder);
                            }

                            if (input.JDKTarget == JDKVersion.NotSet)
                            {
                                input.JDKTarget = JDKVersion.Version8;
                            }

                            if (string.IsNullOrEmpty(input.JDKFolder))
                            {
#if DEBUG
                                input.JDKFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, DEFAULTJDK));
#else
                                throw new ArgumentException("Missing JDKFolder input");
#endif
                            }

                            if (!string.IsNullOrEmpty(tbJDKFolder))
                            {
                                input.JDKFolder = tbJDKFolder;
                            }

                            if (input.AssembliesToUse == null || input.AssembliesToUse.Length == 0)
                            {
                                input.AssembliesToUse = createList(input);
                            }

                            Task.Factory.StartNew(JavaBuilder.CompileClasses, input).Wait();
                        }
                        break;
                    case BUILDDOCS:
                        {
                            var input = readInput<JavaBuilderEventArgs>(args[1]);
                            input.CancellationToken = new CancellationTokenSource().Token;
                            input.RootFolder = RepositoryRoot;
                            if (string.IsNullOrEmpty(input.SourceFolder))
                            {
                                input.SourceFolder = Path.GetFullPath(tbDestinationFolder);
                            }

                            if (input.JDKTarget == JDKVersion.NotSet)
                            {
                                input.JDKTarget = JDKVersion.Version8;
                            }

                            if (string.IsNullOrEmpty(input.JDKFolder))
                            {
#if DEBUG
                                input.JDKFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, DEFAULTJDK));
#else
                                throw new ArgumentException("Missing JDKFolder input");
#endif
                            }

                            if (!string.IsNullOrEmpty(tbJDKFolder))
                            {
                                input.JDKFolder = tbJDKFolder;
                            }

                            if (input.AssembliesToUse == null || input.AssembliesToUse.Length == 0)
                            {
                                input.AssembliesToUse = createList(input);
                            }

                            Task.Factory.StartNew(JavaBuilder.GenerateDocs, input).Wait();
                        }
                        break;
                    case CREATEJARS:
                        {
                            var input = readInput<JARBuilderEventArgs>(args[1]);
                            input.CancellationToken = new CancellationTokenSource().Token;
                            input.RootFolder = RepositoryRoot;

                            if (string.IsNullOrEmpty(input.SourceFolder))
                            {
                                input.SourceFolder = Path.GetFullPath(tbDestinationFolder);
                            }

                            if (input.JarDestinationFolder == null)
                            {
                                input.JarDestinationFolder = tbJarDestinationFolder;
                            }

                            if (input.JDKTarget == JDKVersion.NotSet)
                            {
                                input.JDKTarget = JDKVersion.Version8;
                            }

                            if (string.IsNullOrEmpty(input.JDKFolder))
                            {
#if DEBUG
                                input.JDKFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, DEFAULTJDK));
#else
                                throw new ArgumentException("Missing JDKFolder input");
#endif
                            }

                            if (!string.IsNullOrEmpty(tbJDKFolder))
                            {
                                input.JDKFolder = tbJDKFolder;
                            }

                            if (input.AssembliesToUse == null || input.AssembliesToUse.Length == 0)
                            {
                                input.AssembliesToUse = createList(input);
                            }

                            Task.Factory.StartNew(JavaBuilder.CreateJars, input).Wait();
                        }
                        break;
                    case CREATESNAPSHOTPOMS:
                        {
                            var input = readInput<JARBuilderEventArgs>(args[1]);
                            input.CancellationToken = new CancellationTokenSource().Token;
                            input.RootFolder = RepositoryRoot;

                            if (string.IsNullOrEmpty(input.SourceFolder))
                            {
                                input.SourceFolder = Path.GetFullPath(tbDestinationFolder);
                            }

                            if (input.JarDestinationFolder == null)
                            {
                                input.JarDestinationFolder = tbJarDestinationFolder;
                            }

                            if (input.JDKTarget == JDKVersion.NotSet)
                            {
                                input.JDKTarget = JDKVersion.Version8;
                            }

                            if (string.IsNullOrEmpty(input.JDKFolder))
                            {
#if DEBUG
                                input.JDKFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, DEFAULTJDK));
#else
                                throw new ArgumentException("Missing JDKFolder input");
#endif
                            }

                            if (!string.IsNullOrEmpty(tbJDKFolder))
                            {
                                input.JDKFolder = tbJDKFolder;
                            }

                            if (input.AssembliesToUse == null || input.AssembliesToUse.Length == 0)
                            {
                                input.AssembliesToUse = createList(input);
                            }

                            input.GeneratePOM = JARBuilderEventArgs.POMType.Snapshot;

                            Task.Factory.StartNew(JavaBuilder.CreatePOM, input).Wait();
                        }
                        break;
                    case CREATERELEASEPOMS:
                        {
                            var input = readInput<JARBuilderEventArgs>(args[1]);
                            input.CancellationToken = new CancellationTokenSource().Token;
                            input.RootFolder = RepositoryRoot;

                            if (string.IsNullOrEmpty(input.SourceFolder))
                            {
                                input.SourceFolder = Path.GetFullPath(tbDestinationFolder);
                            }

                            if (input.JarDestinationFolder == null)
                            {
                                input.JarDestinationFolder = tbJarDestinationFolder;
                            }

                            if (input.JDKTarget == JDKVersion.NotSet)
                            {
                                input.JDKTarget = JDKVersion.Version8;
                            }

                            if (string.IsNullOrEmpty(input.JDKFolder))
                            {
#if DEBUG
                                input.JDKFolder = Path.GetFullPath(Path.Combine(RepositoryRoot, DEFAULTJDK));
#else
                                throw new ArgumentException("Missing JDKFolder input");
#endif
                            }

                            if (!string.IsNullOrEmpty(tbJDKFolder))
                            {
                                input.JDKFolder = tbJDKFolder;
                            }

                            if (input.AssembliesToUse == null || input.AssembliesToUse.Length == 0)
                            {
                                input.AssembliesToUse = createList(input);
                            }

                            input.GeneratePOM = JARBuilderEventArgs.POMType.Release;

                            Task.Factory.StartNew(JavaBuilder.CreatePOM, input).Wait();
                        }
                        break;
                    default:
                        showHelp();
                        Environment.ExitCode = -1;
                        return;
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Environment.ExitCode = -1;
            }
        }

        static T readInput<T>(string path) where T : class
        {
            System.Xml.Serialization.XmlSerializer serializer = new System.Xml.Serialization.XmlSerializer(typeof(T));
            string str = File.ReadAllText(path);
            using (TextReader reader = new StringReader(str))
            {
                return serializer.Deserialize(reader) as T;
            }
        }

        static string[] createList(FolderBuilderEventArgs args)
        {
            var result = JavaBuilder.CreateFolderList(args);

            foreach (var item in result)
            {
                item.IsSelected = true;
            }

            return AssemblyDataCollection.CreateList(result);
        }

        static void appendToConsole(string format, params object[] args)
        {
            Console.WriteLine(format, args);
        }

        static void endOperation(object sender, EndOperationEventArgs args)
        {
            Console.WriteLine(args.Report);
            if (args.Failed) Environment.ExitCode = -1;
        }

        static void showHelp()
        {
            var assembly = typeof(Program).Assembly;

#if !NET_CORE
            var title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET Framework)";
#else
#if NET5_0
            var title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET 5)";
#else
            var title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET Core)";
#endif
#endif

            Console.WriteLine(title + " - Version " + assembly.GetName().Version.ToString());
            Console.WriteLine(assembly.GetName().Name + " <OPERATION> <CONFIGURATION FILE> -jdk=<JDKFOLDER>");
            Console.WriteLine();
            Console.WriteLine("OPERATION: reflect, build, builddocs, createjars");
            Console.WriteLine("CONFIGURATION FILE: a file containing the information to complete each OPERATION.");
            Console.WriteLine("-jdk: valid only if OPERATION are build, builddocs and createjars. Overrides value found in CONFIGURATION FILE");
        }
    }
}
