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
        // ----------------------------------------------------------------------------------------------
        // Javadoc completion for the generated members.
        // Paste these members inside the Reflector class (the one that contains GetJavaClassName).
        // Needs: using System.Linq; using System.Text.RegularExpressions;
        //
        // The member templates carry placeholders inside their Javadoc comment. This function expands them
        // reading the Java signature that follows the comment, so no chain of Replace has to know about them:
        //   METHOD_JAVADOC_PARAMS, CTOR_JAVADOC_PARAMS  -> one @param line for each parameter of the signature
        //   METHOD_JAVADOC_RETURN                       -> @return line, or nothing when the method is void
        //   THROWABLE_JAVADOC                           -> one @throws line for each exception but Throwable
        //   DOCUMENTATION_MEMBER_NAME                   -> <documentation name of the type>.<member name>
        // A text without placeholders is returned as it is.
        // ----------------------------------------------------------------------------------------------

        static readonly Regex JavadocMemberRegex = new Regex(
            @"(?<block>/\*\*(?:(?!\*/).)*\*/)(?<annotations>(?:[ \t]*\r?\n[ \t]*@[^\r\n]*)*)[ \t]*\r?\n(?<signature>[ \t]*(?:public|protected)[^\r\n]*)",
            RegexOptions.Singleline | RegexOptions.CultureInvariant);

        static readonly Regex JavadocSignatureRegex = new Regex(
            @"^\s*(?:public|protected)\b(?<modifiers>[^(]*?)(?<name>\w+)\((?<parameters>[^)]*)\)\s*(?:throws\s+(?<throws>[^{;]+?))?\s*[{;]?\s*$",
            RegexOptions.Singleline | RegexOptions.CultureInvariant);

        // Name of a type in the URL of the .NET documentation: List`1 becomes List-1.
        // It uses the same conversion applied to FULLYQUALIFIED_DOCUMENTATION_CLASS_NAME, so the link of a member
        // and the link of its class follow the same rule.
        static string GetDocumentationName(Type type)
        {
            // the FullName of a constructed generic type, like ICollection<KeyValuePair<string, JsonNode>>, lists the
            // assembly qualified names of its arguments: the documentation page is the one of the generic definition
            if (type.IsGenericType && !type.IsGenericTypeDefinition) type = type.GetGenericTypeDefinition();
            return (type.FullName ?? type.Name).ConvertGenericForMicrosoftDocumentation();
        }

        // Splits a Java parameter list on the commas that are not inside generics: "NetObject a, JCORefOut<K, V> b".
        static IEnumerable<string> SplitJavaParameters(string parameters)
        {
            int depth = 0, start = 0;
            for (int i = 0; i < parameters.Length; i++)
            {
                char c = parameters[i];
                if (c == '<') depth++;
                else if (c == '>') depth--;
                else if (c == ',' && depth == 0)
                {
                    yield return parameters.Substring(start, i - start);
                    start = i + 1;
                }
            }
            yield return parameters.Substring(start);
        }

        // Replaces a placeholder that stands alone on a line of the comment with the given lines.
        // With no lines, the whole line is removed.
        static string ReplaceJavadocLine(string block, string placeholder, IList<string> lines, string eol)
        {
            string escaped = Regex.Escape(placeholder);
            if (lines.Count == 0)
            {
                return Regex.Replace(block, @"^[ \t]*\*[ \t]*" + escaped + @"[ \t]*\r?\n", string.Empty,
                                     RegexOptions.Multiline | RegexOptions.CultureInvariant);
            }
            return Regex.Replace(block, @"^(?<prefix>[ \t]*\*[ \t]*)" + escaped + @"(?=[ \t]*\r?$)",
                                 m =>
                                 {
                                     string prefix = m.Groups["prefix"].Value;
                                     return prefix + string.Join(eol + prefix, lines);
                                 },
                                 RegexOptions.Multiline | RegexOptions.CultureInvariant);
        }

        // memberText: the text of one generated member, comment included.
        // declaringType: the .NET type that declares the member (the class, or the interface for the explicit stubs).
        static string CompleteMemberJavadoc(string memberText, Type declaringType)
        {
            if (string.IsNullOrEmpty(memberText)
                || (memberText.IndexOf("JAVADOC", StringComparison.Ordinal) < 0
                    && memberText.IndexOf("DOCUMENTATION_MEMBER_NAME", StringComparison.Ordinal) < 0))
            {
                return memberText;
            }

            return JavadocMemberRegex.Replace(memberText, match =>
            {
                var signature = JavadocSignatureRegex.Match(match.Groups["signature"].Value);
                if (!signature.Success) return match.Value;

                string block = match.Groups["block"].Value;
                string eol = block.Contains("\r\n") ? "\r\n" : "\n";

                string name = signature.Groups["name"].Value;
                string modifiers = Regex.Replace(signature.Groups["modifiers"].Value.Trim(),
                                                 @"^(?:(?:static|final|synchronized|abstract)\s+)*", string.Empty);

                // type parameters of a generic method: "<T extends IJCOBridgeReflected, U extends IJCOBridgeReflected> ..."
                var typeParameterTags = new List<string>();
                var typeParameters = Regex.Match(modifiers, @"^<(?<list>[^>]*)>\s*");
                if (typeParameters.Success)
                {
                    typeParameterTags = typeParameters.Groups["list"].Value.Split(',')
                        .Select(t => t.Trim().Split(' ')[0])
                        .Where(t => t.Length > 0)
                        .Select(t => "@param <" + t + "> the type of the generic argument " + t)
                        .ToList();
                    modifiers = modifiers.Substring(typeParameters.Length);
                }
                bool isConstructor = modifiers.Length == 0;
                bool isVoid = modifiers == "void";

                var paramTags = typeParameterTags.Concat(SplitJavaParameters(signature.Groups["parameters"].Value)
                    .Select(p => p.Trim())
                    .Where(p => p.LastIndexOf(' ') > 0)
                    .Select(p =>
                    {
                        int space = p.LastIndexOf(' ');
                        return "@param " + p.Substring(space + 1) + " the argument of type {@code " + p.Substring(0, space).Trim() + "}";
                    }))
                    .ToList();

                var returnTags = new List<string>();
                if (!isConstructor && !isVoid) returnTags.Add("@return the value returned by the .NET member");

                var throwTags = new List<string>();
                if (signature.Groups["throws"].Success)
                {
                    throwTags = signature.Groups["throws"].Value.Split(',')
                        .Select(e => e.Trim())
                        .Where(e => e.Length > 0 && e != "Throwable" && e != "java.lang.Throwable")
                        .Select(e => "@throws " + e + " if the .NET member raises it")
                        .ToList();
                }

                // getX and setX are the Java accessors of the property X, the methods start with an upper case letter
                string member = name;
                if (isConstructor) member = "-ctor";
                else if (name.Length > 3 && char.IsLower(name[0]) && char.IsUpper(name[3])
                         && (name.StartsWith("get", StringComparison.Ordinal) || name.StartsWith("set", StringComparison.Ordinal)))
                    member = name.Substring(3);

                block = ReplaceJavadocLine(block, Const.Methods.METHOD_JAVADOC_PARAMS, paramTags, eol);
                block = ReplaceJavadocLine(block, Const.CTor.CTOR_JAVADOC_PARAMS, paramTags, eol);
                block = ReplaceJavadocLine(block, Const.Methods.METHOD_JAVADOC_RETURN, returnTags, eol);
                block = ReplaceJavadocLine(block, Const.Exceptions.THROWABLE_JAVADOC, throwTags, eol);
                string documentationName = declaringType == null ? null : GetDocumentationName(declaringType) + "." + member;
                // a name with characters that are not valid in the URL would make the Javadoc fail: no link is better than a broken one
                if (documentationName == null || documentationName.IndexOfAny(new[] { '[', ']', ',', ' ' }) >= 0)
                {
                    block = Regex.Replace(block, @"^[^\r\n]*DOCUMENTATION_MEMBER_NAME[^\r\n]*\r?\n", string.Empty, RegexOptions.Multiline);
                }
                else
                {
                    block = block.Replace("DOCUMENTATION_MEMBER_NAME", documentationName);
                }

                return block + match.Value.Substring(match.Groups["block"].Length);
            });
        }

        static string ConvertGenericForMicrosoftDocumentation(this string input)
        {
            return input.Replace('`', '-');
        }
    }
}
