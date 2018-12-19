package com.ql;

public class Cons extends BaseStatement implements JudgeStatement, AssignableStatement {

    private String cons;

    public Cons(String cons) {
        this.cons = cons;
        setStatementType(StatementType.JUDGE);
    }

    @Override
    public String express() {
        return "(" + cons + ")";
    }

}
