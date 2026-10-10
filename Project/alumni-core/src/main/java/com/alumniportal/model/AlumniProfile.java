
package com.alumniportal.model;

import com.alumniportal.constants.Constants;

public class AlumniProfile {

    private int profileId;
    private int userId;
    private int graduationYear;
    private String department;
    private String company;
    private String jobTitle;
    private String verificationStatus;

    public AlumniProfile(int profileId, int userId,
                         int graduationYear, String department,
                         String company, String jobTitle) {
        this.profileId = profileId;
        this.userId = userId;
        this.graduationYear = graduationYear;
        this.department = department;
        this.company = company;
        this.jobTitle = jobTitle;
        this.verificationStatus = Constants.STATUS_PENDING;
    }

    public int getProfileId() {
        return profileId;
    }

    public int getUserId() {
        return userId;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String getDepartment() {
        return department;
    }

    public String getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void verifyProfile() {
        this.verificationStatus = Constants.STATUS_VERIFIED;
    }

    public void rejectProfile() {
        this.verificationStatus = Constants.STATUS_REJECTED;
    }
}
