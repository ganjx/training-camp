package com.training.leetcode.simple;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class SolutionisUnique {

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * <p>
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: false
     * <p>
     * 示例 2：
     * 输入: s = "abc"
     * 输出: true
     * <p>
     * 限制： 0 <= len(s) <= 100
     * 如果你不使用额外的数据结构，会很加分。
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(isUnique("leetcode"));
        System.out.println(isUnique("abc"));
    }

    /**
     * 思路：
     * 1、定义一个bool型大小为256的数组array，然后遍历输入的字符串，每遍历一个字符，令int型变量val等于该字符的的ASCII码，
     * 2、如果这个字符之前都没有出现过，那么令array[val]等于true，如果这个字符之前出现过了，也就是array[val]已经等于true了，就返回false。
     * 3、当字符串中所有字符都遍历结束后，如果没有返回false，那么说明字符串中没有重复的字符，返回true。
     *
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        boolean[] charset = new boolean[256];
        for (int i = 0; i < astr.length(); i++) {
            int val = (int) astr.charAt(i);//取出字符，转换为ASCII码
            if (charset[val]) {
                return false;
            }
            charset[val] = true;
        }
        return true;
    }
}
