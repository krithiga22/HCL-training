package com.alumniportal.model;

public class StudentRole extends PortalRole {

    @Override
    public String getRoleName() {
        return "STUDENT";
    }

    @Override
    public String getPermissions() {
        return "Search alumni, request mentorship, view jobs";
    }
}