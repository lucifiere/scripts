package com.lucifiere.pattern.state;

public abstract class State {

    protected StateMachineContext stateMachineContext;

    public abstract void submitOrder();

    public abstract void pay();

    public abstract void guarantee();

    public abstract void settle();

    public abstract void profit();

}
