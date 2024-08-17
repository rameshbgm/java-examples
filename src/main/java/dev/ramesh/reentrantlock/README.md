"# java-examples"
# Reentrant Lock Example in Java 21

This example demonstrates the use of `ReentrantLock` in Java for thread synchronization. The example provided shows how to use a `ReentrantLock` to safely increment a shared counter from multiple threads.

## Overview


Concurrency is a crucial aspect of modern programming, particularly when dealing with multithreading in Java. One of the powerful tools for managing thread synchronization is the `ReentrantLock`. With the advancements in Java 21, `ReentrantLock` remains essential for effective thread management. This guide will explain what a reentrant lock is, when to use it, and how to implement it with practical examples.

A `ReentrantLock` allows a thread to acquire a lock it already holds, which is useful in recursive methods or complex scenarios where a thread might need to acquire the lock multiple times.


## What is a Reentrant Lock?

A reentrant lock is a synchronization aid that allows a thread to acquire the same lock multiple times without causing a deadlock. The term "reentrant" implies that a thread can re-enter (acquire) a lock it already holds. This is particularly beneficial in situations where a thread may need to acquire a lock while it already holds it, such as:

- Recursive methods
- Complex algorithms involving multiple locks

In Java, the `ReentrantLock` class, part of the `java.util.concurrent.locks` package, provides this functionality. It offers more flexibility than the traditional `synchronized` keyword by providing advanced features like:

- Try-lock
- Timed lock
- Interruptible lock acquisition

## When to Use a Reentrant Lock

### 1. Complex Locking Scenarios

- **Control Over Lock Acquisition and Release:** Use `ReentrantLock` when you need precise control over how locks are acquired and released.
- **Try-Lock Feature:** When you need to attempt to acquire the lock without blocking indefinitely.
- **Multiple Locks:** When you need to acquire and manage multiple locks simultaneously.

### 2. Recursive Locking

- **Recursive Methods:** When a method requires locking and might call itself or other methods that need the same lock.

### 3. Fairness

- **FIFO Order:** If you want to ensure that locks are granted in the order they are requested, `ReentrantLock` can be configured to be fair.

