package com.training.basic;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class FloatTest {

    /**
     * 此方法如果此对象所表示的值是NaN，返回true，否则返回false。
     * @param args
     */
    public static void main(String[] args) {
        Float f1 = new Float(-1.0/0.0);
        Float f2 = new Float(0.0/0.0);

        System.out.println(f1 + "=" + f1.isNaN()); //-Infinity=false
        System.out.println(f2 + "=" + f2.isNaN()); //NaN=true
    }
}
