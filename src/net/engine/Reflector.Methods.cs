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
        static void SearchMethods(this Type type, IList<MethodInfo> allMethods, bool traverseHierarchy)
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
                    if (!item.IsManagedType(0, 1)) continue;
                    item.SearchMethods(allMethods, traverseHierarchy);
                }
            }
            else if (type.BaseType != null)
            {
                if (!type.BaseType.IsManagedType(0, 1) || type.BaseType == typeof(object) || type.BaseType == typeof(Exception) || type.BaseType == typeof(Type)) return;
                type.BaseType.SearchMethods(allMethods, traverseHierarchy);
            }
        }

        static string SignatureWithoutRetVal(this MethodInfo method)
        {
            if (method == null) return string.Empty;
            var sign = method.ToString();
            sign = sign.Substring(sign.IndexOf(' '));
            return sign;
        }

        static bool IsNewMethod(this Type type, MethodInfo method, IList<MethodInfo> allMethods)
        {
            string refSign = method.SignatureWithoutRetVal();
            if (method.GetBaseDefinition().DeclaringType == type)
            {
                foreach (var item in allMethods)
                {
                    if (item.Name == method.Name
                        && item.DeclaringType != type
                        && item.SignatureWithoutRetVal() == refSign)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        static bool CheckExportingAvoidanceMap(string fullname, string methodPropertyName)
        {
            foreach (var entry in Const.SpecialNames.ExportingAvoidanceMap)
            {
                if (!System.Text.RegularExpressions.Regex.IsMatch(fullname, entry.Key)) continue;
                return entry.Value == null || entry.Value.Contains(methodPropertyName);
            }

            return false;
        }

        static bool AvoidExportMethods(this Type type, MethodInfo method)
        {
            if (!EnableRefOutParameters) return false;

            // FIX: Fallback to Name if FullName is null (common for open generic types)
            var fullname = type.FullName ?? type.Name;
            return CheckExportingAvoidanceMap(fullname, method.Name);
        }

        static string ExportMethods(this Type type, IList<Type> imports, IList<Type> implementableInterfaces, bool withInheritance, string destFolder, string assemblyname, out string returnEnumeratorType, out string returnInterfaceSection)
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
            type.SearchMethods(allMethods, isInterface);
            methods = allMethods.ToArray();

            var methodLst = new List<MethodInfo>();

            string templateInterfaceToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceMethodTemplate);
            string templateToUse = string.Empty;

            List<string> methodsSignatureCreated = new List<string>();
            List<string> methodsNameCreated = new List<string>();
            List<string> methodsDuplicatedCreated = new List<string>();
            // Tracks method signatures as they appear AFTER Java type erasure (raw parameter types,
            // no generic type arguments). Two distinct .NET overloads can still collapse onto the same
            // erased Java signature (e.g. WhenAny(IEnumerable<Task>) vs WhenAny<TResult>(IEnumerable<Task<TResult>>)
            // both become WhenAny(IEnumerable_1)) — Java cannot declare both, so the second one is dropped.
            HashSet<string> javaErasedSignaturesCreated = new HashSet<string>();

            bool isPrimitive = true;
            string defaultPrimitiveValue = string.Empty;
            bool isSpecial = false;
            bool isArray = false;
            bool isRetValArray = false;
            bool isManaged = true;
            bool hasEnumerable = typeof(IEnumerable).IsAssignableFrom(type);

            StringBuilder methodInterfaceBuilder = new StringBuilder();
            StringBuilder methodBuilder = new StringBuilder();

            if (methods.Length != 0)
            {
                SortedDictionary<string, MethodInfo> sortedData = new SortedDictionary<string, MethodInfo>();
                foreach (var item in methods)
                {
                    var strMethod = item.ToString();
                    if (!sortedData.ContainsKey(strMethod))
                    {
                        sortedData.Add(strMethod, item);
                    }
                }

                methodLst.AddRange(sortedData.Values);
                methods = methodLst.ToArray();

                foreach (var item in methods)
                {
                    var methodName = item.Name;

                    if (type.AvoidExportMethods(item)) continue;

                    isPrimitive = true;
                    defaultPrimitiveValue = string.Empty;
                    isSpecial = false;
                    isArray = false;
                    isRetValArray = false;
                    isManaged = true;

                    if (!item.IsPublic
                        || item.IsSpecialName// remove properties
                        || methodsSignatureCreated.Contains(item.ToString())
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

                    if (!EnableGenerics && (item.IsGenericMethod // don't manage generic methods
                        || item.ContainsGenericParameters)
                       ) continue;

                    // GENERICS UPDATED: Allow methods containing generic parameters, block only real complex unbound scenarios
                    if (((withInheritance && !isInterface) ? item.DeclaringType != type : false)
                        || (!methodsNameCreated.Contains(methodName) ? false : methodsSignatureCreated.IsDifferentOnlyForRetVal(item.ToString(), methodName))
                       ) continue;

                    var parameters = item.GetParameters();

                    // "new T(...)"/"new T[...]" are never legal Java: only a CLASS-level T can be resolved at
                    // runtime, via the Class<T> captured by the anonymous-subclass trick at construction time
                    // (instantiateGenericArgument/genericArgumentClasses). A method's own <T> (e.g. static
                    // Array.Empty<T>(), MemoryMarshal.GetArrayDataReference<T>(T[])) has no such capture point —
                    // unwrap "ref T" (a by-ref return) first, since MemoryMarshal.GetArrayDataReference and
                    // friends return "ref T", not "T" directly.
                    var unwrappedReturnTypeForSkipCheck = item.ReturnType.IsByRef ? item.ReturnType.GetElementType() : item.ReturnType;
                    bool returnHasMethodLevelGenericParam =
                        (unwrappedReturnTypeForSkipCheck.IsGenericParameter && unwrappedReturnTypeForSkipCheck.DeclaringMethod != null) ||
                        (unwrappedReturnTypeForSkipCheck.IsArray && unwrappedReturnTypeForSkipCheck.GetElementType().IsGenericParameter && unwrappedReturnTypeForSkipCheck.GetElementType().DeclaringMethod != null);

                    if (EnableGenerics && returnHasMethodLevelGenericParam)
                    {
                        // Not representable in Java: only a CLASS-level T can be resolved at runtime, via the
                        // Class<T> captured by the anonymous-subclass trick at construction time
                        // (instantiateGenericArgument). A method's own <T> has no such capture point — there's
                        // no "new instance of T" or "array of T" we can build reflectively — so the member is
                        // skipped entirely rather than emitting invalid Java.
                        continue;
                    }

                    if (methodName == "ToString" && parameters.Length == 0) continue;
                    if (methodName == "GetHashCode" && parameters.Length == 0) continue;
                    if (methodName == "GetType" && parameters.Length == 0) continue;
                    if (methodName == "Equals" && parameters.Length == 1 && parameters[0].ParameterType == typeof(object)) continue;

                    // JAVA LANGUAGE LIMIT: a static member cannot reference a generic parameter that belongs
                    // to the enclosing class (Java erasure keeps a single shared class per raw type, unlike
                    // .NET where each closed generic instantiation has its own static state). Only skip when
                    // the parameter belongs to the class (DeclaringMethod == null); a method-level generic
                    // parameter (DeclaringMethod != null) is fine on a static method and is handled elsewhere.
                    bool referencesClassLevelGenericParameter =
                        ContainsClassLevelGenericParameter(item.ReturnType) ||
                        parameters.Any(p => ContainsClassLevelGenericParameter(p.ParameterType));

                    if (item.IsStatic && referencesClassLevelGenericParameter)
                    {
                        // Not representable in Java: a static context cannot see the class's own type parameter.
                        continue;
                    }

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
                            if (!item.ReturnType.ExportingEnumerator(null, null, out returnEnumeratorType, true))
                            {
                                returnEnumeratorType = string.Empty;
                                continue;
                            }

                            returnType = ConvertType(imports, item.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                            if (!isManaged)
                            {
                                returnEnumeratorType = string.Empty;
                                continue;
                            }

                            if (!isInterface && EnableInheritance && EnableInterfaceInheritance && type.GetInterfaces().Contains(typeof(IEnumerable)))
                            {
                                enumeratorMethodName += type.GetJavaClassName(type.Assembly);
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
                        string implementationReturnType = string.Empty;
                        string methodGenericMarker = string.Empty;

                        if (EnableGenerics && item.IsGenericMethod)
                        {
                            Type[] methodGenericArgs = item.GetGenericArguments();
                            if (methodGenericArgs.Length > 0)
                            {
                                // Compiles the exact Java declarationLayout: "<T extends IJCOBridgeReflected>"
                                methodGenericMarker = $"<{BuildTypeParameters(methodGenericArgs, imports)}> ";
                            }
                        }

                        if (item.ReturnType == typeof(void))
                        {
                            templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassVoidMethodTemplate);
                        }
                        else
                        {
                            var unwrappedReturnType = item.ReturnType.IsByRef ? item.ReturnType.GetElementType() : item.ReturnType;

                            // GENERICS UPDATED: Route generic type parameters returned by methods natively
                            if (EnableGenerics && item.ReturnType.IsGenericParameter)
                            {
                                returnType = item.ReturnType.Name; // Evaluates to "T" or "K" literal signature
                                isPrimitive = true; // FORCED: Triggers File 6 template to bypass "new T()" erasure compilation crash
                                isManaged = true;
                                isSpecial = false;
                                isRetValArray = false;
                                isInterfaceRetVal = false;
                                implementationReturnType = returnType;

                                // Don't overwrite the marker already built from ALL of item.GetGenericArguments():
                                // it already covers this case (a generic method always has DeclaringMethod != null
                                // on its own type parameters). Overwriting here dropped every other type parameter
                                // besides the return type's own (e.g. CreateWrapperOfType<T, TWrapper> lost T).
                                if (item.ReturnType.DeclaringMethod != null && string.IsNullOrEmpty(methodGenericMarker))
                                {
                                    methodGenericMarker = $"<{returnType} extends IJCOBridgeReflected> ";
                                }

                                templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassNativeMethodTemplate);
                            }
                            else if (EnableGenerics && item.ReturnType.IsByRef && unwrappedReturnType.IsGenericParameter && unwrappedReturnType.DeclaringMethod == null)
                            {
                                // "ref T" (ItemRef, PeekRef, GetValueRefOrNullRef...) where T belongs to the
                                // CLASS: "new T(...)" is illegal, but T IS resolvable via instantiateGenericArgument
                                // (same mechanism already used for array elements), since the class-level Class<T>
                                // was captured at construction time.
                                returnType = unwrappedReturnType.Name;
                                isPrimitive = false;
                                isManaged = true;
                                isSpecial = false;
                                isRetValArray = false;
                                isInterfaceRetVal = false;
                                implementationReturnType = returnType;

                                int genericArgIndex = Array.IndexOf(type.GetGenericArguments(), unwrappedReturnType);
                                templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassObjectMethodGenericTemplate)
                                                                .Replace("GENERIC_ARGUMENT_INDEX", genericArgIndex.ToString());
                            }
                            else
                            {
                                returnType = ConvertType(imports, item.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isRetValArray);
                                if (!isManaged) continue;

                                // FIX: Strip backticks from the return type signature for Java (e.g. ReadOnlyCollection`1 -> ReadOnlyCollection)
                                if (returnType.Contains("`"))
                                {
                                    returnType = returnType.Split('`')[0];
                                }

                                isPrimitive |= typeof(Delegate).IsAssignableFrom(item.ReturnType);
                                if (isRetValArray)
                                {
                                    isInterfaceRetVal = item.ReturnType.GetElementType().IsInterface;
                                    implementationReturnType = isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType;

                                    // "new T(...)" is never legal Java: if the array element is a generic parameter that
                                    // belongs to the CLASS (not this method), route to the reflective-instantiation variant.
                                    var arrayElementType = item.ReturnType.GetElementType();
                                    if (EnableGenerics && arrayElementType.IsGenericParameter && arrayElementType.DeclaringMethod == null)
                                    {
                                        int genericArgIndex = Array.IndexOf(type.GetGenericArguments(), arrayElementType);
                                        templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassObjectArrayGenericMethodTemplate)
                                                                        .Replace("GENERIC_ARGUMENT_INDEX", genericArgIndex.ToString());
                                    }
                                    else
                                    {
                                        templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayMethodTemplate
                                                                                                  : Const.Templates.ReflectorClassObjectArrayMethodTemplate);
                                    }
                                }
                                else
                                {
                                    isInterfaceRetVal = item.ReturnType.IsInterface;
                                    implementationReturnType = isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType;
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? IsPrivitiveConvertibleFromNumber(returnType) ? Const.Templates.ReflectorClassNativeMethodWithCastToNumberTemplate
                                    : Const.Templates.ReflectorClassNativeMethodTemplate
                                    : Const.Templates.ReflectorClassObjectMethodTemplate);
                                }

                                // FIX: Ensure implementationReturnType also drops the backtick if present
                                if (implementationReturnType.Contains("`"))
                                {
                                    implementationReturnType = implementationReturnType.Split('`')[0];
                                }

                                // A constructed generic over in-scope type parameters (ICollection<TKey>) is declared
                                // parameterized; implementationReturnType was computed from the raw name above, so the
                                // "...Implementation" instance keeps being created raw.
                                if (!isRetValArray && !isPrimitive && !isSpecial
                                    && !typeof(Exception).IsAssignableFrom(type)
                                    && IsResolvableConstructedGeneric(item.ReturnType))
                                {
                                    returnType = ResolveGenericTypeName(item.ReturnType, imports);
                                }
                            }
                        }
                        // --- FIXED GENERICS ANALYSIS FOR METHOD INPUT PARAMETERS ---
                        StringBuilder inputParams = new StringBuilder();
                        StringBuilder execParams = new StringBuilder();
                        bool builtWithJCORefOut = false;
                        // Raw parameter types only (no variable names, no array/varargs decoration beyond
                        // "[]"), used later to detect Java erasure collisions between .NET overloads.
                        List<string> erasedParamTypes = new List<string>();
                        foreach (var parameter in parameters)
                        {
                            string paramType = string.Empty;

                            // A parameter is generic if it is a raw generic parameter (T) OR an array of generic parameters (T[])
                            bool isParamGeneric = EnableGenerics && (parameter.ParameterType.IsGenericParameter ||
                                                 (parameter.ParameterType.IsArray && parameter.ParameterType.GetElementType().IsGenericParameter));
                            // ...or a constructed generic over in-scope type parameters (KeyValuePair<TKey,TValue>):
                            // resolved recursively instead of falling back to the raw type.
                            bool isParamConstructedGeneric = !isParamGeneric && !typeof(Exception).IsAssignableFrom(type) && IsResolvableConstructedGeneric(parameter.ParameterType)
                                                             && !DeclaresSameNameAndArityInBaseClass(type, methodName, parameters.Length);

                            if (isParamGeneric)
                            {
                                if (parameter.ParameterType.IsArray)
                                {
                                    paramType = parameter.ParameterType.GetElementType().Name;
                                    isArray = true;
                                }
                                else
                                {
                                    paramType = parameter.ParameterType.Name;
                                    isArray = false;
                                }
                                isPrimitive = false;
                                isManaged = true;
                                isSpecial = false;
                            }
                            else
                            {
                                paramType = ConvertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);

                                // FIX: If the parameter type is a constructed generic type (e.g. IComparer`1), strip the backtick for Java
                                if (paramType.Contains("`"))
                                {
                                    paramType = paramType.Split('`')[0];
                                }

                                // ConvertType has already accepted the type (managed, exportable, not a ref struct):
                                // now keep its type arguments instead of the raw name.
                                if (isParamConstructedGeneric && isManaged && !isPrimitive && !isSpecial && !isArray)
                                {
                                    paramType = ResolveGenericTypeName(parameter.ParameterType, imports);
                                }
                            }

                            hasNativeArrayInParameter |= isArray && isPrimitive;
                            bool useRefOut = false;
                            if (!EnableRefOutParameters)
                            {
                                isManaged &= !(parameter.IsOut || parameter.ParameterType.IsByRef);
                            }
                            else
                            {
                                useRefOut = parameter.IsOut || parameter.ParameterType.IsByRef;
                            }
                            if (!isManaged) break;

                            // Record the erased parameter type as it will actually appear in the generated
                            // Java signature. JCORefOut<T> and JCORefOut<NetObject> erase to the same
                            // "JCORefOut" regardless of what's inside — record the wrapper itself for a
                            // by-ref/out parameter, not the inner paramType, or two overloads that only
                            // differ inside a JCORefOut<...> won't be seen as colliding.
                            erasedParamTypes.Add(useRefOut ? "JCORefOut" : (isArray ? paramType + "[]" : (isParamConstructedGeneric ? paramType.Split('<')[0] : paramType)));

                            isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                            string formatter = string.Empty;
                            string objectCaster = string.Empty;
                            var paramName = ReplaceSinglekeyword(parameter.Name);
                            if (useRefOut)
                            {
                                string primitiveParam = Const.Parameters.JCORefOutType;
                                if (isPrimitive && !isArray && Const.SpecialNames.DirectMappablePrimitives.ContainsKey(paramType))
                                {
                                    primitiveParam = string.Format(Const.Parameters.JCORefOutTypeGenericFormatter, Const.SpecialNames.DirectMappablePrimitives[paramType]);
                                }
                                string typeString = isPrimitive ? primitiveParam : string.Format(Const.Parameters.JCORefOutTypeGenericFormatter, (isArray) ? paramType + Const.SpecialNames.ArrayTrailer : paramType);
                                inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, typeString, paramName));
                                formatter = Const.Parameters.INVOKE_PARAMETER_JCOREFOUT;
                                builtWithJCORefOut = true;
                            }
                            else
                            {
                                inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));
                                if (isParamGeneric)
                                {
                                    if (isArray)
                                    {
                                        // T[] cannot be cast directly to IJCOBridgeReflected (an array is never assignable
                                        // to it); marshal it element-by-element like any other non-primitive array.
                                        formatter = ", " + paramName + " == null ? null : toObjectFromArray(" + paramName + ")";
                                    }
                                    else
                                    {
                                        // GENERICS SECURITY CAST: Explicitly cast T or K to IJCOBridgeReflected to expose getJCOInstance() for marshalling
                                        formatter = ", " + paramName + " == null ? null : ((IJCOBridgeReflected)" + paramName + ").getJCOInstance()";
                                    }
                                }
                                else
                                {
                                    formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                                    if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;
                                    if (isArray && parameters.Length == 1)
                                    {
                                        objectCaster = Const.SpecialNames.OBJECT_CASTER_NAME;
                                    }
                                }
                            }
                            if (isParamGeneric && !useRefOut)
                            {
                                execParams.Append(formatter);
                            }
                            else
                            {
                                execParams.Append(string.Format(formatter, objectCaster, paramName));
                            }
                        }
                        if (!isManaged) continue;

                        // JAVA LANGUAGE LIMIT: after erasure, this overload's signature may be identical to
                        // one already emitted for the same method name, even though the two .NET overloads
                        // are genuinely distinct (e.g. one closes a generic argument, the other doesn't).
                        // Java cannot declare both, so keep only the first one encountered.
                        string javaErasedSignature = methodName + "(" + string.Join(",", erasedParamTypes) + ")";
                        if (!javaErasedSignaturesCreated.Add(javaErasedSignature)) continue;

                        string inputParamStr = inputParams.ToString();
                        if (!string.IsNullOrEmpty(inputParamStr))
                        {
                            inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                        }

                        // --- TOTAL SANITIZATION FOR METHOD INVOKE PARAMETERS (FIXES JAVA BRACE TRUNCATION) ---
                        string execParamStr = execParams.ToString().Trim();

                        // Ensure there are no loose or broken generic concatenation tokens leftover
                        if (execParamStr.StartsWith(","))
                        {
                            execParamStr = execParamStr.Substring(1).Trim();
                        }

                        // If the final string is not empty, ensure it starts with a clean comma space separator for classInstance.Invoke
                        if (!string.IsNullOrEmpty(execParamStr) && !execParamStr.StartsWith(","))
                        {
                            execParamStr = ", " + execParamStr;
                        }
                        var exceptionStr = item.ExceptionStringBuilder(imports);
                        bool isNewMethodVal = (withInheritance && !isInterface) ? type.IsNewMethod(item, allMethods) : false;
                        string newMethodName = string.Empty;
                        if (isNewMethodVal)
                        {
                            newMethodName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, methodName, type.GetJavaClassName(type.Assembly));
                        }

                        // NetObject exposes Equals(IJCOBridgeReflected) and Equals(IJCOBridgeReflected,IJCOBridgeReflected).
                        // A generated Equals(T)/Equals(T,T) on a generic type (IEquatable<T>, IEqualityComparer<T>...)
                        // erases to the exact same signature, and Java rejects the pair ("have the same erasure, yet
                        // neither overrides the other"). Rename the generic one instead of losing it: reuses the same
                        // "use newMethodName for the Java-visible name, keep methodName for the real .NET Invoke/Get
                        // call" switch already used for the "new" keyword case above.
                        bool clashesWithNetObjectEquals = EnableGenerics && methodName == "Equals"
                            && (parameters.Length == 1 || parameters.Length == 2)
                            && parameters.All(p => p.ParameterType.IsGenericParameter);
                        if (clashesWithNetObjectEquals)
                        {
                            newMethodName = methodName + "Generic";
                            isNewMethodVal = true;
                        }

                        bool clashesWithBase = EnableGenerics && !isInterface && parameters.Length > 0
                            && ClashesWithBaseClassMethod(type, methodName, parameters.Length)
                            && parameters.All(p => p.ParameterType.IsGenericParameter);
                        if (clashesWithBase)
                        {
                            newMethodName = methodName + "ByKey";
                            isNewMethodVal = true;
                        }

                        // --- REPLACEMENT PIPELINE FOR METHOD TEMPLATE TAGS ---
                        string modifierKeyword = item.IsStatic ? Const.SpecialNames.STATIC_KEYWORD : string.Empty;
                        string finalModifier = modifierKeyword + methodGenericMarker;
                        methodStr = templateToUse.Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, finalModifier)
                                                 .Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                 .Replace(Const.Methods.METHOD_NAME, methodName)
                                                 .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                 .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, implementationReturnType)
                                                 .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                 .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                 .Replace(Const.Methods.METHOD_OBJECT, item.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                                 .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                        // --- GENERICS INJECTION FOR PURE INTERFACE METHOD SIGNATURE ---
                        if (withInheritance ? (isInterface && (item.GetBaseDefinition().DeclaringType == type)) : isInterface)
                        {
                            // If the method uses a generic parameter belonging to the method itself, inject the bound declaration
                            string interfaceGenericMarker = string.Empty;
                            if (EnableGenerics && item.IsGenericMethod)
                            {
                                Type[] methodGenericArgs = item.GetGenericArguments();
                                if (methodGenericArgs.Length > 0)
                                {
                                    interfaceGenericMarker = $"<{BuildTypeParameters(methodGenericArgs, imports)}> ";
                                }
                            }

                            // NetObject exposes Equals(IJCOBridgeReflected) and Equals(IJCOBridgeReflected,IJCOBridgeReflected).
                            // A generated Equals(T)/Equals(T,T) on a generic type (IEquatable<T>, IEqualityComparer<T>...)
                            // erases to the exact same signature, and Java rejects the pair ("have the same erasure, yet
                            // neither overrides the other"). Rename the generic one instead of losing it: reuses the same
                            // "use newMethodName for the Java-visible name, keep methodName for the real .NET Invoke/Get
                            // call" switch already used for the "new" keyword case above.
                            clashesWithNetObjectEquals = EnableGenerics && methodName == "Equals"
                                && (parameters.Length == 1 || parameters.Length == 2)
                                && parameters.All(p => p.ParameterType.IsGenericParameter);
                            if (clashesWithNetObjectEquals)
                            {
                                newMethodName = methodName + "Generic";
                                isNewMethodVal = true;
                            }

                            // We handle the modifier replacement by injecting the generic marker if present right after public statement
                            methodInterfaceStr = templateInterfaceToUse.Replace("public ", $"public {interfaceGenericMarker}")
                                                                       .Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                                       .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                       .Replace(Const.Methods.METHOD_RETURN_TYPE, isRetValArray ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                                       .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                                       .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                                       .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                        }

                        if (EnableDuplicateMethodNativeArrayWithJCRefOut && hasNativeArrayInParameter && !builtWithJCORefOut)
                        {
                            inputParams = new StringBuilder();
                            execParams = new StringBuilder();
                            foreach (var parameter in parameters)
                            {
                                string paramType = string.Empty;

                                // A parameter is generic if it is a raw generic parameter (T) OR an array of generic parameters (T[])
                                bool isParamGeneric = EnableGenerics && (parameter.ParameterType.IsGenericParameter ||
                                                     (parameter.ParameterType.IsArray && parameter.ParameterType.GetElementType().IsGenericParameter));
                                // same rule as the main signature, so the duplicated overload stays consistent with it
                                bool isParamConstructedGeneric = !isParamGeneric && !typeof(Exception).IsAssignableFrom(type) && IsResolvableConstructedGeneric(parameter.ParameterType)
                                                                 && !DeclaresSameNameAndArityInBaseClass(type, methodName, parameters.Length);

                                if (isParamGeneric)
                                {
                                    if (parameter.ParameterType.IsArray)
                                    {
                                        paramType = parameter.ParameterType.GetElementType().Name;
                                        isArray = true;
                                    }
                                    else
                                    {
                                        paramType = parameter.ParameterType.Name;
                                        isArray = false;
                                    }
                                    isPrimitive = false;
                                    isManaged = true;
                                    isSpecial = false;
                                }
                                else
                                {
                                    paramType = ConvertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);

                                    if (isParamConstructedGeneric && isManaged && !isPrimitive && !isSpecial && !isArray)
                                    {
                                        paramType = ResolveGenericTypeName(parameter.ParameterType, imports);
                                    }
                                }

                                bool isNativeArrayInParameter = isArray && isPrimitive;
                                isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                                var paramName = string.Format(Const.Methods.DUPLICATED_PARAMETER_PROTO, parameter.Position);
                                string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                                if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;
                                if (isNativeArrayInParameter)
                                {
                                    inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, Const.Parameters.JCORefOutType, paramName));
                                    formatter = Const.Parameters.INVOKE_PARAMETER_JCOREFOUT;
                                }
                                else
                                {
                                    inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));
                                    if (isParamGeneric)
                                    {
                                        formatter = ", " + paramName + " == null ? null : ((IJCOBridgeReflected)" + paramName + ").getJCOInstance()";
                                    }
                                }
                                string objectCaster = string.Empty;
                                if (isArray && parameters.Length == 1)
                                {
                                    objectCaster = Const.SpecialNames.OBJECT_CASTER_NAME;
                                }
                                if (isParamGeneric)
                                {
                                    execParams.Append(formatter);
                                }
                                else
                                {
                                    execParams.Append(string.Format(formatter, objectCaster, paramName));
                                }
                            }
                            inputParamStr = inputParams.ToString();
                            if (!string.IsNullOrEmpty(inputParamStr))
                            {
                                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                            }

                            // --- TOTAL SANITIZATION FOR INTERFACE METHOD INVOKE PARAMETERS ---
                            execParamStr = execParams.ToString().Trim();
                            if (execParamStr.StartsWith(","))
                            {
                                execParamStr = execParamStr.Substring(1).Trim();
                            }
                            if (!string.IsNullOrEmpty(execParamStr) && !execParamStr.StartsWith(","))
                            {
                                execParamStr = ", " + execParamStr;
                            }

                            // NetObject exposes Equals(IJCOBridgeReflected) and Equals(IJCOBridgeReflected,IJCOBridgeReflected).
                            // A generated Equals(T)/Equals(T,T) on a generic type (IEquatable<T>, IEqualityComparer<T>...)
                            // erases to the exact same signature, and Java rejects the pair ("have the same erasure, yet
                            // neither overrides the other"). Rename the generic one instead of losing it: reuses the same
                            // "use newMethodName for the Java-visible name, keep methodName for the real .NET Invoke/Get
                            // call" switch already used for the "new" keyword case above.
                            clashesWithNetObjectEquals = EnableGenerics && methodName == "Equals"
                                && (parameters.Length == 1 || parameters.Length == 2)
                                && parameters.All(p => p.ParameterType.IsGenericParameter);
                            if (clashesWithNetObjectEquals)
                            {
                                newMethodName = methodName + "Generic";
                                isNewMethodVal = true;
                            }

                            dupMethodStr = templateToUse.Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, finalModifier)
                                                        .Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                        .Replace(Const.Methods.METHOD_NAME, methodName)
                                                        .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                        .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, implementationReturnType)
                                                        .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                        .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                        .Replace(Const.Methods.METHOD_OBJECT, item.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                                        .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                            if (withInheritance ? (isInterface && (item.GetBaseDefinition().DeclaringType == type)) : isInterface)
                            {
                                dupMethodInterfaceStr = templateInterfaceToUse.Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, methodGenericMarker)
                                                                              .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                              .Replace(Const.Methods.METHOD_JAVA_NAME, methodName)
                                                                              .Replace(Const.Methods.METHOD_RETURN_TYPE, isRetValArray ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                                              .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                                              .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                                              .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);
                            }
                            dupMethodSignature = templateInterfaceToUse.Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, methodGenericMarker)
                                                                       .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                       .Replace(Const.Methods.METHOD_JAVA_NAME, methodName)
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
                        methodInterfaceBuilder.AppendLine(CompleteMemberJavadoc(methodInterfaceStr, type));
                        if (EnableDuplicateMethodNativeArrayWithJCRefOut && !string.IsNullOrEmpty(dupMethodInterfaceStr) && !methodsDuplicatedCreated.Contains(dupMethodSignature))
                        {
                            methodInterfaceBuilder.AppendLine(CompleteMemberJavadoc(dupMethodInterfaceStr, type));
                        }
                    }

                    methodBuilder.AppendLine(CompleteMemberJavadoc(methodStr, type));
                    if (EnableDuplicateMethodNativeArrayWithJCRefOut && !string.IsNullOrEmpty(dupMethodStr) && !methodsDuplicatedCreated.Contains(dupMethodSignature))
                    {
                        methodBuilder.AppendLine(CompleteMemberJavadoc(dupMethodStr, type));
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
            }
            else if (!EnableInterfaceInheritance) return string.Empty;
            // --- Note: Interface Inheritance Traversing cycle code continues here untouched according to original layout ---
            if (!isInterface && EnableInheritance && EnableInterfaceInheritance)
            {
                foreach (var implementableInterface in implementableInterfaces.ToArray())
                {
                    allMethods = new List<MethodInfo>();
                    implementableInterface.SearchMethods(allMethods, true);
                    methods = allMethods.ToArray();

                    if (methods.Length == 0) continue;

                    SortedDictionary<string, MethodInfo> sortedData = new SortedDictionary<string, MethodInfo>();
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
                    int extraImplementedMethods = 0;

                    foreach (var interfaceMethod in methods)
                    {
                        var methodName = interfaceMethod.Name;

                        if (implementableInterface.AvoidExportMethods(interfaceMethod)) continue;

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

                        // FIX: Add protection for interface methods signature traversing when EnableGenerics is false
                        if (!EnableGenerics && (interfaceMethod.IsGenericMethod || interfaceMethod.ContainsGenericParameters)) continue;

                        if (interfaceMethod.IsGenericMethod // don't manage generic methods
                            || interfaceMethod.ContainsGenericParameters
                            || ((withInheritance) ? interfaceMethod.DeclaringType != implementableInterface : false)
                            || (!methodsNameCreated.Contains(methodName) ? false : methodsSignatureCreated.IsDifferentOnlyForRetVal(interfaceMethod.ToString(), methodName))
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
                            if (EnableInheritance && EnableInterfaceInheritance && interfaceMethod.ReturnType == typeof(IEnumerator))
                            {
                                //returnEnumeratorType = string.Empty;
                                returnType = Const.SpecialNames.NetIEnumerator;
                                methodStr = templateToUse.Replace(Const.Methods.METHOD_INTERFACE_NAME, implementableInterface.GetJavaClassName(implementableInterface.Assembly))
                                                         .Replace(Const.Methods.METHOD_ENUMERATOR_NAME, enumeratorMethodName)
                                                         .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                         .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, interfaceMethod.ReturnType.IsInterface ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                         .Replace(Const.Methods.METHOD_RETURN_INNER_TYPE, Const.SpecialNames.NetObject);
                            }
                            else
                            {
                                if (!interfaceMethod.ReturnType.ExportingEnumerator(null, null, out returnEnumeratorType, true))
                                {
                                    //returnEnumeratorType = string.Empty;
                                    continue;
                                }

                                returnType = ConvertType(imports, interfaceMethod.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                                if (!isManaged)
                                {
                                    //returnEnumeratorType = string.Empty;
                                    continue;
                                }

                                if (EnableInheritance && EnableInterfaceInheritance && type.GetInterfaces().Contains(typeof(IEnumerable)))
                                {
                                    enumeratorMethodName += type.GetJavaClassName(type.Assembly);
                                }

                                methodStr = templateToUse.Replace(Const.Methods.METHOD_INTERFACE_NAME, implementableInterface.GetJavaClassName(implementableInterface.Assembly))
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
                                returnType = ConvertType(imports, interfaceMethod.ReturnType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isRetValArray);
                                if (!isManaged) continue;

                                // FIX: Strip backticks from the interface return type signature for Java (ReadOnlyCollection`1 -> ReadOnlyCollection)
                                if (returnType.Contains("`"))
                                {
                                    returnType = returnType.Split('`')[0];
                                }

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
                            bool builtWithJCORefOut = false;
                            // Same format used by the real ExportMethods loop's javaErasedSignaturesCreated, so the
                            // comparison below is apples-to-apples.
                            List<string> erasedParamTypes = new List<string>();
                            foreach (var parameter in parameters)
                            {
                                string paramType = ConvertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);

                                // FIX: Strip backticks from constructed generic parameter signatures inside inherited methods for Java
                                if (!string.IsNullOrEmpty(paramType) && paramType.Contains("`"))
                                {
                                    paramType = paramType.Split('`')[0];
                                }

                                hasNativeArrayInParameter |= isArray && isPrimitive;
                                bool useRefOut = false;
                                if (!EnableRefOutParameters)
                                {
                                    isManaged &= !(parameter.IsOut || parameter.ParameterType.IsByRef); // out parameters not managed
                                }
                                else
                                {
                                    useRefOut = parameter.IsOut || parameter.ParameterType.IsByRef;
                                }
                                if (!isManaged) break; // found not managed type, stop here
                                // Record the erased parameter type as it will actually appear in the generated
                                // Java signature. JCORefOut<T> and JCORefOut<NetObject> erase to the same
                                // "JCORefOut" regardless of what's inside — record the wrapper itself for a
                                // by-ref/out parameter, not the inner paramType, or two overloads that only
                                // differ inside a JCORefOut<...> won't be seen as colliding.
                                erasedParamTypes.Add(useRefOut ? "JCORefOut" : (isArray ? paramType + "[]" : paramType));

                                isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                                string formatter = string.Empty;
                                string objectCaster = string.Empty;
                                var paramName = ReplaceSinglekeyword(parameter.Name);
                                if (useRefOut)
                                {
                                    string primitiveParam = Const.Parameters.JCORefOutType;
                                    if (isPrimitive && !isArray && Const.SpecialNames.DirectMappablePrimitives.ContainsKey(paramType))
                                    {
                                        primitiveParam = string.Format(Const.Parameters.JCORefOutTypeGenericFormatter, Const.SpecialNames.DirectMappablePrimitives[paramType]);
                                    }

                                    string typeString = isPrimitive ? primitiveParam : string.Format(Const.Parameters.JCORefOutTypeGenericFormatter, (isArray) ? paramType + Const.SpecialNames.ArrayTrailer : paramType);
                                    inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, typeString, paramName));
                                    formatter = Const.Parameters.INVOKE_PARAMETER_JCOREFOUT;
                                    builtWithJCORefOut = true;
                                }
                                else
                                {
                                    inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));
                                    formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                                    if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;
                                    if (isArray && parameters.Length == 1)
                                    {
                                        objectCaster = Const.SpecialNames.OBJECT_CASTER_NAME;
                                    }
                                }

                                execParams.Append(string.Format(formatter, objectCaster, paramName));
                            }
                            if (!isManaged) continue; // found not managed type, jump to next 
                            string inputParamStr = inputParams.ToString();
                            if (!string.IsNullOrEmpty(inputParamStr))
                            {
                                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                            }

                            // --- TOTAL SANITIZATION FOR INHERITED DEPRECATED METHOD INVOKE PARAMETERS ---
                            string execParamStr = execParams.ToString().Trim();

                            // Drop any loose leading comma if present at the start of the token
                            if (execParamStr.StartsWith(","))
                            {
                                execParamStr = execParamStr.Substring(1).Trim();
                            }

                            // Ensure it starts with a clean comma space separator for duplicate method Invoke text layout
                            if (!string.IsNullOrEmpty(execParamStr) && !execParamStr.StartsWith(","))
                            {
                                execParamStr = ", " + execParamStr;
                            }

                            var exceptionStr = interfaceMethod.ExceptionStringBuilder(imports);

                            bool isNewMethodVal = (withInheritance) ? type.IsNewMethod(interfaceMethod, allMethods) : false;
                            string newMethodName = string.Empty;
                            if (isNewMethodVal)
                            {
                                newMethodName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, methodName, type.GetJavaClassName(type.Assembly));
                            }

                            // This deprecated stub represents a .NET explicit interface implementation, which is never
                            // publicly visible on the concrete type in .NET. Promoting it to a public Java method can
                            // still erase-clash with a real, non-explicit public method the type genuinely has (e.g.
                            // Collection<T>'s explicit IList.Add(object):int vs SyndicationElementExtensionCollection's
                            // own public Add(object):void). Since the stub only throws UnsupportedOperationException
                            // anyway, rename it on collision instead of losing either method.
                            string stubErasedSignature = methodName + "(" + string.Join(",", erasedParamTypes) + ")";
                            if (javaErasedSignaturesCreated.Contains(stubErasedSignature))
                            {
                                newMethodName = methodName + "From" + implementableInterface.GetJavaClassName(implementableInterface.Assembly);
                                isNewMethodVal = true;
                            }

                            // NetObject exposes Equals(IJCOBridgeReflected) and Equals(IJCOBridgeReflected,IJCOBridgeReflected).
                            // A generated Equals(T)/Equals(T,T) on a generic type (IEquatable<T>, IEqualityComparer<T>...)
                            // erases to the exact same signature, and Java rejects the pair ("have the same erasure, yet
                            // neither overrides the other"). Rename the generic one instead of losing it: reuses the same
                            // "use newMethodName for the Java-visible name, keep methodName for the real .NET Invoke/Get
                            // call" switch already used for the "new" keyword case above.
                            bool clashesWithNetObjectEquals = EnableGenerics && methodName == "Equals"
                                && (parameters.Length == 1 || parameters.Length == 2)
                                && parameters.All(p => p.ParameterType.IsGenericParameter);
                            if (clashesWithNetObjectEquals)
                            {
                                newMethodName = methodName + "Generic";
                                isNewMethodVal = true;
                            }

                            methodStr = templateToUse.Replace(Const.Methods.METHOD_INTERFACE_NAME, implementableInterface.GetJavaClassName(implementableInterface.Assembly))
                                                     .Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                     .Replace(Const.Methods.METHOD_NAME, methodName)
                                                     .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                     .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                     .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                     .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                     .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, interfaceMethod.IsStatic ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                                     .Replace(Const.Methods.METHOD_OBJECT, interfaceMethod.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                                     .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);

                            if (EnableDuplicateMethodNativeArrayWithJCRefOut && hasNativeArrayInParameter && !builtWithJCORefOut) // && !exportingMethodsDuplicateAvoidance(type, methodName))
                            {
                                // needs a duplication in method signature
                                inputParams = new StringBuilder();
                                execParams = new StringBuilder();

                                foreach (var parameter in parameters)
                                {
                                    string paramType = ConvertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                                    bool isNativeArrayInParameter = isArray && isPrimitive;
                                    isPrimitive |= typeof(Delegate).IsAssignableFrom(parameter.ParameterType);
                                    var paramName = string.Format(Const.Methods.DUPLICATED_PARAMETER_PROTO, parameter.Position); // change name to avoid confusion made by parameter name when a duplicated method is searched

                                    string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                                    if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                                    if (isNativeArrayInParameter)
                                    {
                                        inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, Const.Parameters.JCORefOutType, paramName));
                                        formatter = Const.Parameters.INVOKE_PARAMETER_JCOREFOUT;
                                    }
                                    else
                                    {
                                        inputParams.Append(string.Format(Const.Parameters.INPUT_PARAMETER, (isArray) ? paramType + (IsParams(parameter) ? Const.SpecialNames.VarArgsTrailer : Const.SpecialNames.ArrayTrailer) : paramType, paramName));
                                    }

                                    string objectCaster = string.Empty;
                                    if (isArray && parameters.Length == 1)
                                    {
                                        objectCaster = Const.SpecialNames.OBJECT_CASTER_NAME;
                                    }

                                    execParams.Append(string.Format(formatter, objectCaster, paramName));
                                }
                                inputParamStr = inputParams.ToString();
                                if (!string.IsNullOrEmpty(inputParamStr))
                                {
                                    inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
                                }

                                execParamStr = execParams.ToString();

                                // NetObject exposes Equals(IJCOBridgeReflected) and Equals(IJCOBridgeReflected,IJCOBridgeReflected).
                                // A generated Equals(T)/Equals(T,T) on a generic type (IEquatable<T>, IEqualityComparer<T>...)
                                // erases to the exact same signature, and Java rejects the pair ("have the same erasure, yet
                                // neither overrides the other"). Rename the generic one instead of losing it: reuses the same
                                // "use newMethodName for the Java-visible name, keep methodName for the real .NET Invoke/Get
                                // call" switch already used for the "new" keyword case above.
                                clashesWithNetObjectEquals = EnableGenerics && methodName == "Equals"
                                    && (parameters.Length == 1 || parameters.Length == 2)
                                    && parameters.All(p => p.ParameterType.IsGenericParameter);
                                if (clashesWithNetObjectEquals)
                                {
                                    newMethodName = methodName + "Generic";
                                    isNewMethodVal = true;
                                }

                                dupMethodStr = templateToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                            .Replace(Const.Methods.METHOD_NAME, methodName)
                                                            .Replace(Const.Methods.METHOD_JAVA_NAME, methodName)
                                                            .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                            .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                            .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                            .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                            .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, interfaceMethod.IsStatic ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                                            .Replace(Const.Methods.METHOD_OBJECT, interfaceMethod.IsStatic ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME)
                                                            .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr);

                                dupMethodSignature = templateInterfaceToUse.Replace(Const.Methods.METHOD_JAVA_NAME, isNewMethodVal ? newMethodName : methodName)
                                                                           .Replace(Const.Methods.METHOD_NAME, methodName)
                                                                           .Replace(Const.Methods.METHOD_JAVA_NAME, methodName)
                                                                           .Replace(Const.Methods.METHOD_RETURN_TYPE, string.Empty)
                                                                           .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                                           .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, execParamStr)
                                                                           .Replace(Const.Exceptions.THROWABLE_TEMPLATE, string.Empty);

                                Interlocked.Increment(ref implementedDuplicatedMethods);
                            }
                        }

                        methodsSignatureCreated.Add(interfaceMethod.ToString());
                        methodsNameCreated.Add(interfaceMethod.Name);

                        Interlocked.Increment(ref extraImplementedMethods);

                        methodBuilder.AppendLine(CompleteMemberJavadoc(methodStr, implementableInterface));
                        if (EnableDuplicateMethodNativeArrayWithJCRefOut && !string.IsNullOrEmpty(dupMethodStr) && !methodsDuplicatedCreated.Contains(dupMethodSignature))
                        {
                            methodBuilder.AppendLine(CompleteMemberJavadoc(dupMethodStr, implementableInterface));
                            methodsDuplicatedCreated.Add(dupMethodSignature);
                        }
                    }

                    if (extraImplementedMethods != methods.Length) implementableInterfaces.Remove(implementableInterface);
                }
            }

            returnInterfaceSection = methodInterfaceBuilder.ToString();
            return methodBuilder.ToString();
        }
    }
}
