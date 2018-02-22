package fr.lacombe;

import java.time.LocalDate;

public class Debit extends Transaction {

    public Debit(Amount amount, LocalDate date) {
        super(amount,date);
    }

    @Override
    public Amount updateSolde(Amount solde) {
        solde.substract(this.amount);
        return solde;
    }

    @Override
    public String toString() {
        return date+" || || "+amount+" ||";
    }
}
