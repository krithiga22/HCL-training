# AI Usage Log — Day 6

## Stack Trace 1: ArithmeticException

**AI Tool:** Copilot AI

**Prompt:** Explain the Java stack trace, identify the root cause, and suggest a safe fix.

**Stack Trace:** `java.lang.ArithmeticException: / by zero`

**AI Explanation:**
The exception occurs because `StackTraceDemo.java` attempts integer division using `quantity = 0`. The failing statement is `int total = price / quantity;` at line 13. Since there is no enclosing `try-catch`, the exception propagates to the JVM and terminates the program.

**My Verification:**
I checked `StackTraceDemo.java` and confirmed that `quantity` is zero and the division occurs at line 13. I ran the program and verified that the stack trace identifies `calculateTotal()` and its caller, `main()`.

**Result:** Correct, with a small qualification.

**Correction or Learning:**
The explanation is correct. The safe fix depends on the business rule: validate the quantity before division, or catch `ArithmeticException` when recovery is appropriate. For an order quantity, rejecting zero is usually better than simply catching the exception. The suggested standalone compile command may also need the exception class files or a previously compiled classpath, so compiling all project source files is the reliable approach.


## Stack Trace 2: Exception Chaining

**AI Tool:** Copilot Ai

**Prompt:** Explain the Java exception-chaining stack trace, identify the original cause, and explain how the cause is preserved.

**Stack Trace:**
`InvalidQuantityException: Order quantity must be a valid integer.`

Caused by: `NumberFormatException: For input string: "abc"`

**AI Explanation:**
`Integer.parseInt("abc")` throws a `NumberFormatException`. `OrderInputService` catches it and throws an `InvalidQuantityException`, passing the original exception as the cause. Java preserves this relationship through `Throwable(message, cause)`, so `printStackTrace()` displays the `Caused by:` section.

**My Verification:**
I checked `OrderInputService.java` and confirmed that the original exception is passed to `new InvalidQuantityException("Order quantity must be a valid integer.", e)`. The stack trace displays both exceptions and identifies where the parsing failed and where the custom exception was thrown.

**Result:** Correct.

**Correction or Learning:**
Exception chaining allows an application to report a meaningful business-level error without losing the original technical cause. `getCause()` can retrieve the underlying exception for debugging.
