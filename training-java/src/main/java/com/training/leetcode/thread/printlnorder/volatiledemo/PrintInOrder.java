package com.training.leetcode.thread.printlnorder.volatiledemo;

import com.training.leetcode.thread.printlnorder.countdownlatch.Foo;

import java.util.concurrent.CompletableFuture;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class PrintInOrder {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        com.training.leetcode.thread.printlnorder.countdownlatch.Foo foo = new Foo();

        CompletableFuture.runAsync(() -> {
            try {
                foo.first(()->{
                    System.out.println(1);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture.runAsync(() -> {

            try {
                foo.third(()->{
                    System.out.println(3);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture.runAsync(() -> {

            try {
                foo.second(()->{
                    System.out.println(2);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while (true) {

        }
    }
}
