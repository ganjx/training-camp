package com.trining.design.singleton;


/**
 * 优点：volatile关键字能够禁止指令重排，保证在写操作没有完成之前不能调用读操作。
 */
public class Singleton5 {

    private volatile static Singleton5 instance = null;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
