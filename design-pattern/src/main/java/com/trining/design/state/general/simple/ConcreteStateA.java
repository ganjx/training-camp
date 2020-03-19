package com.trining.design.state.general.simple;

//具体状态类
public class ConcreteStateA implements IState {
    public void handle() {
        //必要时刻需要进行状态切换
        System.out.println("StateA do action");
    }
}