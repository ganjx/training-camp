package com.trining.design.decorator.train;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class NavigationBar {

    Logger logger = LoggerFactory.getLogger(NavigationBar.class);

    /**
     *  展示导航条上的菜单项
     */
    public void show(){
        //
        ArrayList<String> strings = Lists.newArrayList("tittle1", "title2");
        logger.info("navigationBar:{}",strings);
    }
}
