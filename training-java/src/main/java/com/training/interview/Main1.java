package com.training.interview;

import com.training.thread.printorder.SemaphoreTest;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main1 {

    /**
     *
     */
    private static volatile Integer state = new Integer(1);

    /**
     * 编写代码，使用3个线程，1个线程打印X，一个线程打印Y，一个线程打印Z，同时执行连续打印10次"XYZ"
     *
     * @param args
     */
    public static void main(String[] args) {
        // threadpoolexecutor
        int nThreads = 3;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        // lock
        Object lock = new Object();
        int count = 10;
        //
        threadPoolExecutor.execute(new MyWroker("X",count,lock));
        threadPoolExecutor.execute(new MyWroker("Y",count,lock));
        threadPoolExecutor.execute(new MyWroker("Z",count,lock));

        threadPoolExecutor.shutdown();
    }

    /**
     *
     */
    public  static class MyWroker implements  Runnable{

        private String key;
        private Integer count;
        private Object lock;

        public MyWroker(String key, Integer count, Object lock) {
            this.key = key;
            this.count = count;
            this.lock  = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                if("X".equals(key)){
                    //
                    synchronized (lock){
                        while(state != 1){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //
                        System.out.println(i + "->" +key);
                        state = 2;
                        lock.notifyAll();
                    }

                }
                else if("Y".equals(key)){
                    //
                    synchronized (lock){
                        while(state != 2){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //
                        System.out.println(i + "->" +key);
                        state = 3;
                        lock.notifyAll();
                    }
                }
                else if("Z".equals(key)){
                    //
                    synchronized (lock){
                        while(state != 3){
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //
                        System.out.println(i + "->" +key);
                        state = 1;
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}


