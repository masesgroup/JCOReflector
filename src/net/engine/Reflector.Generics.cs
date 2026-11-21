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
        // True when generating "methodName" with this parameter list on "type" would erase-clash
        // with a same-named method already present on an ancestor class in the same generated
        // hierarchy (e.g. KeyedCollection<TKey,TItem>.Remove(TKey) vs the inherited
        // Collection<TItem>.Remove(TItem) — different in .NET, identical after Java erasure).
        static bool ClashesWithBaseClassMethod(Type type, string methodName, int paramCount)
        {
            // Base-CLASS chain only. A class correctly implementing an interface method is expected
            // to share that method's erasure — scanning type.GetInterfaces() here produced a false
            // positive (Collection<T>.Remove(T) implementing ICollection<T>.Remove(T) looked like a
            // "clash" and got renamed too, then collided with the rename it wasn't meant to need).
            var baseType = type.BaseType;
            while (baseType != null && baseType != typeof(object))
            {
                if (HasGenericErasureClash(baseType, methodName, paramCount)) return true;
                baseType = baseType.BaseType;
            }
            return false;
        }

        // Separate check, interface-to-interface ancestors only (IDictionary<TKey,TValue>.Remove(TKey)
        // vs the inherited ICollection<KeyValuePair<TKey,TValue>>.Remove(T)) — use this one only when
        // generating an INTERFACE's own declaration in ExportInterface, never for a class implementing it.
        static bool ClashesWithBaseInterfaceMethod(Type type, string methodName, int paramCount)
        {
            foreach (var iface in type.GetInterfaces())
            {
                if (HasGenericErasureClash(iface, methodName, paramCount)) return true;
            }
            return false;
        }

        static bool HasGenericErasureClash(Type candidateType, string methodName, int paramCount)
        {
            var candidates = candidateType.GetMethods(BindingFlags.Public | BindingFlags.Instance | BindingFlags.DeclaredOnly)
                                           .Where(m => m.Name == methodName && m.GetParameters().Length == paramCount);
            return candidates.Any(c => c.GetParameters().All(p => p.ParameterType.IsGenericParameter));
        }

        // True when `t` can never satisfy our IJCOBridgeReflected bound: a primitive, or a .NET type
        // natively mapped onto a plain Java type (currently just System.String -> java.lang.String).
        // Any generic reference that needs one of these as a type argument can't be parameterized at
        // all — same raw-fallback compromise already accepted for cast() and for exception
        // class-level parameters (TDetail -> IJCOBridgeReflected).
        static bool ViolatesReflectedBound(Type t)
        {
            if (t.IsGenericParameter) return false; // already in scope, always correctly bounded
            if (t.IsPrimitive) return true;
            if (t == typeof(string)) return true;
            if (t.IsGenericType) return t.GetGenericArguments().Any(ViolatesReflectedBound);
            return false;
        }

        // True when `t` is a constructed generic type (KeyValuePair<TKey,TValue>, List<T>, ...) whose
        // arguments reference generic parameters in scope and that can be rendered as a parameterized
        // Java type in a member signature. Method-level parameters are excluded: they need the method's
        // own <T> declaration, which is handled by the dedicated method-generic paths.
        static bool IsResolvableConstructedGeneric(Type t)
        {
            if (!EnableGenerics) return false;
            if (t.IsByRef || t.IsArray || t.IsPointer) return false;
            if (!t.IsGenericType || t.IsGenericTypeDefinition || !t.ContainsGenericParameters) return false;
            // Nested types (e.g. ConditionalWeakTable<TKey,TValue>.CreateValueCallback) are not generated as
            // classes of their own, so there is nothing to parameterize: keep the previous behavior.
            if (t.IsNested) return false;
            // An array can never be a type argument: it does not satisfy the IJCOBridgeReflected bound
            // (Func<Task[],TResult>, Predicate<T[]>, ITargetBlock<T[]>...).
            if (ContainsArrayTypeArgument(t)) return false;
            if (ViolatesReflectedBound(t)) return false;
            return !ContainsMethodLevelGenericParameter(t);
        }

        // Same reasoning as DeclaresSameNameAndArityInBaseClass, for properties: a derived setter taking
        // ICollection_1<T> would not override a base setter taking the raw ICollection_1 (name clash).
        static bool DeclaresSamePropertyInBaseClass(Type type, string propertyName)
        {
            for (var b = type.BaseType; b != null && b != typeof(object); b = b.BaseType)
            {
                if (b.GetProperties(BindingFlags.Public | BindingFlags.Instance | BindingFlags.Static | BindingFlags.DeclaredOnly)
                     .Any(p => p.Name == propertyName)) return true;
            }
            return false;
        }

        static bool ContainsArrayTypeArgument(Type t)
        {
            if (t == null) return false;
            if (t.IsArray) return true;
            if (t.HasElementType) return ContainsArrayTypeArgument(t.GetElementType());
            if (t.IsGenericType) return t.GetGenericArguments().Any(ContainsArrayTypeArgument);
            return false;
        }

        // True when an ancestor class already declares a method with the same name and number of
        // parameters. A parameterized override such as Task<TResult>.ContinueWith(Action<Task<TResult>>)
        // would not override the raw Task.ContinueWith(Action) and Java rejects the pair as a name
        // clash (same erasure, neither overrides the other): in that case the parameter stays raw.
        static bool DeclaresSameNameAndArityInBaseClass(Type type, string methodName, int paramCount)
        {
            for (var b = type.BaseType; b != null && b != typeof(object); b = b.BaseType)
            {
                if (b.GetMethods(BindingFlags.Public | BindingFlags.Instance | BindingFlags.Static | BindingFlags.DeclaredOnly)
                     .Any(m => m.Name == methodName && m.GetParameters().Length == paramCount)) return true;
            }
            return false;
        }

        static bool ContainsMethodLevelGenericParameter(Type t)
        {
            if (t == null) return false;
            if (t.IsGenericParameter) return t.DeclaringMethod != null;
            if (t.HasElementType) return ContainsMethodLevelGenericParameter(t.GetElementType());
            if (t.IsGenericType) return t.GetGenericArguments().Any(ContainsMethodLevelGenericParameter);
            return false;
        }

        // Recursively builds the Java "<Arg1, Arg2>" text for a type used in an extends/implements
        // clause, or as a base type. Needed because leaving any supertype raw poisons the whole
        // inherited chain to raw types (the "Iterable cannot be inherited with different arguments"
        // family): IDictionary<TKey,TValue> : ICollection<KeyValuePair<TKey,TValue>> can't just take
        // the plain-generic-parameter shortcut (BuildGenericInterfaceSuffix) because its argument,
        // KeyValuePair<TKey,TValue>, is itself a constructed type, not a bare parameter.
        static string ResolveGenericTypeName(Type t, IList<Type> imports)
        {
            if (t.IsGenericParameter) return t.Name;

            // System.Type is a hand-written runtime class (NetType), never generated as its own file.
            if (t == typeof(Type)) return Const.SpecialNames.NetType;

            if (!t.IsGenericType)
            {
                if (t.IsArray) return ResolveGenericTypeName(t.GetElementType(), imports) + "[]";
                if (!imports.Contains(t)) imports.Add(t);
                return t.GetJavaClassName(t.Assembly);
            }

            if (!imports.Contains(t)) imports.Add(t);
            string containerName = t.GetJavaClassName(t.Assembly);
            var args = t.GetGenericArguments();
            string argsText = string.Join(", ", args.Select(a => ResolveGenericTypeName(a, imports)));
            return containerName + "<" + argsText + ">";
        }

        // Full "package.Name<Args>" text for a supertype/interface reference in an extends/implements
        // clause or as a base class.
        static string BuildQualifiedGenericTypeName(Type t, IList<Type> imports)
        {
            if (t.IsGenericParameter) return t.Name;

            // Any argument (recursively) that can't satisfy IJCOBridgeReflected (a primitive, or
            // System.String) forces the whole reference back to raw instead of parameterized.
            if (t.IsGenericType && ViolatesReflectedBound(t))
            {
                return t.ToPackageName() + "." + t.GetJavaClassName(t.Assembly);
            }

            string simple = ResolveGenericTypeName(t, imports);
            int genericMarker = simple.IndexOf('<');
            string containerPart = genericMarker >= 0 ? simple.Substring(0, genericMarker) : simple;
            string argsPart = genericMarker >= 0 ? simple.Substring(genericMarker) : string.Empty;
            return t.ToPackageName() + "." + containerPart + argsPart;
        }

        static string GetJavaClassName(this Type type, Assembly currentAssembly)
        {
            if (!EnableGenerics)
            {
                return type.Name.Contains('`') ? type.Name.Split('`')[0] : type.Name;
            }

            // If the type name contains the .NET backtick, it is a generic definition or constructed type
            if (type.Name.Contains('`'))
            {
                string[] parts = type.Name.Split('`');
                string cleanName = parts[0];
                string arity = parts[1];

                // Append the exact arity number using the underscore layout (e.g., ObjectSecurity_1, List_1)
                return $"{cleanName}_{arity}";
            }

            // Standard non-generic types keep their native pure name untouched (e.g., ObjectSecurity)
            return type.Name;
        }
    }
}
