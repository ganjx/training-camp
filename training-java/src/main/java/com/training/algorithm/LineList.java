package com.training.algorithm;


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
	 * @param obj
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
	 * 删除时，数组中元素前移 1、未考虑数据缩容
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
	 * 查询
	 * 
	 * @param obj
	 * @param index
	 * @return
	 */
	public Integer get(int index) {
		if (obj == null || index < 0) {
			return null;
		}

		return obj[index];
	}

}
