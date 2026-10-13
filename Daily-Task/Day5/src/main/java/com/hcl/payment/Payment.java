package com.hcl.payment;
public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void pay();

    public void pay(String currency) {
        System.out.println("Amount: " + currency + " " + amount);
        pay();
    }

    public double getAmount() {
        return amount;
    }
}