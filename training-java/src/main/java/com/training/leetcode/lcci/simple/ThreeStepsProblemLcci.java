package com.training.leetcode.lcci.simple;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ThreeStepsProblemLcci {

    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
     * 结果可能很大，你需要对结果模1000000007。
     *
     * 示例1:
     *
     *  输入：n = 3
     *  输出：4
     *  说明: 有四种走法
     * 示例2:
     *
     *  输入：n = 5
     *  输出：13
     * 提示:
     *
     * n范围在[1, 1000000]之间
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(waysToStep(10));
    }

    final static int mod = 1000000007;

    /**
     * 动态规划：
     * 1层楼梯
     * f(1) = 1
     *
     * 2层楼梯
     * f(2) = f(1) + 1 = 2
     *
     * 3层楼梯
     * f(3) = f(1) + f(2) + 1;
     *
     * 4层楼梯
     * f(4) = f(1) + f(2) + f(3);
     *
     * n层楼梯： f(n) = f(n-3) + f(n-2) + f(n-1);
     *
     * 取余公式： (a + b + c)%p = ((a%p + b%p)%p + c%p)%p
     *
     * 作者：tamako-4
     * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci/solution/dong-tai-gui-hua-by-tamako-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int waysToStep(int n) {
        switch (n){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            default:
                break;
        }
        int[] result = new int[n];
        result[0] = 1; result[1] = 2; result[2] = 4;
        for (int i = 3; i < n; i++){
            result[i] = ((result[i-3]%mod + result[i-2]%mod)%mod + result[i-1]%mod)%mod;
        }
        return result[n-1];
    }

}
