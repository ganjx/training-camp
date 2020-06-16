package com.training.thread.printorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore a = new Semaphore(1);
        Semaphore b  = new Semaphore(0);
        Semaphore c = new Semaphore(0);

        ExecutorService poolService = Executors.newFixedThreadPool(3);
        Integer count = 10;
        poolService.execute(new Worker(a, b, "A", count));
        poolService.execute(new Worker(b, c, "B", count));
        poolService.execute(new Worker(c, a, "C", count));

        /**
         * shutdown只是将线程池的状态设置为SHUTWDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断。
         * shutdownNow则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        poolService.shutdown();
    }

    public static class Worker implements Runnable {
        private String key;
        private Semaphore current;
        private Semaphore next;
        private Integer count;
        public Worker(Semaphore current, Semaphore next, String key, Integer count) {
            this.current = current;
            this.next = next;
            this.key = key;
            this.count = count;
        }
        @Override
        public void run() {
            for(int i = 0; i < count; i++) {
                try {
                    //获取当前的锁
                    current.acquire(); //current - 1
                    System.out.println(i+","+key);
                    //释放next的锁
                    next.release();    //next + 1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
