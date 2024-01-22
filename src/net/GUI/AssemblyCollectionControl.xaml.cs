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
using System.Windows;
using System.Windows.Controls;

namespace MASES.JCOReflectorGUI
{
    /// <summary>
    /// Interaction logic for AssemblyCollectionControl.xaml
    /// </summary>
    public partial class AssemblyCollectionControl : ContentControl
    {
        public int TotalFolders
        {
            get { return (int)GetValue(TotalFoldersProperty); }
            set { SetValue(TotalFoldersProperty, value); }
        }

        // Using a DependencyProperty as the backing store for TotalFolders.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty TotalFoldersProperty =
            DependencyProperty.Register("TotalFolders", typeof(int), typeof(AssemblyCollectionControl), new PropertyMetadata(0));

        public AssemblyDataCollection AssemblyCollection
        {
            get { return (AssemblyDataCollection)GetValue(AssemblyCollectionProperty); }
            set { SetValue(AssemblyCollectionProperty, value); }
        }

        // Using a DependencyProperty as the backing store for UserNodeIds.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty AssemblyCollectionProperty =
            DependencyProperty.Register("AssemblyCollection", typeof(AssemblyDataCollection), typeof(AssemblyCollectionControl), new PropertyMetadata(PropertyChangedCallback));

        static void PropertyChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs e)
        {
            AssemblyCollectionControl control = d as AssemblyCollectionControl;
            control.TotalFolders = e.NewValue != null ? (e.NewValue as AssemblyDataCollection).Count : 0;
        }

        public AssemblyCollectionControl()
        {
            InitializeComponent();
        }

        private void btnSelectAll_Click(object sender, RoutedEventArgs e)
        {
            if (AssemblyCollection != null)
            {
                foreach (AssemblyData item in AssemblyCollection)
                {
                    item.IsSelected = true;
                }
            }
        }

        private void btnUnselectAll_Click(object sender, RoutedEventArgs e)
        {
            if (AssemblyCollection != null)
            {
                foreach (AssemblyData item in AssemblyCollection)
                {
                    item.IsSelected = false;
                }
            }
        }
    }
}
