/*
 *  MIT License
 *
 *  Copyright (c) 2020-2026 MASES s.r.l.
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
using System.Text.RegularExpressions;
using System.Threading;
using System.Threading.Tasks;

namespace MASES.JCOReflector.Engine
{
    static partial class Reflector
    {
        static List<string> assemblyReferenced = new List<string>();
        static List<string> assemblyParsed = new List<string>();

        static bool EnableWrite = true;

        static bool EnableAbstract = true;
        static bool EnableArray = true;
        static bool EnableDuplicateMethodNativeArrayWithJCRefOut = true;
        static bool EnableInheritance = false;
        static bool EnableInterfaceInheritance = false;
        static bool EnableRefOutParameters = false;
        static bool EnableGenerics = false;

        static string SourceDestinationFolder;
        static string CsvDestinationFolder;
        static bool SplitByAssembly;
        static bool ForceRebuild;
        static bool UseParallelBuild;
        static bool AvoidHierarchyTraversing;
        static bool CreateExceptionThrownClause;
        static int ExceptionThrownClauseDepth;
        static bool AvoidDisableInternalNamespace;


        static string reflectorVersion = typeof(Reflector).Assembly.GetName().Version.ToString();

        static string ReplaceSinglekeyword(string inputName)
        {
            foreach (var item in Const.KeyWords)
            {
                if (inputName == item) return "_" + item;
            }

            return inputName;
        }

        static string GetAssemblies(this IEnumerable<string> assemblyNames)
        {
            string res;
            try
            {
                StringBuilder sb = new StringBuilder();
                foreach (var item in assemblyNames)
                {
                    sb.AppendLine(item);
                }
                res = sb.ToString();
            }
            catch (Exception ex)
            {
                res = string.Format("Error {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, res);
            }
            return res;
        }

        static void PrepareExclusion()
        {
            Const.SpecialNames.ExportingAvoidanceMap.Clear();

            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Net\.Http\.Headers\.MediaTypeWithQualityHeaderValue$", new string[] { "TryParse" });
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Net\.Http\.Headers\.NameValueWithParametersHeaderValue$", new string[] { "TryParse" });
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Net\.Http\.Headers\.TransferCodingWithQualityHeaderValue$", new string[] { "TryParse" });
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^Microsoft\.VisualBasic\.FileSystem$", new string[] { "FileGet", "Input" });
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Threading\.Thread$", new string[] { "VolatileRead" });
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Threading\.Volatile$", new string[] { "Read" });
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Threading\.Interlocked$", new string[] { "Decrement", "Increment"
#if NET6_0 || NET7_0 || NET8_0 || NET9_0 || NET10_0 || NET11_0
                                                                                              , "Read"
#endif
                                                                                            });
#if NET7_0 || NET8_0 || NET9_0 || NET10_0 || NET11_0
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Runtime\.InteropServices\.JavaScript\.JSMarshalerArgument$", new string[] { "ToManaged" });
            if (EnableGenerics)
            {
                // Generic math (C# 11 "static abstract members in interfaces"): no Java equivalent for a
                // static abstract interface member, and the operator interfaces bind TResult=bool, which
                // never satisfies our IJCOBridgeReflected bound. One pattern for the whole .NET 7+ family
                // instead of one entry per interface — the arity (`1, `2, `3...) differs by interface and
                // has changed across .NET versions, \d+ matches any of them.
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Numerics\.I\w+`\d+$", null);
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.I(Span|Utf8Span)?Parsable`\d+$", null);
            }
#endif
#if NET8_0 || NET9_0 || NET10_0 || NET11_0
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Runtime\.InteropServices\.Marshalling\.IIUnknownInterfaceType$", null);
#endif
#if NET10_0 || NET11_0
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.MemoryExtensions$", null);
            Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Runtime\.InteropServices\.Java\.JavaMarshal$", new string[] { "Initialize" });
#endif
            if (EnableGenerics)
            {
                // TEMPORARY: parked here to unblock compilation. Each of these is either a genuine Java
                // erasure limit (two .NET members that can't coexist once type arguments are erased) or a
                // bug not yet root-caused — revisit before removing.
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.ServiceModel\.Syndication\.SyndicationElementExtensionCollection$", new string[] { "Add" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Collections\.Generic\.ICollection`1$", new string[] { "Add", "Remove" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Collections\.Immutable\.ImmutableArray`1$", new string[] { "AddRange" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Runtime\.Intrinsics\.X86\.Sse41$", new string[] { "Extract" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Guid$", new string[] { "TryFormat" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Version$", new string[] { "TryFormat" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Text\.Rune$", new string[] { "TryFormat" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Net\.IPAddress$", new string[] { "TryFormat" });
                Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Net\.IPNetwork$", new string[] { "TryFormat" });
				Const.SpecialNames.ExportingAvoidanceMap.Add(@"^System\.Windows\.Markup\.INameScopeDictionary$", null);
            }

            Const.SpecialNames.DirectMappablePrimitives.Clear();

            Const.SpecialNames.DirectMappablePrimitives.Add("boolean", "java.util.concurrent.atomic.AtomicBoolean");
            Const.SpecialNames.DirectMappablePrimitives.Add("byte", "java.util.concurrent.atomic.AtomicReference<java.lang.Byte>");
            Const.SpecialNames.DirectMappablePrimitives.Add("short", "java.util.concurrent.atomic.AtomicReference<java.lang.Short>");
            Const.SpecialNames.DirectMappablePrimitives.Add("float", "java.util.concurrent.atomic.AtomicReference<java.lang.Float>");
            Const.SpecialNames.DirectMappablePrimitives.Add("double", "java.util.concurrent.atomic.AtomicReference<java.lang.Double>");
            Const.SpecialNames.DirectMappablePrimitives.Add("int", "java.util.concurrent.atomic.AtomicInteger");
            Const.SpecialNames.DirectMappablePrimitives.Add("long", "java.util.concurrent.atomic.AtomicLong");
        }

        static void WriteExtraClasses(ReflectorEventArgs args)
        {
            string destFolder = assemblyDestinationFolder(SourceDestinationFolder, new AssemblyName(Const.SpecialNames.JCOReflectorGeneratedFolder), SplitByAssembly);
            var jcoBridgeOptionsFile = Path.Combine(destFolder, Const.FileNameAndDirectory.OrgSubDirectory,
                                                     Const.FileNameAndDirectory.MasesSubDirectory,
                                                     Const.FileNameAndDirectory.JCOBridgeSubDirectory,
                                                     Const.FileNameAndDirectory.NetreflectionSubDirectory,
                                                     Const.FileNameAndDirectory.JCOReflectorOptionsFile);

            var jcoBridgeOptionsTemplate = Const.Templates.GetTemplate(Const.Templates.JCOReflectorOptionsTemplate);
            StringBuilder assembyStrSb = new StringBuilder();
            foreach (var item in args.AssemblyNames)
            {
                assembyStrSb.AppendFormat("\"{0}\", ", item);
            }
            var assembyStr = assembyStrSb.ToString();
            assembyStr = assembyStr.Substring(0, assembyStr.Length - 2);

            var jcoBridgeOptionsContent = jcoBridgeOptionsTemplate.Replace(Const.Class.JCOREFLECTOR_VERSION, Const.ReflectorVersion)
                                                                  .Replace(Const.Options.Assembly_Names_Value, assembyStr)
                                                                  .Replace(Const.Options.Create_Exception_Thrown_Clause_Value, CreateExceptionThrownClause ? "true" : "false")
                                                                  .Replace(Const.Options.Exception_Thrown_Clause_Depth_Value, ExceptionThrownClauseDepth.ToString())
                                                                  .Replace(Const.Options.Enable_Abstract_Value, EnableAbstract ? "true" : "false")
                                                                  .Replace(Const.Options.Enable_Array_Value, EnableArray ? "true" : "false")
                                                                  .Replace(Const.Options.Enable_Duplicate_Method_Native_Array_With_JCORefOut_Value, EnableDuplicateMethodNativeArrayWithJCRefOut ? "true" : "false")
                                                                  .Replace(Const.Options.Enable_Inheritance_Value, EnableInheritance ? "true" : "false")
                                                                  .Replace(Const.Options.Enable_Interface_Inheritance_Value, EnableInterfaceInheritance ? "true" : "false")
                                                                  .Replace(Const.Options.Enable_RefOut_Parameters_Value, EnableRefOutParameters ? "true" : "false")
                                                                  .Replace(Const.Options.Enable_Generics_Parameters_Value, EnableGenerics ? "true" : "false");

            writeFile(jcoBridgeOptionsFile, jcoBridgeOptionsContent);
        }

        public static async Task ExecuteAction(object o)
        {
            ResetStatistics();

            bool failed = false;
            List<Type> typesToExport = new List<Type>();
            ReflectorEventArgs args = o as ReflectorEventArgs;

            var location = typeof(JavaBuilder).Assembly.Location;
            location = Path.GetDirectoryName(location);
            Environment.CurrentDirectory = location;

            if (!Path.IsPathRooted(args.SourceFolder))
            {
                args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
            }

            SourceDestinationFolder = Path.GetFullPath(Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory));
            CsvDestinationFolder = Path.GetFullPath(Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.StatsDirectory));
            SplitByAssembly = args.SplitFolderByAssembly;
            ForceRebuild = args.ForceRebuild;
            UseParallelBuild = args.UseParallelBuild;
            AvoidHierarchyTraversing = args.AvoidHierarchyTraversing;
            CreateExceptionThrownClause = args.CreateExceptionThrownClause;
            ExceptionThrownClauseDepth = args.ExceptionThrownClauseDepth;
            EnableAbstract = args.EnableAbstract;
            EnableArray = args.EnableArray;
            EnableDuplicateMethodNativeArrayWithJCRefOut = args.EnableDuplicateMethodNativeArrayWithJCRefOut;
            EnableInheritance = args.EnableInheritance;
            EnableInterfaceInheritance = args.EnableInterfaceInheritance;
            EnableRefOutParameters = args.EnableRefOutParameters;
            EnableGenerics = args.EnableGenerics;
            EnableWrite = !args.DryRun;
            AvoidDisableInternalNamespace = args.AvoidDisableInternalNamespace;

            PrepareExclusion();
            WriteExtraClasses(args);

            string reportStr = string.Empty;
            try
            {
                foreach (var item in args.AssemblyNames)
                {
                    Assembly assembly = null;
                    if (File.Exists(item))
                    {
                        JobManager.AppendToConsole(LogLevel.Info, "Loading assembly from path {0}", item);
                        assembly = Assembly.LoadFrom(item);
                    }
                    else
                    {
                        JobManager.AppendToConsole(LogLevel.Info, "Loading assembly {0}", item);
                        assembly = Assembly.Load(item);
                    }

                    await ExportAssemblyWithReferences(assemblyReferenced, assemblyParsed, assembly, new AssemblyName(assembly.FullName), SourceDestinationFolder, SplitByAssembly, ForceRebuild);
                }

                if (!args.AvoidReportAndStatistics)
                {
                    reportStr = args.AssemblyNames.GetReport();
                    var reportfile = Path.Combine(args.SourceFolder, Const.Report.REPORT_FILE_TO_WRITE);
                    if (File.Exists(reportfile))
                    {
                        var beginTag = string.Format(Const.Report.REPORT_BEGIN_PLACEHOLDER, Const.Framework.RuntimeFolder);
                        var endTag = string.Format(Const.Report.REPORT_END_PLACEHOLDER, Const.Framework.RuntimeFolder);
                        var readmeContent = File.ReadAllText(reportfile);
                        int beginTagIndex = readmeContent.IndexOf(beginTag);
                        int endTagIndex = readmeContent.IndexOf(endTag);
                        if (beginTagIndex < 0) throw new InvalidOperationException(string.Format("File {0} does not contain the {1} tag", reportfile, beginTag));
                        if (endTagIndex < 0) throw new InvalidOperationException(string.Format("File {0} does not contain the {1} tag", reportfile, endTag));

                        StringBuilder sb = new StringBuilder();
                        var preText = readmeContent.Substring(0, beginTagIndex);
                        sb.Append(preText);
                        sb.AppendLine(beginTag);
                        sb.AppendLine(reportStr);
                        var endText = readmeContent.Substring(endTagIndex);
                        sb.Append(endText);
                        writeFile(reportfile, sb.ToString());
                    }

                    var assemblies = assemblyReferenced.GetAssemblies();
                    var assembliesFile = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory, Const.Framework.RuntimeFolder, Const.Report.ASSEMBLIES_FILE_TO_WRITE);
                    writeFile(assembliesFile, assemblies);

                    string statisticsError;
                    string statisticsCsv = GetStatisticsCsv(out statisticsError);

                    if (!string.IsNullOrEmpty(statisticsError))
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
            }
            catch (OperationCanceledException ex)
            {
                JobManager.AppendToConsole(LogLevel.Error, "ExportAssembly error: {0}", ex.Message);
                if (JobManager.ReportException)
                {
                    throw;
                }
            }
            catch (Exception ex)
            {
                JobManager.AppendToConsole(LogLevel.Error, "ExportAssembly error: {0}", ex.Message);
                failed = true;
                if (JobManager.ReportException)
                {
                    throw;
                }
            }
            finally
            {
                JobManager.EndOperation(new EndOperationEventArgs(reportStr, failed));
            }
        }

        public static async Task ExportAssemblyWithReferences(IList<string> assemblyReferenced, IList<string> assemblyParsed, Assembly loadedAssembly, AssemblyName assemblyName, string rootFolder, bool splitByAssembly, bool forceRebuild)
        {
            if (assemblyReferenced.Contains(assemblyName.FullName)) return;
            var assembly = ExportAssembly(assemblyReferenced, assemblyParsed, loadedAssembly, assemblyName, rootFolder, splitByAssembly, forceRebuild);
            assemblyReferenced.Add(assemblyName.FullName);
            if (assembly == null) return;
            if (AvoidHierarchyTraversing) return;
            foreach (var item in assembly.GetReferencedAssemblies())
            {
                await ExportAssemblyWithReferences(assemblyReferenced, assemblyParsed, null, item, rootFolder, splitByAssembly, forceRebuild);
            }
        }

        static string assemblyDestinationFolder(string rootFolder, AssemblyName assemblyName, bool splitByAssembly)
        {
            return Path.Combine(rootFolder, Const.Framework.RuntimeFolder, splitByAssembly ? assemblyName.ToFolderName() : string.Empty);
        }

        static bool TypePrefilter(this Type type)
        {
            // ref structs (Span<T>, ReadOnlySpan<T>, and any future ones) wrap a native pointer/stack
            // reference that cannot survive being boxed or passed through the bridge as an object —
            // JCOBridge has no way to represent them at all, generics or not. Exclude the whole type.
#if NET5_0_OR_GREATER
            if (EnableGenerics && type.IsByRefLike) return false;
#endif
            // Whole-type exclusions from ExportingAvoidanceMap (entries with a null member list) must also
            // stop the type itself from being exported as its own file — skipping just its members left
            // the type's Implementation class generated anyway, still missing methods it inherits from
            // non-excluded interfaces like IComparable/IFormattable.
            if (CheckExportingAvoidanceMap(type.FullName ?? type.Name, string.Empty)) return false;

            // Allow public types and valid generic type definitions, while discarding raw generic parameters (like T)
            if (type.IsPublic
                && (!type.IsGenericType || (EnableGenerics && type.IsGenericTypeDefinition))
                && (AvoidDisableInternalNamespace || !type.ToPackageName().Contains(Const.SpecialNames.Internal)) // avoid types with internal namespace name which are public
               )
            {
                return true;
            }
            return false;
        }

        public static Assembly ExportAssembly(IList<string> assemblyReferenced, IList<string> assemblyParsed, Assembly loadedAssembly, AssemblyName assemblyName, string rootFolder, bool splitByAssembly, bool forceRebuild)
        {
            string destFolder = assemblyDestinationFolder(rootFolder, assemblyName, splitByAssembly);

            if (splitByAssembly && Directory.Exists(destFolder))
            {
                if (!forceRebuild)
                {
                    JobManager.AppendToConsole(LogLevel.Info, "Skipping assembly {0}", assemblyName);
                    return null;
                }
                if (assemblyReferenced.Contains(assemblyName.FullName))
                {
                    JobManager.AppendToConsole(LogLevel.Info, "Skipping assembly {0}", assemblyName);
                    return null;
                }
            }

            if (assemblyReferenced.Contains(assemblyName.FullName))
            {
                JobManager.AppendToConsole(LogLevel.Info, "Duplicated assembly {0}", assemblyName);
            }

            Assembly assembly = loadedAssembly;
            if (assembly == null)
            {
                JobManager.AppendToConsole(LogLevel.Info, "Loading assembly {0}", assemblyName);
                try
                {
                    assembly = Assembly.Load(assemblyName);
                    JobManager.AppendToConsole(LogLevel.Info, "Loaded assembly {0}", assembly.FullName);
                }
                catch (Exception ex)
                {
                    JobManager.AppendToConsole(LogLevel.Error, "Skipping assembly {0}. Error is: {1}", assemblyName, ex.Message);
                    return null;
                }
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
                JobManager.AppendToConsole(LogLevel.Info, "Assembly previously parsed {0}", assembly.FullName);
                return assembly;
            }

            List<Type> typesToExport = new List<Type>();

            JobManager.AppendToConsole(LogLevel.Info, "Getting types from {0}", assembly.FullName);
            var allType = assembly.GetTypes();
            JobManager.AppendToConsole(LogLevel.Verbose, "Searching only public types...");
            foreach (var item in allType)
            {
                Interlocked.Increment(ref analyzedTypes);

                var typeName = item.FullName;

                if (item.TypePrefilter())
                {
                    JobManager.AppendToConsole(LogLevel.Verbose, "Store {0} within types to be exported", item.AssemblyQualifiedName);
                    typesToExport.Add(item);
                }
                else
                {
                    JobManager.AppendToConsole(LogLevel.Verbose, "Discarded {0} from types to be exported", item.AssemblyQualifiedName);
                    Interlocked.Increment(ref discardedTypes);
                    if (!item.IsPublic) Interlocked.Increment(ref discardedNonPublicTypes);
                    else if (item.IsGenericType) Interlocked.Increment(ref discardedGenericTypes);
                    else if (AvoidDisableInternalNamespace || item.ToPackageName().Contains(Const.SpecialNames.Internal)) Interlocked.Increment(ref discardedInternalTypes);
                }
            }

            if (typesToExport.Count != 0)
            {
                ExportingPublicTypes(typesToExport, destFolder, assembly.FullName);
                Interlocked.Increment(ref parsedAssemblies);
                assemblyParsed.Add(assembly.FullName);
            }
            else
            {
                JobManager.AppendToConsole(LogLevel.Info, "No public types in {0}", assembly.FullName);
            }

            return assembly;
        }

        static void ExportingPublicTypes(List<Type> typesToExport, string destFolder, string assemblyname)
        {
            JobManager.AppendToConsole(LogLevel.Info, "Start exporting public types of {0}", assemblyname);

            if (UseParallelBuild)
            {
                ParallelOptions po = new ParallelOptions();
                po.CancellationToken = JobManager.CancellationToken;
                po.MaxDegreeOfParallelism = System.Environment.ProcessorCount;
                Parallel.ForEach(typesToExport, po, ExportingPublicTypeParallel);
            }
            else
            {
                foreach (var item in typesToExport)
                {
                    ExportingPublicType(item, destFolder, assemblyname);
                }
            }
        }

        static void ExportingPublicTypeParallel(this Type typeToExport)
        {
            try
            {
                string assemblyname = typeToExport.Assembly.FullName;
                string destFolder = assemblyDestinationFolder(SourceDestinationFolder, new AssemblyName(assemblyname), SplitByAssembly);
                ExportingPublicType(typeToExport, destFolder, assemblyname);
            }
            catch (OperationCanceledException)
            {
                throw;
            }
            catch (Exception e)
            {
                JobManager.AppendToConsole(LogLevel.Error, $"Error exporting {typeToExport.Name}: {e}");
                throw;
            }
        }

        static void writeFile(string fileName, string content)
        {
            if (EnableWrite)
            {
                FileInfo fi = new FileInfo(fileName);
                if (!Directory.Exists(fi.Directory.FullName))
                    Directory.CreateDirectory(fi.Directory.FullName);
                JobManager.AppendToConsole(LogLevel.Verbose, "Saving file {0}", fileName);
                File.WriteAllText(fileName, content);
            }
        }

        static string ToPackageName(this Type type)
        {
            if (string.IsNullOrEmpty(type.Namespace)) return string.Empty;

            var basepackage = type.Namespace.ToLowerInvariant();

            foreach (var item in Const.KeyWords)
            {
                var beginning = item + ".";
                var middle = "." + item + ".";
                var end = "." + item;

                if (!basepackage.Contains(".") && basepackage == item) // package with a single element
                {
                    basepackage = basepackage.Replace(item, item + "_package");
                }
                else if (basepackage.StartsWith(beginning) || basepackage.Contains(middle) || basepackage.EndsWith(end))
                {
                    basepackage = basepackage.Replace(item, item + "_package");
                }
            }

            return basepackage;
        }

        static bool HasEnumerator(this Type type)
        {
            if (!type.IsInterface
                && (typeof(IEnumerator).IsAssignableFrom(type) || type.FullName == Const.SpecialNames.StringEnumerator)
               )
            {
                return true;
            }
            return false;
        }

        static void ExportingPublicType(this Type typeToExport, string destFolder, string assemblyname)
        {
            var typeName = typeToExport.FullName;

            // RESOLUTION GENERICS: Calculate java class name using collision checker to secure clean logs
            string javaClassName = typeToExport.GetJavaClassName(typeToExport.Assembly);
            JobManager.AppendToConsole(LogLevel.Verbose, "Start exporting {0}", javaClassName);

            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isManaged = true;
            bool isSpecial = false;
            bool isArray = false;

            // GENERICS UPDATED: Allow open generic type definitions to bypass standard conversion filters
            if (EnableGenerics && typeToExport.IsGenericTypeDefinition)
            {
                isPrimitive = false;
                isSpecial = false;
                isManaged = true;
                isArray = false;
            }
            else
            {
                ConvertType(null, typeToExport, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
            }

            if (isPrimitive || isSpecial || !isManaged)
            {
                JobManager.AppendToConsole(LogLevel.Verbose, "Discarding {0}", javaClassName);
                Interlocked.Increment(ref discardedTypes);
                return;
            }

            if (typeof(Delegate).IsAssignableFrom(typeToExport))
            {
                string dummyEnumeratorType = string.Empty;
                typeToExport.ExportingDelegate(destFolder, assemblyname, out dummyEnumeratorType);
            }
            else if (typeToExport.HasEnumerator())
            {
                string returnEnumerableType = string.Empty;
                typeToExport.ExportingEnumerator(destFolder, assemblyname, out returnEnumerableType);
            }
            else if (typeToExport.IsInterface)
            {
                typeToExport.ExportInterface(destFolder, assemblyname);
            }
            else if (typeToExport.IsEnum)
            {
                typeToExport.ExportEnum(destFolder, assemblyname);
            }
            else if (typeToExport.IsClass || typeToExport.IsAnsiClass)
            {
                typeToExport.ExportClass(destFolder, assemblyname);
            }
            else throw new InvalidOperationException(string.Format("Unchecked and unexported type {0}", typeToExport.FullName));

            JobManager.CancellationToken.ThrowIfCancellationRequested();
        }
    }
}
