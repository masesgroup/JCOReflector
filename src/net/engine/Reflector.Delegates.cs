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
        static bool ExportingDelegate(this Type item, string destFolder, string assemblyname, out string returnEnumeratorType, bool avoidWrite = false)
        {
            returnEnumeratorType = string.Empty;

            if (!avoidWrite) Interlocked.Increment(ref analyzedDelegates);

            if (item.IsGenericParameter) return false;
            if (item.IsGenericType && !(EnableGenerics && item.IsGenericTypeDefinition)) return false;

            IList<Type> imports = new List<Type>();
            var invokeMethod = item.GetMethod("Invoke");

            if (invokeMethod == null) return false;

            var packageName = item.ToPackageName();
            string javaClassName = item.GetJavaClassName(item.Assembly);

            var parameters = invokeMethod.GetParameters();
            string returnType = "void";
            string dynamicInvokeTemplateToUse = string.Empty;
            string interfaceTemplateToUse = string.Empty;
            string classTemplateToUse = string.Empty;
            bool isPrimitive = true;
            bool isRetValPrimitive = false;
            bool isInterfaceRetVal = false;
            string defaultPrimitiveReturnValue = string.Empty;
            bool isSpecial = false;
            bool isRetValArray = false;
            bool isArray = false;
            bool isManaged = true;

            // --- ALIGNED GENERIC TEMPLATE BRANCHING CHANNELS INSIDE ExportingDelegate ---
            if (EnableGenerics && invokeMethod.ReturnType.IsGenericParameter)
            {
                returnType = invokeMethod.ReturnType.Name;
                isRetValPrimitive = true; // Forced as primitive to guarantee clean runtime cast statements bypassing wrappers
                isManaged = true;
                isSpecial = false;
                isRetValArray = false;
                isInterfaceRetVal = false;

                classTemplateToUse = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(Const.Templates.ObjectGenericDelegateClassTemplate)
                    : Const.Templates.GetTemplate(Const.Templates.ObjectDelegateClassTemplate);

                interfaceTemplateToUse = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(Const.Templates.NonVoidGenericDelegateInterfaceTemplate)
                    : Const.Templates.GetTemplate(Const.Templates.NonVoidDelegateInterfaceTemplate);

                dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassNativeMethodTemplate);
            }
            else if (invokeMethod.ReturnType == typeof(void))
            {
                classTemplateToUse = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(Const.Templates.VoidGenericDelegateClassTemplate)
                    : Const.Templates.GetTemplate(Const.Templates.VoidDelegateClassTemplate);

                interfaceTemplateToUse = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(Const.Templates.VoidGenericDelegateInterfaceTemplate)
                    : Const.Templates.GetTemplate(Const.Templates.VoidDelegateInterfaceTemplate);

                dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassVoidMethodTemplate);
            }
            else
            {
                returnType = ConvertType(imports, invokeMethod.ReturnType, out isRetValPrimitive, out defaultPrimitiveReturnValue, out isManaged, out isSpecial, out isRetValArray);
                if (!isManaged) return false;

                // FIXED LOGIC: Branch dynamically to NativeGenericDelegateClassTemplate when return type is a standard primitive (e.g. Comparison returning int)
                classTemplateToUse = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(isRetValPrimitive ? Const.Templates.NativeGenericDelegateClassTemplate : Const.Templates.ObjectGenericDelegateClassTemplate)
                    : Const.Templates.GetTemplate(isRetValPrimitive ? Const.Templates.NativeDelegateClassTemplate : Const.Templates.ObjectDelegateClassTemplate);

                interfaceTemplateToUse = EnableGenerics && item.IsGenericTypeDefinition
                    ? Const.Templates.GetTemplate(Const.Templates.NonVoidGenericDelegateInterfaceTemplate)
                    : Const.Templates.GetTemplate(Const.Templates.NonVoidDelegateInterfaceTemplate);

                if (isRetValArray)
                {
                    isInterfaceRetVal = invokeMethod.ReturnType.GetElementType().IsInterface;
                    dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(isRetValPrimitive ? Const.Templates.ReflectorClassNativeArrayMethodTemplate
                                                                                               : Const.Templates.ReflectorClassObjectArrayMethodTemplate);
                }
                else
                {
                    isInterfaceRetVal = invokeMethod.ReturnType.IsInterface;
                    dynamicInvokeTemplateToUse = Const.Templates.GetTemplate(isRetValPrimitive ? IsPrivitiveConvertibleFromNumber(returnType) ? Const.Templates.ReflectorClassNativeMethodWithCastToNumberTemplate
                                                                                                                                              : Const.Templates.ReflectorClassNativeMethodTemplate
                                                                                               : Const.Templates.ReflectorClassObjectMethodTemplate);
                }
            }

            StringBuilder converterBlock = new StringBuilder();
            StringBuilder inputParams = new StringBuilder();
            StringBuilder execParams = new StringBuilder();
            StringBuilder dynamicInvokeExecParams = new StringBuilder();
            int paramCounter = 0;
            string defaultPrimitiveValue = string.Empty;
            // Replaces the two ad-hoc comma conventions above: every parameter contributes a bare
            // expression token (no leading/trailing comma), and the single Join below owns all
            // separators. This removes the mismatch that produced "Invoke(sender, , e)".
            List<string> execParamTokens = new List<string>();
            List<string> javadocParams = new List<string>();
            foreach (var parameter in parameters)
            {
                string paramType = string.Empty;
                bool isDelegateParamGeneric = EnableGenerics && parameter.ParameterType.IsGenericParameter;

                if (isDelegateParamGeneric)
                {
                    paramType = parameter.ParameterType.Name;
                    isPrimitive = true;
                    isSpecial = false;
                    isArray = false;
                    isManaged = true;
                }
                else
                {
                    paramType = ConvertType(imports, parameter.ParameterType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                }

                if (!EnableRefOutParameters)
                {
                    isManaged &= !(parameter.IsOut || parameter.ParameterType.IsByRef);
                }
                if (!isManaged) break;

                var paramName = ReplaceSinglekeyword(parameter.Name);
                javadocParams.Add(string.Format("@param {0} the .NET argument of type {{@code {1}}}", paramName, parameter.ParameterType));

                if (isArray)
                {
                    string formatter = string.Empty;
                    formatter = isPrimitive ? Const.Delegates.CONVERTER_BLOCK_PARAMETER_PRIMITIVE_ARRAY : Const.Delegates.CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE_ARRAY;

                    formatter = formatter.Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_TYPE, paramType)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_IMPLEMENTATION_PARAM_TYPE, parameter.ParameterType.IsInterface ? paramType + Const.SpecialNames.ImplementationTrailer : paramType)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_NAME, paramName)
                                         .Replace(Const.Delegates.CONVERTER_BLOCK_PARAM_INDEX, paramCounter.ToString());

                    converterBlock.AppendLine(formatter);
                }
                else
                {
                    if (isDelegateParamGeneric)
                    {
                        int genericArgIndex = Array.IndexOf(item.GetGenericArguments(), parameter.ParameterType);
                        string genericConverterLine = $"{paramType} {paramName} = (argsFromJCOBridge[{paramCounter}] == null) ? null : " +
                            $"NetGenericHelper.<{paramType}>instantiate(NetGenericHelper.resolveTypeArguments(getClass()), {genericArgIndex}, argsFromJCOBridge[{paramCounter}]);";
                        converterBlock.AppendLine("            " + genericConverterLine);
                    }
                    else
                    {
                        converterBlock.AppendLine(string.Format(isPrimitive ? Const.Delegates.CONVERTER_BLOCK_PARAMETER_PRIMITIVE : Const.Delegates.CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE, parameter.ParameterType.IsInterface ? paramType + Const.SpecialNames.ImplementationTrailer : paramType, paramName, paramCounter));
                    }
                }

                inputParams.Append(string.Format(Const.Delegates.INPUT_INVOKE_PARAMETER, (isArray) ? paramType + Const.SpecialNames.ArrayTrailer : paramType, paramName));

                // HIGH-PRECISION INJECTION: Accumulate parameter marshalling tokens using safe trailing formatting
                if (isDelegateParamGeneric)
                {
                    // converterBlock has already produced a correctly-typed Tn argN variable above;
                    // callerInstance.Invoke(...) is a plain Java call and expects that Tn value as-is.
                    execParamTokens.Add(paramName);
                }
                else
                {
                    // Const.Delegates.INVOKE_PARAMETER may embed its own leading or trailing comma;
                    // strip it here so every token is a bare expression, letting the Join below own
                    // all separators consistently.
                    string rawToken = string.Format(Const.Delegates.INVOKE_PARAMETER, paramName).Trim();
                    rawToken = rawToken.Trim(',', ' ');
                    execParamTokens.Add(rawToken);
                }

                string dynamicFormatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
                if (!isPrimitive && isArray) dynamicFormatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

                string objectCaster = string.Empty;
                if (isArray && parameters.Length == 1)
                {
                    objectCaster = Const.SpecialNames.OBJECT_CASTER_NAME;
                }

                dynamicInvokeExecParams.Append(string.Format(dynamicFormatter, objectCaster, paramName));
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

            string execParamStr = string.Join(", ", execParamTokens);
            var javadocEol = interfaceTemplateToUse.Contains("\r\n") ? "\r\n" : "\n";
            string javadocParamsStr = string.Join(javadocEol + "     * ", javadocParams);

            var exceptionStr = invokeMethod.ExceptionStringBuilder(imports);
            var importsStr = imports.ExportImports();
            // FIXED RETURN LOGIC: Build safe, compiler-checked return strings based on whether return type is a real primitive or not
            var strReturnStatement = isRetValPrimitive ? "return retVal;" : Const.Delegates.DELEGATE_RETURN_STATEMENT_OBJECT;
            if (isRetValArray)
            {
                strReturnStatement = Const.Delegates.DELEGATE_RETURN_STATEMENT_OBJECT_ARRAY.Replace(Const.Delegates.DELEGATE_RETURN_STATEMENTTYPE, returnType);
            }
            else if (invokeMethod.ReturnType.IsGenericParameter)
            {
                strReturnStatement = $"return (retVal == null) ? null : ({returnType})retVal;";
            }
            // SEPARATE COMPUTATION FOR GENERIC PARAMETERS AND ARGUMENTS (FIX BUG #2)
            string classParameters = string.Empty;
            string methodArguments = string.Empty;
            if (EnableGenerics && item.IsGenericTypeDefinition)
            {
                Type[] genericArguments = item.GetGenericArguments();
                classParameters = string.Join(", ", genericArguments.Select(t => $"{t.Name} extends IJCOBridgeReflected"));
                methodArguments = string.Join(", ", genericArguments.Select(t => t.Name));
            }
            // 1. Process and save the pure Java interface file
            var interfaceStr = interfaceTemplateToUse.Replace(Const.Delegates.PACKAGE_NAME, packageName)
                                                     .Replace(Const.Delegates.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                     .Replace(Const.Delegates.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation())
                                                     .Replace(Const.Delegates.PACKAGE_IMPORT_SECTION, importsStr)
                                                     .Replace(Const.Class.PACKAGE_CLASS_NAME, javaClassName) // Pure name replacement, handles the IPACKAGE_CLASS_NAME substring correctly
                                                     .Replace(Const.Class.GENERIC_CLASS_PARAMETERS, classParameters) // Resolves placeholder inside the <...> block
                                                     .Replace(Const.Delegates.DELEGATE_RETURN_TYPE, (isRetValArray) ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                     .Replace(Const.Delegates.DELEGATE_PARAMETERS, inputParamStr)
                                                     .Replace(Const.Delegates.DELEGATE_JAVADOC_PARAMS, javadocParamsStr)
                                                     .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);
            var pathToSaveTo = packageName.Replace('.', '\\');
        
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo)) Directory.CreateDirectory(pathToSaveTo);
            var fileName = Path.Combine(pathToSaveTo, string.Format("I{0}.java", javaClassName));
            writeFile(fileName, interfaceStr);
            // 2. Process and save the Java delegate implementation class file
            importsStr += string.Format(Const.Imports.IMPORT, packageName, string.Format("I{0}", javaClassName));
            string dynamicInvokeExecParamStr = dynamicInvokeExecParams.ToString();
            var dynamicInvokeStr = dynamicInvokeTemplateToUse.Replace(Const.Methods.METHOD_JAVA_NAME, Const.SpecialNames.METHOD_DYNAMICINVOKE_NAME)
                                                             .Replace(Const.Methods.METHOD_NAME, Const.SpecialNames.METHOD_DYNAMICINVOKE_NAME)
                                                             .Replace(Const.Methods.METHOD_RETURN_TYPE, returnType)
                                                             .Replace(Const.Methods.METHOD_IMPLEMENTATION_RETURN_TYPE, isInterfaceRetVal ? returnType + Const.SpecialNames.ImplementationTrailer : returnType)
                                                             .Replace(Const.Methods.METHOD_PARAMETERS, inputParamStr)
                                                             .Replace(Const.Methods.METHOD_INVOKE_PARAMETERS, dynamicInvokeExecParamStr)
                                                             .Replace(Const.Methods.METHOD_MODIFIER_KEYWORD, string.Empty)
                                                             .Replace(Const.Methods.METHOD_OBJECT, Const.Class.INSTANCE_CLASS_NAME)
                                                             .Replace(Const.Exceptions.THROWABLE_TEMPLATE, string.Empty);
            dynamicInvokeStr = CompleteMemberJavadoc(dynamicInvokeStr, typeof(Delegate));
            var delegateStr = classTemplateToUse.Replace(Const.Delegates.PACKAGE_NAME, packageName)
                                                .Replace(Const.Delegates.PACKAGE_IMPORT_SECTION, importsStr)
                                                .Replace(Const.Class.PACKAGE_CLASS_NAME, javaClassName) // Pure name replacement, does not corrupt interface substring
                                                .Replace(Const.Class.GENERIC_CLASS_PARAMETERS, classParameters) // Resolves the class declaration layout: class ... <...>
                                                .Replace(Const.Methods.GENERIC_METHOD_ARGUMENTS, methodArguments) // Resolves usages like IPACKAGE_CLASS_NAME<...> without duplicating constraints
                                                .Replace(Const.Delegates.FULL_ASSEMBLY_CLASS_NAME, assemblyname)
                                                .Replace(Const.Delegates.SHORT_ASSEMBLY_CLASS_NAME, item.Assembly.GetName().Name)
                                                .Replace(Const.Delegates.FULLYQUALIFIED_CLASS_NAME, item.FullName)
                                                .Replace(Const.Delegates.FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, item.FullName.ConvertGenericForMicrosoftDocumentation())
                                                .Replace(Const.Delegates.DELEGATE_INVOKE_PARAMETERS_CONVERTER_BLOCK, converterBlockStr)
                                                .Replace(Const.Delegates.DELEGATE_INVOKE_PARAMETERS, execParamStr)
                                                .Replace(Const.Delegates.DELEGATE_PARAMETERS, inputParamStr)
                                                .Replace(Const.Delegates.DELEGATE_JAVADOC_PARAMS, javadocParamsStr)
                                                .Replace(Const.Delegates.DELEGATE_RETURN_STATEMENT, strReturnStatement)
                                                .Replace(Const.Delegates.DELEGATE_RETURN_TYPE, (isRetValArray) ? returnType + Const.SpecialNames.ArrayTrailer : returnType)
                                                .Replace(Const.Delegates.DELEGATE_PRIMITIVE_DEFAULT_VALUE, defaultPrimitiveReturnValue)
                                                .Replace(Const.Delegates.DELEGATE_DYNAMIC_INVOKE_SECTION, dynamicInvokeStr)
                                                .Replace(Const.Class.JCOREFLECTOR_VERSION, reflectorVersion);
            pathToSaveTo = packageName.Replace('.', '\\');
            pathToSaveTo = System.IO.Path.Combine(destFolder, pathToSaveTo);
            if (!Directory.Exists(pathToSaveTo)) Directory.CreateDirectory(pathToSaveTo);
            fileName = Path.Combine(pathToSaveTo, string.Format("{0}.java", javaClassName));
            writeFile(fileName, delegateStr);
            Interlocked.Increment(ref implementedDelegates);
            return true;
        }
    }
}
