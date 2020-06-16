package com.trining.design.singleton;

/**
 *
 * <b>缺点：实例在类初始化的时候就创建了，如果在整个项目中都没有使用到该类，就会创建内存空间的浪费。</b>
 *
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class Singleton {

    public static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
}
