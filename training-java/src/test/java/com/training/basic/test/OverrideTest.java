package com.training.basic.test;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class OverrideTest {

    public static void main(String[] args) {

        OverrideTest overrideTest = new OverrideTest();


    }

    void f(Integer i){
        System.out.println("integer...");
    }

    void f(String s){
        System.out.println("string...");
    }
}
