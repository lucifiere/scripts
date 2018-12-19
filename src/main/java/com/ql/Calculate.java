package com.ql;

public class Calculate extends BaseStatement implements JudgeStatement, AssignableStatement {

    private String var1;
    private String var2;
    private Token operator;

    public Calculate(String var1, Token operator, String var2) {
        this.var1 = var1;
        this.var2 = var2;
        this.operator = operator;
        setStatementType(StatementType.CALCULATE);
    }

    @Override
    public String express() {
        return "(" + var1 + operator.getLiteral() + var2 + ")";
    }

}
