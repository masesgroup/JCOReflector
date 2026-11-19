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
        static void ExportEnum(this Type item, string destFolder, string assemblyname)
        {
            var reflectorEnumTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumTemplate);
            var packageName = item.ToPackageName();
            reflectorEnumTemplate = reflectorEnumTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                         .Replace(Const.Class.PACKAGE_CLASS_NAME, item.Name)
                                                         .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                         .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                         .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                         .Replace(Const.Class.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation());

            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public values from {0}", item.Name);
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
                JobManager.AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", item.Name));
            writeFile(fileName, reflectorEnumTemplate);

            Interlocked.Increment(ref implementedEnums);
        }
    }
}
