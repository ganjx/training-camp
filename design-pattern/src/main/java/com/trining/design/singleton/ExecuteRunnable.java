package com.trining.design.singleton;

/**
 * @author ganjx
 * Kjtpay.com Inc. Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ExecuteRunnable implements  Runnable{

    @Override
    public void run() {
        ContainerSingleton.putInstance("object",new Object());
        Object instance = ContainerSingleton.getInstance("object");
        System.out.println(Thread.currentThread().getName() +" "+ instance);
    }
}
