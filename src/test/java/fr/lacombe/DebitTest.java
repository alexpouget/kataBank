package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class DebitTest {

    LocalDate date;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.of(2012, 01, 10);
    }

    @Test
    public void updateSolde0To0() {
        Debit debit = new Debit(new Amount(0), date);
        Amount solde = debit.updateSolde(new Amount(0));
        assertThat(solde).isEqualTo(new Amount(0));
    }

    @Test
    public void updateSolde1To0() {
        Debit debit = new Debit(new Amount(1), date);
        Amount solde = debit.updateSolde(new Amount(1));
        assertThat(solde).isEqualTo(new Amount(0));
    }

    @Test
    public void updateSolde3To2() {
        Debit debit = new Debit(new Amount(1), date);
        Amount solde = debit.updateSolde(new Amount(3));
        assertThat(solde).isEqualTo(new Amount(2));
    }

}