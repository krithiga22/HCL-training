package com.hcl.functional;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
public class FilterEngine {

    public static void main(String[] args) {

        // Creating products
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 55000, "Electronics", true),
            new Product(2, "Mouse", 800, "Electronics", true),
            new Product(3, "Chair", 3500, "Furniture", false),
            new Product(4, "Mobile", 25000, "Electronics", true),
            new Product(5, "Table", 7000, "Furniture", true)
        );

        // Predicate 1: Price below 30000
        Predicate<Product> priceFilter =
                product -> product.getPrice() < 30000;

        // Predicate 2: Electronics category
        Predicate<Product> categoryFilter =
                product -> product.getCategory().equals("Electronics");

        // Predicate 3: Product in stock
        Predicate<Product> stockFilter =
                product -> product.isInStock();

        // Combining all three predicates
        Predicate<Product> finalFilter =
                priceFilter.and(categoryFilter).and(stockFilter);

        // Filtering products
        System.out.println("===== FILTERED PRODUCTS =====");

        products.stream()
                .filter(finalFilter)
                .forEach(System.out::println);
        Function<Product, String> productDetails =
        product -> product.getName().toUpperCase()
                + " costs Rs." + product.getPrice();

        // Apply Function to filtered products
        System.out.println("\n===== TRANSFORMED PRODUCTS =====");

        products.stream()
                .filter(finalFilter)
                .map(productDetails)
                .forEach(System.out::println);
        // Consumer: Print product details
        Consumer<Product> productPrinter = product -> {
            System.out.println("--------------------------");
            System.out.println("Product Name: " + product.getName());
            System.out.println("Price: Rs." + product.getPrice());
            System.out.println("Category: " + product.getCategory());
            System.out.println("In Stock: " + product.isInStock());
        };

        // Print filtered products
        System.out.println("\n===== PRODUCT DETAILS =====");

        products.stream()
                .filter(finalFilter)
                .forEach(productPrinter);

        // Supplier: Create a default product
        Supplier<Product> defaultProduct = () ->
                new Product(
                        6,
                        "Keyboard",
                        1500,
                        "Electronics",
                        true
                );

        // Get the default product
        Product newProduct = defaultProduct.get();

        System.out.println("\n===== DEFAULT PRODUCT =====");
        System.out.println(newProduct);
    }
}