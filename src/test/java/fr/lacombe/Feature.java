package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class Feature {

    @Test
    public void acceptanceTest() {
        Account account = new Account();
        AccountService bank = new AccountService(account);
        bank.deposit(new Amount(1000),LocalDate.of(2012,01,10));
        bank.deposit(new Amount(2000),LocalDate.of(2012,01,13));
        bank.withdrawal(new Amount(500),LocalDate.of(2012,01,14));
        BankStatement bankStatementExpected = new BankStatement("14/01/2012 || || 500.00 || 2500.00\n" +
                                                    "13/01/2012 || 2000.00 || || 3000.00\n" +
                                                    "10/01/2012 || 1000.00 || || 1000.00");
        Assertions.assertThat(bank.printStatement()).isEqualTo(bankStatementExpected);
    }

}
