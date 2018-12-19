package com.ql;

public enum Token {

    /**
     * 且
     */
    AND("&&"),
    /**
     * 或
     */
    OR("||"),
    /**
     * 真
     */
    TRUE("true"),
    /**
     * 假
     */
    FALSE("false"),
    /**
     * 赋值
     */
    ASSIGN("="),

    EQUAL("=="),

    GT(">"),

    LT("<"),

    NOT("<>"),

    PLUS("+"),

    MINOR("-"),

    MULTI("*"),

    DIV("/"),

    RETURN("return ");

    private String literal;

    Token(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

}
