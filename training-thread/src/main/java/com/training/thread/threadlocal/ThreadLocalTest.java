package com.training.thread.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ThreadLocalTest {

    static Logger logger = LoggerFactory.getLogger(ThreadLocalTest.class);

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        protected Integer initialValue(){
            return 0;
        }
    };

    public static void main(String[] args) {

        int count = 5;
        for (int i = 0; i < count; i++) {
            new Thread(()->{
                int localNum = threadLocal.get().intValue() + 5;
                logger.info("{}->{}",Thread.currentThread().getName(),localNum);
            }).start();
        }
    }
}
