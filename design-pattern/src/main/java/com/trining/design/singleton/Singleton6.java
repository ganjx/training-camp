package com.trining.design.singleton;

/**
 * 优点：充分利用了静态内部类的特点，它的初始化操作跟外部类是分开的。在没有调用 getInstance() 方法之前，
 * 静态内部类不会进行初始化，在第一次调用该方法后就生成了唯一一个实例。
 */
public class Singleton6 {

    private  Singleton6(){}

    private static class SingletonHolder{
        private static Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return SingletonHolder.instance;
    }
}
