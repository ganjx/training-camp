package com.training.leetcode.lcci.simple;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ReplaceSpaces {

    /**
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     * <p>
     * 示例1:
     * <p>
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * 示例2:
     * <p>
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     * 提示：
     * <p>
     * 字符串长度在[0, 500000]范围内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        String string1 = "Mr John Smith    ";
        System.out.println(replaceSpaces(string1, string1.length()));

        String string2 = "               ";
        System.out.println(replaceSpaces(string2, string2.length()));

    }

    // 思路一：char数组替换（时间空间最少）
    public static String replaceSpaces(String S, int length) {
        char[] target = new char[length * 3];
        //使用两个指针，i代表S字符数组内的位置。  j代表新字符数组内的位置
        int i = 0, j = 0;
        char c;
        while (i < length) {
            c = S.charAt(i);
            if (c == ' ') {
                target[j++] = '%';
                target[j++] = '2';
                target[j++] = '0';
            } else {
                target[j++] = c;
            }
            i++;
        }
        return new String(target, 0, j);

    }

    // 思路二：StringBuilder
    public static String replaceSpaces2(String S, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(S.charAt(i));
        }
        return sb.toString();
    }

    //思路三：java API
    public static String replaceSpaces3(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

}
