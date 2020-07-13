package com.training.leetcode.concurrency.simple;

/**
 *
 */
public class PrintInOrder {


    /**
     * 我们提供了一个类：
     * <p>
     * public class Foo {
     *   public void one() { print("one"); }
     *   public void two() { print("two"); }
     *   public void three() { print("three"); }
     * }
     * 三个不同的线程将会共用一个 Foo 实例。
     * <p>
     * 线程 A 将会调用 one() 方法
     * 线程 B 将会调用 two() 方法
     * 线程 C 将会调用 three() 方法
     * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
     * <p>
     *  
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: "onetwothree"
     * 解释:
     * 有三个线程会被异步启动。
     * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
     * 正确的输出是 "onetwothree"。
     * <p>
     * 示例 2:
     * 输入: [1,3,2]
     * 输出: "onetwothree"
     * 解释:
     * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
     * 正确的输出是 "onetwothree"。
     *  
     * 注意:
     * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
     * 你看到的输入格式主要是为了确保测试的全面性。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/print-in-order
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        PrintInOrder printInOrder = new PrintInOrder();


        Thread thread1 = new Thread(()->{

            try {
                printInOrder.first(()->{
                    System.out.println("first");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(()->{
            try {
                printInOrder.third(()->{
                    System.out.println("third");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{

            try {
                printInOrder.second(()->{
                    System.out.println("second");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        thread1.start();
        thread2.start();;
        thread3.start();

    }


    private volatile boolean firstFinished;
    private volatile boolean secondFinished;
    private Object lock = new Object();


    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
