package com.training.didi;

public class ArraySortTest {


    /**
     * 两个无序数组合并成非递减数组：[3,1,5,7],[7,3,2,9,8]合并后[1,2,3,3,5,7,8,9]
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] a = {3, 1, 5, 7};
        int[] b = {7, 3, 2, 9, 8};


        int[] merge = merge(a, b);
        print(merge);
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        //
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        //
        while (i < a.length) {
            c[k++] = a[i++];
        }

        //
        while (j < b.length) {
            c[k++] = b[j++];
        }

        return c;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
