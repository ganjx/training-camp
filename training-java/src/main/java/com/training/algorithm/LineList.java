package com.training.algorithm;


import java.util.Arrays;

public class LineList {

	Integer[] obj;

	/**
	 * 
	 */
	public LineList() {
		// TODO Auto-generated constructor stub
	}

	public LineList(int init) {
		// TODO Auto-generated constructor stub
		obj = new Integer[init];
	}

	public LineList(Integer[] from) {
		// TODO Auto-generated constructor stub
		obj = from;
	}

	/**
	 * @param index
	 * @param addInteger
	 */
	public void add(int index, Integer addInteger) {
		if (obj == null) {
			throw new NullPointerException();
		}
		if (index > obj.length) {
			throw new IndexOutOfBoundsException();
		}
		// 有两种情况，一种是在数组末尾插入，可以直接插入； 另外一种是在中间插入，需要后移下标之后的数组
		// 拷贝数据
		// 此处可使用Arrays.copyOf和System.arraycopy等方法替代
		Integer[] copy = new Integer[obj.length + 1];
		for (int i = 0; i < obj.length; i++) {
			copy[i] = obj[i];
		}
		obj = copy;

		// 循环将数字后移
		for (int i = obj.length - 1; i > index; i--) {
			obj[i] = obj[i - 1];
		}

		// 在指定坐标上插入
		obj[index] = addInteger;
	}

	/**
	 * 删除时，
	 * 第一种方式：数组中元素前移，不考虑数组缩容
	 */
	public void remove(int index) {
		if (obj == null) {
			throw new NullPointerException();
		}
		if (index > obj.length) {
			throw new IndexOutOfBoundsException();
		}

		// 前移
		int length = obj.length;
		for (int i = index; i < length; i++) {
			if (i != length - 1)
				obj[i] = obj[i + 1];
		}
		obj[length - 1] = null;
	}

	/**
	 * 删除时，
	 * 第二种方式：
	 * 1、新建length -1大小的数组copy；
	 * 2、将[0,index-1]的对象拷贝入copy数组；
	 * 3、将[index+1,length-1]的对象拷贝如copy数组；
	 *
	 * 这种方式的好处是删除元素的同时，数组长度同等缩减；
	 * 不足之处就是数组内length-1个元素都必须拷贝；
	 */
	public void remove2(int index) {
		if (obj == null) {
			throw new NullPointerException();
		}
		if (index > obj.length) {
			throw new IndexOutOfBoundsException();
		}

		Integer[] copy = new Integer[obj.length -1];
		for (int i = 0; i <index ; i++) {
			copy[i] = obj[i];
		}

		for (int i = index +1 ; i < obj.length; i++) {
			copy[i - 1] = obj[i];
		}

		obj = copy;
	}
	/**
	 * 查询
	 * 
	 * @param index
	 * @return
	 */
	public Integer get(int index) {
		if (obj == null || index < 0) {
			return null;
		}

		return obj[index];
	}


	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LineList lineList = new LineList(new Integer[] {2,10,14,19,51,71});
		System.out.println("    初始：" + Arrays.toString(lineList.obj));

		lineList.add(3, 1);
		System.out.println("新增对象：" + Arrays.toString(lineList.obj));

		lineList.remove2(5);
		System.out.println("删除对象方式二：" + Arrays.toString(lineList.obj));

		lineList.remove(5);
		System.out.println("删除对象方式一：" + Arrays.toString(lineList.obj));
	}
}
