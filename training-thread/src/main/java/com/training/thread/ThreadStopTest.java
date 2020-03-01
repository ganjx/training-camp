package com.training.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ThreadStopTest {

    private static int i;

    /**
     *  停止线程的方式一：  使用interrupt方法设置中断标识，并在线程内部探测isInterrupted是否中断
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread subThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("num->" + i);
        });
        subThread.start();
        TimeUnit.SECONDS.sleep(2);
        subThread.interrupt();


    }

}
