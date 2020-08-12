package com.lucifiere.pattern.state;

public class Init extends State {

    @Override
    public void submitOrder() {
        System.out.println("下单成功");
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void profit() {
        throw new UnsupportedOperationException();
    }

}
