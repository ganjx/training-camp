package com.trining.design.singleton;

/**
 * 优点：解决了内存浪费的问题
 * 缺点：只能在单线程中使用，在多线程中使用如果多个线程同时进入if语句中，就可能出现创建多个实例的问题。
 */
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
