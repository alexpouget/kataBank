package fr.lacombe;

import java.util.Objects;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return this.amount == amount.amount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount);
    }
}
