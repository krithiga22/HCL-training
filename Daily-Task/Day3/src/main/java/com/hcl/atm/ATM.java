
package com.hcl.atm;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int correctPin = 1234;
        int balance = 5000;
        int attempts = 0;
        boolean authenticated = false;

        // Allow a maximum of 3 PIN attempts
        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter numbers only.");
                sc.next();
                attempts++;
                continue;
            }

            int pin = sc.nextInt();

            if (pin == correctPin) {
                authenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: "
                        + (3 - attempts));
            }
        }

        if (!authenticated) {
            System.out.println("Too many incorrect attempts. Access denied.");
            sc.close();
            return;
        }

        int choice = 0;

        // Keep displaying the menu until the user exits
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: Rs. " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Please enter a valid amount.");
                        sc.next();
                        break;
                    }

                    int deposit = sc.nextInt();

                    if (deposit <= 0) {
                        System.out.println("Amount must be greater than zero.");
                    } else {
                        balance += deposit;
                        System.out.println("Deposit successful.");
                        System.out.println("New balance: Rs. " + balance);
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Please enter a valid amount.");
                        sc.next();
                        break;
                    }

                    int withdrawal = sc.nextInt();

                    if (withdrawal <= 0) {
                        System.out.println("Amount must be greater than zero.");
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        System.out.println("Please collect your cash.");
                        System.out.println("Remaining balance: Rs. " + balance);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid menu option.");
            }

        } while (choice != 4);

        // Enhanced for loop demonstration
        String[] statement = {
            "Account summary",
            "Transactions are complete",
            "Thank you!"
        };

        System.out.println("\n===== MINI STATEMENT =====");

        for (String line : statement) {
            System.out.println(line);
        }

        sc.close();
    }
}