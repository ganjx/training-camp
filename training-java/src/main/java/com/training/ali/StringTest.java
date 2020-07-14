package com.training.ali;

public class StringTest {

    public static void main(String[] args) {
        String string = "abc";
        int length = string.length();
        print(string, 0, length);
    }

    public static void print(String string, int currentIndex, int length) {

        if (currentIndex > length) {
            return;
        }

        for (int i = currentIndex; i < length; i++) {
            System.out.println(string.substring(i, length - i));
        }

        print(string, currentIndex++, length);
    }
}