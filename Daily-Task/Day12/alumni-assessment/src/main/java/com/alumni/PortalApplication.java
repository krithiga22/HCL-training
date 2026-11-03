package com.alumni;

import com.alumni.model.*;
import com.alumni.service.*;

import com.alumni.exception.AlumniNotFoundException;
import com.alumni.exception.DuplicateAlumniException;

import java.util.Scanner;

public class PortalApplication {

    private static final Scanner scanner = new Scanner(System.in);

    private static final AlumniService alumniService =
            new AlumniService();

    private static final JobService jobService =
            new JobService();

    private static final MentorshipService mentorshipService =
            new MentorshipService();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 -> addAlumni();

                    case 2 -> viewAllAlumni();

                    case 3 -> searchAlumni();

                    case 4 -> removeAlumni();

                    case 5 -> postJob();

                    case 6 -> jobService.displayJobs();

                    case 7 -> submitMentorshipRequest();

                    case 8 -> mentorshipService.displayPendingRequests();

                    case 9 -> processMentorshipRequest(true);

                    case 10 -> processMentorshipRequest(false);

                    case 11 -> {
                        running = false;
                        System.out.println("Thank you for using Alumni Portal!");
                    }

                    default -> System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");

            } catch (DuplicateAlumniException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (AlumniNotFoundException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("\n========== ALUMNI NETWORK PORTAL ==========");
        System.out.println("1. Add Alumni");
        System.out.println("2. View All Alumni");
        System.out.println("3. Search Alumni");
        System.out.println("4. Remove Alumni");
        System.out.println("5. Post Job");
        System.out.println("6. View Available Jobs");
        System.out.println("7. Submit Mentorship Request");
        System.out.println("8. View Mentorship Requests");
        System.out.println("9. Accept Mentorship Request");
        System.out.println("10. Reject Mentorship Request");
        System.out.println("11. Exit");
    }

    private static void addAlumni() {

        System.out.print("Alumni ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Batch: ");
        String batch = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Company: ");
        String company = scanner.nextLine();

        Alumni alumni = new Alumni(
                id, name, email, batch, department, company
        );

        alumniService.addAlumni(alumni);
    }

    private static void viewAllAlumni() {

        System.out.println("\n--- ALL ALUMNI ---");

        for (Alumni alumni : alumniService.getAllAlumni()) {
            alumni.displayDetails();
        }
    }

    private static void searchAlumni()
            throws AlumniNotFoundException {

        System.out.print("Enter Alumni ID: ");
        String id = scanner.nextLine();

        Alumni alumni = alumniService.findAlumni(id);
        alumni.displayDetails();
    }

    private static void removeAlumni()
            throws AlumniNotFoundException {

        System.out.print("Enter Alumni ID: ");
        String id = scanner.nextLine();

        alumniService.removeAlumni(id);
    }

    private static void postJob() {

        System.out.print("Job ID: ");
        String id = scanner.nextLine();

        System.out.print("Job Title: ");
        String title = scanner.nextLine();

        System.out.print("Company: ");
        String company = scanner.nextLine();

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Posted By (Alumni ID): ");
        String postedBy = scanner.nextLine();

        Job job = new Job(
                id, title, company, location, postedBy
        );

        jobService.addJob(job);
    }

    private static void submitMentorshipRequest() {

        System.out.print("Request ID: ");
        String requestId = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Alumni ID: ");
        String alumniId = scanner.nextLine();

        System.out.print("Mentorship Topic: ");
        String topic = scanner.nextLine();

        MentorshipRequest request = new MentorshipRequest(
                requestId, studentId, alumniId, topic
        );

        mentorshipService.submitRequest(request);
    }

    private static void processMentorshipRequest(boolean accept) {

        System.out.print("Enter Request ID: ");
        String id = scanner.nextLine();

        if (accept) {
            mentorshipService.acceptRequest(id);
        } else {
            mentorshipService.rejectRequest(id);
        }
    }
}

