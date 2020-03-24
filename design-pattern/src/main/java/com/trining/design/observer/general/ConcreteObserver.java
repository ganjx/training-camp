package com.trining.design.observer.general;

//具体观察者
public class ConcreteObserver<E> implements IObserver<E> {
    public void update(E event) {
        System.out.println("receive event: " + event);
    }
}