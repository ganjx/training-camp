package com.training.algorithm;

import java.util.Arrays;


public class MaoPaoV1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 6, 2, 5, 4, 9 };
		sort(arr);
		System.err.println(Arrays.toString(arr));
	}

	/**
	 * 每次冒泡过程都是从数列的第一个元素开始，然后依次和剩余的元素进行比较，若小于相邻元素，则交换两者位置，
	 * 同时将较大元素作为下一个比较的基准元素，继续将该元素与其相邻的元素进行比较，直到数列的最后一个元素
	 * 
	 * @param arr
	 */
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) { // 第一层for循环,用来控制冒泡的次数
			for (int j = 0; j < arr.length - 1; j++) { // 第二层for循环,用来控制冒泡一层层到最后
				// 如果前一个数比后一个数大,两者调换 ,意味着泡泡向上走了一层
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

}
