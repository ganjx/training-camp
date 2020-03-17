package com.training.algorithm;


public class SearchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = {1,2,3,4,5};
		int search = search(intArray,intArray.length -1 ,5);
		System.err.println(search);
	}

	// 从a[1]...a[n] 搜索是否有给定值
	public static int search(int[] intArray, int length, int key) {
		int i;
		// 0 赋值为给定值
		intArray[0] = key;
		i =  length;
		while(intArray[i] != key) {
			i--;
		}
		return i;
	}

}
