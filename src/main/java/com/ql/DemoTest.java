package com.ql;

import com.google.common.collect.Lists;
import com.ql.util.express.DefaultContext;

import java.util.List;

public class DemoTest {

    public static void main(String[] args) {
        QlExpressRunner runner = new QlExpressRunner();

        Branch lowestPriceBranch = new Branch();
        lowestPriceBranch.cond(
                new CompositeJudge(new Calculate("结算价", Token.LT, "最低票价"), Token.AND, new Cons("不允许突破最低票价")),
                new Assign("结算价", new Cons("最低票价"))
        );

        List<Statement> produce = Lists.newArrayList(
                new Assign("结算价", new Cons("原价")),
                new Assign("结算价", new Cons("减至")),
                lowestPriceBranch,
                new Assign("结算价", new Calculate("结算价", Token.MINOR, "立减")),
                lowestPriceBranch,
                new Return("结算价")
        );

        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("原价", 80);
        context.put("减至", 24);
        context.put("立减", 5);
        context.put("最低票价", 25);
        context.put("不允许突破最低票价", false);
        runner.execute(produce, context);
    }

}
