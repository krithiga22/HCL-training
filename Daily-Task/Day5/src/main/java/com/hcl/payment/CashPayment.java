
package com.hcl.payment;

public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid Rs. " + amount + " using Cash.");
    }
}