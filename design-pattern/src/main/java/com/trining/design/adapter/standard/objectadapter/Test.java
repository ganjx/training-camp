package com.trining.design.adapter.standard.objectadapter;


public class Test {
    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee());
        int result = adapter.request();
        System.out.println(result);
    }
}
