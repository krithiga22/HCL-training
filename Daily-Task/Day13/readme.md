# Day 13 – Functional Programming in Java

## Topics Learned

### 1. Lambda Expressions
- Lambda syntax and usage.
- Effectively-final variable capture.
- Replacing anonymous classes with lambda expressions.

### 2. Functional Interfaces
Learned the four built-in functional interfaces:
- Predicate
- Function
- Consumer
- Supplier

### 3. Predicate Composition
- and()
- or()
- negate()

### 4. Function Composition
- apply()
- andThen()
- compose()

### 5. Method References
Learned four types:
- Static method reference.
- Particular object method reference.
- Arbitrary object method reference.
- Constructor reference.

### 6. Custom Functional Interface
Created a custom functional interface using @FunctionalInterface and implemented it using a lambda expression.

## Hands-on Task – Product Filter Engine

Created a Product Filter Engine using Java Functional Programming.

### Product.java
Created a Product class with:
- Product ID
- Product name
- Price
- Category
- Stock availability

### FilterEngine.java
Implemented:
- Product filtering using Predicate.
- Multiple condition combinations.
- Product transformation using Function.
- Function composition.
- Product printing using Consumer.
- Default product generation using Supplier.
- Method references.

## Outcome

Learned how to use Functional Programming to write clean, concise, reusable and maintainable Java code.