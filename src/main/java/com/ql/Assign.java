package com.ql;

public class Assign extends BaseStatement {

    private String var1;

    private AssignableStatement var2;

    public Assign(String var1, AssignableStatement var2) {
        this.var1 = var1;
        this.var2 = var2;
        setStatementType(StatementType.ASSIGN);
    }

    @Override
    public String express() {
        return var1 + Token.ASSIGN.getLiteral() + var2.express() + ";";
    }

}
