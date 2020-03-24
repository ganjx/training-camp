package com.trining.design.visitor.dispatch.staticdispatch;


public class Main {
    public void test(String string){
        System.out.println("string" + string);
    }
    public void test(Integer integer){
        System.out.println("integer" + integer);
    }

    public static void main(String[] args) {
        String string = "1";
        Integer integer = 1;
        Main main = new Main();
        main.test(integer);
        main.test(string);
    }
}
