package com.trining.design.template.jdbc;


import com.trining.design.template.jdbc.dao.MemberDao;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
    }
}
