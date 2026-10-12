
package com.hcl.orders;

import com.hcl.orders.exception.InsufficientStockException;
import com.hcl.orders.exception.InvalidQuantityException;

public class OrderProcessor {

    private int stock = 10;

    public void processOrder(int quantity)
            throws InsufficientStockException {

        try {
            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than zero.");
            }

            if (quantity > stock) {
                throw new InsufficientStockException(
                        "Insufficient stock. Available stock: " + stock);
            }

            stock -= quantity;
            System.out.println("Order successful!");
            System.out.println("Quantity ordered: " + quantity);
            System.out.println("Remaining stock: " + stock);

        } catch (InvalidQuantityException | InsufficientStockException e) {

            System.out.println("Order failed: " + e.getMessage());
            throw e;

        } finally {
            System.out.println("Order processing audit completed.");
        }
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        int[] quantities = { 3, 0, 12, 2 };

        for (int quantity : quantities) {
            try {
                processor.processOrder(quantity);
            } catch (InvalidQuantityException | InsufficientStockException e) {
                System.out.println("Handled error: " + e.getMessage());
            }

            System.out.println("Ready for the next order.\n");
        }

        System.out.println("All orders processed.");
    }
}