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
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Threading;

namespace MASES.C2JReflector
{
    #region AssemblyData Class
    /// <summary>
    /// The single AssemblyData.
    /// </summary>
    public class AssemblyData : INotifyPropertyChanged
    {
        #region Constructors
        /// <summary>
        /// The default constructor.
        /// </summary>
        public AssemblyData()
        {
            Initialize();
        }

        /// <summary>
        /// The default constructor.
        /// </summary>
        public AssemblyData(string folderName)
        {
            Initialize();

        }

        /// <summary>
        /// Sets private members to default values.
        /// </summary>
        private void Initialize()
        {
        }
        #endregion

        #region Persistent Properties
        bool isSelected;
        /// <summary>
        /// The IsSelected
        /// </summary>
        public bool IsSelected
        {
            get { return isSelected; }
            set
            {
                isSelected = value;
                if (AssemblyFullName == Const.FileNameAndDirectory.CommonDirectory) isSelected = true;
                EmitPropertyChanged("IsSelected");
            }
        }
        string framework;
        /// <summary>
        /// The Framework
        /// </summary>
        public string Framework { get { return framework; } set { framework = value; EmitPropertyChanged("Framework"); } }
        string assemblyFullName;
        /// <summary>
        /// The AssemblyFullName
        /// </summary>
        public string AssemblyFullName { get { return assemblyFullName; } set { assemblyFullName = value; EmitPropertyChanged("AssemblyFullName"); } }
        string folderName;
        /// <summary>
        /// The FolderName
        /// </summary>
        public string FolderName { get { return folderName; } set { folderName = value; EmitPropertyChanged("FolderName"); } }
        IList<string> referencedAssemblies = null;
        /// <summary>
        /// The ReferencedAssemblies
        /// </summary>
        public IList<string> ReferencedAssemblies { get { return referencedAssemblies; } set { referencedAssemblies = value; EmitPropertyChanged("ReferencedAssemblies"); } }
        #endregion

        #region Private Fields
        #endregion

        protected void EmitPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged.Invoke(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
    #endregion

    #region UserNodeIdCollection Class
    /// <summary>
    /// A collection of Manager objects.
    /// </summary>
    public partial class AssemblyDataCollection : ObservableCollection<AssemblyData>
    {
        /// <summary>
        /// Initializes an empty collection.
        /// </summary>
        public AssemblyDataCollection() { }

        /// <summary>
        /// Initializes the collection from another collection.
        /// </summary>
        /// <param name="collection">A collection of values to add to this new collection</param>
        /// <exception cref="T:System.ArgumentNullException">
        /// 	<paramref name="collection"/> is null.
        /// </exception>
        public AssemblyDataCollection(IEnumerable<AssemblyData> collection) : base(collection) { }

        /// <summary>
        /// Initializes the collection with the specified capacity.
        /// </summary>
        /// <param name="capacity">The capacity.</param>
        public AssemblyDataCollection(List<AssemblyData> capacity) : base(capacity) { }
    }
    #endregion

    public class JavaBuilderEventArgs : EventArgs
    {
        public LogLevel LogLevel { get; set; }
        public string JDKFolder { get; set; }
        public JDKVersion JDKTarget { get; set; }
        public string OriginFolder { get; set; }
        public string DestinationFolder { get; set; }
        public bool SplitFolderByAssembly { get; set; }
        public IList<string> AssembliesToUse { get; set; }
    }

    public static class JavaBuilder
    {
        enum JarType
        {
            Source, Compiled
        }

        const string JavaCompiler = @"bin\javac.exe";
        const string JarCompiler = @"bin\jar.exe";

        public static appendToConsoleHandler AppendToConsoleHandler;
        public static EventHandler<EndOperationEventArgs> EndOperationHandler;

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
            JavaBuilderEventArgs args = o as JavaBuilderEventArgs;

            logLevel = args.LogLevel;
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                var classes = CreateSourceListAndCompile(args.JDKFolder, args.JDKTarget, args.OriginFolder, (args.AssembliesToUse == null) ? CreateFolderList(args.OriginFolder) : args.AssembliesToUse, Timeout.Infinite);
                reportStr = string.Format("Compilation of {0} classes done in {1}.", classes, DateTime.Now - dtStart);
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(reportStr));
            }
        }

        public static AssemblyDataCollection CreateFolderList(object o)
        {
            JavaBuilderEventArgs args = o as JavaBuilderEventArgs;
            logLevel = args.LogLevel;

            string jdkFolder = args.JDKFolder;
            string originFolder = args.OriginFolder;
            bool splitFolder = args.SplitFolderByAssembly;

            try
            {
                var folders = CreateFolderList(args.OriginFolder);
                AssemblyDataCollection coll = new AssemblyDataCollection();
                foreach (var folder in folders)
                {
                    AssemblyData data = new AssemblyData();
                    if (folder.Equals(Const.FileNameAndDirectory.CommonDirectory))
                    {
                        data.IsSelected = true;
                        data.Framework = Const.Framework.All;
                        data.AssemblyFullName = folder;
                        data.FolderName = folder;
                    }
                    else
                    {
#if NET_CORE
                        var relFolder = Const.Framework.NETCoreFolder;
#else
                        var relFolder = Const.Framework.NETFrameworkFolder;
#endif
                        data.AssemblyFullName = folder;
                        data.FolderName = Path.Combine(relFolder, folder);
#if NET_CORE
                        data.Framework = Const.Framework.NETCore;
#else
                        data.Framework = Const.Framework.NETFramework;
#endif
#if ENABLE_REFERENCE_BUILDER
                        var refPath = Path.Combine(args.OriginFolder, relFolder, folder, Const.FileNameAndDirectory.ReferencesFile);
                        var refData = File.ReadAllLines(refPath);
                        data.ReferencedAssemblies = new List<string>(refData);
#endif
                    }
                    coll.Add(data);
                }
                return coll;
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "Error {0}", ex.Message);
                return new AssemblyDataCollection();
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(string.Empty));
            }
        }

        static IEnumerable<string> CreateFolderList(string originFolder)
        {
            originFolder = Path.GetFullPath(originFolder);
            List<string> dirs = new List<string>();
            dirs.Add(Const.FileNameAndDirectory.CommonDirectory);
#if NET_CORE
            originFolder = Path.Combine(originFolder, Const.Framework.NETCoreFolder);
#else
            originFolder = Path.Combine(originFolder, Const.Framework.NETFrameworkFolder);
#endif
            foreach (var item in Directory.EnumerateDirectories(originFolder))
            {
                var path = Path.GetFullPath(item);
                path = path.Replace(originFolder, string.Empty);
                path = path.Replace("\\", string.Empty);
                dirs.Add(path);
            }

            return dirs;
        }

        static int CreateSourceListAndCompile(string jdkFolder, JDKVersion jdkTarget, string originFolder, IEnumerable<string> assemblies, int timeout)
        {
            int counter = 0;
            var tmpFile = Path.Combine(originFolder, Const.FileNameAndDirectory.SourceFile);

            StringBuilder sb = new StringBuilder();
            foreach (var assembly in assemblies)
            {
                foreach (var item in Directory.EnumerateFiles(Path.Combine(originFolder, assembly), "*.java", SearchOption.AllDirectories))
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

        public static void CreateJars(object o)
        {
            DateTime dtStart = DateTime.Now;
            string reportStr = string.Empty;
            try
            {
                JavaBuilderEventArgs args = o as JavaBuilderEventArgs;
                logLevel = args.LogLevel;

                var jars = CreateJars(args.JDKFolder, args.OriginFolder, args.DestinationFolder, (args.AssembliesToUse == null) ? CreateFolderList(args.OriginFolder) : args.AssembliesToUse);
                reportStr = string.Format("{0} Jars created in {1}.", jars, DateTime.Now - dtStart);
            }
            catch (Exception ex)
            {
                reportStr = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, reportStr);
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(reportStr));
            }
        }

        public static int CreateJars(string jdkFolder, string originFolder, string destFolder, IEnumerable<string> assemblies, int timeout = Timeout.Infinite)
        {
            var counter = 0;
            var location = typeof(JavaBuilder).Assembly.Location;
            location = Path.GetDirectoryName(location);
            location = Path.Combine(location, Const.Templates.ManifestTemplate);
            var manifestTemplate = File.ReadAllText(location);
            StringBuilder sb = new StringBuilder(manifestTemplate);
            foreach (var item in assemblies)
            {
                if (item.Contains(Const.FileNameAndDirectory.CommonDirectory)) continue; // bypass for class-path build

                var resName = CreateSingleJar(jdkFolder, originFolder, item, JarType.Compiled, destFolder, timeout);
                if (!string.IsNullOrEmpty(resName))
                {
                    var str = string.Format(" {0} ", string.Format(Const.FileNameAndDirectory.CompiledPattern, resName));
                    sb.AppendLine(str);
                    counter++;
                }
                CreateSingleJar(jdkFolder, originFolder, item, JarType.Source, destFolder, timeout);
                counter++;
            }
            sb.AppendLine();
            var manifestStr = sb.ToString();
            manifestStr = manifestStr.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);
            var manifestFileName = Path.Combine(originFolder, Const.FileNameAndDirectory.ManifestFile);
            File.WriteAllText(manifestFileName, manifestStr);

            CreateSingleJar(jdkFolder, originFolder, Const.FileNameAndDirectory.CommonDirectory, JarType.Compiled, destFolder, timeout, manifestFileName);
            counter++;
            CreateSingleJar(jdkFolder, originFolder, Const.FileNameAndDirectory.CommonDirectory, JarType.Source, destFolder, timeout);
            counter++;

            return counter;
        }

        static string CreateSingleJar(string jdkFolder, string originFolder, string pathName, JarType type, string destinationFolder, int timeout, string manifestFile = null)
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

#if NET_CORE
            var assemblyName = pathName.Replace(Const.Framework.NETCoreFolder, string.Empty);
#else
            var assemblyName = pathName.Replace(Const.Framework.NETFrameworkFolder, string.Empty);
#endif
            assemblyName = assemblyName.Replace("\\", string.Empty);
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

            var outputStr = sb.ToString();
            if (string.IsNullOrEmpty(outputStr)) return string.Empty; // discard empty folders

            File.WriteAllText(Path.Combine(searchPath, fileWithNames), sb.ToString());
            if (string.IsNullOrEmpty(manifestFile))
            {
                launchProcess(searchPath, Path.Combine(jdkFolder, JarCompiler), "cvf " + destinationJar + " @" + fileWithNames, timeout);
            }
            else
            {
                launchProcess(searchPath, Path.Combine(jdkFolder, JarCompiler), "cvfm " + destinationJar + " " + manifestFile + " @" + fileWithNames, timeout);
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
                            proc.WaitForExit();
                        }
                        else if (!proc.WaitForExit(timeout * 1000))
                        {
                            AppendToConsole(LogLevel.Warning, "Timeout on operation {0} {1}. Killing it.", processToLaunch, arguments);
                        }
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

                        if (!string.IsNullOrEmpty(errorData))
                        {
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
