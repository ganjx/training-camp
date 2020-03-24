package com.trining.design.visitor.dispatch.dymdispatch;


public class Main {
    public static void main(String[] args) {
        Person man = new Man();
        Person woman = new WoMan();

        man.test();
        woman.test();
    }
}
