package com.training.thread.printorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ReentrantLockTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static volatile int state = 1;

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 3;
        ExecutorService poolService = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        Integer count = 10;
        poolService.execute(new Worker("A", count, 1, lock, conditionA, conditionB));
        poolService.execute(new Worker("B", count, 2, lock, conditionB, conditionC));
        poolService.execute(new Worker("C", count, 3, lock, conditionC, conditionA));
        /**
         * shutdown只是将线程池的状态设置为SHUTWDOWN状态，正在执行的任务会继续执行下去，没有被执行的则中断。
         * shutdownNow则是将线程池的状态设置为STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        poolService.shutdown();
    }

    public static class Worker implements Runnable {
        private String key;
        private Integer count;
        private Lock lock;
        private Condition current;
        private Condition next;
        private int targetState;

        public Worker(String key, Integer count, int targetState, Lock lock, Condition cur, Condition next) {
            this.key = key;
            this.count = count;
            this.lock = lock;
            this.current = cur;
            this.next = next;
            this.targetState = targetState;
        }

        @Override
        public void run() {
            this.lock.lock();
            try {
                for (int i = 0; i < count; i++) {
                    while (state != targetState) {
                        current.await();
                    }
                    System.out.println(i + "," + key);
                    state++;
                    if (state > 3) {
                        state = 1;
                    }
                    next.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.lock.unlock();
            }
        }
    }
}
