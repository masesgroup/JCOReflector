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
        static bool ExportingEnumerator(this Type item, string destFolder, string assemblyname, out string returnEnumeratorType, bool avoidWrite = false)
        {
            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public values from {0}", item.Name);

            if (!item.HasEnumerator()) { returnEnumeratorType = string.Empty; return false; }

            returnEnumeratorType = string.Empty;

            if (!avoidWrite) Interlocked.Increment(ref analyzedEnumerators);

            // Open generic definitions are now processed natively by the new pipeline, raw open arguments are discarded
            if (item.IsGenericParameter) return false;
            if (item.IsGenericType && !(EnableGenerics && item.IsGenericTypeDefinition)) return false;

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
            bool isCurrentGeneric = EnableGenerics && propertyMethod.PropertyType.IsGenericParameter;

            // GENERICS UPDATED: Extract generic signature literals ("T") safely without calling ConvertType
            if (isCurrentGeneric)
            {
                returnEnumeratorType = propertyMethod.PropertyType.Name; // Evaluates to "T" literal signature
                isPrimitive = true; // FORCED: Triggers File 28 template to bypass "new T()" erasure compiler crash
                isManaged = true;
                isSpecial = false;
                isArray = false;
            }
            else
            {
                returnEnumeratorType = ConvertType(imports, propertyMethod.PropertyType, out isPrimitive, out defaultPrimitiveReturnValue, out isManaged, out isSpecial, out isArray);
            }

            if (!isManaged || isArray
                || (isPrimitive && !returnEnumeratorType.Contains("String") && !isCurrentGeneric))
            {
                // Only String and open generic parameter types are accepted, standard primitives are rejected for Iterable<E>
                returnEnumeratorType = string.Empty;
                return false;
            }

            if (avoidWrite) return true;

            // TEMPLATE SELECTION FOR NEXT SECTION: Choose sub-template for the next() method body
            string nextSection = string.Empty;
            if (isCurrentGeneric)
            {
                var nextTemplateRaw = Const.Templates.GetTemplate(Const.Templates.ReflectorEnumerableNativeNextTemplate);

                // "(T)classInstance.next()" is never legal Java: classInstance.next() returns a raw JCObject,
                // unrelated to T as far as the compiler knows. Build it reflectively instead, via the
                // Class<T> captured at construction time — same mechanism used everywhere else for a
                // class-level generic parameter (instantiateGenericArgument).
                int genericArgIndex = Array.IndexOf(item.GetGenericArguments(), propertyMethod.PropertyType);
                string genericDirectCast = $"this.<{returnEnumeratorType}>instantiateGenericArgument({genericArgIndex}, classInstance.next())";

                nextSection = nextTemplateRaw.Replace($"(PACKAGE_INNER_CLASS_NAME)classInstance.next().toString()", genericDirectCast)
                                             .Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType);
            }
            else
            {
                // Standard original JCOReflector sub-template processing pipeline
                var nextTemplateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorEnumerableNativeNextTemplate : Const.Templates.ReflectorEnumerableObjectNextTemplate);
                nextSection = nextTemplateToUse.Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType)
                                              .Replace(Const.Enumerator.PACKAGE_IMPLEMENTATION_INNER_CLASS_NAME, propertyMethod.PropertyType.IsInterface ? returnEnumeratorType + Const.SpecialNames.ImplementationTrailer : returnEnumeratorType);
            }

            // TEMPLATE SELECTION: Select between standard and generic enumerator master templates dynamically
            var templateToken = EnableGenerics && item.IsGenericTypeDefinition
                ? Const.Templates.ReflectorGenericEnumeratorTemplate
                : Const.Templates.ReflectorEnumeratorTemplate;

            var reflectorEnumeratorTemplate = Const.Templates.GetTemplate(templateToken);

            var importsStr = imports.ExportImports();

            // RESOLUTION GENERICS: Resolve non-colliding java class name for the enumerator file name
            var packageName = item.ToPackageName();
            string javaClassName = item.GetJavaClassName(item.Assembly);

            var enumeratorStr = reflectorEnumeratorTemplate.Replace(Const.Enumerator.PACKAGE_NAME, packageName)
                                                           .Replace(Const.Enumerator.PACKAGE_IMPORT_SECTION, importsStr)
                                                           .Replace(Const.Enumerator.PACKAGE_INNER_CLASS_NAME, returnEnumeratorType)
                                                           .Replace(Const.Enumerator.PACKAGE_IMPLEMENTATION_INNER_CLASS_NAME, propertyMethod.PropertyType.IsInterface ? returnEnumeratorType + Const.SpecialNames.ImplementationTrailer : returnEnumeratorType)
                                                           .Replace(Const.Enumerator.PACKAGE_CLASS_NAME, javaClassName)
                                                           .Replace(Const.Enumerator.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                           .Replace(Const.Enumerator.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                           .Replace(Const.Enumerator.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                           .Replace(Const.Enumerator.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation())
                                                           .Replace(Const.Enumerator.PACKAGE_CLASS_NEXT_SECTION, nextSection)
                                                           .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            // GENERICS INJECTION: Compile the type bounds definition if the enumerator is a generic definition
            if (EnableGenerics && item.IsGenericTypeDefinition)
            {
                Type[] genericArguments = item.GetGenericArguments();
                string classParameters = BuildTypeParameters(genericArguments, imports);
                enumeratorStr = enumeratorStr.Replace(Const.Class.GENERIC_CLASS_PARAMETERS, classParameters);
            }

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                JobManager.AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }

            // WRITE LOGIC FIXED: Saves the file with the resolved non-colliding Java name
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", javaClassName));
            writeFile(fileName, enumeratorStr);

            Interlocked.Increment(ref implementedEnumerators);

            return true;
        }
    }
}
