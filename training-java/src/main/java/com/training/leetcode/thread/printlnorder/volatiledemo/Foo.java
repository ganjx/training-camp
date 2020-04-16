package com.training.leetcode.thread.printlnorder.volatiledemo;

/**
 * 解题思路：利用volatile变量
 */
public class Foo {

    volatile int count = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        count++;
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count != 2) ;
        printSecond.run();
        count++;
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count != 3) ;
        printThird.run();
        count = 1;
        // printThird.run() outputs "third". Do not change or remove this line.
    }

}
