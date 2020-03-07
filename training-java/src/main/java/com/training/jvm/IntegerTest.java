package com.training.jvm;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = 100;
        System.out.println(a == b); // true

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;
        System.out.println(c == d); // false
    }
}
