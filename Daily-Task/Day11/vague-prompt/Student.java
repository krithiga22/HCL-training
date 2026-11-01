public class Student {
    private String studentId;
    private String name;
    private String email;
    private String department;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(String studentId, String name, String email, String department) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("========== Student Details ==========");
        System.out.println("Student ID  : " + studentId);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.println("Department  : " + department);
        System.out.println("=====================================");
    }

    // Main method for testing
    public static void main(String[] args) {
        Student student = new Student("STU101", "Alice Johnson", "alice.johnson@example.com", "Computer Science");
        student.displayDetails();
    }
}
