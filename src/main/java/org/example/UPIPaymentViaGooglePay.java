package org.example;

public class UPIPaymentViaGooglePay implements UPIPaymentsInterface , ScratchCardInterface , CashBackInterface {

    private SavingAccount savingAccount;
    private double cashbackPercent;

    public UPIPaymentViaGooglePay(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String payMoney(double amt , String reciverUPI) {

        if (amt > savingAccount.getBalance())
            return "UPI payment failed. Insufficient balance";
        String paidStatement = String.format("%.2f has been paid to UPI id %s.", amt, reciverUPI);
        return String.format("%s %s %s", paidStatement, this.getScratchCard(), this.getCashBackAsCreditBalance(amt));

    }

    @Override
    public String getScratchCard() {
        return "Have received a scratch card.";
    }

    @Override
    public String getCashBackAsCreditBalance(double amt) {
        cashbackPercent = 0.01;
        return String.format("Have received %.2f cashback", amt * cashbackPercent);
    }

}
