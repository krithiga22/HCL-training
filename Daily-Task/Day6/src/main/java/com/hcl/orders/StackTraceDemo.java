package com.hcl.orders;

public class StackTraceDemo {

    public static void main(String[] args) {
        calculateTotal();
    }

    public static void calculateTotal() {
        int price = 100;
        int quantity = 0;

        int total = price / quantity;

        System.out.println(total);
    }
}
