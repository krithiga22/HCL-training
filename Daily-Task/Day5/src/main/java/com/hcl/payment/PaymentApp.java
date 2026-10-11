
package com.hcl.payment;

import java.util.Scanner;

public class PaymentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== PAYMENT SYSTEM =====");
        System.out.println("1. Card");
        System.out.println("2. UPI");
        System.out.println("3. Cash");
        System.out.print("Choose payment method: ");

        int choice = sc.nextInt();

        System.out.print("Enter amount: Rs. ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            sc.close();
            return;
        }

        Payment payment;

        switch (choice) {
            case 1:
                payment = new CardPayment(amount);
                break;

            case 2:
                payment = new UpiPayment(amount);
                break;

            case 3:
                payment = new CashPayment(amount);
                break;

            default:
                System.out.println("Invalid payment method.");
                sc.close();
                return;
        }

        System.out.println("\n===== PAYMENT RESULT =====");

        // Runtime polymorphism
        payment.pay();

        // Method overloading
        payment.pay("INR");

        // Refund supported only by selected payment types
        if (payment instanceof Refundable) {

            System.out.print("Enter refund amount (0 to skip): ");
            double refundAmount = sc.nextDouble();

            if (refundAmount > 0) {
                ((Refundable) payment).refund(refundAmount);
            }

        } else {
            System.out.println(
                "This payment method does not support refunds."
            );
        }

        sc.close();
    }
}