package com.lucifiere.pattern.state;

public class Main {

    public static void main(String[] args) {
        StateMachineContext context = new StateMachineContext(StateMachineContext.initState);
        context.submitOrder();
        context.pay();
        context.guarantee();
        context.settle();
        context.profit();
    }

}
