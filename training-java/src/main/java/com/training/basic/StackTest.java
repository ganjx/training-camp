package com.training.basic;

import java.util.LinkedList;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class StackTest {
    //以下代码平常没有问题，偶然会出问题
    LinkedList list = new LinkedList();
    public synchronized void push(Object x) {
        synchronized(list) {
            list.addLast( x );
            notify(); // notify 需要改成 notifyall
        }
    }
    public synchronized Object pop()
            throws Exception {
        synchronized(list) {
            if( list.size() <= 0 ) {
                wait();
            }
            return list.removeLast();
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
