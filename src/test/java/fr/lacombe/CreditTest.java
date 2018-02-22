package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CreditTest {

    private LocalDate date;

    @Before
    public void setUp() throws Exception {
        date = LocalDate.of(2012, 01, 10);
    }

    @Test
    public void updateSolde0To0() {
        Credit credit = new Credit(new Amount(0), date);
        Amount solde = credit.updateSolde(new Amount(0));
        Assertions.assertThat(solde).isEqualTo(new Amount(0));
    }

    @Test
    public void updateSolde0To1() {
        Credit credit = new Credit(new Amount(0), date);
        Amount solde = credit.updateSolde(new Amount(1));
        Assertions.assertThat(solde).isEqualTo(new Amount(1));
    }

    @Test
    public void updateSolde1To1() {
        Credit credit = new Credit(new Amount(1), date);
        Amount solde = credit.updateSolde(new Amount(1));
        Assertions.assertThat(solde).isEqualTo(new Amount(2));
    }
}