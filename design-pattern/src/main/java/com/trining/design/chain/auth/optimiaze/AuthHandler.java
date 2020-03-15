package com.trining.design.chain.auth.optimiaze;


import com.trining.design.chain.auth.Member;

public class AuthHandler extends Handler {
    public void doHandler(Member member) {
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");
    }
}
