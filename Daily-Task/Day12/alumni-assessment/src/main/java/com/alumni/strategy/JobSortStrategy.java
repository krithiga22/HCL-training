package com.alumni.strategy;

import com.alumni.model.Job;
import java.util.Comparator;

public class JobSortStrategy {

    // Sort by company name
    public static Comparator<Job> byCompany() {
        return Comparator.comparing(
                Job::getCompany,
                String.CASE_INSENSITIVE_ORDER
        );
    }

    // Sort by location
    public static Comparator<Job> byLocation() {
        return Comparator.comparing(
                Job::getLocation,
                String.CASE_INSENSITIVE_ORDER
        );
    }

    // Sort by title
    public static Comparator<Job> byTitle() {
        return Comparator.comparing(
                Job::getTitle,
                String.CASE_INSENSITIVE_ORDER
        );
    }
}
