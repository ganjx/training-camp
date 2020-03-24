package com.trining.design.mediator.general;

// 具体同事类
public class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
        this.mediator.setColleageB(this);
    }

    // 自有方法：self-Method
    public void selfMethodB() {
        // 处理自己的逻辑
        System.out.println(String.format("%s:self-Method", this.getClass().getSimpleName()));
    }

    // 依赖方法：dep-Method
    public void depMethodB() {
        // 处理自己的逻辑
        System.out.println(String.format("%s:depMethod: delegate to Mediator", this.getClass().getSimpleName()));
        // 无法处理的业务逻辑委托给中介者处理
        this.mediator.transferB();
    }
}