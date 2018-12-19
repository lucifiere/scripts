package com.ql;

public class CompositeJudge extends BaseStatement implements JudgeStatement, AssignableStatement {

    private JudgeStatement var1;
    private JudgeStatement var2;
    private Token operator;

    public CompositeJudge(JudgeStatement var1, Token operator, JudgeStatement var2) {
        this.var1 = var1;
        this.var2 = var2;
        this.operator = operator;
        setStatementType(StatementType.JUDGE);
    }

    @Override
    public String express() {
        return "(" + var1.express() + operator.getLiteral() + var2.express() + ")";
    }

}
