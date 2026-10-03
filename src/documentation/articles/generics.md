---
title: Generics support (experimental)
_description: Current state of .NET generics support in JCOReflector — what is reflected, what is intentionally skipped, and the Java-language limits behind those choices.
---

# Generics support (experimental)

> [!WARNING]
> Support for .NET generic types and members is **experimental**. It is controlled by an engine-level `EnableGenerics` switch. Enabling it changes the shape of the generated Java code (see [Impact on non-generic output](#impact-on-non-generic-output) below) and is not yet recommended for production reflection runs. This page documents the current state as of this writing and will be updated as the feature matures.

> [!NOTE]
> Some generic scenarios depend on the JCOBridge runtime version. For example, passing a `Comparison<T>` delegate to `List<T>.Sort` requires JCOBridge 2.6.10 preview 4 or later.

## Why generics needed dedicated work

Before this feature, JCOReflector discarded every .NET generic type and member during reflection: a generic class, interface, delegate, or method was simply not reflected. This kept the generated Java code simple, but excluded a large and important part of the .NET surface — collections (`List<T>`, `Dictionary<TKey,TValue>`), `Task<TResult>`, LINQ, and most modern .NET APIs are generic.

The core difficulty is that **.NET generics and Java generics work differently at runtime**. .NET generics are *reified*: `List<int>` and `List<string>` are distinct types at runtime, each with its own compiled code and static state. Java generics are implemented via *type erasure*: `List<Integer>` and `List<String>` share a single compiled class, and all type-parameter information is erased by the time the code runs. Mapping the former onto the latter means working around erasure everywhere it would otherwise cause a compile error, and accepting that some .NET APIs simply have no equivalent Java representation.

## How reflected generic types work

- A reflected generic .NET type (e.g. `List<T>`) becomes a parameterized Java class or interface (`List_1<T extends IJCOBridgeReflected>`), following the naming convention `<Name>_<arity>` (arity-based suffix) to avoid collisions between same-named types of different arity (`Lazy_1<T>`, `Lazy_2<T,TMetadata>`, and so on).
- Every type parameter is bounded by `IJCOBridgeReflected`, the marker interface implemented by every JCOReflector-generated class. This is what lets the generated code marshal a type argument back and forth across the bridge — and it is also the source of the most common limitation (see [Bound limitations](#bound-limitations) below).
- Creating an instance of a generated generic class requires the Java "anonymous subclass" idiom, e.g. `new List_1<Foo>(nativeHandle){}` (note the trailing `{}`). This is a deliberate, well-established Java pattern (the same "super type token" trick used by libraries such as Gson and Guava) for recovering a type argument's `Class<?>` at runtime despite erasure: the JVM retains generic information on an anonymous subclass's supertype, even though it discards it everywhere else. Constructing an instance without the trailing `{}` throws a clear `IllegalArgumentException` explaining the required syntax.
- The `Class<?>` recovered this way is cached on the instance (`genericArgumentClasses` in the shared `NetObject` base class) and reused whenever the generated code needs to build a new instance of a type parameter — for example when marshalling a returned array of `T`, or a `ref T` return value from newer .NET APIs — via a helper method (`instantiateGenericArgument`) that builds the instance reflectively instead of writing `new T(...)`, which Java forbids outright.
- Generic **delegates** (`Comparison<T>`, `Func<T>`, and similar) work the same way from the caller's point of view, even though they extend `JCDelegate` rather than `NetObject`: a shared helper (`NetGenericHelper`) recovers the type argument from the anonymous subclass and lazily resolves the closed CLR delegate type the first time it's needed, instead of requiring the caller to build the closed type name by hand. See the [example](#example-sorting-a-list-with-a-generic-comparison-delegate) below.

## What is intentionally not reflected

Several categories of .NET generic APIs are excluded on purpose, because there is no correct way to represent them in Java — not because of a missing feature, but because of a hard language or runtime limit:

- **`ref struct` types** (`Span<T>`, `ReadOnlySpan<T>`, and similar). These wrap a native pointer or stack reference that cannot be boxed, cannot cross the bridge as an object, and have no JVM equivalent. The type itself, and any member that uses it as a parameter or return type, is skipped entirely.
- **"Generic math" interfaces** (`System.Numerics.INumber<TSelf>` and the whole family: `IBinaryInteger`, `IFloatingPointIeee754`, the `I*Operators` interfaces, plus `IParsable`/`ISpanParsable`/`IUtf8SpanParsable`). These rely on C# **static abstract interface members**, a language feature with no Java counterpart at all — a Java interface can never declare a static abstract member. Their operator interfaces are also bound to `TResult = bool`, which can never satisfy the `IJCOBridgeReflected` bound. The whole family is excluded: in practice every generic interface of `System.Numerics`, plus `IParsable`, `ISpanParsable` and `IUtf8SpanParsable`, is matched by pattern.
- **Method-level type parameters with no construction point.** A class-level type parameter (e.g. the `T` in `List<T>`) can be resolved at runtime because the anonymous-subclass trick captures its `Class<?>` when the instance is built. A type parameter that belongs to a single **method** instead (e.g. `Array.Empty<T>()`, `MemoryMarshal.GetArrayDataReference<T>(T[])`) has no such capture point — there is no moment where the caller supplies a `Class<T>` — so these members are skipped rather than emitting code that cannot compile.
- **A generic class-level parameter used from a `static` member.** In .NET, each closed generic instantiation (`Foo<int>`, `Foo<string>`) has its own independent static state, so a static member can reference the class's own type parameter. In Java there is exactly one shared class per raw type regardless of how many parameterizations exist, so a static context can never see a class-level type parameter. Such members are skipped.
- **Genuine erasure collisions.** Some pairs of distinct .NET members become identical once Java erasure removes their type arguments — two overloads (`Task.WhenAny(IEnumerable<Task>)` vs `WhenAny<TResult>(IEnumerable<Task<TResult>>)`), an array parameter next to a `params T[]` (`ImmutableArray<T>.AddRange`), or an inherited member whose erased signature collides with one from a base type or interface. Where a rename keeps both members usable (see [Renaming](#renaming-to-avoid-erasure-collisions) below) that is preferred; where no rename is possible without misrepresenting the API (e.g. two overloads whose only difference disappears entirely under erasure), the losing member is skipped.

## Bound limitations

Every type parameter is declared as `<T extends IJCOBridgeReflected>`. This is necessary for the generated code to marshal `T` across the bridge, but it means a type parameter **cannot** be filled with:

- a native-mapped .NET type (`System.String`, or any primitive: `int`, `bool`, and so on), since these map onto plain Java types (`java.lang.String`, `int`, `boolean`, ...) that do not implement `IJCOBridgeReflected`.

When a .NET type fixes one of its own base type's parameters to such a type — the most common real-world case is `KeyedCollection<string, TItem>`, i.e. any "keyed by name" collection — the affected `extends`/`implements` reference is generated **raw** (unparameterized) instead of failing to compile. This is the same trade-off already accepted elsewhere (see below): the class remains usable, but loses compile-time type-safety on that specific reference.

## Renaming to avoid erasure collisions

Where two members would otherwise collide only because of erasure — not because they are truly the same member — the generated one is renamed with a descriptive suffix rather than dropped, so both remain available:

- `Equals(T)` / `Equals(T, T)` on `IEquatable<T>` / `IEqualityComparer<T>` implementations, which would otherwise erase to the same signature as `NetObject.Equals(IJCOBridgeReflected[, IJCOBridgeReflected])`, are generated as `EqualsGeneric(...)`.
- `Remove(TKey)` / `Contains(TKey)` on `KeyedCollection<TKey,TItem>` and similar types, which would otherwise erase to the same signature as the inherited `Collection<TItem>.Remove(TItem)` / `Contains(TItem)`, are generated as `RemoveByKey(...)` / `ContainsByKey(...)`.

## Exceptions cannot be generic classes

Java forbids a generic class from extending `java.lang.Throwable`, without exception (JLS §8.1.2) — this is not something JCOReflector can work around. A .NET generic exception type (e.g. `FaultException<TDetail>`) is therefore always generated as a **plain, non-generic** Java class. Its class-level type parameter is exposed everywhere as its bound, `IJCOBridgeReflected`, instead of a real type variable — for example `FaultException_1.getDetail()` returns `IJCOBridgeReflected`, not `TDetail`. This is the one case where the generic parameter is always erased to its bound in the public API, by necessity rather than by choice.

## Using generics from Clojure

The anonymous-subclass idiom described above (`new List_1<Foo>(){}`) cannot be written in Clojure. `proxy`, `reify` and `gen-class` generate classes, but none of them writes the generic `Signature` attribute of the superclass, which is exactly what JCOReflector reads to recover the type arguments. A subclass produced by those forms looks, to the reflection code, like a raw `List_1`, so the type argument is lost and instantiating a generic class fails the same way it does in Java when the trailing `{}` is omitted.

To fill that gap, the Clojure tests ship a small helper namespace, `generics.GenericSupport` (currently in `tests/jvm/clojure/src/main/clojure/generics/GenericSupport.clj`). It generates, at runtime, the same kind of class `javac` emits for an anonymous generic subclass.

### The `new-generic` function

```clojure
(gs/new-generic super type-args)
(gs/new-generic super type-args impls)
```

- `super` is the generated generic class to instantiate (for example `List_1` or `Comparison_1`).
- `type-args` is a vector of classes, one per type parameter (for example `[system.Object]`). Each one must satisfy the `IJCOBridgeReflected` bound, so the [bound limitations](#bound-limitations) apply unchanged.
- `impls` is an optional map from a method name to the Clojure function that implements it, for example `{"Invoke" (fn [x y] 0)}`. It is meant for delegates and for classes whose virtual methods must be overridden from Clojure.

The return value is an instance of a public, no-argument subclass of `super`, whose `Signature` attribute is `Super<TypeArg1, ...>`.

### How it works

The helper builds the subclass bytecode with the ASM copy that ships inside Clojure (`clojure.asm`), so no extra dependency is needed:

- The class has a public no-argument constructor that calls the superclass constructor, and a public field `impl` that holds a Clojure function.
- For every method named in `impls`, the helper looks up the overridable method in the superclass hierarchy (public or protected, not static, not final, bridge and synthetic methods skipped) and overrides it. The override boxes the arguments, calls `impl` with the method name and the argument array, and converts the result back to the declared return type: `void` discards it, `boolean` and `char` are unboxed, the other primitives go through `java.lang.Number`, and reference types are cast.
- The Clojure function receives the **boxed** arguments of the method, so a `Comparison<T>` delegate receives two objects and must return a number that is converted to `int`.
- Generated classes are cached per combination of superclass, type arguments and overridden method names, so repeated calls with the same shape reuse one class.
- **Generic classes and generic delegates need nothing different.** `NetObject` (generic classes) and `NetGenericHelper` (generic delegates, which extend `JCDelegate` instead) both read the type arguments from `getGenericSuperclass()` of the instance's class. The generated `Signature` is therefore all they require, whichever base class is involved.
- **The generated class is defined in the same package and class loader as the superclass**, and is named `<package of super>.DynamicGeneratedN` (for example `system.collections.generic.DynamicGenerated1`). This is required: when an instance crosses the bridge, JCOBridge resolves the class by name to read its generic signature and decide which .NET type to allocate. A class that lives only in a private class loader cannot be resolved and the call fails with an exception whose message is just the generated class name. On Java 9 and later the class is defined with `MethodHandles.Lookup.defineClass`; a reflective fallback on `ClassLoader.defineClass` exists for Java 8.

### Example

```clojure
(ns example
  (:require [generics.GenericSupport :as gs])
  (:import [org.mases.jcobridge.netreflection IJCOBridgeReflected]
           [system Comparison_1]
           [system.collections.generic List_1]))

;; a List<System.Object>
(let [^List_1 lst (gs/new-generic List_1 [system.Object])
      a (system.Object.)]
  ;; see "Overload resolution" below for the type hint
  (.Add lst ^IJCOBridgeReflected a))

;; a Comparison<System.Object> delegate implemented by a Clojure function
(def comparison
  (gs/new-generic Comparison_1 [system.Object]
                  {"Invoke" (fn [x y] 0)}))
```

### Limits of the helper

- **Plain type arguments only.** The generated `Signature` lists each type argument as a simple class, so a type argument that is itself parameterized (`List<List<Foo>>`) cannot be expressed. The runtime side agrees: `NetGenericHelper` throws an `IllegalArgumentException` ("unsupported generic argument") for anything that is not a plain class.
- **Overrides are selected by name.** If several overridable methods share the same name, the helper picks the first non-bridge one it finds in the hierarchy. A single entry in `impls` cannot target a specific overload.
- **Overload resolution is done by Clojure, not by `javac`.** Clojure sees only the erased signatures, so a call that `javac` resolves through the generic parameter (`Add(T)`) can be bound by Clojure to a more specific overload, for example an explicit-interface `Add(...)`, which throws `UnsupportedOperationException`. Hinting the arguments as `IJCOBridgeReflected`, as in the example above, forces the intended overload. When no hint is enough (for example `List_1.Sort` with a `Comparison_1`), select the method by reflection.
- **Instances only.** The helper does not make static members or method-level type parameters reachable; the [exclusions listed above](#what-is-intentionally-not-reflected) are the same for every language.
- **Java versions.** The Clojure generics tests pass on Java 8, 11, 17, 21 and 25.
- **Experimental.** Like the feature it supports, the helper lives in the test sources and may change.

## Known gaps

A number of types and members are currently excluded through the exporting avoidance map, pending further investigation. The entries are temporary: each is either a genuine Java erasure limit (two .NET members that cannot coexist once type arguments are erased) or a bug not yet root-caused, and they are expected to be revisited in a future iteration.

Whole types:

- `System.Collections.Generic.IAlternateEqualityComparer<TAlternate,T>` (.NET 9+) — its `Equals(TAlternate, T)` collides with `NetObject.Equals` similarly to the cases above, but on two *different* type parameters, which the current renaming logic does not yet detect.
- `System.Windows.Markup.INameScopeDictionary` — its `Implementation` class is missing members it inherits transitively through `IDictionary<TKey,TValue>`; the class-generation step currently only collects members declared directly on the interface being processed, not the full transitive interface closure.

Members:

- `SyndicationElementExtensionCollection.Add`
- `ICollection<T>.Add` and `ICollection<T>.Remove`
- `ImmutableArray<T>.AddRange`
- `Sse41.Extract`
- `TryFormat` on `Guid`, `Version`, `Rune`, `IPAddress` and `IPNetwork`
- `GetPinnableReference` on `Span<T>` and `ReadOnlySpan<T>` — probably redundant, since both are `ref struct` types and are already excluded as whole types (see [What is intentionally not reflected](#what-is-intentionally-not-reflected)); the entries are to be reviewed.

A whole-type entry (one without a member list) also stops the type itself from being exported as its own file. Skipping only its members would leave the type's `Implementation` class generated anyway, still missing members inherited from non-excluded interfaces such as `IComparable` or `IFormattable`.

## Impact on non-generic output

Regenerating with `EnableGenerics` disabled is intended to reproduce the pre-generics output exactly. As of this writing that guarantee does **not** yet fully hold: some fully-qualified class names appear where a simple name used to be (cosmetic), and — more importantly — some classes have been observed to lose an `implements` clause they should still have even with the switch off. This is an active, unresolved issue; do not rely on `EnableGenerics=false` output being byte-for-byte identical to a pre-generics build until this note is updated.

## Example: sorting a list with a generic `Comparison` delegate

This example exercises three mechanisms described above together: constructing a generic class (`List<T>`), passing a generic **delegate** as a synchronous, value-returning callback (`Comparison<T>`), and the anonymous-subclass idiom used for both. The full source lives at `tests/jvm/java/src/generics/GenericComparisonDelegateSortsAList.java`.

```java
List_1<system.Object> list = new List_1<system.Object>() {};
list.Add(new system.Object());
list.Add(new system.Object());

final java.util.concurrent.atomic.AtomicInteger calls = new java.util.concurrent.atomic.AtomicInteger();

Comparison_1<system.Object> comparison = new Comparison_1<system.Object>() {
    @Override
    public int Invoke(system.Object x, system.Object y) {
        calls.incrementAndGet();
        return 0;
    }
};
list.Sort(comparison);

if (calls.get() == 0) throw new AssertionError("Java comparison never invoked");
```

Note that, exactly as for `List_1<T>` itself, the delegate is constructed with the trailing `{}` and only `Invoke` needs to be overridden — the generated `Comparison_1` class resolves its own closed CLR delegate type (`System.Comparison\`1[System.Object]`) lazily, via the same anonymous-subclass capture used everywhere else, instead of requiring the caller to build that name by hand.
