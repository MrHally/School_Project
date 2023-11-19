﻿#pragma checksum "..\..\..\Level3.xaml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "4D469927105BD11AA5FF1114E61015510D9F2F64"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Controls.Ribbon;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;
using TetrisNew;


namespace TetrisNew {
    
    
    /// <summary>
    /// Level3
    /// </summary>
    public partial class Level3 : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 25 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Canvas GameCanvas;
        
        #line default
        #line hidden
        
        
        #line 28 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock Level;
        
        #line default
        #line hidden
        
        
        #line 31 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock ScoreText;
        
        #line default
        #line hidden
        
        
        #line 32 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock Goal;
        
        #line default
        #line hidden
        
        
        #line 38 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Image NextImage;
        
        #line default
        #line hidden
        
        
        #line 41 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Grid GameWinMenu;
        
        #line default
        #line hidden
        
        
        #line 45 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock FinalScoreText1;
        
        #line default
        #line hidden
        
        
        #line 51 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Grid GameOveMenu;
        
        #line default
        #line hidden
        
        
        #line 55 "..\..\..\Level3.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock FinalScoreText;
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "7.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
            System.Uri resourceLocater = new System.Uri("/TetrisNew;component/level3.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\Level3.xaml"
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "7.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
            
            #line 8 "..\..\..\Level3.xaml"
            ((TetrisNew.Level3)(target)).KeyDown += new System.Windows.Input.KeyEventHandler(this.Window_KeyDown);
            
            #line default
            #line hidden
            return;
            case 2:
            this.GameCanvas = ((System.Windows.Controls.Canvas)(target));
            
            #line 25 "..\..\..\Level3.xaml"
            this.GameCanvas.Loaded += new System.Windows.RoutedEventHandler(this.GameCanvas_Loaded);
            
            #line default
            #line hidden
            return;
            case 3:
            this.Level = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 4:
            this.ScoreText = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 5:
            this.Goal = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 6:
            this.NextImage = ((System.Windows.Controls.Image)(target));
            return;
            case 7:
            this.GameWinMenu = ((System.Windows.Controls.Grid)(target));
            return;
            case 8:
            this.FinalScoreText1 = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 9:
            
            #line 46 "..\..\..\Level3.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Button_Click_1);
            
            #line default
            #line hidden
            return;
            case 10:
            
            #line 47 "..\..\..\Level3.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Button_Click_2);
            
            #line default
            #line hidden
            return;
            case 11:
            this.GameOveMenu = ((System.Windows.Controls.Grid)(target));
            return;
            case 12:
            this.FinalScoreText = ((System.Windows.Controls.TextBlock)(target));
            return;
            case 13:
            
            #line 56 "..\..\..\Level3.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Button_Click);
            
            #line default
            #line hidden
            return;
            case 14:
            
            #line 57 "..\..\..\Level3.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Button_Click_2);
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}

