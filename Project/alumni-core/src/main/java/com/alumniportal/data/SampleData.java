
package com.alumniportal.data;

import com.alumniportal.constants.Constants;

public final class SampleData {

    private SampleData() {
    }
    public static final String[] DAYS = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };
    public static final int[] ALUMNI_REGISTRATIONS = {
        12, 15, 10, 18, 20, 25, 14
    };
    public static final int[] JOBS_POSTED = {
        2, 3, 1, 4, 5, 3, 2
    };
    public static final int[] MENTORSHIP_REQUESTS = {
        5, 7, 4, 8, 10, 12, 6
    };
    public static final int[] EVENT_RSVPS = {
        10, 15, 12, 20, 25, 30, 18
    };
    public static final int[] DONATIONS = {
        1000, 2500, 0, 1500, 3000, 5000, 2000
    };
    public static void displayWeeklyAnalytics() {
        System.out.println("\n===== WEEKLY PORTAL ANALYTICS =====");
        System.out.printf(
            "%-12s %10s %8s %12s %8s %12s%n",
            "Day", "Registrations", "Jobs",
            "Mentorship", "RSVPs", "Donations"
        );
        for (int i = 0; i < Constants.DAYS_IN_WEEK; i++) {
            System.out.printf(
                "%-12s %10d %8d %12d %8d %12d%n",
                DAYS[i],
                ALUMNI_REGISTRATIONS[i],
                JOBS_POSTED[i],
                MENTORSHIP_REQUESTS[i],
                EVENT_RSVPS[i],
                DONATIONS[i]
            );
        }
    }
    public static void displaySampleAlumni() {
        System.out.println("\n===== SAMPLE ALUMNI DIRECTORY =====");
        System.out.printf("%-6s %-20s %-15s %-20s %-15s%n", "ID", "Name", "Graduation Year", "Designation", "Company");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-6s %-20s %-15s %-20s %-15s%n", "AL101", "Alice Johnson", "2018", "Software Engineer", "Google");
        System.out.printf("%-6s %-20s %-15s %-20s %-15s%n", "AL102", "Bob Smith", "2015", "Engineering Lead", "Microsoft");
        System.out.printf("%-6s %-20s %-15s %-20s %-15s%n", "AL103", "Charlie Davis", "2020", "Product Manager", "Amazon");
        System.out.printf("%-6s %-20s %-15s %-20s %-15s%n", "AL104", "Diana Prince", "2019", "Data Scientist", "Meta");
    }

    public static void runCollectionsDemo() {
        System.out.println("\n=======================================================");
        System.out.println("       DAY 7: COLLECTIONS & EXCEPTIONS DEMO            ");
        System.out.println("=======================================================");

        com.alumniportal.service.PortalService service = new com.alumniportal.service.PortalService();

        // 1. Alumni Map & Job List (AlumniNotVerifiedException)
        System.out.println("\n--- [1] Testing Job Posting & AlumniNotVerifiedException ---");
        com.alumniportal.model.AlumniProfile alumni = new com.alumniportal.model.AlumniProfile(
                101, 101, 2020, "Computer Science", "Google", "Software Engineer"
        );
        service.registerAlumni(alumni);
        System.out.println("Registered Alumnus: " + alumni.getProfileId() + " (Status: " + alumni.getVerificationStatus() + ")");

        com.alumniportal.model.Job job1 = new com.alumniportal.model.Job(
                1, "Java Developer", "Google", "Full-time backend role", "Remote", 101
        );

        try {
            System.out.println("Attempting to post job while unverified...");
            service.postJob(101, job1);
        } catch (com.alumniportal.exception.AlumniNotVerifiedException e) {
            System.out.println(" CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        }

        System.out.println("Admin verifies alumnus profile...");
        alumni.verifyProfile();
        service.postJob(101, job1);
        System.out.println(" Job successfully added to List<Job>! Total jobs: " + service.getAllJobs().size());

        // 2. Event RSVP Set & Capacity (DuplicateRsvpException & EventCapacityExceededException)
        System.out.println("\n--- [2] Testing Event RSVP Set & Capacity Exceptions ---");
        com.alumniportal.model.Event event = new com.alumniportal.model.Event(
                501, "AI & Cloud Alumni Summit", "Annual Networking Event", "Auditorium A", 2
        );
        service.createEvent(event);
        System.out.println("Created Event: '" + event.getTitle() + "' with Capacity = " + event.getCapacity());

        // RSVP User 1
        service.rsvpEvent(501, 1001);
        System.out.println(" User 1001 registered. Total RSVPs: " + event.getRegisteredCount());

        // Duplicate RSVP by User 1
        try {
            System.out.println("Attempting duplicate RSVP for User 1001...");
            service.rsvpEvent(501, 1001);
        } catch (com.alumniportal.exception.DuplicateRsvpException e) {
            System.out.println(" CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        }

        // RSVP User 2
        service.rsvpEvent(501, 1002);
        System.out.println(" User 1002 registered. Total RSVPs: " + event.getRegisteredCount());

        // Exceed Capacity with User 3
        try {
            System.out.println("Attempting registration for User 1003 beyond capacity...");
            service.rsvpEvent(501, 1003);
        } catch (com.alumniportal.exception.EventCapacityExceededException e) {
            System.out.println(" CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        }

        // 3. Mentorship Requests Queue (FIFO Queue)
        System.out.println("\n--- [3] Testing Mentorship Request Queue (FIFO) ---");
        service.enqueueMentorshipRequest(new com.alumniportal.model.MentorshipRequest(1, 201, 101, "System Design"));
        service.enqueueMentorshipRequest(new com.alumniportal.model.MentorshipRequest(2, 202, 101, "Resume Review"));
        service.enqueueMentorshipRequest(new com.alumniportal.model.MentorshipRequest(3, 203, 101, "Spring Boot Prep"));
        System.out.println("Enqueued 3 requests. Queue size: " + service.getPendingMentorshipCount());

        System.out.println("Processing queue in FIFO order:");
        while (service.getPendingMentorshipCount() > 0) {
            com.alumniportal.model.MentorshipRequest req = service.processNextMentorshipRequest();
            System.out.println("  Processed -> " + req);
        }

        // 4. Donations (InvalidDonationAmountException)
        System.out.println("\n--- [4] Testing Donations & InvalidDonationAmountException ---");
        try {
            System.out.println("Attempting donation with amount -100...");
            service.processDonation(101, -100.0);
        } catch (com.alumniportal.exception.InvalidDonationAmountException e) {
            System.out.println(" CAUGHT EXPECTED EXCEPTION: " + e.getMessage());
        }

        service.processDonation(101, 2500.0);
        service.processDonation(102, 1500.0);
        System.out.println(" Total Donations Collected: $" + service.getTotalDonations());
        System.out.println("=======================================================\n");
    }
}

