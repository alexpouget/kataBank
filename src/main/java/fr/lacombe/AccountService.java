package fr.lacombe;

import java.time.LocalDate;

public class AccountService {

    private final Account account;

    public AccountService(Account account) {

        this.account = account;
    }

    public void deposit(Amount amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, date);
        account.addTransaction(transaction);
    }

    public void withdrawal(Amount amount, LocalDate date) {
        account.addTransaction(new Debit(amount,date));

    }

    public BankStatement printStatement() {
        return new BankStatement("date || credit || debit || balance");
    }
}
