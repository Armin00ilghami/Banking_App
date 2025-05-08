package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankingAppTest {

    private SavingAccount savingAccount ;
    private WithdrawalBankingService withdrawalBankingService;
    private FixedDepositAccount fdAccount;
    private BankingService fixedDepositBankingService;
    private int fixedDepositedAmount;
    private int savingDepositedAmount;

    @BeforeEach
    void setUp() {
        savingAccount  = new SavingAccount("ACN123", "Ali", 999912345, "ali@xyz.com");
        fdAccount = new FixedDepositAccount("ACN123", "Ali", 999912345, "ali@xyz.com");
        withdrawalBankingService = new WithdrawalBankingService(savingAccount);
        savingDepositedAmount = 5000;
        withdrawalBankingService.depositMoney(savingDepositedAmount);
        fixedDepositBankingService = new BankingService(fdAccount);
        fixedDepositedAmount = 25000;
        fixedDepositBankingService.depositMoney(fixedDepositedAmount);
    }

    @Test
    void shouldAbleToDepositMoney(){
        Assertions.assertEquals(savingDepositedAmount, withdrawalBankingService.getAccountBalance());
    }

    @Test
    void shouldAbleToDepositMoneyToFixedDeposit(){
        Assertions.assertEquals(fixedDepositedAmount, fixedDepositBankingService.getAccountBalance());
//        BankingService fixedDepositBankingService = new BankingService(fdAccount);
//        fixedDepositBankingService.depositMoney(25000);
//        Assertions.assertEquals(25000, fixedDepositBankingService.getAccountBalance());
    }

    @Test
    void shouldAbleToWithdrawMoney(){
        withdrawalBankingService.withdrawMoney(2000);
        Assertions.assertEquals(3000, withdrawalBankingService.getAccountBalance());
    }

    @Test
    void shouldNotAbleToWithdrawMoneyFromFixedDeposit(){
      //  fixedDepositBankingService.withdrawMoney(2000);   Actually we cannot withdraw money from fixed deposit
        Assertions.assertEquals(25000, fixedDepositBankingService.getAccountBalance());
    }

    @Test
    void shouldAbleToGetPrintDataForPassbook(){
        var printService = new PrintService(savingAccount);
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
        NotificationService notificationService = new SMSNotificationService(savingAccount);

        String expected = String.format(
                "Hi %s, Please don't this OTP with anyone. OTP send to your number %s" , savingAccount.name(),savingAccount.mobileNum()
        );
        Assertions.assertEquals(expected,notificationService.sendOtp());
    }

    @Test
    void shouldAbleSendOTPToEmailWithGreetingsAndDisclaimer() {
        NotificationService notificationService = new EmailNotificationService(savingAccount);

        String expected = String.format(
                "Hi %s, Please don't this OTP with anyone. OTP send to your email %s" , savingAccount.name(),savingAccount.email()
        );
        Assertions.assertEquals(expected,notificationService.sendOtp());
    }

}
