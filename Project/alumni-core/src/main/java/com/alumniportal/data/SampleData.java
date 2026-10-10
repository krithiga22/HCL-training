
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
}

