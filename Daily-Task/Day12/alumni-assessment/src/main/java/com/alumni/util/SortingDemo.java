package com.alumni.util;

import com.alumni.model.Job;
import com.alumni.strategy.JobSortStrategy;

import java.util.ArrayList;
import java.util.List;

public class SortingDemo {

    public static void main(String[] args) {

        List<Job> jobs = new ArrayList<>();

        jobs.add(new Job(
                "J101", "Java Developer",
                "TCS", "Chennai", "A101"
        ));

        jobs.add(new Job(
                "J102", "Software Engineer",
                "Google", "Bangalore", "A102"
        ));

        jobs.add(new Job(
                "J103", "Backend Developer",
                "Infosys", "Hyderabad", "A103"
        ));

        // Natural sorting using Comparable
        System.out.println("\n--- SORT BY TITLE (Comparable) ---");

        jobs.sort(null);

        jobs.forEach(System.out::println);

        // Custom sorting using Comparator
        System.out.println("\n--- SORT BY COMPANY (Comparator) ---");

        jobs.sort(JobSortStrategy.byCompany());

        jobs.forEach(System.out::println);

        // Custom sorting using Comparator
        System.out.println("\n--- SORT BY LOCATION (Comparator) ---");

        jobs.sort(JobSortStrategy.byLocation());

        jobs.forEach(System.out::println);
    }
}