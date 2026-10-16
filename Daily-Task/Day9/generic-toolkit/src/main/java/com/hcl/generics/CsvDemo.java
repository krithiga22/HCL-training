package com.hcl.generics;

import com.hcl.generics.model.Product;
import com.hcl.generics.repository.CrudRepository;
import com.hcl.generics.repository.InMemoryRepository;
import com.hcl.generics.util.CsvProductLoader;

import java.io.IOException;
import java.util.List;

public class CsvDemo {

    public static void main(String[] args) {
        try {
            List<Product> loadedProducts =
                    new CsvProductLoader().loadProducts();

            CrudRepository<Product, String> repository =
                    new InMemoryRepository<>(Product::getId);

            loadedProducts.forEach(repository::save);

            System.out.println("Products loaded into repository:");
            repository.findAll().forEach(System.out::println);

            System.out.println("Total products: "
                    + repository.findAll().size());

            System.out.println("Find P102: "
                    + repository.findById("P102"));

        } catch (IOException exception) {
            System.err.println("Import failed: "
                    + exception.getMessage());
        }
    }
}
