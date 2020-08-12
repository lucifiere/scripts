package com.lucifiere.pattern.state;

public class Paying extends State {

    @Override
    public void submitOrder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void pay() {
        System.out.println("开始支付");
        this.stateMachineContext.setCurrentState(this);
        System.out.println("支付成功");
    }

    @Override
    public void guarantee() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void settle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void profit() {
        throw new UnsupportedOperationException();
    }

}
