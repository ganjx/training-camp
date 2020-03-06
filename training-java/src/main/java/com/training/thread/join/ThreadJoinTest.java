package com.training.thread.join;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread subThread1 = new Thread(()->{
            System.out.println("subThread 1");
        });
        Thread subThread2 = new Thread(()->{
            System.out.println("subThread 2");
        });
        Thread subThread3 = new Thread(()->{
            System.out.println("subThread 3");
        });
        subThread1.start();
        subThread1.join(); // main Thread wait for subThread1,when subThread1 finish notify all.
        subThread2.start();
        subThread2.join(); // main Thread wait for subThread2,when subThread2 finish notify all.
        subThread3.start();


    }
}
