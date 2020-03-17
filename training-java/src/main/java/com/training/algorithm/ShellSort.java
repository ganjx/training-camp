package com.training.algorithm;

import java.util.Arrays;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        shellSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * <b>希尔排序</b> 希尔排序(Shell's Sort)在插入排序算法的基础上进行了改进，算法的时间复杂度与前面几种算法相比有较大的改进。
     * 其算法的基本思想是：先将待排记录序列分割成为若干子序列分别进行插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行一次直接插入排序。
     *
     * @param arr
     * @param length
     */
    public static  void shellSort(int arr[], int length) {
        int increasement = length;
        int i, j, k;
        do {
            // 确定分组的增量
            increasement = increasement / 3 + 1;
            for (i = 0; i < increasement; i++) {
                for (j = i + increasement; j < length; j += increasement) {
                    if (arr[j] < arr[j - increasement]) {
                        int temp = arr[j];
                        for (k = j - increasement; k >= 0 && temp < arr[k]; k -= increasement) {
                            arr[k + increasement] = arr[k];
                        }
                        arr[k + increasement] = temp;
                    }
                }
            }
        } while (increasement > 1);
    }
}
