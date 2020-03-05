package com.trining.design.decorator.train;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class NavigationBarDecorator {

    Logger logger = LoggerFactory.getLogger(NavigationBarDecorator.class);

    private int level;
    NavigationBar navigationBar;

    public NavigationBarDecorator(int level, NavigationBar navigationBar) {
        this.level = level;
        this.navigationBar = navigationBar;
    }

    public void show() {
        navigationBar.show();
        List<String> menuItemByLevel = getMenuItemByLevel();
        logger.info("{}",menuItemByLevel);
    }

    public List<String> getMenuItemByLevel() {
        List<String> menuitem = Lists.newArrayList();
        switch (level) {
            case 2:
                menuitem = Lists.newArrayList("newItem1", "newItem2", "newItem3", "newItem4");
                break;
            case 3:
                menuitem = Lists.newArrayList("newItem1", "newItem2", "newItem3", "newItem4", "newItem5", "newItem6");
                break;
        }
        return menuitem;
    }
}
