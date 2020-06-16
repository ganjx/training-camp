package com.trining.design.singleton;


/**
 * 缺点：JVM 在执行对引用赋值时并不是一个原子操作。具体是首先在堆中为 Singleton 分配内存空间，然后对 Singleton 执行初始化操作，
 * 最后再将引用变量指向该实例所对应的内存地址以完成赋值。而 JVM 对这一步进行了优化，使得步骤二和步骤三可以不按顺序执行。
 * 所以就有可能出现一个线程在执行了步骤一之后执行了步骤三，然后另一个线程调用了该方法，此时 instance 引用变量不为空，
 * 然而 Singleton 实例还没有完成初始化，就会造成报错。
 */
public class Singleton4 {

    private static Singleton4 instance = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
