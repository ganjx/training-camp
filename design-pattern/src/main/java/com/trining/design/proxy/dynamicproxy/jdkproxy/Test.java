package com.trining.design.proxy.dynamicproxy.jdkproxy;



public class Test {
    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        zhangsan.findLove();


        IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());
        zhaoliu.findLove();

    }
}
