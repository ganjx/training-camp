package com.trining.design.observer.guava;

import com.google.common.eventbus.Subscribe;


public class VoEvent {

    @Subscribe
    public void observer(Vo arg){
//        if(arg instanceof Vo){
            System.out.println("执行VoEvent方法，传参为：" + arg);
//        }

    }

}
