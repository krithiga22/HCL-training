package com.hcl.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureDemo {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        System.out.println(names.getClass());
        System.out.println(numbers.getClass());

        System.out.println(
            "Same runtime class: "
            + (names.getClass() == numbers.getClass())
        );
    }
}
