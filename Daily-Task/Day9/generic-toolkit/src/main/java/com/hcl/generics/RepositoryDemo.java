package com.hcl.generics;

import com.hcl.generics.model.Product;
import com.hcl.generics.model.Student;
import com.hcl.generics.repository.InMemoryRepository;
import com.hcl.generics.repository.CrudRepository;

public class RepositoryDemo {

    public static void main(String[] args) {

        CrudRepository<Product, String> products =
                new InMemoryRepository<>(Product::getId);

        products.save(new Product("P101", "Java Book", 450.0));
        products.save(new Product("P102", "Notebook", 80.0));

        System.out.println("=== PRODUCTS ===");
        products.findAll().forEach(System.out::println);

        System.out.println("Find P101: "
                + products.findById("P101"));

        System.out.println("Delete P102: "
                + products.deleteById("P102"));

        System.out.println("Products after delete: "
                + products.findAll());

        CrudRepository<Student, Integer> students =
                new InMemoryRepository<>(Student::getId);

        students.save(new Student(1, "Anu"));
        students.save(new Student(2, "Krithiga"));

        System.out.println("\n=== STUDENTS ===");
        students.findAll().forEach(System.out::println);

        System.out.println("Find student 2: "
                + students.findById(2));
    }
}
