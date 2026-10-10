
package com.hcl.bank.service;

import com.hcl.bank.model.BankAccount;

public class BankService {

    public void showBalance(BankAccount account) {
        System.out.println(
            "Account: " + account.getAccountNumber()
        );
        System.out.println(
            "Balance: Rs. " + account.getBalance()
        );
    }

    public void deposit(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public boolean withdraw(BankAccount account, double amount) {
        return account.withdraw(amount);
    }
}