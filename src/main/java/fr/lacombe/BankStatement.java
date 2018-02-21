package fr.lacombe;

import java.util.Objects;

public class BankStatement {

    private final String statement;

    public BankStatement(String statement) {
        this.statement = statement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankStatement that = (BankStatement) o;
        return Objects.equals(statement, that.statement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(statement);
    }
}
