package com.hcl.generics.util;

import com.hcl.generics.model.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvProductLoader {

    public List<Product> loadProducts() throws IOException {
        InputStream input =
                getClass().getResourceAsStream("/products.csv");

        if (input == null) {
            throw new IOException("products.csv not found");
        }

        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                if (line.isBlank()) {
                    continue;
                }

                String[] columns = line.split(",", -1);

                if (columns.length != 3) {
                    throw new IOException("Invalid CSV row: " + line);
                }

                try {
                    String id = columns[0].trim();
                    String name = columns[1].trim();
                    double price = Double.parseDouble(columns[2].trim());

                    products.add(new Product(id, name, price));
                } catch (NumberFormatException exception) {
                    throw new IOException(
                            "Invalid product price in row: " + line,
                            exception);
                }
            }
        }

        return products;
    }
}
