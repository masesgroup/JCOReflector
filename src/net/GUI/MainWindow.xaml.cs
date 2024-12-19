/*
 *  MIT License
 *
 *  Copyright (c) 2024 MASES s.r.l.
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

using MASES.JCOReflectorEngine;
using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace MASES.JCOReflectorGUI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public string SourceDestinationFolder
        {
            get { return (string)GetValue(SourceDestinationFolderProperty); }
            set { SetValue(SourceDestinationFolderProperty, value); }
        }

        // Using a DependencyProperty as the backing store for RepositoryRoot.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty SourceDestinationFolderProperty =
            DependencyProperty.Register("SourceDestinationFolder", typeof(string), typeof(MainWindow), new PropertyMetadata(JobManager.SourceFolder));

        public string JarDestinationFolder
        {
            get { return (string)GetValue(JarDestinationFolderProperty); }
            set { SetValue(JarDestinationFolderProperty, value); }
        }

        // Using a DependencyProperty as the backing store for RepositoryRoot.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty JarDestinationFolderProperty =
            DependencyProperty.Register("JarDestinationFolder", typeof(string), typeof(MainWindow), new PropertyMetadata(JobManager.JarDestinationFolder));

        public AssemblyDataCollection AssemblyCollection
        {
            get { return (AssemblyDataCollection)GetValue(AssemblyCollectionProperty); }
            set { SetValue(AssemblyCollectionProperty, value); }
        }

        // Using a DependencyProperty as the backing store for UserNodeIds.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty AssemblyCollectionProperty =
            DependencyProperty.Register("AssemblyCollection", typeof(AssemblyDataCollection), typeof(MainWindow));

        public int MaxDepth
        {
            get { return (int)GetValue(MaxDepthProperty); }
            set { SetValue(MaxDepthProperty, value); }
        }

        // Using a DependencyProperty as the backing store for MaxDepth.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty MaxDepthProperty =
            DependencyProperty.Register("MaxDepth", typeof(int), typeof(MainWindow), new PropertyMetadata(10));

        public bool EnableAbstract
        {
            get { return (bool)GetValue(EnableAbstractProperty); }
            set { SetValue(EnableAbstractProperty, value); }
        }

        // Using a DependencyProperty as the backing store for EnableAbstract.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty EnableAbstractProperty =
            DependencyProperty.Register("EnableAbstract", typeof(bool), typeof(MainWindow), new PropertyMetadata(true));

        public bool EnableInheritance
        {
            get { return (bool)GetValue(EnableInheritanceProperty); }
            set { SetValue(EnableInheritanceProperty, value); }
        }

        // Using a DependencyProperty as the backing store for EnableAbstract.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty EnableInheritanceProperty =
            DependencyProperty.Register("EnableInheritance", typeof(bool), typeof(MainWindow), new PropertyMetadata(true));

        public bool EnableRefOutParameters
        {
            get { return (bool)GetValue(EnableRefOutParametersProperty); }
            set { SetValue(EnableRefOutParametersProperty, value); }
        }

        // Using a DependencyProperty as the backing store for EnableAbstract.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty EnableRefOutParametersProperty =
            DependencyProperty.Register("EnableRefOutParameters", typeof(bool), typeof(MainWindow), new PropertyMetadata(false));

        public MainWindow()
        {
            InitializeComponent();

#if NET6_0
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET 6)";

            tbAssemblyNames.Text += "PresentationFramework";
#elif NET7_0
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET 7)";

            tbAssemblyNames.Text += "PresentationFramework";
#elif NET8_0
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET 8)";

            tbAssemblyNames.Text += "PresentationFramework";
#elif NET9_0
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET 9)";

            tbAssemblyNames.Text += "PresentationFramework";
#elif NETFRAMEWORK
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (.NET Framework)";

            tbAssemblyNames.Text += "PresentationFramework,Version=4.0.0.0,Culture=neutral,PublicKeyToken=31bf3856ad364e35" + Environment.NewLine +
                                    "System.ServiceModel, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = b77a5c561934e089" + Environment.NewLine +
                                    "System.Data.Entity, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = b77a5c561934e089" + Environment.NewLine +
                                    "System.Activities.Presentation, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = 31bf3856ad364e35" + Environment.NewLine +
                                    "System.Net, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = b03f5f7f11d50a3a" + Environment.NewLine +
                                    "System.Workflow.Runtime, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = 31bf3856ad364e35";
#else
#error Unable to identify .NET engine
#endif

            Title += " Version " + typeof(MainWindow).Assembly.GetName().Version.ToString();

            cbTarget.ItemsSource = Enum.GetValues(typeof(JDKVersion));
            cbTarget.SelectedValue = JDKVersion.Version8;

            cbLogLevel.ItemsSource = Enum.GetValues(typeof(LogLevel));
            cbLogLevel.SelectedValue = LogLevel.Info;
#if DEBUG
            tbJDKFolder.Text = "jdk-14.0.1";
#endif
            JobManager.SetHandler(appendToConsole, endOperation);
        }

        private void btnClear_Click(object sender, RoutedEventArgs e)
        {
            tbConsole.Text = string.Empty;
        }

        private void btnExecute_Click(object sender, RoutedEventArgs e)
        {
            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;

            ReflectorEventArgs args = new ReflectorEventArgs((LogLevel)cbLogLevel.SelectedValue)
            {
                JobType = JobTypes.Reflect,
                AssemblyNames = string.IsNullOrEmpty(tbAssemblyNames.Text) ? new List<string>().ToArray() : tbAssemblyNames.Text.Replace("\r", "").Split('\n'),
                SourceFolder = SourceDestinationFolder,
                SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value,
                ForceRebuild = cbForceRebuildIfFolderExist.IsChecked.Value,
                UseParallelBuild = cbUseParallel.IsChecked.Value,
                CreateExceptionThrownClause = cbExportExceptions.IsChecked.Value,
                ExceptionThrownClauseDepth = MaxDepth,
                EnableAbstract = cbExportAbstract.IsChecked.Value,
                EnableArray = cbExportArray.IsChecked.Value,
                EnableDuplicateMethodNativeArrayWithJCRefOut = cbDuplicateMethodNativeArray.IsChecked.Value,
                EnableInheritance = cbEnableInheritance.IsChecked.Value,
                EnableInterfaceInheritance = cbEnableInterfaceInheritance.IsChecked.Value,
                EnableRefOutParameters = cbEnableRefOutParameters.IsChecked.Value,
                AvoidDisableInternalNamespace = cbAvoidDisableInternalNamespace.IsChecked.Value,
                DryRun = cbDryRun.IsChecked.Value
            };

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            JobManager.RunJob(args);
        }

        private void btnGetFolders_Click(object sender, RoutedEventArgs e)
        {
            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;

            FolderBuilderEventArgs args = new FolderBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue);
            args.SourceFolder = SourceDestinationFolder;
            args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            var result = JobManager.CreateFolderList(args);

            AssemblyCollection = result;
        }

        private void btnBuild_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                JavaBuilderEventArgs args = new JavaBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue)
                {
                    JobType = JobTypes.Build,
                    JDKFolder = tbJDKFolder.Text,
                    JDKTarget = (JDKVersion)cbTarget.SelectedValue,
                    JDKToolExtraOptions = tbJDKToolExtraOptions.Text,
                    SourceFolder = SourceDestinationFolder,
                    SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value,
                    AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyCollection)
                };

                if (cbExportToFile.IsChecked.Value)
                {
                    export(args);
                    if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
                }

                commandPanel.IsEnabled = false;
                btnStop.Visibility = Visibility.Visible;
                JobManager.RunJob(args);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void btnBuildDoc_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                DocsBuilderEventArgs args = new DocsBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue)
                {
                    JobType = JobTypes.BuildDocs,
                    JDKFolder = tbJDKFolder.Text,
                    JDKTarget = (JDKVersion)cbTarget.SelectedValue,
                    JDKToolExtraOptions = tbJDKToolExtraOptions.Text,
                    SourceFolder = SourceDestinationFolder,
                    SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value,
                    AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyCollection),
                    CommitVersion = tbCommitVersion.Text
                };

                if (cbExportToFile.IsChecked.Value)
                {
                    export(args);
                    if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
                }

                commandPanel.IsEnabled = false;
                btnStop.Visibility = Visibility.Visible;
                JobManager.RunJob(args);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void btnCreateJars_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                JARBuilderEventArgs args = new JARBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue)
                {
                    JobType = JobTypes.CreateJars,
                    JDKFolder = tbJDKFolder.Text,
                    JDKToolExtraOptions = tbJDKToolExtraOptions.Text,
                    SourceFolder = SourceDestinationFolder,
                    JarDestinationFolder = JarDestinationFolder,
                    SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value,
                    WithJARSource = cbWithSource.IsChecked.Value,
                    EmbeddingJCOBridge = cbWithEmbedding.IsChecked.Value,

                    AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyCollection)
                };

                if (cbExportToFile.IsChecked.Value)
                {
                    export(args);
                    if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
                }

                commandPanel.IsEnabled = false;
                btnStop.Visibility = Visibility.Visible;
                JobManager.RunJob(args);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void btnGenerateSnapshotPOM_Click(object sender, RoutedEventArgs e)
        {
            POMBuilderEventArgs args = new POMBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue)
            {
                JobType = JobTypes.CreatePOM,
                JDKFolder = tbJDKFolder.Text,
                JDKToolExtraOptions = tbJDKToolExtraOptions.Text,
                SourceFolder = SourceDestinationFolder,
                SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value,
                AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyCollection)
            };

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;
            JobManager.RunJob(args);
        }

        private void btnGeneratePOM_Click(object sender, RoutedEventArgs e)
        {
            POMBuilderEventArgs args = new POMBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue)
            {
                JobType = JobTypes.CreatePOM,
                JDKFolder = tbJDKFolder.Text,
                JDKToolExtraOptions = tbJDKToolExtraOptions.Text,
                SourceFolder = SourceDestinationFolder,
                SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value,
                POMStagingType = POMStagingType.Release,
                AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyCollection)
            };

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;
            JobManager.RunJob(args);
        }

        private void btnExtractPOM_Click(object sender, RoutedEventArgs e)
        {
            POMBuilderEventArgs args = new POMBuilderEventArgs((LogLevel)cbLogLevel.SelectedValue)
            {
                JobType = JobTypes.ExtractPOM,
                POMFileName = tbPOMFileName.Text
            };

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;
            JobManager.RunJob(args);
        }

        public delegate void appendToConsoleDelegate(TextBox myControl, string format, object[] args);

        void appendToConsole(string format, params object[] args)
        {
            object[] myArray = new object[3];

            myArray[0] = tbConsole;
            myArray[1] = format;
            myArray[2] = args;

            this.Dispatcher.BeginInvoke(new appendToConsoleDelegate(appendToConsoleDispatcher), myArray);
        }

        void appendToConsoleDispatcher(TextBox console, string format, object[] args)
        {
            console.Text += ((args != null && args.Length != 0) ? string.Format(format, args) : format) + Environment.NewLine;
        }

        void endOperation(object sender, EndOperationEventArgs args)
        {
            this.Dispatcher.Invoke(() =>
            {
                commandPanel.IsEnabled = true;
                btnStop.Visibility = Visibility.Collapsed;
                if (args != null)
                {
                    tbReport.Text = args.Report;
                    if (args.Failed)
                    {
                        MessageBox.Show("Operation failed, check console for error.");
                    }
                }
                else tbReport.Text = "Missing managed event args.";
            });
        }

        private void tbConsole_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (!cbPinConsole.IsChecked.Value)
            {
                tbConsole.CaretIndex = tbConsole.Text.Length;
                tbConsole.ScrollToEnd();
            }
        }

        private void btnStop_Click(object sender, RoutedEventArgs e)
        {
            JobManager.CancelJob();
        }

        bool export<T>(T type) where T : class
        {
            Microsoft.Win32.SaveFileDialog sfd = new Microsoft.Win32.SaveFileDialog();
            sfd.InitialDirectory = JobManager.RootFolder;
            sfd.FileName = typeof(T).Name;
            bool result = false;
            try
            {
                var res = sfd.ShowDialog();

                result = res.HasValue ? res.Value : false;

                if (result)
                {
                    JobManager.Export(type, sfd.FileName);
                }

            }
            catch (Exception e)
            {
                MessageBox.Show(e.Message, string.Empty, MessageBoxButton.OK, MessageBoxImage.Error);
            }

            return result;
        }
    }
}
