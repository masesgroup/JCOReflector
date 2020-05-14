/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

namespace MASES.C2JReflector
{
    public enum LogLevel
    {
        Error,
        Warning,
        Info,
        Verbose
    }

    public enum JDKVersion
    {
        NotSet = 0,
        Version8 = 8,
        Version9,
        Version10,
        Version11,
        Version12,
        Version13,
        Version14
    }

    class Const
    {
        public static string[] KeyWords = new string[]
        {
            "import",
            "final",
            "package",
            "implements",
            "extends",
            "break",
            "finally",
            "continue",
            "Class",
            "classType",
            "classInstance"
        };

        public class SpecialNames
        {
            public const string Internal = "internal";
            public const string VarArgsTrailer = "...";
            public const string ArrayTrailer = "[]";
            public const string MultiArrayTrailer = "[,";
            public const string NativeStringType = "java.lang.String";
            public const string NetObject = "NetObject";
            public const string NetType = "NetType";
            public const string NetException = "NetException";
            public const string NetArrayList = "NetArrayList";
            public const string StringEnumerator = "System.Collections.Specialized.StringEnumerator";
            public const string XamlReader = "System.Xaml.XamlReader";
            public const string WsdlImporter = "System.ServiceModel.Description.WsdlImporter";
        }

        public class FileNameAndDirectory
        {
            public const string CommonDirectory = "JCOReflector";
            public const string ManifestFile = "JCOReflector.manifest";
            public const string ReferencesFile = "references.filelist";
            public const string SourceFile = "sources.filelist";
            public const string SourceFilter = "*.java";
            public const string SourcePattern = "{0}-src.jar";
            public const string CompiledFile = "compiled.filelist";
            public const string CompiledFilter = "*.class";
            public const string CompiledPattern = "{0}.jar";
        }

        public class Framework
        {
            public const string All = "All";
            public const string NETCore = ".NET Core";
            public const string NETCoreFolder = "Core";
            public const string NETFramework = ".NET Framework";
            public const string NETFrameworkFolder = "Framework";
        }

        public class Templates
        {
            public const string ReflectorThrowableClassTemplate = "JCObjectReflectorThrowableClass.template";
            public const string ReflectorClassTemplate = "JCObjectReflectorClass.template";
            public const string ReflectorClassConstructorTemplate = "JCObjectReflectorClassConstructor.template";

            public const string ReflectorClassVoidMethodTemplate = "JCObjectReflectorClassVoidMethod.template";
            public const string ReflectorClassNativeMethodTemplate = "JCObjectReflectorClassNativeMethod.template";
            public const string ReflectorClassNativeArrayMethodTemplate = "JCObjectReflectorClassNativeMethodArray.template";
            public const string ReflectorClassObjectMethodTemplate = "JCObjectReflectorClassObjectMethod.template";
            public const string ReflectorClassObjectArrayMethodTemplate = "JCObjectReflectorClassObjectMethodArray.template";

            public const string ReflectorClassSetTemplate = "JCObjectReflectorClassSetProperty.template";
            public const string ReflectorClassNativeGetTemplate = "JCObjectReflectorClassNativeGetProperty.template";
            public const string ReflectorClassNativeArrayGetTemplate = "JCObjectReflectorClassNativeGetPropertyArray.template";
            public const string ReflectorClassObjectGetTemplate = "JCObjectReflectorClassObjectGetProperty.template";
            public const string ReflectorClassObjectArrayGetTemplate = "JCObjectReflectorClassObjectGetPropertyArray.template";

            public const string ReflectorEnumTemplate = "JCObjectReflectorEnum.template";
            public const string ReflectorEnumFlagsTemplate = "JCObjectReflectorEnumFlags.template";

            public const string ReflectorEnumeratorTemplate = "JCObjectReflectorEnumerator.template";
            public const string ReflectorEnumerableTemplate = "JCObjectReflectorClassEnumerable.template";
            public const string ReflectorEnumerableNativeNextTemplate = "JCObjectReflectorEnumeratorNativeNext.template";
            public const string ReflectorEnumerableObjectNextTemplate = "JCObjectReflectorEnumeratorObjectNext.template";

            public const string ReflectorEventsTemplate = "JCObjectReflectorClassEvent.template";

            public const string VoidDelegateClassTemplate = "JCObjectReflectorVoidDelegateClass.template";
            public const string VoidDelegateInterfaceTemplate = "JCObjectReflectorVoidDelegateInterface.template";
            public const string NativeDelegateClassTemplate = "JCObjectReflectorNativeDelegateClass.template";
            public const string ObjectDelegateClassTemplate = "JCObjectReflectorObjectDelegateClass.template";
            public const string NonVoidDelegateInterfaceTemplate = "JCObjectReflectorNonVoidDelegateInterface.template";

            public const string ManifestTemplate = "JCOManifest.template";
        }

        public class Imports
        {
            public const string IMPORT = "import {0}.{1};";
        }

        public class Class
        {
            public const string PACKAGE_NAME = "PACKAGE_NAME";

            public const string PACKAGE_IMPORT_SECTION = "PACKAGE_IMPORT_SECTION";

            public const string PACKAGE_CLASS_NAME = "PACKAGE_CLASS_NAME";
            public const string PACKAGE_CLASS_IMPLEMENTS_SECTION = "PACKAGE_CLASS_IMPLEMENTS_SECTION";
            public const string FULL_ASSEMBLY_CLASS_NAME = "FULL_ASSEMBLY_CLASS_NAME";
            public const string SHORT_ASSEMBLY_CLASS_NAME = "SHORT_ASSEMBLY_CLASS_NAME";
            public const string FULLYQUALIFIED_CLASS_NAME = "FULLYQUALIFIED_CLASS_NAME";

            public const string CONSTRUCTORS_SECTION = "CONSTRUCTORS_SECTION";
            public const string METHODS_SECTION = "METHODS_SECTION";
            public const string GETTER_SETTER_SECTION = "GETTER_SETTER_SECTION";
            public const string INSTANCE_EVENTS_SECTION = "INSTANCE_EVENTS_SECTION";

            public const string INSTANCE_CLASS_NAME = "classInstance";
            public const string STATIC_CLASS_NAME = "classType";

            public const string JCOREFLECTOR_VERSION = "JCOREFLECTOR_VERSION";

            public const string PACKAGE_CLASS_ABSTRACT_PROTO = "abstract ";
            public const string PACKAGE_CLASS_IMPLEMENTS_PROTO = "implements ";
            public const string PACKAGE_CLASS_IMPLEMENTS_ITERABLE = "Iterable<{0}>";
        }

        public class Parameters
        {
            public const string INPUT_PARAMETER = "{0} {1}, ";
            public const string INVOKE_PARAMETER_PRIMITIVE = ", {0}{1}";
            public const string INVOKE_PARAMETER_GENERIC = ", ({0} instanceof IJCOBridgeReflected) ? ((IJCOBridgeReflected){0}).getJCOInstance() : throw JCException(\"Cannot manage instance\")";
            public const string INVOKE_PARAMETER_NONPRIMITIVE = ", {0}{1}.getJCOInstance()";
            public const string INVOKE_PARAMETER_NONPRIMITIVE_ARRAY = ", {0}toObjectFromArray({1})";
            public const string STATIC_KEYWORD = "static ";
        }

        public class CTor
        {
            public const string CTOR_PARAMETERS = "CTOR_PARAMETERS";
            public const string CTOR_NEWOBJECT_PARAMETERS = "CTOR_NEWOBJECT_PARAMETERS";
        }

        public class Methods
        {
            public const string STATIC_KEYWORD = "STATIC_KEYWORD";
            public const string METHOD_NAME = "METHOD_NAME";
            public const string METHOD_OBJECT = "METHOD_OBJECT";
            public const string METHOD_RETURN_TYPE = "METHOD_RETURN_TYPE";
            public const string METHOD_RETURN_INNER_TYPE = "METHOD_RETURN_INNER_TYPE";
            public const string METHOD_PARAMETERS = "METHOD_PARAMETERS";
            public const string METHOD_INVOKE_PARAMETERS = "METHOD_INVOKE_PARAMETERS";
        }

        public class Properties
        {
            public const string STATIC_KEYWORD = "STATIC_KEYWORD";
            public const string PROPERTY_NAME = "PROPERTY_NAME";
            public const string PROPERTY_OBJECT = "PROPERTY_OBJECT";
            public const string PROPERTY_INPUTTYPE = "PROPERTY_INPUTTYPE";
            public const string PROPERTY_INPUTNAME = "PROPERTY_INPUTNAME";
            public const string PROPERTY_OUTPUTTYPE = "PROPERTY_OUTPUTTYPE";
            public const string PROPERTY_VALUE = "PROPERTY_VALUE";
            public const string PROPERTY_PARAMETERS = "PROPERTY_PARAMETERS";
            public const string PROPERTY_INVOKE_PARAMETERS = "PROPERTY_INVOKE_PARAMETERS";
        }

        public class Events
        {
            public const string STATIC_KEYWORD = "STATIC_KEYWORD";
            public const string EVENT_NAME = "EVENT_NAME";
            public const string EVENT_OBJECT = "EVENT_OBJECT";
            public const string EVENT_HANDLER_TYPE = "EVENT_HANDLER_TYPE";
        }

        public class Delegates
        {
            public const string PACKAGE_NAME = "PACKAGE_NAME";

            public const string PACKAGE_IMPORT_SECTION = "PACKAGE_IMPORT_SECTION";

            public const string PACKAGE_CLASS_NAME = "PACKAGE_CLASS_NAME";
            public const string FULL_ASSEMBLY_CLASS_NAME = "FULL_ASSEMBLY_CLASS_NAME";
            public const string SHORT_ASSEMBLY_CLASS_NAME = "SHORT_ASSEMBLY_CLASS_NAME";
            public const string FULLYQUALIFIED_CLASS_NAME = "FULLYQUALIFIED_CLASS_NAME";

            public const string DELEGATE_NAME = "DELEGATE_NAME";
            public const string DELEGATE_RETURN_TYPE = "DELEGATE_RETURN_TYPE";
            public const string DELEGATE_PARAMETERS = "DELEGATE_PARAMETERS";
            public const string DELEGATE_INVOKE_PARAMETERS = "DELEGATE_INVOKE_PARAMETERS";
            public const string DELEGATE_INVOKE_PARAMETERS_CONVERTER_BLOCK = "DELEGATE_INVOKE_PARAMETERS_CONVERTER_BLOCK";
            public const string DELEGATE_PRIMITIVE_DEFAULT_VALUE = "DELEGATE_PRIMITIVE_DEFAULT_VALUE";

            public const string INVOKE_PARAMETER = "{0}, ";
            public const string INPUT_INVOKE_PARAMETER = "{0} {1}, ";
            public const string CONVERTER_BLOCK_PARAMETER_PRIMITIVE = "            {0} {1} = ({0})argsFromJCOBridge[{2}];";

            public const string CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE = "            {0} {1} = new {0}(argsFromJCOBridge[{2}]);";

            public static string CONVERTER_BLOCK_PARAMETER_PRIMITIVE_ARRAY = "            ArrayList<Object> resultingArrayListCONVERTER_BLOCK_PARAM_INDEX = new ArrayList<Object>();" + Environment.NewLine +
                                                                             "            JCObject resultingObjects = (JCObject)argsFromJCOBridge[CONVERTER_BLOCK_PARAM_INDEX];" + Environment.NewLine +
                                                                             "            for (Object resultingObjectCONVERTER_BLOCK_PARAM_INDEX : resultingObjects) {" + Environment.NewLine +
                                                                             "                resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.add(resultingObjectCONVERTER_BLOCK_PARAM_INDEX);" + Environment.NewLine +
                                                                             "            }" + Environment.NewLine +
                                                                             "            CONVERTER_BLOCK_PARAM_TYPE[] CONVERTER_BLOCK_PARAM_NAME = new CONVERTER_BLOCK_PARAM_TYPE[resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.size()];" + Environment.NewLine +
                                                                             "			  for(int indexCONVERTER_BLOCK_PARAM_INDEX = 0; indexCONVERTER_BLOCK_PARAM_INDEX < resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.size(); indexCONVERTER_BLOCK_PARAM_INDEX++ ) {" + Environment.NewLine +
                                                                             "	              CONVERTER_BLOCK_PARAM_NAME[indexCONVERTER_BLOCK_PARAM_INDEX] = (CONVERTER_BLOCK_PARAM_TYPE)resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.get(indexCONVERTER_BLOCK_PARAM_INDEX);" + Environment.NewLine +
                                                                             "            }" + Environment.NewLine;

            public static string CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE_ARRAY = "            ArrayList<CONVERTER_BLOCK_PARAM_TYPE> resultingArrayListCONVERTER_BLOCK_PARAM_INDEX = new ArrayList<CONVERTER_BLOCK_PARAM_TYPE>();" + Environment.NewLine +
                                                                                "            JCObject resultingObjects = (JCObject)argsFromJCOBridge[CONVERTER_BLOCK_PARAM_INDEX];" + Environment.NewLine +
                                                                                "            for (Object resultingObjectCONVERTER_BLOCK_PARAM_INDEX : resultingObjects) {" + Environment.NewLine +
                                                                                "                resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.add(new CONVERTER_BLOCK_PARAM_TYPE(resultingObjectCONVERTER_BLOCK_PARAM_INDEX));" + Environment.NewLine +
                                                                                "            }" + Environment.NewLine +
                                                                                "            CONVERTER_BLOCK_PARAM_TYPE[] CONVERTER_BLOCK_PARAM_NAME = new CONVERTER_BLOCK_PARAM_TYPE[resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.size()];" + Environment.NewLine +
                                                                                "            CONVERTER_BLOCK_PARAM_NAME = resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.toArray(CONVERTER_BLOCK_PARAM_NAME);";

            public const string CONVERTER_BLOCK_PARAM_TYPE = "CONVERTER_BLOCK_PARAM_TYPE";
            public const string CONVERTER_BLOCK_PARAM_NAME = "CONVERTER_BLOCK_PARAM_NAME";
            public const string CONVERTER_BLOCK_PARAM_INDEX = "CONVERTER_BLOCK_PARAM_INDEX";

            public const string DELEGATE_RETURN_STATEMENT = "DELEGATE_RETURN_STATEMENT";
            public const string DELEGATE_RETURN_STATEMENTTYPE = "DELEGATE_RETURN_STATEMENTTYPE";
            public const string DELEGATE_RETURN_STATEMENT_OBJECT = "            return (retVal == null) ? null : retVal.getJCOInstance();";
            public static string DELEGATE_RETURN_STATEMENT_OBJECT_ARRAY = "            ArrayList<Object> retValJCArrayList = new ArrayList<Object>();" + Environment.NewLine +
                                                                          "            for (DELEGATE_RETURN_STATEMENTTYPE retValJCObject : retVal) {" + Environment.NewLine +
                                                                          "                retValJCArrayList.add(retValJCObject.getJCOInstance());" + Environment.NewLine +
                                                                          "            }" + Environment.NewLine +
                                                                          "            return (Object)retValJCArrayList.toArray();";
        }

        public class Enumerator
        {
            public const string PACKAGE_NAME = "PACKAGE_NAME";

            public const string PACKAGE_IMPORT_SECTION = "PACKAGE_IMPORT_SECTION";

            public const string PACKAGE_CLASS_NAME = "PACKAGE_CLASS_NAME";
            public const string PACKAGE_INNER_CLASS_NAME = "PACKAGE_INNER_CLASS_NAME";
            public const string FULL_ASSEMBLY_CLASS_NAME = "FULL_ASSEMBLY_CLASS_NAME";
            public const string SHORT_ASSEMBLY_CLASS_NAME = "SHORT_ASSEMBLY_CLASS_NAME";
            public const string FULLYQUALIFIED_CLASS_NAME = "FULLYQUALIFIED_CLASS_NAME";

            public const string PACKAGE_CLASS_NEXT_SECTION = "PACKAGE_CLASS_NEXT_SECTION";
        }

        public class Enum
        {
            public const string ENUM_FIELDS_SECTION = "ENUM_FIELDS_SECTION";
            public const string FLAGS_MANAGEMENT_SECTION = "FLAGS_MANAGEMENT_SECTION";
            public const string SINGLE_ELEMENT_PROTOTYPE = "    public static {0} {1} = getFrom(enumReflected, \"{1}\");";
        }

        public class Exceptions
        {
            public const string THROWABLE_TEMPLATE = "THROWABLE_TEMPLATE";
            public const string DEFAULT_EXCEPTION = "Throwable";
            public const string SINGLE_EXCEPTION_PROTO = ", {0}.{1}";
        }
    }
}
