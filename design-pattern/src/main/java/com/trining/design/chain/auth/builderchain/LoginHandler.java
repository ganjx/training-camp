package com.trining.design.chain.auth.builderchain;


import com.trining.design.chain.auth.Member;

public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        if(null != next) {
            next.doHandler(member);
        }
    }
}
