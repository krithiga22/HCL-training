# Day 10 — Memory Management

## Topics Covered
- Stack memory and heap memory
- Stack frames and heap objects
- Object reachability and garbage collection
- Young and old generation concepts
- Common memory pitfalls in Java

## Hands-on Experiments
1. Tested StackOverflowError with different `-Xss` values.
2. Tested heap exhaustion with `-Xmx64m`.
3. Compared repeated String concatenation with StringBuilder.
4. Examined garbage collection logs using `-Xlog:gc`.
5. Investigated Integer caching and the difference between `==` and `equals()`.

## Project Review
Reviewed memory-related risks in the Alumni Network Portal and documented a stack/heap diagram for a business method.

## Deliverables
- Java source files for the memory experiments
- Lab results table
- Project memory review notes and diagram
- README with key learning outcomes

## Key Learning
Java manages object memory through garbage collection, but developers must still avoid unnecessary allocations, unbounded references, excessive recursion, and unclosed resources.
