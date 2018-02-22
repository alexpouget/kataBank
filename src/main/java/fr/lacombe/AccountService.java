package fr.lacombe;

import java.time.LocalDate;

public class AccountService {

    private final Account account;

    public AccountService(Account account) {

        this.account = account;
    }

    public void deposit(Amount amount, LocalDate date) {
        account.addTransaction(new Transaction(amount,date));
    }

    public void withdrawal(Amount amount, LocalDate date) {

    }

    public BankStatement printStatement() {
        return new BankStatement("date || credit || debit || balance");
    }
}
