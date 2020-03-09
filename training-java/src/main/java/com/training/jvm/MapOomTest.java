package com.training.jvm;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class MapOomTest {

    static Map<String, String> base = new HashMap<>();

    /**
     *  运行环境 JDK1.8
     *  异常信息：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {

        String randomAlphabetic = RandomStringUtils.randomAlphabetic(1024 * 1024);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            base.put(String.valueOf(i), randomAlphabetic);
        }
    }
}
