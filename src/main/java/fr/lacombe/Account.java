package fr.lacombe;

import fr.lacombe.amount.Amount;
import fr.lacombe.reporting.BankStatement;
import fr.lacombe.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final List<Transaction> transactionList;

    public Account() {
        transactionList = new ArrayList<>();
    }

    public void addTransaction(final Transaction transaction) {
        transactionList.add(transaction);
    }

    public BankStatement printTransactions() {
        BankStatement bankStatement = new BankStatement();
        Amount recalculateSolde = Amount.parse(0);
        for (Transaction transaction : transactionList) {
            recalculateSolde = transaction.updateSolde(recalculateSolde);
            bankStatement.append(transaction.toString() + " " + recalculateSolde);
        }
        return bankStatement;
    }
}
