package com.training.druid;

import com.alibaba.druid.filter.config.ConfigTools;

public class DruidMain {

    public static void main(String[] args) throws Exception {
        String publicKey = "==";
        String password = "";
        String pwd = ConfigTools.decrypt(publicKey, password);

        System.out.println(pwd);
    }
}
