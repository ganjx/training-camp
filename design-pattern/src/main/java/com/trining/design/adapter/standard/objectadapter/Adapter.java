package com.trining.design.adapter.standard.objectadapter;


public class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public int request() {
        return adaptee.specificRequest() / 10;
    }
}
