package com.lucifiere.pattern.state;

public class Profiting extends State {

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
        System.out.println("继续结算");
        this.stateMachineContext.setCurrentState(this);
        System.out.println("结算成功");
    }

    @Override
    public void profit() {
        System.out.println("开始分账");
        this.stateMachineContext.setCurrentState(this);
        System.out.println("分账成功");
    }

}
