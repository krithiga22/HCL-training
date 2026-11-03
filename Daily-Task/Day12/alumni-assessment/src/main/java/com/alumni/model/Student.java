package com.alumni.model;

public class Student extends User {

    private String department;
    private int year;

    public Student(String userId, String name, String email,
                   String department, int year) {

        super(userId, name, email);
        this.department = department;
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- STUDENT DETAILS ---");
        displayBasicInfo();
        System.out.println("Department: " + department);
        System.out.println("Year: " + year);
    }
}
