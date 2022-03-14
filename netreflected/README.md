# Assembly Reflected 

The available reflected classes are generated starting from root assemblies, generation is done using up to 10 recursions to explore for exportable Exceptions.
There are two main folders:
* **_net461_** contains the reflected classes generated from .NET Framework, divided by the containing assembly
* **_netcoreapp3.1_** contains the reflected classes generated from .NET Core 3.1, divided by the containing assembly
* **_net5.0_** contains the reflected classes generated from .NET 5, divided by the containing assembly
* **_net6.0_** contains the reflected classes generated from .NET 6, divided by the containing assembly

**JCOReflector** is the folder of common classes for both **.NET** **Framework**, **Core**, **5** and **6**

## .NET Framework
![FrameworkStatistic](https://docs.google.com/spreadsheets/d/e/2PACX-1vRKe-7bBH40JmQmq4I194xz9g2YsoU7L9fHwzY0fqZyWepyjqnOC0B7lgO9CjAuTrBkOA8qbTiScLpS/pubchart?oid=1238429091&format=image)

![FrameworkStatisticPercent](https://docs.google.com/spreadsheets/d/e/2PACX-1vRKe-7bBH40JmQmq4I194xz9g2YsoU7L9fHwzY0fqZyWepyjqnOC0B7lgO9CjAuTrBkOA8qbTiScLpS/pubchart?oid=485555819&format=image)

[//]: # "BeginReport net461"
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

> * Analyzed Types = 43282
>   * Enumerators = 26
>   * Delegates = 557
>   * Classes
>     * Constructors = 11699
>     * Methods = 35787
>     * Properties = 31911
>     * Events = 2391
> * Implemented Types = 12311
>   * Enumerators = 25
>   * Delegates = 557
>   * Enums = 1660
>     * Flags = 314
>   * Interfaces = 847
>   * Classes = 9222
>     * Exceptions = 396
>     * Constructors = 10192
>     * Methods = 30468
>       * Duplicated Methods = 999
>     * Properties = 29770
>     * Events = 2185
> * Discarded Types = 30970
>   * Non Public = 30516
>   * Generic = 354
>   * Internals = 50

[//]: # "EndReport net461"
## .NET Core (reference is .NET Core 3.1)

![NetcoreStatistic](https://docs.google.com/spreadsheets/d/e/2PACX-1vRKe-7bBH40JmQmq4I194xz9g2YsoU7L9fHwzY0fqZyWepyjqnOC0B7lgO9CjAuTrBkOA8qbTiScLpS/pubchart?oid=964222969&format=image)

![NetcoreStatisticPercent](https://docs.google.com/spreadsheets/d/e/2PACX-1vRKe-7bBH40JmQmq4I194xz9g2YsoU7L9fHwzY0fqZyWepyjqnOC0B7lgO9CjAuTrBkOA8qbTiScLpS/pubchart?oid=857533338&format=image)

[//]: # "BeginReport netcoreapp3.1"
Parsed assemblies are:
* PresentationFramework,Version=4.0.0.0,Culture=neutral,PublicKeyToken=31bf3856ad364e35

> Analyzed Assemblies:
> * PresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * System.Private.Uri, Version=4.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.InteropServices, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=4.3.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Debug, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Buffers, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Memory, Version=4.2.1.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections.Concurrent, Version=4.0.15.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tools, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=4.3.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Numerics, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding.Extensions, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tracing, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.ThreadPool, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Primitives, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Timer, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TraceSource, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Process, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Registry, Version=4.1.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.Unsafe, Version=4.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XDocument, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Xml.Linq, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Private.Xml, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.RegularExpressions, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.ILGeneration, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.Lightweight, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Primitives, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebHeaderCollection, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Overlapped, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NetworkInformation, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.DiagnosticSource, Version=4.0.5.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Compression, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.Brotli, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Net.ServicePoint, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Reflection.Emit, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Expressions, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Extensions, Version=4.0.1.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Debug, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Common, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Drawing.Primitives, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TraceSource, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.SystemEvents, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections.NonGeneric, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=4.0.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Memory, Version=4.2.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.X509Certificates, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.ReaderWriter, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Primitives, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions.Local, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Accessibility, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime.InteropServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Packaging, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.MemoryMappedFiles, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Contracts, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TextWriterTraceListener, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Metadata, Version=1.4.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Immutable, Version=1.2.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.ZipFile, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.DriveInfo, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Watcher, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=4.1.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebProxy, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Ping, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebSockets.Client, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.DispatchProxy, Version=4.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Primitives, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=4.1.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.DataContractSerialization, Version=4.1.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.XPath.XDocument, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Pkcs, Version=4.0.3.2, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=4.3.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Numerics, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding.Extensions, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.ProtectedData, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Memory, Version=4.0.1.1, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.EventLog, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.ThreadPool, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TraceSource, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Security.Principal.Windows, Version=4.1.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=4.1.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.AccessControl, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * DirectWriteForwarder, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Microsoft.CSharp, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Core, Version=10.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.1.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.AppContext, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Annotations, Version=4.3.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.DataAnnotations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Diagnostics.PerformanceCounter, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.MemoryMappedFiles, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Process, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=4.0.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.DataSetExtensions, Version=4.0.1.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data.SqlClient, Version=4.6.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Odbc, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.OleDb, Version=4.0.1.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Ports, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Text.Encoding.CodePages, Version=4.1.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Windows.Forms.Design.Editors, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Dynamic.Runtime, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Calendars, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Extensions, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.FileSystem, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Primitives, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.UnmanagedMemoryStream, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Reflection, Version=4.2.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Extensions, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Reader, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Handles, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.WindowsRuntime, Version=4.0.4.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Intrinsics, Version=4.0.1.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime.Loader, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Pkcs, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.SecureString, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ServiceModel.Syndication, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ServiceProcess, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceProcess.ServiceController, Version=4.2.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encodings.Web, Version=4.0.5.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Json, Version=4.0.1.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encodings.Web, Version=4.0.5.1, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Channels, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Tasks.Dataflow, Version=4.6.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Extensions, Version=4.3.1.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Transactions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.ValueTuple, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.Linq, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XmlDocument, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * UIAutomationTypes, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationProvider, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Windows.Input.Manipulations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Printing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * PresentationUI, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=4.3.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a

> * Analyzed Types = 24360
>   * Enumerators = 24
>   * Delegates = 367
>   * Classes
>     * Constructors = 6403
>     * Methods = 26057
>     * Properties = 17746
>     * Events = 1725
> * Implemented Types = 6974
>   * Enumerators = 23
>   * Delegates = 367
>   * Enums = 1203
>     * Flags = 260
>   * Interfaces = 354
>   * Classes = 5027
>     * Exceptions = 229
>     * Constructors = 5540
>     * Methods = 19861
>       * Duplicated Methods = 726
>     * Properties = 16607
>     * Events = 1620
> * Discarded Types = 17385
>   * Non Public = 17085
>   * Generic = 232
>   * Internals = 33

[//]: # "EndReport netcoreapp3.1"
## .NET Core (reference is .NET v5.0.100)

![Net5Statistic](https://docs.google.com/spreadsheets/d/e/2PACX-1vRKe-7bBH40JmQmq4I194xz9g2YsoU7L9fHwzY0fqZyWepyjqnOC0B7lgO9CjAuTrBkOA8qbTiScLpS/pubchart?oid=212559398&format=image)

![Net5StatisticPercent](https://docs.google.com/spreadsheets/d/e/2PACX-1vRKe-7bBH40JmQmq4I194xz9g2YsoU7L9fHwzY0fqZyWepyjqnOC0B7lgO9CjAuTrBkOA8qbTiScLpS/pubchart?oid=1162005117&format=image)

[//]: # "BeginReport net5.0"
Parsed assemblies are:
* PresentationFramework, Version=5.0.0.0, PublicKeyToken=31bf3856ad364e35

> Analyzed Assemblies:
> * PresentationFramework, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.CoreLib, Version=5.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * System.Private.Uri, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xaml, Version=5.0.14.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.InteropServices, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Memory, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections.Concurrent, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Formats.Asn1, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime.Numerics, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding.Extensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tracing, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Overlapped, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.ThreadPool, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.Unsafe, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XDocument, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Xml.Linq, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Private.Xml, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.TraceSource, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.ILGeneration, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.Lightweight, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Channels, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.NetworkInformation, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.DiagnosticSource, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Compression, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.Brotli, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Reflection.Emit, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Expressions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Extensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebHeaderCollection, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.ServicePoint, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Debug, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Common, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime.InteropServices, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Primitives, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.SystemEvents, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections.NonGeneric, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=4.0.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Buffers, Version=4.0.2.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Memory, Version=4.2.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.ReaderWriter, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.AccessControl, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions.Local, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * WindowsBase, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Accessibility, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Registry, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Packaging, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.MemoryMappedFiles, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Process, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Contracts, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TextWriterTraceListener, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Metadata, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Immutable, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.ZipFile, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.DriveInfo, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Watcher, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebProxy, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Ping, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebSockets.Client, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.DispatchProxy, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.DataContractSerialization, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.XPath.XDocument, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Memory, Version=4.0.1.1, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Pkcs, Version=4.0.3.2, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=4.3.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Numerics, Version=4.1.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=4.2.1.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.ProtectedData, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=5.0.0.1, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.ThreadPool, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TraceSource, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * PresentationCore, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Private.CoreLib, Version=0.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * Microsoft.Win32.Registry, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * DirectWriteForwarder, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime.Extensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.CSharp, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Core, Version=10.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Forms, Version=5.0.14.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms, Version=5.0.14.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Drawing.Common, Version=5.0.0.2, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows.Forms.Primitives, Version=5.0.14.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Text.Encoding.CodePages, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.1.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.AppContext, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Buffers, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.Annotations, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.DataAnnotations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Annotations, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.MemoryMappedFiles, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.PerformanceCounter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.MemoryMappedFiles, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Process, Version=4.2.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Expressions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.DataSetExtensions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data.SqlClient, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Odbc, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.OleDb, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Debug, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tools, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
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
> * System.Windows.Forms.Design, Version=5.0.14.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Dynamic.Runtime, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Calendars, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Extensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.FileSystem, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.ZipFile, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Primitives, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.UnmanagedMemoryStream, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http.Json, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Json, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encodings.Web, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime.Intrinsics, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Numerics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Numerics, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Extensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Reader, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Handles, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Loader, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Serialization.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Pkcs, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.ProtectedData, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Principal, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.SecureString, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ServiceModel.Syndication, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ServiceProcess, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceProcess.ServiceController, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Dataflow, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Extensions, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Timer, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Transactions.Local, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ValueTuple, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Private.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.Linq, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.ReaderWriter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlDocument, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationTypes, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationProvider, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Windows.Input.Manipulations, Version=5.0.14.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * ReachFramework, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Printing, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * PresentationUI, Version=5.0.14.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=4.3.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=4.1.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a

> * Analyzed Types = 25384
>   * Enumerators = 24
>   * Delegates = 363
>   * Classes
>     * Constructors = 6504
>     * Methods = 28312
>     * Properties = 18027
>     * Events = 1733
> * Implemented Types = 7089
>   * Enumerators = 23
>   * Delegates = 363
>   * Enums = 1227
>     * Flags = 265
>   * Interfaces = 355
>   * Classes = 5121
>     * Exceptions = 233
>     * Constructors = 5615
>     * Methods = 20224
>       * Duplicated Methods = 758
>     * Properties = 16860
>     * Events = 1626
> * Discarded Types = 18294
>   * Non Public = 17991
>   * Generic = 238
>   * Internals = 29

[//]: # "EndReport net5.0"
## .NET Core (reference is .NET v6.0.100)

[//]: # "BeginReport net6.0"
Parsed assemblies are:
* PresentationFramework, Version=6.0.0.0, PublicKeyToken=31bf3856ad364e35

> Analyzed Assemblies:
> * PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * System.Private.Uri, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.InteropServices, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Loader, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Security, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Memory, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Encoding, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Formats.Asn1, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encoding.Extensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Numerics, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.Unsafe, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Thread, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tracing, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Sockets, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Overlapped, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.NameResolution, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.ThreadPool, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Drawing.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.RegularExpressions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.ILGeneration, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Emit.Lightweight, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XDocument, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.Xml.Linq, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Private.Xml, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.TraceSource, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Quic, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Channels, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Compression, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.Brotli, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Net.NetworkInformation, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.DiagnosticSource, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Reflection.Emit, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Expressions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Extensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.EventBasedAsync, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Requests, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebHeaderCollection, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.ServicePoint, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.ReaderWriter, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.AccessControl, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions.Local, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * WindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * Accessibility, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Registry, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Packaging, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.Pkcs, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.FileVersionInfo, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebClient, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Cryptography.ProtectedData, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * PresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * DirectWriteForwarder, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Private.CoreLib, Version=0.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
> * Microsoft.Win32.Registry, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Principal.Windows, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Permissions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Collections, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.NonGeneric, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Concurrent, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ObjectModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Console, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.StackTrace, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Metadata, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Immutable, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.MemoryMappedFiles, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.IsolatedStorage, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Writer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.InteropServices.RuntimeInformation, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Formatters, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Claims, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Algorithms, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Csp, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Encoding, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.X509Certificates, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Extensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.CompilerServices.VisualC, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.CSharp, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Core, Version=11.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.DriveInfo, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.VisualBasic.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms.Primitives, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Diagnostics.StackTrace, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Private.DataContractSerialization, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Text.Encoding.CodePages, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Ping, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * netstandard, Version=2.1.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Console, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Contracts, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.TextWriterTraceListener, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.ZipFile, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.FileSystem.Watcher, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.HttpListener, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.WebProxy, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.Mail, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Net.WebSockets.Client, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.DispatchProxy, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Parallel, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.XPath.XDocument, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.AppContext, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Buffers, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ComponentModel.Annotations, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.DataAnnotations, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Runtime, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Annotations, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Configuration.ConfigurationManager, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.MemoryMappedFiles, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Cng, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.EventLog, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.PerformanceCounter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Linq.Expressions, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Queryable, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Linq.Parallel, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.DataSetExtensions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Data.SqlClient, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Common, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Data.Odbc, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Data.OleDb, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Debug, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Diagnostics.Tools, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * Microsoft.Win32.SystemEvents, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Diagnostics.Process, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Collections.Specialized, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.TypeConverter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.EventBasedAsync, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ComponentModel.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * Microsoft.Win32.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
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
> * System.Windows.Forms.Design, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Dynamic.Runtime, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Calendars, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Globalization.Extensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Compression.FileSystem, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO.Compression.ZipFile, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.IO, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.FileSystem.Primitives, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.Pipes.AccessControl, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.IO.UnmanagedMemoryStream, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Net.Http.Json, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Json, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Encodings.Web, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Runtime.Intrinsics, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Numerics, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Numerics, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Numerics.Vectors, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.Extensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Reflection.TypeExtensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.Reader, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Resources.ResourceManager, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Handles, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Runtime.Serialization.Primitives, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Runtime.Serialization.Json, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.OpenSsl, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Pkcs, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.ProtectedData, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.Cryptography.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Security.Principal, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Security.SecureString, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceModel.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.ServiceModel.Syndication, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ServiceProcess, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.ServiceProcess.ServiceController, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Dataflow, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Threading.Tasks.Extensions, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Threading.Timer, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Transactions, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Transactions.Local, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.ValueTuple, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Web.HttpUtility, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Windows, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Private.Xml, Version=0.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Xml.Linq, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XPath.XDocument, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.Serialization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.Xml.ReaderWriter, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlSerializer, Version=0.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Xml.XmlDocument, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationTypes, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * UIAutomationProvider, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Windows.Input.Manipulations, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * ReachFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.Printing, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * PresentationUI, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a

> * Analyzed Types = 25842
>   * Enumerators = 24
>   * Delegates = 364
>   * Classes
>     * Constructors = 6628
>     * Methods = 29132
>     * Properties = 18246
>     * Events = 1734
> * Implemented Types = 7180
>   * Enumerators = 23
>   * Delegates = 364
>   * Enums = 1237
>     * Flags = 267
>   * Interfaces = 360
>   * Classes = 5196
>     * Exceptions = 237
>     * Constructors = 5718
>     * Methods = 20579
>       * Duplicated Methods = 800
>     * Properties = 17033
>     * Events = 1627
> * Discarded Types = 18661
>   * Non Public = 18321
>   * Generic = 277
>   * Internals = 27

[//]: # "EndReport net6.0"
