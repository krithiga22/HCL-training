package com.alumni.model;

import com.alumni.repository.Identifiable;

public class Job implements Comparable<Job>, Identifiable<String> {

    private String jobId;
    private String title;
    private String company;
    private String location;
    private String postedBy;

    public Job(String jobId, String title, String company,
               String location, String postedBy) {
        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.location = location;
        this.postedBy = postedBy;
    }

    @Override
    public String getId() {
        return jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getPostedBy() {
        return postedBy;
    }

    @Override
    public int compareTo(Job other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId
                + " | Title: " + title
                + " | Company: " + company
                + " | Location: " + location;
    }
}
