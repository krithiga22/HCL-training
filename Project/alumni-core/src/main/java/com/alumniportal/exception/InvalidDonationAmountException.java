package com.alumniportal.exception;
public class InvalidDonationAmountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidDonationAmountException() {
        super("Donation failed: Donation amount must be greater than zero.");
    }

    public InvalidDonationAmountException(String message) {
        super(message);
    }

    public InvalidDonationAmountException(double amount) {
        super("Donation failed: Invalid donation amount of " + amount + ". Amount must be greater than zero.");
    }

    public InvalidDonationAmountException(String message, Throwable cause) {
        super(message, cause);
    }
}
