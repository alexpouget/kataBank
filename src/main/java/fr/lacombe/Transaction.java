package fr.lacombe;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Transaction{

    protected final Amount amount;
    protected final LocalDate date;

    public Transaction(Amount amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, date);
    }

    public abstract Amount updateSolde(Amount solde);

    @Override
    public abstract String toString();
}
