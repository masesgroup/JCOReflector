/*
 *  MIT License
 *
 *  Copyright (c) 2023 MASES s.r.l.
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
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.IO;

namespace MASES.JCOReflectorEngine
{
    static class Const
    {
        public static string ToFolderName(this System.Reflection.AssemblyName assName)
        {
            var name = string.Concat(assName.FullName.Split(' '));

            name = name.Replace(',', '_')
                       .Replace('=', '_').ToLowerInvariant();

            return name;
        }

        public static readonly string ReflectorVersion = typeof(JavaBuilder).Assembly.GetName().Version.ToString();

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
            "classInstance",
            "native",
            "switch"
        };

        public class SpecialNames
        {
            public const string ImplementationTrailer = "Implementation";
            public const string Internal = "internal";
            public const string VarArgsTrailer = "...";
            public const string ArrayTrailer = "[]";
            public const string MultiArrayTrailer = "[,";
            public const string NativeStringType = "java.lang.String";
            public const string IJCOBridgeReflected = "IJCOBridgeReflected";
            public const string NetObject = "NetObject";
            public const string NetObjectEnumerable = "NetObjectEnumerable";
            public const string AutoCloseable = "AutoCloseable";
            public const string NetType = "NetType";
            public const string NetException = "NetException";
            public const string NetArrayList = "NetArrayList";
            public const string NetIDisposable = "IDisposable";
            public const string NetIEnumerable = "IEnumerable";
            public const string NetIEnumerator = "IEnumerator";
            public const string StringEnumerator = "System.Collections.Specialized.StringEnumerator";
            public const string XamlReader = "System.Xaml.XamlReader";
            public const string WsdlImporter = "System.ServiceModel.Description.WsdlImporter";
            public const string STATIC_KEYWORD = "static ";
            public const string FINAL_KEYWORD = "final ";
            public const string METHOD_DYNAMICINVOKE_NAME = "DynamicInvoke";
            public const string METHOD_GETENUMERATOR_NAME = "GetEnumerator";
#if NETFRAMEWORK
            public const string METHOD_STREAMREAD_NAME = "Read";
            public const string METHOD_STREAMREADBLOCK_NAME = "ReadBlock";
#endif

            public const string JCOReflectorGeneratedFolder = "JCOReflectorGenerated";

            public const string OBJECT_CASTER_NAME = "(java.lang.Object)";

            public static Dictionary<string, string[]> ExportingMethodsAvoidanceMap = new Dictionary<string, string[]>();
            public static Dictionary<string, string> DirectMappablePrimitives = new Dictionary<string, string>();

            static SpecialNames()
            {
                ExportingMethodsAvoidanceMap.Add("System.Net.Http.Headers.MediaTypeWithQualityHeaderValue", new string[] { "TryParse" });
                ExportingMethodsAvoidanceMap.Add("System.Net.Http.Headers.NameValueWithParametersHeaderValue", new string[] { "TryParse" });
                ExportingMethodsAvoidanceMap.Add("System.Net.Http.Headers.TransferCodingWithQualityHeaderValue", new string[] { "TryParse" });
                ExportingMethodsAvoidanceMap.Add("Microsoft.VisualBasic.FileSystem", new string[] { "FileGet", "Input" });
                ExportingMethodsAvoidanceMap.Add("System.Threading.Thread", new string[] { "VolatileRead" });
                ExportingMethodsAvoidanceMap.Add("System.Threading.Volatile", new string[] { "Read" });
                ExportingMethodsAvoidanceMap.Add("System.Threading.Interlocked", new string[] { "Decrement", "Increment"
#if NET6_0 || NET7_0
                                                                                                , "Read"
#endif
                });
#if NET7_0
                ExportingMethodsAvoidanceMap.Add("System.Runtime.Interopservices.JavaScript.JSMarshalerArgument", new string[] { "ToManaged" });
#endif
                DirectMappablePrimitives.Add("boolean", "java.util.concurrent.atomic.AtomicBoolean");
                DirectMappablePrimitives.Add("byte", "java.util.concurrent.atomic.AtomicReference<java.lang.Byte>");
                DirectMappablePrimitives.Add("short", "java.util.concurrent.atomic.AtomicReference<java.lang.Short>");
                DirectMappablePrimitives.Add("float", "java.util.concurrent.atomic.AtomicReference<java.lang.Float>");
                DirectMappablePrimitives.Add("double", "java.util.concurrent.atomic.AtomicReference<java.lang.Double>");
                DirectMappablePrimitives.Add("int", "java.util.concurrent.atomic.AtomicInteger");
                DirectMappablePrimitives.Add("long", "java.util.concurrent.atomic.AtomicLong");
            }
        }

        public class FileNameAndDirectory
        {
            public static string GetRelativePath(string filespec, string folder)
            {
                Uri pathUri = new Uri(filespec);
                if (!folder.EndsWith(Path.DirectorySeparatorChar.ToString()))
                {
                    folder += Path.DirectorySeparatorChar;
                }
                Uri folderUri = new Uri(folder);
                return Uri.UnescapeDataString(folderUri.MakeRelativeUri(pathUri).ToString().Replace('/', Path.DirectorySeparatorChar));
            }

            public const string BinDirectory = "bin";
            public const string RootDirectory = "netreflected";
            public const string SourceDirectory = "src";
            public const string StatsDirectory = "statistics";
            public const string DocsDirectory = "docs";

            public const string StatisticsFilename = "Statistics.csv";
            public const string POMFilename = "pom.xml";

            public const string CommonDirectory = "JCOReflector";
            public const string OrgSubDirectory = "org";
            public const string MasesSubDirectory = "mases";
            public const string JCOBridgeSubDirectory = "jcobridge";
            public const string NetreflectionSubDirectory = "netreflection";

            public const string ManifestFile = "JCOReflector.manifest";
            public const string ReferencesFile = "references.filelist";
            public const string SourceFile = "sources.filelist";
            public const string SourceFilter = "*.java";
            public const string SourcePattern = "{0}-src.jar";
            public const string CompiledFile = "compiled.filelist";
            public const string CompiledFilter = "*.class";
            public const string CompiledPattern = "{0}.jar";
            public const string JCOBridgeEmbeddedFile = "JCOBridge.zip";
            public const string JCOReflectorOptionsFile = "JCOReflectorOptions.java";


#if NET6_0
            public static string[] JCOBridgeFiles = new string[]
            {
                Path.Combine("linux-arm", "J2CBridgeHostActivator.so"),
                Path.Combine("linux-arm", "libnethost.so"),
                Path.Combine("linux-arm64", "J2CBridgeHostActivator.so"),
                Path.Combine("linux-arm64", "libnethost.so"),
                Path.Combine("linux-x64", "J2CBridgeHostActivator.so"),
                Path.Combine("linux-x64", "libnethost.so"),
                Path.Combine("win-arm", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-arm", "nethost.dll"),
                Path.Combine("win-arm64", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-arm64", "nethost.dll"),
                Path.Combine("win-x64", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-x64", "nethost.dll"),
                Path.Combine("win-x86", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-x86", "nethost.dll"),
                "C2JBridge.dll",
                "C2JBridgeDesktop.dll",
                "IpAddressIdGenerator.dll",
                "IpAddressIdGenerator.runtimeconfig.json",
                "J2CBridge_Arm.dll",
                "J2CBridge_Arm.so",
                "J2CBridge_Arm64.dll",
                "J2CBridge_Arm64.so",
                "J2CBridge_x64.dll",
                "J2CBridge_x64.so",
                "J2CBridge_x86.dll",
                "JCOBridge.docs.jar",
                "JCOBridge.jar",
                "LicenseManagerUI.dll",
                "LicenseManagerUI.runtimeconfig.json",
                "LicenseViewer.dll",
                "LicenseViewer.runtimeconfig.json",
                "MachineIdGenerator.dll",
                "MachineIdGenerator.runtimeconfig.json",
                "Microsoft.NET6.App.runtimeconfig.json",
                "Microsoft.WindowsDesktop6.App.runtimeconfig.json",
            };
#elif NET7_0
            public static string[] JCOBridgeFiles = new string[]
            {
                Path.Combine("linux-arm", "J2CBridgeHostActivator.so"),
                Path.Combine("linux-arm", "libnethost.so"),
                Path.Combine("linux-arm64", "J2CBridgeHostActivator.so"),
                Path.Combine("linux-arm64", "libnethost.so"),
                Path.Combine("linux-x64", "J2CBridgeHostActivator.so"),
                Path.Combine("linux-x64", "libnethost.so"),
                Path.Combine("win-arm", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-arm", "nethost.dll"),
                Path.Combine("win-arm64", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-arm64", "nethost.dll"),
                Path.Combine("win-x64", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-x64", "nethost.dll"),
                Path.Combine("win-x86", "J2CBridgeHostActivator.dll"),
                Path.Combine("win-x86", "nethost.dll"),
                "C2JBridge.dll",
                "C2JBridgeDesktop.dll",
                "IpAddressIdGenerator.dll",
                "IpAddressIdGenerator.runtimeconfig.json",
                "J2CBridge_Arm.dll",
                "J2CBridge_Arm.so",
                "J2CBridge_Arm64.dll",
                "J2CBridge_Arm64.so",
                "J2CBridge_x64.dll",
                "J2CBridge_x64.so",
                "J2CBridge_x86.dll",
                "JCOBridge.docs.jar",
                "JCOBridge.jar",
                "LicenseManagerUI.dll",
                "LicenseManagerUI.runtimeconfig.json",
                "LicenseViewer.dll",
                "LicenseViewer.runtimeconfig.json",
                "MachineIdGenerator.dll",
                "MachineIdGenerator.runtimeconfig.json",
                "Microsoft.NET6.App.runtimeconfig.json",
                "Microsoft.WindowsDesktop6.App.runtimeconfig.json",
            };
#elif NETFRAMEWORK
            public static string[] JCOBridgeFiles = new string[]
            {
                "C2JBridge.dll",
                "IpAddressIdGenerator.exe",
                "IpAddressIdGenerator.exe.config",
                "J2CBridge_x64.dll",
                "J2CBridge_x86.dll",
                "JCOBridge.docs.jar",
                "JCOBridge.jar",
                "LicenseManagerUI.exe",
                "LicenseManagerUI.exe.config",
                "LicenseViewer.exe",
                "LicenseViewer.exe.config",
                "MachineIdGenerator.exe",
                "MachineIdGenerator.exe.config",
            };
#else
#error Unable to identify .NET engine
#endif

            public static string CreateJCOBridgeZip(string rootFolder)
            {
                var frameworkPath = Path.Combine(rootFolder, BinDirectory, Framework.RuntimeFolder);
                var localArchive = Path.Combine(frameworkPath, JCOBridgeEmbeddedFile);
                if (File.Exists(localArchive)) File.Delete(localArchive);
                using (var archive = System.IO.Compression.ZipFile.Open(localArchive, System.IO.Compression.ZipArchiveMode.Create))
                {
                    foreach (var item in JCOBridgeFiles)
                    {
                        System.IO.Compression.ZipArchiveEntry entry = archive.CreateEntry(item, System.IO.Compression.CompressionLevel.Optimal);
                        using (StreamWriter writer = new StreamWriter(entry.Open()))
                        {
                            byte[] buffer = File.ReadAllBytes(Path.Combine(frameworkPath, item));
                            writer.BaseStream.Write(buffer, 0, buffer.Length);
                        }
                    }
                }
                return localArchive;
            }
        }

        public class Framework
        {
            public const string All = "All";

#if NET6_0
            public const string Runtime = ".NET 6";
            public const string RuntimeName = ".NETCoreApp";
            public const string RuntimeFolder = "net6.0";
#elif NET7_0
            public const string Runtime = ".NET 7";
            public const string RuntimeName = ".NETCoreApp";
            public const string RuntimeFolder = "net7.0";
#elif NETFRAMEWORK
            public const string Runtime = ".NET Framework";
            public const string RuntimeName = ".NETFramework";
            public const string RuntimeFolder = "net462";
#else
#error Unable to identify .NET engine
#endif
        }

        public class Templates
        {
            static string[] templateStrings = new string[]
            {
                ReflectorInterfaceTemplate,
                ReflectorInterfaceClassTemplate,
                ReflectorInterfaceEventTemplate,
                ReflectorInterfaceMethodTemplate,
                ReflectorInterfaceGetTemplate,
                ReflectorInterfaceGetArrayTemplate,
                ReflectorInterfaceSetTemplate,

                ReflectorThrowableClassTemplate,
                ReflectorClassTemplate,

                ReflectorClassConstructorTemplate,

                ReflectorClassVoidMethodTemplate,
                ReflectorClassNativeMethodTemplate,
                ReflectorClassNativeArrayMethodTemplate,
                ReflectorClassObjectMethodTemplate,
                ReflectorClassObjectArrayMethodTemplate,

                ReflectorClassVoidMethodDeprecatedTemplate,
                ReflectorClassNativeMethodDeprecatedTemplate,
                ReflectorClassNativeArrayMethodDeprecatedTemplate,
                ReflectorClassObjectMethodDeprecatedTemplate,
                ReflectorClassObjectArrayMethodDeprecatedTemplate,

                ReflectorClassSetTemplate,
                ReflectorClassNativeGetTemplate,
                ReflectorClassNativeArrayGetTemplate,
                ReflectorClassObjectGetTemplate,
                ReflectorClassObjectArrayGetTemplate,

                ReflectorClassSetDeprecatedTemplate,
                ReflectorClassNativeGetDeprecatedTemplate,
                ReflectorClassNativeArrayGetDeprecatedTemplate,
                ReflectorClassObjectGetDeprecatedTemplate,
                ReflectorClassObjectArrayGetDeprecatedTemplate,

                ReflectorEnumTemplate,
                ReflectorEnumFlagsTemplate,

                ReflectorEnumeratorTemplate,
                ReflectorEnumerableTemplate,
                ReflectorEnumerableDeprecatedTemplate,
                ReflectorEnumerableNativeNextTemplate,
                ReflectorEnumerableObjectNextTemplate,

                ReflectorClassEventTemplate,

                VoidDelegateClassTemplate,
                VoidDelegateInterfaceTemplate,
                NativeDelegateClassTemplate,
                ObjectDelegateClassTemplate,
                NonVoidDelegateInterfaceTemplate,

                ManifestTemplate,

                POMExtension,
                POMJCOReflector,

                JCOReflectorOptionsTemplate,
            };

            static Templates()
            {
                foreach (var item in templateStrings)
                {
                    string template = string.Empty;
                    using (var stream = typeof(Const).Assembly.GetManifestResourceStream(typeof(Const).Namespace + "." + item))
                    {
                        using (var sr = new StreamReader(stream))
                        {
                            template = sr.ReadToEnd();
                        }
                    }
                    templates.Add(item, template);
                }
            }

            static IDictionary<string, string> templates = new ConcurrentDictionary<string, string>();
            const string namespaceName = "";
            public static string GetTemplate(string templateName)
            {
                string template = string.Empty;
                if (!templates.TryGetValue(templateName, out template))
                {
                    throw new InvalidOperationException(string.Format("Missing template {0}", templateName));
                }
                return template;
            }

            public const string ReflectorInterfaceTemplate = "JCObjectReflectorInterface.template";
            public const string ReflectorInterfaceClassTemplate = "JCObjectReflectorInterfaceClass.template";
            public const string ReflectorInterfaceEventTemplate = "JCObjectReflectorInterfaceEvent.template";
            public const string ReflectorInterfaceMethodTemplate = "JCObjectReflectorInterfaceMethod.template";
            public const string ReflectorInterfaceGetTemplate = "JCObjectReflectorInterfaceGetProperty.template";
            public const string ReflectorInterfaceGetArrayTemplate = "JCObjectReflectorInterfaceGetPropertyArray.template";
            public const string ReflectorInterfaceSetTemplate = "JCObjectReflectorInterfaceSetProperty.template";

            public const string ReflectorThrowableClassTemplate = "JCObjectReflectorThrowableClass.template";
            public const string ReflectorClassTemplate = "JCObjectReflectorClass.template";

            public const string ReflectorClassConstructorTemplate = "JCObjectReflectorClassConstructor.template";

            public const string ReflectorClassVoidMethodTemplate = "JCObjectReflectorClassVoidMethod.template";
            public const string ReflectorClassNativeMethodTemplate = "JCObjectReflectorClassNativeMethod.template";
            public const string ReflectorClassNativeArrayMethodTemplate = "JCObjectReflectorClassNativeMethodArray.template";
            public const string ReflectorClassObjectMethodTemplate = "JCObjectReflectorClassObjectMethod.template";
            public const string ReflectorClassObjectArrayMethodTemplate = "JCObjectReflectorClassObjectMethodArray.template";

            public const string ReflectorClassVoidMethodDeprecatedTemplate = "JCObjectReflectorClassVoidMethodDeprecated.template";
            public const string ReflectorClassNativeMethodDeprecatedTemplate = "JCObjectReflectorClassNativeMethodDeprecated.template";
            public const string ReflectorClassNativeArrayMethodDeprecatedTemplate = "JCObjectReflectorClassNativeMethodArrayDeprecated.template";
            public const string ReflectorClassObjectMethodDeprecatedTemplate = "JCObjectReflectorClassObjectMethodDeprecated.template";
            public const string ReflectorClassObjectArrayMethodDeprecatedTemplate = "JCObjectReflectorClassObjectMethodArrayDeprecated.template";

            public const string ReflectorClassSetTemplate = "JCObjectReflectorClassSetProperty.template";
            public const string ReflectorClassNativeGetTemplate = "JCObjectReflectorClassNativeGetProperty.template";
            public const string ReflectorClassNativeArrayGetTemplate = "JCObjectReflectorClassNativeGetPropertyArray.template";
            public const string ReflectorClassObjectGetTemplate = "JCObjectReflectorClassObjectGetProperty.template";
            public const string ReflectorClassObjectArrayGetTemplate = "JCObjectReflectorClassObjectGetPropertyArray.template";

            public const string ReflectorClassSetDeprecatedTemplate = "JCObjectReflectorClassSetPropertyDeprecated.template";
            public const string ReflectorClassNativeGetDeprecatedTemplate = "JCObjectReflectorClassNativeGetPropertyDeprecated.template";
            public const string ReflectorClassNativeArrayGetDeprecatedTemplate = "JCObjectReflectorClassNativeGetPropertyArrayDeprecated.template";
            public const string ReflectorClassObjectGetDeprecatedTemplate = "JCObjectReflectorClassObjectGetPropertyDeprecated.template";
            public const string ReflectorClassObjectArrayGetDeprecatedTemplate = "JCObjectReflectorClassObjectGetPropertyArrayDeprecated.template";

            public const string ReflectorEnumTemplate = "JCObjectReflectorEnum.template";
            public const string ReflectorEnumFlagsTemplate = "JCObjectReflectorEnumFlags.template";

            public const string ReflectorEnumeratorTemplate = "JCObjectReflectorEnumerator.template";
            public const string ReflectorEnumerableTemplate = "JCObjectReflectorClassEnumerable.template";
            public const string ReflectorEnumerableDeprecatedTemplate = "JCObjectReflectorClassEnumerableDeprecated.template";
            public const string ReflectorEnumerableNativeNextTemplate = "JCObjectReflectorEnumeratorNativeNext.template";
            public const string ReflectorEnumerableObjectNextTemplate = "JCObjectReflectorEnumeratorObjectNext.template";

            public const string ReflectorClassEventTemplate = "JCObjectReflectorClassEvent.template";


            public const string VoidDelegateClassTemplate = "JCObjectReflectorVoidDelegateClass.template";
            public const string VoidDelegateInterfaceTemplate = "JCObjectReflectorVoidDelegateInterface.template";
            public const string NativeDelegateClassTemplate = "JCObjectReflectorNativeDelegateClass.template";
            public const string ObjectDelegateClassTemplate = "JCObjectReflectorObjectDelegateClass.template";
            public const string NonVoidDelegateInterfaceTemplate = "JCObjectReflectorNonVoidDelegateInterface.template";

            public const string ManifestTemplate = "JCOManifest.template";

            public const string POMExtension = "JCOPOMExtension.template";
            public const string POMJCOReflector = "JCOPOMJCOReflector.template";

            public const string JCOReflectorOptionsTemplate = "JCOReflectorOptions.template";
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
            public const string PACKAGE_CLASS_BASE_CLASS = "PACKAGE_CLASS_BASE_CLASS";
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
            public const string INVOKE_PARAMETER_NONPRIMITIVE = ", {1} == null ? null : {0}{1}.getJCOInstance()";
            public const string INVOKE_PARAMETER_NONPRIMITIVE_ARRAY = ", {0}toObjectFromArray({1})";
            public const string INVOKE_PARAMETER_JCOREFOUT = ", {0}{1}.getJCRefOut()";
            public const string JCORefOutType = "JCORefOut";
            public const string JCORefOutTypeGenericFormatter = "JCORefOut<{0}>";
        }

        public class CTor
        {
            public const string CTOR_PARAMETERS = "CTOR_PARAMETERS";
            public const string CTOR_NEWOBJECT_PARAMETERS = "CTOR_NEWOBJECT_PARAMETERS";

            public static string DEFAULT_CTOR = "    public PACKAGE_CLASS_NAME() throws Throwable {" + Environment.NewLine +
                                                "    }" + Environment.NewLine;
        }

        public class Methods
        {
            public const string METHOD_MODIFIER_KEYWORD = "METHOD_MODIFIER_KEYWORD";
            public const string METHOD_JAVA_NAME = "METHOD_JAVA_NAME";
            public const string METHOD_NAME = "METHOD_NAME";
            public const string METHOD_OBJECT = "METHOD_OBJECT";
            public const string METHOD_RETURN_TYPE = "METHOD_RETURN_TYPE";
            public const string METHOD_IMPLEMENTATION_RETURN_TYPE = "METHOD_IMPLEMENTATION_RETURN_TYPE";
            public const string METHOD_RETURN_INNER_TYPE = "METHOD_RETURN_INNER_TYPE";
            public const string METHOD_PARAMETERS = "METHOD_PARAMETERS";
            public const string METHOD_INVOKE_PARAMETERS = "METHOD_INVOKE_PARAMETERS";

            public const string DUPLICATED_PARAMETER_PROTO = "dupParam{0}";
            public const string NEW_MODIFIER_PROTO = "{0}New{1}";

            public static string AUTOCLOSEABLE_CLOSE_METHOD = "    public void close() throws Exception {" + Environment.NewLine +
                                                                "        try {" + Environment.NewLine +
                                                                "            if (classInstance == null)" + Environment.NewLine +
                                                                "                throw new UnsupportedOperationException(\"classInstance is null.\");" + Environment.NewLine +
                                                                "            try {" + Environment.NewLine +
                                                                "                classInstance.Invoke(\"Dispose\");" + Environment.NewLine +
                                                                "            }" + Environment.NewLine +
                                                                "            catch (JCNativeException jcne) {" + Environment.NewLine +
                                                                "                throw translateException(jcne);" + Environment.NewLine +
                                                                "            }" + Environment.NewLine +
                                                                "        } catch (Throwable t) {" + Environment.NewLine +
                                                                "            throw new Exception(t);" + Environment.NewLine +
                                                                "        }" + Environment.NewLine +
                                                                "    }";

            public const string METHOD_INTERFACE_NAME = "METHOD_INTERFACE_NAME";
            public const string METHOD_ENUMERATOR_NAME = "METHOD_ENUMERATOR_NAME";
        }

        public class Properties
        {
            public const string METHOD_MODIFIER_KEYWORD = "METHOD_MODIFIER_KEYWORD";
            public const string PROPERTY_JAVA_NAME = "PROPERTY_JAVA_NAME";
            public const string PROPERTY_NAME = "PROPERTY_NAME";
            public const string PROPERTY_OBJECT = "PROPERTY_OBJECT";
            public const string PROPERTY_INPUTTYPE = "PROPERTY_INPUTTYPE";
            public const string PROPERTY_INPUTNAME = "PROPERTY_INPUTNAME";
            public const string PROPERTY_OUTPUTTYPE = "PROPERTY_OUTPUTTYPE";
            public const string PROPERTY_IMPLEMENTATION_OUTPUTTYPE = "PROPERTY_IMPLEMENTATION_OUTPUTTYPE";
            public const string PROPERTY_VALUE = "PROPERTY_VALUE";
            public const string PROPERTY_PARAMETERS = "PROPERTY_PARAMETERS";
            public const string PROPERTY_INVOKE_PARAMETERS = "PROPERTY_INVOKE_PARAMETERS";
            public const string PROPERTY_INTERFACE_NAME = "PROPERTY_INTERFACE_NAME";
        }

        public class Events
        {
            public const string METHOD_MODIFIER_KEYWORD = "METHOD_MODIFIER_KEYWORD";
            public const string EVENT_JAVA_NAME = "EVENT_JAVA_NAME";
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
            public const string DELEGATE_DYNAMIC_INVOKE_SECTION = "DELEGATE_DYNAMIC_INVOKE_SECTION";

            public const string INVOKE_PARAMETER = "{0}, ";
            public const string INPUT_INVOKE_PARAMETER = "{0} {1}, ";
            public const string CONVERTER_BLOCK_PARAMETER_PRIMITIVE = "            {0} {1} = argsFromJCOBridge[{2}] == null ? null : ({0})argsFromJCOBridge[{2}];";

            public const string CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE = "            {0} {1} = argsFromJCOBridge[{2}] == null ? null : new {0}(argsFromJCOBridge[{2}]);";

            public static string CONVERTER_BLOCK_PARAMETER_PRIMITIVE_ARRAY = "            CONVERTER_BLOCK_PARAM_TYPE[] CONVERTER_BLOCK_PARAM_NAME = null;" + Environment.NewLine +
                                                                             "            if (argsFromJCOBridge[CONVERTER_BLOCK_PARAM_INDEX] != null) {" + Environment.NewLine +
                                                                             "                ArrayList<java.lang.Object> resultingArrayListCONVERTER_BLOCK_PARAM_INDEX = new ArrayList<java.lang.Object>();" + Environment.NewLine +
                                                                             "                JCObject resultingObjects = (JCObject)argsFromJCOBridge[CONVERTER_BLOCK_PARAM_INDEX];" + Environment.NewLine +
                                                                             "                for (java.lang.Object resultingObjectCONVERTER_BLOCK_PARAM_INDEX : resultingObjects) {" + Environment.NewLine +
                                                                             "                    resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.add(resultingObjectCONVERTER_BLOCK_PARAM_INDEX);" + Environment.NewLine +
                                                                             "                }" + Environment.NewLine +
                                                                             "                CONVERTER_BLOCK_PARAM_NAME = new CONVERTER_BLOCK_PARAM_TYPE[resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.size()];" + Environment.NewLine +
                                                                             "		    	  for(int indexCONVERTER_BLOCK_PARAM_INDEX = 0; indexCONVERTER_BLOCK_PARAM_INDEX < resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.size(); indexCONVERTER_BLOCK_PARAM_INDEX++ ) {" + Environment.NewLine +
                                                                             "	                  CONVERTER_BLOCK_PARAM_NAME[indexCONVERTER_BLOCK_PARAM_INDEX] = (CONVERTER_BLOCK_PARAM_TYPE)resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.get(indexCONVERTER_BLOCK_PARAM_INDEX);" + Environment.NewLine +
                                                                             "                }" + Environment.NewLine +
                                                                             "            }" + Environment.NewLine;

            public static string CONVERTER_BLOCK_PARAMETER_NONPRIMITIVE_ARRAY = "            CONVERTER_BLOCK_PARAM_TYPE[] CONVERTER_BLOCK_PARAM_NAME = null;" + Environment.NewLine +
                                                                                "            if (argsFromJCOBridge[CONVERTER_BLOCK_PARAM_INDEX] != null) {" + Environment.NewLine +
                                                                                "                ArrayList<CONVERTER_BLOCK_PARAM_TYPE> resultingArrayListCONVERTER_BLOCK_PARAM_INDEX = new ArrayList<CONVERTER_BLOCK_PARAM_TYPE>();" + Environment.NewLine +
                                                                                "                JCObject resultingObjects = (JCObject)argsFromJCOBridge[CONVERTER_BLOCK_PARAM_INDEX];" + Environment.NewLine +
                                                                                "                for (java.lang.Object resultingObjectCONVERTER_BLOCK_PARAM_INDEX : resultingObjects) {" + Environment.NewLine +
                                                                                "                    resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.add(new CONVERTER_BLOCK_IMPLEMENTATION_PARAM_TYPE(resultingObjectCONVERTER_BLOCK_PARAM_INDEX));" + Environment.NewLine +
                                                                                "                }" + Environment.NewLine +
                                                                                "                CONVERTER_BLOCK_PARAM_NAME = new CONVERTER_BLOCK_PARAM_TYPE[resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.size()];" + Environment.NewLine +
                                                                                "                CONVERTER_BLOCK_PARAM_NAME = resultingArrayListCONVERTER_BLOCK_PARAM_INDEX.toArray(CONVERTER_BLOCK_PARAM_NAME);" + Environment.NewLine +
                                                                                "            }" + Environment.NewLine;

            public const string CONVERTER_BLOCK_PARAM_TYPE = "CONVERTER_BLOCK_PARAM_TYPE";
            public const string CONVERTER_BLOCK_IMPLEMENTATION_PARAM_TYPE = "CONVERTER_BLOCK_IMPLEMENTATION_PARAM_TYPE";
            public const string CONVERTER_BLOCK_PARAM_NAME = "CONVERTER_BLOCK_PARAM_NAME";
            public const string CONVERTER_BLOCK_PARAM_INDEX = "CONVERTER_BLOCK_PARAM_INDEX";

            public const string DELEGATE_RETURN_STATEMENT = "DELEGATE_RETURN_STATEMENT";
            public const string DELEGATE_RETURN_STATEMENTTYPE = "DELEGATE_RETURN_STATEMENTTYPE";
            public const string DELEGATE_RETURN_STATEMENT_OBJECT = "            return (retVal == null) ? null : retVal.getJCOInstance();";
            public static string DELEGATE_RETURN_STATEMENT_OBJECT_ARRAY = "            if (retVal == null) return retVal;" + Environment.NewLine +
                                                                          "            ArrayList<java.lang.Object> retValJCArrayList = new ArrayList<java.lang.Object>();" + Environment.NewLine +
                                                                          "            for (DELEGATE_RETURN_STATEMENTTYPE retValJCObject : retVal) {" + Environment.NewLine +
                                                                          "                retValJCArrayList.add(retValJCObject.getJCOInstance());" + Environment.NewLine +
                                                                          "            }" + Environment.NewLine +
                                                                          "            return (java.lang.Object)retValJCArrayList.toArray();";
        }

        public class Enumerator
        {
            public const string PACKAGE_NAME = "PACKAGE_NAME";

            public const string PACKAGE_IMPORT_SECTION = "PACKAGE_IMPORT_SECTION";

            public const string PACKAGE_CLASS_NAME = "PACKAGE_CLASS_NAME";
            public const string PACKAGE_INNER_CLASS_NAME = "PACKAGE_INNER_CLASS_NAME";
            public const string PACKAGE_IMPLEMENTATION_INNER_CLASS_NAME = "PACKAGE_IMPLEMENTATION_INNER_CLASS_NAME";
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

        public class Documentation
        {
            public const string DOCS_VERSION_JCOREFLECTOR_PLACEHOLDER = "DOCS_VERSION_JCOREFLECTOR_PLACEHOLDER";
            public const string DOCS_HEADER = "<a href=\\\"https://masesgroup.github.io/JCOReflector\\\" style=\\\"text-decoration: none;margin-left: 0;padding: 1px 20px 0 0;font-size: 30px;font-weight: 200;color: #777777;text-shadow: 0 1px 0 #ffffff;\\\"><b>JCOReflector</b></a> DOCS_VERSION_JCOREFLECTOR_PLACEHOLDER powered by </large><a href=\\\"https://www.jcobridge.com/\\\" style=\\\"text-decoration: none;overflow: hidden;margin-left: 0;padding: 1px 20px 0 0;font-size: 30px;font-weight: 200;color: #777777;text-shadow: 0 1px 0 #ffffff;\\\"><span style=\\\"color: #5090FF;\\\"> <img src=\\\"https://www.jcobridge.com/LogoSquare.png\\\" width=\\\"25\\\">J<small>VM CLR Objects Bridge</small></span></a>";
        }

        public class POM
        {
            public const string POM_SOURCEDIRECTORIES_PLACEHOLDER = "POM_SOURCEDIRECTORIES_PLACEHOLDER";
            public const string POM_ARTIFACTID_PLACEHOLDER = "POM_ARTIFACTID_PLACEHOLDER";
            public const string POM_NAME_PLACEHOLDER = "POM_NAME_PLACEHOLDER";
            public const string POM_DESCRIPTION_PLACEHOLDER = "POM_DESCRIPTION_PLACEHOLDER";
            public const string POM_JCOREFLECTOR_VERSION_PLACEHOLDER = "POM_JCOREFLECTOR_VERSION_PLACEHOLDER";
            public const string POM_ADDITIONAL_DEPENDENCIES_PLACEHOLDER = "POM_ADDITIONAL_DEPENDENCIES_PLACEHOLDER";
            public const string POM_VERSION_PLACEHOLDER = "POM_VERSION_PLACEHOLDER";
            public const string POM_VERSION_SNAPSHOT = "-SNAPSHOT";
            public const string POM_RUNTIME_PLACEHOLDER = "POM_RUNTIME_PLACEHOLDER";
            public const string POM_JDK_TARGET = "POM_JDK_TARGET";
            public const string POM_JCOREFLECTOR_SOURCE_PLACEHOLDER = "                <source>./{0}</source>";
        }

        public class Report
        {
            public const string ASSEMBLIES_FILE_TO_WRITE = "assemblies.list";
            public const string REPORT_FILE_TO_WRITE = "README.md";
            public const string REPORT_BEGIN_PLACEHOLDER = "[//]: # \"BeginReport {0}\"";
            public const string REPORT_END_PLACEHOLDER = "[//]: # \"EndReport {0}\"";
        }

        public class Options
        {
            public const string Assembly_Names_Value = "Assembly_Names_Value";
            public const string Create_Exception_Thrown_Clause_Value = "Create_Exception_Thrown_Clause_Value";
            public const string Exception_Thrown_Clause_Depth_Value = "Exception_Thrown_Clause_Depth_Value";
            public const string Enable_Abstract_Value = "Enable_Abstract_Value";
            public const string Enable_Array_Value = "Enable_Array_Value";
            public const string Enable_Duplicate_Method_Native_Array_With_JCORefOut_Value = "Enable_Duplicate_Method_Native_Array_With_JCORefOut_Value";
            public const string Enable_Inheritance_Value = "Enable_Inheritance_Value";
            public const string Enable_Interface_Inheritance_Value = "Enable_Interface_Inheritance_Value";
            public const string Enable_RefOut_Parameters_Value = "Enable_RefOut_Parameters_Value";
        }
    }
}
