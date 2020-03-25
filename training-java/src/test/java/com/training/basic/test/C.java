package com.training.basic.test;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class C {
    C(){
        System.out.println("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }

    C c2 = new C();
}

class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        // CCBB
        new Test();
    }
}