package com.trining.design.adapter.train.passport.adapterv2;


import com.trining.design.adapter.train.passport.ResultMsg;
import com.trining.design.adapter.train.passport.adapterv2.adapters.LoginForQQAdapter;

public class Test {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();
        ResultMsg login = adapter.processLogin("1",LoginForQQAdapter.class);
        System.out.println(login);

    }
}
