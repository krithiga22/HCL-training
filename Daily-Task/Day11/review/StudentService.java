package Day11.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Locale;

public class StudentService {

    private final List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null");
        }

        if (existsById(student.getStudentId())) {
            throw new IllegalArgumentException(
                    "Duplicate student ID: " + student.getStudentId());
        }

        students.add(student);
    }

    // Remove student
    public boolean removeStudent(String studentId) {

        String id = normalizeId(studentId);

        return students.removeIf(
                student -> student.getStudentId().equals(id));
    }

    // Find student
    public Optional<Student> findStudent(String studentId) {

        String id = normalizeId(studentId);

        return students.stream()
                .filter(student ->
                        student.getStudentId().equals(id))
                .findFirst();
    }

    // Return independent unmodifiable snapshot
    public List<Student> getAllStudents() {
        return List.copyOf(students);
    }

    // Display students
    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Check duplicate ID
    public boolean existsById(String studentId) {

        String id = normalizeId(studentId);

        return students.stream()
                .anyMatch(student ->
                        student.getStudentId().equals(id));
    }

    // Normalize and validate ID
    private String normalizeId(String studentId) {

        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Student ID cannot be null or blank");
        }

        return studentId.trim().toUpperCase(Locale.ROOT);
    }

    public int getStudentCount() {
        return students.size();
    }

    // Testing
    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student s1 = new Student(
                "S101", "Alice", "alice@gmail.com", "IT");

        Student s2 = new Student(
                "S102", "Bob", "bob@gmail.com", "CSE");

        service.addStudent(s1);
        service.addStudent(s2);

        System.out.println("All Students:");
        service.displayAllStudents();

        System.out.println("\nFind Student S101:");
        System.out.println(service.findStudent("s101"));

        System.out.println("\nDuplicate Test:");

        try {
            service.addStudent(
                    new Student("S101", "Charlie",
                            "charlie@gmail.com", "ECE"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nRemove Student S102:");
        System.out.println(service.removeStudent("S102"));

        System.out.println("\nTotal Students:");
        System.out.println(service.getStudentCount());

        System.out.println("\nTest Invalid Input:");

        try {
            service.addStudent(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTest List Protection:");

        List<Student> result = service.getAllStudents();

        try {
            result.add(s2);
        } catch (UnsupportedOperationException e) {
            System.out.println("External modification prevented.");
        }
    }
}