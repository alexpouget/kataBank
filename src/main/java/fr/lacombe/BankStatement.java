package fr.lacombe;

import java.util.Objects;

public class BankStatement {

    private final StringBuilder statement;

    public BankStatement() {
        statement = new StringBuilder("date || credit || debit || balance");
    }

    //use String not StringBuilder
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
        statement.append("\n"+transactionLine);
    }

    @Override
    public String toString() {
        return statement.toString();
    }
}
