package com.trining.design.adapter.train.passport.adapterv2;


import com.trining.design.adapter.train.passport.ResultMsg;
import com.trining.design.adapter.train.passport.adapterv2.adapters.*;

public class PassportForThirdAdapter implements IPassportForThird {

//    public ResultMsg loginForQQ(String openId) {
//        return processLogin(openId, LoginForQQAdapter.class);
//    }
//
//    public ResultMsg loginForWechat(String openId) {
//
//        return processLogin(openId, LoginForWechatAdapter.class);
//
//    }
//
//    public ResultMsg loginForToken(String token) {
//
//        return processLogin(token, LoginForTokenAdapter.class);
//    }
//
//    public ResultMsg loginForTelphone(String phone, String code) {
//        return processLogin(phone, LoginForTelAdapter.class);
//    }


    public ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)){
                return adapter.login(id,adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
