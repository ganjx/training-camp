package com.training.leetcode.thread.printlnorder.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 解题思路：利用CountDownLatch，CountDownLatch是java.util.concurrent包下面的一个工具类，可以用来协调多个线程之间的同步，
 * 或者说起到线程之间的通信（而不是用作互斥的作用）。 它可以允许一个或者多个线程等待其他线程完成操作。
 *
 */
public class Foo {
    private CountDownLatch countDownLatchA;
    private CountDownLatch countDownLatchB;

    public Foo() {
        countDownLatchA = new CountDownLatch(1);
        countDownLatchB = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchA.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatchA.await();
        printSecond.run();
        countDownLatchB.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatchB.await();
        printThird.run();
    }
}