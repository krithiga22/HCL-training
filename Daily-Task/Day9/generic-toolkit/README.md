# Day 9 — Java Generics and Resource Management

## 1. Learning Objectives

Today, I learned Java Generics and how they help write reusable, type-safe code. I also studied type erasure, wildcards, and resource management in Java.

## 2. Topics Learned

### 2.1 Introduction to Generics
- Understood the purpose of Generics in Java.
- Learned how Generics provide compile-time type safety.
- Understood how Generics reduce unnecessary type casting.
- Compared generic types with raw types.

### 2.2 Generic Classes
- Learned how to create generic classes using type parameters.
- Practised `Pair<K, V>` to store two values of different types.
- Implemented `Box<T extends Number>` to restrict the type parameter to numeric types.
- Understood bounded type parameters.

### 2.3 Generic Methods
- Learned how to declare generic methods using type parameters.
- Implemented a generic method to print values of different data types.
- Created a bounded generic method to find the maximum of two comparable values.

### 2.4 Wildcards in Generics
- Learned about upper-bounded wildcards using `? extends`.
- Learned about lower-bounded wildcards using `? super`.
- Understood the PECS principle: Producer Extends, Consumer Super.
- Practised reading numeric values and adding integer values to collections.

### 2.5 Type Erasure
- Understood how Java implements Generics through type erasure.
- Observed that `List<String>` and `List<Integer>` use the same runtime class.
- Learned that generic type information is primarily checked at compile time.

### 2.6 Resource Management
- Learned about the `AutoCloseable` interface.
- Practised try-with-resources for automatic resource cleanup.
- Observed that resources close in reverse order of declaration.
- Understood how resource management helps prevent resource leaks.

### 2.7 CSV File Handling
- Learned how to read data from a CSV file using Java I/O.
- Used `BufferedReader` to read file contents line by line.
- Converted CSV rows into Java objects.
- Practised exception handling when a file is missing or contains invalid data.

### 2.8 Generic Repository Pattern
- Learned how to create a generic `CrudRepository<T, ID>` interface.
- Implemented an `InMemoryRepository<T, ID>` using a `Map`.
- Practised Create, Read, and Delete operations.
- Used the same repository implementation for different entity types, such as Product and Student.
- Understood how Generics improve code reusability and reduce duplication.

## 3. Hands-On Practice

The following practical exercises were performed:

1. Created generic classes and methods.
2. Implemented bounded generics and wildcard methods.
3. Demonstrated type erasure.
4. Read product information from a CSV file.
5. Used try-with-resources and `AutoCloseable`.
6. Implemented a reusable generic CRUD repository.
7. Tested the repository with multiple entity types.
8. Compiled and executed the Java programs using Maven and Java 21.

## 4. Tools and Technologies

- Java 21
- Maven
- Visual Studio Code
- Java Collections Framework
- Java I/O and exception handling
- Git and GitHub

## 5. Key Takeaways

- Generics enable type-safe and reusable code.
- Bounded types restrict which data types can be used.
- Wildcards provide flexibility when working with generic collections.
- Type erasure explains how generic types are handled at runtime.
- Try-with-resources simplifies resource cleanup.
- A generic repository can support multiple entity types without duplicating CRUD logic.

## 6. Outcome

By the end of Day 9, I gained practical experience with Java Generics, wildcards, type erasure, CSV file handling, and automatic resource management. I also implemented a reusable in-memory CRUD repository that can manage multiple types of entities.

These concepts provide a foundation for building reusable components in larger Java applications, including the Alumni Network Portal.
