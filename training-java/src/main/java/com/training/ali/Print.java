package com.training.ali;

import java.util.concurrent.atomic.AtomicInteger;

public class Print {

    private static volatile Integer state = new Integer(1);

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(1);
        Object lock = new Object();
        Thread thread1 = new Thread(new Work(lock, "A", count));
        Thread thread2 = new Thread(new Work(lock, "B", count));
        thread1.start();
        thread2.start();
    }

    static class Work implements Runnable {
        Object obj;
        String key;
        AtomicInteger count;

        public Work(Object obj, String key, AtomicInteger count) {
            this.obj = obj;
            this.key = key;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                if ("A".equals(key)) {
                    synchronized (obj) {
                        while (state != 1) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName()+"=>"+count.getAndIncrement());
                        state = 2;
                        obj.notifyAll();
                    }
                } else if ("B".equals(key)) {
                    synchronized (obj) {
                        while (state != 2) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName()+"=>"+count.getAndIncrement());
                        state = 1;
                        obj.notifyAll();
                    }
                }

            }

        }

    }


}