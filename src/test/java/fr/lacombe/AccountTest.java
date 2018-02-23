package fr.lacombe;

import fr.lacombe.amount.Amount;
import fr.lacombe.reporting.BankStatement;
import fr.lacombe.transaction.Credit;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void printEmptyStatement() {
        Account account = new Account();
        BankStatement expectedBankStatement = new BankStatement();
        assertThat(account.printTransactions()).isEqualTo(expectedBankStatement);
    }

    @Test
    public void printStatementWithOneTransaction() {
        Account account = new Account();
        account.addTransaction(new Credit(Amount.parse(1000), LocalDate.of(2018, 01, 10)));
        BankStatement expectedBankStatement = new BankStatement();
        expectedBankStatement.append("2018-01-10 || 1000.00 || || 1000.00");
        assertThat(account.printTransactions()).isEqualTo(expectedBankStatement);
    }
}