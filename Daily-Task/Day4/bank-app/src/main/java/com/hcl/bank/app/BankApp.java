
package com.hcl.bank.app;

import com.hcl.bank.model.BankAccount;
import com.hcl.bank.service.BankService;

public class BankApp {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("ACC101", 5000.0);

        BankService service = new BankService();

        System.out.println("===== BANK ACCOUNT =====");

        service.showBalance(account);

        System.out.println("\nDepositing Rs. 1000...");
        service.deposit(account, 1000.0);
        service.showBalance(account);

        System.out.println("\nWithdrawing Rs. 900...");
        boolean success = service.withdraw(account, 900.0);

        System.out.println("Withdrawal successful: " + success);
        service.showBalance(account);

        BankAccount sameAccount =
                new BankAccount("ACC101", 200.0);

        System.out.println("\n===== OOP DEMONSTRATION =====");

        System.out.println(
            "Accounts equal: " + account.equals(sameAccount)
        );

        System.out.println(
            "Total accounts created: "
                    + BankAccount.getAccountCount()
        );
    }
}