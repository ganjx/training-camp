package com.trining.design.singleton;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ContainerSingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecuteRunnable());
        Thread t2 = new Thread(new ExecuteRunnable());
        t1.start();
        t2.start();
    }
}
