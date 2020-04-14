package com.training.leetcode;

import javafx.scene.SceneAntialiasing;

import java.util.Arrays;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class PalindromePermutationLcci {

    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * <p>
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     * <p>
     * 示例1：
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(canPermutePalindrome("tactcoa"));
        System.out.println(canPermutePalindrome("aa"));
    }

    public static boolean canPermutePalindrome(String s) {
        int[] map = new int[256]; //  根据ASCII,所以申请长度为256的int数组
        for (byte a : s.getBytes()) {
            map[a]++;  // 使用字符-a得到数组上的位置，如果有重复，则递增
        }
        int count = 0; // 统计单数个数
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0) {
                count++;
            }
        }
        return count <= 1;
    }
}
