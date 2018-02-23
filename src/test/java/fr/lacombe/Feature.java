package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

public class Feature {

    @Test
    public void acceptanceTest() {
        Account account = new Account();
        AccountService bank = new AccountService(account);
        bank.deposit(Amount.parse(1000), LocalDate.of(2012, 01, 10));
        bank.deposit(Amount.parse(2000), LocalDate.of(2012, 01, 13));
        bank.withdrawal(Amount.parse(500), LocalDate.of(2012, 01, 14));
        BankStatement bankStatementExpected = new BankStatement();
        bankStatementExpected.append("2012-01-14 || || 500.00 || 2500.00\n" +
                "2012-01-13 || 2000.00 || || 3000.00\n" +
                "2012-01-10 || 1000.00 || || 1000.00");
        Assertions.assertThat(bank.printStatement().toString()).isEqualTo(bankStatementExpected.toString());
    }

}
