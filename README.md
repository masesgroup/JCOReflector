# JCOReflector

JCOReflector is a reflection engine which automatically writes Java classes using .NET class reflection.
The generated classes are based on the powerful [JCOBridge](https://www.jcobridge.com) engine and extends its use to simplify the use of .NET from Java(JVM).
It was created internally from us to support our customers, now we made it available for everyone.

This project adheres to the Contributor [Covenant code of conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. Please report unacceptable behavior to coc_reporting@masesgroup.com.

## Scope of the project

This project aims to create a set of Java (JVM) classes which mimic .NET (Framework/Core) conterparts.
Using this project it is possible to use .NET API in Java and all JVM enabled languages (Scala, Kotlin, and so on).

The final output of JCOReflector are JARs: JCOReflector can be used to reflects any .NET assembly (even assembly outside the Microsoft ones) into JARs.
You only need to reference JCOReflector.jar in the class-path and use the .NET API within a Java projects. A simple example is the following one: 

```java

package mscorlib;

import system.*;
import system.io.*;

public class HelloNET {
    public static void main(String[] args) {
        try {
            String filename = "test.txt";
            String result = "";
            if (File.Exists(filename)) {
                result = File.ReadAllText(filename);
				Console.WriteLine(result);
                result = result + "Java Execution ";
                File.WriteAllText(filename, result);
            }
            Console.WriteLine(result);
            Console.WriteLine("Exiting");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }catch (Throwable tre) {
            tre.printStackTrace();
        }
        return;
    }
}

```

This is the result:

```
prompt> This is a text file for read/write operation
prompt> This is a text file for read/write operation Java Execution
prompt> Exiting
```

To run it runs a command like the following one:

> java -cp JCOReflector.jar;. HelloNET

The full example code, and other ones, are in the project test folder.

### Whats in .NET for Java?

From the point of view of .NET it is very simple to use Java classes and it is not necessary to have some kind of reflection classes.
[JCOBridge](https://www.jcobridge.com) is able to access and execute directly within a JVM using C# code, from C# it is possible to execute directly Java code with a similar syntax: look at the examples in [JCOBridge-Examples](https://github.com/masesgroup/JCOBridge-Examples)

## Actual state

The project is at its first stages. A graphical UI helps to manages reflection and all other operations to finally build JARs.
JCOReflector uses templates so it is not necessary to manually manages the output.
The reflector executable, available for both Framework and CoreCLR, is limited in the following features:

### Implemented in the reflector

- Only public Types are available
- Classes and public accessible methods
- Interface
- Enum: enumeration and flags are available
- .NET exception are translated and thrown in code
- Static classes are managed
- Events
- Arrays: partial support
- Native types managed from JCOBridge are directly mapped to native Java type
- Base types (System.Object, System.Type, System.Enum, System.Exception, System.Collections.ArrayList) are mapped to specific type into a support library (**JCOReflector.jar**)
- Management of thrown declaration as expected in Java: a generic Throwable is used with all exceptions found in code (used the algorithm in https://stackoverflow.com/questions/986180/how-can-i-determine-which-exceptions-can-be-thrown-by-a-given-method and code from https://docs.microsoft.com/en-us/archive/blogs/haibo_luo/)

### Not implemented in reflector:

- Out/Ref parameters: you need to write code using JCOBridge API
- Inheritance
- Generic types
- Method decoration (Attributes)
- Unsafe methods
- Fields
- Documentation

### Limitations

C# and Java are different languages. The reflection process cannot reflects into Java some features available on C#: an example are properties where get/set is automatically choosed from C# compiler
Other limitations comes from some differences between the two engines (CLR and JVM).
In all cases [JCOBridge](https://www.jcobridge.com) superside these limitations, but manual operations shall be made: do not change the reflected classes, override them in your code.

## How to use the generator tool (JCOReflector)

In the root folder execute:

> dotnet build JCOReflector\JCOReflectorCore.csproj

For .NET Core it is possible to execute:

> dotnet run --framework netcoreapp3.1 --project JCOReflector\JCOReflectorCore.csproj

For .NET Framework it is possible to execute:

> dotnet run --framework net461 --project JCOReflector\JCOReflectorCore.csproj

![JCOReflector](/images/jcoreflector.png?raw=true "JCOReflector screenshot")
![JCOReflector](/images/jcoreflector2.png?raw=true "JCOReflector screenshot")

## Reflected Assemblies

The folder [netreflected](/netreflected/src) contains all reflected classes generated for **.NET** **Framework** and **Core**. Below the list of analyzed and reflected assemblies:

### Framework

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

### CoreCLR (reference is .NET Core 3.1)

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
> * System.Data.OleDb, Version=4.0.1.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
> * System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
> * System.CodeDom, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.IO.Ports, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
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
> * System.Text.Encoding.CodePages, Version=4.1.3.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encoding, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
> * System.Text.Encodings.Web, Version=4.0.5.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
> * System.Text.Json, Version=4.0.1.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
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
