package com.training.jvm.test;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ByteCodeTest {

    public static void main(String[] args) {
        System.out.println(f1()); // hello
        System.out.println(f2().string); // 123
        System.out.println(f3()); //hello3
        System.out.println(f4().string); // hello4
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

    public static String f3(){
        String str = new String("hello3");
        try{
            return str;
        }
        finally {
            str = new String("1233");
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

    public static SubByteCode f4(){
        SubByteCode subByteCode = new SubByteCode();
        subByteCode.string = "hello4";
        try{
            return subByteCode;
        }
        finally {
            subByteCode = new SubByteCode();
            subByteCode.string = "return4";
        }
    }
}

class SubByteCode{
    String string;
}
