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
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace MASES.C2JReflector
{
    public static class Reflector
    {
        static List<string> assemblyReferenced = new List<string>();
        static List<string> assemblyParsed = new List<string>();
        public static appendToConsoleHandler AppendToConsoleHandler;
        public static EventHandler<EndOperationEventArgs> EndOperationHandler;

        static CancellationToken CancellationToken;

        static bool EnableWrite = true;

        static bool EnableAbstract = true;
        static bool EnableArray = true;
        static bool EnableDuplicateMethodNativeArrayWithJCRefOut = true;
        static bool EnableInheritance = false;
        static bool EnableInterfaceInheritance = false;

        static LogLevel LogLevel;
        static string SrcDestinationFolder;
        static string CsvDestinationFolder;
        static bool SplitByAssembly;
        static bool ForceRebuild;
        static bool UseParallelBuild;
        static bool CreateExceptionThrownClause;
        static int ExceptionThrownClauseDepth;

        static long loadedAssemblies = 0;
        static long parsedAssemblies = 0;
        static long discardedTypes = 0;
        static long analyzedTypes = 0;
        static long discardedNonPublicTypes = 0;
        static long discardedGenericTypes = 0;
        static long discardedInternalTypes = 0;
        static long implementedEnums = 0;
        static long implementedEnumsFlags = 0;
        static long analyzedEnumerators = 0;
        static long implementedEnumerators = 0;
        static long analyzedDelegates = 0;
        static long implementedDelegates = 0;
        static long implementedInterfaces = 0;
        static long implementedClasses = 0;
        static long implementedExceptions = 0;
        static long analyzedCtors = 0;
        static long implementedCtors = 0;
        static long implementedMethods = 0;
        static long implementedDuplicatedMethods = 0;
        static long analyzedMethods = 0;
        static long implementedProperties = 0;
        static long analyzedProperties = 0;
        static long implementedEvents = 0;
        static long analyzedEvents = 0;

        static void AppendToConsole(LogLevel level, string format, params object[] args)
        {
            if (LogLevel >= level && AppendToConsoleHandler != null)
            {
                AppendToConsoleHandler(format, args);
            }
        }

        static string reflectorVersion = typeof(Reflector).Assembly.GetName().Version.ToString();

        static string checkForkeyword(string inputName)
        {
            foreach (var item in Const.KeyWords)
            {
                if (inputName == item) return "_" + item;
            }

            return inputName;
        }

        public static void ResetStatistics()
        {
            assemblyReferenced.Clear();
            assemblyParsed.Clear();
            loadedAssemblies = 0;
            parsedAssemblies = 0;
            analyzedTypes = 0;
            discardedTypes = 0;
            discardedNonPublicTypes = 0;
            discardedGenericTypes = 0;
            discardedInternalTypes = 0;
            implementedEnums = 0;
            implementedEnumsFlags = 0;
            analyzedEnumerators = 0;
            implementedEnumerators = 0;
            analyzedDelegates = 0;
            implementedDelegates = 0;
            implementedInterfaces = 0;
            implementedClasses = 0;
            implementedExceptions = 0;
            analyzedCtors = 0;
            implementedCtors = 0;
            implementedMethods = 0;
            implementedDuplicatedMethods = 0;
            analyzedMethods = 0;
            implementedProperties = 0;
            analyzedProperties = 0;
            implementedEvents = 0;
            analyzedEvents = 0;
        }

        static bool WriteStatisticsCsv(string csvString)
        {
            bool res = true;
            try
            {
                if (csvString != null)
                {
                    string csvFileName = string.Empty;

                    if (!Directory.Exists(CsvDestinationFolder)) Directory.CreateDirectory(CsvDestinationFolder);
                    csvFileName = Path.GetFullPath(Path.Combine(CsvDestinationFolder, Const.Framework.RuntimeFolder, Const.FileNameAndDirectory.StatisticsFilename));
                    File.WriteAllText(csvFileName, csvString);
                }
            }
            catch (Exception ex)
            {
                string errorString = string.Format("Error writing csv files {0}", ex.Message);
                AppendToConsole(LogLevel.Error, errorString);
                res = false;
            }
            return res;
        }
        static string GetStatisticsCsv(out string errorString)
        {
            // Modification in the order and quantity of data shall be done also in 
            // the graph generator (google sheets)
            string res = String.Empty;
            errorString = null;
            try
            {
                StringBuilder sb = new StringBuilder();
                //add header
                sb.Append("parsedAssemblies;");
                sb.Append("analyzedTypes;");
                sb.Append("discardedTypes;");
                sb.Append("discardedNonPublicTypes;");
                sb.Append("discardedGenericTypes;");
                sb.Append("discardedInternalTypes;");
                sb.Append("implementedEnum ;");
                sb.Append("implementedEnumsFlags;");
                sb.Append("analyzedEnumerators;");
                sb.Append("implementedEnumerators;");
                sb.Append("analyzedDelegates;");
                sb.Append("implementedDelegates;");
                sb.Append("implementedInterfaces;");
                sb.Append("implementedClasses;");
                sb.Append("implementedExceptions;");
                sb.Append("analyzedCtors;");
                sb.Append("implementedCtors ;");
                sb.Append("analyzedMethods;");
                sb.Append("implementedMethods;");
                sb.Append("analyzedProperties;");
                sb.Append("implementedProperties;");
                sb.Append("analyzedEvents;");
                sb.Append("implementedEvents;");
                sb.Append("loadedAssemblies;");

                sb.AppendLine();
                //Add data
                sb.AppendFormat("{0};", parsedAssemblies);
                sb.AppendFormat("{0};", analyzedTypes);
                sb.AppendFormat("{0};", discardedTypes);
                sb.AppendFormat("{0};", discardedNonPublicTypes);
                sb.AppendFormat("{0};", discardedGenericTypes);
                sb.AppendFormat("{0};", discardedInternalTypes);
                sb.AppendFormat("{0};", implementedEnums);
                sb.AppendFormat("{0};", implementedEnumsFlags);
                sb.AppendFormat("{0};", analyzedEnumerators);
                sb.AppendFormat("{0};", implementedEnumerators);
                sb.AppendFormat("{0};", analyzedDelegates);
                sb.AppendFormat("{0};", implementedDelegates);
                sb.AppendFormat("{0};", implementedInterfaces);
                sb.AppendFormat("{0};", implementedClasses);
                sb.AppendFormat("{0};", implementedExceptions);
                sb.AppendFormat("{0};", analyzedCtors);
                sb.AppendFormat("{0};", implementedCtors);
                sb.AppendFormat("{0};", analyzedMethods);
                sb.AppendFormat("{0};", implementedMethods);
                sb.AppendFormat("{0};", analyzedProperties);
                sb.AppendFormat("{0};", implementedProperties);
                sb.AppendFormat("{0};", analyzedEvents);
                sb.AppendFormat("{0};", implementedEvents);
                sb.AppendFormat("{0};", loadedAssemblies);

                res = sb.ToString();
            }
            catch (Exception ex)
            {

                errorString = string.Format("CSV FILES NOT CREATED!!! Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, errorString);
            }
            return res;
        }

        static string GetReport(string[] assemblyNames)
        {
            string res = string.Empty;
            try
            {
                StringBuilder sb = new StringBuilder();
                sb.AppendLine("Parsed assemblies are:");
                foreach (var item in assemblyNames)
                {
                    sb.AppendLine(string.Format("* {0}", item));
                }
                sb.AppendLine();
                sb.AppendLine("> Analyzed Assemblies:");
                foreach (var item in assemblyReferenced)
                {
                    sb.AppendLine(string.Format("> * {0}", item));
                }
                sb.AppendLine();
                var implemented = implementedDelegates + implementedEnumerators + implementedInterfaces + implementedEnums + implementedClasses;
                sb.AppendFormat("> * Analyzed Types = {0}", analyzedTypes);
                sb.AppendLine();
                sb.AppendFormat(">   * Enumerators = {0}", analyzedEnumerators);
                sb.AppendLine();
                sb.AppendFormat(">   * Delegates = {0}", analyzedDelegates);
                sb.AppendLine();
                sb.AppendLine(">   * Classes");
                sb.AppendFormat(">     * Constructors = {0}", analyzedCtors);
                sb.AppendLine();
                sb.AppendFormat(">     * Methods = {0}", analyzedMethods);
                sb.AppendLine();
                sb.AppendFormat(">     * Properties = {0}", analyzedProperties);
                sb.AppendLine();
                sb.AppendFormat(">     * Events = {0}", analyzedEvents);
                sb.AppendLine();
                sb.AppendFormat("> * Implemented Types = {0}", implemented);
                sb.AppendLine();
                sb.AppendFormat(">   * Enumerators = {0}", implementedEnumerators);
                sb.AppendLine();
                sb.AppendFormat(">   * Delegates = {0}", implementedDelegates);
                sb.AppendLine();
                sb.AppendFormat(">   * Enums = {0}", implementedEnums);
                sb.AppendLine();
                sb.AppendFormat(">     * Flags = {0}", implementedEnumsFlags);
                sb.AppendLine();
                sb.AppendFormat(">   * Interfaces = {0}", implementedInterfaces);
                sb.AppendLine();
                sb.AppendFormat(">   * Classes = {0}", implementedClasses);
                sb.AppendLine();
                sb.AppendFormat(">     * Exceptions = {0}", implementedExceptions);
                sb.AppendLine();
                sb.AppendFormat(">     * Constructors = {0}", implementedCtors);
                sb.AppendLine();
                sb.AppendFormat(">     * Methods = {0}", implementedMethods);
                sb.AppendLine();
                sb.AppendFormat(">       * Duplicated Methods = {0}", implementedDuplicatedMethods);
                sb.AppendLine();
                sb.AppendFormat(">     * Properties = {0}", implementedProperties);
                sb.AppendLine();
                sb.AppendFormat(">     * Events = {0}", implementedEvents);
                sb.AppendLine();
                sb.AppendFormat("> * Discarded Types = {0}", discardedTypes);
                sb.AppendLine();
                sb.AppendFormat(">   * Non Public = {0}", discardedNonPublicTypes);
                sb.AppendLine();
                sb.AppendFormat(">   * Generic = {0}", discardedGenericTypes);
                sb.AppendLine();
                sb.AppendFormat(">   * Internals = {0}", discardedInternalTypes);
                sb.AppendLine();

                res = sb.ToString();
            }
            catch (Exception ex)
            {
                res = string.Format("Error {0}", ex.Message);
                AppendToConsole(LogLevel.Error, res);
            }
            return res;
        }

        public static async Task ExecuteAction(object o)
        {
            bool failed = false;
            List<Type> typesToExport = new List<Type>();
            ReflectorEventArgs args = o as ReflectorEventArgs;

            var location = typeof(JavaBuilder).Assembly.Location;
            location = Path.GetDirectoryName(location);
            Environment.CurrentDirectory = location;

            if (!Path.IsPathRooted(args.SrcDestinationFolder))
            {
                args.SrcDestinationFolder = Path.Combine(args.RootFolder, args.SrcDestinationFolder);
            }

            CancellationToken = args.CancellationToken;
            LogLevel = args.LogLevel;
            SrcDestinationFolder = Path.GetFullPath(Path.Combine(args.SrcDestinationFolder, Const.FileNameAndDirectory.SourceDirectory));
            CsvDestinationFolder = Path.GetFullPath(Path.Combine(args.SrcDestinationFolder, Const.FileNameAndDirectory.StatsDirectory));
            SplitByAssembly = args.SplitFolderByAssembly;
            ForceRebuild = args.ForceRebuild;
            UseParallelBuild = args.UseParallelBuild;
            CreateExceptionThrownClause = args.CreateExceptionThrownClause;
            ExceptionThrownClauseDepth = args.ExceptionThrownClauseDepth;
            EnableAbstract = args.EnableAbstract;
            EnableArray = args.EnableArray;
            EnableDuplicateMethodNativeArrayWithJCRefOut = args.EnableDuplicateMethodNativeArrayWithJCRefOut;
            EnableInheritance = args.EnableInheritance;
            EnableInterfaceInheritance = args.EnableInterfaceInheritance;// -- disabled due to issues in reflector engines (see https://github.com/masesgroup/JCOReflector/issues/6#issuecomment-686596662)
            EnableWrite = !args.DryRun;

            string reportStr = string.Empty;
            string statisticsCsv = string.Empty;
            try
            {
                foreach (var item in args.AssemblyNames)
                {
                    Assembly assembly = null;
                    if (File.Exists(item))
                    {
                        AppendToConsole(LogLevel.Info, "Loading assembly from path {0}", item);
                        assembly = Assembly.LoadFrom(item);
                    }
                    else
                    {
                        AppendToConsole(LogLevel.Info, "Loading assembly {0}", item);
                        assembly = Assembly.Load(item);
                    }

                    await ExportAssemblyWithReferences(assemblyReferenced, assemblyParsed, new AssemblyName(assembly.FullName), SrcDestinationFolder, SplitByAssembly, ForceRebuild);
                }

                reportStr = GetReport(args.AssemblyNames);
                var reportfile = Path.Combine(args.SrcDestinationFolder, Const.Report.REPORT_FILE_TO_WRITE);
                if (File.Exists(reportfile))
                {
                    var beginTag = string.Format(Const.Report.REPORT_BEGIN_PLACEHOLDER, Const.Framework.RuntimeFolder);
                    var endTag = string.Format(Const.Report.REPORT_END_PLACEHOLDER, Const.Framework.RuntimeFolder);
                    var readmeContent = File.ReadAllText(reportfile);

                    StringBuilder sb = new StringBuilder();
                    var preText = readmeContent.Substring(0, readmeContent.IndexOf(beginTag));
                    sb.Append(preText);
                    sb.AppendLine(beginTag);
                    sb.AppendLine(reportStr);
                    var endText = readmeContent.Substring(readmeContent.IndexOf(endTag));
                    sb.Append(endText);
                    File.WriteAllText(reportfile, sb.ToString());
                }

                string statisticsError;
                statisticsCsv = GetStatisticsCsv(out statisticsError);

                if (!String.IsNullOrEmpty(statisticsError))
                {
                    reportStr += statisticsError;
                }
                else if (!WriteStatisticsCsv(statisticsCsv))
                {
                    reportStr += "ERROR WRITING STATISTICS FILES" + Environment.NewLine;
                }
                else
                {
                    reportStr += "STATISTICS FILES CREATED OK" + Environment.NewLine;
                }
            }
            catch (OperationCanceledException ex)
            {
                AppendToConsole(LogLevel.Error, "ExportAssembly error: {0}", ex.Message);
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "ExportAssembly error: {0}", ex.Message);
                failed = true;
            }
            finally
            {
                EndOperationHandler?.Invoke(null, new EndOperationEventArgs(reportStr, failed));
            }
        }

        public static async Task ExportAssemblyWithReferences(IList<string> assemblyReferenced, IList<string> assemblyParsed, AssemblyName assemblyName, string rootFolder, bool splitByAssembly, bool forceRebuild)
        {
            if (assemblyReferenced.Contains(assemblyName.FullName)) return;
            var assembly = ExportAssembly(assemblyReferenced, assemblyParsed, assemblyName, rootFolder, splitByAssembly, forceRebuild);
            assemblyReferenced.Add(assemblyName.FullName);
            if (assembly == null) return;
            foreach (var item in assembly.GetReferencedAssemblies())
            {
                await ExportAssemblyWithReferences(assemblyReferenced, assemblyParsed, item, rootFolder, splitByAssembly, forceRebuild);
            }
        }

        static string assemblyDestinationFolder(string rootFolder, AssemblyName assemblyName, bool splitByAssembly)
        {
            return Path.Combine(rootFolder, Const.Framework.RuntimeFolder, splitByAssembly ? assemblyName.ToFolderName() : string.Empty);
        }

        static bool typePrefilter(Type type)
        {
            if (type.IsPublic
                && !type.IsGenericType
                && !type.Namespace.ToLowerInvariant().Contains(Const.SpecialNames.Internal) // avoid types with internal namespace name which are public
               )
            {
                return true;
            }
            return false;
        }

        public static Assembly ExportAssembly(IList<string> assemblyReferenced, IList<string> assemblyParsed, AssemblyName assemblyName, string rootFolder, bool splitByAssembly, bool forceRebuild)
        {
            string destFolder = assemblyDestinationFolder(rootFolder, assemblyName, splitByAssembly);

            if (splitByAssembly && Directory.Exists(destFolder))
            {
                if (!forceRebuild)
                {
                    AppendToConsole(LogLevel.Info, "Skipping assembly {0}", assemblyName);
                    return null;
                }
                if (assemblyReferenced.Contains(assemblyName.FullName))
                {
                    AppendToConsole(LogLevel.Info, "Skipping assembly {0}", assemblyName);
                    return null;
                }
            }

            if (assemblyReferenced.Contains(assemblyName.FullName))
            {
                AppendToConsole(LogLevel.Info, "Duplicated assembly {0}", assemblyName);
            }

            Assembly assembly = null;
            AppendToConsole(LogLevel.Info, "Loading assembly {0}", assemblyName);
            try
            {
                assembly = Assembly.Load(assemblyName);
                AppendToConsole(LogLevel.Info, "Loaded assembly {0}", assembly.FullName);
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "Skipping assembly {0}. Error is: {1}", assemblyName, ex.Message);
                return null;
            }

            Interlocked.Increment(ref loadedAssemblies);

#if ENABLE_REFERENCE_BUILDER
            StringBuilder sb = new StringBuilder();
            foreach (var item in assembly.GetReferencedAssemblies())
            {
                sb.AppendLine(string.Concat(item.FullName.Split(' ')));
            }

            if (!Directory.Exists(destFolder))
            {
                Directory.CreateDirectory(destFolder);
            }

            File.WriteAllText(Path.Combine(destFolder, Const.FileNameAndDirectory.ReferencesFile), sb.ToString());
#endif

            if (assemblyParsed.Contains(assembly.FullName))
            {
                AppendToConsole(LogLevel.Info, "Assembly previously parsed {0}", assembly.FullName);
                return assembly;
            }

            List<Type> typesToExport = new List<Type>();

            AppendToConsole(LogLevel.Info, "Getting types from {0}", assembly.FullName);
            var allType = assembly.GetTypes();
            AppendToConsole(LogLevel.Verbose, "Searching only public types...");
            foreach (var item in allType)
            {
                Interlocked.Increment(ref analyzedTypes);

                var typeName = item.FullName;

                if (typePrefilter(item))
                {
                    AppendToConsole(LogLevel.Verbose, "Store {0} within types to be exported", item.AssemblyQualifiedName);
                    typesToExport.Add(item);
                }
                else
                {
                    AppendToConsole(LogLevel.Verbose, "Discarded {0} from types to be exported", item.AssemblyQualifiedName);
                    Interlocked.Increment(ref discardedTypes);
                    if (!item.IsPublic) Interlocked.Increment(ref discardedNonPublicTypes);
                    else if (item.IsGenericType) Interlocked.Increment(ref discardedGenericTypes);
                    else if (item.Namespace.ToLowerInvariant().Contains(Const.SpecialNames.Internal)) Interlocked.Increment(ref discardedInternalTypes);
                }
            }

            if (typesToExport.Count != 0)
            {
                exportingPublicTypes(typesToExport, destFolder, assembly.FullName);
                Interlocked.Increment(ref parsedAssemblies);
                assemblyParsed.Add(assembly.FullName);
            }
            else
            {
                AppendToConsole(LogLevel.Info, "No public types in {0}", assembly.FullName);
            }

            return assembly;
        }

        static void exportingPublicTypes(List<Type> typesToExport, string destFolder, string assemblyname)
        {
            AppendToConsole(LogLevel.Info, "Start exporting public types of {0}", assemblyname);

            if (UseParallelBuild)
            {
                ParallelOptions po = new ParallelOptions();
                po.CancellationToken = CancellationToken;
                po.MaxDegreeOfParallelism = System.Environment.ProcessorCount;
                Parallel.ForEach(typesToExport, po, exportingPublicTypeParallel);
            }
            else
            {
                foreach (var item in typesToExport)
                {
                    exportingPublicType(item, destFolder, assemblyname);
                }
            }
        }

        static void exportingPublicTypeParallel(Type typeToExport)
        {
            try
            {
                string assemblyname = typeToExport.Assembly.FullName;
                string destFolder = assemblyDestinationFolder(SrcDestinationFolder, new AssemblyName(assemblyname), SplitByAssembly);
                exportingPublicType(typeToExport, destFolder, assemblyname);
            }
            catch (OperationCanceledException)
            {
                throw;
            }
            catch (Exception e)
            {
                AppendToConsole(LogLevel.Error, "Error exporting {0}: {1}", typeToExport.Name, e.Message);
                throw;
            }
        }

        static void writeFile(string fileName, string content)
        {
            if (EnableWrite)
            {
                AppendToConsole(LogLevel.Verbose, "Saving file {0}", fileName);
                File.WriteAllText(fileName, content);
            }
        }

        static bool checkForEnumerator(Type type)
        {
            if (!type.IsInterface
                && (typeof(IEnumerator).IsAssignableFrom(type) || type.FullName == Const.SpecialNames.StringEnumerator)
               )
            {
                return true;
            }
            return false;
        }

        static void exportingPublicType(Type typeToExport, string destFolder, string assemblyname)
        {
            var typeName = typeToExport.FullName;

            AppendToConsole(LogLevel.Verbose, "Start exporting {0}", typeName);
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isManaged = true;
            bool isSpecial = false;
            bool isArray = false;
            convertType(null, typeToExport, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);

            if (isPrimitive || isSpecial || !isManaged)
            {
                AppendToConsole(LogLevel.Verbose, "Discarding {0}", typeName);
                Interlocked.Increment(ref discardedTypes);
                return;
            }

            if (typeof(Delegate).IsAssignableFrom(typeToExport))
            {
                exportingDelegate(typeToExport, destFolder, assemblyname);
            }
            else if (checkForEnumerator(typeToExport))
            {
                string returnEnumerableType = string.Empty;
                exportingEnumerator(typeToExport, destFolder, assemblyname, out returnEnumerableType);
            }
            else if (typeToExport.IsInterface)
            {
                exportingInterface(typeToExport, destFolder, assemblyname);
            }
            else if (typeToExport.IsEnum)
            {
                exportingEnum(typeToExport, destFolder, assemblyname);
            }
            else if (typeToExport.IsClass || typeToExport.IsAnsiClass)
            {
                exportingClass(typeToExport, destFolder, assemblyname);
            }
            else throw new InvalidOperationException(string.Format("Unchecked and unexported type {0}", typeToExport.FullName));

            CancellationToken.ThrowIfCancellationRequested();
        }

        static void exportingEnum(Type item, string destFolder, string assemblyname)
        {
            var reflectorEnumTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumTemplate);
            var packageName = item.Namespace.ToLowerInvariant();
            reflectorEnumTemplate = reflectorEnumTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                         .Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name)
                                                         .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                         .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                         .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName);

            AppendToConsole(LogLevel.Verbose, "Starting creating public values from {0}", item.Name);
            var enumValues = Enum.GetNames(item);
            StringBuilder enums = new StringBuilder();
            foreach (var en in enumValues)
            {
                string enVal = string.Format(Const.Enum.SINGLE_ELEMENT_PROTOTYPE, item.Name, en);
                enums.AppendLine(enVal);
            }

            var enumStr = enums.ToString();
            bool hasFlags = false;
            foreach (var flagattrib in item.GetCustomAttributes(typeof(FlagsAttribute)))
            {
                hasFlags = true; break;
            }

            string flagsStr = string.Empty;
            if (hasFlags)
            {
                Interlocked.Increment(ref implementedEnumsFlags);
                var reflectorEnumFlagsTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumFlagsTemplate);
                flagsStr = reflectorEnumFlagsTemplate.Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name);
            }

            reflectorEnumTemplate = reflectorEnumTemplate.Replace(Const.Enum.ENUM_FIELDS_SECTION, enumStr)
                                                         .Replace(Const.Enum.FLAGS_MANAGEMENT_SECTION, flagsStr)
                                                         .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", item.Name));
            writeFile(fileName, reflectorEnumTemplate);

            Interlocked.Increment(ref implementedEnums);
        }

        static void exportingInterface(Type item, string destFolder, string assemblyname)
        {
            bool isException = false;
            string reflectorInterfaceClassTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceClassTemplate);
            string reflectorInterfaceTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceTemplate);
            string packageBaseClass = Const.SpecialNames.NetObject;
            IList<Type> imports = new List<Type>();

            string packageBaseInterface = Const.SpecialNames.IJCOBridgeReflected;
            bool withInheritance = false;

            var allDirectInterfaces = item.GetInterfaces(!EnableInterfaceInheritance);
            List<Type> implementableInterfaces = new List<Type>();
            foreach (var interfaceType in allDirectInterfaces)
            {
                if (isManagedType(interfaceType, 0, 1))
                {
                    implementableInterfaces.Add(interfaceType);
                }
            }

            if (EnableInheritance)
            {
                withInheritance = true;
                foreach (var inter in implementableInterfaces)
                {
                    if (inter == typeof(IEnumerable)) packageBaseClass = Const.SpecialNames.NetIEnumerable + Const.SpecialNames.ImplementationTrailer;
                    if (inter == typeof(IEnumerator)) packageBaseClass = Const.SpecialNames.NetIEnumerator + Const.SpecialNames.ImplementationTrailer;
                    packageBaseInterface += string.Format(", {0}", inter.Name);
                    imports.Add(inter);
                }
            }

            string implementsStr = string.Empty;
            var packageName = item.Namespace.ToLowerInvariant();
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                                             .Replace(Const.Class.PACKAGE_CLASS_BASE_CLASS, packageBaseClass)
                                                                             .Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name)
                                                                             .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                                             .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                                             .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName);

            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                                   .Replace(Const.Class.PACKAGE_CLASS_BASE_CLASS, packageBaseInterface)
                                                                   .Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name)
                                                                   .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                                   .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                                   .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName);

            var typeName = item.Name;

            string returnEnumerableType = string.Empty;
            string returnInterfaceSection = string.Empty;
            AppendToConsole(LogLevel.Verbose, "Starting creating public Methods from {0}", typeName);
            var methodsStr = exportingMethods(item, imports, implementableInterfaces, withInheritance, destFolder, assemblyname, out returnEnumerableType, out returnInterfaceSection);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.METHODS_SECTION, methodsStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.METHODS_SECTION, returnInterfaceSection);

            AppendToConsole(LogLevel.Verbose, "Starting creating public Properties from {0}", typeName);
            var propInstanceStr = exportingProperties(item, imports, implementableInterfaces, withInheritance, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, propInstanceStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, returnInterfaceSection);

            var eventsInstanceStr = exportingEvents(item, imports, implementableInterfaces, withInheritance, false, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, eventsInstanceStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, returnInterfaceSection);

            var importStr = exportingImports(imports);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);

            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", typeName));
            writeFile(fileName, reflectorInterfaceTemplate);

            fileName = Path.Combine(pathToSaveTo, string.Format("{0}" + Const.SpecialNames.ImplementationTrailer + ".java", typeName));
            writeFile(fileName, reflectorInterfaceClassTemplate);

            Interlocked.Increment(ref implementedInterfaces);
        }

        /***************
        https://stackoverflow.com/questions/5318685/get-only-direct-interface-instead-of-all
        ****************/
        public static IEnumerable<Type> GetInterfaces(this Type type, bool includeInherited)
        {
            if (includeInherited || type.BaseType == null)
                return type.GetInterfaces();
            else
                return type.GetInterfaces().Except(type.BaseType.GetInterfaces());
        }
        /*************/

        static void exportingClass(Type item, string destFolder, string assemblyname)
        {
            bool isException = false;
            string reflectorClassTemplate = string.Empty;
            string packageBaseClass = string.Empty;
            if (typeof(Exception).IsAssignableFrom(item))
            {
                isException = true;
                Interlocked.Increment(ref implementedExceptions);
                reflectorClassTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorThrowableClassTemplate);
                packageBaseClass = Const.SpecialNames.NetException;
            }
            else
            {
                reflectorClassTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorClassTemplate);
                packageBaseClass = Const.SpecialNames.NetObject;
                if (EnableInterfaceInheritance && typeof(IEnumerable).IsAssignableFrom(item))
                {
                    packageBaseClass = Const.SpecialNames.NetObjectEnumerable;
                }
            }

            var allDirectInterfaces = item.GetInterfaces(false);
            List<Type> implementableInterfaces = new List<Type>();
            foreach (var interfaceType in allDirectInterfaces)
            {
                if (isManagedType(interfaceType, 0, 1) && typeof(IEnumerable) != interfaceType)
                {
                    implementableInterfaces.Add(interfaceType);
                }
            }

            string implementsStr = string.Empty;
            IList<Type> imports = new List<Type>();
            bool withInheritance = false;
            if (EnableInheritance)
            {
                withInheritance = true;
                if (isManagedType(item.BaseType, 0, 1) && item.BaseType != typeof(object) && item.BaseType != typeof(Exception) && item.BaseType != typeof(Type))
                {
                    packageBaseClass = item.BaseType.Name;
                    imports.Add(item.BaseType);
                }

                if (EnableInterfaceInheritance)
                {
                    foreach (var interfaceType in implementableInterfaces)
                    {
                        var nameToAdd = interfaceType.Namespace.ToLowerInvariant() + "." + interfaceType.Name;

                        if (string.IsNullOrEmpty(implementsStr))
                        {
                            implementsStr += Const.Class.PACKAGE_CLASS_IMPLEMENTS_PROTO + nameToAdd;
                        }
                        else
                        {
                            implementsStr += ", " + nameToAdd;
                        }

                        imports.Add(interfaceType);
                    }
                }
            }

            var packageName = item.Namespace.ToLowerInvariant();
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                           .Replace(Const.Class.PACKAGE_CLASS_BASE_CLASS, packageBaseClass)
                                                           .Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name)
                                                           .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                           .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                           .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName);

            var typeName = item.Name;

            AppendToConsole(LogLevel.Verbose, "Starting creating public Constructors from {0}", typeName);
            string ctorStr = string.Empty;
            if (EnableAbstract && !item.IsAbstract)
            {
                ctorStr = exportingConstructors(item, imports, withInheritance, isException, destFolder, assemblyname);
            }
            else if (!isException)
            {
                ctorStr = Const.CTor.DEFAULT_CTOR.Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name);
            }
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.CONSTRUCTORS_SECTION, ctorStr);

            bool isDisposable = allDirectInterfaces.Contains(typeof(IDisposable));
            string returnEnumerableType = string.Empty;
            string returnInterfaceSection = string.Empty;
            AppendToConsole(LogLevel.Verbose, "Starting creating public Methods from {0}", typeName);
            var methodsStr = exportingMethods(item, imports, implementableInterfaces, withInheritance, destFolder, assemblyname, out returnEnumerableType, out returnInterfaceSection);
            if (isDisposable)
            {
                methodsStr += Const.Methods.AUTOCLOSEABLE_CLOSE_METHOD;
            }
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.METHODS_SECTION, methodsStr);

            AppendToConsole(LogLevel.Verbose, "Starting creating public Properties from {0}", typeName);
            var propInstanceStr = exportingProperties(item, imports, implementableInterfaces, withInheritance, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, propInstanceStr);

            var eventsInstanceStr = exportingEvents(item, imports, implementableInterfaces, withInheritance, false, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, eventsInstanceStr);

            var importStr = exportingImports(imports);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);

            if (!string.IsNullOrEmpty(returnEnumerableType) && typeof(IEnumerable).IsAssignableFrom(item))
            {
                string implStr = string.Format(Const.Class.PACKAGE_CLASS_IMPLEMENTS_ITERABLE, returnEnumerableType);
                if (returnEnumerableType == Const.SpecialNames.NetObject)
                {
                    implStr = Const.SpecialNames.NetIEnumerable;
                }

                if (string.IsNullOrEmpty(implementsStr)) implementsStr += Const.Class.PACKAGE_CLASS_IMPLEMENTS_PROTO + implStr;
                else implementsStr += ", " + implStr; // proto for other interface
            }

            if (isDisposable)
            {
                if (string.IsNullOrEmpty(implementsStr)) implementsStr += Const.Class.PACKAGE_CLASS_IMPLEMENTS_PROTO + Const.SpecialNames.AutoCloseable;
                else implementsStr += ", " + Const.SpecialNames.AutoCloseable; // proto for other interface
            }

            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_CLASS_IMPLEMENTS_SECTION, implementsStr)
                                                           .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", typeName));
            writeFile(fileName, reflectorClassTemplate);

            Interlocked.Increment(ref implementedClasses);
        }

        static string exceptionStringBuilder(MethodBase method, IList<Type> imports)
        {
            if (!CreateExceptionThrownClause) return string.Empty;

            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isConcrete = true;
            bool isSpecial = false;
            bool isArray = false;
            string exceptionStr = string.Empty;
            try
            {
                StringBuilder expBuilder = new StringBuilder();
                var expTypes = method.GetAllExceptions(ExceptionThrownClauseDepth);
                if (expTypes.Count != 0)
                {
                    foreach (var expType in expTypes)
                    {
                        if (!expType.IsSubclassOf(typeof(Exception))) continue;
                        convertType(imports, expType, out isPrimitive, out defaultPrimitiveValue, out isConcrete, out isSpecial, out isArray, false);
                        if (!isSpecial && isConcrete)
                        {
                            expBuilder.AppendFormat(Const.Exceptions.SINGLE_EXCEPTION_PROTO, expType.Namespace.ToLowerInvariant(), expType.Name);
                        }
                    }
                    exceptionStr = expBuilder.ToString();
                }
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "exceptionStringBuilder on {0} with error {1}", method.Name, ex.Message);
                exceptionStr = string.Empty;
            }

            return exceptionStr;
        }

        static string exportingConstructors(Type type, IList<Type> imports, bool withInheritance, bool isException, string destFolder, string assemblyname)
        {
            var ctorTypes = type.GetConstructors();
            if (!withInheritance && ctorTypes.Length == 0) return string.Empty;

            SortedDictionary<string, ConstructorInfo> sortedData = new SortedDictionary<string, ConstructorInfo>();
            foreach (var item in ctorTypes)
            {
                var strMethod = item.ToString();
                if (!sortedData.ContainsKey(strMethod))
                {
                    sortedData.Add(strMethod, item);
                }
            }

            var ctorLst = new List<ConstructorInfo>();
            ctorLst.AddRange(sortedData.Values);

            ctorTypes = ctorLst.ToArray();

            var ctorClassTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorClassConstructorTemplate);
            ctorClassTemplate = ctorClassTemplate.Replace(Const.Class.PACKAGE_CLASS_NAME, type.Name);

            var defaultCtor = Const.CTor.DEFAULT_CTOR.Replace(Const.Class.PACKAGE_CLASS_NAME, type.Name);

            StringBuilder ctors = new StringBuilder();

            bool hasDefaultCtor = false;

            foreach (var item in ctorTypes)
            {
                Interlocked.Increment(ref analyzedCtors);

                if (item.IsVirtual
                    || (EnableAbstract ? false : item.IsAbstract)
                    || !item.IsPublic) continue;
                if (!item.IsConstructor) continue;

                var parameters = item.GetParameters();
                if (isException)
                {
                    if (parameters.Length == 0) continue;
                    if (parameters.Length == 1 && (parameters[0].ParameterType == typeof(string) || typeof(Exception).IsAssignableFrom(parameters[0].ParameterType))) continue;
                    if (parameters.Length == 2 && parameters[0].ParameterType == typeof(string) && typeof(Exception).IsAssignableFrom(parameters[1].ParameterType)) continue;
                }

                hasDefaultCtor |= parameters.Length == 0;

                StringBuilder ctorParams = new StringBuilder();
                StringBuilder newObjectParams = new StringBuilder();

                bool isPrimitive = true;
                string defaultPrimitiveValue = string.Empty;
                bool isSpecial = false;
                bool isArray = false;
                bool isManaged = true;
                foreach (var parameter in parameters)
                {
                    string paramType = convertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                    if (!isManaged) break; // found not managed type, stop here

                    var paramName = checkForkeyword(parameter.Name);
                    isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                    ctorParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));

                    string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                    if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                    string objectCaster = string.Empty;
                    if (isArray && parameters.Length == 1)
                    {
                        objectCaster = "(Object)";
                    }
                    newObjectParams.Append(string.Format(formatter, objectCaster, paramName));
                }
                if (!isManaged) continue; // found not managed type, jump to next 
                string ctorParamStr = ctorParams.ToString();
                if (!string.IsNullOrEmpty(ctorParamStr))
                {
                    ctorParamStr = ctorParamStr.Substring(0, ctorParamStr.Length - 2);
                }

                string newObjParamStr = newObjectParams.ToString();
                if (!string.IsNullOrEmpty(newObjParamStr))
                {
                    newObjParamStr = newObjParamStr.Substring(2);
                }

                var exceptionStr = exceptionStringBuilder(item, imports);

                var otherCtor = ctorClassTemplate.Replace(Const.CTor.CTOR_PARAMETERS, ctorParamStr)
                                                 .Replace(Const.CTor.CTOR_NEWOBJECT_PARAMETERS, newObjParamStr)
                                                 .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);

                ctors.AppendLine(otherCtor);

                Interlocked.Increment(ref implementedCtors);
            }

            string ctorsStr = ctors.ToString();

            if (!isException && !hasDefaultCtor)
            {
                ctors = new StringBuilder();
                ctors.AppendLine(defaultCtor);
                ctors.AppendLine(ctorsStr);
                ctorsStr = ctors.ToString();
            }

            return ctorsStr;
        }

        static bool isDifferentOnlyForRetVal(IList<string> signatures, string signToCheck, string methodName)
        {
            var endOfSignToCheck = signToCheck.Remove(0, signToCheck.LastIndexOf(methodName));
            var startOfSignToCheck = signToCheck.Substring(0, signToCheck.LastIndexOf(methodName));
            startOfSignToCheck = startOfSignToCheck.TrimEnd(' ');
            foreach (var signature in signatures)
            {
                if (signature.EndsWith(endOfSignToCheck))
                {
                    var startToCheck = signature.Substring(0, signature.LastIndexOf(endOfSignToCheck));
                    startToCheck = startToCheck.TrimEnd(' ');
                    if (startToCheck.Contains(" ")) continue; // the method name is different: there is a space between returning type and starting section of method name
                    return startToCheck != startOfSignToCheck;
                }
            }

            return false;
        }

        static bool exportingEnumerator(Type item, string destFolder, string assemblyname, out string returnEnumeratorType, bool avoidWrite = false)
        {
            AppendToConsole(LogLevel.Verbose, "Starting creating public values from {0}", item.Name);

            if (!checkForEnumerator(item)) { returnEnumeratorType = string.Empty; return false; }

            returnEnumeratorType = string.Empty;

            if (!avoidWrite) Interlocked.Increment(ref analyzedEnumerators);

            if (item.IsGenericType
                || item.IsGenericParameter
               ) return false;

            IList<Type> imports = new List<Type>();
            var propertyMethod = item.GetProperty("Current");

            if (propertyMethod == null) return false;

            string interfaceTemplateToUse = string.Empty;
            string classTemplateToUse = string.Empty;
            bool isPrimitive = true;
            string defaultPrimitiveReturnValue = string.Empty;
            bool isManaged = true;
            bool isSpecial = false;
            bool isArray = false;

            returnEnumeratorType = convertType(imports, propertyMethod.PropertyType, out isPrimitive, out defaultPrimitiveReturnValue, out isManaged, out isSpecial, out isArray);

            if (!isManaged || isArray
                || (isPrimitive && !returnEnumeratorType.Contains("String"))) // only String type from native are accepted, other are not valid for Iterable<E> Java interface
            {
                returnEnumeratorType = string.Empty;
                return false;
            }

            if (avoidWrite) return true;

            var nextTemplateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorEnumerableNativeNextTemplate : Const.Templates.ReflectorEnumerableObjectNextTemplate);

            string nextSection = nextTemplateToUse.Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType)
                                                  .Replace(Const.Enumerator.PACKAGE_IMPLEMENTATION_INNER_CLASS_NAME, propertyMethod.PropertyType.IsInterface ? returnEnumeratorType + Const.SpecialNames.ImplementationTrailer : returnEnumeratorType);

            var reflectorEnumeratorTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumeratorTemplate);

            var importsStr = exportingImports(imports);

            var packageName = item.Namespace.ToLowerInvariant();
            var enumeratorStr = reflectorEnumeratorTemplate.Replace(Const.Enumerator.PACKAGE_NAME, packageName)
                                                           .Replace(Const.Enumerator.PACKAGE_IMPORT_SECTION, importsStr)
                                                           .Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType)
                                                           .Replace(Const.Enumerator.PACKAGE_IMPLEMENTATION_INNER_CLASS_NAME, propertyMethod.PropertyType.IsInterface ? returnEnumeratorType + Const.SpecialNames.ImplementationTrailer : returnEnumeratorType)
                                                           .Replace(Const.Enumerator.PACKAGE_CLASS_NAME, item.Name)
                                                           .Replace(Const.Enumerator.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                           .Replace(Const.Enumerator.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                           .Replace(Const.Enumerator.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                           .Replace(Const.Enumerator.PACKAGE_CLASS_NEXT_SECTION, nextSection)
                                                           .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", item.Name));
            writeFile(fileName, enumeratorStr);

            Interlocked.Increment(ref implementedEnumerators);

            return true;
        }

        static bool IsParams(ParameterInfo param)
        {
            return param.IsDefined(typeof(ParamArrayAttribute), false);
        }

        static void searchMethods(Type type, IList<MethodInfo> allMethods, bool traverseHierarchy)
        {
            TypeInfo t = type.GetTypeInfo();
            foreach (var item in t.GetRuntimeMethods())
            {
                allMethods.Add(item);
            }

            if (traverseHierarchy)
            {
                foreach (var item in t.ImplementedInterfaces)
                {
                    if (!isManagedType(item, 0, 1)) continue;
                    searchMethods(item, allMethods, traverseHierarchy);
                }
            }
            else if (type.BaseType != null)
            {
                if (!isManagedType(type.BaseType, 0, 1) || type.BaseType == typeof(object) || type.BaseType == typeof(Exception) || type.BaseType == typeof(Type)) return;
                searchMethods(type.BaseType, allMethods, traverseHierarchy);
            }
        }

        static string signatureWithoutRetVal(MethodInfo method)
        {
            if (method == null) return string.Empty;
            var sign = method.ToString();
            sign = sign.Substring(sign.IndexOf(' '));
            return sign;
        }

        static bool isNewMethod(Type type, MethodInfo method, IList<MethodInfo> allMethods)
        {
            string refSign = signatureWithoutRetVal(method);
            if (method.GetBaseDefinition().DeclaringType == type)
            {
                foreach (var item in allMethods)
                {
                    if (item.Name == method.Name
                        && item.DeclaringType != type
                        && signatureWithoutRetVal(item) == refSign)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        static string exportingMethods(Type type, IList<Type> imports, IList<Type> implementableInterfaces, bool withInheritance, string destFolder, string assemblyname, out string returnEnumeratorType, out string returnInterfaceSection)
        {
            bool isInterface = false;
            returnInterfaceSection = string.Empty;
            returnEnumeratorType = string.Empty;

            MethodInfo[] methods = null;

            if (type.IsInterface)
            {
                isInterface = true;
            }
            List<MethodInfo> allMethods = new List<MethodInfo>();
            searchMethods(type, allMethods, isInterface);
            methods = allMethods.ToArray();

            if (methods.Length == 0) return string.Empty;

            SortedDictionary<string, MethodInfo> sortedData = new SortedDictionary<string, MethodInfo>();
            foreach (var item in methods)
            {
                var strMethod = item.ToString();
                if (!sortedData.ContainsKey(strMethod))
                {
                    sortedData.Add(strMethod, item);
                }
            }

            var methodLst = new List<MethodInfo>();
            methodLst.AddRange(sortedData.Values);

            methods = methodLst.ToArray();

            string templateInterfaceToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceMethodTemplate);
            string templateToUse = string.Empty;

            bool hasEnumerable = typeof(IEnumerable).IsAssignableFrom(type);

            StringBuilder methodInterfaceBuilder = new StringBuilder();
            StringBuilder methodBuilder = new StringBuilder();
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isSpecial = false;
            bool isArray = false;
            bool isRetValArray = false;
            bool isManaged = true;

            List<string> methodsSignatureCreated = new List<string>();
            List<string> methodsNameCreated = new List<string>();
            List<string> methodsDuplicatedCreated = new List<string>();

            foreach (var item in methods)
            {
                var methodName = item.Name;

                isPrimitive = true;
                defaultPrimitiveValue = string.Empty;
                isSpecial = false;
                isArray = false;
                isRetValArray = false;
                isManaged = true;

                if (!item.IsPublic
                    || item.IsSpecialName // remove properties
                    || methodsSignatureCreated.Contains(item.ToString()) // avoid duplicated methods from inheritance
                   ) continue;

                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref analyzedMethods);
                    }
                }
                else
                {
                    Interlocked.Increment(ref analyzedMethods);
                }

                if (item.IsGenericMethod // don't manage generic methods
                    || item.ContainsGenericParameters
                    || ((withInheritance && !isInterface) ? item.DeclaringType != type : false)
                    || (!methodsNameCreated.Contains(methodName) ? false : isDifferentOnlyForRetVal(methodsSignatureCreated, item.ToString(), methodName))
                   ) continue;

                var parameters = item.GetParameters();

                if (methodName == "ToString" && parameters.Length == 0) continue;
                if (methodName == "GetHashCode" && parameters.Length == 0) continue;
                if (methodName == "GetType" && parameters.Length == 0) continue;
                if (methodName == "Equals" && parameters.Length == 1 && parameters[0].ParameterType == typeof(object)) continue;

                string methodInterfaceStr = string.Empty;
                string dupMethodInterfaceStr = string.Empty;
                string methodStr = string.Empty;
                string dupMethodStr = string.Empty;
                string dupMethodSignature = string.Empty;

                var signToAdd = item.ToString();

                if (hasEnumerable && methodName == Const.SpecialNames.METHOD_GETENUMERATOR_NAME && parameters.Length == 0)
                {
                    if (EnableInterfaceInheritance) continue; // we avoid any enumerator here, becuase it is managed in the superclass

                    var enumeratorMethodName = Const.SpecialNames.METHOD_GETENUMERATOR_NAME;
                    templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumerableTemplate);
                    var returnType = string.Empty;
                    if (!isInterface && EnableInheritance && EnableInterfaceInheritance && item.ReturnType == typeof(IEnumerator))
                    {
                        returnEnumeratorType = string.Empty;
                        returnType = Const.SpecialNames.NetIEnumerator;
                        methodStr = templateToUse.Replace(Const.Methods.METHOD_ENUMERATOR_NAME, enumeratorMethodName)
                                                 .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                 .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, item.ReturnType.IsInterface ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                 .Replace(Const.Methods.METHOD_RETURN_INNER_TYPE, Const.SpecialNames.NetObject);
                    }
                    else
                    {
                        if (!exportingEnumerator(item.ReturnType, null, null, out returnEnumeratorType, true))
                        {
                            returnEnumeratorType = string.Empty;
                            continue;
                        }

                        returnType = convertType(imports, item.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        if (!isManaged)
                        {
                            returnEnumeratorType = string.Empty;
                            continue;
                        }

                        if (!isInterface && EnableInheritance && EnableInterfaceInheritance && type.GetInterfaces().Contains(typeof(IEnumerable)))
                        {
                            enumeratorMethodName += type.Name;
                            signToAdd = signToAdd.Replace(Const.SpecialNames.METHOD_GETENUMERATOR_NAME, enumeratorMethodName);
                        }

                        if (EnableInterfaceInheritance && enumeratorMethodName == Const.SpecialNames.METHOD_GETENUMERATOR_NAME) continue;

                        methodStr = templateToUse.Replace(Const.Methods.METHOD_ENUMERATOR_NAME, enumeratorMethodName)
                                                 .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                 .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, item.ReturnType.IsInterface ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                 .Replace(Const.Methods.METHOD_RETURN_INNER_TYPE, returnEnumeratorType);
                    }
                }
                else
                {
                    bool hasNativeArrayInParameter = false;

                    isRetValArray = false;
                    string returnType = "void";
                    bool isInterfaceRetVal = false;
                    if (item.ReturnType == typeof(void))
                    {
                        templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassVoidMethodTemplate);
                    }
                    else
                    {
                        returnType = convertType(imports, item.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isRetValArray);
                        if (!isManaged) continue;
                        isPrimitive |= typeof(Delegate).IsAssignableFrom(item.ReturnType);

                        if (isRetValArray)
                        {
                            isInterfaceRetVal = item.ReturnType.GetElementType().IsInterface;
                            templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayMethodTemplate : Const.Templates.ReflectorClassObjectArrayMethodTemplate);
                        }
                        else
                        {
                            isInterfaceRetVal = item.ReturnType.IsInterface;
                            templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeMethodTemplate : Const.Templates.ReflectorClassObjectMethodTemplate);
                        }
                    }

                    StringBuilder inputParams = new StringBuilder();
                    StringBuilder execParams = new StringBuilder();

                    foreach (var parameter in parameters)
                    {
                        string paramType = convertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        hasNativeArrayInParameter |= isArray && isPrimitive;
                        isManaged &= !parameter.IsOut; // out parameters not managed
                        if (!isManaged) break; // found not managed type, stop here
                        isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                        var paramName = checkForkeyword(parameter.Name);
                        inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));

                        string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                        if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                        string objectCaster = string.Empty;
                        if (isArray && parameters.Length == 1)
                        {
                            objectCaster = "(Object)";
                        }

                        execParams.Append(string.Format(formatter, objectCaster, paramName));
                    }
                    if (!isManaged) continue; // found not managed type, jump to next 
                    string inputParamStr = inputParams.ToString();
                    if (!string.IsNullOrEmpty(inputParamStr))
                    {
                        inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                    }

                    string execParamStr = execParams.ToString();

                    var exceptionStr = exceptionStringBuilder(item, imports);

                    bool isNewMethodVal = (withInheritance && !isInterface) ? isNewMethod(type, item, allMethods) : false;
                    string newMethodName = string.Empty;
                    if (isNewMethodVal)
                    {
                        newMethodName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, methodName, type.Name);
                    }

                    methodStr = templateToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                             .Replace(Const.Methods.METHOD_NAME, methodName)
                                             .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                             .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                             .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                             .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                             .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, item.IsStatic ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                             .Replace(Const.Methods.METHOD_OBJECT, item.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                             .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);

                    if (withInheritance ? (isInterface && (item.GetBaseDefinition().DeclaringType == type)) : isInterface)
                    {
                        methodInterfaceStr = templateInterfaceToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                                   .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                   .Replace(Const.Methods.METHOD_RETURN_TYPE, isRetValArray ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                                   .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                                   .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                                   .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                    }

                    if (EnableDuplicateMethodNativeArrayWithJCRefOut && hasNativeArrayInParameter)
                    {
                        // needs a duplication in method signature
                        inputParams = new StringBuilder();
                        execParams = new StringBuilder();

                        foreach (var parameter in parameters)
                        {
                            string paramType = convertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                            bool isNativeArrayInParameter = isArray && isPrimitive;
                            isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                            var paramName = string.Format(Const.Methods.DUPLICATED_PARAMETER_PROTO, parameter.Position); // change name to avoid confusion made by parameter name when a duplicated method is searched

                            string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                            if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                            if (isNativeArrayInParameter)
                            {
                                inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, Const.SpecialNames.JCORefOutType, paramName));
                                formatter = Const.Parameters.INVOKE_PARAMETER_JCOREFOUT;
                            }
                            else
                            {
                                inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));
                            }

                            string objectCaster = string.Empty;
                            if (isArray && parameters.Length == 1)
                            {
                                objectCaster = "(Object)";
                            }

                            execParams.Append(string.Format(formatter, objectCaster, paramName));
                        }
                        inputParamStr = inputParams.ToString();
                        if (!string.IsNullOrEmpty(inputParamStr))
                        {
                            inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                        }

                        execParamStr = execParams.ToString();

                        dupMethodStr = templateToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                    .Replace(Const.Methods.METHOD_NAME, methodName)
                                                    .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                    .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                    .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                    .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                    .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, item.IsStatic ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                                    .Replace(Const.Methods.METHOD_OBJECT, item.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                                    .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);

                        if (withInheritance ? (isInterface && (item.GetBaseDefinition().DeclaringType == type)) : isInterface)
                        {
                            dupMethodInterfaceStr = templateInterfaceToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                                          .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                          .Replace(Const.Methods.METHOD_RETURN_TYPE, isRetValArray ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                                          .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                                          .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                                          .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                        }

                        dupMethodSignature = templateInterfaceToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                                   .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                   .Replace(Const.Methods.METHOD_RETURN_TYPE, string.Empty)
                                                                   .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                                   .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                                   .Replace(Const.Exceptions.THROWABLE_TEMPLATE, string.Empty);

                        Interlocked.Increment(ref implementedDuplicatedMethods);
                    }
                }

                methodsSignatureCreated.Add(signToAdd);
                methodsNameCreated.Add(item.Name);

                if (isInterface)
                {
                    methodInterfaceBuilder.AppendLine(methodInterfaceStr);
                    if (EnableDuplicateMethodNativeArrayWithJCRefOut && !string.IsNullOrEmpty(dupMethodInterfaceStr) && !methodsDuplicatedCreated.Contains(dupMethodSignature))
                    {
                        methodInterfaceBuilder.AppendLine(dupMethodInterfaceStr);
                    }
                }

                methodBuilder.AppendLine(methodStr);
                if (EnableDuplicateMethodNativeArrayWithJCRefOut && !string.IsNullOrEmpty(dupMethodStr) && !methodsDuplicatedCreated.Contains(dupMethodSignature))
                {
                    methodBuilder.AppendLine(dupMethodStr);
                    methodsDuplicatedCreated.Add(dupMethodSignature);
                }

                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref implementedMethods);
                    }
                }
                else
                {
                    Interlocked.Increment(ref implementedMethods);
                }
            }

            if (!isInterface && EnableInheritance && EnableInterfaceInheritance)
            {
                foreach (var item in implementableInterfaces)
                {
                    allMethods = new List<MethodInfo>();
                    searchMethods(item, allMethods, true);
                    methods = allMethods.ToArray();

                    if (methods.Length == 0) return string.Empty;

                    sortedData = new SortedDictionary<string, MethodInfo>();
                    foreach (var method in methods)
                    {
                        var strMethod = method.ToString();
                        if (!sortedData.ContainsKey(strMethod))
                        {
                            sortedData.Add(strMethod, method);
                        }
                    }

                    methodLst = new List<MethodInfo>();
                    methodLst.AddRange(sortedData.Values);

                    methods = methodLst.ToArray();

                    foreach (var interfaceMethod in methods)
                    {
                        var methodName = interfaceMethod.Name;

                        isPrimitive = true;
                        defaultPrimitiveValue = string.Empty;
                        isSpecial = false;
                        isArray = false;
                        isRetValArray = false;
                        isManaged = true;

                        if (!interfaceMethod.IsPublic
                            || interfaceMethod.IsSpecialName // remove properties
                            || methodsSignatureCreated.Contains(interfaceMethod.ToString()) // avoid duplicated methods from inheritance
                           ) continue;

                        if (interfaceMethod.IsGenericMethod // don't manage generic methods
                            || interfaceMethod.ContainsGenericParameters
                            || ((withInheritance && !isInterface) ? !interfaceMethod.DeclaringType.IsAssignableFrom(item) : false)
                            || (!methodsNameCreated.Contains(methodName) ? false : isDifferentOnlyForRetVal(methodsSignatureCreated, interfaceMethod.ToString(), methodName))
                           ) continue;

                        var parameters = interfaceMethod.GetParameters();

                        if (methodName == "ToString" && parameters.Length == 0) continue;
                        if (methodName == "GetHashCode" && parameters.Length == 0) continue;
                        if (methodName == "GetType" && parameters.Length == 0) continue;
                        if (methodName == "Equals" && parameters.Length == 1 && parameters[0].ParameterType == typeof(object)) continue;

                        string methodInterfaceStr = string.Empty;
                        string dupMethodInterfaceStr = string.Empty;
                        string methodStr = string.Empty;
                        string dupMethodStr = string.Empty;
                        string dupMethodSignature = string.Empty;

                        if (hasEnumerable && methodName == Const.SpecialNames.METHOD_GETENUMERATOR_NAME && parameters.Length == 0)
                        {
                            var enumeratorMethodName = Const.SpecialNames.METHOD_GETENUMERATOR_NAME;
                            templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumerableDeprecatedTemplate);
                            var returnType = string.Empty;
                            if (!isInterface && EnableInheritance && EnableInterfaceInheritance && interfaceMethod.ReturnType == typeof(IEnumerator))
                            {
                                //returnEnumeratorType = string.Empty;
                                returnType = Const.SpecialNames.NetIEnumerator;
                                methodStr = templateToUse.Replace(Const.Methods.METHOD_INTERFACE_NAME, item.Name)
                                                         .Replace(Const.Methods.METHOD_ENUMERATOR_NAME, enumeratorMethodName)
                                                         .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                         .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, interfaceMethod.ReturnType.IsInterface ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                         .Replace(Const.Methods.METHOD_RETURN_INNER_TYPE, Const.SpecialNames.NetObject);
                            }
                            else
                            {
                                if (!exportingEnumerator(interfaceMethod.ReturnType, null, null, out returnEnumeratorType, true))
                                {
                                    //returnEnumeratorType = string.Empty;
                                    continue;
                                }

                                returnType = convertType(imports, interfaceMethod.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                                if (!isManaged)
                                {
                                    //returnEnumeratorType = string.Empty;
                                    continue;
                                }

                                if (!isInterface && EnableInheritance && EnableInterfaceInheritance && type.GetInterfaces().Contains(typeof(IEnumerable)))
                                {
                                    enumeratorMethodName += type.Name;
                                }

                                methodStr = templateToUse.Replace(Const.Methods.METHOD_INTERFACE_NAME, item.Name)
                                                         .Replace(Const.Methods.METHOD_ENUMERATOR_NAME, enumeratorMethodName)
                                                         .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                         .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, interfaceMethod.ReturnType.IsInterface ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                         .Replace(Const.Methods.METHOD_RETURN_INNER_TYPE, returnEnumeratorType);
                            }
                        }
                        else
                        {
                            bool hasNativeArrayInParameter = false;

                            isRetValArray = false;
                            string returnType = "void";
                            bool isInterfaceRetVal = false;
                            if (interfaceMethod.ReturnType == typeof(void))
                            {
                                templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassVoidMethodDeprecatedTemplate);
                            }
                            else
                            {
                                returnType = convertType(imports, interfaceMethod.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isRetValArray);
                                if (!isManaged) continue;
                                isPrimitive |= typeof(Delegate).IsAssignableFrom(interfaceMethod.ReturnType);

                                if (isRetValArray)
                                {
                                    isInterfaceRetVal = interfaceMethod.ReturnType.GetElementType().IsInterface;
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayMethodDeprecatedTemplate : Const.Templates.ReflectorClassObjectArrayMethodDeprecatedTemplate);
                                }
                                else
                                {
                                    isInterfaceRetVal = interfaceMethod.ReturnType.IsInterface;
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeMethodDeprecatedTemplate : Const.Templates.ReflectorClassObjectMethodDeprecatedTemplate);
                                }
                            }

                            StringBuilder inputParams = new StringBuilder();
                            StringBuilder execParams = new StringBuilder();

                            foreach (var parameter in parameters)
                            {
                                string paramType = convertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                                hasNativeArrayInParameter |= isArray && isPrimitive;
                                isManaged &= !parameter.IsOut; // out parameters not managed
                                if (!isManaged) break; // found not managed type, stop here
                                isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                                var paramName = checkForkeyword(parameter.Name);
                                inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));

                                string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                                if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                                string objectCaster = string.Empty;
                                if (isArray && parameters.Length == 1)
                                {
                                    objectCaster = "(Object)";
                                }

                                execParams.Append(string.Format(formatter, objectCaster, paramName));
                            }
                            if (!isManaged) continue; // found not managed type, jump to next 
                            string inputParamStr = inputParams.ToString();
                            if (!string.IsNullOrEmpty(inputParamStr))
                            {
                                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                            }

                            string execParamStr = execParams.ToString();

                            var exceptionStr = exceptionStringBuilder(interfaceMethod, imports);

                            bool isNewMethodVal = (withInheritance && !isInterface) ? isNewMethod(type, interfaceMethod, allMethods) : false;
                            string newMethodName = string.Empty;
                            if (isNewMethodVal)
                            {
                                newMethodName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, methodName, type.Name);
                            }

                            methodStr = templateToUse.Replace(Const.Methods.METHOD_INTERFACE_NAME, item.Name)
                                                     .Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                     .Replace(Const.Methods.METHOD_NAME, methodName)
                                                     .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                     .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                     .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                     .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                     .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, interfaceMethod.IsStatic ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                                     .Replace(Const.Methods.METHOD_OBJECT, interfaceMethod.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                                     .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                        }

                        methodsSignatureCreated.Add(interfaceMethod.ToString());
                        methodsNameCreated.Add(interfaceMethod.Name);

                        if (isInterface)
                        {
                            methodInterfaceBuilder.AppendLine(methodInterfaceStr);
                        }

                        methodBuilder.AppendLine(methodStr);
                    }
                }
            }

            returnInterfaceSection = methodInterfaceBuilder.ToString();

            return methodBuilder.ToString();
        }

        static string buildPropertySignature(string templateToUse, string propertyJavaName, string propertyName, string propertyType, string exceptionStr, bool isPrimitive, bool isArray, bool needInterfaceImplementation, bool statics, string propertyInterfaceName)
        {
            StringBuilder inputParams = new StringBuilder();
            StringBuilder execParams = new StringBuilder();

            propertyJavaName = checkForkeyword(propertyJavaName);

            string inputParamStr = inputParams.ToString();
            if (!string.IsNullOrEmpty(inputParamStr))
            {
                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
            }

            string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
            if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

            string execParamStr = execParams.ToString();
            var propertyStr = templateToUse.Replace(Const.Properties.PROPERTY_INTERFACE_NAME, propertyInterfaceName)
                                           .Replace(Const.Properties.PROPERTY_JAVA_NAME, propertyJavaName)
                                           .Replace(Const.Properties.PROPERTY_NAME, propertyName)
                                           .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr)
                                           .Replace(Const.Properties.PROPERTY_INPUTTYPE, (isArray) ? propertyType + Const.SpecialNames.ArrayTrailer : propertyType)
                                           .Replace(Const.Properties.PROPERTY_INPUTNAME, propertyName)
                                           .Replace(Const.Properties.PROPERTY_OUTPUTTYPE, propertyType)
                                           .Replace(Const.Properties.PROPERTY_IMPLEMENTATION_OUTPUTTYPE, needInterfaceImplementation ? propertyType + Const.SpecialNames.ImplementationTrailer : propertyType)
                                           .Replace(Const.Properties.PROPERTY_PARAMETERS, string.Empty)
                                           .Replace(Const.Properties.PROPERTY_INVOKE_PARAMETERS, string.Empty)
                                           .Replace(Const.Properties.PROPERTY_VALUE, string.Format(formatter, string.Empty, propertyName))
                                           .Replace(Const.Properties.METHOD_MODIFIER_KEYWORD, statics ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                           .Replace(Const.Properties.PROPERTY_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

            return propertyStr;
        }

        static bool isNewProperty(Type type, PropertyInfo property, IList<Tuple<bool, PropertyInfo>> allProperties, bool isGet)
        {
            MethodInfo method = isGet ? property.GetMethod : property.SetMethod;
            string refSign = signatureWithoutRetVal(method);
            if (method.GetBaseDefinition().DeclaringType == type)
            {
                foreach (var item in allProperties)
                {
                    if (item.Item2.Name == property.Name
                        && item.Item2.DeclaringType != type
                        && signatureWithoutRetVal(isGet ? item.Item2.GetMethod : item.Item2.SetMethod) == refSign)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        static void searchProperties(Type type, IList<Tuple<bool, PropertyInfo>> allProperties, bool staticSearch, bool traverseHierarchy)
        {
            BindingFlags flags = BindingFlags.Public;
            flags |= staticSearch ? BindingFlags.Static : BindingFlags.Instance;

            foreach (var item in type.GetProperties(flags))
            {
                allProperties.Add(new Tuple<bool, PropertyInfo>(staticSearch, item));
            }

            if (traverseHierarchy)
            {
                foreach (var item in type.GetInterfaces())
                {
                    if (!isManagedType(item, 0, 1)) continue;
                    searchProperties(item, allProperties, staticSearch, traverseHierarchy);
                }
            }
            else if (type.BaseType != null)
            {
                if (!isManagedType(type.BaseType, 0, 1) || type.BaseType == typeof(object) || type.BaseType == typeof(Exception) || type.BaseType == typeof(Type)) return;
                searchProperties(type.BaseType, allProperties, staticSearch, traverseHierarchy);
            }
        }

        static string exportingProperties(Type type, IList<Type> imports, IList<Type> implementableInterfaces, bool withInheritance, bool isException, string destFolder, string assemblyname, out string returnInterfaceSection)
        {
            bool isInterface = false;
            returnInterfaceSection = string.Empty;
            List<Tuple<bool, PropertyInfo>> properties = new List<Tuple<bool, PropertyInfo>>();

            if (type.IsInterface)
            {
                isInterface = true;
            }

            searchProperties(type, properties, false, isInterface);
            searchProperties(type, properties, true, isInterface);

            if (properties.Count == 0) return string.Empty;

            SortedDictionary<string, Tuple<bool, PropertyInfo>> sortedData = new SortedDictionary<string, Tuple<bool, PropertyInfo>>();
            foreach (var item in properties)
            {
                var strMethod = item.Item2.ToString();
                if (!sortedData.ContainsKey(strMethod))
                {
                    sortedData.Add(strMethod, item);
                }
            }

            properties = new List<Tuple<bool, PropertyInfo>>();
            properties.AddRange(sortedData.Values);
            string templateToUse = string.Empty;

            StringBuilder propertyInterfaceBuilder = new StringBuilder();
            StringBuilder propertyBuilder = new StringBuilder();
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isManaged = true;
            bool isSpecial = false;
            bool isArray = false;

            List<string> propertiesSignaturesCreated = new List<string>();
            List<string> propertiesNameCreated = new List<string>();

            foreach (var prop in properties.ToArray())
            {
                var statics = prop.Item1;
                var item = prop.Item2;

                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref analyzedProperties);
                    }
                }
                else
                {
                    Interlocked.Increment(ref analyzedProperties);
                }

                var propertyName = item.Name;

                isPrimitive = true;
                defaultPrimitiveValue = string.Empty;
                isManaged = true;
                isSpecial = false;
                isArray = false;

                if (isException)
                {
                    if (propertyName == "Message") continue;
                    if (propertyName == "StackTrace") continue;
                }

                if (propertiesSignaturesCreated.Contains(item.ToString())
                    || item.IsSpecialName
                    || ((withInheritance && !isInterface) ? item.DeclaringType != type : false)
                    || (!propertiesNameCreated.Contains(propertyName) ? false : isDifferentOnlyForRetVal(propertiesSignaturesCreated, item.ToString(), propertyName))
                   ) continue;

                string propertyType = "void";

                propertyType = convertType(imports, item.PropertyType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                if (!isManaged) continue; // found not managed type, jump to next 

                bool isPropertyTypeInterface = isArray ? item.PropertyType.GetElementType().IsInterface : item.PropertyType.IsInterface;

                if (item.CanRead) // get
                {
                    if (item.GetMethod.GetParameters().Length != 0) continue; // only get without parameters are managed
                    isPrimitive |= typeof(Delegate).IsAssignableFrom(item.PropertyType);

                    var exceptionStr = exceptionStringBuilder(item.GetMethod, imports);

                    bool isNewPropertyVal = (withInheritance && !isInterface) ? isNewProperty(type, item, properties, true) : false;
                    string newPropertyName = string.Empty;
                    if (isNewPropertyVal)
                    {
                        newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, type.Name);
                    }

                    if (withInheritance ? (isInterface && (item.GetMethod.GetBaseDefinition().DeclaringType == type)) : isInterface)
                    {
                        string propertyInterfaceTemplate = Const.Templates.GetTemplate(isArray ? Const.Templates.ReflectorInterfaceGetArrayTemplate : Const.Templates.ReflectorInterfaceGetTemplate);

                        var propertyInterfaceStr = buildPropertySignature(propertyInterfaceTemplate, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);
                        propertyInterfaceBuilder.AppendLine(propertyInterfaceStr);
                    }

                    if (withInheritance ? (isInterface || (item.GetMethod.GetBaseDefinition().DeclaringType == type)) : true)
                    {
                        if (isArray)
                        {
                            templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayGetTemplate : Const.Templates.ReflectorClassObjectArrayGetTemplate);
                        }
                        else
                        {
                            templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeGetTemplate : Const.Templates.ReflectorClassObjectGetTemplate);
                        }

                        var propertyStr = buildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);
                        propertyBuilder.AppendLine(propertyStr);
                    }
                }
                if (item.CanWrite) // set
                {
                    var exceptionStr = exceptionStringBuilder(item.SetMethod, imports);

                    bool isNewPropertyVal = (withInheritance && !isInterface) ? isNewProperty(type, item, properties, false) : false;
                    string newPropertyName = string.Empty;
                    if (isNewPropertyVal)
                    {
                        newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, type.Name);
                    }

                    if (withInheritance ? (isInterface && (item.SetMethod.GetBaseDefinition().DeclaringType == type)) : isInterface)
                    {
                        string propertyInterfaceTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceSetTemplate);

                        var propertyInterfaceStr = buildPropertySignature(propertyInterfaceTemplate, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);
                        propertyInterfaceBuilder.AppendLine(propertyInterfaceStr);
                    }

                    if (withInheritance ? (isInterface || (item.SetMethod.GetBaseDefinition().DeclaringType == type)) : true)
                    {
                        templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassSetTemplate);
                        var propertyStr = buildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);
                        propertyBuilder.AppendLine(propertyStr);
                    }
                }

                propertiesSignaturesCreated.Add(item.ToString());
                propertiesNameCreated.Add(item.Name);

                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref implementedProperties);
                    }
                }
                else
                {
                    Interlocked.Increment(ref implementedProperties);
                }
            }

            if (!isInterface && EnableInheritance && EnableInterfaceInheritance)
            {
                foreach (var implementableInterface in implementableInterfaces)
                {
                    properties = new List<Tuple<bool, PropertyInfo>>();
                    searchProperties(implementableInterface, properties, false, true);
                    searchProperties(implementableInterface, properties, true, true);

                    if (properties.Count == 0) continue;

                    sortedData = new SortedDictionary<string, Tuple<bool, PropertyInfo>>();
                    foreach (var item in properties)
                    {
                        var strMethod = item.Item2.ToString();
                        if (!sortedData.ContainsKey(strMethod))
                        {
                            sortedData.Add(strMethod, item);
                        }
                    }

                    properties = new List<Tuple<bool, PropertyInfo>>();
                    properties.AddRange(sortedData.Values);

                    foreach (var interfaceProp in properties)
                    {
                        var statics = interfaceProp.Item1;
                        var item = interfaceProp.Item2;

                        var propertyName = item.Name;

                        isPrimitive = true;
                        defaultPrimitiveValue = string.Empty;
                        isManaged = true;
                        isSpecial = false;
                        isArray = false;

                        if (isException)
                        {
                            if (propertyName == "Message") continue;
                            if (propertyName == "StackTrace") continue;
                        }

                        if (propertiesSignaturesCreated.Contains(item.ToString())
                            || item.IsSpecialName
                            || ((withInheritance && !isInterface) ? item.DeclaringType != implementableInterface : false)
                            || (!propertiesNameCreated.Contains(propertyName) ? false : isDifferentOnlyForRetVal(propertiesSignaturesCreated, item.ToString(), propertyName))
                           ) continue;

                        string propertyType = "void";

                        propertyType = convertType(imports, item.PropertyType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        if (!isManaged) continue; // found not managed type, jump to next 

                        bool isPropertyTypeInterface = isArray ? item.PropertyType.GetElementType().IsInterface : item.PropertyType.IsInterface;

                        if (item.CanRead) // get
                        {
                            if (item.GetMethod.GetParameters().Length != 0) continue; // only get without parameters are managed
                            isPrimitive |= typeof(Delegate).IsAssignableFrom(item.PropertyType);

                            var exceptionStr = exceptionStringBuilder(item.GetMethod, imports);

                            bool isNewPropertyVal = (withInheritance && !isInterface) ? isNewProperty(implementableInterface, item, properties, true) : false;
                            string newPropertyName = string.Empty;
                            if (isNewPropertyVal)
                            {
                                newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, implementableInterface.Name);
                            }

                            if (withInheritance ? (isInterface || (item.GetMethod.GetBaseDefinition().DeclaringType == implementableInterface)) : true)
                            {
                                if (isArray)
                                {
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayGetDeprecatedTemplate : Const.Templates.ReflectorClassObjectArrayGetDeprecatedTemplate);
                                }
                                else
                                {
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeGetDeprecatedTemplate : Const.Templates.ReflectorClassObjectGetDeprecatedTemplate);
                                }

                                var propertyStr = buildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, implementableInterface.Name);
                                propertyBuilder.AppendLine(propertyStr);
                            }
                        }
                        if (item.CanWrite) // set
                        {
                            var exceptionStr = exceptionStringBuilder(item.SetMethod, imports);

                            bool isNewPropertyVal = (withInheritance && !isInterface) ? isNewProperty(type, item, properties, false) : false;
                            string newPropertyName = string.Empty;
                            if (isNewPropertyVal)
                            {
                                newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, type.Name);
                            }

                            if (withInheritance ? (isInterface || (item.SetMethod.GetBaseDefinition().DeclaringType == type)) : true)
                            {
                                templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassSetDeprecatedTemplate);
                                var propertyStr = buildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, implementableInterface.Name);
                                propertyBuilder.AppendLine(propertyStr);
                            }
                        }

                        propertiesSignaturesCreated.Add(item.ToString());
                        propertiesNameCreated.Add(item.Name);
                    }
                }
            }

            returnInterfaceSection = propertyInterfaceBuilder.ToString();

            return propertyBuilder.ToString();
        }

        static bool exportingDelegate(Type item, string destFolder, string assemblyname, bool avoidWrite = false)
        {
            if (!avoidWrite) Interlocked.Increment(ref analyzedDelegates);

            if (item.IsGenericType
                || item.IsGenericParameter
               ) return false;

            IList<Type> imports = new List<Type>();
            var invokeMethod = item.GetMethod("Invoke");

            if (invokeMethod == null) return false;

            var packageName = item.Namespace.ToLowerInvariant();
            var delegateName = item.Name;

            var parameters = invokeMethod.GetParameters();
            string returnType = "void";
            string dynamicInvokeTemplateToUse = string.Empty;
            string interfaceTemplateToUse = string.Empty;
            string classTemplateToUse = string.Empty;
            bool isPrimitive = true;
            bool isRetValPrimitive = false;
            bool isInterfaceRetVal = false;
            string defaultPrimitiveReturnValue = string.Empty;
            bool isSpecial = false;
            bool isRetValArray = false;
            bool isArray = false;
            bool isManaged = true;
            if (invokeMethod.ReturnType == typeof(void))
            {
                classTemplateToUse = Const.Templates.GetTemplate(Const.Templates.VoidDelegateClassTemplate);
                interfaceTemplateToUse = Const.Templates.GetTemplate(Const.Templates.VoidDelegateInterfaceTemplate);
                dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassVoidMethodTemplate);
            }
            else
            {
                returnType = convertType(imports, invokeMethod.ReturnType, out isRetValPrimitive, out defaultPrimitiveReturnValue, out isManaged, out isSpecial, out isRetValArray);
                if (!isManaged) return false;
                classTemplateToUse = Const.Templates.GetTemplate(isRetValPrimitive ? Const.Templates.NativeDelegateClassTemplate : Const.Templates.ObjectDelegateClassTemplate);
                interfaceTemplateToUse = Const.Templates.GetTemplate(Const.Templates.NonVoidDelegateInterfaceTemplate);
                if (isRetValArray)
                {
                    isInterfaceRetVal = invokeMethod.ReturnType.GetElementType().IsInterface;
                    dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(isRetValPrimitive ? Const.Templates.ReflectorClassNativeArrayMethodTemplate : Const.Templates.ReflectorClassObjectArrayMethodTemplate);
                }
                else
                {
                    isInterfaceRetVal = invokeMethod.ReturnType.IsInterface;
                    dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(isRetValPrimitive ? Const.Templates.ReflectorClassNativeMethodTemplate : Const.Templates.ReflectorClassObjectMethodTemplate);
                }
            }

            StringBuilder converterBlock = new StringBuilder();
            StringBuilder inputParams = new StringBuilder();
            StringBuilder execParams = new StringBuilder();
            StringBuilder dynamicInvokeExecParams = new StringBuilder();
            int paramCounter = 0;
            string defaultPrimitiveValue = string.Empty;
            foreach (var parameter in parameters)
            {
                string paramType = convertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                isManaged &= !parameter.IsOut; // out parameters not managed
                if (!isManaged) break; // found not managed type, stop here

                var paramName = checkForkeyword(parameter.Name);

                if (isArray)
                {
                    string formatter = string.Empty;
                    formatter = isPrimitive ? Const.Delegates.CONVERTER_BLOCK_PARAMETER_PRIMITIVE_ARRAY : Const.Delegates.CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE_ARRAY;

                    formatter = formatter.Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_TYPE, paramType)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_IMPLEMENTATION_PARAM_TYPE, parameter.ParameterType.IsInterface ? paramType + Const.SpecialNames.ImplementationTrailer : paramType)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_NAME, paramName)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_INDEX, paramCounter.ToString());

                    converterBlock.AppendLine(formatter);
                }
                else
                {
                    converterBlock.AppendLine(string.Format(isPrimitive ? Const.Delegates.CONVERTER_BLOCK_PARAMETER_PRIMITIVE : Const.Delegates.CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE, parameter.ParameterType.IsInterface ? paramType + Const.SpecialNames.ImplementationTrailer : paramType, paramName, paramCounter));
                }

                inputParams.Append(string.Format(Const.Delegates.INPUT_INVOKE_PARAMETER, (isArray) ? paramType + Const.SpecialNames.ArrayTrailer : paramType, paramName));
                execParams.Append(string.Format(Const.Delegates.INVOKE_PARAMETER, paramName));

                string dynamicFormatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                if (!isPrimitive && isArray) dynamicFormatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                string objectCaster = string.Empty;
                if (isArray && parameters.Length == 1)
                {
                    objectCaster = "(Object)";
                }

                dynamicInvokeExecParams.Append(string.Format(dynamicFormatter, objectCaster, paramName));
                paramCounter++;
            }
            if (!isManaged) return false; // found not managed type, jump to next 

            if (avoidWrite) return true; // blocks operation here because the real write was done in another piece of code, but we are sure someone have made it

            string converterBlockStr = converterBlock.ToString();

            string inputParamStr = inputParams.ToString();
            if (!string.IsNullOrEmpty(inputParamStr))
            {
                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
            }

            string execParamStr = execParams.ToString();
            if (!string.IsNullOrEmpty(execParamStr))
            {
                execParamStr = execParamStr.Substring(0, execParamStr.Length - 2);
            }

            var exceptionStr = exceptionStringBuilder(invokeMethod, imports);

            var importsStr = exportingImports(imports);

            var strReturnStatement = Const.Delegates.DELEGATE_RETURN_STATEMENT_OBJECT;
            if (isRetValArray)
            {
                strReturnStatement = Const.Delegates.DELEGATE_RETURN_STATEMENT_OBJECT_ARRAY.Replace(Const.Delegates.DELEGATE_RETURN_STATEMENTTYPE, returnType);
            }

            var interfaceStr = interfaceTemplateToUse.Replace(Const.Delegates.PACKAGE_NAME, packageName)
                                                     .Replace(Const.Delegates.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                     .Replace(Const.Delegates.PACKAGE_IMPORT_SECTION, importsStr)
                                                     .Replace(Const.Delegates.PACKAGE_CLASS_NAME, delegateName)
                                                     .Replace(Const.Delegates.DELEGATE_RETURN_TYPE, (isRetValArray) ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                     .Replace(Const.Delegates.DELEGATE_PARAMETERS, inputParamStr)
                                                     .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            var fileName = Path.Combine(pathToSaveTo, string.Format("I{0}.java", delegateName));
            writeFile(fileName, interfaceStr);

            importsStr = importsStr + string.Format(Const.Imports.IMPORT, packageName, string.Format("I{0}", delegateName));

            string dynamicInvokeExecParamStr = dynamicInvokeExecParams.ToString();
            var dynamicInvokeStr = dynamicInvokeTemplateToUse.Replace(Const.Methods.METHOD_JAVA_NAME, Const.SpecialNames.METHOD_DYNAMICINVOKE_NAME)
                                                             .Replace(Const.Methods.METHOD_NAME, Const.SpecialNames.METHOD_DYNAMICINVOKE_NAME)
                                                             .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                             .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                             .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                             .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, dynamicInvokeExecParamStr)
                                                             .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, string.Empty)
                                                             .Replace(Const.Methods.METHOD_OBJECT, Const.Class.INSTANCE_CLASS_NAME)
                                                             .Replace(Const.Exceptions.THROWABLE_TEMPLATE, string.Empty);

            var delegateStr = classTemplateToUse.Replace(Const.Delegates.PACKAGE_NAME, packageName)
                                                .Replace(Const.Delegates.PACKAGE_IMPORT_SECTION, importsStr)
                                                .Replace(Const.Delegates.PACKAGE_CLASS_NAME, delegateName)
                                                .Replace(Const.Delegates.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                .Replace(Const.Delegates.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                .Replace(Const.Delegates.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                .Replace(Const.Delegates.DELEGATE_INVOKE_PARAMETERS_CONVERTER_BLOCK, converterBlockStr)
                                                .Replace(Const.Delegates.DELEGATE_INVOKE_PARAMETERS, execParamStr)
                                                .Replace(Const.Delegates.DELEGATE_PARAMETERS, inputParamStr)
                                                .Replace(Const.Delegates.DELEGATE_RETURN_STATEMENT, strReturnStatement)
                                                .Replace(Const.Delegates.DELEGATE_RETURN_TYPE, (isRetValArray) ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                .Replace(Const.Delegates.DELEGATE_PRIMITIVE_DEFAULT_VALUE, defaultPrimitiveReturnValue)
                                                .Replace(Const.Delegates.DELEGATE_PRIMITIVE_DEFAULT_VALUE, defaultPrimitiveReturnValue)
                                                .Replace(Const.Delegates.DELEGATE_DYNAMIC_INVOKE_SECTION, dynamicInvokeStr)
                                                .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", delegateName));
            writeFile(fileName, delegateStr);

            Interlocked.Increment(ref implementedDelegates);

            return true;
        }

        static bool isNewEvent(Type type, EventInfo eventInfo, IList<EventInfo> allEvents)
        {
            MethodInfo method = eventInfo.AddMethod;
            string refSign = signatureWithoutRetVal(eventInfo.AddMethod);
            if (method.GetBaseDefinition().DeclaringType == type)
            {
                foreach (var item in allEvents)
                {
                    if (item.Name == eventInfo.Name
                        && item.DeclaringType != type
                        && signatureWithoutRetVal(item.AddMethod) == refSign)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        static void searchEvents(Type type, BindingFlags flags, IList<EventInfo> allEvents, bool traverseHierarchy)
        {
            foreach (var item in type.GetEvents(flags))
            {
                allEvents.Add(item);
            }

            if (traverseHierarchy)
            {
                foreach (var item in type.GetInterfaces())
                {
                    if (!isManagedType(item, 0, 1)) continue;
                    searchEvents(item, flags, allEvents, traverseHierarchy);
                }
            }
            else if (type.BaseType != null)
            {
                if (!isManagedType(type.BaseType, 0, 1) || type.BaseType == typeof(object) || type.BaseType == typeof(Exception) || type.BaseType == typeof(Type)) return;
                searchEvents(type.BaseType, flags, allEvents, traverseHierarchy);
            }
        }

        static string exportingEvents(Type type, IList<Type> imports, IList<Type> implementableInterfaces, bool withInheritance, bool statics, bool isException, string destFolder, string assemblyname, out string returnInterfaceSection)
        {
            bool isInterface = false;
            returnInterfaceSection = string.Empty;

            BindingFlags flags = BindingFlags.Public;
            flags |= statics ? BindingFlags.Static : BindingFlags.Instance;

            EventInfo[] events = null;

            List<EventInfo> allEvents = new List<EventInfo>();

            if (type.IsInterface)
            {
                isInterface = true;
            }
            searchEvents(type, flags, allEvents, isInterface);
            events = allEvents.ToArray();

            if (events.Length == 0) return string.Empty;

            SortedDictionary<string, EventInfo> sortedData = new SortedDictionary<string, EventInfo>();
            foreach (var item in events)
            {
                var strMethod = item.ToString();
                if (!sortedData.ContainsKey(strMethod))
                {
                    sortedData.Add(strMethod, item);
                }
            }

            var eventLst = new List<EventInfo>();
            eventLst.AddRange(sortedData.Values);

            events = eventLst.ToArray();

            string templateInterfaceToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceEventTemplate);
            string templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassEventTemplate);

            StringBuilder eventInterfaceBuilder = new StringBuilder();
            StringBuilder eventBuilder = new StringBuilder();
            eventBuilder.AppendLine();
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isConcrete = true;
            bool isSpecial = false;
            bool isArray = false;

            List<string> eventsSignaturesCreated = new List<string>();
            List<string> eventsNameCreated = new List<string>();

            foreach (var item in events)
            {
                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref analyzedEvents);
                    }
                }
                else
                {
                    Interlocked.Increment(ref analyzedEvents);
                }

                var eventName = item.Name;

                isPrimitive = true;
                defaultPrimitiveValue = string.Empty;
                isConcrete = true;
                isSpecial = false;
                isArray = false;

                if (isException)
                {
                    if (eventName == "Message") continue;
                    if (eventName == "StackTrace") continue;
                }

                if (eventsSignaturesCreated.Contains(item.ToString())
                    || item.IsSpecialName
                    || ((withInheritance && !isInterface) ? item.DeclaringType != type : false)
                    || (!eventsNameCreated.Contains(eventName) ? false : isDifferentOnlyForRetVal(eventsSignaturesCreated, item.ToString(), eventName))
                   ) continue;

                string eventType = "void";
                StringBuilder inputParams = new StringBuilder();
                StringBuilder execParams = new StringBuilder();

                if (!exportingDelegate(item.EventHandlerType, destFolder, assemblyname, true)) continue;

                eventType = convertType(imports, item.EventHandlerType, out isPrimitive, out defaultPrimitiveValue, out isConcrete, out isSpecial, out isArray);
                if (!isConcrete) continue; // found not managed type, jump to next 

                bool isNewEventVal = (withInheritance && !isInterface) ? isNewEvent(type, item, eventLst) : false;
                string newEventName = string.Empty;
                if (isNewEventVal)
                {
                    newEventName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, eventName, type.Name);
                }


                var eventStr = templateToUse.Replace(Const.Events.EVENT_JAVA_NAME, isNewEventVal ? newEventName : eventName)
                                            .Replace(Const.Events.EVENT_NAME, eventName)
                                            .Replace(Const.Events.EVENT_HANDLER_TYPE, item.EventHandlerType.Name)
                                            .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, statics ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                            .Replace(Const.Events.EVENT_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

                eventsSignaturesCreated.Add(item.ToString());
                eventsNameCreated.Add(item.Name);

                if (withInheritance ? (isInterface && (item.AddMethod.GetBaseDefinition().DeclaringType == type)) : isInterface)
                {
                    var eventInterfaceStr = templateInterfaceToUse.Replace(Const.Events.EVENT_JAVA_NAME, isNewEventVal ? newEventName : eventName)
                                                                  .Replace(Const.Events.EVENT_NAME, eventName)
                                                                  .Replace(Const.Events.EVENT_HANDLER_TYPE, item.EventHandlerType.Name)
                                                                  .Replace(Const.Events.METHOD_MODIFIER_KEYWORD, statics ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                                                  .Replace(Const.Events.EVENT_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

                    eventInterfaceBuilder.AppendLine(eventInterfaceStr);
                }

                eventBuilder.AppendLine(eventStr);

                if (withInheritance)
                {
                    if (item.DeclaringType == type)
                    {
                        Interlocked.Increment(ref implementedEvents);
                    }
                }
                else
                {
                    Interlocked.Increment(ref implementedEvents);
                }
            }

            if (isInterface) returnInterfaceSection = eventInterfaceBuilder.ToString();

            return eventBuilder.ToString();
        }

        static string exportingImports(IList<Type> imports)
        {
            StringBuilder importsToExport = new StringBuilder();
            foreach (var item in imports)
            {
                if (item.IsInterface)
                {
                    if (isManagedType(item, 0, 1) && item != typeof(IEnumerator) && item != typeof(IEnumerable))
                    {
                        importsToExport.AppendLine(string.Format(Const.Imports.IMPORT, item.Namespace.ToLowerInvariant(), item.Name));
                        importsToExport.AppendLine(string.Format(Const.Imports.IMPORT, item.Namespace.ToLowerInvariant(), item.Name + Const.SpecialNames.ImplementationTrailer));
                    }
                }
                else if (isManagedType(item, 0, 1))
                {
                    importsToExport.AppendLine(string.Format(Const.Imports.IMPORT, item.Namespace.ToLowerInvariant(), item.Name));
                }
            }

            return importsToExport.ToString();
        }

        static bool isManagedType(Type type, int recursion, int limit)
        {
            if (recursion == limit) return false; // we don't manage array of arrays
            if (type.FullName == Const.SpecialNames.XamlReader) return false;
            if (type.IsArray)
            {
                if (!EnableArray) return false;  // uncomment to disable array
                if (type.Name.Contains(Const.SpecialNames.MultiArrayTrailer)) return false;
                else if (type.Name.Contains(Const.SpecialNames.ArrayTrailer))
                {
                    var tmp = type.Name.Substring(0, type.Name.LastIndexOf(Const.SpecialNames.ArrayTrailer));
                    if (tmp.Contains(Const.SpecialNames.ArrayTrailer)) return false; // it is [][]
                    return isManagedType(type.GetElementType(), recursion + 1, limit);
                }
                else return false;
            }
            if (typeof(Type).IsAssignableFrom(type)) // special type
            {
                return true;
            }
            if (!type.IsPublic // only public types are managed
                || !(type.IsAnsiClass || type.IsClass || type.IsEnum)
                 || (EnableAbstract ? false : (type.IsAbstract && !type.IsSealed)) // discard real abstract class for now, but abstract/sealed classes are what in .NET are "public static class"
                                                                                   //  || type.IsInterface // discard interfaces for now
                 || type.IsGenericType || type.IsGenericParameter)
            {
                return false;
            }
            if (typeof(Delegate).IsAssignableFrom(type)) // delegate types are managed only with events
            {
                return exportingDelegate(type, null, null, true);
            }

            if (type.Name.Contains("IntPtr"))
                return false;
            if (type.Name.Contains("*"))
                return false;
            if (type.IsByRef)
                return false;

            return true;
        }

        static string checkForSpecialNames(string name, Type type, out bool needImport)
        {
            needImport = true;
            if (name == "ArrayList") { needImport = false; return type.Namespace.ToLowerInvariant() + "." + type.Name; }
            if (name == "Binding") { needImport = false; return type.Namespace.ToLowerInvariant() + "." + type.Name; }
            if (name == "XamlReader") { needImport = false; return type.Namespace.ToLowerInvariant() + "." + type.Name; }
            return name;
        }

        static string checkForPrimitive(Type type, bool isArray, out bool isPrimitive, out string defaultPrimitiveValue, out bool needImport)
        {
            needImport = false;
            isPrimitive = true;
            defaultPrimitiveValue = string.Empty;
            var fullName = (isArray) ? type.FullName.Substring(0, type.FullName.IndexOf(Const.SpecialNames.ArrayTrailer)) : type.FullName;
            var name = (isArray) ? type.Name.Substring(0, type.Name.IndexOf(Const.SpecialNames.ArrayTrailer)) : type.Name;
            string retType = string.Empty;
            switch (fullName)
            {
                case "System.Boolean": retType = "boolean"; defaultPrimitiveValue = "false"; break;
                case "System.Byte": retType = "byte"; defaultPrimitiveValue = "0"; break;
                case "System.Char": retType = "char"; defaultPrimitiveValue = "0"; break;
                case "System.Float": retType = "float"; defaultPrimitiveValue = "0.0f"; break;
                case "System.Double": retType = "double"; defaultPrimitiveValue = "0"; break;
                case "System.Int64": retType = "long"; defaultPrimitiveValue = "0"; break;
                case "System.Int32": retType = "int"; defaultPrimitiveValue = "0"; break;
                case "System.Int16": retType = "short"; defaultPrimitiveValue = "0"; break;
                case "System.String": retType = Const.SpecialNames.NativeStringType; defaultPrimitiveValue = "\"\""; break;
                default:
                    {
                        isPrimitive = false;
                        retType = checkForSpecialNames(name, type, out needImport);
                    }
                    break;
            }
            return retType;
        }

        static string checkIsSpecial(Type type, out bool isSpecial)
        {
            isSpecial = false;
            if (type == typeof(object)) { isSpecial = true; return Const.SpecialNames.NetObject; }
            if (type == typeof(Type)) { isSpecial = true; return Const.SpecialNames.NetType; }
            if (type == typeof(Exception)) { isSpecial = true; return Const.SpecialNames.NetException; }
            if (type == typeof(ArrayList)) { isSpecial = true; return Const.SpecialNames.NetArrayList; }
            if (type == typeof(IEnumerable)) { isSpecial = true; return Const.SpecialNames.NetIEnumerable; }
            if (type == typeof(IEnumerator)) { isSpecial = true; return Const.SpecialNames.NetIEnumerator; }

            return type.Name;
        }

        static string convertType(IList<Type> imports, Type type, out bool isPrimitive, out string defaultPrimitiveValue, out bool isManaged, out bool isSpecial, out bool isArray, bool storeInImports = true)
        {
            isPrimitive = true;
            defaultPrimitiveValue = string.Empty;
            isSpecial = false;
            isArray = type.IsArray || type.Name.Contains("[]");
            isManaged = isManagedType(type, 0, 2);
            bool needImport = true;
            try
            {
                if (!isManaged) { return string.Empty; }
                var special = checkIsSpecial((isArray) ? type.GetElementType() : type, out isSpecial);
                if (isSpecial) { needImport = false; isPrimitive = false; return special; }

                return checkForPrimitive(type, isArray, out isPrimitive, out defaultPrimitiveValue, out needImport);
            }
            finally
            {
                if (imports != null && storeInImports && needImport && isManaged)
                {
                    if (isArray && isManagedType(type.GetElementType(), 0, 1))
                    {
                        Type innerType = type.GetElementType();

                        bool isArrayHere = innerType.IsArray || innerType.Name.Contains(Const.SpecialNames.ArrayTrailer);
                        if (!isArrayHere)
                        {
                            bool isSpecialHere;
                            bool isPrimitiveHere;
                            bool needImportHere;
                            string defaultPrimitiveValueHere;
                            checkIsSpecial(type.GetElementType(), out isSpecialHere);
                            checkForPrimitive(type.GetElementType(), isArrayHere, out isPrimitiveHere, out defaultPrimitiveValueHere, out needImportHere);
                            if (needImportHere && !isPrimitiveHere && !isSpecialHere && !imports.Contains(type.GetElementType()))
                            {
                                imports.Add(type.GetElementType());
                            }
                        }
                    }
                    else if (!isPrimitive && !isSpecial && !imports.Contains(type))
                    {
                        imports.Add(type);
                    }
                }
            }
        }
    }
}
