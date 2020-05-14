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
using System.Collections;
using System.Collections.Generic;
using System.IO;
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

        public MainWindow()
        {
            InitializeComponent();
#if !NET_CORE
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (Framework)";
#else
            Title = "JCOReflector Builder - CLR to JVM reflection class generator (CoreCLR)";
#endif

            Title += " Version " + typeof(MainWindow).Assembly.GetName().Version.ToString();

            cbTarget.ItemsSource = Enum.GetValues(typeof(JDKVersion));
            cbTarget.SelectedValue = JDKVersion.Version8;

            cbLogLevel.ItemsSource = Enum.GetValues(typeof(LogLevel));
            cbLogLevel.SelectedValue = LogLevel.Info;

            tbDestinationFolder.Text = Path.GetFullPath(Path.Combine(Environment.CurrentDirectory, @"..\..\netreflected\src"));
            tbJarDestinationFolder.Text = Environment.CurrentDirectory;
#if DEBUG
            tbJDKFolder.Text = Path.GetFullPath(Path.Combine(Environment.CurrentDirectory, @"..\..\jdk-14.0.1"));
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
            ReflectorEventArgs args = new ReflectorEventArgs();
            args.LogLevel = (LogLevel)cbLogLevel.SelectedValue;
            args.AssemblyName = tbAssembly.Text;
            args.RootDestinationFolder = tbDestinationFolder.Text;
            args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
            args.ForceRebuild = cbForceRebuildIfFolderExist.IsChecked.Value;
            args.UseParallelBuild = cbUseParallel.IsChecked.Value;
            args.CreateExceptionThrownClause = cbExportExceptions.IsChecked.Value;
            args.ExceptionThrownClauseDepth = MaxDepth;
            args.EnableAbstract = cbExportAbstract.IsChecked.Value;
            args.EnableArray = cbExportArray.IsChecked.Value;
            args.EnableInheritance = cbEnableInheritance.IsChecked.Value;
            args.DryRun = cbDryRun.IsChecked.Value;

            Task.Factory.StartNew(Reflector.ExportAssembly, args);
        }

        private void btnGetFolders_Click(object sender, RoutedEventArgs e)
        {
            commandPanel.IsEnabled = false;

            JavaBuilderEventArgs args = new JavaBuilderEventArgs();
            args.LogLevel = (LogLevel)cbLogLevel.SelectedValue;
            args.JDKFolder = tbJDKFolder.Text;
            args.OriginFolder = tbDestinationFolder.Text;
            args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;

            var result = JavaBuilder.CreateFolderList(args);

            AssemblyDataCollection = result;
        }

        IList<string> createList()
        {
            int coreCounter = 0;
            int frameworkCounter = 0;

            List<string> items = new List<string>();
            if (AssemblyDataCollection != null)
            {
                foreach (var item in AssemblyDataCollection)
                {
                    if (item.IsSelected)
                    {
                        switch (item.Framework)
                        {
                            case Const.Framework.NETCore: coreCounter++; break;
                            case Const.Framework.NETFramework: frameworkCounter++; break;
                            case Const.Framework.All: break;
                            default:
                                throw new InvalidOperationException(string.Format("Framework {0} is not valid", item.Framework));
                        }

                        items.Add(item.FolderName);
                    }
                }
            }

            if (coreCounter * frameworkCounter != 0) throw new InvalidOperationException("Framework type cannot be mixed.");

            return items;
        }

        private void btnBuild_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                JavaBuilderEventArgs args = new JavaBuilderEventArgs();
                args.LogLevel = (LogLevel)cbLogLevel.SelectedValue;
                args.JDKFolder = tbJDKFolder.Text;
                args.JDKTarget = (JDKVersion)cbTarget.SelectedValue;
                args.OriginFolder = tbDestinationFolder.Text;
                args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
                args.AssembliesToUse = createList();

                commandPanel.IsEnabled = false;
                Task.Factory.StartNew(JavaBuilder.CompileClasses, args);
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
                JavaBuilderEventArgs args = new JavaBuilderEventArgs();
                args.LogLevel = (LogLevel)cbLogLevel.SelectedValue;
                args.JDKFolder = tbJDKFolder.Text;
                args.OriginFolder = tbDestinationFolder.Text;
                args.DestinationFolder = tbJarDestinationFolder.Text;
                args.SplitFolderByAssembly = cbEnableSplitFolder.IsChecked.Value;
                args.AssembliesToUse = createList();

                commandPanel.IsEnabled = false;
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
            this.Dispatcher.Invoke(() =>
            {
                commandPanel.IsEnabled = true;
                if (args != null) tbReport.Text = args.Report;
                else tbReport.Text = "Missing managed event args.";
            });
        }
    }
}
