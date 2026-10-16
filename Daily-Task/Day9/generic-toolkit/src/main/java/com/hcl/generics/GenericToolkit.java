package com.hcl.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericToolkit {

    // 1. Generic method: works with any type
    public static <T> void printItem(T item) {
        System.out.println("Item: " + item);
    }

    // 2. Bounded generic method: finds the maximum
    public static <T extends Comparable<T>> T max(T first, T second) {
        return first.compareTo(second) >= 0 ? first : second;
    }

    // 3. Upper-bounded wildcard: reads numbers
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }

    // 4. Lower-bounded wildcard: accepts integers or their supertypes
    public static void addDefaults(List<? super Integer> numbers) {
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
    }

    public static void main(String[] args) {
        printItem("Alumni Portal");
        printItem(100);

        System.out.println("Maximum: " + max(25, 40));
        System.out.println("Maximum name: " + max("Java", "Spring"));

        List<Integer> marks = List.of(80, 90, 95);
        System.out.println("Total marks: " + sumNumbers(marks));

        List<Number> values = new ArrayList<>();
        addDefaults(values);
        System.out.println("Default values: " + values);
    }
}
