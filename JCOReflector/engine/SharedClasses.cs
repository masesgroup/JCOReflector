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
        CreateSnapshotPOM,
        CreateReleasePOM,
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
            Parser.DefaultType = ArgumentType.Double;
            arguments = prepareArguments();
            arguments.Add();
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

        public const string PARAM_File = "JobFile";

        // CommonArgs
        public const string PARAM_JobType = "JobType";
        public const string PARAM_LogLevel = "LogLevel";
        public const string PARAM_RootFolder = "RootFolder";
        public const string PARAM_SplitFolderByAssembly = "SplitFolderByAssembly";

        // FolderBuilderEventArgs
        public const string PARAM_SourceFolder = "SourceFolder";

        // ReflectorEventArgs
        public const string PARAM_Assembly = "Assembly";
        public const string PARAM_SourceDestinationFolder = "SourceDestinationFolder";
        public const string PARAM_ForceRebuild = "ForceRebuild";
        public const string PARAM_UseParallelBuild = "UseParallelBuild";
        public const string PARAM_AvoidHierarchyTraversing = "AvoidHierarchyTraversing";
        public const string PARAM_CreateExceptionThrownClause = "CreateExceptionThrownClause";
        public const string PARAM_ExceptionThrownClauseDepth = "ExceptionThrownClauseDepth";
        public const string PARAM_EnableAbstract = "EnableAbstract";
        public const string PARAM_EnableArray = "EnableArray";
        public const string PARAM_EnableDuplicateMethodNativeArrayWithJCRefOut = "EnableDuplicateMethodNativeArrayWithJCRefOut";
        public const string PARAM_EnableInheritance = "EnableInheritance";
        public const string PARAM_EnableInterfaceInheritance = "EnableInterfaceInheritance";
        public const string PARAM_EnableRefOutParameters = "EnableRefOutParameters";
        public const string PARAM_DryRun = "DryRun";
        public const string PARAM_AvoidReportAndStatistics = "AvoidReportAndStatistics";

        // JavaBuilderEventArgs
        public const string PARAM_JDKFolder = "JDKFolder";
        public const string PARAM_JDKTarget = "JDKTarget";
        public const string PARAM_AssembliesToUse = "AssembliesToUse";
        public const string PARAM_JDKToolExtraOptions = "JDKToolExtraOptions";

        // DocsBuilderEventArgs
        public const string PARAM_CommitVersion = "CommitVersion";

        // JARBuilderEventArgs
        public const string PARAM_JarDestinationFolder = "JarDestinationFolder";
        public const string PARAM_WithJARSource = "WithJARSource";
        public const string PARAM_EmbeddingJCOBridge = "EmbeddingJCOBridge";

        static IArgumentMetadata[] arguments = null;
        static IArgumentMetadata[] prepareArguments()
        {
            return new IArgumentMetadata[]
            {
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_File,
                    Default = null,
                    Help = "The file containing the serialized job to run.",
                },
                new ArgumentMetadata<JobTypes>()
                {
                    Name = PARAM_JobType,
                    IsMandatory = true,
                    Help = "The job to execute.",
                },
                new ArgumentMetadata<LogLevel>()
                {
                    Name = PARAM_LogLevel,
                    Default = LogLevel.Error,
                    Help = "The error level to report.",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_RootFolder,
                    Default = RootFolder,
                    Help = "The root folder.",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_SplitFolderByAssembly,
                    Default = true,
                    Help = "True to split the reflected class into folder with the name equals to the name of assembly containing the class.",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_SourceFolder,
                    Default = SourceDestinationFolder,
                    Help = "The foldercontaining the reflected classes (used from any JobType expect JobType.Reflect).",
                },
                // reflector arguments
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_Assembly,
                    IsMultiValue = true,
                    Default = ArgumentMetadata<string>.DefaultMultiValue,
                    Help = "The list of assembly name to parse (used from JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_SourceDestinationFolder,
                    Default = SourceDestinationFolder,
                    Help = "The destination folder where store the reflected classes (used from JobType.Reflect).",
                },

                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_ForceRebuild,
                    Default = true,
                    Help = "Force rebuild even if the assembly folder is in the SourceDestinationFolder (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_UseParallelBuild,
                    Default = true,
                    Help = "Optimize use of processors with a parallel execution (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_AvoidHierarchyTraversing,
                    Default = true,
                    Help = "Avoid the traversing of the assemblies dependency hierarchy (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_CreateExceptionThrownClause,
                    Default = true,
                    Help = "Analyze and add exception in the methods declaration (used from JobType.Reflect).",
                },
                new ArgumentMetadata<int>()
                {
                    Name = PARAM_ExceptionThrownClauseDepth,
                    Default = 10,
                    ValueType = ArgumentValueType.Range,
                    MinValue = 0,
                    MaxValue = int.MaxValue,
                    Help = "The maximum analysis depth when searching for exception (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EnableAbstract,
                    Default = true,
                    Help = "Enable abstract classes (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EnableArray,
                    Default = true,
                    Help = "Enable array declaration (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EnableDuplicateMethodNativeArrayWithJCRefOut,
                    Default = true,
                    Help = "Duplicates methods which has array of native types to reproduce the same behavior of .NET (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EnableInheritance,
                    Default = true,
                    Help = "Enable class inheritance (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EnableInterfaceInheritance,
                    Default = true,
                    Help = "Enable interface inheritance (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EnableRefOutParameters,
                    Default = true,
                    Help = "Enable management of ref and out parameters (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_DryRun,
                    Default = false,
                    Help = "Do not write anything (used from JobType.Reflect).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_AvoidReportAndStatistics,
                    Default = false,
                    Help = "Do not write report and statistics (used from JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_JDKFolder,
                    Default = null,
                    Help = "The folder containing the JDK, it is used to find JDK tools (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<JDKVersion>()
                {
                    Name = PARAM_JDKTarget,
                    Default = JDKVersion.Version8,
                    Help = "The java version used when class are generated (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_AssembliesToUse,
                    Default = ArgumentMetadata<string>.DefaultMultiValue,
                    IsMultiValue = true,
                    Help = "The list of assemblies, the one previously reflected, to be used in the operation (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_JDKToolExtraOptions,
                    Default = string.Empty,
                    Help = "Extra options to be passed to the JDK tools (used from any JobType expect JobType.Reflect).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_CommitVersion,
                    Default = string.Empty,
                    Help = "The commit version (used from JobType.BuildDocs).",
                },
                new ArgumentMetadata<string>()
                {
                    Name = PARAM_JarDestinationFolder,
                    Default = string.Empty,
                    Help = "Destination folder where store JarFile (used from JobType.CreateJars).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_WithJARSource,
                    Default = false,
                    Help = "Create the source Jar (used from JobType.CreateJars).",
                },
                new ArgumentMetadata<bool>()
                {
                    Name = PARAM_EmbeddingJCOBridge,
                    Default = true,
                    Help = "Embed JCOBridge engine within JCOReflector.jar (used from JobType.CreateJars).",
                },
            };
        }
        /// <summary>
        /// Returns the help info for parameters
        /// </summary>
        /// <returns></returns>
        public static string GetArgumentHelp()
        {
            int newPadding = Parser.PaddingFromArguments();
            Parser.DefaultDescriptionPadding = newPadding;
            return Parser.HelpInfo();
        }
        /// <summary>
        /// Convert arguments into an instance of <see cref="CommonEventArgs"/>
        /// </summary>
        /// <param name="args">Arguments from command line</param>
        /// <returns>An instance of <see cref="CommonEventArgs"/></returns>
        public static CommonEventArgs FromArgs(this string[] args)
        {
            var resultingArgs = args.Parse();

            var jobType = resultingArgs.Get<JobTypes>(PARAM_JobType);
            CommonEventArgs arg = null;
            if (resultingArgs.Exist(PARAM_File))
            {
                arg = ConvertFile(jobType, resultingArgs.Get<string>(PARAM_File));
            }

            if (arg != null)
            {
                arg.JobType = jobType;
            }

            if (jobType == JobTypes.NoType) throw new InvalidOperationException("No JobType neighter in file nor in command line");

            switch (jobType)
            {
                case JobTypes.Reflect:
                    {
                        ReflectorEventArgs newArg;
                        if (arg == null) newArg = new ReflectorEventArgs();
                        else newArg = arg as ReflectorEventArgs;
                        if (resultingArgs.Exist(PARAM_LogLevel))
                        {
                            newArg.LogLevel = resultingArgs.Get<LogLevel>(PARAM_LogLevel);
                        }
                        if (resultingArgs.Exist(PARAM_RootFolder))
                        {
                            newArg.RootFolder = resultingArgs.Get<string>(PARAM_RootFolder);
                        }
                        if (resultingArgs.Exist(PARAM_SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = resultingArgs.Get<bool>(PARAM_SplitFolderByAssembly);
                        }
                        List<string> assemblies = new List<string>();
                        if (newArg.AssemblyNames != null) assemblies.AddRange(newArg.AssemblyNames);
                        if (resultingArgs.Exist(PARAM_Assembly))
                        {
                            assemblies.AddRange(resultingArgs.Get<IEnumerable<string>>(PARAM_Assembly));
                        }
                        newArg.AssemblyNames = assemblies.ToArray();
                        if (resultingArgs.Exist(PARAM_SourceDestinationFolder))
                        {
                            newArg.SourceDestinationFolder = resultingArgs.Get<string>(PARAM_SourceDestinationFolder);
                        }
                        if (resultingArgs.Exist(PARAM_ForceRebuild))
                        {
                            newArg.ForceRebuild = resultingArgs.Get<bool>(PARAM_ForceRebuild);
                        }
                        if (resultingArgs.Exist(PARAM_UseParallelBuild))
                        {
                            newArg.UseParallelBuild = resultingArgs.Get<bool>(PARAM_UseParallelBuild);
                        }
                        if (resultingArgs.Exist(PARAM_AvoidHierarchyTraversing))
                        {
                            newArg.AvoidHierarchyTraversing = resultingArgs.Get<bool>(PARAM_AvoidHierarchyTraversing);
                        }
                        if (resultingArgs.Exist(PARAM_CreateExceptionThrownClause))
                        {
                            newArg.CreateExceptionThrownClause = resultingArgs.Get<bool>(PARAM_CreateExceptionThrownClause);
                        }
                        if (resultingArgs.Exist(PARAM_ExceptionThrownClauseDepth))
                        {
                            newArg.ExceptionThrownClauseDepth = resultingArgs.Get<int>(PARAM_ExceptionThrownClauseDepth);
                        }
                        if (resultingArgs.Exist(PARAM_EnableAbstract))
                        {
                            newArg.EnableAbstract = resultingArgs.Get<bool>(PARAM_EnableAbstract);
                        }
                        if (resultingArgs.Exist(PARAM_EnableArray))
                        {
                            newArg.EnableArray = resultingArgs.Get<bool>(PARAM_EnableArray);
                        }
                        if (resultingArgs.Exist(PARAM_EnableDuplicateMethodNativeArrayWithJCRefOut))
                        {
                            newArg.EnableDuplicateMethodNativeArrayWithJCRefOut = resultingArgs.Get<bool>(PARAM_EnableDuplicateMethodNativeArrayWithJCRefOut);
                        }
                        if (resultingArgs.Exist(PARAM_EnableInheritance))
                        {
                            newArg.EnableInheritance = resultingArgs.Get<bool>(PARAM_EnableInheritance);
                        }
                        if (resultingArgs.Exist(PARAM_EnableInterfaceInheritance))
                        {
                            newArg.EnableInterfaceInheritance = resultingArgs.Get<bool>(PARAM_EnableInterfaceInheritance);
                        }
                        if (resultingArgs.Exist(PARAM_EnableRefOutParameters))
                        {
                            newArg.EnableRefOutParameters = resultingArgs.Get<bool>(PARAM_EnableRefOutParameters);
                        }
                        if (resultingArgs.Exist(PARAM_DryRun))
                        {
                            newArg.DryRun = resultingArgs.Get<bool>(PARAM_DryRun);
                        }
                        if (resultingArgs.Exist(PARAM_AvoidReportAndStatistics))
                        {
                            newArg.AvoidReportAndStatistics = resultingArgs.Get<bool>(PARAM_AvoidReportAndStatistics);
                        }
                    }
                    break;
                case JobTypes.Build:
                    {
                        JavaBuilderEventArgs newArg;
                        if (arg == null) newArg = new JavaBuilderEventArgs();
                        else newArg = arg as JavaBuilderEventArgs;

                        if (resultingArgs.Exist(PARAM_LogLevel))
                        {
                            newArg.LogLevel = resultingArgs.Get<LogLevel>(PARAM_LogLevel);
                        }
                        if (resultingArgs.Exist(PARAM_RootFolder))
                        {
                            newArg.RootFolder = resultingArgs.Get<string>(PARAM_RootFolder);
                        }
                        if (resultingArgs.Exist(PARAM_SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = resultingArgs.Get<bool>(PARAM_SplitFolderByAssembly);
                        }

                        if (resultingArgs.Exist(PARAM_SourceFolder))
                        {
                            newArg.SourceFolder = resultingArgs.Get<string>(PARAM_SourceFolder);
                        }

                        if (resultingArgs.Exist(PARAM_JDKFolder))
                        {
                            newArg.JDKFolder = resultingArgs.Get<string>(PARAM_JDKFolder);
                        }
                        if (resultingArgs.Exist(PARAM_JDKTarget))
                        {
                            newArg.JDKTarget = resultingArgs.Get<JDKVersion>(PARAM_JDKTarget);
                        }
                        if (resultingArgs.Exist(PARAM_AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(resultingArgs.Get<IEnumerable<string>>(PARAM_AssembliesToUse)).ToArray();
                        }
                        if (resultingArgs.Exist(PARAM_JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = resultingArgs.Get<string>(PARAM_JDKToolExtraOptions);
                        }
                    }
                    break;
                case JobTypes.BuildDocs:
                    {
                        DocsBuilderEventArgs newArg;
                        if (arg == null) newArg = new DocsBuilderEventArgs();
                        else newArg = arg as DocsBuilderEventArgs;

                        if (resultingArgs.Exist(PARAM_LogLevel))
                        {
                            newArg.LogLevel = resultingArgs.Get<LogLevel>(PARAM_LogLevel);
                        }
                        if (resultingArgs.Exist(PARAM_RootFolder))
                        {
                            newArg.RootFolder = resultingArgs.Get<string>(PARAM_RootFolder);
                        }
                        if (resultingArgs.Exist(PARAM_SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = resultingArgs.Get<bool>(PARAM_SplitFolderByAssembly);
                        }


                        if (resultingArgs.Exist(PARAM_SourceFolder))
                        {
                            newArg.SourceFolder = resultingArgs.Get<string>(PARAM_SourceFolder);
                        }

                        if (resultingArgs.Exist(PARAM_JDKFolder))
                        {
                            newArg.JDKFolder = resultingArgs.Get<string>(PARAM_JDKFolder);
                        }
                        if (resultingArgs.Exist(PARAM_JDKTarget))
                        {
                            newArg.JDKTarget = resultingArgs.Get<JDKVersion>(PARAM_JDKTarget);
                        }
                        if (resultingArgs.Exist(PARAM_AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(resultingArgs.Get<IEnumerable<string>>(PARAM_AssembliesToUse)).ToArray();
                        }
                        if (resultingArgs.Exist(PARAM_JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = resultingArgs.Get<string>(PARAM_JDKToolExtraOptions);
                        }

                        if (resultingArgs.Exist(PARAM_CommitVersion))
                        {
                            newArg.CommitVersion = resultingArgs.Get<string>(PARAM_CommitVersion);
                        }
                    }
                    break;
                case JobTypes.CreateJars:
                    {
                        JARBuilderEventArgs newArg;
                        if (arg == null) newArg = new JARBuilderEventArgs();
                        else newArg = arg as JARBuilderEventArgs;

                        if (resultingArgs.Exist(PARAM_LogLevel))
                        {
                            newArg.LogLevel = resultingArgs.Get<LogLevel>(PARAM_LogLevel);
                        }
                        if (resultingArgs.Exist(PARAM_RootFolder))
                        {
                            newArg.RootFolder = resultingArgs.Get<string>(PARAM_RootFolder);
                        }
                        if (resultingArgs.Exist(PARAM_SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = resultingArgs.Get<bool>(PARAM_SplitFolderByAssembly);
                        }

                        if (resultingArgs.Exist(PARAM_SourceFolder))
                        {
                            newArg.SourceFolder = resultingArgs.Get<string>(PARAM_SourceFolder);
                        }

                        if (resultingArgs.Exist(PARAM_JDKFolder))
                        {
                            newArg.JDKFolder = resultingArgs.Get<string>(PARAM_JDKFolder);
                        }
                        if (resultingArgs.Exist(PARAM_JDKTarget))
                        {
                            newArg.JDKTarget = resultingArgs.Get<JDKVersion>(PARAM_JDKTarget);
                        }
                        if (resultingArgs.Exist(PARAM_AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(resultingArgs.Get<IEnumerable<string>>(PARAM_AssembliesToUse)).ToArray();
                        }
                        if (resultingArgs.Exist(PARAM_JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = resultingArgs.Get<string>(PARAM_JDKToolExtraOptions);
                        }

                        if (resultingArgs.Exist(PARAM_JarDestinationFolder))
                        {
                            newArg.JarDestinationFolder = resultingArgs.Get<string>(PARAM_JarDestinationFolder);
                        }

                        if (resultingArgs.Exist(PARAM_WithJARSource))
                        {
                            newArg.WithJARSource = resultingArgs.Get<bool>(PARAM_WithJARSource);
                        }

                        if (resultingArgs.Exist(PARAM_EmbeddingJCOBridge))
                        {
                            newArg.EmbeddingJCOBridge = resultingArgs.Get<bool>(PARAM_EmbeddingJCOBridge);
                        }

                        newArg.GeneratePOM = JARBuilderEventArgs.POMType.NoPOM;
                    }
                    break;
                case JobTypes.CreateSnapshotPOM:
                    {
                        JARBuilderEventArgs newArg;
                        if (arg == null) newArg = new JARBuilderEventArgs();
                        else newArg = arg as JARBuilderEventArgs;

                        if (resultingArgs.Exist(PARAM_LogLevel))
                        {
                            newArg.LogLevel = resultingArgs.Get<LogLevel>(PARAM_LogLevel);
                        }
                        if (resultingArgs.Exist(PARAM_RootFolder))
                        {
                            newArg.RootFolder = resultingArgs.Get<string>(PARAM_RootFolder);
                        }
                        if (resultingArgs.Exist(PARAM_SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = resultingArgs.Get<bool>(PARAM_SplitFolderByAssembly);
                        }

                        if (resultingArgs.Exist(PARAM_SourceFolder))
                        {
                            newArg.SourceFolder = resultingArgs.Get<string>(PARAM_SourceFolder);
                        }

                        if (resultingArgs.Exist(PARAM_JDKFolder))
                        {
                            newArg.JDKFolder = resultingArgs.Get<string>(PARAM_JDKFolder);
                        }
                        if (resultingArgs.Exist(PARAM_JDKTarget))
                        {
                            newArg.JDKTarget = resultingArgs.Get<JDKVersion>(PARAM_JDKTarget);
                        }
                        if (resultingArgs.Exist(PARAM_AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(resultingArgs.Get<IEnumerable<string>>(PARAM_AssembliesToUse)).ToArray();
                        }
                        if (resultingArgs.Exist(PARAM_JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = resultingArgs.Get<string>(PARAM_JDKToolExtraOptions);
                        }

                        if (resultingArgs.Exist(PARAM_JarDestinationFolder))
                        {
                            newArg.JarDestinationFolder = resultingArgs.Get<string>(PARAM_JarDestinationFolder);
                        }

                        if (resultingArgs.Exist(PARAM_WithJARSource))
                        {
                            newArg.WithJARSource = resultingArgs.Get<bool>(PARAM_WithJARSource);
                        }

                        if (resultingArgs.Exist(PARAM_EmbeddingJCOBridge))
                        {
                            newArg.EmbeddingJCOBridge = resultingArgs.Get<bool>(PARAM_EmbeddingJCOBridge);
                        }

                        newArg.GeneratePOM = JARBuilderEventArgs.POMType.Snapshot;
                    }
                    break;
                case JobTypes.CreateReleasePOM:
                    {
                        JARBuilderEventArgs newArg;
                        if (arg == null) newArg = new JARBuilderEventArgs();
                        else newArg = arg as JARBuilderEventArgs;

                        if (resultingArgs.Exist(PARAM_LogLevel))
                        {
                            newArg.LogLevel = resultingArgs.Get<LogLevel>(PARAM_LogLevel);
                        }
                        if (resultingArgs.Exist(PARAM_RootFolder))
                        {
                            newArg.RootFolder = resultingArgs.Get<string>(PARAM_RootFolder);
                        }
                        if (resultingArgs.Exist(PARAM_SplitFolderByAssembly))
                        {
                            newArg.SplitFolderByAssembly = resultingArgs.Get<bool>(PARAM_SplitFolderByAssembly);
                        }

                        if (resultingArgs.Exist(PARAM_SourceFolder))
                        {
                            newArg.SourceFolder = resultingArgs.Get<string>(PARAM_SourceFolder);
                        }

                        if (resultingArgs.Exist(PARAM_JDKFolder))
                        {
                            newArg.JDKFolder = resultingArgs.Get<string>(PARAM_JDKFolder);
                        }
                        if (resultingArgs.Exist(PARAM_JDKTarget))
                        {
                            newArg.JDKTarget = resultingArgs.Get<JDKVersion>(PARAM_JDKTarget);
                        }
                        if (resultingArgs.Exist(PARAM_AssembliesToUse))
                        {
                            newArg.AssembliesToUse = new List<string>(resultingArgs.Get<IEnumerable<string>>(PARAM_AssembliesToUse)).ToArray();
                        }
                        if (resultingArgs.Exist(PARAM_JDKToolExtraOptions))
                        {
                            newArg.JDKToolExtraOptions = resultingArgs.Get<string>(PARAM_JDKToolExtraOptions);
                        }

                        if (resultingArgs.Exist(PARAM_JarDestinationFolder))
                        {
                            newArg.JarDestinationFolder = resultingArgs.Get<string>(PARAM_JarDestinationFolder);
                        }

                        if (resultingArgs.Exist(PARAM_WithJARSource))
                        {
                            newArg.WithJARSource = resultingArgs.Get<bool>(PARAM_WithJARSource);
                        }

                        if (resultingArgs.Exist(PARAM_EmbeddingJCOBridge))
                        {
                            newArg.EmbeddingJCOBridge = resultingArgs.Get<bool>(PARAM_EmbeddingJCOBridge);
                        }

                        newArg.GeneratePOM = JARBuilderEventArgs.POMType.Release;
                    }
                    break;
                case JobTypes.NoType:
                default: throw new InvalidOperationException("No valid Job type.");
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
                case JobTypes.CreateSnapshotPOM:
                    return Import<JARBuilderEventArgs>(file);
                case JobTypes.CreateReleasePOM:
                    return Import<JARBuilderEventArgs>(file);
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
                case JobTypes.CreateSnapshotPOM:
                case JobTypes.CreateReleasePOM:
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

                        if (newArg.GeneratePOM == JARBuilderEventArgs.POMType.NoPOM)
                        {
                            newArg.GeneratePOM = (newArg.JobType == JobTypes.CreateSnapshotPOM) ? JARBuilderEventArgs.POMType.Snapshot : JARBuilderEventArgs.POMType.Release;
                        }

                        task = Task.Factory.StartNew(JavaBuilder.CreatePOM, newArg);
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
        public enum POMType
        {
            NoPOM,
            Release,
            Snapshot
        }

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
        public POMType GeneratePOM { get; set; }
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
