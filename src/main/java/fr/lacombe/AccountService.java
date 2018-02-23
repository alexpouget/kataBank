package fr.lacombe;

import fr.lacombe.amount.Amount;
import fr.lacombe.reporting.BankStatement;
import fr.lacombe.transaction.Credit;
import fr.lacombe.transaction.Debit;
import fr.lacombe.transaction.Transaction;

import java.time.LocalDate;

public class AccountService {

    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(Amount amount, LocalDate date) {
        Transaction credit = new Credit(amount, date);
        account.addTransaction(credit);
    }

    public void withdrawal(Amount amount, LocalDate date) {
        Transaction debit = new Debit(amount, date);
        account.addTransaction(debit);

    }

    public BankStatement printStatement() {
        BankStatement statement = account.printTransactions();
        return statement;
    }
}
