package org.example;

public class BankAccount {
    private String accNum;
    private String name;
    private int mobileNum;
    private String email;
    private double balance;
    private double newBalance;

    public BankAccount(String accNum, String name, int mobileNum, String email) {
        this.accNum = accNum;
        this.name = name;
        this.mobileNum = mobileNum;
        this.email = email;
        this.balance = 0 ;
    }

    public double getBalance() {
        return balance ;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance ;
    }

}
