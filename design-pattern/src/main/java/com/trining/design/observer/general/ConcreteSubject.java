package com.trining.design.observer.general;

import java.util.ArrayList;
import java.util.List;

//具体主题者
public class ConcreteSubject<E> implements ISubject<E> {
    private List<IObserver<E>> observers = new ArrayList<IObserver<E>>();

    public boolean attach(IObserver<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    public void notify(E event) {
        for (IObserver<E> observer : this.observers) {
            observer.update(event);
        }
    }
}