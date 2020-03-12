package com.trining.design.singleton;

/**
 * 双重检查  单例
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class DoubleCheckSingletonTest {

    private static volatile DoubleCheckSingletonTest instance;

    private DoubleCheckSingletonTest(){}

    public static DoubleCheckSingletonTest getInstance() {
        if(instance == null){
            synchronized(DoubleCheckSingletonTest.class){
                if(instance == null){
                    instance = new DoubleCheckSingletonTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(DoubleCheckSingletonTest.getInstance() == DoubleCheckSingletonTest.getInstance());
    }
}
