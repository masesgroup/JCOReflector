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
- Interface
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

> dotnet run --framework netcoreapp3.1 JCOReflector\JCOReflectorCore.csproj

For .NET Framework it is possible to execute:

> dotnet run --framework net461 JCOReflector\JCOReflectorCore.csproj

![JCOReflector](/images/jcoreflector.png?raw=true "JCOReflector screenshot")

## Reflected Assemblies

The folder [netreflected](/netreflected/src) contains all reflected classes.