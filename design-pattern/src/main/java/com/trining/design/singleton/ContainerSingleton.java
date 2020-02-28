package com.trining.design.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ganjx
 * Kjtpay.com Inc. Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> map = new ConcurrentHashMap<>();

    /**
     * 隔离级别问题： 目前的代码相当于数据库中的“一级封锁协议”。存在覆盖值的问题；
     * 解决方案：1、对map.put(key, value)上增加synchronized； 2、并二次检查map.containsKey(key)；
     *
     * @param key
     * @param value
     */
    public static void putInstance(String key, Object value) {
        if (key != null && !key.isEmpty() && value != null) {
            if (!map.containsKey(key)) {
                synchronized (ContainerSingleton.class) {
                    if (!map.containsKey(key)) {
                        map.put(key, value);
                    }
                }
            }
        }
    }

    public static Object getInstance(String key) {
        return map.get(key);
    }
}
