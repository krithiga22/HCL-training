package com.alumni.model;

import com.alumni.interfaces.JobPostable;
import com.alumni.repository.Identifiable;

public class Alumni extends User
        implements JobPostable, Identifiable<String> {

    private String batch;
    private String department;
    private String company;

    public Alumni(String userId, String name, String email,
                  String batch, String department, String company) {
        super(userId, name, email);
        this.batch = batch;
        this.department = department;
        this.company = company;
    }

    @Override
    public String getId() {
        return getUserId();
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- ALUMNI DETAILS ---");
        displayBasicInfo();
        System.out.println("Batch: " + batch);
        System.out.println("Department: " + department);
        System.out.println("Company: " + company);
    }

    @Override
    public void postJob(Job job) {
        System.out.println(getName() + " posted a job: " + job.getTitle());
    }
}
