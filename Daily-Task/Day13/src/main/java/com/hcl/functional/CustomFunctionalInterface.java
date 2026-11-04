package com.hcl.functional;

@FunctionalInterface
interface DiscountCalculator {

    double calculate(double price);
}

public class CustomFunctionalInterface {

    public static void main(String[] args) {

        DiscountCalculator discount =
                price -> price - (price * 0.10);

        double finalPrice = discount.calculate(1000);

        System.out.println("Original Price: 1000");
        System.out.println("Final Price: " + finalPrice);
    }
}