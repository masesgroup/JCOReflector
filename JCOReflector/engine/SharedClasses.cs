/*
 *  MIT License
 *
 *  Copyright (c) 2021 MASES s.r.l.
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

using MASES.CLIParser;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.IO;
using System.Threading;
using System.Threading.Tasks;

namespace MASES.JCOReflectorEngine
{
    public delegate void appendToConsoleHandler(string format, params object[] args);

    #region LogLevel enum
    public enum LogLevel
    {
        Error,
        Warning,
        Info,
        Verbose
    }
    #endregion

    #region JDKVersion enum
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
    #endregion

    #region JobTypes enum
    public enum JobTypes
    {
        NoType,
        Reflect,
        Build,
        BuildDocs,
        CreateJars,
        CreatePOM,
        ExtractPOM,
    }
    #endregion

    #region POMType enum
    public enum POMType
    {
        Frameworks,
        Extension
    }
    #endregion

    #region POMVersionType enum
    public enum POMVersionType
    {
        NoPOM,
        Release,
        Snapshot
    }
    #endregion

    #region JobManager Class
    /// <summary>
    /// The main entry point
    /// </summary>
    public static class JobManager
    {
        static readonly object ctsLock = new object();
        static CancellationTokenSource cts = null;
        internal static LogLevel LogLevel;
        internal static CancellationToken CancellationToken;

        static appendToConsoleHandler AppendToConsoleHandler;
        static EventHandler<EndOperationEventArgs> EndOperationHandler;
        /// <summary>
        /// Running location identified on startup
        /// </summary>
        public static readonly string StartupLocation;
        /// <summary>
        /// Default root which use the JCOReflector repository rules
        /// </summary>
        public static readonly string DefaultRootFolder;

        static string rootFolder = null;
        /// <summary>
        /// Root used for all operations
        /// </summary>
        public static string RootFolder
        {
            get { return rootFolder; }
            set
            {
                rootFolder = value;
                JarDestinationFolder = Const.FileNameAndDirectory.GetRelativePath(StartupLocation, RootFolder);
                SourceDestinationFolder = Path.Combine(rootFolder, Const.FileNameAndDirectory.RootDirectory);
            }
        }
        /// <summary>
        /// Destination of produced sources
        /// </summary>
        public static string SourceDestinationFolder { get; set; }
        /// <summary>
        /// Destination of JARs relative to <see cref="RootFolder"/>
        /// </summary>
        public static string JarDestinationFolder { get; set; }

        static JobManager()
        {
            StartupLocation = Path.GetDirectoryName(typeof(JobManager).Assembly.Location);
            RootFolder = DefaultRootFolder = Path.Combine(StartupLocation, @".." + Path.DirectorySeparatorChar + @".." + Path.DirectorySeparatorChar);
            arguments = prepareArguments();
            parser.Add(arguments);
        }
        /// <summary>
        /// Sets the operations handler 
        /// </summary>
        /// <param name="appendToConsoleHandler">Handler for logging purpose</param>
        /// <param name="endOperationHandler">Handler for completed operations</param>
        public static void SetHandler(appendToConsoleHandler appendToConsoleHandler, EventHandler<EndOperationEventArgs> endOperationHandler)
        {
            AppendToConsoleHandler = appendToConsoleHandler;
            EndOperationHandler = endOperationHandler;
        }

        public class CmdParam
        {
            public const string File = "JobFile";

            // CommonArgs
            public const string JobType = "JobType";
            public const string LogLevel = "LogLevel";
            public const string RootFolder = "RootFolder";
            public const string SplitFolderByAssembly = "SplitFolderByAssembly";

            // FolderBuilderEventArgs
            public const string SourceFolder = "SourceFolder";

            // ReflectorEventArgs
            public const string Assembly = "Assembly";
            public const string SourceDestinationFolder = "SourceDestinationFolder";
            public const string ForceRebuild = "ForceRebuild";
            public const string UseParallelBuild = "UseParallelBuild";
            public const string AvoidHierarchyTraversing = "AvoidHierarchyTraversing";
            public const string CreateExceptionThrownClause = "CreateExceptionThrownClause";
            public const string ExceptionThrownClauseDepth = "ExceptionThrownClauseDepth";
            public const string EnableAbstract = "EnableAbstract";
            public const string EnableArray = "EnableArray";
            public const string EnableDuplicateMethodNativeArrayWithJCRefOut = "EnableDuplicateMethodNativeArrayWithJCRefOut";
            public const string EnableInheritance = "EnableInheritance";
            public const string EnableInterfaceInheritance = "EnableInterfaceInheritance";
            public const string EnableRefOutParameters = "EnableRefOutParameters";
            public const string DryRun = "DryRun";
            public const string AvoidReportAndStatistics = "AvoidReportAndStatistics";

            // JavaBuilderEventArgs
            public const string JDKFolder = "JDKFolder";
            public const string JDKTarget = "JDKTarget";
            public const string AssembliesToUse = "AssembliesToUse";
            public const string JDKToolExtraOptions = "JDKToolExtraOptions";

            // DocsBuilderEventArgs
            public const string CommitVersion = "CommitVersion";

            // JARBuilderEventArgs
            public const string JarDestinationFolder = "JarDestinationFolder";
            public const string WithJARSource = "WithJARSource";
            public const string EmbeddingJCOBridge = "EmbeddingJCOBridge";

            // POMBuilderEventArgs
            public const string POMArtifactId = "POMArtifactId";
            public const string POMName = "POMName";
            public const string POMFileName = "POMFileName";
            public const string POMDescription = "POMDescription";
            public const string POMVersion = "POMVersion";
            public const string POMType = "POMType";
            public const string POMVersionType = "POMVersionType";
        }

        static Parser parser = Parser.CreateInstance(new Settings()
        {
            DefaultType = ArgumentType.Double,
        });

        static IArgumentMetadata[] arguments = null;
        static IArgumentMetadata[] prepareArguments()
        {
            return new IArgumentMetadata[]
            {
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.File,
                    Default = null,
                    Help = "The file containing the serialized job to run.",
                },
                new ArgumentMetadata<JobTypes>()
                {
                    Name = CmdParam.JobType,
                    IsMandatory = true,
                    Help = "The job to execute.",
                },
                new ArgumentMetadata<LogLevel>()
                {
                    Name = CmdParam.LogLevel,
                    Default = LogLevel.Error,
                    Help = "The error level to report.",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.RootFolder,
                    Default = RootFolder,
                    Help = "The root folder.",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.SplitFolderByAssembly,
                    Default = true,
                    Help = "True to split the reflected class into folder with the name equals to the name of assembly containing the class.",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.SourceFolder,
                    Default = SourceDestinationFolder,
                    Help = "The foldercontaining the reflected classes (used from any JobType expect JobType.Reflect).",
                },
                // reflector arguments
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.Assembly,
                    IsMultiValue = true,
                    Default = ArgumentMetadata<string>.DefaultMultiValue,
                    Help = "The list of assembly name to parse (used from JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.SourceDestinationFolder,
                    Default = SourceDestinationFolder,
                    Help = "The destination folder where store the reflected classes (used from JobType.Reflect).",
                },

                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.ForceRebuild,
                    Default = true,
                    Help = "Force rebuild even if the assembly folder is in the SourceDestinationFolder (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.UseParallelBuild,
                    Default = true,
                    Help = "Optimize use of processors with a parallel execution (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.AvoidHierarchyTraversing,
                    Default = true,
                    Help = "Avoid the traversing of the assemblies dependency hierarchy (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.CreateExceptionThrownClause,
                    Default = true,
                    Help = "Analyze and add exception in the methods declaration (used from JobType.Reflect).",
                },
                new ArgumentMetadata<int>()
                {
                    Name = CmdParam.ExceptionThrownClauseDepth,
                    Default = 10,
                    ValueType = ArgumentValueType.Range,
                    MinValue = 0,
                    MaxValue = int.MaxValue,
                    Help = "The maximum analysis depth when searching for exception (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EnableAbstract,
                    Default = true,
                    Help = "Enable abstract classes (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EnableArray,
                    Default = true,
                    Help = "Enable array declaration (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EnableDuplicateMethodNativeArrayWithJCRefOut,
                    Default = true,
                    Help = "Duplicates methods which has array of native types to reproduce the same behavior of .NET (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EnableInheritance,
                    Default = true,
                    Help = "Enable class inheritance (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EnableInterfaceInheritance,
                    Default = true,
                    Help = "Enable interface inheritance (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EnableRefOutParameters,
                    Default = true,
                    Help = "Enable management of ref and out parameters (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.DryRun,
                    Default = false,
                    Help = "Do not write anything (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.AvoidReportAndStatistics,
                    Default = false,
                    Help = "Do not write report and statistics (used from JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.JDKFolder,
                    Default = null,
                    Help = "The folder containing the JDK, it is used to find JDK tools (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<JDKVersion>()
                {
                    Name = CmdParam.JDKTarget,
                    Default = JDKVersion.Version8,
                    Help = "The java version used when class are generated (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.AssembliesToUse,
                    Default = ArgumentMetadata<string>.DefaultMultiValue,
                    IsMultiValue = true,
                    Help = "The list of assemblies, the one previously reflected, to be used in the operation (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.JDKToolExtraOptions,
                    Default = string.Empty,
                    Help = "Extra options to be passed to the JDK tools (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.CommitVersion,
                    Default = string.Empty,
                    Help = "The commit version (used from JobType.BuildDocs).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.JarDestinationFolder,
                    Default = string.Empty,
                    Help = "Destination folder where store JarFile (used from JobType.CreateJars).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.WithJARSource,
                    Default = false,
                    Help = "Create the source Jar (used from JobType.CreateJars).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = CmdParam.EmbeddingJCOBridge,
                    Default = true,
                    Help = "Embed JCOBridge engine within JCOReflector.jar (used from JobType.CreateJars).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.POMArtifactId,
                    Help = "The artifact Id to use in the POM (used from JobType.CreatePOM).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.POMName,
                    Help = "The artifact name to use in the POM (used from JobType.CreatePOM).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.POMFileName,
                    Help = "The file name to use in the POM extraction or POM preparation (used from JobType.CreatePOM and JobType.ExtractPOM).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.POMDescription,
                    Help = "The description to use in the POM (used from JobType.CreatePOM).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = CmdParam.POMVersion,
                    Default = Const.ReflectorVersion,
                    Help = "The version to use when the POM is created (used from JobType.CreatePOM).",
                },
                new ArgumentMetadata<POMType>()
                {
                    Name = CmdParam.POMType,
                    Default = POMType.Frameworks,
                    Help = "Select if the POM must be created for internal purpose (i.e. JCOReflector) or for external assemblies (used from JobType.CreatePOM).",
                },
                new ArgumentMetadata<POMVersionType>()
                {
                    Name = CmdParam.POMVersionType,
                    Default = POMVersionType.Snapshot,
                    Help = "Select if the POM must have a SNAPSHOT version or not (used from JobType.CreatePOM).",
                },
            };
        }
        /// <summary>
        /// Returns the help info for parameters
        /// </summary>
        /// <returns></returns>
        public static string GetArgumentHelp()
        {
            int newPadding = parser.PaddingFromArguments();
            parser.Settings.DefaultDescriptionPadding = newPadding;
            return parser.HelpInfo();
        }
        /// <summary>
        /// Convert arguments into an instance of <see cref="CommonEventArgs"/>
        /// </summary>
        /// <param name="args">Arguments from command line</param>
        /// <returns>An instance of <see cref="CommonEventArgs"/></returns>
        public static CommonEventArgs FromArgs(this string[] args)
        {
            var resultingArgs = parser.Parse(args);

            var jobType = parser.Get<JobTypes>(resultingArgs, CmdParam.JobType);
            CommonEventArgs arg = null;
            if (parser.Exist(resultingArgs, CmdParam.File))
            {
                arg = ConvertFile(jobType, parser.Get<string>(resultingArgs, CmdParam.File));
            }

            if (jobType == JobTypes.NoType) throw new InvalidOperationException("No JobType neighter in file nor in command line");

            switch (jobType)
            {
                case JobTypes.Reflect:
                    {
                        ReflectorEventArgs newArg;
                        if (arg == null) arg = newArg = new ReflectorEventArgs();
                        else newArg = arg as ReflectorEventArgs;
                        if (parser.Exist(resultingArgs, CmdParam.LogLevel))
                        {
                            newArg.LogLevel = parser.Get<LogLevel>(resultingArgs, CmdParam.LogLevel);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.RootFolder))
                        {
                            newArg.RootFolder = parser.Get<string>(resultingArgs, CmdParam.RootFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = parser.Get<bool>(resultingArgs, CmdParam.SplitFolderByAssembly);
                        }
                        List<string> assemblies = new List<string>();
                        if (newArg.AssemblyNames != null) assemblies.AddRange(newArg.AssemblyNames);
                        if (parser.Exist(resultingArgs, CmdParam.Assembly))
                        {
                            assemblies.AddRange(parser.Get<IEnumerable<string>>(resultingArgs, CmdParam.Assembly));
                        }
                        newArg.AssemblyNames = assemblies.ToArray();
                        if (parser.Exist(resultingArgs, CmdParam.SourceDestinationFolder))
                        {
                            newArg.SourceDestinationFolder = parser.Get<string>(resultingArgs, CmdParam.SourceDestinationFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.ForceRebuild))
                        {
                            newArg.ForceRebuild = parser.Get<bool>(resultingArgs, CmdParam.ForceRebuild);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.UseParallelBuild))
                        {
                            newArg.UseParallelBuild = parser.Get<bool>(resultingArgs, CmdParam.UseParallelBuild);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.AvoidHierarchyTraversing))
                        {
                            newArg.AvoidHierarchyTraversing = parser.Get<bool>(resultingArgs, CmdParam.AvoidHierarchyTraversing);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.CreateExceptionThrownClause))
                        {
                            newArg.CreateExceptionThrownClause = parser.Get<bool>(resultingArgs, CmdParam.CreateExceptionThrownClause);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.ExceptionThrownClauseDepth))
                        {
                            newArg.ExceptionThrownClauseDepth = parser.Get<int>(resultingArgs, CmdParam.ExceptionThrownClauseDepth);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.EnableAbstract))
                        {
                            newArg.EnableAbstract = parser.Get<bool>(resultingArgs, CmdParam.EnableAbstract);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.EnableArray))
                        {
                            newArg.EnableArray = parser.Get<bool>(resultingArgs, CmdParam.EnableArray);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.EnableDuplicateMethodNativeArrayWithJCRefOut))
                        {
                            newArg.EnableDuplicateMethodNativeArrayWithJCRefOut = parser.Get<bool>(resultingArgs, CmdParam.EnableDuplicateMethodNativeArrayWithJCRefOut);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.EnableInheritance))
                        {
                            newArg.EnableInheritance = parser.Get<bool>(resultingArgs, CmdParam.EnableInheritance);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.EnableInterfaceInheritance))
                        {
                            newArg.EnableInterfaceInheritance = parser.Get<bool>(resultingArgs, CmdParam.EnableInterfaceInheritance);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.EnableRefOutParameters))
                        {
                            newArg.EnableRefOutParameters = parser.Get<bool>(resultingArgs, CmdParam.EnableRefOutParameters);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.DryRun))
                        {
                            newArg.DryRun = parser.Get<bool>(resultingArgs, CmdParam.DryRun);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.AvoidReportAndStatistics))
                        {
                            newArg.AvoidReportAndStatistics = parser.Get<bool>(resultingArgs, CmdParam.AvoidReportAndStatistics);
                        }
                    }
                    break;
                case JobTypes.Build:
                    {
                        JavaBuilderEventArgs newArg;
                        if (arg == null) arg = newArg = new JavaBuilderEventArgs();
                        else newArg = arg as JavaBuilderEventArgs;

                        if (parser.Exist(resultingArgs, CmdParam.LogLevel))
                        {
                            newArg.LogLevel = parser.Get<LogLevel>(resultingArgs, CmdParam.LogLevel);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.RootFolder))
                        {
                            newArg.RootFolder = parser.Get<string>(resultingArgs, CmdParam.RootFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = parser.Get<bool>(resultingArgs, CmdParam.SplitFolderByAssembly);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.SourceFolder))
                        {
                            newArg.SourceFolder = parser.Get<string>(resultingArgs, CmdParam.SourceFolder);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.JDKFolder))
                        {
                            newArg.JDKFolder = parser.Get<string>(resultingArgs, CmdParam.JDKFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKTarget))
                        {
                            newArg.JDKTarget = parser.Get<JDKVersion>(resultingArgs, CmdParam.JDKTarget);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(parser.Get<IEnumerable<string>>(resultingArgs, CmdParam.AssembliesToUse)).ToArray();
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = parser.Get<string>(resultingArgs, CmdParam.JDKToolExtraOptions);
                        }
                    }
                    break;
                case JobTypes.BuildDocs:
                    {
                        DocsBuilderEventArgs newArg;
                        if (arg == null) arg = newArg = new DocsBuilderEventArgs();
                        else newArg = arg as DocsBuilderEventArgs;

                        if (parser.Exist(resultingArgs, CmdParam.LogLevel))
                        {
                            newArg.LogLevel = parser.Get<LogLevel>(resultingArgs, CmdParam.LogLevel);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.RootFolder))
                        {
                            newArg.RootFolder = parser.Get<string>(resultingArgs, CmdParam.RootFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = parser.Get<bool>(resultingArgs, CmdParam.SplitFolderByAssembly);
                        }


                        if (parser.Exist(resultingArgs, CmdParam.SourceFolder))
                        {
                            newArg.SourceFolder = parser.Get<string>(resultingArgs, CmdParam.SourceFolder);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.JDKFolder))
                        {
                            newArg.JDKFolder = parser.Get<string>(resultingArgs, CmdParam.JDKFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKTarget))
                        {
                            newArg.JDKTarget = parser.Get<JDKVersion>(resultingArgs, CmdParam.JDKTarget);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(parser.Get<IEnumerable<string>>(resultingArgs, CmdParam.AssembliesToUse)).ToArray();
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = parser.Get<string>(resultingArgs, CmdParam.JDKToolExtraOptions);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.CommitVersion))
                        {
                            newArg.CommitVersion = parser.Get<string>(resultingArgs, CmdParam.CommitVersion);
                        }
                    }
                    break;
                case JobTypes.CreateJars:
                    {
                        JARBuilderEventArgs newArg;
                        if (arg == null) arg = newArg = new JARBuilderEventArgs();
                        else newArg = arg as JARBuilderEventArgs;

                        if (parser.Exist(resultingArgs, CmdParam.LogLevel))
                        {
                            newArg.LogLevel = parser.Get<LogLevel>(resultingArgs, CmdParam.LogLevel);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.RootFolder))
                        {
                            newArg.RootFolder = parser.Get<string>(resultingArgs, CmdParam.RootFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = parser.Get<bool>(resultingArgs, CmdParam.SplitFolderByAssembly);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.SourceFolder))
                        {
                            newArg.SourceFolder = parser.Get<string>(resultingArgs, CmdParam.SourceFolder);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.JDKFolder))
                        {
                            newArg.JDKFolder = parser.Get<string>(resultingArgs, CmdParam.JDKFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKTarget))
                        {
                            newArg.JDKTarget = parser.Get<JDKVersion>(resultingArgs, CmdParam.JDKTarget);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(parser.Get<IEnumerable<string>>(resultingArgs, CmdParam.AssembliesToUse)).ToArray();
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = parser.Get<string>(resultingArgs, CmdParam.JDKToolExtraOptions);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.JarDestinationFolder))
                        {
                            newArg.JarDestinationFolder = parser.Get<string>(resultingArgs, CmdParam.JarDestinationFolder);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.WithJARSource))
                        {
                            newArg.WithJARSource = parser.Get<bool>(resultingArgs, CmdParam.WithJARSource);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.EmbeddingJCOBridge))
                        {
                            newArg.EmbeddingJCOBridge = parser.Get<bool>(resultingArgs, CmdParam.EmbeddingJCOBridge);
                        }
                    }
                    break;
                case JobTypes.CreatePOM:
                    {
                        POMBuilderEventArgs newArg;
                        if (arg == null) arg = newArg = new POMBuilderEventArgs();
                        else newArg = arg as POMBuilderEventArgs;

                        if (parser.Exist(resultingArgs, CmdParam.LogLevel))
                        {
                            newArg.LogLevel = parser.Get<LogLevel>(resultingArgs, CmdParam.LogLevel);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.RootFolder))
                        {
                            newArg.RootFolder = parser.Get<string>(resultingArgs, CmdParam.RootFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = parser.Get<bool>(resultingArgs, CmdParam.SplitFolderByAssembly);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.SourceFolder))
                        {
                            newArg.SourceFolder = parser.Get<string>(resultingArgs, CmdParam.SourceFolder);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.JDKFolder))
                        {
                            newArg.JDKFolder = parser.Get<string>(resultingArgs, CmdParam.JDKFolder);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKTarget))
                        {
                            newArg.JDKTarget = parser.Get<JDKVersion>(resultingArgs, CmdParam.JDKTarget);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(parser.Get<IEnumerable<string>>(resultingArgs, CmdParam.AssembliesToUse)).ToArray();
                        }
                        if (parser.Exist(resultingArgs, CmdParam.JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = parser.Get<string>(resultingArgs, CmdParam.JDKToolExtraOptions);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.POMArtifactId))
                        {
                            newArg.POMArtifactId = parser.Get<string>(resultingArgs, CmdParam.POMArtifactId);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.POMName))
                        {
                            newArg.POMName = parser.Get<string>(resultingArgs, CmdParam.POMName);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.POMFileName))
                        {
                            newArg.POMFileName = parser.Get<string>(resultingArgs, CmdParam.POMFileName);
                        }
                        if (parser.Exist(resultingArgs, CmdParam.POMDescription))
                        {
                            newArg.POMDescription = parser.Get<string>(resultingArgs, CmdParam.POMDescription);
                        }

                        if (parser.Exist(resultingArgs, CmdParam.POMVersion))
                        {
                            newArg.POMVersion = parser.Get<string>(resultingArgs, CmdParam.POMVersion);
                        }
                        else newArg.POMVersion = (string)parser.Get(resultingArgs, CmdParam.POMVersion).Default;
                        if (parser.Exist(resultingArgs, CmdParam.POMType))
                        {
                            newArg.POMType = parser.Get<POMType>(resultingArgs, CmdParam.POMType);
                        }
                        else newArg.POMType = (POMType)parser.Get(resultingArgs, CmdParam.POMType).Default;
                        if (parser.Exist(resultingArgs, CmdParam.POMVersionType))
                        {
                            newArg.POMVersionType = parser.Get<POMVersionType>(resultingArgs, CmdParam.POMVersionType);
                        }
                        else newArg.POMVersionType = (POMVersionType)parser.Get(resultingArgs, CmdParam.POMVersionType).Default;
                    }
                    break;
                case JobTypes.ExtractPOM:
                    {
                        POMBuilderEventArgs newArg;
                        if (arg == null) arg = newArg = new POMBuilderEventArgs();
                        else newArg = arg as POMBuilderEventArgs;

                        if (parser.Exist(resultingArgs, CmdParam.LogLevel))
                        {
                            newArg.LogLevel = parser.Get<LogLevel>(resultingArgs, CmdParam.LogLevel);
                        }

                        if (!parser.Exist(resultingArgs, CmdParam.POMFileName)) throw new ArgumentException(string.Format("ExtractPOM needs {0} argument", CmdParam.POMFileName));
                        newArg.POMFileName = parser.Get<string>(resultingArgs, CmdParam.POMFileName);
                    }
                    break;
                case JobTypes.NoType:
                default: throw new InvalidOperationException("No valid Job type.");
            }

            if (arg != null)
            {
                arg.JobType = jobType;
            }

            return arg;
        }

        /// <summary>
        /// Imports a configuration written on a file
        /// </summary>
        /// <typeparam name="T">The operation type</typeparam>
        /// <param name="path">The full file path containing the serialized operation</param>
        /// <returns>The <see cref="T"/> object</returns>
        public static T Import<T>(string path) where T : class
        {
            System.Xml.Serialization.XmlSerializer serializer = new System.Xml.Serialization.XmlSerializer(typeof(T));
            string str = File.ReadAllText(path);
            using (TextReader reader = new StringReader(str))
            {
                return serializer.Deserialize(reader) as T;
            }
        }
        /// <summary>
        /// Exports a configuration to a file
        /// </summary>
        /// <typeparam name="T">The operation type</typeparam>
        /// <param name="type">The operation object</param>
        /// <param name="fileName">The file path where operation will be written</param>
        public static void Export<T>(T type, string fileName) where T : class
        {
            System.Text.StringBuilder sb = new System.Text.StringBuilder();
            System.Xml.Serialization.XmlSerializer serializer = new System.Xml.Serialization.XmlSerializer(typeof(T));
            using (TextWriter writer = new StringWriter(sb))
            {
                serializer.Serialize(writer, type);
                writer.Flush();
            }

            string str = sb.ToString();
            File.WriteAllText(fileName, str);
        }
        /// <summary>
        /// Gets the list of generated folder from reflection
        /// </summary>
        /// <param name="args">A <see cref="FolderBuilderEventArgs"/> with instructions</param>
        /// <returns>An <see cref="AssemblyDataCollection"/> with the data</returns>
        public static AssemblyDataCollection CreateFolderList(FolderBuilderEventArgs args)
        {
            bool failed = false;

            if (!Path.IsPathRooted(args.SourceFolder))
            {
                args.SourceFolder = Path.Combine(args.RootFolder, args.SourceFolder);
            }

            string originFolder = Path.Combine(args.SourceFolder, Const.FileNameAndDirectory.SourceDirectory);

            try
            {
                var folders = CreateFolderList(originFolder);
                AssemblyDataCollection coll = new AssemblyDataCollection();
                AssemblyData data = new AssemblyData();
                data.IsSelected = true;
                data.Framework = Const.Framework.All;
                data.AssemblyFullName = Const.FileNameAndDirectory.CommonDirectory;
                data.FolderName = Const.FileNameAndDirectory.CommonDirectory;
                coll.Add(data);
                foreach (var folder in folders)
                {
                    data = new AssemblyData();
                    if (folder.Equals(Const.FileNameAndDirectory.CommonDirectory)) continue;

                    var relFolder = Const.Framework.RuntimeFolder;
                    data.AssemblyFullName = folder;
                    data.FolderName = Path.Combine(relFolder, folder);

                    data.Framework = Const.Framework.Runtime;

#if ENABLE_REFERENCE_BUILDER
                    var refPath = Path.Combine(args.OriginFolder, relFolder, folder, Const.FileNameAndDirectory.ReferencesFile);
                    var refData = File.ReadAllLines(refPath);
                    data.ReferencedAssemblies = new List<string>(refData);
#endif

                    coll.Add(data);
                }
                return coll;
            }
            catch (OperationCanceledException ex)
            {
                AppendToConsole(LogLevel.Error, "Error {0}", ex.Message);
                return new AssemblyDataCollection();
            }
            catch (Exception ex)
            {
                AppendToConsole(LogLevel.Error, "Error {0}", ex.Message);
                failed = true;
                return new AssemblyDataCollection();
            }
            finally
            {
                EndOperation(new EndOperationEventArgs(string.Empty, failed));
            }
        }

        internal static IEnumerable<string> CreateFolderList(string originFolder, bool withCommonDir = true)
        {
            originFolder = Path.GetFullPath(originFolder);
            List<string> dirs = new List<string>();

            if (withCommonDir)
            {
                dirs.Add(Const.FileNameAndDirectory.CommonDirectory);
            }

            originFolder = Path.Combine(originFolder, Const.Framework.RuntimeFolder);
            foreach (var item in Directory.EnumerateDirectories(originFolder))
            {
                var path = Path.GetFullPath(item);
                path = path.Replace(originFolder, string.Empty);
                path = path.Replace("\\", string.Empty);
                path = path.Replace("/", string.Empty);
                dirs.Add(path);
            }

            return dirs;
        }

        public static string[] CreateList(this FolderBuilderEventArgs args)
        {
            var result = CreateFolderList(args);

            foreach (var item in result)
            {
                item.IsSelected = true;
            }

            return AssemblyDataCollection.CreateList(result);
        }

        /// <summary>
        /// Convert a file into a Job
        /// </summary>
        /// <typeparam name="T">The argument type inherited from <see cref="CommonEventArgs"/></typeparam>
        /// <param name="type">The <see cref="JobTypes"/> to use</param>
        /// <param name="file">The file containing argument to use</param>
        public static CommonEventArgs ConvertFile(JobTypes type, string file)
        {
            switch (type)
            {
                case JobTypes.Reflect:
                    return Import<ReflectorEventArgs>(file);
                case JobTypes.Build:
                    return Import<JavaBuilderEventArgs>(file);
                case JobTypes.BuildDocs:
                    return Import<DocsBuilderEventArgs>(file);
                case JobTypes.CreateJars:
                    return Import<JARBuilderEventArgs>(file);
                case JobTypes.CreatePOM:
                    return Import<POMBuilderEventArgs>(file);
                case JobTypes.ExtractPOM:
                    return Import<POMBuilderEventArgs>(file);
                case JobTypes.NoType:
                default:
                    throw new InvalidOperationException("No valid Job type.");
            }
        }

        /// <summary>
        /// Executes a Job
        /// </summary>
        /// <typeparam name="T">The argument type inherited from <see cref="CommonEventArgs"/></typeparam>
        /// <param name="arg">The argument to use</param>
        /// <param name="waitEnd">True to wait the end of operation</param>
        public static void RunJob<T>(T arg, bool waitEnd = false)
            where T : CommonEventArgs
        {
            Task task = null;
            lock (ctsLock)
            {
                if (cts != null)
                {
                    throw new InvalidOperationException("A previous job is already running.");
                }
                cts = new CancellationTokenSource();
            }

            CancellationToken = cts.Token;
            LogLevel = arg.LogLevel;
            if (string.IsNullOrEmpty(arg.RootFolder))
            {
                arg.RootFolder = RootFolder;
            }
            arg.RootFolder = Path.GetFullPath(arg.RootFolder);

            switch (arg.JobType)
            {
                case JobTypes.Reflect:
                    if (arg is ReflectorEventArgs)
                    {
                        ReflectorEventArgs newArg = arg as ReflectorEventArgs;
                        if (string.IsNullOrEmpty(newArg.SourceDestinationFolder)) newArg.SourceDestinationFolder = SourceDestinationFolder;
                        newArg.SourceDestinationFolder = Path.GetFullPath(newArg.SourceDestinationFolder);
                        task = Task.Factory.StartNew(Reflector.ExecuteAction, newArg);
                    }
                    break;
                case JobTypes.Build:
                    if (arg is JavaBuilderEventArgs)
                    {
                        JavaBuilderEventArgs newArg = arg as JavaBuilderEventArgs;

                        if (string.IsNullOrEmpty(newArg.JDKFolder)) throw new ArgumentException("Missing JDKFolder");

                        if (string.IsNullOrEmpty(newArg.SourceFolder)) newArg.SourceFolder = SourceDestinationFolder;
                        newArg.SourceFolder = Path.GetFullPath(newArg.SourceFolder);
                        if (newArg.JDKTarget == JDKVersion.NotSet)
                        {
                            newArg.JDKTarget = JDKVersion.Version8;
                        }

                        if (newArg.AssembliesToUse == null || newArg.AssembliesToUse.Length == 0)
                        {
                            newArg.AssembliesToUse = newArg.CreateList();
                        }
                        task = Task.Factory.StartNew(JavaBuilder.CompileClasses, newArg);
                    }
                    break;
                case JobTypes.BuildDocs:
                    if (arg is DocsBuilderEventArgs)
                    {
                        DocsBuilderEventArgs newArg = arg as DocsBuilderEventArgs;

                        if (string.IsNullOrEmpty(newArg.JDKFolder)) throw new ArgumentException("Missing JDKFolder");

                        if (string.IsNullOrEmpty(newArg.CommitVersion))
                        {
                            throw new ArgumentException("Commit version must be set when docs are generated.");
                        }

                        if (string.IsNullOrEmpty(newArg.SourceFolder)) newArg.SourceFolder = SourceDestinationFolder;
                        newArg.SourceFolder = Path.GetFullPath(newArg.SourceFolder);
                        if (newArg.JDKTarget == JDKVersion.NotSet)
                        {
                            newArg.JDKTarget = JDKVersion.Version8;
                        }

                        if (newArg.AssembliesToUse == null || newArg.AssembliesToUse.Length == 0)
                        {
                            newArg.AssembliesToUse = newArg.CreateList();
                        }
                        task = Task.Factory.StartNew(JavaBuilder.GenerateDocs, newArg);
                    }
                    break;
                case JobTypes.CreateJars:
                    if (arg is JARBuilderEventArgs)
                    {
                        JARBuilderEventArgs newArg = arg as JARBuilderEventArgs;

                        if (string.IsNullOrEmpty(newArg.JDKFolder)) throw new ArgumentException("Missing JDKFolder");

                        if (string.IsNullOrEmpty(newArg.SourceFolder)) newArg.SourceFolder = SourceDestinationFolder;
                        newArg.SourceFolder = Path.GetFullPath(newArg.SourceFolder);
                        if (newArg.JDKTarget == JDKVersion.NotSet)
                        {
                            newArg.JDKTarget = JDKVersion.Version8;
                        }

                        if (string.IsNullOrEmpty(newArg.JarDestinationFolder))
                        {
                            newArg.JarDestinationFolder = JarDestinationFolder;
                        }

                        if (newArg.AssembliesToUse == null || newArg.AssembliesToUse.Length == 0)
                        {
                            newArg.AssembliesToUse = newArg.CreateList();
                        }

                        task = Task.Factory.StartNew(JavaBuilder.CreateJars, newArg);
                    }
                    break;
                case JobTypes.CreatePOM:
                    if (arg is POMBuilderEventArgs)
                    {
                        POMBuilderEventArgs newArg = arg as POMBuilderEventArgs;

                        if (string.IsNullOrEmpty(newArg.JDKFolder)) throw new ArgumentException("Missing JDKFolder");

                        if (string.IsNullOrEmpty(newArg.SourceFolder)) newArg.SourceFolder = SourceDestinationFolder;
                        newArg.SourceFolder = Path.GetFullPath(newArg.SourceFolder);
                        if (newArg.JDKTarget == JDKVersion.NotSet)
                        {
                            newArg.JDKTarget = JDKVersion.Version8;
                        }

                        if (newArg.AssembliesToUse == null || newArg.AssembliesToUse.Length == 0)
                        {
                            newArg.AssembliesToUse = newArg.CreateList();
                        }

                        if (newArg.POMVersionType == POMVersionType.NoPOM) throw new InvalidOperationException("No POMVersion selected.");

                        task = Task.Factory.StartNew(JavaBuilder.CreatePOM, newArg);
                    }
                    break;
                case JobTypes.ExtractPOM:
                    if (arg is POMBuilderEventArgs)
                    {
                        POMBuilderEventArgs newArg = arg as POMBuilderEventArgs;
                        if (string.IsNullOrEmpty(newArg.POMFileName))
                        {
                            throw new InvalidOperationException("POMFileName is not valid.");
                        }
                        if (string.IsNullOrEmpty(Path.GetFileName(newArg.POMFileName)))
                        {
                            throw new InvalidOperationException(string.Format("POMFileName {0} is not a valid file.", newArg.POMFileName));
                        }
                        task = Task.Factory.StartNew(JavaBuilder.ExtractPOM, newArg);
                    }
                    break;
                case JobTypes.NoType:
                default:
                    throw new InvalidOperationException("No Job type selected.");
            }

            if (waitEnd)
            {
                task.Wait();
            }
        }
        /// <summary>
        /// Cancel a running job
        /// </summary>
        public static void CancelJob()
        {
            lock (ctsLock)
            {
                if (cts == null)
                {
                    throw new InvalidOperationException("No Job running.");
                }

                cts.Cancel(true);
            }
        }

        internal static void EndOperation(EndOperationEventArgs arg)
        {
            lock (ctsLock)
            {
                if (cts != null)
                {
                    cts.Dispose();
                    cts = null;
                }
            }
            EndOperationHandler?.Invoke(null, arg);
        }

        internal static void AppendToConsole(LogLevel level, string format, params object[] args)
        {
            if (LogLevel >= level && AppendToConsoleHandler != null)
            {
                AppendToConsoleHandler(format, args);
            }
        }
    }
    #endregion

    #region AssemblyData Class
    /// <summary>
    /// The single AssemblyData.
    /// </summary>
    public class AssemblyData : INotifyPropertyChanged
    {
        #region Constructors
        /// <summary>
        /// The default constructor.
        /// </summary>
        public AssemblyData()
        {
            Initialize();
        }

        /// <summary>
        /// The default constructor.
        /// </summary>
        public AssemblyData(string folderName)
        {
            Initialize();

        }

        /// <summary>
        /// Sets private members to default values.
        /// </summary>
        private void Initialize()
        {
        }
        #endregion

        #region Persistent Properties
        bool isSelected;
        /// <summary>
        /// The IsSelected
        /// </summary>
        public bool IsSelected
        {
            get { return isSelected; }
            set
            {
                isSelected = value;
                if (AssemblyFullName == Const.FileNameAndDirectory.CommonDirectory) isSelected = true;
                EmitPropertyChanged("IsSelected");
            }
        }
        string framework;
        /// <summary>
        /// The Framework
        /// </summary>
        public string Framework { get { return framework; } set { framework = value; EmitPropertyChanged("Framework"); } }
        string assemblyFullName;
        /// <summary>
        /// The AssemblyFullName
        /// </summary>
        public string AssemblyFullName { get { return assemblyFullName; } set { assemblyFullName = value; EmitPropertyChanged("AssemblyFullName"); } }
        string folderName;
        /// <summary>
        /// The FolderName
        /// </summary>
        public string FolderName { get { return folderName; } set { folderName = value; EmitPropertyChanged("FolderName"); } }
        IList<string> referencedAssemblies = null;
        /// <summary>
        /// The ReferencedAssemblies
        /// </summary>
        public IList<string> ReferencedAssemblies { get { return referencedAssemblies; } set { referencedAssemblies = value; EmitPropertyChanged("ReferencedAssemblies"); } }
        #endregion

        #region Private Fields
        #endregion

        protected void EmitPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged.Invoke(this, new PropertyChangedEventArgs(propertyName));
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
    #endregion

    #region AssemblyDataCollection Class
    /// <summary>
    /// A collection of Manager objects.
    /// </summary>
    public partial class AssemblyDataCollection : ObservableCollection<AssemblyData>
    {
        /// <summary>
        /// Initializes an empty collection.
        /// </summary>
        public AssemblyDataCollection() { }

        /// <summary>
        /// Initializes the collection from another collection.
        /// </summary>
        /// <param name="collection">A collection of values to add to this new collection</param>
        /// <exception cref="T:System.ArgumentNullException">
        /// 	<paramref name="collection"/> is null.
        /// </exception>
        public AssemblyDataCollection(IEnumerable<AssemblyData> collection) : base(collection) { }

        /// <summary>
        /// Initializes the collection with the specified capacity.
        /// </summary>
        /// <param name="capacity">The capacity.</param>
        public AssemblyDataCollection(List<AssemblyData> capacity) : base(capacity) { }

        public static string[] CreateList(AssemblyDataCollection input)
        {
            int counter = 0;

            List<string> items = new List<string>();
            if (input != null)
            {
                foreach (var item in input)
                {
                    if (item.IsSelected)
                    {
                        switch (item.Framework)
                        {
                            case Const.Framework.Runtime: counter++; break;
                            case Const.Framework.All: break;
                            default:
                                throw new InvalidOperationException(string.Format("Framework {0} is not valid", item.Framework));
                        }

                        items.Add(item.FolderName);
                    }
                }
            }

            return items.ToArray();
        }
    }
    #endregion

    #region EndOperationEventArgs class
    public class EndOperationEventArgs : EventArgs
    {
        public EndOperationEventArgs(string report, bool failed)
        {
            Report = report;
            Failed = failed;
        }

        public string Report { get; private set; }
        public bool Failed { get; private set; }
    }
    #endregion

    #region CommonEventArgs Class

    [Serializable]
    public class CommonEventArgs : EventArgs
    {
        public CommonEventArgs()
        {
        }

        public CommonEventArgs(LogLevel logLevel)
        {
            LogLevel = logLevel;
        }

        public JobTypes JobType { get; set; }
        public LogLevel LogLevel { get; set; }
        public string RootFolder { get; set; }
        public bool SplitFolderByAssembly { get; set; }
    }

    #endregion

    #region FolderBuilderEventArgs Class
    [Serializable]
    public class FolderBuilderEventArgs : CommonEventArgs
    {
        public FolderBuilderEventArgs()
        {
        }

        public FolderBuilderEventArgs(LogLevel logLevel)
            : base(logLevel)
        {
        }

        public string SourceFolder { get; set; }
    }
    #endregion

    #region JavaBuilderEventArgs Class
    [Serializable]
    public class JavaBuilderEventArgs : FolderBuilderEventArgs
    {
        public JavaBuilderEventArgs()
        {
        }

        public JavaBuilderEventArgs(LogLevel logLevel)
            : base(logLevel)
        {
        }

        public string JDKFolder { get; set; }
        public JDKVersion JDKTarget { get; set; }
        public string[] AssembliesToUse { get; set; }
        public string JDKToolExtraOptions { get; set; }
    }
    #endregion

    #region DocsBuilderEventArgs Class

    [Serializable]
    public class DocsBuilderEventArgs : JavaBuilderEventArgs
    {
        public DocsBuilderEventArgs()
        {
        }

        public DocsBuilderEventArgs(LogLevel logLevel)
            : base(logLevel)
        {
        }

        public string CommitVersion { get; set; }
    }

    #endregion

    #region JARBuilderEventArgs Class

    [Serializable]
    public class JARBuilderEventArgs : JavaBuilderEventArgs
    {
        public JARBuilderEventArgs()
        {
        }

        public JARBuilderEventArgs(LogLevel logLevel)
            : base(logLevel)
        {
        }

        public string JarDestinationFolder { get; set; }
        public bool WithJARSource { get; set; }
        public bool EmbeddingJCOBridge { get; set; }
    }

    #endregion

    #region POMBuilderEventArgs Class

    [Serializable]
    public class POMBuilderEventArgs : JavaBuilderEventArgs
    {
        public POMBuilderEventArgs()
        {
            POMVersion = Const.ReflectorVersion;
            POMType = POMType.Frameworks;
            POMVersionType = POMVersionType.Snapshot;
        }

        public POMBuilderEventArgs(LogLevel logLevel)
            : base(logLevel)
        {
            POMType = POMType.Frameworks;
            POMVersionType = POMVersionType.Snapshot;
        }

        public string POMArtifactId { get; set; }

        public string POMName { get; set; }

        public string POMFileName { get; set; }

        public string POMDescription { get; set; }

        public string POMVersion { get; set; }

        public POMType POMType { get; set; }

        public POMVersionType POMVersionType { get; set; }
    }

    #endregion

    #region ReflectorEventArgs Class

    [Serializable]
    public class ReflectorEventArgs : CommonEventArgs
    {

        public ReflectorEventArgs()
        {
        }

        public ReflectorEventArgs(LogLevel logLevel)
            : base(logLevel)
        {
        }

        public string[] AssemblyNames { get; set; }
        public string SourceDestinationFolder { get; set; }
        public bool ForceRebuild { get; set; }
        public bool UseParallelBuild { get; set; }
        public bool AvoidHierarchyTraversing { get; set; }
        public bool CreateExceptionThrownClause { get; set; }
        public int ExceptionThrownClauseDepth { get; set; }
        public bool EnableAbstract { get; set; }
        public bool EnableArray { get; set; }
        public bool EnableDuplicateMethodNativeArrayWithJCRefOut { get; set; }
        public bool EnableInheritance { get; set; }
        public bool EnableInterfaceInheritance { get; set; }
        public bool EnableRefOutParameters { get; set; }
        public bool DryRun { get; set; }
        public bool AvoidReportAndStatistics { get; set; }
    }
    #endregion
}
