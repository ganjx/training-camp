package com.trining.design.singleton;

/**
 * 推荐写法，简单高效。充分利用枚举类的特性，只定义了一个实例，且枚举类是天然支持多线程的。
 */
public enum  Singleton7 {

    INSTANCE;

    public void fun(){}
}
