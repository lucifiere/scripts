package com.ql;

public class Return extends BaseStatement {

    private String var1;

    public Return(String var1) {
        this.var1 = var1;
        setStatementType(StatementType.RETURN);
    }

    @Override
    public String express() {
        return Token.RETURN.getLiteral() + var1 + ";";
    }

}
