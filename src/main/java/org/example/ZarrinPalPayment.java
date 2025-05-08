package org.example;

public class ZarrinPalPayment implements UPIPaymentsInterface , CashBackInterface{

    private double cashbackPercent;
    private SavingAccount savingAccount;

    public ZarrinPalPayment(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String payMoney(double amt , String reciverUPI) {

        if (amt > savingAccount.getBalance())
            return "UPI payment failed. Insufficient balance";
        String paidStatement = String.format("%.2f has been paid to UPI id %s.", amt, reciverUPI);
        return String.format("%s %s", paidStatement, this.getCashBackAsCreditBalance(amt));

    }

    @Override
    public String getCashBackAsCreditBalance(double amt) {
        cashbackPercent = 0.05;
        return String.format("Have received %.2f cashback", amt * cashbackPercent);
    }

}
