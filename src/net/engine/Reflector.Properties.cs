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
        static string BuildPropertySignature(string templateToUse, string propertyJavaName, string propertyName, string propertyType, string exceptionStr, bool isPrimitive, bool isArray, bool needInterfaceImplementation, bool statics, string propertyInterfaceName)
        {
            StringBuilder inputParams = new StringBuilder();
            StringBuilder execParams = new StringBuilder();

            propertyJavaName = ReplaceSinglekeyword(propertyJavaName);

            string inputParamStr = inputParams.ToString();
            if (!string.IsNullOrEmpty(inputParamStr))
            {
                inputParamStr = inputParamStr.Substring(0, inputParamStr.Length - 2);
            }

            string formatter = isPrimitive ? Const.Parameters.INVOKE_PARAMETER_PRIMITIVE : Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE;
            if (!isPrimitive && isArray) formatter = Const.Parameters.INVOKE_PARAMETER_NONPRIMITIVE_ARRAY;

            string execParamStr = execParams.ToString();
            var propertyStr = templateToUse.Replace(Const.Properties.PROPERTY_INTERFACE_NAME, propertyInterfaceName)
                                           .Replace(Const.Properties.PROPERTY_JAVA_NAME, propertyJavaName)
                                           .Replace(Const.Properties.PROPERTY_NAME, propertyName)
                                           .Replace(Const.Exceptions.THROWABLE_TEMPLATE, exceptionStr)
                                           .Replace(Const.Properties.PROPERTY_INPUTTYPE, (isArray) ? propertyType + Const.SpecialNames.ArrayTrailer : propertyType)
                                           .Replace(Const.Properties.PROPERTY_INPUTNAME, propertyName)
                                           .Replace(Const.Properties.PROPERTY_OUTPUTTYPE, propertyType)
                                           .Replace(Const.Properties.PROPERTY_IMPLEMENTATION_OUTPUTTYPE, needInterfaceImplementation ? propertyType + Const.SpecialNames.ImplementationTrailer : propertyType)
                                           .Replace(Const.Properties.PROPERTY_PARAMETERS, string.Empty)
                                           .Replace(Const.Properties.PROPERTY_INVOKE_PARAMETERS, string.Empty)
                                           .Replace(Const.Properties.PROPERTY_VALUE, string.Format(formatter, string.Empty, propertyName))
                                           .Replace(Const.Properties.METHOD_MODIFIER_KEYWORD, statics ? Const.SpecialNames.STATIC_KEYWORD : string.Empty)
                                           .Replace(Const.Properties.PROPERTY_OBJECT, statics ? Const.Class.STATIC_CLASS_NAME : Const.Class.INSTANCE_CLASS_NAME);

            return propertyStr;
        }

        static bool IsNewProperty(this Type type, PropertyInfo property, IList<Tuple<bool, PropertyInfo>> allProperties, bool isGet)
        {
            MethodInfo method = isGet ? property.GetMethod : property.SetMethod;
            string refSign = method.SignatureWithoutRetVal();
            if (method.GetBaseDefinition().DeclaringType == type)
            {
                foreach (var item in allProperties)
                {
                    if (item.Item2.Name == property.Name
                        && item.Item2.DeclaringType != type
                        && SignatureWithoutRetVal(isGet ? item.Item2.GetMethod : item.Item2.SetMethod) == refSign)
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        static void SearchProperties(this Type type, IList<Tuple<bool, PropertyInfo>> allProperties, bool staticSearch, bool traverseHierarchy)
        {
            BindingFlags flags = BindingFlags.Public;
            flags |= staticSearch ? BindingFlags.Static : BindingFlags.Instance;

            foreach (var item in type.GetProperties(flags))
            {
                allProperties.Add(new Tuple<bool, PropertyInfo>(staticSearch, item));
            }

            if (traverseHierarchy)
            {
                foreach (var item in type.GetInterfaces())
                {
                    if (!item.IsManagedType(0, 1)) continue;
                    item.SearchProperties(allProperties, staticSearch, traverseHierarchy);
                }
            }
            else if (type.BaseType != null)
            {
                if (!type.BaseType.IsManagedType(0, 1) || type.BaseType == typeof(object) || type.BaseType == typeof(Exception) || type.BaseType == typeof(Type)) return;
                type.BaseType.SearchProperties(allProperties, staticSearch, traverseHierarchy);
            }
        }

        static bool AvoidExportProperties(this Type type, PropertyInfo property)
        {
            if (!EnableRefOutParameters) return false;

            // FIX: Fallback to Name if FullName is null (common for open generic types)
            var fullname = type.FullName ?? type.Name;
            return CheckExportingAvoidanceMap(fullname, property.Name);
        }

        static string ExportProperties(this Type type, IList<Type> imports, IList<Type> implementableInterfaces, bool withInheritance, bool isException, string destFolder, string assemblyname, out string returnInterfaceSection)
        {
            bool isInterface = false;
            returnInterfaceSection = string.Empty;
            List<Tuple<bool, PropertyInfo>> properties = new List<Tuple<bool, PropertyInfo>>();

            if (type.IsInterface)
            {
                isInterface = true;
            }

            type.SearchProperties(properties, false, isInterface);
            type.SearchProperties(properties, true, isInterface);

            List<string> propertiesSignaturesCreated = new List<string>();
            List<string> propertiesNameCreated = new List<string>();

            StringBuilder propertyInterfaceBuilder = new StringBuilder();
            StringBuilder propertyBuilder = new StringBuilder();

            if (properties.Count != 0)
            {
                SortedDictionary<string, Tuple<bool, PropertyInfo>> sortedData = new SortedDictionary<string, Tuple<bool, PropertyInfo>>();
                foreach (var item in properties)
                {
                    var strMethod = item.Item2.ToString();
                    if (!sortedData.ContainsKey(strMethod))
                    {
                        sortedData.Add(strMethod, item);
                    }
                }

                properties = new List<Tuple<bool, PropertyInfo>>();
                properties.AddRange(sortedData.Values);
                string templateToUse = string.Empty;

                bool isPrimitive = true;
                string defaultPrimitiveValue = string.Empty;
                bool isManaged = true;
                bool isSpecial = false;
                bool isArray = false;

                foreach (var prop in properties.ToArray())
                {
                    var statics = prop.Item1;
                    var item = prop.Item2;

                    if (withInheritance)
                    {
                        if (item.DeclaringType == type)
                        {
                            Interlocked.Increment(ref analyzedProperties);
                        }
                    }
                    else
                    {
                        Interlocked.Increment(ref analyzedProperties);
                    }

                    var propertyName = item.Name;

                    if (type.AvoidExportProperties(item)) continue;

                    isPrimitive = true;
                    defaultPrimitiveValue = string.Empty;
                    isManaged = true;
                    isSpecial = false;
                    isArray = false;

                    if (isException)
                    {
                        if (propertyName == "Message") continue;
                        if (propertyName == "StackTrace") continue;
                    }

                    if (propertiesSignaturesCreated.Contains(item.ToString())
                        || item.IsSpecialName
                        || ((withInheritance && !isInterface) ? item.DeclaringType != type : false)
                        || (!propertiesNameCreated.Contains(propertyName) ? false : propertiesSignaturesCreated.IsDifferentOnlyForRetVal(item.ToString(), propertyName))
                       ) continue;

                    // Same Java-language limit as for static methods: a static property cannot see the
                    // class's own generic type parameter (see ExportMethods for the full rationale).
                    bool referencesClassLevelGenericParameter = ContainsClassLevelGenericParameter(item.PropertyType);
                    if (item.GetMethod != null && item.GetMethod.IsStatic && referencesClassLevelGenericParameter) continue;
                    if (item.SetMethod != null && item.SetMethod.IsStatic && referencesClassLevelGenericParameter) continue;

                    string propertyType = "void";
                    var unwrappedPropertyType = item.PropertyType.IsByRef ? item.PropertyType.GetElementType() : item.PropertyType;
                    bool isPropertyGeneric = EnableGenerics && !isException && item.PropertyType.IsGenericParameter;
                    bool isByRefClassGenericProperty = EnableGenerics && !isException && item.PropertyType.IsByRef
                        && unwrappedPropertyType.IsGenericParameter && unwrappedPropertyType.DeclaringMethod == null;

                    if (isException && item.PropertyType.IsGenericParameter && item.PropertyType.DeclaringMethod == null)
                    {
                        propertyType = "IJCOBridgeReflected";
                        isPrimitive = false;
                        isManaged = true;
                        isSpecial = false;
                        isArray = false;
                    }
                    else if (isPropertyGeneric)
                    {
                        propertyType = item.PropertyType.Name;
                        isPrimitive = true; // Forces File 18/19 templates to trigger a clean explicit Java runtime cast (T)
                        isManaged = true;
                        isSpecial = false;
                        isArray = false;
                    }
                    else if (isByRefClassGenericProperty)
                    {
                        // "ref T" (ValueRef and similar .NET 8+ properties) where T belongs to the CLASS:
                        // "new T(...)" is illegal, but T is resolvable via instantiateGenericArgument
                        // (same mechanism already used for methods returning "ref T").
                        propertyType = unwrappedPropertyType.Name;
                        isPrimitive = false;
                        isManaged = true;
                        isSpecial = false;
                        isArray = false;
                    }
                    else
                    {
                        propertyType = ConvertType(imports, item.PropertyType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        if (!isManaged) continue; // found not managed type, jump to next 
                    }

                    bool isPropertyTypeInterface = isArray ? item.PropertyType.GetElementType().IsInterface : item.PropertyType.IsInterface;

                    if (item.CanRead) // get
                    {
                        if (item.GetMethod.GetParameters().Length != 0) continue;
                        isPrimitive |= typeof(Delegate).IsAssignableFrom(item.PropertyType);

                        var exceptionStr = item.GetMethod.ExceptionStringBuilder(imports);

                        bool isNewPropertyVal = (withInheritance && !isInterface) ? type.IsNewProperty(item, properties, true) : false;
                        string newPropertyName = string.Empty;
                        if (isNewPropertyVal)
                        {
                            newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, type.GetJavaClassName(type.Assembly));
                        }

                        if (withInheritance ? (isInterface && (item.GetMethod.GetBaseDefinition().DeclaringType == type)) : isInterface)
                        {
                            string propertyInterfaceTemplate = Const.Templates.GetTemplate(isArray ? Const.Templates.ReflectorInterfaceGetArrayTemplate : Const.Templates.ReflectorInterfaceGetTemplate);

                            var propertyInterfaceStr = BuildPropertySignature(propertyInterfaceTemplate, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);
                            propertyInterfaceBuilder.AppendLine(CompleteMemberJavadoc(propertyInterfaceStr, type));
                        }

                        if (withInheritance ? (isInterface || (item.GetMethod.GetBaseDefinition().DeclaringType == type)) : true)
                        {
                            if (isArray)
                            {
                                var arrayElementType = item.PropertyType.GetElementType();
                                if (EnableGenerics && arrayElementType.IsGenericParameter && arrayElementType.DeclaringMethod == null)
                                {
                                    int genericArgIndex = Array.IndexOf(type.GetGenericArguments(), arrayElementType);
                                    templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassObjectArrayGenericGetTemplate)
                                                                    .Replace("GENERIC_ARGUMENT_INDEX", genericArgIndex.ToString());
                                }
                                else
                                {
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayGetTemplate 
                                                                                            : Const.Templates.ReflectorClassObjectArrayGetTemplate);
                                }
                            }
                            else
                            {
                                if (isByRefClassGenericProperty)
                                {
                                    int genericArgIndex = Array.IndexOf(type.GetGenericArguments(), unwrappedPropertyType);
                                    templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassObjectGetGenericTemplate)
                                                                    .Replace("GENERIC_ARGUMENT_INDEX", genericArgIndex.ToString());
                                }
                                else
                                {
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? IsPrivitiveConvertibleFromNumber(propertyType) ? Const.Templates.ReflectorClassNativeGetWithCastToNumberTemplate
                                                                                                                                             : Const.Templates.ReflectorClassNativeGetTemplate
                                                                                            : Const.Templates.ReflectorClassObjectGetTemplate);
                                }
                            }

                            var propertyStr = BuildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);

                            // Same reasoning as ExportConstructors: IJCOBridgeReflected has no "...Implementation" class
                            // of its own (it's the root interface, not one of our reflected interfaces) — needInterfaceImplementation
                            // would have to append a suffix that names a class which doesn't exist. Wrap the native value
                            // in NetObject instead (it always implements IJCOBridgeReflected), keeping the declared
                            // return type as IJCOBridgeReflected in the method signature.
                            bool isExceptionGenericProperty = isException && item.PropertyType.IsGenericParameter && item.PropertyType.DeclaringMethod == null;
                            if (isExceptionGenericProperty)
                            {
                                propertyStr = propertyStr.Replace("new IJCOBridgeReflected(", "new NetObject(");
                            }

                            propertyBuilder.AppendLine(CompleteMemberJavadoc(propertyStr, type));
                        }
                    }
                    if (item.CanWrite) // set
                    {
                        var exceptionStr = item.SetMethod.ExceptionStringBuilder(imports);

                        bool isNewPropertyVal = (withInheritance && !isInterface) ? type.IsNewProperty(item, properties, false) : false;
                        string newPropertyName = string.Empty;
                        if (isNewPropertyVal)
                        {
                            newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, type.GetJavaClassName(type.Assembly));
                        }

                        if (withInheritance ? (isInterface && (item.SetMethod.GetBaseDefinition().DeclaringType == type)) : isInterface)
                        {
                            string propertyInterfaceTemplate = Const.Templates.GetTemplate(Const.Templates.ReflectorInterfaceSetTemplate);

                            var propertyInterfaceStr = BuildPropertySignature(propertyInterfaceTemplate, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);
                            propertyInterfaceBuilder.AppendLine(CompleteMemberJavadoc(propertyInterfaceStr, type));
                        }

                        if (withInheritance ? (isInterface || (item.SetMethod.GetBaseDefinition().DeclaringType == type)) : true)
                        {
                            templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassSetTemplate);
                            var propertyStr = BuildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, string.Empty);

                            // GENERICS UPDATED: Inject marshalling cast for generic property parameters inside the compiled output string
                            if (isPropertyGeneric)
                            {
                                // Overwrite the raw variable injection with the secure IJCOBridgeReflected marshalling token
                                string standardValueToken = $", {propertyName}";
                                string genericValueCaster = $", {propertyName} == null ? null : ((IJCOBridgeReflected){propertyName}).getJCOInstance()";

                                propertyStr = propertyStr.Replace(standardValueToken, genericValueCaster);
                            }

                            // Same reasoning as ExportConstructors: IJCOBridgeReflected has no "...Implementation" class
                            // of its own (it's the root interface, not one of our reflected interfaces) — needInterfaceImplementation
                            // would have to append a suffix that names a class which doesn't exist. Wrap the native value
                            // in NetObject instead (it always implements IJCOBridgeReflected), keeping the declared
                            // return type as IJCOBridgeReflected in the method signature.
                            bool isExceptionGenericProperty = isException && item.PropertyType.IsGenericParameter && item.PropertyType.DeclaringMethod == null;
                            if (isExceptionGenericProperty)
                            {
                                propertyStr = propertyStr.Replace("new IJCOBridgeReflected(", "new NetObject(");
                            }

                            propertyBuilder.AppendLine(CompleteMemberJavadoc(propertyStr, type));
                        }
                    }
                    propertiesSignaturesCreated.Add(item.ToString());
                    propertiesNameCreated.Add(item.Name);
                    if (withInheritance)
                    {
                        if (item.DeclaringType == type)
                        {
                            Interlocked.Increment(ref implementedProperties);
                        }
                    }
                    else
                    {
                        Interlocked.Increment(ref implementedProperties);
                    }
                }
            }
            else if (!EnableInterfaceInheritance) return string.Empty;
            // --- Note: Interface Inheritance Traversing cycle code continues here untouched according to original layout ---
            if (!isInterface && EnableInheritance && EnableInterfaceInheritance)
            {
                foreach (var implementableInterface in implementableInterfaces.ToArray())
                {
                    properties = new List<Tuple<bool, PropertyInfo>>();
                    implementableInterface.SearchProperties(properties, false, true);
                    implementableInterface.SearchProperties(properties, true, true);

                    if (properties.Count == 0) continue;

                    SortedDictionary<string, Tuple<bool, PropertyInfo>> sortedData = new SortedDictionary<string, Tuple<bool, PropertyInfo>>();
                    foreach (var item in properties)
                    {
                        var strMethod = item.Item2.ToString();
                        if (!sortedData.ContainsKey(strMethod))
                        {
                            sortedData.Add(strMethod, item);
                        }
                    }

                    string templateToUse = string.Empty;

                    bool isPrimitive = true;
                    string defaultPrimitiveValue = string.Empty;
                    bool isManaged = true;
                    bool isSpecial = false;
                    bool isArray = false;

                    properties = new List<Tuple<bool, PropertyInfo>>();
                    properties.AddRange(sortedData.Values);

                    int extraImplementedProperties = 0;

                    foreach (var interfaceProp in properties)
                    {
                        var statics = interfaceProp.Item1;
                        var item = interfaceProp.Item2;

                        var propertyName = item.Name;

                        isPrimitive = true;
                        defaultPrimitiveValue = string.Empty;
                        isManaged = true;
                        isSpecial = false;
                        isArray = false;

                        if (isException)
                        {
                            if (propertyName == "Message") continue;
                            if (propertyName == "StackTrace") continue;
                        }

                        if (propertiesSignaturesCreated.Contains(item.ToString())
                            || item.IsSpecialName
                            || ((withInheritance) ? item.DeclaringType != implementableInterface : false)
                            || (!propertiesNameCreated.Contains(propertyName) ? false : propertiesSignaturesCreated.IsDifferentOnlyForRetVal(item.ToString(), propertyName))
                           ) continue;

                        string propertyType = "void";

                        propertyType = ConvertType(imports, item.PropertyType, out isPrimitive, out defaultPrimitiveValue, out isManaged, out isSpecial, out isArray);
                        if (!isManaged) continue; // found not managed type, jump to next 

                        bool isPropertyTypeInterface = isArray ? item.PropertyType.GetElementType().IsInterface : item.PropertyType.IsInterface;

                        if (item.CanRead) // get
                        {
                            if (item.GetMethod.GetParameters().Length != 0) continue; // only get without parameters are managed
                            isPrimitive |= typeof(Delegate).IsAssignableFrom(item.PropertyType);

                            var exceptionStr = item.GetMethod.ExceptionStringBuilder(imports);

                            bool isNewPropertyVal = (withInheritance) ? implementableInterface.IsNewProperty(item, properties, true) : false;
                            string newPropertyName = string.Empty;
                            if (isNewPropertyVal)
                            {
                                newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, implementableInterface.GetJavaClassName(type.Assembly));
                            }

                            if (withInheritance ? (isInterface || (item.GetMethod.GetBaseDefinition().DeclaringType == implementableInterface)) : true)
                            {
                                if (isArray)
                                {
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeArrayGetDeprecatedTemplate : Const.Templates.ReflectorClassObjectArrayGetDeprecatedTemplate);
                                }
                                else
                                {
                                    templateToUse = Const.Templates.GetTemplate(isPrimitive ? Const.Templates.ReflectorClassNativeGetDeprecatedTemplate : Const.Templates.ReflectorClassObjectGetDeprecatedTemplate);
                                }

                                var propertyStr = BuildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, implementableInterface.Name);
                                propertyBuilder.AppendLine(CompleteMemberJavadoc(propertyStr, implementableInterface));
                            }
                        }
                        if (item.CanWrite) // set
                        {
                            var exceptionStr = item.SetMethod.ExceptionStringBuilder(imports);

                            bool isNewPropertyVal = withInheritance ? type.IsNewProperty(item, properties, false) : false;
                            string newPropertyName = string.Empty;
                            if (isNewPropertyVal)
                            {
                                newPropertyName = string.Format(Const.Methods.NEW_MODIFIER_PROTO, propertyName, type.GetJavaClassName(type.Assembly));
                            }

                            if (withInheritance ? (isInterface || (item.SetMethod.GetBaseDefinition().DeclaringType == type)) : true)
                            {
                                templateToUse = Const.Templates.GetTemplate(Const.Templates.ReflectorClassSetDeprecatedTemplate);
                                var propertyStr = BuildPropertySignature(templateToUse, isNewPropertyVal ? newPropertyName : propertyName, propertyName, propertyType, exceptionStr, isPrimitive, isArray, isPropertyTypeInterface, statics, implementableInterface.Name);
                                propertyBuilder.AppendLine(CompleteMemberJavadoc(propertyStr, implementableInterface));
                            }
                        }

                        Interlocked.Increment(ref extraImplementedProperties);

                        propertiesSignaturesCreated.Add(item.ToString());
                        propertiesNameCreated.Add(item.Name);
                    }

                    if (extraImplementedProperties != properties.Count) implementableInterfaces.Remove(implementableInterface);
                }
            }

            returnInterfaceSection = propertyInterfaceBuilder.ToString();
            return propertyBuilder.ToString();
        }
    }
}
