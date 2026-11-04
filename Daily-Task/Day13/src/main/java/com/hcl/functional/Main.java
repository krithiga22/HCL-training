package com.hcl.functional;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // 1. Predicate
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("Is positive: " + isPositive.test(10));


        // 2. Function
        Function<Integer, Integer> doubleNumber = n -> n * 2;

        System.out.println("Double: " + doubleNumber.apply(5));


        // 3. Consumer
        Consumer<String> printMessage = msg -> System.out.println(msg);

        printMessage.accept("Learning Functional Programming");


        // 4. Supplier
        Supplier<String> welcomeMessage = () -> "Welcome to Day 13";

        System.out.println(welcomeMessage.get());

        Predicate<Integer> greaterThan10 = n -> n > 10;
        Predicate<Integer> lessThan100 = n -> n < 100;

        // AND
        Predicate<Integer> andResult =
                greaterThan10.and(lessThan100);

        System.out.println("AND: " + andResult.test(50));

        // OR
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isMultipleOf5 = n -> n % 5 == 0;

        Predicate<Integer> orResult =
                isEven.or(isMultipleOf5);

        System.out.println("OR: " + orResult.test(15));

        // NEGATE
        Predicate<Integer> negateResult = isPositive.negate();

        System.out.println("NEGATE: " + negateResult.test(-10));
        Function<Integer, Integer> multiplyBy2 =
                n -> n * 2;

        Function<Integer, Integer> add10 =
                n -> n + 10;

        // AND THEN
        Function<Integer, Integer> andThenResult =
                multiplyBy2.andThen(add10);

        System.out.println("AndThen: " +
                andThenResult.apply(5));


        // COMPOSE
        Function<Integer, Integer> composeResult =
                multiplyBy2.compose(add10);

        System.out.println("Compose: " +
                composeResult.apply(5));


        // String transformation
        Function<String, String> uppercase =
                name -> name.toUpperCase();

        Function<String, String> addWelcome =
                name -> "Welcome " + name;

        Function<String, String> finalResult =
                uppercase.andThen(addWelcome);

        System.out.println(finalResult.apply("java"));
           // 1. Static Method Reference
        Function<String, Integer> number =
                Integer::parseInt;

        System.out.println("Static: " + number.apply("100"));


        // 2. Particular Object Method Reference
        Consumer<String> printer =
                System.out::println;

        printer.accept("Hello Java");


        // 3. Arbitrary Object Method Reference
        Function<String, String> uppercase1 =
                String::toUpperCase;

        System.out.println("Uppercase: " +
                uppercase1.apply("functional programming"));


        // 4. Constructor Reference
        Supplier<StringBuilder> builder =
                StringBuilder::new;

        System.out.println("Constructor: " +
                builder.get().append("Day 13"));
    }
}
