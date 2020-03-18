package com.training.jvm.test;

import org.junit.Test;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ClassLoaderTest {


    /**
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$ExtClassLoader@6f94fa3e
     */
    @Test
    public void testClassLoader() {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }

}
