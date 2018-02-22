package fr.lacombe;

import java.time.LocalDate;

public class Credit extends Transaction {
    public Credit(Amount amount, LocalDate date) {
        super(amount,date);
    }
}
