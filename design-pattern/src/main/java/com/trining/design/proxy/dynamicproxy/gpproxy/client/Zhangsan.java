package com.trining.design.proxy.dynamicproxy.gpproxy.client;


public class Zhangsan implements IPerson {

    public void findLove(String name, String hoppy) {
        System.out.println("张三要求：肤白貌美大长腿->" + name + "->" + hoppy);
    }

    public void buyInsure() {
        System.out.println("30万");
    }

}
