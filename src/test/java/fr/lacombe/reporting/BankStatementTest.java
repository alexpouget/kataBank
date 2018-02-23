package fr.lacombe.reporting;

import fr.lacombe.reporting.BankStatement;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BankStatementTest {

    @Test
    public void appendBonjour() {
        BankStatement bankStatement = new BankStatement();
        bankStatement.append("bonjour");
        Assertions.assertThat(bankStatement.toString()).isEqualTo("date || credit || debit || balance\n" + "bonjour");
    }
}