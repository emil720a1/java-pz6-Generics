# Java Practical Assignment 6 — Generics and Collections

This project demonstrates Java generics and the Collections Framework through a bank transaction example (Variant 4).

## Project contents

- `Container<T>` is a generic container that stores and returns a value of a specific type.
- `ObjectContainer` demonstrates storing values as `Object` and the need for an unsafe cast when retrieving them.
- `Transaction` represents a bank transaction with an ID, amount, and date. Equality and hashing are based on the transaction ID.
- `Main` demonstrates generic methods, bounded wildcards, collection operations, timing measurements, and safe removal with an iterator.

## Topics demonstrated

- Compile-time type safety with generic classes and methods.
- Why `List<Integer>` cannot be passed to a method accepting `List<Number>`, and how `List<? extends Number>` allows reading numbers from lists of numeric subtypes.
- Collection implementations: `ArrayList`, `LinkedList`, and `HashSet`.
- Timing indexed insertion and `contains` operations. Results depend on the JVM and machine, so repeated runs may differ.
- The `ConcurrentModificationException` that can occur when a list is modified directly during a for-each traversal, and removal using `Iterator.remove()`.
- The `equals()`/`hashCode()` contract used by `HashSet`, including the effect of changing a field used in equality after insertion.

## Requirements

- JDK 27
- Maven

The configured Java source and target versions are set to 27 in `pom.xml`.

## Run

Open the project in IntelliJ IDEA and run `org.example.Main`, or compile it with Maven:

```bash
mvn clean compile
```

The program prints demonstration output and collection timing measurements to the console.

## Variant

Variant 4 uses the transaction `id` as the equality key. The transaction amount and date are additional fields and do not participate in equality.
