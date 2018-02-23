package fr.lacombe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AmountTest {

    @Test
    public void add0to0() {
        Amount amount = Amount.parse(0);
        amount.add(Amount.parse(0));
        Assertions.assertThat(amount).isEqualTo(Amount.parse(0));
    }

    @Test
    public void add0to1() {
        Amount amount = Amount.parse(0);
        amount.add(Amount.parse(1));
        Assertions.assertThat(amount).isEqualTo(Amount.parse(1));
    }

    @Test
    public void add1to1() {
        Amount amount = Amount.parse(1);
        amount.add(Amount.parse(1));
        Assertions.assertThat(amount).isEqualTo(Amount.parse(2));
    }

    @Test
    public void substract0to0() {
        Amount amount = Amount.parse(0);
        amount.substract(Amount.parse(0));
        Assertions.assertThat(amount).isEqualTo(Amount.parse(0));
    }

    @Test
    public void substract1to1() {
        Amount amount = Amount.parse(1);
        amount.substract(Amount.parse(1));
        Assertions.assertThat(amount).isEqualTo(Amount.parse(0));
    }

    @Test
    public void substract1to2() {
        Amount amount = Amount.parse(2);
        amount.substract(Amount.parse(1));
        Assertions.assertThat(amount).isEqualTo(Amount.parse(1));
    }

    @Test
    public void buildAmountWithValue1Dot20() {
        Amount amount = Amount.parse(1.20);
        Assertions.assertThat(amount.toString()).isEqualTo("1.20");
    }


}