package com.alumniportal.model;

public class AdminRole extends PortalRole {

    @Override
    public String getRoleName() {
        return "ADMIN";
    }

    @Override
    public String getPermissions() {
        return "Verify alumni, manage users, manage events";
    }
}