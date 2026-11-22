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

        static void ExportClass(this Type item, string destFolder, string assemblyname)
        {
            bool isException = false;
            string reflectorClassTemplate = string.Empty;
            string packageBaseClass = string.Empty;
            if (typeof(Exception).IsAssignableFrom(item))
            {
                isException = true;
                Interlocked.Increment(ref implementedExceptions);
                // A generic class can never extend java.lang.Throwable (JLS 8.1.2) — exceptions are
                // always generated as plain, non-generic classes, whatever their .NET type looks like.
                reflectorClassTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorThrowableClassTemplate);
                packageBaseClass = Const.SpecialNames.NetException;
            }
            else
            {
                // TEMPLATE SELECTION: Select between standard class and generic class definition templates dynamically
                reflectorClassTemplate = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(Const.Templates.ReflectorClassGenericTemplate)
                    : Const.Templates.GetTemplate(Const.Templates.ReflectorClassTemplate);

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
                if (interfaceType.IsManagedType(0, 1) && typeof(IEnumerable) != interfaceType)
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
                if (item.BaseType.IsManagedType(0, 1) && item.BaseType != typeof(object) && item.BaseType != typeof(Exception) && item.BaseType != typeof(Type))
                {
                    packageBaseClass = EnableGenerics ? BuildQualifiedGenericTypeName(item.BaseType, imports)
                                                      : item.BaseType.Name;
                    imports.Add(item.BaseType);
                }
            }

            // RESOLUTION GENERICS: Calculate java class name using collision checker to avoid raw backticks or wrong _1 suffixes
            var packageName = item.ToPackageName();
            string javaClassName = item.GetJavaClassName(item.Assembly);

            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                           .Replace(Const.Class.PACKAGE_CLASS_BASE_CLASS, packageBaseClass)
                                                           .Replace(Const.Class.PACKAGE_CLASS_NAME, javaClassName)
                                                           .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                           .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                           .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                           .Replace(Const.Class.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation());

            // GENERICS INJECTION: Inject bounds and method type definitions into master class template if item is generic
            if (EnableGenerics && item.IsGenericTypeDefinition)
            {
                Type[] genericArguments = item.GetGenericArguments();
                string classParameters = string.Join(", ", genericArguments.Select(t => $"{t.Name} extends IJCOBridgeReflected"));
                string methodArguments = string.Join(", ", genericArguments.Select(t => t.Name));

                reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.GENERIC_CLASS_PARAMETERS, classParameters);
                reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Methods.GENERIC_METHOD_PARAMETERS, classParameters);
                reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Methods.GENERIC_METHOD_ARGUMENTS, methodArguments);
            }

            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public Constructors from {0}", javaClassName);
            string ctorStr = string.Empty;
            if (EnableAbstract && !item.IsAbstract)
            {
                ctorStr = item.ExportConstructors(imports, withInheritance, isException, destFolder, assemblyname);
            }
            else if (!isException)
            {
                ctorStr = Const.CTor.DEFAULT_CTOR.Replace(Const.Class.PACKAGE_CLASS_NAME, javaClassName);
            }
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.CONSTRUCTORS_SECTION, ctorStr);

            bool isDisposable = allDirectInterfaces.Contains(typeof(IDisposable));
            string returnEnumerableType = string.Empty;
            string returnInterfaceSection = string.Empty;
            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public Methods from {0}", javaClassName);
            var methodsStr = item.ExportMethods(imports, implementableInterfaces, withInheritance, destFolder, assemblyname, out returnEnumerableType, out returnInterfaceSection);
            if (isDisposable)
            {
                methodsStr += Const.Methods.AUTOCLOSEABLE_CLOSE_METHOD;
            }
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.METHODS_SECTION, methodsStr);

            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public Properties from {0}", javaClassName);
            var propInstanceStr = item.ExportProperties(imports, implementableInterfaces, withInheritance, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, propInstanceStr);

            var eventsInstanceStr = item.ExportEvents(imports, implementableInterfaces, withInheritance, false, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, eventsInstanceStr);

            if (EnableInheritance && EnableInterfaceInheritance)
            {
                foreach (var interfaceType in implementableInterfaces)
                {
                    if (EnableGenerics)
                    {
                        // If any abstract member of this interface is NOT satisfied by a public method on
                        // the type (e.g. satisfied only via an explicit interface implementation, which the
                        // CLR always represents as a private target method), Java cannot see this class as
                        // genuinely implementing the interface. Still reachable through the ToIXxx(...)
                        // deprecated-stub path built elsewhere, so skip only the "implements" declaration.
                        // Gated behind EnableGenerics: this check did not exist before this feature, and
                        // EnableGenerics=false must reproduce the exact pre-generics output.
                        bool hasUnsatisfiedMember;
                        try
                        {
                            var map = item.GetInterfaceMap(interfaceType);
                            hasUnsatisfiedMember = map.TargetMethods.Any(m => m == null || !m.IsPublic);
                        }
                        catch (ArgumentException)
                        {
                            hasUnsatisfiedMember = false;
                        }

                        if (hasUnsatisfiedMember) continue;
                    }

                    // Pre-generics behavior when the flag is off: plain name relying on the import below —
                    // no package qualification, since none was needed before this feature existed.
                    var nameToAdd = EnableGenerics
                        ? BuildQualifiedGenericTypeName(interfaceType, imports)
                        : interfaceType.GetJavaClassName(interfaceType.Assembly);

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

            var importStr = imports.ExportImports();
            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);

            if (!string.IsNullOrEmpty(returnEnumerableType) && typeof(IEnumerable).IsAssignableFrom(item))
            {
                string implStr = string.Format(Const.Class.PACKAGE_CLASS_IMPLEMENTS_ITERABLE, returnEnumerableType);
                if (returnEnumerableType == Const.SpecialNames.NetObject)
                {
                    implStr = Const.SpecialNames.NetIEnumerable;
                }

                if (string.IsNullOrEmpty(implementsStr)) implementsStr += Const.Class.PACKAGE_CLASS_IMPLEMENTS_PROTO + implStr;
                else implementsStr += ", " + implStr;
            }

            if (isDisposable)
            {
                if (string.IsNullOrEmpty(implementsStr)) implementsStr += Const.Class.PACKAGE_CLASS_IMPLEMENTS_PROTO + Const.SpecialNames.AutoCloseable;
                else implementsStr += ", " + Const.SpecialNames.AutoCloseable;
            }

            reflectorClassTemplate = reflectorClassTemplate.Replace(Const.Class.PACKAGE_CLASS_IMPLEMENTS_SECTION, implementsStr)
                                                           .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                JobManager.AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }

            // WRITE LOGIC FIXED: Saves the class file using the resolved non-colliding clean Java name
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", javaClassName));
            writeFile(fileName, reflectorClassTemplate);

            Interlocked.Increment(ref implementedClasses);
        }
    }
}
