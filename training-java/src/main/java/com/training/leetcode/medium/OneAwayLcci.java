package com.training.leetcode.medium;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class OneAwayLcci {

    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     *  
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     *
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/one-away-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pal"));
        System.out.println(oneEditAway("industry" ,"interest"));
    }

    /**
     * 思路：
     * 1、首先验证两个字符串字符个数是否相差小于等于1，否则返回false
     * 2、判定first是否为长字符串，否则将first替换为长字符串，保障first为长字符串
     * 3、利用循环，判定字符串字符是否一样，若判定不一样，则跳过不同的字符串，截取长字符串frist的i+1位后的字符串，
     *       若frist字符串长度与second字符串的长度相同，则截取second的第i+1位后的字符串，否则截取second的第i为字符串
     * 5、判定截取后的frist的与second字符串是否相同，相同则返回true，否则返回false
     * @param first
     * @param second
     * @return
     */
    public static boolean oneEditAway(String first, String second) {
        //
        int len1 = first.length();
        int len2 = second.length();

        // 1.先判断长度，如果长度差大于1，则一定false
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        // 2.如果sencond字符的长度大于first，则调换位置
        if (len2 > len1) {
            String tem = first;
            first = second;
            second = tem;
        }
        int l1 = first.length();
        int l2 = second.length();

        // 3. 循环遍历字符数组
        for (int i = 0; i < l2; i++) {
            // 当first的字符和second的字符不同时
            if (first.charAt(i) != second.charAt(i)) {
                // first :  截取 i+1后的字符串
                // second : 如果l1 == l2 ，截取i+1 。否则截取i后的
                return first.substring(i + 1).equals(second.substring(l1 == l2 ? i + 1 : i));
            }
        }
        return true;
    }


}
