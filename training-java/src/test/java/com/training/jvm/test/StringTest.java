package com.training.jvm.test;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class StringTest {

    /**
     *  涉及享元模式
     * @param args
     */
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = "hello";
        String string3 = "he" + "llo";
        String string4 = "he" + new String("llo");
        String string5 = new String("hello");
        String string6 = string5.intern();
        String string7 = "h";
        String string8 = "ello";
        String string9 = string7 + string8;

        System.out.println(string1 == string2); //true
        System.out.println(string1 == string3); // true
        System.out.println(string1 == string4); // false
        System.out.println(string1 == string5); // false
        System.out.println(string1 == string6); //true
        System.out.println(string1 == string9); //false
    }
}
