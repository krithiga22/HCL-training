
package com.hcl.orders;

import com.hcl.orders.exception.InvalidQuantityException;

public class ExceptionChainingDemo {

    public static void main(String[] args) {
        OrderInputService service = new OrderInputService();

        try {
            int quantity = service.parseQuantity("abc");
            System.out.println("Quantity: " + quantity);

        } catch (InvalidQuantityException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println(
            "Cause preserved: " +
            (e.getCause() instanceof NumberFormatException)
);
}
    }
}