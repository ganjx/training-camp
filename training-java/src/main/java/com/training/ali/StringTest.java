package com.training.ali;

public class StringTest {

    public static void main(String[] args) {
        String string = "abc";
        int length = string.length();
        print(string, 0, length);
    }

    public static void print(String string, int currentIndex, int length) {
        /**
         * 0
         * a b c  0 2
         * a b    0 1
         * a      0 0
         * 1
         * b c    1 2
         * b      1 1
         * 2
         * c      2 2
         */
        for (int i = currentIndex; i < length; i++) {
            // i  0
            // i  1
            // i  2
            System.out.println(string.substring(currentIndex, i + 1));
        }

        if (currentIndex != length) {
            print(string, ++currentIndex, length);
        }
    }
}