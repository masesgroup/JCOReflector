/*
 *  MIT License
 *
 *  Copyright (c) 2022 MASES s.r.l.
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

namespace MASES.JCOReflectorEngine
{
    static class JavaBuilder
    {
        enum JarType
        {
            Source, Compiled
        }

        static string JavaCompiler = Path.Combine("bin", "javac");
        static string JavaDoc = Path.Combine("bin", "javadoc");
        static string JarCompiler = Path.Combine("bin", "jar");

        public static void CompileClasses(object o)
        {
            Exception storedException = null;
            bool failed = false;
            JavaBuilderEventArgs args = o as JavaBuilderEventArgs;

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

                var srcRootFolder = args.SplitFolderByAssembly ? Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory) : args.SourceFolder;
                var classes = CreateSourceListAndCompile(args.JDKFolder, args.JDKTarget, args.JDKToolExtraOptions, args.RootFolder, srcRootFolder, (args.AssembliesToUse == null) ? JobManager.CreateFolderList(srcRootFolder) : args.AssembliesToUse, Timeout.Infinite);
                reportStr = string.Format("Compilation of {0} classes done in {1}.", classes, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                storedException = ex;
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
                storedException = ex;
            }
            finally
            {
                if (JobManager.ErrorReporting.HasFlag(ErrorReportingType.Callback))
                {
                    JobManager.EndOperation(new EndOperationEventArgs(reportStr, failed));
                }
                if (storedException != null && JobManager.ErrorReporting.HasFlag(ErrorReportingType.Exception))
                {
                    throw storedException;
                }
            }
        }

        public static void GenerateDocs(object o)
        {
            Exception storedException = null;
            bool failed = false;
            DocsBuilderEventArgs args = o as DocsBuilderEventArgs;

            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                if (string.IsNullOrEmpty(args.CommitVersion))
                {
                    throw new ArgumentException("Commit version must be set when docs are generated.");
                }

                if (!Path.IsPathRooted(args.SourceFolder))
                {
                    args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
                }

                if (!Path.IsPathRooted(args.JDKFolder))
                {
                    args.JDKFolder = Path.Combine(args.RootFolder, args.JDKFolder);
                }

                var srcRootFolder = args.SplitFolderByAssembly ? Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory) : args.SourceFolder;
                string destinationFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.DocsDirectory);
                var classes = CreateSourceListAndGenerateDocs(args.JDKFolder, args.JDKTarget, args.JDKToolExtraOptions, args.RootFolder, srcRootFolder, destinationFolder, args.CommitVersion, (args.AssembliesToUse == null) ? JobManager.CreateFolderList(srcRootFolder) : args.AssembliesToUse, Timeout.Infinite);
                reportStr = string.Format("Javadoc of {0} classes done in {1}.", classes, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                storedException = ex;
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
                storedException = ex;
            }
            finally
            {
                if (JobManager.ErrorReporting.HasFlag(ErrorReportingType.Callback))
                {
                    JobManager.EndOperation(new EndOperationEventArgs(reportStr, failed));
                }
                if (storedException != null && JobManager.ErrorReporting.HasFlag(ErrorReportingType.Exception))
                {
                    throw storedException;
                }
            }
        }

        static int CreateSourceListAndCompile(string jdkFolder, JDKVersion jdkTarget, string toolExtraOptions, string rootFolder, string originFolder, IEnumerable<string> assemblies, int timeout)
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
            var extraOptions = string.IsNullOrEmpty(toolExtraOptions) ? string.Empty : string.Format(" {0} ", toolExtraOptions);
            if (jdkTarget == JDKVersion.NotSet)
            {
                launchProcess(originFolder, Path.Combine(jdkFolder, JavaCompiler), "-cp " + jcoBridgeCp + extraOptions + " @" + Const.FileNameAndDirectory.SourceFile, timeout);
            }
            else
            {
                string compatibility = string.Format(" -source {0} -target {0}", (int)jdkTarget); // -bootclasspath rt{0}.jar
                launchProcess(originFolder, Path.Combine(jdkFolder, JavaCompiler), "-cp " + jcoBridgeCp + compatibility + extraOptions + " @" + Const.FileNameAndDirectory.SourceFile, timeout);
            }
            return counter;
        }

        static int CreateSourceListAndGenerateDocs(string jdkFolder, JDKVersion jdkTarget, string toolExtraOptions, string rootFolder, string originFolder, string destinationFolder, string commitVersion, IEnumerable<string> assemblies, int timeout)
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
            var extraOptions = string.IsNullOrEmpty(toolExtraOptions) ? string.Empty : string.Format(" {0} ", toolExtraOptions);
            var header = Const.Documentation.DOCS_HEADER.Replace(Const.Documentation.DOCS_VERSION_JCOREFLECTOR_PLACEHOLDER, string.Format("v{0}-{1}", Const.ReflectorVersion, commitVersion));
            launchProcess(originFolder, Path.Combine(jdkFolder, JavaDoc), "-header \"" + header + "\" -quiet -author -noindex -nodeprecated -nodeprecatedlist -notimestamp -nohelp -notree -public -cp " + jcoBridgeCp + " -d " + destinationFolder + extraOptions + " -link https://www.jcobridge.com/api-java @" + Const.FileNameAndDirectory.SourceFile, timeout);

            return counter;
        }

        public static void CreatePOM(object o)
        {
            Exception storedException = null;
            bool failed = false;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                POMBuilderEventArgs args = o as POMBuilderEventArgs;

                if (!Path.IsPathRooted(args.SourceFolder))
                {
                    args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
                }

                if (args.POMType == POMType.Frameworks)
                {
                    Const.FileNameAndDirectory.CreateJCOBridgeZip(args.RootFolder);
                }

                var srcRootFolder = args.SplitFolderByAssembly ? Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory) : args.SourceFolder;
                var assembliesToUse = (args.AssembliesToUse == null) ? JobManager.CreateFolderList(srcRootFolder, false) : args.AssembliesToUse;
                StringBuilder sb = new StringBuilder();
                foreach (var item in assembliesToUse)
                {
                    sb.AppendFormat(Const.POM.POM_JCOREFLECTOR_SOURCE_PLACEHOLDER, item);
                    sb.AppendLine();
                }
                var sourceFlders = sb.ToString();
                //sourceFlders = sourceFlders.Remove(sourceFlders.LastIndexOf(','));
                sourceFlders = sourceFlders.Replace('\\', '/');
                string jcoPomTemplate = string.Empty;
                if (args.POMType == POMType.Extension && !string.IsNullOrEmpty(args.POMFileName))
                {
                    jcoPomTemplate = File.ReadAllText(args.POMFileName);
                }
                else
                {
                    jcoPomTemplate = Const.Templates.GetTemplate((args.POMType == POMType.Frameworks) ? Const.Templates.POMJCOReflector : Const.Templates.POMExtension);
                }

                var jcoPom = jcoPomTemplate.Replace(Const.POM.POM_VERSION_PLACEHOLDER, args.POMVersion + ((args.POMStagingType == POMStagingType.Snapshot) ? Const.POM.POM_VERSION_SNAPSHOT : string.Empty))
                                           .Replace(Const.POM.POM_RUNTIME_PLACEHOLDER, Const.Framework.RuntimeFolder)
                                           .Replace(Const.POM.POM_JDK_TARGET, ((int)args.JDKTarget).ToString())
                                           .Replace(Const.POM.POM_SOURCEDIRECTORIES_PLACEHOLDER, sourceFlders)
                                           .Replace(Const.POM.POM_ARTIFACTID_PLACEHOLDER, args.POMArtifactId)
                                           .Replace(Const.POM.POM_NAME_PLACEHOLDER, args.POMName)
                                           .Replace(Const.POM.POM_DESCRIPTION_PLACEHOLDER, args.POMDescription)
                                           .Replace(Const.POM.POM_JCOREFLECTOR_VERSION_PLACEHOLDER, Const.ReflectorVersion)
                                           .Replace(Const.POM.POM_ADDITIONAL_DEPENDENCIES_PLACEHOLDER, args.POMAdditionalDependencies ?? string.Empty);

                var fileName = Path.Combine(srcRootFolder, string.Format("{0}.xml", Const.Framework.RuntimeFolder));
                File.WriteAllText(fileName, jcoPom);
                reportStr = string.Format("{0} POM created in {1}.", fileName, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                storedException = ex;
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
                storedException = ex;
            }
            finally
            {
                if (JobManager.ErrorReporting.HasFlag(ErrorReportingType.Callback))
                {
                    JobManager.EndOperation(new EndOperationEventArgs(reportStr, failed));
                }
                if (storedException != null && JobManager.ErrorReporting.HasFlag(ErrorReportingType.Exception))
                {
                    throw storedException;
                }
            }
        }

        public static void ExtractPOM(object o)
        {
            Exception storedException = null;
            bool failed = false;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                POMBuilderEventArgs args = o as POMBuilderEventArgs;

                var jcoPomTemplate = Const.Templates.GetTemplate(Const.Templates.POMExtension);
                File.WriteAllText(args.POMFileName, jcoPomTemplate);
                reportStr = string.Format("{0} POM created in {1}.", args.POMFileName, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                storedException = ex;
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
                storedException = ex;
            }
            finally
            {
                if (JobManager.ErrorReporting.HasFlag(ErrorReportingType.Callback))
                {
                    JobManager.EndOperation(new EndOperationEventArgs(reportStr, failed));
                }
                if (storedException != null && JobManager.ErrorReporting.HasFlag(ErrorReportingType.Exception))
                {
                    throw storedException;
                }
            }
        }

        public static void CreateJars(object o)
        {
            Exception storedException = null;
            bool failed = false;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                JARBuilderEventArgs args = o as JARBuilderEventArgs;

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

                var srcRootFolder = args.SplitFolderByAssembly ? Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory) : args.SourceFolder;
                var jars = CreateJars(args.JDKFolder, args.RootFolder, srcRootFolder, args.JarDestinationFolder, (args.AssembliesToUse == null) ? JobManager.CreateFolderList(srcRootFolder) : args.AssembliesToUse, args.WithJARSource, args.EmbeddingJCOBridge);
                reportStr = string.Format("{0} Jars created in {1}.", jars, DateTime.Now - dtStart);
            }
            catch (OperationCanceledException ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                storedException = ex;
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, reportStr);
                failed = true;
                storedException = ex;
            }
            finally
            {
                if (JobManager.ErrorReporting.HasFlag(ErrorReportingType.Callback))
                {
                    JobManager.EndOperation(new EndOperationEventArgs(reportStr, failed));
                }
                if (storedException != null && JobManager.ErrorReporting.HasFlag(ErrorReportingType.Exception))
                {
                    throw storedException;
                }
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
            manifestStr = manifestStr.Replace(Const.Class.JCOREFLECTOR_VERSION, Const.ReflectorVersion);
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

                var localArchive = Const.FileNameAndDirectory.CreateJCOBridgeZip(rootFolder);

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

            string jarParam = (JobManager.LogLevel > LogLevel.Info) ? "cvf" : "cf";
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
            JobManager.AppendToConsole(LogLevel.Info, "Starting operation {0} {1} with {2} seconds of timeout at {3}.", processToLaunch, arguments, timeout, dtStart);

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
                if (JobManager.LogLevel == LogLevel.Verbose)
                {
                    startInfo.RedirectStandardOutput = true;
                }
                startInfo.RedirectStandardError = true;
                startInfo.UseShellExecute = false;
                using (var proc = Process.Start(startInfo))
                {
                    proc.ErrorDataReceived += Proc_ErrorDataReceived;
                    proc.BeginErrorReadLine();
                    if (JobManager.LogLevel == LogLevel.Verbose)
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
                                JobManager.CancellationToken.ThrowIfCancellationRequested();
                            }
                        }
                        else if (!proc.WaitForExit(timeout * 1000))
                        {
                            JobManager.AppendToConsole(LogLevel.Warning, "Timeout on operation {0} {1}. Killing it.", processToLaunch, arguments);
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
                            JobManager.AppendToConsole(LogLevel.Error, "Error killing job: {0}", ex.Message);
                        }

                        JobManager.AppendToConsole(LogLevel.Error, "Error executing job: {0}", oce.Message);
                    }
                    catch (Exception ex)
                    {
                        JobManager.AppendToConsole(LogLevel.Error, "Error executing job: {0}", ex.Message);
                    }
                    finally
                    {
                        proc.ErrorDataReceived -= Proc_ErrorDataReceived;
                        if (JobManager.LogLevel == LogLevel.Verbose)
                        {
                            proc.OutputDataReceived -= Proc_OutputDataReceived;
                        }

                        if (!string.IsNullOrEmpty(outputData))
                        {
                            JobManager.AppendToConsole(LogLevel.Error, outputData);
                        }

                        if (!string.IsNullOrEmpty(errorData) && errorData != Environment.NewLine)
                        {
                            errorData = errorData.Replace("{", "{{").Replace("}", "}}");
                            JobManager.AppendToConsole(LogLevel.Error, errorData);
                        }
                    }
                }
            }
            finally
            {
                JobManager.AppendToConsole(LogLevel.Info, "End operation {0} {1} with {2} seconds of timeout, elapsed {3}.", processToLaunch, arguments, timeout, DateTime.Now - dtStart);
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
