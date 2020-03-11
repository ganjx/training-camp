package com.training.basic;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class StaticTest {

    static int i = 1;
    static {
        i = 0;
        // 静态块顺序执行   i=0
        System.out.println(i);
    }
    public static void main(String[] args) {
        System.out.println(i);
    }
}
