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

        static void ResetStatistics()
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
                    var relativePath = Path.GetFullPath(Path.Combine(CsvDestinationFolder, Const.Framework.RuntimeFolder));
                    if (!Directory.Exists(relativePath)) Directory.CreateDirectory(relativePath);
                    csvFileName = Path.Combine(relativePath, Const.FileNameAndDirectory.StatisticsFilename);
                    writeFile(csvFileName, csvString);
                }
            }
            catch (Exception ex)
            {
                string errorString = string.Format("Error writing csv files {0}", ex.Message);
                JobManager.AppendToConsole(LogLevel.Error, errorString);
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
                JobManager.AppendToConsole(LogLevel.Error, errorString);
            }
            return res;
        }

        static string GetReport(this IEnumerable<string> assemblyNames)
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
                JobManager.AppendToConsole(LogLevel.Error, res);
            }
            return res;
        }
    }
}
