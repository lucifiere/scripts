package com.lucifiere.pattern.state;

public class Settled extends State {

    @Override
    public void submitOrder() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void pay() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void guarantee() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void settle() {
        System.out.println("开始结算");
        System.out.println("结算成功");
    }

    @Override
    public void profit() {
        throw new UnsupportedOperationException();
    }

}
