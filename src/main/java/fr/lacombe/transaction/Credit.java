package fr.lacombe.transaction;

import fr.lacombe.amount.Amount;

import java.time.LocalDate;

public class Credit extends Transaction {
    public Credit(Amount amount, LocalDate date) {
        super(amount, date);
    }

    @Override
    public Amount updateSolde(Amount solde) {
        solde.add(this.amount);
        return solde;
    }

    @Override
    public String toString() {
        return date + " || " + amount + " || ||";
    }
}
