package com.training.leetcode.lcci.medium;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ZeroMatrixLcci {

    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * 输出：
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     * 示例 2：
     * <p>
     * 输入：
     * [
     * [0,1,2,0],
     * [3,4,5,2],
     * [1,3,1,5]
     * ]
     * 输出：
     * [
     * [0,0,0,0],
     * [0,4,5,0],
     * [0,3,1,0]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[0][3] = 0;

        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 2;

        matrix[2][0] = 1;
        matrix[2][1] = 3;
        matrix[2][2] = 1;
        matrix[2][3] = 5;


        setZeroes(matrix);

        print(matrix);
    }

    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            int[] matrixItem = matrix[i];
            for (int j = 0; j < matrixItem.length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        // 1. 统计X,y坐标
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //确认哪些行哪些列需要置0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // 2.循环遍历数据，对应x,y赋值0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
