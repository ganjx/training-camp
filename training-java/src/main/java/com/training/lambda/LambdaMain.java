package com.training.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda 表达式是一个匿名函数，源于数学λ演算。
 */
public class LambdaMain {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(2, 4, 6, 8);
        integers.forEach((x) -> System.out.println(x));

        //
        printString("test", (x) -> System.out.println(x));
    }

    public static void printString(String s, Print<String> print) {
        print.print(s);
    }

    /**
     *     private static void lambda$main$1(java.lang.String a){};
     *     private static void lambda$main$0(java.lang.Integer a){};
     */

}
