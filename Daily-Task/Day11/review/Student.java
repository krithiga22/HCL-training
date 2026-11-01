package Day11.review;

import java.util.Objects;
import java.util.Locale;

public class Student {

    // Student ID is immutable
    private final String studentId;

    private String name;
    private String email;
    private String department;

    public Student(String studentId, String name,
                   String email, String department) {

        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException("Student ID is required");
        }

        this.studentId = studentId.trim().toUpperCase(Locale.ROOT);

        setName(name);
        setEmail(email);
        setDepartment(department);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()
                || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Valid email is required");
        }
        this.email = email.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department is required");
        }
        this.department = department.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student other)) {
            return false;
        }

        return studentId.equals(other.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}