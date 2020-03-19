package com.trining.design.state.general.apply;

//环境类
public class Context {
    public static final State STATE_A = new ConcreteStateA();
    public static final State STATE_B = new ConcreteStateB();
    // 默认状态A
    private State currentState = STATE_A;
    {
        STATE_A.setContext(this);
        STATE_B.setContext(this);
    }

    public void setState(State state) {
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public State getState() {
        return this.currentState;
    }

    public void handle() {
        this.currentState.handle();
    }
}