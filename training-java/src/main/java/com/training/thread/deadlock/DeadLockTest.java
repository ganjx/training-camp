package com.training.thread.deadlock;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class DeadLockTest {

    public void run(){
        MyThread thread1 = new MyThread();
        new Thread(thread1,"Cat").start();
        new Thread(thread1,"Tom").start();

    }

    class  MyThread implements  Runnable{

        private  Object o1 = new Object();
        private  Object o2 = new Object();
        private  boolean flag = true;

        @Override
        public void run() {
            if(flag){
                flag = false;
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + " have o1.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println(Thread.currentThread().getName() + " have o2.");
                    }

                }
            }
            else{
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + " have o2.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o1){
                        System.out.println(Thread.currentThread().getName() + " have o1.");
                    }
                }
            }

        }
    }


    public static void main(String[] args) {
        new DeadLockTest().run();
    }

}
