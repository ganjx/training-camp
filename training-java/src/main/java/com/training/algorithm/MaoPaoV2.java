/**
 * Kjtpay.com Inc. Copyright (c) 2012-2020 All Rights Reserved.
 */
package com.training.algorithm;

import java.util.Arrays;


public class MaoPaoV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 2, 5, 4, 9 };
		sortPlus(arr);
		System.err.println(Arrays.toString(arr));
	}

	/**
	 * 终极版冒泡排序 加入一个布尔变量,如果内循环没有交换值,说明已经排序完成,提前终止
	 * 
	 * @param arr
	 */
	public static void sortPlus(int[] arr) {
		if (arr != null && arr.length > 1) {
			for (int i = 0; i < arr.length - 1; i++) {
				// 初始化一个布尔值
				boolean flag = true;
				for (int j = 0; j < arr.length - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						// 调换
						int temp;
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						// 改变flag
						flag = false;
					}
				}
				if (flag) {
					break;
				}
			}
		}
	}

}
