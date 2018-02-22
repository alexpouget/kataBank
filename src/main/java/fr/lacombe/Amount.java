package fr.lacombe;

import java.util.Objects;

public class Amount {

    private int amount;

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

    public void add(Amount amount) {
        this.amount += amount.amount;
    }

    public void substract(Amount amount) {
        this.amount -= amount.amount;
    }

    @Override
    public String toString() {
        return String.valueOf(amount+".00");
    }
}
