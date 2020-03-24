package com.trining.design.observer.general;


public class Test {

    public static void main(String[] args) {
        // 被观察者
        ISubject<String> observable = new ConcreteSubject<String>();
        // 观察者
        IObserver<String> observer = new ConcreteObserver<String>();
        // 注册
        observable.attach(observer);
        // 通知
        observable.notify("hello");
    }

}
