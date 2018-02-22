package fr.lacombe;

import java.time.LocalDate;

public class Debit extends Transaction {

    public Debit(Amount amount, LocalDate date) {
        super(amount,date);
    }
}
