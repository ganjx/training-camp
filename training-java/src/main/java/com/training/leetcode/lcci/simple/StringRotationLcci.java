package com.training.leetcode.lcci.simple;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class StringRotationLcci {

    /**
     * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
     * <p>
     * 示例1:
     * <p>
     * 输入：s1 = "waterbottle", s2 = "erbottlewat"
     * 输出：True
     * 示例2:
     * <p>
     * 输入：s1 = "aa", "aba"
     * 输出：False
     * 提示：
     * <p>
     * 字符串长度在[0, 100000]范围内。
     * 说明:
     * <p>
     * 你能只调用一次检查子串的方法吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(isFlipedString("ab", "aba"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n) return false;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            /**
             *  异或： 相同为0，不同为1
             *  等价于 s1 => a^b^c   和 s2=> b^c^a   再判断 s1^s2  若相等则为0
             */
            ans = ans ^ s1.charAt(i) ^ s2.charAt(i);
        }
        return ans == 0;
    }
//    public static boolean isFlipedString(String s1, String s2) {
//        if (s1.length() != s2.length()) return false;
//        int[] map = new int[256]; //  总共26个字母，所以申请长度为26的int数组
//        for (byte a : s1.getBytes()) {
//            map[a]++;  // 使用字符-a得到数组上的位置，如果有重复，则递增
//        }
//        for (byte a : s2.getBytes()) {
//            map[a]--;  // 在对应的位置上递减，如果小于0，说明在该位置上不存在字符
//            if (map[a] < 0) return false;
//        }
//        return true;
//    }
}
