package com.training.leetcode.concurrency.medium;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class PrintFoobarAlternately3 {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        PrintFoobarAlternately3 printFoobarAlternately3 = new PrintFoobarAlternately3(10);
        Thread thread1 = new Thread(()->{
            try {
                printFoobarAlternately3.bar(()->{
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                printFoobarAlternately3.foo(()->{
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }



    // 循环次数
    private int n;
    // 计数器
    private CountDownLatch a;
    // 使用CyclicBarrier保证任务按组执行
    private CyclicBarrier barrier;

    public PrintFoobarAlternately3(int n) {
        this.n = n;
        a = new CountDownLatch(1);
        // 保证每组内有两个任务
        barrier = new CyclicBarrier(2);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                printFoo.run();
                a.countDown();// printFoo方法完成调用countDown
                barrier.await();// 等待printBar方法执行完成
            }
        } catch (Exception e) {
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        try {
            for (int i = 0; i < n; i++) {
                a.await();// 等待printFoo方法先执行
                printBar.run();
                a = new CountDownLatch(1); // 保证下一次依旧等待printFoo方法先执行
                barrier.await();// 等待printFoo方法执行完成
            }
        } catch (Exception e) {
        }
    }

}
