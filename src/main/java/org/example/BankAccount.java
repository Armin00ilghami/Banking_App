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

    public int mobileNum() {
        return this.mobileNum;
    }

    public void addMoney(double amt) {
        this.balance += amt;
    }

    public String name (){
        return this.name;
    }

    public String email (){
        return this.email;
    }

}
