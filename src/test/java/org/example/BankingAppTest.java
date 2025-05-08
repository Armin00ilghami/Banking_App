package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankingAppTest {

    private BankAccount account;
    private BankingService bankingService;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACN123", "Ali", 999912345, "ali@xyz.com");
        bankingService = new BankingService(account);
        bankingService.depositMoney(5000);
    }

    @Test
    void shouldAbleToDepositMoney(){
        Assertions.assertEquals(5000, bankingService.getAccountBalance());
    }

    @Test
    void shouldAbleToWithdrawMoney(){
        bankingService.withdrawMoney(2000);
        Assertions.assertEquals(3000, bankingService.getAccountBalance());
    }

    @Test
    void shouldAbleToGetPrintDataForPassbook(){
        var printService = new PrintService(account);
        Assertions.assertEquals("Current balance is 5000.0", printService.getPassbookPrintData());
    }

    @Test
    void shouldGetTheLoanInterest(){
        LosnService losnService = new LosnService();
        Assertions.assertEquals(7, losnService.getInterestPercent("homeLoan"));
        Assertions.assertEquals(9, losnService.getInterestPercent("carLoan"));
        Assertions.assertEquals(12, losnService.getInterestPercent("personalLoan"));
    }

    @Test
    void shouldAbleSendOTPToMobileWithGreetingsAndDisclaimer() {
        NotificationService notificationService = new SMSNotificationService(account);

        String expected = String.format(
                "Hi %s, Please don't this OTP with anyone. OTP send to your number %s" , account.name(),account.mobileNum()
        );
        Assertions.assertEquals(expected,notificationService.sendOtp());
    }

    @Test
    void shouldAbleSendOTPToEmailWithGreetingsAndDisclaimer() {
        NotificationService notificationService = new EmailNotificationService(account);

        String expected = String.format(
                "Hi %s, Please don't this OTP with anyone. OTP send to your email %s" , account.name(),account.email()
        );
        Assertions.assertEquals(expected,notificationService.sendOtp());
    }

}
