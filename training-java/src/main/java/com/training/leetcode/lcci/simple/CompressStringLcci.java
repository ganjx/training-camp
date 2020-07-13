package com.training.leetcode.lcci.simple;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class CompressStringLcci {

    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     * <p>
     * 示例1:
     * <p>
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * 示例2:
     * <p>
     * 输入："abbccd"
     * 输出："abbccd"
     * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     * 提示：
     * <p>
     * 字符串长度在[0, 50000]范围内。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
    }


    // 方案一
    public static String compressString(String S) {
        int flog = 1;
        StringBuilder str2 = new StringBuilder();

        //1.输入的str长度小于等于2，一定返回原字符串；
        if (S.length() <= 2) {
            return S;
        }

        //2.循环遍历字符
        for (int i = 1; i < S.length(); i++) {
            // 2.1 如果字符相同，则记录字符出现次数
            if (S.charAt(i - 1) == S.charAt(i)) {
                flog++;
            } else {
                // 2.2 如果字符不同，则记录字符和次数
                str2.append(S.charAt(i - 1)).append(flog);
                // 2.3 初始化计数器
                flog = 1;
            }
        }

        // 3.最后一个字符未发生切换，需要单独记入
        str2.append(S.charAt(S.length() - 1)).append(flog);

        if (S.length() <= str2.length()) {
            return S;
        } else {
            return str2.toString();
        }

    }

    // 方案二
    public static String compressString2(String S) {

        // 初始化信息
        int N = S.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();

        //
        while (i < N) {
            int j = i;
            while (j < N && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;
        }

        // 判断长度，如果小于压缩后长度，则返回原字符串
        if (sb.length() < S.length()) {
            return sb.toString();
        } else {
            return S;
        }
    }
}
