
package com.hcl.memory;

public class StackHeapDemo {

    public static void main(String[] args) {
        int batchYear = 2027;
        String studentName = new String("Krithiga");

        printProfile(studentName, batchYear);
    }

    private static void printProfile(String name, int year) {
        System.out.println("Student: " + name);
        System.out.println("Batch: " + year);
    }
}
