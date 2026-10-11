
package com.hcl.payment;

public class CardPayment extends Payment implements Refundable {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid Rs. " + amount + " using Card.");
    }

    @Override
    public void refund(double refundAmount) {
        if (refundAmount > 0 && refundAmount <= amount) {
            System.out.println("Card refund successful: Rs. " + refundAmount);
        } else {
            System.out.println("Invalid refund amount.");
        }
    }
}