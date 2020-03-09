package com.trining.design.adapter.train.passport.adapterv2;


import com.trining.design.adapter.train.passport.ResultMsg;
import com.trining.design.adapter.train.passport.adapterv2.adapters.ILoginAdapter;

public interface IPassportForThird {

//    ResultMsg loginForQQ(String openId);
//
//    ResultMsg loginForWechat(String openId);
//
//    ResultMsg loginForToken(String token);
//
//    ResultMsg loginForTelphone(String phone, String code);


    ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz);


}
