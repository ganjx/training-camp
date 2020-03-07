package com.trining.design.proxy.dynamicproxy.gpproxy.client;



public class Test {
    public static void main(String[] args) {
        GpMeipo gpMeipo = new GpMeipo();
        IPerson zhangsan = gpMeipo.getInstance(new Zhangsan());
        zhangsan.findLove("xi shi","like Self-driving tour");
    }
}
