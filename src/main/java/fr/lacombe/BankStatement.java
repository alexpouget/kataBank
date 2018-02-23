package fr.lacombe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankStatement {

    private final List<String> statement;

    public BankStatement() {
        statement = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankStatement that = (BankStatement) o;
        return Objects.equals(statement.toString(), that.statement.toString());
    }

    @Override
    public int hashCode() {

        return Objects.hash(statement);
    }

    public void append(String transactionLine) {
        statement.add(transactionLine);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("date || credit || debit || balance");
        for (int i = statement.size() -1; i>=0;i--) {
            stringBuilder.append("\n");
            stringBuilder.append(statement.get(i));
        }
        return stringBuilder.toString();
    }
}
