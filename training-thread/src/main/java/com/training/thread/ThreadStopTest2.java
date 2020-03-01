package com.training.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ThreadStopTest2 {

    /**
     * 停止线程的方式二： 设置线程可见(volatile)标识isStop，在外部改变其值
     */
    private static volatile boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread subThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (!isStop) {
                // nothing
            }
            System.out.println("耗时(ms)->" + (System.currentTimeMillis() - start));
        });
        subThread.start();
        TimeUnit.SECONDS.sleep(2);
        isStop = true;
    }

}
