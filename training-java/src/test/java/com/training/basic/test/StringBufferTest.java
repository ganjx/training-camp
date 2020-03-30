package com.training.basic.test;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("1234");
        System.out.println(stringBuffer.length()); // 4
        System.out.println(stringBuffer.capacity()); // 20
    }
}
