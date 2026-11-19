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
        static string ExportImports(this IList<Type> imports)
        {
            StringBuilder importsToExport = new StringBuilder();
            var emitted = new HashSet<string>();

            foreach (var item in imports)
            {
                var subItem = item;
                if (EnableRefOutParameters && item.IsByRef)
                {
                    subItem = item.GetElementType();
                }
                var name = subItem.GetJavaClassName(subItem.Assembly);
                if (string.IsNullOrWhiteSpace(name)) continue;

                if (subItem.IsInterface)
                {
                    if (subItem.IsManagedType(0, 1) && subItem != typeof(IEnumerator) && subItem != typeof(IEnumerable))
                    {
                        string line1 = string.Format(Const.Imports.IMPORT, subItem.ToPackageName(), name);
                        string line2 = string.Format(Const.Imports.IMPORT, subItem.ToPackageName(), name + Const.SpecialNames.ImplementationTrailer);
                        if (emitted.Add(line1)) importsToExport.AppendLine(line1);
                        if (emitted.Add(line2)) importsToExport.AppendLine(line2);
                    }
                }
                else if (subItem.IsManagedType(0, 1))
                {
                    string line = string.Format(Const.Imports.IMPORT, subItem.ToPackageName(), name);
                    if (emitted.Add(line)) importsToExport.AppendLine(line);
                }
            }
            return importsToExport.ToString();
        }

        // Recursively checks whether a type references, anywhere in its structure (arrays, by-ref,
        // or as a generic argument of a constructed type like JCORefOut<T>), a generic parameter that
        // belongs to the enclosing CLASS rather than to the current method.
        static bool ContainsClassLevelGenericParameter(Type t)
        {
            if (t == null) return false;
            if (t.IsGenericParameter) return t.DeclaringMethod == null;
            if (t.HasElementType) return ContainsClassLevelGenericParameter(t.GetElementType()); // arrays, by-ref (out/ref)
            if (t.IsGenericType) return t.GetGenericArguments().Any(ContainsClassLevelGenericParameter);
            return false;
        }

        static bool IsManagedType(this Type type, int recursion, int limit)
        {
            var innerType = type;
            if (recursion == limit) return false; // we don't manage array of arrays
            if (type.FullName == Const.SpecialNames.XamlReader) return false;
            if (!EnableRefOutParameters && type.IsByRef) // don't check IsByRef if EnableRefOutParameters is true
                return false;
            if (EnableRefOutParameters && type.IsByRef)
            {
                innerType = type.GetElementType();
            }

            if (innerType.IsArray)
            {
                if (!EnableArray) return false;  // uncomment to disable array
                if (innerType.Name.Contains(Const.SpecialNames.MultiArrayTrailer)) return false;
                else if (innerType.Name.Contains(Const.SpecialNames.ArrayTrailer))
                {
                    var tmp = innerType.Name.Substring(0, innerType.Name.LastIndexOf(Const.SpecialNames.ArrayTrailer));
                    if (tmp.Contains(Const.SpecialNames.ArrayTrailer)) return false; // it is [][]
                    return innerType.GetElementType().IsManagedType(recursion + 1, limit);
                }
                else return false;
            }
            if (typeof(Type).IsAssignableFrom(innerType)) // special type
            {
                return true;
            }
#if NET5_0_OR_GREATER
            // ref structs (Span<T>, ReadOnlySpan<T>...) can never cross the bridge as an object — same
            // reasoning as the TypePrefilter exclusion, but this is the gate that actually stops them
            // from being accepted as a parameter or return type of some OTHER method.
            if (EnableGenerics && innerType.IsByRefLike) return false;
#endif
            // FIX: If EnableGenerics is false, fallback immediately to the original native scart rule for any generic element
            if (!EnableGenerics && (innerType.IsGenericType || innerType.IsGenericParameter))
            {
                return false;
            }

            // GENERICS UPDATED: Allow open generic definitions and generic parameters (like T or K) to pass the management filters
            if (!innerType.IsPublic && !innerType.IsGenericParameter // only public types or generic parameters are managed except when used in out/ref
                || !(innerType.IsAnsiClass || innerType.IsClass || innerType.IsEnum || innerType.IsInterface || innerType.IsGenericParameter)
                || (EnableAbstract ? false : (innerType.IsAbstract && !innerType.IsSealed)) // discard real abstract class for now, but abstract/sealed classes are what in .NET are "public static class"
               )
            {
                return false;
            }
            if (typeof(Delegate).IsAssignableFrom(innerType)) // delegate types are managed only with events
            {
                string dummyEnumeratorType = string.Empty;
                // A parameter/return type can be a CONSTRUCTED generic delegate closed over an in-scope
                // type parameter (e.g. Comparison<T> as a parameter of List<T>.Sort, T being List<T>'s own
                // class-level parameter) — that's valid, ordinary usage, not a request to export a new
                // top-level file for a closed instantiation. Validate against the delegate's own generic
                // type DEFINITION (Comparison<>), which is what ExportingDelegate can actually generate,
                // instead of the constructed type itself — ExportingDelegate's own guard always rejects a
                // non-definition generic type, since it's never meant to export one as its own file.
                var delegateTypeToCheck = (EnableGenerics && innerType.IsGenericType && !innerType.IsGenericTypeDefinition)
                    ? innerType.GetGenericTypeDefinition()
                    : innerType;
                return delegateTypeToCheck.ExportingDelegate(null, null, out dummyEnumeratorType, true);
            }
            if (innerType.Name.Contains("IntPtr") || innerType.Name.Contains("*"))
                return false;

            return true;
        }

        static string CheckForSpecialNames(string name, Type type, out bool needImport)
        {
            needImport = true;
            if (name == "ArrayList") { needImport = false; return type.ToPackageName() + "." + name; }
            if (name == "Binding") { needImport = false; return type.ToPackageName() + "." + name; }
            if (name == "XamlReader") { needImport = false; return type.ToPackageName() + "." + name; }
            return name;
        }

        static string CheckForPrimitive(this Type type, bool isArray, out bool isPrimitive, out string defaultPrimitiveValue, out bool needImport)
        {
            needImport = false;
            isPrimitive = true;
            defaultPrimitiveValue = string.Empty;
            var innerType = type;
            if (EnableRefOutParameters && type.IsByRef)
            {
                innerType = type.GetElementType();
            }

            // TOTAL FIX FOR BUG #3: Secure against ANY type parameter or constructed type with a null FullName
            if (innerType.FullName == null || innerType.IsGenericParameter || (innerType.IsArray && innerType.GetElementType().IsGenericParameter))
            {
                isPrimitive = false;
                bool isBareGenericParameter = innerType.IsGenericParameter || (innerType.IsArray && innerType.GetElementType().IsGenericParameter);
                string genericName = innerType.IsArray
                    ? innerType.GetElementType().GetJavaClassName(innerType.GetElementType().Assembly)
                    : innerType.GetJavaClassName(innerType.Assembly);
                string result = CheckForSpecialNames(genericName, innerType, out needImport);
                if (isBareGenericParameter) needImport = false; // T / TOutput sono variabili di tipo Java, mai classi importabili
                return result;
            }

            // --- FIXED HIGH-PRECISION ARRAY ELEMENT EXTRACTION (Risolve il bug di IList`1[][]) ---
            var baseElementType = innerType;
            while (baseElementType.IsArray)
            {
                baseElementType = baseElementType.GetElementType();
            }

            // Extract the clean full name of the underlying type, dropping the array layout trailing brackets
            var fullName = isArray ? baseElementType.FullName : innerType.FullName;

            // Resolve the clean non-colliding Java name directly from the base element type (e.g., "IList" from "IList`1[][]")
            string resolvedCleanName = baseElementType.GetJavaClassName(baseElementType.Assembly);
            var name = isArray ? resolvedCleanName : resolvedCleanName;

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
                        retType = CheckForSpecialNames(name, innerType, out needImport);
                    }
                    break;
            }
            return retType;
        }

        static string CheckIsSpecial(this Type type, out bool isSpecial)
        {
            isSpecial = false;
            if (type == typeof(object)) { isSpecial = true; return Const.SpecialNames.NetObject; }
            if (type == typeof(Type)) { isSpecial = true; return Const.SpecialNames.NetType; }
            if (type == typeof(Exception)) { isSpecial = true; return Const.SpecialNames.NetException; }
            if (type == typeof(ArrayList)) { isSpecial = true; return Const.SpecialNames.NetArrayList; }
            if (type == typeof(IEnumerable)) { isSpecial = true; return Const.SpecialNames.NetIEnumerable; }
            if (type == typeof(IEnumerator)) { isSpecial = true; return Const.SpecialNames.NetIEnumerator; }

            string typeName = type.Name;
            if (EnableRefOutParameters && type.IsByRef)
            {
                typeName = typeName.Substring(0, typeName.Length - 1);
            }

            return typeName;
        }

        static string ConvertType(IList<Type> imports, Type type, out bool isPrimitive, out string defaultPrimitiveValue, out bool isManaged, out bool isSpecial, out bool isArray, bool storeInImports = true)
        {
            isPrimitive = true;
            defaultPrimitiveValue = string.Empty;
            isSpecial = false;
            var innerType = type;
            if (EnableRefOutParameters && type.IsByRef)
            {
                innerType = type.GetElementType();
            }
            isArray = innerType.IsArray || innerType.Name.Contains("[]");
            isManaged = type.IsManagedType(0, 2);
            bool needImport = true;
            try
            {
                if (!isManaged) { return string.Empty; }
                var special = CheckIsSpecial((isArray) ? innerType.GetElementType() : innerType, out isSpecial);
                if (isSpecial) { needImport = false; isPrimitive = false; return special; }

                return innerType.CheckForPrimitive(isArray, out isPrimitive, out defaultPrimitiveValue, out needImport);
            }
            finally
            {
                if (imports != null && storeInImports && needImport && isManaged)
                {
                    if (isArray && innerType.GetElementType().IsManagedType(0, 1))
                    {
                        innerType = innerType.GetElementType();

                        bool isArrayHere = innerType.IsArray || innerType.Name.Contains(Const.SpecialNames.ArrayTrailer);
                        if (!isArrayHere)
                        {
                            bool isSpecialHere;
                            bool isPrimitiveHere;
                            bool needImportHere;
                            string defaultPrimitiveValueHere;
                            innerType.CheckIsSpecial(out isSpecialHere);
                            innerType.CheckForPrimitive(isArrayHere, out isPrimitiveHere, out defaultPrimitiveValueHere, out needImportHere);
                            if (needImportHere && !isPrimitiveHere && !isSpecialHere && !imports.Contains(innerType))
                            {
                                imports.Add(innerType);
                            }
                        }
                    }
                    else if (!isPrimitive && !isSpecial && !imports.Contains(innerType))
                    {
                        imports.Add(innerType);
                    }
                }
            }
        }

        static bool IsPrivitiveConvertibleFromNumber(string type)
        {
            switch (type.ToLowerInvariant())
            {
                case "byte":
                case "double":
                case "float":
                case "int":
                case "long":
                case "short":
                    return true;
                default: return false;
            }
        }

        static bool IsDifferentOnlyForRetVal(this IList<string> signatures, string signToCheck, string methodName)
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

        static bool IsParams(this ParameterInfo param)
        {
            return param.IsDefined(typeof(ParamArrayAttribute), false);
        }
    }
}
