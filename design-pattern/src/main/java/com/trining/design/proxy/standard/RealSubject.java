package com.trining.design.proxy.standard;


public class RealSubject implements ISubject {

    public void request() {
        System.out.println("real service is called.");
    }

}
