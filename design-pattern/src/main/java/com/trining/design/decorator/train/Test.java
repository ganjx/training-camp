package com.trining.design.decorator.train;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class Test {

    public static void main(String[] args) {

        NavigationBarDecorator normalNav = new NavigationBarDecorator(1,new NavigationBar());
        normalNav.show();

        NavigationBarDecorator vipNav = new NavigationBarDecorator(2,new NavigationBar());
        vipNav.show();

        NavigationBarDecorator adminNav = new NavigationBarDecorator(3,new NavigationBar());
        adminNav.show();


    }
}
