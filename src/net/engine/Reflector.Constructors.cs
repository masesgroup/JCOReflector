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
        static string ExceptionStringBuilder(this MethodBase method, IList<Type> imports)
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
                        ConvertType(imports, expType, out isPrimitive, out defaultPrimitiveValue, out isConcrete, out isSpecial, out isArray, false);
                        if (!isSpecial && isConcrete)
                        {
                            expBuilder.AppendFormat(Const.Exceptions.SINGLE_EXCEPTION_PROTO, expType.ToPackageName(), expType.GetJavaClassName(expType.Assembly));
                        }
                    }
                    exceptionStr = expBuilder.ToString();
                }
            }
            catch (Exception ex)
            {
                JobManager.AppendToConsole(LogLevel.Error, "exceptionStringBuilder on {0} with error {1}", method.Name, ex.Message);
                exceptionStr = string.Empty;
            }

            return exceptionStr;
        }

        static string ExportConstructors(this Type type, IList<Type> imports, bool withInheritance, bool isException, string destFolder, string assemblyname)
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

            // TEMPLATE SELECTION: Dynamically choose the correct template file based on generic definition
            var ctorClassTemplate = EnableGenerics && !isException && type.IsGenericTypeDefinition
                ? Const.Templates.GetTemplate(Const.Templates.ReflectorClassGenericConstructorTemplate)
                : Const.Templates.GetTemplate(Const.Templates.ReflectorClassConstructorTemplate);

            var javaClassName = type.GetJavaClassName(type.Assembly);
            ctorClassTemplate = ctorClassTemplate.Replace(Const.Class.PACKAGE_CLASS_NAME, javaClassName);

            var defaultCtor = Const.CTor.DEFAULT_CTOR.Replace(Const.Class.PACKAGE_CLASS_NAME, javaClassName);

            StringBuilder ctors = new StringBuilder();
            // Same erasure-collision guard used in ExportMethods: two distinct .NET constructor
            // overloads can still collapse onto the same erased Java signature.
            HashSet<string> javaErasedCtorSignaturesCreated = new HashSet<string>();

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
                List<string> erasedCtorParamTypes = new List<string>();

                bool isPrimitive = true;
                string defaultPrimitiveValue = string.Empty;
                bool isSpecial = false;
                bool isArray = false;
                bool isManaged = true;
                foreach (var parameter in parameters)
                {
                    // A generic class-level parameter is only representable as a real Java type variable when
                    // the class declares its own <T> — never possible for an exception (a generic class cannot
                    // extend java.lang.Throwable). For exceptions, fall back to the bound (IJCOBridgeReflected).
                    bool isClassLevelGenericParam = (parameter.ParameterType.IsGenericParameter && parameter.ParameterType.DeclaringMethod == null) ||
                                                     (parameter.ParameterType.IsArray && parameter.ParameterType.GetElementType().IsGenericParameter && parameter.ParameterType.GetElementType().DeclaringMethod == null);

                    bool isParamGeneric = EnableGenerics && !isException && (parameter.ParameterType.IsGenericParameter ||
                                         (parameter.ParameterType.IsArray && parameter.ParameterType.GetElementType().IsGenericParameter));

                    string paramType;
                    if (isException && isClassLevelGenericParam)
                    {
                        paramType = parameter.ParameterType.IsArray ? "IJCOBridgeReflected" : "IJCOBridgeReflected";
                        isPrimitive = false;
                        isManaged = true;
                        isSpecial = false;
                        isArray = parameter.ParameterType.IsArray;
                    }
                    else if (isParamGeneric)
                    {
                        paramType = parameter.ParameterType.IsArray ? parameter.ParameterType.GetElementType().Name : parameter.ParameterType.Name;
                    }
                    else
                    {
                        paramType = ConvertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                    }

                    // FIX: If the constructor parameter type is a constructed generic type (e.g. IEqualityComparer`1), strip the backtick for Java
                    if (!isParamGeneric && !isClassLevelGenericParam && !string.IsNullOrEmpty(paramType) && paramType.Contains("`"))
                    {
                        paramType = paramType.Split('`')[0];
                    }

                    if (isParamGeneric)
                    {
                        isArray = parameter.ParameterType.IsArray;
                        isPrimitive = false;
                        isManaged = true;
                        isSpecial = false;
                    }

                    if (!isManaged) break; // found not managed type, stop here

                    erasedCtorParamTypes.Add(isArray ? paramType + "[]" : paramType);

                    var paramName = ReplaceSinglekeyword(parameter.Name);
                    isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                    ctorParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));

                    string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                    if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                    string objectCaster = string.Empty;
                    if (isArray && parameters.Length == 1)
                    {
                        objectCaster = Const.SpecialNames.OBJECT_CASTER_NAME;
                    }
                    newObjectParams.Append(string.Format(formatter, objectCaster, paramName));
                }
                if (!isManaged) continue; // found not managed type, jump to next

                // JAVA LANGUAGE LIMIT: keep only the first constructor overload that reaches
                // this erased Java signature; a later one identical after erasure can't coexist.
                string javaErasedCtorSignature = "(" + string.Join(",", erasedCtorParamTypes) + ")";
                if (!javaErasedCtorSignaturesCreated.Add(javaErasedCtorSignature)) continue;

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

                string newObjParamStrGeneric = string.IsNullOrEmpty(newObjParamStr) ? string.Empty : ", " + newObjParamStr;

                var exceptionStr = item.ExceptionStringBuilder(imports);

                bool isGenericCtor = EnableGenerics && !isException && type.IsGenericTypeDefinition;
                // Replaces parameters and thrown exceptions seamlessly
                var otherCtor = ctorClassTemplate.Replace(Const.CTor.CTOR_PARAMETERS, ctorParamStr)
                                                 .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                // TOTAL FIX VIA TARGETED INJECTION: One single replacement shot handles both empty and loaded constructors
                otherCtor = otherCtor.Replace(Const.CTor.CTOR_NEWOBJECT_PARAMETERS, isGenericCtor ? newObjParamStrGeneric : newObjParamStr);

                ctors.AppendLine(CompleteMemberJavadoc(otherCtor, type));

                Interlocked.Increment(ref implementedCtors);
            }

            string ctorsStr = ctors.ToString();

            if (!isException && !hasDefaultCtor)
            {
                ctors = new StringBuilder();
                ctors.AppendLine(CompleteMemberJavadoc(defaultCtor, type));
                ctors.AppendLine(CompleteMemberJavadoc(ctorsStr, type));
                ctorsStr = ctors.ToString();
            }

            return ctorsStr;
        }
    }
}
