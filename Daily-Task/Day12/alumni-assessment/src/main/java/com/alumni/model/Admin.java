package com.alumni.model;

public class Admin extends User {

    public Admin(String userId, String name, String email) {
        super(userId, name, email);
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- ADMIN DETAILS ---");
        displayBasicInfo();
    }
}
