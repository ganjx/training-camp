package com.trining.design.adapter.train.passport.adapterv2.adapters;


import com.trining.design.adapter.train.passport.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(String id, Object adapter);
}
