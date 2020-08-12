package com.lucifiere.pattern.state;

public class StateMachineContext {

    public static final Init initState = new Init();

    public static final Paying payingState = new Paying();

    public static final Paid paidState = new Paid();

    public static final Settled settledState = new Settled();

    public static final Profiting profitingState = new Profiting();

    private State currentState;

    public StateMachineContext(State currentState) {
        this.currentState = currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.stateMachineContext = this;
    }

    public void submitOrder() {
        currentState.submitOrder();
    }

    public void pay() {
        currentState.pay();
    }

    public void guarantee() {
        currentState.guarantee();
    }

    public void settle() {
        currentState.settle();
    }

    public void profit() {
        currentState.profit();
    }

}
