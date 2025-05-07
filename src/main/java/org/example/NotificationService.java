package org.example;

public class NotificationService {

    private BankAccount account;

    public NotificationService(BankAccount account) {
        this.account = account;
    }

    public String sendOtp() {
        return "OTP send to number " + account.mobileNum();
    }

}
