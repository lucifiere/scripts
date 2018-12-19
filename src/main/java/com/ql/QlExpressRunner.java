package com.ql;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

import java.util.List;

class QlExpressRunner {

    public Object execute(List<Statement> statementSequence, DefaultContext<String, Object> context) {
        ExpressRunner runner = new ExpressRunner();
        String script = parse(statementSequence);
        System.out.println(script);
        Object res = null;
        try {
            res = runner.execute(script, context, null, true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结果：" + res);
        return res;
    }

    public String parse(List<Statement> statements) {
        StringBuilder sb = new StringBuilder();
        statements.forEach(statement -> sb.append(statement.express()));
        return sb.toString();
    }

}
