# Java Functional Interfaces

## Overview

Java functional interfaces, introduced in Java 8, are a cornerstone of functional programming in Java. They allow for more concise and expressive code by providing a way to pass behavior as parameters using lambda expressions and method references. This document introduces Java functional interfaces, their usage, advantages, and provides examples for each interface.

## Introduction to Java Functional Interfaces

Functional interfaces are interfaces with exactly one abstract method. They may have multiple default or static methods, but there must be only one abstract method. This makes them ideal for use with lambda expressions and method references.

## Usage

Functional interfaces are widely used in various contexts:
- **Lambda Expressions**: Simplify the implementation of functional interfaces.
- **Method References**: Provide a concise way to refer to methods without invoking them.
- **Java Collections Framework**: Often used in methods like `sort()`, `filter()`, and `map()` within streams.
- **Streams API**: Facilitates complex operations on sequences of elements.

## Advantages

- **Conciseness**: Reduces boilerplate code compared to anonymous classes.
- **Readability**: Makes code more readable and easier to maintain.
- **Reusability**: Promotes code reuse and functional programming practices.
- **Declarative Style**: Encourages a more declarative style of coding, simplifying complex operations.

# List of Functional Interfaces

- **BiConsumer**
- **BiFunction**
- **BinaryOperator**
- **BiPredicate**
- **BooleanSupplier**
- **Consumer**
- **DoubleBinaryOperator**
- **DoubleConsumer**
- **DoubleFunction**
- **DoublePredicate**
- **DoubleSupplier**
- **DoubleToIntFunction**
- **DoubleToLongFunction**
- **DoubleUnaryOperator**
- **Function**
- **IntBinaryOperator**
- **IntConsumer**
- **IntFunction**
- **IntPredicate**
- **IntSupplier**
- **IntToDoubleFunction**
- **IntToLongFunction**
- **IntUnaryOperator**
- **LongBinaryOperator**
- **LongConsumer**
- **LongFunction**
- **LongPredicate**
- **LongSupplier**
- **LongToDoubleFunction**
- **LongToIntFunction**
- **LongUnaryOperator**
- **ObjDoubleConsumer**
- **ObjIntConsumer**
- **ObjLongConsumer**
- **Predicate**
- **Supplier**
- **ToDoubleBiFunction**
- **ToDoubleFunction**
- **ToIntBiFunction**
- **ToIntFunction**
- **ToLongBiFunction**
- **ToLongFunction**
- **UnaryOperator**

## BiConsumer

The `BiConsumer` interface is a part of the `java.util.function` package and is a functional interface in Java. It is intended for use primarily with lambda expressions or method references.

`BiConsumer` is a functional interface that accepts two input parameters and performs an operation on them without returning any result. The interface has a single method:

```java
void accept(T t, U u);
