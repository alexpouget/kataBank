package fr.lacombe.transaction;

import fr.lacombe.amount.Amount;
import fr.lacombe.transaction.Credit;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CreditTest {

    private LocalDate date;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.of(2012, 01, 10);
    }

    @Test
    public void updateSolde0To0() {
        Credit credit = new Credit(Amount.parse(0), date);
        Amount solde = credit.updateSolde(Amount.parse(0));
        Assertions.assertThat(solde).isEqualTo(Amount.parse(0));
    }

    @Test
    public void updateSolde0To1() {
        Credit credit = new Credit(Amount.parse(0), date);
        Amount solde = credit.updateSolde(Amount.parse(1));
        Assertions.assertThat(solde).isEqualTo(Amount.parse(1));
    }

    @Test
    public void updateSolde1To1() {
        Credit credit = new Credit(Amount.parse(1), date);
        Amount solde = credit.updateSolde(Amount.parse(1));
        Assertions.assertThat(solde).isEqualTo(Amount.parse(2));
    }
}