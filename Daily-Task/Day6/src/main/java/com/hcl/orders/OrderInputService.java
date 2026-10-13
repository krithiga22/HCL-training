
package com.hcl.orders;

import com.hcl.orders.exception.InvalidQuantityException;

public class OrderInputService {

    public int parseQuantity(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidQuantityException(
                    "Order quantity must be a valid integer.", e
            );
        }
    }
}