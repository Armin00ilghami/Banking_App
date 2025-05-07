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
    void shouldAbleSendOTPToMobile() {
        NotificationService notificationService = new NotificationService(account);
        Assertions.assertEquals(
                "OTP send to number " + account.mobileNum() ,notificationService.sendOtp());
    }
}
