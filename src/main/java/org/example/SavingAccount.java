package org.example;

public class SavingAccount extends BankAccount{
    public SavingAccount(String accNum, String name, int mobileNum, String email) {
        super(accNum, name, mobileNum, email);
    }

    public void withdrawMoney(double amt) {
        this.setBalance(this.getBalance() - amt);
    }

}
