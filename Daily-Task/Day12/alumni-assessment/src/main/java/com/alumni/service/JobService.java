
package com.alumni.service;

import com.alumni.model.Job;

import java.util.*;

public class JobService {

    private final Map<String, Job> jobs = new HashMap<>();

    // Add a job
    public void addJob(Job job) {

        if (job == null) {
            throw new IllegalArgumentException(
                    "Job cannot be null"
            );
        }

        if (job.getJobId() == null || job.getJobId().isBlank()) {
            throw new IllegalArgumentException(
                    "Job ID cannot be empty"
            );
        }

        String jobId = job.getJobId().trim();

        if (jobs.containsKey(jobId)) {
            throw new IllegalArgumentException(
                    "Duplicate job ID: " + jobId
            );
        }

        jobs.put(jobId, job);

        System.out.println("Job posted successfully!");
    }

    // Find job by ID
    public Job findJob(String jobId) {

        if (jobId == null || jobId.isBlank()) {
            throw new IllegalArgumentException(
                    "Job ID cannot be empty"
            );
        }

        Job job = jobs.get(jobId.trim());

        if (job == null) {
            throw new NoSuchElementException(
                    "Job not found: " + jobId
            );
        }

        return job;
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return List.copyOf(jobs.values());
    }

    // Sort jobs by company
    public List<Job> getJobsSortedByCompany() {

        List<Job> result = new ArrayList<>(jobs.values());

        result.sort(
                Comparator.comparing(
                        Job::getCompany,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        return result;
    }

    // Display jobs
    public void displayJobs() {

        System.out.println("\n--- AVAILABLE JOBS ---");

        for (Job job : getJobsSortedByCompany()) {
            System.out.println(job);
        }
    }
}
