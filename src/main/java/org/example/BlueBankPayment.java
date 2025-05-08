package org.example;

public class BlueBankPayment implements UPIPaymentsInterface {
    private SavingAccount savingAccount;

    public BlueBankPayment(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    @Override
    public String payMoney(double amt, String reciverUPI) {

        if (amt > savingAccount.getBalance())
            return "UPI payment failed. Insufficient balance";
        String paidStatement = String.format("%.2f has been paid to UPI id %s.", amt, reciverUPI);
        return String.format("%s", paidStatement);
        
    }

}
