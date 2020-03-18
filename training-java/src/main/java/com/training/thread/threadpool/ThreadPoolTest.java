package com.training.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ThreadPoolTest {

    static final int COUNT_BITS = Integer.SIZE - 3; //29
    static final int CAPACITY   = (1 << COUNT_BITS) - 1; //1 1111 1111 1111 1111 1111 1111 1111
    // runState is stored in the high-order bits
    static final int RUNNING    = -1 << COUNT_BITS; //1110 0000 0000 0000 0000 0000 0000 0000
    static final int SHUTDOWN   =  0 << COUNT_BITS; //0
    static final int STOP       =  1 << COUNT_BITS; //10 0000 0000 0000 0000 0000 0000 0000
    static final int TIDYING    =  2 << COUNT_BITS; //100 0000 0000 0000 0000 0000 0000 0000
    static final int TERMINATED =  3 << COUNT_BITS; //110 0000 0000 0000 0000 0000 0000 0000


    public static void main(String[] args) {
        // 固定线程池
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
//        // 缓存线程池
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        // 单线程池
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        // 定时任务线程池
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
//        // jdk1.8 创建一个具有抢占式操作的线程池
//        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();



        System.out.println(ctlOf(RUNNING,0) + " " +Integer.toBinaryString(ctlOf(RUNNING,0)));

    }

    // 计算当前线程池的状态
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    //计算当前线程的个数
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    //根据状态值和线程数合成ctl
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }
}
