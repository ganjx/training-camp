package com.trining.design.adapter.train.passport.adapterv1;


import com.trining.design.adapter.train.passport.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String phone, String code);

}
