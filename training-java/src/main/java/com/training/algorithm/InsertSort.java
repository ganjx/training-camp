package com.training.algorithm;

import java.util.Arrays;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        insertSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 插入排序 操作过程：将待插元素，依次与已排序好的子数列元素从后到前进行比较，如果当前元素值比待插元素值大，
     * 则将移位到与其相邻的后一个位置，否则直接将待插元素插入当前元素相邻的后一位置，因为说明已经找到插入点的最终位置
     *
     * @param arr
     * @param length
     */
    public static void insertSort(int arr[], int length) {
        for (int i = 1; i < length; i++) {
            int j;
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
