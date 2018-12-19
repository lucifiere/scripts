package com.ql;

public abstract class BaseStatement implements Statement {

    private StatementType statementType;

    @Override
    public StatementType getStatementType() {
        return statementType;
    }

    protected void setStatementType(StatementType statementType) {
        this.statementType = statementType;
    }

}
