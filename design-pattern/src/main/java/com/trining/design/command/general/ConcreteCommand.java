package com.trining.design.command.general;

//具体命令
public class ConcreteCommand implements ICommand {
    // 直接创建接收者，不暴露给客户端
    private Receiver mReceiver = new Receiver();

    public void execute() {
        this.mReceiver.action();
    }
}