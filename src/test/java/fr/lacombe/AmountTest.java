package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {

    @Test
    public void add0to0() {
        Amount amount = new Amount(0);
        amount.add(new Amount(0));
        Assertions.assertThat(amount).isEqualTo(new Amount(0));
    }

    @Test
    public void add0to1() {
        Amount amount = new Amount(0);
        amount.add(new Amount(1));
        Assertions.assertThat(amount).isEqualTo(new Amount(1));
    }

    @Test
    public void add1to1() {
        Amount amount = new Amount(1);
        amount.add(new Amount(1));
        Assertions.assertThat(amount).isEqualTo(new Amount(2));
    }

    @Test
    public void substract0to0() {
        Amount amount = new Amount(0);
        amount.substract(new Amount(0));
        Assertions.assertThat(amount).isEqualTo(new Amount(0));
    }

    @Test
    public void substract1to1() {
        Amount amount = new Amount(1);
        amount.substract(new Amount(1));
        Assertions.assertThat(amount).isEqualTo(new Amount(0));
    }

    @Test
    public void substract1to2() {
        Amount amount = new Amount(2);
        amount.substract(new Amount(1));
        Assertions.assertThat(amount).isEqualTo(new Amount(1));
    }


}