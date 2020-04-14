package com.training.leetcode;

import java.util.Arrays;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class CheckPermutation {

    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * <p>
     * 示例 1：
     * <p>
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * 示例 2：
     * <p>
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     * 说明：
     * 0 <= len(s1) <= 100
     * 0 <= len(s2) <= 100
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
        System.out.println(CheckPermutation("abcabc", "bcabca"));
        System.out.println(CheckPermutation("bad", "abc"));
        System.out.println(CheckPermutation("abc", "abcd"));
    }


    public static boolean CheckPermutation(String s1, String s2) {
        // 思路三：使用一个数组，记录字符的出现位数，若出现不相等的情况就返回false。
        if (s1.length() != s2.length()) return false;
        int[] map = new int[26]; //  总共26个字母，所以申请长度为26的int数组
        for (byte a : s1.getBytes()) {
            map[a - 'a']++;  // 使用字符-a得到数组上的位置，如果有重复，则递增
        }
        for (byte a : s2.getBytes()) {
            map[a - 'a']--;  // 在对应的位置上递减，如果小于0，说明在该位置上不存在字符
            if (map[a - 'a'] < 0) return false;
        }
        return true;

        //思路二：使用异或，如果两字符串相应字符个数相等，异或结果一定为0。
//        int n = s1.length();
//        if (s2.length() != n) return false;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            /**
//             *  异或： 相同为0，不同为1
//             *  等价于 s1 => a^b^c   和 s2=> b^c^a   再判断 s1^s2  若相等则为0
//             */
//            ans = ans ^ s1.charAt(i) ^ s2.charAt(i);
//        }
//        return ans == 0;


        // 思路一：  两个字符串排序后进行比对
//        if(s1 == null && s2 == null){
//            return true;
//        }
//
//        if(s1 == null || s2 == null){
//            return false;
//        }
//
//        if(s1.equals(s2)){
//            return true;
//        }
//
//        byte[] bytes1 = s1.getBytes();
//        sortPlus(bytes1);
//
//        byte[] bytes2 = s2.getBytes();
//        sortPlus(bytes2);
//        return new String(bytes1).equals(new String(bytes2));
    }

    public static void sortPlus(byte[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                // 初始化一个布尔值
                boolean flag = true;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // 调换
                        byte temp;
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }

}
