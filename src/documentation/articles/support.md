---
title: Professional support for JCOReflector
_description: Professional support, legacy target builds and implementation services for JCOReflector by MASES Group
---

# JCOReflector: professional support

Looking for expertise in applications mixing .NET and JVM™-enabled languages? MASES Group can help you design, build, deploy, and manage applications that run .NET and Java™/JVM™ side-by-side, and can provide builds for targets no longer covered by the public releases.

---

## Legacy and out-of-support targets

The public open-source branch of JCOReflector follows the target framework support of JCOBridge, which in turn follows the Microsoft .NET support lifecycle. When a target reaches end of support, it moves to the deprecated targets and is no longer part of the standard public updates.

If your project still depends on one of those targets, MASES Group can provide:

- Dedicated engine compilation for deprecated or out-of-support targets (for example .NET Framework 4.6.1+, .NET 5, .NET 6 and .NET 7)
- Continued maintenance of those builds, so you can plan your migration to a supported runtime on your own schedule
- Help assessing and executing the migration to a currently supported .NET target

---

## What MASES Group can help with

### Architecture and design

- Designing the integration architecture between .NET and JVM™-based systems: in-process vs. out-of-process, bidirectional vs. unidirectional, synchronous vs. event-driven
- Selecting the right JVM version for your .NET target runtime and managing backward compatibility with existing Java 8+ bytecode
- Mapping Java API surface to idiomatic C# patterns: generics, listeners, iterables, futures, and exception hierarchies
- Assessing legacy Java codebases for .NET integration — identifying which components to wrap via JCOReflector and which to migrate

### Implementation

- Building .NET applications that consume Java/Scala/Kotlin/Clojure/etc libraries directly via JCOReflector, without requiring Java-side modifications
- Developing JCOReflector-based wrappers for custom or third-party Java libraries not covered by the standard JCOReflector generated classes
- Implementing bidirectional integration using JCOReflector: exposing .NET assemblies as JARs for consumption from Java, Kotlin, Scala or Clojure
- Configuring JCOReflectorEngine to generate C# gateway classes from custom JARs and maintaining those classes across library updates

### Operations and performance

- JVM tuning for .NET-hosted processes: GC strategy, heap sizing, class loading, and thread pool configuration
- Diagnosing and resolving JVM↔CLR boundary issues, including object lifetime and cross-boundary GC collection (see [JCOBridgePublic#24](https://github.com/masesgroup/JCOBridgePublic/issues/24))
- Guidance on JCOBridge HPA Edition for production workloads requiring the highest reliability at the JVM↔CLR boundary
- PowerShell automation via JCOReflectorPS: scripting Java API calls from PowerShell in CI/CD and operational workflows

### Training and knowledge transfer

- Hands-on workshops covering the JCOReflector programming model: JVMBridgeBase, listeners, generics, and the JCOBridge runtime
- Code reviews and architectural walkthroughs for teams integrating existing Java libraries into .NET applications
- Guidance on managing multi-version Java compatibility and JVM upgrade paths alongside .NET runtime upgrades

---

## Contact

To discuss your project or request a quote, contact MASES Group at:

- **Website:** [https://www.masesgroup.com/](https://www.masesgroup.com/)
- **GitHub:** [https://github.com/masesgroup](https://github.com/masesgroup)
- **Email:** <span>&#115;&#97;&#108;&#101;&#115;&#64;&#109;&#97;&#115;&#101;&#115;&#103;&#114;&#111;&#117;&#112;&#46;&#99;&#111;&#109;</span>