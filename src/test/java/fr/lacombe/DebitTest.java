package fr.lacombe;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class DebitTest {

    LocalDate date;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.of(2012, 01, 10);
    }

    @Test
    public void updateSolde0To0() {
        Debit debit = new Debit(Amount.parse(0), date);
        Amount solde = debit.updateSolde(Amount.parse(0));
        assertThat(solde).isEqualTo(Amount.parse(0));
    }

    @Test
    public void updateSolde1To0() {
        Debit debit = new Debit(Amount.parse(1), date);
        Amount solde = debit.updateSolde(Amount.parse(1));
        assertThat(solde).isEqualTo(Amount.parse(0));
    }

    @Test
    public void updateSolde3To2() {
        Debit debit = new Debit(Amount.parse(1), date);
        Amount solde = debit.updateSolde(Amount.parse(3));
        assertThat(solde).isEqualTo(Amount.parse(2));
    }

}