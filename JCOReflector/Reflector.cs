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
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Reflection;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace MASES.C2JReflector
{
    public delegate void appendToConsoleHandler(string format, params object[] args);

    public class ReflectorEventArgs : EventArgs
    {
        public LogLevel LogLevel { get; set; }
        public string AssemblyName { get; set; }
        public string RootDestinationFolder { get; set; }
        public bool SplitFolderByAssembly { get; set; }
        public bool ForceRebuild { get; set; }
        public bool UseParallelBuild { get; set; }
        public bool CreateExceptionThrownClause { get; set; }
        public int ExceptionThrownClauseDepth { get; set; }
        public bool EnableAbstract { get; set; }
        public bool EnableArray { get; set; }
        public bool EnableInheritance { get; set; }
        public bool DryRun { get; set; }
    }

    public class EndOperationEventArgs : EventArgs
    {
        public EndOperationEventArgs(string report)
        {
            Report = report;
        }

        public string Report { get; private set; }
    }

    public static class Reflector
    {
        static List<string> assemblyReferenced = new List<string>();
        public static appendToConsoleHandler AppendToConsoleHandler;
        public static EventHandler<EndOperationEventArgs> EndOperationHandler;

        static bool EnableWrite = true;

        static bool EnableAbstract = true;
        static bool EnableArray = true;
        static bool EnableInheritance = false;

        static LogLevel LogLevel;
        static string RootAssemblyName;
        static string RootDestinationFolder;
        static bool SplitByAssembly;
        static bool ForceRebuild;
        static bool UseParallelBuild;
        static bool CreateExceptionThrownClause;
        static int ExceptionThrownClauseDepth;

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
        static long implementedClasses = 0;
        static long implementedExceptions = 0;
        static long analyzedCtors = 0;
        static long implementedCtors = 0;
        static long implementedMethods = 0;
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
            implementedClasses = 0;
            implementedExceptions = 0;
            analyzedCtors = 0;
            implementedCtors = 0;
            implementedMethods = 0;
            analyzedMethods = 0;
            implementedProperties = 0;
            analyzedProperties = 0;
            implementedEvents = 0;
            analyzedEvents = 0;
        }

        public static async Task ExportAssembly(object o)
        {
            List<Type> typesToExport = new List<Type>();
            ReflectorEventArgs args = o as ReflectorEventArgs;

            var location = typeof(JavaBuilder).Assembly.Location;
            location = Path.GetDirectoryName(location);
            Environment.CurrentDirectory = location;

            LogLevel = args.LogLevel;
            RootDestinationFolder = args.RootDestinationFolder;

            RootAssemblyName = args.AssemblyName;
            SplitByAssembly = args.SplitFolderByAssembly;
            ForceRebuild = args.ForceRebuild;
            UseParallelBuild = args.UseParallelBuild;
            CreateExceptionThrownClause = args.CreateExceptionThrownClause;
            ExceptionThrownClauseDepth = args.ExceptionThrownClauseDepth;
            EnableAbstract = args.EnableAbstract;
            EnableArray = args.EnableArray;
            EnableInheritance = args.EnableInheritance;
            EnableWrite = !args.DryRun;

            if (ForceRebuild)
            {
                assemblyReferenced.Clear();
            }

            string reportStr = string.Empty;
            try
            {
                Assembly assembly = null;
                if (File.Exists(RootAssemblyName))
                {
                    AppendToConsole(LogLevel.Info, "Loading assembly from path {0}", RootAssemblyName);
                    assembly = Assembly.LoadFrom(RootAssemblyName);
                }
                else
                {
                    AppendToConsole(LogLevel.Info, "Loading assembly {0}", RootAssemblyName);
                    assembly = Assembly.Load(RootAssemblyName);
                }

                await ExportAssemblyWithReferences(assemblyReferenced, new AssemblyName(assembly.FullName), RootDestinationFolder, SplitByAssembly, ForceRebuild);

                StringBuilder sb = new StringBuilder();
                sb.AppendLine();
                sb.AppendLine("> Analyzed Assemblies:");
                foreach (var item in assemblyReferenced)
                {
                    sb.AppendLine(string.Format("> * {0}", item));
                }
                sb.AppendLine();
                var implemented = implementedEnumerators + implementedDelegates + implementedEnumsFlags + implementedClasses;
                sb.AppendFormat("> Total Types: Analyzed = {0} - Implemented = {1} - Discarded = {2} - Non Public = {3} - Generic = {4} - Internals = {5}", analyzedTypes, implemented, discardedTypes, discardedNonPublicTypes, discardedGenericTypes, discardedInternalTypes);
                sb.AppendLine();
                sb.AppendFormat("> * Total Enumerators: Analyzed = {0} - Implemented = {1}", analyzedEnumerators, implementedEnumerators);
                sb.AppendLine();
                sb.AppendFormat("> * Total Delegates: Analyzed = {0} - Implemented = {1}", analyzedDelegates, implementedDelegates);
                sb.AppendLine();
                sb.AppendFormat("> * Total Enums: Implemented = {0} - Flags = {1}", implementedEnums, implementedEnumsFlags);
                sb.AppendLine();
                sb.AppendFormat("> * Total Classes: Implemented = {0} Exceptions = {1}", implementedClasses, implementedExceptions);
                sb.AppendLine();
                sb.AppendFormat(">   * Total Constructors: Analyzed {0} - Implemented = {1}", analyzedCtors, implementedCtors);
                sb.AppendLine();
                sb.AppendFormat(">   * Total Methods: Analyzed {0} - Implemented = {1}", analyzedMethods, implementedMethods);
                sb.AppendLine();
                sb.AppendFormat(">   * Total Properties: Analyzed {0} - Implemented = {1}", analyzedProperties, implementedProperties);
                sb.AppendLine();
                sb.AppendFormat(">   * Total Events: Analyzed {0} - Implemented = {1}", analyzedEvents, implementedEvents);
                sb.AppendLine();

                reportStr = sb.ToString();
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

        public static async Task ExportAssemblyWithReferences(IList<string> assemblyReferenced, AssemblyName assemblyName, string rootFolder, bool splitByAssembly, bool forceRebuild)
        {
            if (assemblyReferenced.Contains(assemblyName.FullName)) return;
            var assembly = ExportAssembly(assemblyName, rootFolder, splitByAssembly, forceRebuild);
            assemblyReferenced.Add(assemblyName.FullName);
            if (assembly == null) return;
            foreach (var item in assembly.GetReferencedAssemblies())
            {
                await ExportAssemblyWithReferences(assemblyReferenced, item, rootFolder, splitByAssembly, forceRebuild);
            }
        }

        static string assemblyDestinationFolder(string rootFolder, AssemblyName assemblyName, bool splitByAssembly)
        {
#if NET_CORE
            return Path.Combine(rootFolder, Const.Framework.NETCoreFolder, splitByAssembly ? string.Concat(assemblyName.FullName.Split(' ')) : string.Empty);
#else
            return Path.Combine(rootFolder, Const.Framework.NETFrameworkFolder, splitByAssembly ? string.Concat(assemblyName.FullName.Split(' ')) : string.Empty);
#endif
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

        public static Assembly ExportAssembly(AssemblyName assemblyName, string rootFolder, bool splitByAssembly, bool forceRebuild)
        {
            string destFolder = assemblyDestinationFolder(rootFolder, assemblyName, splitByAssembly);
            if (splitByAssembly && Directory.Exists(destFolder) && !forceRebuild)
            {
                AppendToConsole(LogLevel.Info, "Skipping assembly {0}", assemblyName);
                return null;
            }

            Assembly assembly = null;
            AppendToConsole(LogLevel.Info, "Loading assembly {0}", assemblyName);
            try
            {
                assembly = Assembly.Load(assemblyName);
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "Skipping assembly {0}. Error is: {1}", assemblyName, ex.Message);
                return null;
            }

            Interlocked.Increment(ref parsedAssemblies);

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

            exportingPublicTypes(typesToExport, destFolder, assembly.FullName);

            return assembly;
        }

        static void exportingPublicTypes(List<Type> typesToExport, string destFolder, string assemblyname)
        {
            AppendToConsole(LogLevel.Info, "Start exporting public types of {0}", assemblyname);

            if (UseParallelBuild)
            {
                Parallel.ForEach(typesToExport, exportingPublicTypeParallel);
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
                string destFolder = assemblyDestinationFolder(RootDestinationFolder, new AssemblyName(assemblyname), SplitByAssembly);
                exportingPublicType(typeToExport, destFolder, assemblyname);
            }
            catch (Exception e)
            {
                AppendToConsole(LogLevel.Error, "Error exporting {0}: {1}", typeToExport.Name, e.Message);
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
            if (typeof(IEnumerator).IsAssignableFrom(type)
                || type.FullName == Const.SpecialNames.StringEnumerator)
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
            else if (typeToExport.IsEnum)
            {
                exportingEnum(typeToExport, destFolder, assemblyname);
            }
            else if (typeToExport.IsClass || typeToExport.IsAnsiClass)
            {
                exportingClass(typeToExport, destFolder, assemblyname);
            }
            else throw new InvalidOperationException(string.Format("Unchecked and unexported type {0}", typeToExport.FullName));
        }

        static void exportingEnum(Type item, string destFolder, string assemblyname)
        {
            var reflectorEnumTemplate = File.ReadAllText(Const.Templates.ReflectorEnumTemplate);
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
                var reflectorEnumFlagsTemplate = File.ReadAllText(Const.Templates.ReflectorEnumFlagsTemplate);
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

        static void exportingClass(Type item, string destFolder, string assemblyname)
        {
            bool isException = false;
            string reflectorClassTemplate = string.Empty;
            if (typeof(Exception).IsAssignableFrom(item))
            {
                isException = true;
                Interlocked.Increment(ref implementedExceptions);
                reflectorClassTemplate = File.ReadAllText(Const.Templates.ReflectorThrowableClassTemplate);
            }
            else
            {
                reflectorClassTemplate = File.ReadAllText(Const.Templates.ReflectorClassTemplate);
            }

            IList<Type> imports = new List<Type>();

            string implementsStr = string.Empty;
            var packageName = item.Namespace.ToLowerInvariant();
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                           .Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name)
                                                           .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                           .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                           .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName);

            var typeName = item.Name;

            AppendToConsole(LogLevel.Verbose, "Starting creating public Constructors from {0}", typeName);
            string ctorStr = string.Empty;
            if (EnableAbstract && !item.IsAbstract)
            {
                ctorStr = exportingConstructors(item, imports, isException, destFolder, assemblyname);
            }
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.CONSTRUCTORS_SECTION, ctorStr);

            string returnEnumerableType = string.Empty;
            AppendToConsole(LogLevel.Verbose, "Starting creating public Methods from {0}", typeName);
            var methodsStr = exportingMethods(item, imports, destFolder, assemblyname, out returnEnumerableType);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.METHODS_SECTION, methodsStr);

            AppendToConsole(LogLevel.Verbose, "Starting creating public Properties from {0}", typeName);
            var propInstanceStr = exportingProperties(item, imports, isException, destFolder, assemblyname);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, propInstanceStr);

            var eventsInstanceStr = exportingEvents(item, imports, false, isException, destFolder, assemblyname);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, eventsInstanceStr);

            var importStr = exportingImports(imports);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);

            if (!string.IsNullOrEmpty(returnEnumerableType) && typeof(IEnumerable).IsAssignableFrom(item))
            {
                if (string.IsNullOrEmpty(implementsStr)) implementsStr += Const.Class.PACKAGE_CLASS_IMPLEMENTS_PROTO + string.Format(Const.Class.PACKAGE_CLASS_IMPLEMENTS_ITERABLE, returnEnumerableType);
                else implementsStr += ", " + string.Format(Const.Class.PACKAGE_CLASS_IMPLEMENTS_ITERABLE, returnEnumerableType); // proto for other interface
            }

            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_CLASS_IMPLEMENTS_SECTION, implementsStr);

            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

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

        static string exportingConstructors(Type type, IList<Type> imports, bool isException, string destFolder, string assemblyname)
        {
            var ctorTypes = type.GetConstructors();
            if (ctorTypes.Length == 0) return string.Empty;

            var ctorClassTemplate = File.ReadAllText(Const.Templates.ReflectorClassConstructorTemplate);
            ctorClassTemplate = ctorClassTemplate.Replace(Const.Class.PACKAGE_CLASS_NAME, type.Name);

            var defaultCtor = ctorClassTemplate.Replace(Const.CTor.CTOR_PARAMETERS, string.Empty)
                                               .Replace(Const.CTor.CTOR_NEWOBJECT_PARAMETERS, string.Empty);

            StringBuilder ctors = new StringBuilder();
            ctors.AppendLine();
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
                    newObjectParams.Append(string.Format(formatter, (isArray && IsParams(parameter) && !isPrimitive ? "(Object[])" : (isPrimitive && paramType != Const.SpecialNames.NativeStringType) ? string.Empty : "(Object)"), paramName));
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

            return ctors.ToString();
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

            var nextTemplateToUse = File.ReadAllText(isPrimitive ? Const.Templates.ReflectorEnumerableNativeNextTemplate : Const.Templates.ReflectorEnumerableObjectNextTemplate);

            string nextSection = nextTemplateToUse.Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType);

            var reflectorEnumeratorTemplate = File.ReadAllText(Const.Templates.ReflectorEnumeratorTemplate);

            var importsStr = exportingImports(imports);

            var packageName = item.Namespace.ToLowerInvariant();
            var enumeratorStr = reflectorEnumeratorTemplate.Replace(Const.Enumerator.PACKAGE_NAME, packageName)
                                                           .Replace(Const.Enumerator.PACKAGE_IMPORT_SECTION, importsStr)
                                                           .Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType)
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

        static string exportingMethods(Type type, IList<Type> imports, string destFolder, string assemblyname, out string returnEnumeratorType)
        {
            returnEnumeratorType = string.Empty;
            var methods = type.GetMethods();
            if (methods.Length == 0) return string.Empty;

            string templateToUse = string.Empty;

            bool hasEnumerable = typeof(IEnumerable).IsAssignableFrom(type);

            StringBuilder methodBuilder = new StringBuilder();
            methodBuilder.AppendLine();
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isSpecial = false;
            bool isArray = false;
            bool isManaged = true;

            List<string> methodsSignatureCreated = new List<string>();
            List<string> methodsNameCreated = new List<string>();

            foreach (var item in methods)
            {
                Interlocked.Increment(ref analyzedMethods);

                var methodName = item.Name;

                if (methodsSignatureCreated.Contains(item.ToString()) // avoid duplicated methods from inheritance
                    || item.IsSpecialName // remove properties
                    || item.IsGenericMethod // don't manage generic methods
                    || item.ContainsGenericParameters
                    || (EnableInheritance ? item.DeclaringType != type : item.IsAbstract)
                    || !item.IsPublic
                    || (!methodsNameCreated.Contains(methodName) ? false : isDifferentOnlyForRetVal(methodsSignatureCreated, item.ToString(), methodName))
                   ) continue;

                var parameters = item.GetParameters();

                if (methodName == "ToString" && parameters.Length == 0) continue;
                if (methodName == "GetHashCode" && parameters.Length == 0) continue;
                if (methodName == "GetType" && parameters.Length == 0) continue;
                if (methodName == "Equals" && parameters.Length == 1 && parameters[0].ParameterType == typeof(object)) continue;

                //if (!isManagedType(item.ReturnType)) continue;
                var methodStr = string.Empty;
                if (hasEnumerable && methodName == "GetEnumerator" && parameters.Length == 0)
                {
                    templateToUse = File.ReadAllText(Const.Templates.ReflectorEnumerableTemplate);

                    if (!exportingEnumerator(item.ReturnType, null, null, out returnEnumeratorType, true))
                    {
                        returnEnumeratorType = string.Empty;
                        continue;
                    }

                    var returnType = convertType(imports, item.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                    if (!isManaged)
                    {
                        returnEnumeratorType = string.Empty;
                        continue;
                    }

                    methodStr = templateToUse.Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                              .Replace(Const.Methods.METHOD_RETURN_INNER_TYPE, returnEnumeratorType);
                }
                else
                {
                    string returnType = "void";
                    if (item.ReturnType == typeof(void))
                    {
                        templateToUse = File.ReadAllText(Const.Templates.ReflectorClassVoidMethodTemplate);
                    }
                    else
                    {
                        returnType = convertType(imports, item.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        if (!isManaged) continue;
                        isPrimitive |= typeof(Delegate).IsAssignableFrom(item.ReturnType);

                        if (isArray)
                        {
                            templateToUse = File.ReadAllText(isPrimitive ? Const.Templates.ReflectorClassNativeArrayMethodTemplate : Const.Templates.ReflectorClassObjectArrayMethodTemplate);
                        }
                        else
                        {
                            templateToUse = File.ReadAllText(isPrimitive ? Const.Templates.ReflectorClassNativeMethodTemplate : Const.Templates.ReflectorClassObjectMethodTemplate);
                        }
                    }

                    StringBuilder inputParams = new StringBuilder();
                    StringBuilder execParams = new StringBuilder();

                    foreach (var parameter in parameters)
                    {
                        string paramType = convertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        isManaged &= !parameter.IsOut; // out parameters not managed
                        if (!isManaged) break; // found not managed type, stop here
                        isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                        var paramName = checkForkeyword(parameter.Name);
                        inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));

                        string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                        if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;
                        execParams.Append(string.Format(formatter, (isArray && IsParams(parameter) && !isPrimitive ? "(Object[])" : (isPrimitive && paramType != Const.SpecialNames.NativeStringType) ? string.Empty : "(Object)"), paramName));
                    }
                    if (!isManaged) continue; // found not managed type, jump to next 
                    string inputParamStr = inputParams.ToString();
                    if (!string.IsNullOrEmpty(inputParamStr))
                    {
                        inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                    }

                    string execParamStr = execParams.ToString();

                    var exceptionStr = exceptionStringBuilder(item, imports);

                    methodStr = templateToUse.Replace(Const.Methods.METHOD_NAME, methodName)
                                             .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                             .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                             .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                             .Replace(Const.Methods.STATIC_KEYWORD, item.IsStatic ? Const.Parameters.STATIC_KEYWORD : string.Empty)
                                             .Replace(Const.Methods.METHOD_OBJECT, item.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                             .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                }

                methodsSignatureCreated.Add(item.ToString());
                methodsNameCreated.Add(item.Name);

                methodBuilder.AppendLine(methodStr);

                Interlocked.Increment(ref implementedMethods);
            }

            return methodBuilder.ToString();
        }

        static string buildPropertySignature(string templateToUse, string propertyName, string propertyType, bool isPrimitive, bool isArray, bool statics)
        {
            StringBuilder inputParams = new StringBuilder();
            StringBuilder execParams = new StringBuilder();

            propertyName = checkForkeyword(propertyName);

            string inputParamStr = inputParams.ToString();
            if (!string.IsNullOrEmpty(inputParamStr))
            {
                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
            }

            string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
            if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

            string execParamStr = execParams.ToString();
            var propertyStr = templateToUse.Replace(Const.Properties.PROPERTY_NAME, propertyName)
                                           .Replace(Const.Properties.PROPERTY_INPUTTYPE, (isArray) ? propertyType + Const.SpecialNames.ArrayTrailer : propertyType)
                                           .Replace(Const.Properties.PROPERTY_INPUTNAME, propertyName)
                                           .Replace(Const.Properties.PROPERTY_OUTPUTTYPE, propertyType)
                                           .Replace(Const.Properties.PROPERTY_PARAMETERS, string.Empty)
                                           .Replace(Const.Properties.PROPERTY_INVOKE_PARAMETERS, string.Empty)
                                           .Replace(Const.Properties.PROPERTY_VALUE, string.Format(formatter, (isPrimitive && propertyType != Const.SpecialNames.NativeStringType) ? string.Empty : "(Object)", propertyName))
                                           .Replace(Const.Methods.STATIC_KEYWORD, statics ? Const.Parameters.STATIC_KEYWORD : string.Empty)
                                           .Replace(Const.Properties.PROPERTY_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

            return propertyStr;
        }

        static string exportingProperties(Type type, IList<Type> imports, bool isException, string destFolder, string assemblyname)
        {
            List<Tuple<bool, PropertyInfo>> properties = new List<Tuple<bool, PropertyInfo>>();
            var props = type.GetProperties(BindingFlags.Public | BindingFlags.Instance); // prefer instance properties against static, Java don't like same name of functions
            foreach (var item in props)
            {
                properties.Add(new Tuple<bool, PropertyInfo>(false, item));
            }
            props = type.GetProperties(BindingFlags.Public | BindingFlags.Static);
            foreach (var item in props)
            {
                properties.Add(new Tuple<bool, PropertyInfo>(true, item));
            }

            if (properties.Count == 0) return string.Empty;

            string templateToUse = string.Empty;

            StringBuilder propertyBuilder = new StringBuilder();
            propertyBuilder.AppendLine();
            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isManaged = true;
            bool isSpecial = false;
            bool isArray = false;

            List<string> propertiesSignaturesCreated = new List<string>();
            List<string> propertiesNameCreated = new List<string>();

            foreach (var prop in properties)
            {
                Interlocked.Increment(ref analyzedProperties);

                var statics = prop.Item1;
                var item = prop.Item2;

                var propertyName = item.Name;

                if (isException)
                {
                    if (propertyName == "Message") continue;
                    if (propertyName == "StackTrace") continue;
                }

                if (propertiesSignaturesCreated.Contains(item.ToString())
                    || item.IsSpecialName
                    || (EnableInheritance ? item.DeclaringType != type : false)
                    || (!propertiesNameCreated.Contains(propertyName) ? false : isDifferentOnlyForRetVal(propertiesSignaturesCreated, item.ToString(), propertyName))
                   ) continue;

                string propertyType = "void";

                propertyType = convertType(imports, item.PropertyType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                if (!isManaged) continue; // found not managed type, jump to next 

                if (item.CanRead) // get
                {
                    if (item.GetMethod.GetParameters().Length != 0) continue; // only get without parameters are managed
                    isPrimitive |= typeof(Delegate).IsAssignableFrom(item.PropertyType);

                    if (isArray)
                    {
                        templateToUse = File.ReadAllText(isPrimitive ? Const.Templates.ReflectorClassNativeArrayGetTemplate : Const.Templates.ReflectorClassObjectArrayGetTemplate);
                    }
                    else
                    {
                        templateToUse = File.ReadAllText(isPrimitive ? Const.Templates.ReflectorClassNativeGetTemplate : Const.Templates.ReflectorClassObjectGetTemplate);
                    }

                    var propertyStr = buildPropertySignature(templateToUse, propertyName, propertyType, isPrimitive, isArray, statics);
                    propertyBuilder.AppendLine(propertyStr);
                }
                if (item.CanWrite) // set
                {
                    templateToUse = File.ReadAllText(Const.Templates.ReflectorClassSetTemplate);
                    var propertyStr = buildPropertySignature(templateToUse, propertyName, propertyType, isPrimitive, isArray, statics);
                    propertyBuilder.AppendLine(propertyStr);
                }

                propertiesSignaturesCreated.Add(item.ToString());
                propertiesNameCreated.Add(item.Name);

                Interlocked.Increment(ref implementedProperties);
            }

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
            string interfaceTemplateToUse = string.Empty;
            string classTemplateToUse = string.Empty;
            bool isPrimitive = true;
            bool isRetValPrimitive = false;
            string defaultPrimitiveReturnValue = string.Empty;
            bool isSpecial = false;
            bool isRetValArray = false;
            bool isArray = false;
            bool isManaged = true;
            if (invokeMethod.ReturnType == typeof(void))
            {
                classTemplateToUse = File.ReadAllText(Const.Templates.VoidDelegateClassTemplate);
                interfaceTemplateToUse = File.ReadAllText(Const.Templates.VoidDelegateInterfaceTemplate);
            }
            else
            {
                returnType = convertType(imports, invokeMethod.ReturnType, out isRetValPrimitive, out defaultPrimitiveReturnValue, out isManaged, out isSpecial, out isRetValArray);
                if (!isManaged) return false;
                classTemplateToUse = File.ReadAllText(isRetValPrimitive ? Const.Templates.NativeDelegateClassTemplate : Const.Templates.ObjectDelegateClassTemplate);
                interfaceTemplateToUse = File.ReadAllText(Const.Templates.NonVoidDelegateInterfaceTemplate);
            }

            StringBuilder converterBlock = new StringBuilder();
            StringBuilder inputParams = new StringBuilder();
            StringBuilder execParams = new StringBuilder();
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
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_NAME, paramName)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_INDEX, paramCounter.ToString());

                    converterBlock.AppendLine(formatter);
                }
                else
                {
                    converterBlock.AppendLine(string.Format(isPrimitive ? Const.Delegates.CONVERTER_BLOCK_PARAMETER_PRIMITIVE : Const.Delegates.CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE, paramType, paramName, paramCounter));
                }

                inputParams.Append(string.Format(Const.Delegates.INPUT_INVOKE_PARAMETER, (isArray) ? paramType + Const.SpecialNames.ArrayTrailer : paramType, paramName));
                execParams.Append(string.Format(Const.Delegates.INVOKE_PARAMETER, paramName));

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

        static string exportingEvents(Type type, IList<Type> imports, bool statics, bool isException, string destFolder, string assemblyname)
        {
            BindingFlags flags = BindingFlags.Public;
            flags |= statics ? BindingFlags.Static : BindingFlags.Instance;
            var events = type.GetEvents(flags);
            if (events.Length == 0) return string.Empty;

            string templateToUse = File.ReadAllText(Const.Templates.ReflectorEventsTemplate);

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
                Interlocked.Increment(ref analyzedEvents);

                var eventName = item.Name;

                if (isException)
                {
                    if (eventName == "Message") continue;
                    if (eventName == "StackTrace") continue;
                }

                if (eventsSignaturesCreated.Contains(item.ToString())
                    || item.IsSpecialName
                    || (EnableInheritance ? item.DeclaringType != type : false)
                    || (!eventsNameCreated.Contains(eventName) ? false : isDifferentOnlyForRetVal(eventsSignaturesCreated, item.ToString(), eventName))
                   ) continue;

                string eventType = "void";
                StringBuilder inputParams = new StringBuilder();
                StringBuilder execParams = new StringBuilder();

                if (!exportingDelegate(item.EventHandlerType, destFolder, assemblyname, true)) continue;

                eventType = convertType(imports, item.EventHandlerType, out isPrimitive, out defaultPrimitiveValue, out isConcrete, out isSpecial, out isArray);
                if (!isConcrete) continue; // found not managed type, jump to next 

                var eventStr = templateToUse.Replace(Const.Events.EVENT_NAME, eventName)
                                            .Replace(Const.Events.EVENT_HANDLER_TYPE, item.EventHandlerType.Name)
                                            .Replace(Const.Methods.STATIC_KEYWORD, statics ? Const.Events.STATIC_KEYWORD : string.Empty)
                                            .Replace(Const.Events.EVENT_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

                eventsSignaturesCreated.Add(item.ToString());
                eventsNameCreated.Add(item.Name);

                eventBuilder.AppendLine(eventStr);

                Interlocked.Increment(ref implementedEvents);
            }

            return eventBuilder.ToString();
        }

        static string exportingImports(IList<Type> imports)
        {
            StringBuilder importsToExport = new StringBuilder();
            foreach (var item in imports)
            {
                importsToExport.AppendLine(string.Format(Const.Imports.IMPORT, item.Namespace.ToLowerInvariant(), item.Name));
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
                 || type.IsInterface // discard interfaces for now
                 || type.IsGenericType || type.IsGenericParameter || type.IsInterface)
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
