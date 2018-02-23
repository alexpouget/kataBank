package fr.lacombe.amount;

import java.util.Objects;

public class Amount {

    private Integer wholePart;
    private Integer fractionalPart;

    public Amount(Integer wholePart, Integer fractionalPart) {
        this.wholePart = wholePart;
        this.fractionalPart = fractionalPart;
    }

    public static Amount parse(double amount) {
        Integer wholePart = (int) amount;
        Integer fractionalPart = (int) (amount * 100 - wholePart * 100);
        return new Amount(wholePart, fractionalPart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return wholePart == amount.wholePart &&
                fractionalPart == amount.fractionalPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wholePart, fractionalPart);
    }

    public void add(Amount amount) {
        this.fractionalPart += amount.fractionalPart;
        this.wholePart += amount.wholePart + fractionalPart / 100;
        this.fractionalPart = amount.fractionalPart % 100;
    }

    public void subtract(Amount amount) {
        Integer newAmount = wholePart * 100 + fractionalPart;
        Integer amountToSubtract = amount.wholePart * 100 + amount.fractionalPart;
        newAmount -= amountToSubtract;
        wholePart = newAmount / 100;
        fractionalPart = newAmount % 100;
    }

    @Override
    public String toString() {
        String formattedFractionalPart = String.format("%02d", fractionalPart);
        return String.valueOf(wholePart + "." + formattedFractionalPart);
    }
}
