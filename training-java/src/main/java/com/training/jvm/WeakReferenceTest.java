package com.training.jvm;

import java.lang.ref.WeakReference;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class WeakReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B(a);
        a = null;
        System.out.println(b.getA());  // not null
        System.gc();
        System.out.println(b.getA());  // null
    }
}

class A {}

class B {

    WeakReference<A> weakReference;

    public B(A a) {
        weakReference = new WeakReference<>(a);
    }

    public A getA() {
        return weakReference.get();
    }
}