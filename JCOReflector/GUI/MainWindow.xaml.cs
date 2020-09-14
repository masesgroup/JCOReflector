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
using System.IO;
using System.Threading;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace MASES.C2JReflector
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        CancellationTokenSource cts = null;
        string assemblyLoc = typeof(MainWindow).Assembly.Location;

        public string RepositoryRoot
        {
            get { return (string)GetValue(RepositoryRootProperty); }
            set { SetValue(RepositoryRootProperty, value); }
        }

        // Using a DependencyProperty as the backing store for RepositoryRoot.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty RepositoryRootProperty =
            DependencyProperty.Register("RepositoryRoot", typeof(string), typeof(MainWindow), new PropertyMetadata(string.Empty));

        public AssemblyDataCollection AssemblyDataCollection
        {
            get { return (AssemblyDataCollection)GetValue(AssemblyDataCollectionProperty); }
            set { SetValue(AssemblyDataCollectionProperty, value); }
        }

        // Using a DependencyProperty as the backing store for UserNodeIds.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty AssemblyDataCollectionProperty =
            DependencyProperty.Register("AssemblyDataCollection", typeof(AssemblyDataCollection), typeof(MainWindow));

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

        public MainWindow()
        {
            InitializeComponent();
#if !NET_CORE
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (Framework)";
#else
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (CoreCLR)";
#endif

            Title += " Version " + typeof(MainWindow).Assembly.GetName().Version.ToString();

            assemblyLoc = Path.GetDirectoryName(assemblyLoc);
            RepositoryRoot = Path.GetFullPath(Path.Combine(assemblyLoc, @"..\..\"));

            cbTarget.ItemsSource = Enum.GetValues(typeof(JDKVersion));
            cbTarget.SelectedValue = JDKVersion.Version8;

            cbLogLevel.ItemsSource = Enum.GetValues(typeof(LogLevel));
            cbLogLevel.SelectedValue = LogLevel.Info;

            tbDestinationFolder.Text = Const.FileNameAndDirectory.RootDirectory;
            tbJarDestinationFolder.Text = Const.FileNameAndDirectory.GetRelativePath(assemblyLoc, RepositoryRoot);
#if DEBUG
            tbJDKFolder.Text = "jdk-14.0.1";
#endif
            Reflector.AppendToConsoleHandler = appendToConsole;
            Reflector.EndOperationHandler = endOperation;
            JavaBuilder.AppendToConsoleHandler = appendToConsole;
            JavaBuilder.EndOperationHandler = endOperation;
        }

        private void btnClear_Click(object sender, RoutedEventArgs e)
        {
            tbConsole.Text = string.Empty;
        }

        private void btnReset_Click(object sender, RoutedEventArgs e)
        {
            if (MessageBox.Show("Are you sure?", "Reset statistics", MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.No) == MessageBoxResult.Yes)
            {
                Task.Factory.StartNew(Reflector.ResetStatistics);
            }
        }

        private void btnExecute_Click(object sender, RoutedEventArgs e)
        {
            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;

            ReflectorEventArgs args = new ReflectorEventArgs(RepositoryRoot, (LogLevel)cbLogLevel.SelectedValue);
            cts = new CancellationTokenSource();
            args.CancellationToken = cts.Token;
            args.AssemblyNames = string.IsNullOrEmpty(tbAssemblyNames.Text) ? new List<string>().ToArray() : tbAssemblyNames.Text.Replace("\r", "").Split('\n');
            args.SrcDestinationFolder = Path.GetFullPath(tbDestinationFolder.Text);
            args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
            args.ForceRebuild = cbForceRebuildIfFolderExist.IsChecked.Value;
            args.UseParallelBuild = cbUseParallel.IsChecked.Value;
            args.CreateExceptionThrownClause = cbExportExceptions.IsChecked.Value;
            args.ExceptionThrownClauseDepth = MaxDepth;
            args.EnableAbstract = cbExportAbstract.IsChecked.Value;
            args.EnableArray = cbExportArray.IsChecked.Value;
            args.EnableDuplicateMethodNativeArrayWithJCRefOut = cbDuplicateMethodNativeArray.IsChecked.Value;
            args.EnableInheritance = cbEnableInheritance.IsChecked.Value;
            args.EnableInterfaceInheritance = cbEnableInterfaceInheritance.IsChecked.Value;
            args.DryRun = cbDryRun.IsChecked.Value;

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            Task.Factory.StartNew(Reflector.ExportAssembly, args);
        }

        private void btnGetFolders_Click(object sender, RoutedEventArgs e)
        {
            commandPanel.IsEnabled = false;
            btnStop.Visibility = Visibility.Visible;

            FolderBuilderEventArgs args = new FolderBuilderEventArgs(RepositoryRoot, (LogLevel)cbLogLevel.SelectedValue);
            args.SourceFolder = Path.GetFullPath(tbDestinationFolder.Text);
            args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;

            if (cbExportToFile.IsChecked.Value)
            {
                export(args);
                if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
            }

            var result = JavaBuilder.CreateFolderList(args);

            AssemblyDataCollection = result;
        }

        private void btnBuild_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                JavaBuilderEventArgs args = new JavaBuilderEventArgs(RepositoryRoot, (LogLevel)cbLogLevel.SelectedValue);
                cts = new CancellationTokenSource();
                args.CancellationToken = cts.Token;
                args.JDKFolder = tbJDKFolder.Text;
                args.JDKTarget = (JDKVersion)cbTarget.SelectedValue;
                args.SourceFolder = Path.GetFullPath(tbDestinationFolder.Text);
                args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
                args.AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyDataCollection);

                if (cbExportToFile.IsChecked.Value)
                {
                    export(args);
                    if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
                }

                commandPanel.IsEnabled = false;
                btnStop.Visibility = Visibility.Visible;
                Task.Factory.StartNew(JavaBuilder.CompileClasses, args);
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
                JavaBuilderEventArgs args = new JavaBuilderEventArgs(RepositoryRoot, (LogLevel)cbLogLevel.SelectedValue);
                cts = new CancellationTokenSource();
                args.CancellationToken = cts.Token;
                args.JDKFolder = tbJDKFolder.Text;
                args.JDKTarget = (JDKVersion)cbTarget.SelectedValue;
                args.SourceFolder = Path.GetFullPath(tbDestinationFolder.Text);
                args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
                args.AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyDataCollection);

                if (cbExportToFile.IsChecked.Value)
                {
                    export(args);
                    if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
                }

                commandPanel.IsEnabled = false;
                btnStop.Visibility = Visibility.Visible;
                Task.Factory.StartNew(JavaBuilder.GenerateDocs, args);
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
                JARBuilderEventArgs args = new JARBuilderEventArgs(RepositoryRoot, (LogLevel)cbLogLevel.SelectedValue);
                cts = new CancellationTokenSource();
                args.CancellationToken = cts.Token;
                args.JDKFolder = tbJDKFolder.Text;
                args.SourceFolder = Path.GetFullPath(tbDestinationFolder.Text);
                args.JarDestinationFolder = tbJarDestinationFolder.Text;
                args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
                args.WithJARSource = cbWithSource.IsChecked.Value;
                args.AssembliesToUse = AssemblyDataCollection.CreateList(AssemblyDataCollection);

                if (cbExportToFile.IsChecked.Value)
                {
                    export(args);
                    if (MessageBox.Show("Continue operation?", string.Empty, MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.Yes) == MessageBoxResult.No) return;
                }

                commandPanel.IsEnabled = false;
                btnStop.Visibility = Visibility.Visible;
                Task.Factory.StartNew(JavaBuilder.CreateJars, args);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
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
            if (cts != null)
            {
                cts.Dispose();
                cts = null;
            }

            this.Dispatcher.Invoke(() =>
            {
                commandPanel.IsEnabled = true;
                btnStop.Visibility = Visibility.Collapsed;
                if (args != null)
                {
                    tbReport.Text = args.Report;
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
            if (cts != null)
            {
                cts.Cancel(true);
            }
        }

        bool export<T>(T type) where T : class
        {
            Microsoft.Win32.SaveFileDialog sfd = new Microsoft.Win32.SaveFileDialog();
            sfd.InitialDirectory = assemblyLoc;
            sfd.FileName = typeof(T).Name;

            bool result = sfd.ShowDialog().Value;

            if (result)
            {
                System.Text.StringBuilder sb = new System.Text.StringBuilder();
                System.Xml.Serialization.XmlSerializer serializer = new System.Xml.Serialization.XmlSerializer(typeof(T));
                using (TextWriter writer = new StringWriter(sb))
                {
                    serializer.Serialize(writer, type);
                    writer.Flush();
                }

                string str = sb.ToString();
                File.WriteAllText(sfd.FileName, str);
            }

            return result;
        }
    }
}
