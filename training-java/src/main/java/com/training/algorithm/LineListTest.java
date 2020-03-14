/**
 * Kjtpay.com Inc. Copyright (c) 2012-2019 All Rights Reserved.
 */
package com.training.algorithm;

import java.util.Arrays;


public class LineListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineList lineList = new LineList(new Integer[] {2,10,14,19,51,71});
//		lineList.add(3, 1);
		
		lineList.remove(5);
		System.out.println(Arrays.toString(lineList.obj));
		
	}

}
