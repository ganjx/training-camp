package com.trining.design.proxy.standard;


public class Client {

    public static void main(String[] args) {

        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();

    }

}
