package com.trining.design.adapter.train.passport.adapterv2.adapters;


import com.trining.design.adapter.train.passport.ResultMsg;

public class LoginForTelAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        return super.loginForRegist(id,null);
    }

}
