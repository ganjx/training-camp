/**
 * Kjtpay.com Inc. Copyright (c) 2012-2020 All Rights Reserved.
 */
package com.training.algorithm;

import java.util.Arrays;


public class SortMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
		// SelectionSort(arr);
		// InsertSort(arr, arr.length);
		// InsertSort2(arr);
		// mergeSort(arr, 0, arr.length - 1);
		quickSort(arr, 0, arr.length - 1);
		System.err.println(Arrays.toString(arr));
	}

	/**
	 * 选择排序 选择排序也是一种简单直观的排序算法，实现原理比较直观易懂：首先在未排序数列中找到最小元素，
	 * 然后将其与数列的首部元素进行交换，然后，在剩余未排序元素中继续找出最小元素，将其与已排序数列的末尾位置元素交换。 以此类推，直至所有元素圴排序完毕
	 * 
	 * @param arr
	 */
	public static void SelectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i; // 遍历的区间最小的值
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					// 找到当前遍历区间最小的值的索引
					min = j;
				}
			}
			if (min != i) {
				// 发生了调换
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}

	/**
	 * 插入排序 操作过程：将待插元素，依次与已排序好的子数列元素从后到前进行比较，如果当前元素值比待插元素值大，
	 * 则将移位到与其相邻的后一个位置，否则直接将待插元素插入当前元素相邻的后一位置，因为说明已经找到插入点的最终位置
	 * 
	 * @param arr
	 * @param length
	 */
	public static void InsertSort(int arr[], int length) {
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

	public static void InsertSort2(int[] arr) {
		if (arr.length >= 2) {
			for (int i = 1; i < arr.length; i++) {
				// 挖出一个要用来插入的值,同时位置上留下一个可以存新的值的坑
				int x = arr[i];
				int j = i - 1;
				// 在前面有一个或连续多个值比x大的时候,一直循环往前面找,将x插入到这串值前面
				while (j >= 0 && arr[j] > x) {
					// 当arr[j]比x大的时候,将j向后移一位,正好填到坑中
					arr[j + 1] = arr[j];
					j--;
				}
				// 将x插入到最前面
				arr[j + 1] = x;
			}
		}
	}

	/**
	 * <b>希尔排序</b> 希尔排序(Shell's Sort)在插入排序算法的基础上进行了改进，算法的时间复杂度与前面几种算法相比有较大的改进。
	 * 其算法的基本思想是：先将待排记录序列分割成为若干子序列分别进行插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行一次直接插入排序。
	 * 
	 * @param arr
	 * @param length
	 */
	void ShellSort(int arr[], int length) {
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

	/**
	 * 归并排序
	 * 
	 * @param a
	 * @param s
	 * @param e
	 */
	public static void mergeSort(int[] arr, int start, int end) {
		int m = (start + end) / 2;
		if (start < end) {
			mergeSort(arr, start, m);
			mergeSort(arr, m + 1, end);
			// 归并
			merge(arr, start, m, end);
		}
	}

	private static void merge(int[] a, int s, int m, int e) {
		// 初始化一个从起始s到终止e的一个数组
		int[] temp = new int[(e - s) + 1];
		// 左起始指针
		int l = s;
		// 右起始指针
		int r = m + 1;
		int i = 0;
		// 将s-e这段数据在逻辑上一分为二,l-m为一个左边的数组,r-e为一个右边的数组,两边都是有序的
		// 从两边的第一个指针开始遍历,将其中小的那个值放在temp数组中
		while (l <= m && r <= e) {
			if (a[l] < a[r]) {
				temp[i++] = a[l++];
			} else {
				temp[i++] = a[r++];
			}
		}

		// 将两个数组剩余的数放到temp中
		while (l <= m) {
			temp[i++] = a[l++];
		}
		while (r <= e) {
			temp[i++] = a[r++];
		}

		// 将temp数组覆盖原数组
		for (int n = 0; n < temp.length; n++) {
			a[s + n] = temp[n];
		}

	}

	/**
	 * 快速排序
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 */
	public static void quickSort(int[] arr, int begin, int end) {
		// 先定义两个参数接收排序起始值和结束值
		int a = begin;
		int b = end;
		// 先判断a是否大于b

		if (a >= b) {
			// 没必要排序
			return;
		}
		// 基准数,默认设置为第一个值
		int x = arr[a];

		// 循环
		while (a < b) {
			// 从后往前找,找到一个比基准数x小的值,赋给arr[a]
			// 如果a和b的逻辑正确--a<b ,并且最后一个值arr[b]>x,就一直往下找,直到找到后面的值大于x
			while (a < b && arr[b] >= x) {
				b--;
			}
			// 跳出循环,两种情况,一是a和b的逻辑不对了,a>=b,这时候排序结束.二是在后面找到了比x小的值
			if (a < b) {
				// 将这时候找到的arr[b]放到最前面arr[a]
				arr[a] = arr[b];
				// 排序的起始位置后移一位
				a++;
			}

			// 从前往后找,找到一个比基准数x大的值,放在最后面arr[b]
			while (a < b && arr[a] <= x) {
				a++;
			}
			if (a < b) {
				arr[b] = arr[a];
				// 排序的终止位置前移一位
				b--;
			}
		}
		// 跳出循环 a < b的逻辑不成立了,a==b重合了,此时将x赋值回去arr[a]
		arr[a] = x;
		// 调用递归函数,再细分再排序
		quickSort(arr, begin, a - 1);
		quickSort(arr, a + 1, end);
	}

}
