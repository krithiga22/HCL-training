
package com.hcl.bank.model;

import java.util.Objects;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private static int accountCount = 0;
    public BankAccount() {
        this("UNKNOWN", 0.0);
    }
    public BankAccount(String accountNumber) {
        this(accountNumber, 0.0);
    }
    public BankAccount(String accountNumber, double balance) {

        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException(
                "Account number cannot be empty"
            );
        }

        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException(
                "Initial balance cannot be negative or invalid"
            );
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        accountCount++;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountCount() {
        return accountCount;
    }
    public void deposit(double amount) {

        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive and valid"
            );
        }

        balance += amount;
    }
    public boolean withdraw(double amount) {

        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
    //    balance -= amount; 

        return true;
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) obj;

        return accountNumber.equals(other.accountNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}