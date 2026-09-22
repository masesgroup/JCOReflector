---
title: Generics support (experimental)
_description: Current state of .NET generics support in JCOReflector — what is reflected, what is intentionally skipped, and the Java-language limits behind those choices.
---

# Generics support (experimental)

> [!WARNING]
> Support for .NET generic types and members is **experimental**. It is controlled by an engine-level `EnableGenerics` switch, disabled by default. Enabling it changes the shape of the generated Java code (see [Impact on non-generic output](#impact-on-non-generic-output) below) and is not yet recommended for production reflection runs. This page documents the current state as of this writing and will be updated as the feature matures.

## Why generics needed dedicated work

Before this feature, JCOReflector discarded every .NET generic type and member during reflection: a generic class, interface, delegate, or method was simply not reflected. This kept the generated Java code simple, but excluded a large and important part of the .NET surface — collections (`List<T>`, `Dictionary<TKey,TValue>`), `Task<TResult>`, LINQ, and most modern .NET APIs are generic.

The core difficulty is that **.NET generics and Java generics work differently at runtime**. .NET generics are *reified*: `List<int>` and `List<string>` are distinct types at runtime, each with its own compiled code and static state. Java generics are implemented via *type erasure*: `List<Integer>` and `List<String>` share a single compiled class, and all type-parameter information is erased by the time the code runs. Mapping the former onto the latter means working around erasure everywhere it would otherwise cause a compile error, and accepting that some .NET APIs simply have no equivalent Java representation.

## How reflected generic types work

- A reflected generic .NET type (e.g. `List<T>`) becomes a parameterized Java class or interface (`List_1<T extends IJCOBridgeReflected>`), following the naming convention `<Name>_<arity>` (arity-based suffix) to avoid collisions between same-named types of different arity (`Lazy_1<T>`, `Lazy_2<T,TMetadata>`, and so on).
- Every type parameter is bounded by `IJCOBridgeReflected`, the marker interface implemented by every JCOReflector-generated class. This is what lets the generated code marshal a type argument back and forth across the bridge — and it is also the source of the most common limitation (see [Bound limitations](#bound-limitations) below).
- Creating an instance of a generated generic class requires the Java "anonymous subclass" idiom, e.g. `new List_1<Foo>(nativeHandle){}` (note the trailing `{}`). This is a deliberate, well-established Java pattern (the same "super type token" trick used by libraries such as Gson and Guava) for recovering a type argument's `Class<?>` at runtime despite erasure: the JVM retains generic information on an anonymous subclass's supertype, even though it discards it everywhere else. Constructing an instance without the trailing `{}` throws a clear `IllegalArgumentException` explaining the required syntax.
- The `Class<?>` recovered this way is cached on the instance (`genericArgumentClasses` in the shared `NetObject` base class) and reused whenever the generated code needs to build a new instance of a type parameter — for example when marshalling a returned array of `T`, or a `ref T` return value from newer .NET APIs — via a helper method (`instantiateGenericArgument`) that builds the instance reflectively instead of writing `new T(...)`, which Java forbids outright.

## What is intentionally not reflected

Several categories of .NET generic APIs are excluded on purpose, because there is no correct way to represent them in Java — not because of a missing feature, but because of a hard language or runtime limit:

- **`ref struct` types** (`Span<T>`, `ReadOnlySpan<T>`, and similar). These wrap a native pointer or stack reference that cannot be boxed, cannot cross the bridge as an object, and have no JVM equivalent. The type itself, and any member that uses it as a parameter or return type, is skipped entirely.
- **"Generic math" interfaces** (`System.Numerics.INumber<TSelf>` and the whole family: `IBinaryInteger`, `IFloatingPointIeee754`, the `I*Operators` interfaces, plus `IParsable`/`ISpanParsable`/`IUtf8SpanParsable`). These rely on C# **static abstract interface members**, a language feature with no Java counterpart at all — a Java interface can never declare a static abstract member. Their operator interfaces are also bound to `TResult = bool`, which can never satisfy the `IJCOBridgeReflected` bound. The whole family is excluded.
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

## Known gaps

A small number of specific types remain excluded (via an internal avoidance list) pending further investigation, rather than being fully worked through:

- `System.Collections.Generic.IAlternateEqualityComparer<TAlternate,T>` (.NET 9+) — its `Equals(TAlternate, T)` collides with `NetObject.Equals` similarly to the cases above, but on two *different* type parameters, which the current renaming logic does not yet detect.
- `System.Windows.Markup.INameScopeDictionary` — its `Implementation` class is missing members it inherits transitively through `IDictionary<TKey,TValue>`; the class-generation step currently only collects members declared directly on the interface being processed, not the full transitive interface closure.

These are being tracked and are expected to be revisited in a future iteration.

## Impact on non-generic output

Regenerating with `EnableGenerics` disabled is intended to reproduce the pre-generics output exactly. As of this writing that guarantee does **not** yet fully hold: some fully-qualified class names appear where a simple name used to be (cosmetic), and — more importantly — some classes have been observed to lose an `implements` clause they should still have even with the switch off. This is an active, unresolved issue; do not rely on `EnableGenerics=false` output being byte-for-byte identical to a pre-generics build until this note is updated.
