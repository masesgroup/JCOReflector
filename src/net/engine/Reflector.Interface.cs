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
        static void ExportInterface(this Type item, string destFolder, string assemblyname)
        {
            bool isException = false;
            string reflectorInterfaceTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceTemplate);
            string packageBaseClass = Const.SpecialNames.NetObject;
            IList<Type> imports = new List<Type>();

            string packageBaseInterface = Const.SpecialNames.IJCOBridgeReflected;
            bool withInheritance = false;

            var allDirectInterfaces = item.GetInterfaces(!EnableInterfaceInheritance);
            List<Type> implementableInterfaces = new List<Type>();
            foreach (var interfaceType in allDirectInterfaces)
            {
                // Same avoidance map used for methods/properties: an interface whose entry has a null
                // method list (e.g. the generic-math family) is excluded entirely, not just its members —
                // it should never appear in an extends/implements clause either.
                var interfaceFullName = interfaceType.FullName ?? interfaceType.Name;
                if (CheckExportingAvoidanceMap(interfaceFullName, string.Empty)) continue;

                if (interfaceType.IsManagedType(0, 1))
                {
                    implementableInterfaces.Add(interfaceType);
                }
            }

            if (EnableInheritance)
            {
                withInheritance = true;
                bool hasGenericEnumerable = implementableInterfaces.Any(i => i.IsGenericType && i.GetGenericTypeDefinition() == typeof(IEnumerable<>));
                bool hasGenericEnumerator = implementableInterfaces.Any(i => i.IsGenericType && i.GetGenericTypeDefinition() == typeof(IEnumerator<>));

                foreach (var inter in implementableInterfaces)
                {
                    if (inter == typeof(IEnumerable))
                    {
                        packageBaseClass = Const.SpecialNames.NetIEnumerable + Const.SpecialNames.ImplementationTrailer;
                        if (!EnableGenerics || !hasGenericEnumerable)
                        {
                            packageBaseInterface += string.Format(", {0}", "org.mases.jcobridge.netreflection." + inter.Name);
                            imports.Add(inter);
                        }
                    }
                    else if (inter == typeof(IEnumerator))
                    {
                        packageBaseClass = Const.SpecialNames.NetIEnumerator + Const.SpecialNames.ImplementationTrailer;
                        if (!EnableGenerics || !hasGenericEnumerator)
                        {
                            packageBaseInterface += string.Format(", {0}", "org.mases.jcobridge.netreflection." + inter.Name);
                            imports.Add(inter);
                        }
                    }
                    else
                    {
                        var nameToAdd = EnableGenerics
                            ? BuildQualifiedGenericTypeName(inter, imports)
                            : inter.ToPackageName() + "." + inter.GetJavaClassName(item.Assembly);
                        packageBaseInterface += string.Format(", {0}", nameToAdd);
                        imports.Add(inter);
                    }
                }
            }

            // TEMPLATE SELECTION: Select between standard and generic implementation templates dynamically
            string reflectorInterfaceClassTemplate = EnableGenerics && item.IsGenericTypeDefinition
                ? Const.Templates.GetTemplate(Const.Templates.ReflectorGenericInterfaceClassTemplate)
                : Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceClassTemplate);

            // RESOLUTION GENERICS: Calculate java interface name using collision checker
            string implementsStr = string.Empty;
            var packageName = item.ToPackageName();
            string javaInterfaceName = item.GetJavaClassName(item.Assembly);

            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                                             .Replace(Const.Class.PACKAGE_CLASS_BASE_CLASS, packageBaseClass)
                                                                             .Replace(Const.Class.PACKAGE_CLASS_NAME, javaInterfaceName)
                                                                             .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                                             .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                                             .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                                             .Replace(Const.Class.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation());

            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.PACKAGE_NAME, packageName)
                                                                   .Replace(Const.Class.PACKAGE_CLASS_BASE_CLASS, packageBaseInterface)
                                                                   .Replace(Const.Class.PACKAGE_CLASS_NAME, javaInterfaceName)
                                                                   .Replace(Const.Class.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                                   .Replace(Const.Class.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                                   .Replace(Const.Class.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                                   .Replace(Const.Class.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation());

            // GENERICS INJECTION: Inject bounds and method type definitions into both files if item is generic
            if (EnableGenerics && item.IsGenericTypeDefinition)
            {
                Type[] genericArguments = item.GetGenericArguments();
                string classParameters = BuildTypeParameters(genericArguments, imports);
                string methodArguments = string.Join(", ", genericArguments.Select(t => t.Name));

                // Update the implementation file template tags
                reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.GENERIC_CLASS_PARAMETERS, classParameters);
                reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Methods.GENERIC_METHOD_PARAMETERS, classParameters);
                reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Methods.GENERIC_METHOD_ARGUMENTS, methodArguments);

                // Update the interface pure file declaration layout to append <T extends...>
                reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace($"interface {javaInterfaceName}", $"interface {javaInterfaceName}<{classParameters}>");
            }

            string returnEnumerableType = string.Empty;
            string returnInterfaceSection = string.Empty;
            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public Methods from {0}", javaInterfaceName);
            var methodsStr = item.ExportMethods(imports, implementableInterfaces, withInheritance, destFolder, assemblyname, out returnEnumerableType, out returnInterfaceSection);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.METHODS_SECTION, methodsStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.METHODS_SECTION, returnInterfaceSection);

            JobManager.AppendToConsole(LogLevel.Verbose, "Starting creating public Properties from {0}", javaInterfaceName);
            var propInstanceStr = item.ExportProperties(imports, implementableInterfaces, withInheritance, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, propInstanceStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.GETTER_SETTER_SECTION, returnInterfaceSection);

            var eventsInstanceStr = item.ExportEvents(imports, implementableInterfaces, withInheritance, false, isException, destFolder, assemblyname, out returnInterfaceSection);
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, eventsInstanceStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.INSTANCE_EVENTS_SECTION, returnInterfaceSection);

            var importStr = imports.ExportImports();
            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.PACKAGE_IMPORT_SECTION, importStr);

            reflectorInterfaceClassTemplate = reflectorInterfaceClassTemplate.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);
            reflectorInterfaceTemplate = reflectorInterfaceTemplate.Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);

            var pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo))
            {
                JobManager.AppendToConsole(LogLevel.Verbose, "Creating folder {0}", pathToSaveTo);
                Directory.CreateDirectory(pathToSaveTo);
            }

            // WRITE LOGIC FIXED: Saves both interface and implementation files with corrected names
            var fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", javaInterfaceName));
            writeFile(fileName, reflectorInterfaceTemplate);

            fileName = Path.Combine(pathToSaveTo, string.Format("{0}" + Const.SpecialNames.ImplementationTrailer + ".java", javaInterfaceName));
            writeFile(fileName, reflectorInterfaceClassTemplate);

            Interlocked.Increment(ref implementedInterfaces);
        }
    }
}
