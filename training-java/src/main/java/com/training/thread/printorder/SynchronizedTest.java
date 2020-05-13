package com.training.thread.printorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class SynchronizedTest {
    private static volatile Integer state = new Integer(1);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService poolService = Executors.newFixedThreadPool(3);
        Integer count = 10;
        Object lock = new Object();
        poolService.execute(new Worker("A", count, lock));
        poolService.execute(new Worker("B", count, lock));
        poolService.execute(new Worker("C", count, lock));

        /**
         * shutdown只是将线程池的状态设置为SHUTWDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断。
         * shutdownNow则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        poolService.shutdown();
    }

    public static class Worker implements Runnable {
        private String key;
        private Integer count;
        private Object lock;
        public Worker(String key, Integer count, Object lock) {
            this.key = key;
            this.count = count;
            this.lock  = lock;
        }
        public void run() {
            for(int i = 0; i < count; i++) {
                if(key == "A") {
                    synchronized (lock) {
                        while (state != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i+","+key);
                        state = 2;
                        lock.notifyAll();
                    }
                } else if(key == "B") {
                    synchronized (lock) {
                        while (state != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i+","+key);
                        state = 3;
                        lock.notifyAll();
                    }
                } else if (key == "C") {
                    synchronized (lock) {
                        while (state != 3) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i+","+key);
                        state = 1;
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
