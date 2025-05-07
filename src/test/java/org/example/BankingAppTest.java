package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankingAppTest {

    @Test
    void shouldAbleToDepositMoney(){
        BankAccount bankAccount = new BankAccount("ACN123", "Ali", 999912345, "ali@xyz.com");
        BankingService bankingService = new BankingService(bankAccount);
        bankingService.depositMoney(5000);

        Assertions.assertEquals(5000, bankingService.getAccountBalance());
    }

}
