package com.trining.design.adapter.train.passport.adapterv2.adapters;


import com.trining.design.adapter.train.passport.PassportService;
import com.trining.design.adapter.train.passport.ResultMsg;

public abstract class AbstraceAdapter extends PassportService implements ILoginAdapter {


    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}
