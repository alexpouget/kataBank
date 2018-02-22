package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankStatementTest {

    @Test
    public void appendBonjour() {
        BankStatement bankStatement = new BankStatement();
        bankStatement.append("bonjour");
        Assertions.assertThat(bankStatement.toString()).isEqualTo("date || credit || debit || balance\n"+"bonjour");
    }
}