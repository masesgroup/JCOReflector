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

using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Threading;

namespace MASES.C2JReflector
{
    public static class JavaBuilder
    {
        enum JarType
        {
            Source, Compiled
        }

        static string JavaCompiler = Path.Combine("bin", "javac");
        static string JavaDoc = Path.Combine("bin", "javadoc");
        static string JarCompiler = Path.Combine("bin", "jar");

        public static appendToConsoleHandler AppendToConsoleHandler;
        public static EventHandler<EndOperationEventArgs> EndOperationHandler;

        static CancellationToken CancellationToken;

        static LogLevel logLevel;

        static string reflectorVersion = typeof(JavaBuilder).Assembly.GetName().Version.ToString();

        static void AppendToConsole(LogLevel level, string format, params object[] args)
        {
            if (logLevel >= level && AppendToConsoleHandler != null)
            {
                AppendToConsoleHandler(format, args);
            }
        }

        public static void CompileClasses(object o)
        {
            bool failed = false;
            JavaBuilderEventArgs args = o as JavaBuilderEventArgs;

            CancellationToken = args.CancellationToken;
            logLevel = args.LogLevel;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                if (!Path.IsPathRooted(args.SourceFolder))
                {
                    args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
                }

                if (!Path.IsPathRooted(args.JDKFolder))
                {
                    args.JDKFolder = Path.Combine(args.RootFolder, args.JDKFolder);
                }

                var srcRootFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory);
                var classes = CreateSourceListAndCompile(args.JDKFolder, args.JDKTarget, args.RootFolder, srcRootFolder, (args.AssembliesToUse == null) ? CreateFolderList(srcRootFolder) : args.AssembliesToUse, Timeout.Infinite);
                reportStr = string.Format("Compilation of {0} classes done in {1}.", classes, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(reportStr, failed));
            }
        }

        public static void GenerateDocs(object o)
        {
            bool failed = false;
            JavaBuilderEventArgs args = o as JavaBuilderEventArgs;
            CancellationToken = args.CancellationToken;
            logLevel = args.LogLevel;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                if (!Path.IsPathRooted(args.SourceFolder))
                {
                    args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
                }

                if (!Path.IsPathRooted(args.JDKFolder))
                {
                    args.JDKFolder = Path.Combine(args.RootFolder, args.JDKFolder);
                }

                var srcRootFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory);
                string destinationFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.DocsDirectory);
                var classes = CreateSourceListAndGenerateDocs(args.JDKFolder, args.JDKTarget, args.RootFolder, srcRootFolder, destinationFolder, (args.AssembliesToUse == null) ? CreateFolderList(srcRootFolder) : args.AssembliesToUse, Timeout.Infinite);
                reportStr = string.Format("Javadoc of {0} classes done in {1}.", classes, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(reportStr, failed));
            }
        }

        public static AssemblyDataCollection CreateFolderList(object o)
        {
            bool failed = false;
            FolderBuilderEventArgs args = o as FolderBuilderEventArgs;
            CancellationToken = args.CancellationToken;
            logLevel = args.LogLevel;

            if (!Path.IsPathRooted(args.SourceFolder))
            {
                args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
            }

            string originFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory);

            try
            {
                var folders = CreateFolderList(originFolder);
                AssemblyDataCollection coll = new AssemblyDataCollection();
                AssemblyData data = new AssemblyData();
                data.IsSelected = true;
                data.Framework = Const.Framework.All;
                data.AssemblyFullName = Const.FileNameAndDirectory.CommonDirectory;
                data.FolderName = Const.FileNameAndDirectory.CommonDirectory;
                coll.Add(data);
                foreach (var folder in folders)
                {
                    data = new AssemblyData();
                    if (folder.Equals(Const.FileNameAndDirectory.CommonDirectory)) continue;

                    var relFolder = Const.Framework.RuntimeFolder;
                    data.AssemblyFullName = folder;
                    data.FolderName = Path.Combine(relFolder, folder);

                    data.Framework = Const.Framework.Runtime;

#if ENABLE_REFERENCE_BUILDER
                    var refPath = Path.Combine(args.OriginFolder, relFolder, folder, Const.FileNameAndDirectory.ReferencesFile);
                    var refData = File.ReadAllLines(refPath);
                    data.ReferencedAssemblies = new List<string>(refData);
#endif

                    coll.Add(data);
                }
                return coll;
            }
            catch (OperationCanceledException ex)
            {
                AppendToConsole(LogLevel.Error, "Error {0}", ex.Message);
                return new AssemblyDataCollection();
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "Error {0}", ex.Message);
                failed = true;
                return new AssemblyDataCollection();
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(string.Empty, failed));
            }
        }

        static IEnumerable<string> CreateFolderList(string originFolder)
        {
            originFolder = Path.GetFullPath(originFolder);
            List<string> dirs = new List<string>();
            dirs.Add(Const.FileNameAndDirectory.CommonDirectory);

            originFolder = Path.Combine(originFolder, Const.Framework.RuntimeFolder);
            foreach (var item in Directory.EnumerateDirectories(originFolder))
            {
                var path = Path.GetFullPath(item);
                path = path.Replace(originFolder, string.Empty);
                path = path.Replace("\\", string.Empty);
                path = path.Replace("/", string.Empty);
                dirs.Add(path);
            }

            return dirs;
        }

        static int CreateSourceListAndCompile(string jdkFolder, JDKVersion jdkTarget, string rootFolder, string originFolder, IEnumerable<string> assemblies, int timeout)
        {
            int counter = 0;
            var tmpFile = Path.Combine(originFolder, Const.FileNameAndDirectory.SourceFile);

            StringBuilder sb = new StringBuilder();
            foreach (var assembly in assemblies)
            {
                var folder = Path.Combine(originFolder, assembly);
                if (assembly == Const.FileNameAndDirectory.CommonDirectory)
                {
                    folder = Path.Combine(rootFolder, Const.FileNameAndDirectory.RootDirectory, Const.FileNameAndDirectory.SourceDirectory, Const.FileNameAndDirectory.CommonDirectory);
                }

                foreach (var item in Directory.EnumerateFiles(folder, "*.java", SearchOption.AllDirectories))
                {
                    sb.AppendLine(item);
                    counter++;
                }
            }

            File.WriteAllText(tmpFile, sb.ToString());
            var jcoBridgePath = Path.GetDirectoryName(typeof(JavaBuilder).Assembly.Location);
            var jcoBridgeCp = Path.Combine(jcoBridgePath, "JCOBridge.jar");
            if (jdkTarget == JDKVersion.NotSet)
            {
                launchProcess(originFolder, Path.Combine(jdkFolder, JavaCompiler), "-cp " + jcoBridgeCp + " @" + Const.FileNameAndDirectory.SourceFile, timeout);
            }
            else
            {
                string compatibility = string.Format(" -source {0} -target {0}", (int)jdkTarget); // -bootclasspath rt{0}.jar
                launchProcess(originFolder, Path.Combine(jdkFolder, JavaCompiler), "-cp " + jcoBridgeCp + compatibility + " @" + Const.FileNameAndDirectory.SourceFile, timeout);
            }
            return counter;
        }

        static int CreateSourceListAndGenerateDocs(string jdkFolder, JDKVersion jdkTarget, string rootFolder, string originFolder, string destinationFolder, IEnumerable<string> assemblies, int timeout)
        {
            int counter = 0;
            var tmpFile = Path.Combine(originFolder, Const.FileNameAndDirectory.SourceFile);

            StringBuilder sb = new StringBuilder();
            foreach (var assembly in assemblies)
            {
                var folder = Path.Combine(originFolder, assembly);
                if (assembly == Const.FileNameAndDirectory.CommonDirectory)
                {
                    folder = Path.Combine(rootFolder, Const.FileNameAndDirectory.RootDirectory, Const.FileNameAndDirectory.SourceDirectory, Const.FileNameAndDirectory.CommonDirectory);
                }

                foreach (var item in Directory.EnumerateFiles(folder, "*.java", SearchOption.AllDirectories))
                {
                    sb.AppendLine(item);
                    counter++;
                }
            }

            File.WriteAllText(tmpFile, sb.ToString());
            var jcoBridgePath = Path.GetDirectoryName(typeof(JavaBuilder).Assembly.Location);
            var jcoBridgeCp = Path.Combine(jcoBridgePath, "JCOBridge.jar");

            destinationFolder = Path.Combine(destinationFolder, Const.Framework.RuntimeFolder);
            destinationFolder = destinationFolder.Replace('\\', '/');

            launchProcess(originFolder, Path.Combine(jdkFolder, JavaDoc), "-header \"" + Const.Documentation.DOCS_HEADER + "\" -quiet -author -noindex -nodeprecated -nodeprecatedlist -notimestamp -nohelp -notree -public -cp " + jcoBridgeCp + " -d " + destinationFolder + " -link https://www.jcobridge.com/api-java @" + Const.FileNameAndDirectory.SourceFile, timeout);

            return counter;
        }

        public static void CreateJars(object o)
        {
            bool failed = false;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                JARBuilderEventArgs args = o as JARBuilderEventArgs;
                logLevel = args.LogLevel;

                if (!Path.IsPathRooted(args.SourceFolder))
                {
                    args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
                }

                if (!Path.IsPathRooted(args.JDKFolder))
                {
                    args.JDKFolder = Path.Combine(args.RootFolder, args.JDKFolder);
                }

                if (!Path.IsPathRooted(args.JarDestinationFolder))
                {
                    args.JarDestinationFolder = Path.Combine(args.RootFolder, args.JarDestinationFolder);
                }

                var srcRootFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory);
                var jars = CreateJars(args.JDKFolder, args.RootFolder, srcRootFolder, args.JarDestinationFolder, (args.AssembliesToUse == null) ? CreateFolderList(srcRootFolder) : args.AssembliesToUse, args.WithJARSource, args.EmbeddingJCOBridge);
                reportStr = string.Format("{0} Jars created in {1}.", jars, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(reportStr, failed));
            }
        }

        public static int CreateJars(string jdkFolder, string rootFolder, string originFolder, string destFolder, IEnumerable<string> assemblies, bool withSource, bool withEmbedding, int timeout = Timeout.Infinite)
        {
            var counter = 0;
            var manifestTemplate = Const.Templates.GetTemplate(Const.Templates.ManifestTemplate);
            StringBuilder sb = new StringBuilder(manifestTemplate);
            foreach (var item in assemblies)
            {
                if (item.Contains(Const.FileNameAndDirectory.CommonDirectory)) continue; // bypass for class-path build

                var resName = CreateSingleJar(jdkFolder, rootFolder, originFolder, item, JarType.Compiled, destFolder, timeout, withEmbedding);
                if (!string.IsNullOrEmpty(resName))
                {
                    var str = string.Format(" {0} ", string.Format(Const.FileNameAndDirectory.CompiledPattern, resName));
                    sb.AppendLine(str);
                    counter++;
                }
                if (withSource)
                {
                    CreateSingleJar(jdkFolder, rootFolder, originFolder, item, JarType.Source, destFolder, timeout, false);
                    counter++;
                }
            }
            sb.AppendLine();
            var manifestStr = sb.ToString();
            manifestStr = manifestStr.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);
            var manifestFileName = Path.Combine(originFolder, Const.FileNameAndDirectory.ManifestFile);
            File.WriteAllText(manifestFileName, manifestStr);

            var reflectorPath = Path.Combine(rootFolder, Const.FileNameAndDirectory.RootDirectory, Const.FileNameAndDirectory.SourceDirectory);

            CreateSingleJar(jdkFolder, rootFolder, reflectorPath, Const.FileNameAndDirectory.CommonDirectory, JarType.Compiled, destFolder, timeout, withEmbedding, manifestFileName);
            counter++;
            if (withSource)
            {
                CreateSingleJar(jdkFolder, rootFolder, reflectorPath, Const.FileNameAndDirectory.CommonDirectory, JarType.Source, destFolder, timeout, withEmbedding);
                counter++;
            }
            return counter;
        }

        static string CreateSingleJar(string jdkFolder, string rootFolder, string originFolder, string pathName, JarType type, string destinationFolder, int timeout, bool withEmbedding, string manifestFile = null)
        {
            string filter = string.Empty;
            string patternName = string.Empty;
            string fileWithNames = string.Empty;
            switch (type)
            {
                case JarType.Compiled:
                    filter = Const.FileNameAndDirectory.CompiledFilter;
                    patternName = Const.FileNameAndDirectory.CompiledPattern;
                    fileWithNames = Const.FileNameAndDirectory.CompiledFile;
                    break;
                case JarType.Source:
                    filter = Const.FileNameAndDirectory.SourceFilter;
                    patternName = Const.FileNameAndDirectory.SourcePattern;
                    fileWithNames = Const.FileNameAndDirectory.SourceFile;
                    break;
                default: throw new InvalidOperationException();
            }

            var assemblyName = pathName.Replace(Const.Framework.RuntimeFolder, string.Empty);
            assemblyName = assemblyName.Replace("\\", string.Empty);
            assemblyName = assemblyName.Replace("/", string.Empty);
            var destinationJar = string.Format(patternName, assemblyName);
            destinationJar = Path.Combine(destinationFolder, destinationJar);
            var searchPath = Path.Combine(originFolder, pathName);
            searchPath = Path.GetFullPath(searchPath);
            StringBuilder sb = new StringBuilder();
            foreach (var item in Directory.EnumerateFiles(searchPath, filter, SearchOption.AllDirectories))
            {
                var fileName = Path.GetFullPath(item);
                fileName = fileName.Replace(searchPath, ".");
                sb.AppendLine(fileName);
            }

            if (withEmbedding && !string.IsNullOrEmpty(manifestFile)) // we are making JCOReflector.jar
            {
                var jcoBridgeEmbeddedFile = Path.Combine(searchPath, Const.FileNameAndDirectory.OrgSubDirectory,
                                                                     Const.FileNameAndDirectory.MasesSubDirectory,
                                                                     Const.FileNameAndDirectory.JCOBridgeSubDirectory,
                                                                     Const.FileNameAndDirectory.NetreflectionSubDirectory, 
                                                                     Const.FileNameAndDirectory.JCOBridgeEmbeddedFile);

                var frameworkPath = Path.Combine(rootFolder, Const.FileNameAndDirectory.BinDirectory, Const.Framework.RuntimeFolder);
                var localArchive = Path.Combine(frameworkPath, Const.FileNameAndDirectory.JCOBridgeEmbeddedFile);
                if (File.Exists(localArchive)) File.Delete(localArchive);
                using (var archive = System.IO.Compression.ZipFile.Open(localArchive, System.IO.Compression.ZipArchiveMode.Create))
                {
                    foreach (var item in Const.FileNameAndDirectory.JCOBridgeFiles)
                    {
                        System.IO.Compression.ZipArchiveEntry entry = archive.CreateEntry(item, System.IO.Compression.CompressionLevel.Optimal);
                        using (StreamWriter writer = new StreamWriter(entry.Open()))
                        {
                            byte[] buffer = File.ReadAllBytes(Path.Combine(frameworkPath, item));
                            writer.BaseStream.Write(buffer, 0, buffer.Length);
                        }
                    }
                }
                if (File.Exists(jcoBridgeEmbeddedFile)) File.Delete(jcoBridgeEmbeddedFile);
                File.Move(localArchive, jcoBridgeEmbeddedFile);

                if (!File.Exists(jcoBridgeEmbeddedFile))
                {
                    throw new InvalidOperationException(string.Format("Unable to find {0}", jcoBridgeEmbeddedFile));
                }

                var fileName = Path.GetFullPath(jcoBridgeEmbeddedFile);
                fileName = fileName.Replace(searchPath, ".");
                sb.AppendLine(fileName);
            }

            var outputStr = sb.ToString();
            if (string.IsNullOrEmpty(outputStr)) return string.Empty; // discard empty folders

            File.WriteAllText(Path.Combine(searchPath, fileWithNames), sb.ToString());

            string jarParam = (logLevel > LogLevel.Info) ? "cvf" : "cf";
            if (string.IsNullOrEmpty(manifestFile))
            {
                launchProcess(searchPath, Path.Combine(jdkFolder, JarCompiler), jarParam + " " + destinationJar + " @" + fileWithNames, timeout);
            }
            else
            {
                launchProcess(searchPath, Path.Combine(jdkFolder, JarCompiler), jarParam + "m " + destinationJar + " " + manifestFile + " @" + fileWithNames, timeout);
            }
            return assemblyName;
        }

        static string errorData = string.Empty;
        static string outputData = string.Empty;

        static void launchProcess(string workingDir, string processToLaunch, string arguments, int timeout = Timeout.Infinite)
        {
            DateTime dtStart = DateTime.Now;
            AppendToConsole(LogLevel.Info, "Starting operation {0} {1} with {2} seconds of timeout at {3}.", processToLaunch, arguments, timeout, dtStart);

            errorData = outputData = string.Empty;
            var tmpDirectory = Environment.CurrentDirectory;
            try
            {
                Environment.CurrentDirectory = workingDir;
                ProcessStartInfo startInfo = new ProcessStartInfo();
                startInfo.FileName = processToLaunch;
                startInfo.Arguments = arguments;
                startInfo.CreateNoWindow = true;
                startInfo.WorkingDirectory = workingDir;
                if (logLevel == LogLevel.Verbose)
                {
                    startInfo.RedirectStandardOutput = true;
                }
                startInfo.RedirectStandardError = true;
                startInfo.UseShellExecute = false;
                using (var proc = Process.Start(startInfo))
                {
                    proc.ErrorDataReceived += Proc_ErrorDataReceived;
                    proc.BeginErrorReadLine();
                    if (logLevel == LogLevel.Verbose)
                    {
                        proc.OutputDataReceived += Proc_OutputDataReceived;
                        proc.BeginOutputReadLine();
                    }

                    try
                    {
                        if (timeout == Timeout.Infinite)
                        {
                            while (!proc.WaitForExit(1000))
                            {
                                CancellationToken.ThrowIfCancellationRequested();
                            }
                        }
                        else if (!proc.WaitForExit(timeout * 1000))
                        {
                            AppendToConsole(LogLevel.Warning, "Timeout on operation {0} {1}. Killing it.", processToLaunch, arguments);
                            proc.Kill();
                        }
                    }
                    catch (OperationCanceledException oce)
                    {
                        try
                        {
                            proc.Kill();
                        }
                        catch (Exception ex)
                        {
                            AppendToConsole(LogLevel.Error, "Error killing job: {0}", ex.Message);
                        }

                        AppendToConsole(LogLevel.Error, "Error executing job: {0}", oce.Message);
                    }
                    catch (Exception ex)
                    {
                        AppendToConsole(LogLevel.Error, "Error executing job: {0}", ex.Message);
                    }
                    finally
                    {
                        proc.ErrorDataReceived -= Proc_ErrorDataReceived;
                        if (logLevel == LogLevel.Verbose)
                        {
                            proc.OutputDataReceived -= Proc_OutputDataReceived;
                        }

                        if (!string.IsNullOrEmpty(outputData))
                        {
                            AppendToConsole(LogLevel.Error, outputData);
                        }

                        if (!string.IsNullOrEmpty(errorData) && errorData != Environment.NewLine)
                        {
                            errorData = errorData.Replace("{", "{{").Replace("}", "}}");
                            AppendToConsole(LogLevel.Error, errorData);
                        }
                    }
                }
            }
            finally
            {
                AppendToConsole(LogLevel.Info, "End operation {0} {1} with {2} seconds of timeout, elapsed {3}.", processToLaunch, arguments, timeout, DateTime.Now - dtStart);
                Environment.CurrentDirectory = tmpDirectory;
            }
        }

        private static void Proc_OutputDataReceived(object sender, DataReceivedEventArgs e)
        {
            outputData += e.Data + Environment.NewLine;
        }

        private static void Proc_ErrorDataReceived(object sender, DataReceivedEventArgs e)
        {
            errorData += e.Data + Environment.NewLine;
        }
    }
}
