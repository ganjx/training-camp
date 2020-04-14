package com.training.leetcode.simple;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class KthNodeFromEndOfListLcci {


    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * <p>
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例：
     * <p>
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * 说明：
     * <p>
     * 给定的 k 保证是有效的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        //

        System.out.println(kthToLast(listNode1, 2));

    }

    /**
     * 思路：
     * 1.初始时，两个指针均指向 head。
     * 2.先将 q 向后移动 k 次。此时p，q的距离为 k。
     * 3.同时移动 p，q, 直到 q 指向 nullptr。此时p->val即为答案。
     *
     * @param head
     * @param k
     * @return
     */
    public static int kthToLast(ListNode head, int k) {
        ListNode p = head;
        // 向前走k个位置
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        //p位置走完后，head刚好走到倒数k的位置
        while (p != null) {
            p = p.next;
            head = head.next;
        }

        return head.val;
    }
}
