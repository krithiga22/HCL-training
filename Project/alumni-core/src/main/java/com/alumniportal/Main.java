package com.alumniportal;

import java.util.Scanner;

import com.alumniportal.constants.Constants;
import com.alumniportal.data.SampleData;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== COLLEGE ALUMNI NETWORK PORTAL =====");
            System.out.println("1. View Weekly Analytics");
            System.out.println("2. View Sample Alumni");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case Constants.MENU_VIEW_WEEKLY_ANALYTICS ->
                        SampleData.displayWeeklyAnalytics();

                    case Constants.MENU_VIEW_SAMPLE_ALUMNI ->
                        SampleData.displaySampleAlumni();

                    case Constants.MENU_EXIT ->
                        System.out.println("Exiting Alumni Network Portal. Goodbye!");

                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                choice = -1;
                System.out.println("Please enter a valid number.");
            }

        } while (choice != Constants.MENU_EXIT);

        scanner.close();
    }
}