package com.lucifiere.pattern.state;

public class Paid extends State {

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
        System.out.println("开始履约");
        this.stateMachineContext.setCurrentState(this);
        System.out.println("履约成功");
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
