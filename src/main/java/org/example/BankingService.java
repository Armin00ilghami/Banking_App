package org.example;

public class BankingService {

    private BankAccount account;

    public  BankingService(BankAccount account) {
        this.account = account;
    }

    public void depositMoney(double amt) {
        account.setBalance(account.getBalance() + amt );
    }

    public double getAccountBalance() {
        return account.getBalance();
    }

    public void withdrawMoney(double amt) {
        this.account.setBalance( this.account.getBalance() - amt );
    }

    public String getPassbookPrintData() {
        return "Current balance is " + account.getBalance();
    }
}
