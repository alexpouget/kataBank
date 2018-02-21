package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void printEmptyDeposit() {
        Account account = new Account();
        BankStatement expectedBankStatement = new BankStatement("date || credit || debit || balance");
        Assertions.assertThat(account.printStatement()).isEqualTo(expectedBankStatement);

    }
}