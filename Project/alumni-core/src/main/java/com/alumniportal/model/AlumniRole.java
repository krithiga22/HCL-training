package com.alumniportal.model;

public class AlumniRole extends PortalRole {

    @Override
    public String getRoleName() {
        return "ALUMNI";
    }

    @Override
    public String getPermissions() {
        return "Manage profile, post jobs, mentor students";
    }
}