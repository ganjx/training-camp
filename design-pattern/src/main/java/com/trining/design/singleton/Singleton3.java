package com.trining.design.singleton;

/**
 * 优点：getInstance方法上增加synchronized，保证了多线程情况下只会创建一个用例。
 * 缺点：synchronized关键字会强制一次只能让一个线程进入方法中，其他线程不得不阻塞等待该线程退出方法。
 */
public class Singleton3 {

    private  static Singleton3 instance = null;

    private Singleton3(){}

    public synchronized static Singleton3 getInstance() {
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
