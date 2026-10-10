
package com.alumniportal.model;

public class Job {

    private int jobId;
    private String title;
    private String company;
    private String description;
    private String location;
    private int postedByUserId;

    public Job(int jobId, String title, String company,
               String description, String location,
               int postedByUserId) {
        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.description = description;
        this.location = location;
        this.postedByUserId = postedByUserId;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getPostedByUserId() {
        return postedByUserId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
