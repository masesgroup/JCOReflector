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
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Threading;

namespace MASES.C2JReflector
{
    public delegate void appendToConsoleHandler(string format, params object[] args);

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
        public EndOperationEventArgs(string report)
        {
            Report = report;
        }

        public EndOperationEventArgs(string report, string statisticsCsv)
        {
            Report = report;
            StatisticsCsv = statisticsCsv;
        }

        public string Report { get; private set; }
        public string StatisticsCsv { get; private set; }
    }
    #endregion

    #region CommonEventArgs Class

    [Serializable]
    public class CommonEventArgs : EventArgs
    {
        public CommonEventArgs()
        {
        }

        public CommonEventArgs(string rootFolder, LogLevel logLevel)
        {
            RootFolder = rootFolder;
            LogLevel = logLevel;
        }

        public CancellationToken CancellationToken { get; set; }
        public LogLevel LogLevel { get; set; }
        public string RootFolder { get; set; }
    }

    #endregion

    #region FolderBuilderEventArgs Class
    [Serializable]
    public class FolderBuilderEventArgs : CommonEventArgs
    {
        public FolderBuilderEventArgs()
        {
        }

        public FolderBuilderEventArgs(string rootFolder, LogLevel logLevel) 
            : base(rootFolder, logLevel)
        {
        }

        public string SourceFolder { get; set; }
        public bool SplitFolderByAssembly { get; set; }
    }
    #endregion

    #region JavaBuilderEventArgs Class
    [Serializable]
    public class JavaBuilderEventArgs : FolderBuilderEventArgs
    {
        public JavaBuilderEventArgs()
        {
        }

        public JavaBuilderEventArgs(string rootFolder, LogLevel logLevel) 
            : base(rootFolder, logLevel)
        {
        }

        public string JDKFolder { get; set; }
        public JDKVersion JDKTarget { get; set; }
        public string[] AssembliesToUse { get; set; }
    }
    #endregion

    #region JARBuilderEventArgs Class

    [Serializable]
    public class JARBuilderEventArgs : JavaBuilderEventArgs
    {
        public JARBuilderEventArgs()
        {
        }

        public JARBuilderEventArgs(string rootFolder, LogLevel logLevel) 
            : base(rootFolder, logLevel)
        {
        }

        public string JarDestinationFolder { get; set; }
        public bool WithJARSource { get; set; }
    }

    #endregion

    #region ReflectorEventArgs Class

    [Serializable]
    public class ReflectorEventArgs : CommonEventArgs
    {
        public ReflectorEventArgs()
        {
        }

        public ReflectorEventArgs(string rootFolder, LogLevel logLevel) 
            : base(rootFolder, logLevel)
        {
        }

        public string[] AssemblyNames { get; set; }
        public string SrcDestinationFolder { get; set; }
        public bool SplitFolderByAssembly { get; set; }
        public bool ForceRebuild { get; set; }
        public bool UseParallelBuild { get; set; }
        public bool CreateExceptionThrownClause { get; set; }
        public int ExceptionThrownClauseDepth { get; set; }
        public bool EnableAbstract { get; set; }
        public bool EnableArray { get; set; }
        public bool EnableDuplicateMethodNativeArrayWithJCRefOut { get; set; }
        public bool EnableInheritance { get; set; }
        public bool EnableInterfaceInheritance { get; set; }
        public bool DryRun { get; set; }
    }
    #endregion
}
