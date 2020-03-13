package com.training.basic;

import java.util.HashMap;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        Integer size = null;
        System.out.println(size.hashCode());
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
