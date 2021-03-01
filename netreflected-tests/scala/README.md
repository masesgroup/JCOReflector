## Scala to .NET Example
In this example we use JCOReflector objects from Scala language.

> **NOTE**: [Scala binaries](https://www.scala-lang.org/download/) shall be installed in the system and scala tools shall be available in the system path.

A simple program is like the following one:

```scala
package mscorlib;

import org.mases.jcobridge.netreflection._;
import system._;
 
object HelloNet extends App {
	try {
		Environment.GetLogicalDrives().foreach(Console.WriteLine(_))		
		Environment.Exit(0);
	} catch {
		case tre: Throwable => tre.printStackTrace();
	}
}
```

The program iterates across the array of logical drives returned from `Environment.GetLogicalDrives()` .NET equivalent.

To compile examples execute the following command (or use the _command.bat_ batch script available in this folder):

> scalac -toolcp "../../bin/net5.0/*" -d output ./mscorlib/*

To execute the compiled code execute the following command (or use the _execute.bat_ batch script available in this folder):

> scala -toolcp "../../bin/net5.0/*;./output" mscorlib.HelloNet

> **NOTE**: above command line, and batch scripts, uses **net5.0**. Change it to **net461** or **netcoreapp3.1** to use another framework.
