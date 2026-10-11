
package com.hcl.payment;

public class UpiPayment extends Payment implements Refundable {

    public UpiPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid Rs. " + amount + " using UPI.");
    }

    @Override
    public void refund(double refundAmount) {
        if (refundAmount > 0 && refundAmount <= amount) {
            System.out.println("UPI refund successful: Rs. " + refundAmount);
        } else {
            System.out.println("Invalid refund amount.");
        }
    }
}