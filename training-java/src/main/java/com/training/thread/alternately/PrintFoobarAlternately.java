package com.training.thread.alternately;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class PrintFoobarAlternately {

    /**
     * 我们提供一个类：
     * <p>
     * class FooBar {
     * public void foo() {
     *     for (int i = 0; i < n; i++) {
     *       print("foo");
     *     }
     * }
     * <p>
     * public void bar() {
     *     for (int i = 0; i < n; i++) {
     *       print("bar");
     *     }
     * }
     * }
     * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
     * <p>
     * 请设计修改程序，以确保 "foobar" 被输出 n 次。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 1
     * 输出: "foobar"
     * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
     * 示例 2:
     * <p>
     * 输入: n = 2
     * 输出: "foobarfoobar"
     * 解释: "foobar" 将被输出两次。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */


    private int n;
    private boolean fooTurn = true;
    private Object lock = new Object();

    public PrintFoobarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!fooTurn) lock.wait();
                fooTurn = false;
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (fooTurn) lock.wait();
                fooTurn = true;
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        PrintFoobarAlternately p = new PrintFoobarAlternately(5);
        new Thread() {
            public void run() {
                try {
                    p.foo(()->{
                        System.out.print("foo");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    p.bar(()->{
                        System.out.print("Bar");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

