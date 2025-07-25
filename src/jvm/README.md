# Assembly Reflected 

The available reflected classes are generated starting from root assemblies, generation is done using up to 10 recursions to explore for exportable Exceptions.
There are three main folders:
* [**_net462_**](#net-framework) contains the reflected classes generated from .NET Framework, divided by the containing assembly
* [**_net8.0_**](#net-8) contains the reflected classes generated from .NET 8, divided by the containing assembly
* [**_net9.0_**](#net-9) contains the reflected classes generated from .NET 9, divided by the containing assembly

**JCOReflector** is the folder of common classes for both **.NET** **Framework**, **6** and **8**

## .NET Framework

[//]: # "BeginReport net462"
Parsed assemblies are:
* PresentationFramework,Version=4.0.0.0,Culture=neutral,PublicKeyToken=31bf3856ad364e35
* System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
* System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
* System.Activities.Presentation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
* System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
* System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35

> Analyzed Assemblies:
> * PresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data.SqlXml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Numerics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Accessibility, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationTypes, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Windows.Input.Manipulations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * UIAutomationProvider, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Deployment, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters.Soap, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Printing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * PresentationUI, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.ServiceModel.Internals, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * SMDiagnostics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IdentityModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Web.ApplicationServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Transactions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.EnterpriseServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Caching, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.RegularExpressions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.OracleClient, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Drawing.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.DataAnnotations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices.Protocols, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceProcess, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.Install, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.Services, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Build.Utilities.v4.0, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Build.Tasks.v4.0, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Transactions.Bridge, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IdentityModel.Selectors, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Messaging, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Linq, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.DurableInstancing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Net.Http, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel.Activation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ServiceModel.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Microsoft.VisualBasic.Activities.Compiler, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Activities.DurableInstancing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Xaml.Hosting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Activities.Presentation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * WindowsFormsIntegration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ComponentModel.Composition, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Workflow.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Microsoft.Workflow.Compiler, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Workflow.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35

> * Analyzed Types = 43406
>   * Enumerators = 26
>   * Delegates = 557
>   * Classes
>     * Constructors = 11701
>     * Methods = 35798
>     * Properties = 31917
>     * Events = 2391
> * Implemented Types = 12316
>   * Enumerators = 25
>   * Delegates = 557
>   * Enums = 1663
>     * Flags = 314
>   * Interfaces = 847
>   * Classes = 9224
>     * Exceptions = 396
>     * Constructors = 10194
>     * Methods = 30477
>       * Duplicated Methods = 999
>     * Properties = 29775
>     * Events = 2185
> * Discarded Types = 31089
>   * Non Public = 30635
>   * Generic = 354
>   * Internals = 50

[//]: # "EndReport net462"

![FrameworkStatistic](https://docs.google.com/spreadsheets/d/e/2PACX-1vTe94B4KWTddOWDnIHGRkHHPq23g_oPzZUfmVU3ls1lEUwNQmG_T4Zi7xCCNkb0RMqkT8LblRNW7aT9/pubchart?oid=845891829&format=interactive ".NET Framework statistics")

## .NET 8

> NOTE: reference is .NET v8.0.* of the GitHub runner image

[//]: # "BeginReport net8.0"
Parsed assemblies are:
* PresentationFramework, Version=8.0.0.0

> Analyzed Assemblies:
> * PresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.CoreLib, Version=8.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * System.Private.Uri, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.InteropServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Loader, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Memory, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Reflection.Emit.ILGeneration, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.Lightweight, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Formats.Asn1, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encoding.Extensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Numerics, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tracing, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Intrinsics, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Overlapped, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.DiagnosticSource, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.ThreadPool, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XDocument, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Xml.Linq, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Private.Xml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.TraceSource, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Quic, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Registry, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Channels, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Compression, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.Brotli, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Net.NetworkInformation, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Metadata, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Immutable, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.MemoryMappedFiles, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Expressions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Extensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.EventBasedAsync, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebHeaderCollection, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.ServicePoint, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Drawing.Common, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.ReaderWriter, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.Common, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions.Local, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * WindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Accessibility, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Packaging, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Pkcs, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web.HttpUtility, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.TextWriterTraceListener, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.ProtectedData, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * PresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * DirectWriteForwarder, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Private.CoreLib, Version=0.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * Microsoft.Win32.Registry, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Memory, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.CSharp, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Core, Version=13.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Forms, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Pipes, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.DataContractSerialization, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Text.Encoding.CodePages, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Ping, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.1.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Contracts, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.ZipFile, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.Watcher, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebProxy, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets.Client, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.DispatchProxy, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath.XDocument, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.AppContext, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Buffers, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.Annotations, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.DataAnnotations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Annotations, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.MemoryMappedFiles, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.PerformanceCounter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Linq.Expressions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.DataSetExtensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data.SqlClient, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Odbc, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.OleDb, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Debug, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tools, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TraceSource, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TextWriterTraceListener, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Uri, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.Watcher, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Ports, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows.Extensions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Requests, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.ServicePoint, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.NameResolution, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebHeaderCollection, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebProxy, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.NetworkInformation, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Ping, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebSockets.Client, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebSockets, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms.Design, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Dynamic.Runtime, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Formats.Tar, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Globalization.Calendars, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Extensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.FileSystem, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.ZipFile, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.UnmanagedMemoryStream, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http.Json, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Json, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encodings.Web, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Numerics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Numerics, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Extensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Reader, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.Unsafe, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Handles, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.JavaScript, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Serialization.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Schema, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.OpenSsl, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Pkcs, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.ProtectedData, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Principal, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.SecureString, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ServiceModel.Syndication, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ServiceProcess, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceProcess.ServiceController, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Dataflow, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Extensions, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Timer, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Transactions.Local, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ValueTuple, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.ReaderWriter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Linq, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XmlDocument, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationTypes, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationProvider, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Windows.Input.Manipulations, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * ReachFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Printing, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * PresentationUI, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a

> * Analyzed Types = 26820
>   * Enumerators = 24
>   * Delegates = 364
>   * Classes
>     * Constructors = 6769
>     * Methods = 32460
>     * Properties = 18564
>     * Events = 1744
> * Implemented Types = 7350
>   * Enumerators = 23
>   * Delegates = 364
>   * Enums = 1258
>     * Flags = 273
>   * Interfaces = 375
>   * Classes = 5330
>     * Exceptions = 239
>     * Constructors = 5839
>     * Methods = 21285
>       * Duplicated Methods = 826
>     * Properties = 17285
>     * Events = 1636
> * Discarded Types = 19469
>   * Non Public = 19103
>   * Generic = 309
>   * Internals = 20

[//]: # "EndReport net8.0"

![Net8Statistic](https://docs.google.com/spreadsheets/d/e/2PACX-1vTe94B4KWTddOWDnIHGRkHHPq23g_oPzZUfmVU3ls1lEUwNQmG_T4Zi7xCCNkb0RMqkT8LblRNW7aT9/pubchart?oid=1753386013&format=interactive ".NET 8 statistics")


## .NET 9

> NOTE: reference is .NET v9.0.* of the GitHub runner image

[//]: # "BeginReport net9.0"
Parsed assemblies are:
* PresentationFramework, Version=9.0.0.0

> Analyzed Assemblies:
> * PresentationFramework, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.CoreLib, Version=9.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * System.Private.Uri, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xaml, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.InteropServices, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Loader, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Memory, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Reflection.Emit.ILGeneration, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.Lightweight, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Formats.Asn1, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encoding.Extensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Numerics, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Intrinsics, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Thread, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.MemoryMappedFiles, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tracing, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Overlapped, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.DiagnosticSource, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.ThreadPool, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=8.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XDocument, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Xml.Linq, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Private.Xml, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.TraceSource, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Quic, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Registry, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Channels, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Compression, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.Brotli, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Net.NetworkInformation, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Metadata, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Immutable, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Expressions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Extensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.EventBasedAsync, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebHeaderCollection, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Common, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Private.Windows.Core, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Formats.Nrbf, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.ReaderWriter, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.Common, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions.Local, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * WindowsBase, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Accessibility, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Packaging, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Pkcs, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web.HttpUtility, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.TextWriterTraceListener, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.ProtectedData, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * PresentationCore, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * DirectWriteForwarder, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Private.CoreLib, Version=0.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * Microsoft.Win32.Registry, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Memory, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.CSharp, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Core, Version=14.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Forms, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Windows.Forms, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Text.Encoding.CodePages, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.DataContractSerialization, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Ping, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.1.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Contracts, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.ZipFile, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.Watcher, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebProxy, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets.Client, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.DispatchProxy, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath.XDocument, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.AppContext, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Buffers, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.Annotations, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.DataAnnotations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Annotations, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.MemoryMappedFiles, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.PerformanceCounter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Linq.Expressions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.DataSetExtensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data.SqlClient, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Odbc, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.OleDb, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Debug, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tools, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TraceSource, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TextWriterTraceListener, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Uri, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.Watcher, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Ports, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows.Extensions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Requests, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.NameResolution, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebHeaderCollection, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebProxy, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.NetworkInformation, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Ping, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebSockets.Client, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebSockets, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms.Design, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Dynamic.Runtime, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Formats.Tar, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Globalization.Calendars, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Extensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.FileSystem, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.ZipFile, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipelines, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Pipes.AccessControl, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.UnmanagedMemoryStream, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http.Json, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Json, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encodings.Web, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.ServicePoint, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Numerics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Numerics, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Extensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Reader, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.Unsafe, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Handles, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.JavaScript, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Serialization.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Schema, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.OpenSsl, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Pkcs, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.ProtectedData, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Principal, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.SecureString, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ServiceModel.Syndication, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ServiceProcess, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceProcess.ServiceController, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Dataflow, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Extensions, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Timer, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Transactions.Local, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ValueTuple, Version=9.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.ReaderWriter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Linq, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XmlDocument, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationTypes, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationProvider, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Windows.Input.Manipulations, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * ReachFramework, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Printing, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * PresentationUI, Version=9.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices, Version=9.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a

> * Analyzed Types = 28070
>   * Enumerators = 24
>   * Delegates = 365
>   * Classes
>     * Constructors = 6853
>     * Methods = 35486
>     * Properties = 18839
>     * Events = 1749
> * Implemented Types = 7446
>   * Enumerators = 23
>   * Delegates = 365
>   * Enums = 1268
>     * Flags = 274
>   * Interfaces = 376
>   * Classes = 5414
>     * Exceptions = 240
>     * Constructors = 5897
>     * Methods = 21653
>       * Duplicated Methods = 852
>     * Properties = 17531
>     * Events = 1641
> * Discarded Types = 20623
>   * Non Public = 20249
>   * Generic = 317
>   * Internals = 20

[//]: # "EndReport net9.0"

![Net9Statistic](https://docs.google.com/spreadsheets/d/e/2PACX-1vTe94B4KWTddOWDnIHGRkHHPq23g_oPzZUfmVU3ls1lEUwNQmG_T4Zi7xCCNkb0RMqkT8LblRNW7aT9/pubchart?oid=1200391981&format=interactive ".NET 9 statistics")
