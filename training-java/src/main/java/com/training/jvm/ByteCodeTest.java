package com.training.jvm;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ByteCodeTest {

    public static void main(String[] args) {
        System.out.println(f1()); // hello
        System.out.println(f2().string); // 123
    }
    /**
     * @return
     */
    public static String f1(){
        String str = "hello";
        try{
            return str;
        }
        finally {
            str = "123";
        }
    }

    public static SubByteCode f2(){
        SubByteCode subByteCode = new SubByteCode();
        subByteCode.string = "hello";
        try{
            return subByteCode;
        }
        finally {
            subByteCode.string = "123";
        }
    }
}

class SubByteCode{
    String string;
}
