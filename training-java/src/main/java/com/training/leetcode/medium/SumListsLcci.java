package com.training.leetcode.medium;

import com.training.leetcode.model.ListNode;
import com.training.leetcode.util.ListNodeUtils;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class SumListsLcci {

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * <p>
     * 示例：
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * 进阶：假设这些数位是正向存放的，请再做一遍。
     * <p>
     * 示例：
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = ListNodeUtils.build(new int[]{7, 1, 6});
        ListNode listNode2 = ListNodeUtils.build(new int[]{5, 9, 2});

        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        ListNodeUtils.print(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addLists(l1, l2, 0);
    }

    //将两个节点的值逐一相加，如有进位，则转入下一个节点
    public static ListNode addLists(ListNode node1, ListNode node2, int carry) {
        //若两个链表全部为空，且进位为0，则返回
        if (node1 == null && node2 == null && carry == 0)
            return null;

        int value = carry;
        if (node1 != null) {
            value += node1.val;
        }
        if (node2 != null) {
            value += node2.val;
        }
        ListNode result = new ListNode(value % 10);

        ListNode more = addLists(node1 == null ? null : node1.next, node2 == null ? null : node2.next, value / 10 == 1 ? 1 : 0);
        result.next = more;
        return result;

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //返回求和结果和进位
    public static class PartialSum {
        public ListNode sum = null;
        public int carry = 0;
    }

    public static ListNode addLists2(ListNode node1, ListNode node2) {
        PartialSum sum = new PartialSum();
        int len1 = length(node1);
        int len2 = length(node2);

        //对较短的链表高位进行补零
        if (len1 < len2) {
            padList(node1, len2 - len1);
        } else {
            padList(node2, len1 - len2);
        }
        //对两个链表求和
        sum = addListHelper(node1, node2);
        //如果有进位，插入首位，否则直接返回
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            ListNode finalRes = insertBefore(sum.sum, sum.carry);
            return finalRes;
        }

    }

    //链表求和
    public static PartialSum addListHelper(ListNode node1, ListNode node2) {
        PartialSum sum = new PartialSum();
        if (node1 == null && node2 == null) {
            return sum;
        }

        //对应为相加
        sum = addListHelper(node1.next, node2.next);
        int val = sum.carry + node1.val + node2.val;

        //插入当前数字的求和结果
        ListNode result = insertBefore(sum.sum, val % 10);
        sum.sum = result;
        sum.carry = val / 10;

        return sum;
    }

    //用零填充较短链表的开头
    public static ListNode padList(ListNode node, int padding) {
        ListNode head = node;
        for (int i = 0; i < padding; i++) {
            ListNode n = new ListNode(0);
            n.next = head;
            head = n;
        }
        return head;
    }

    //求链表的长度
    public static int length(ListNode node) {
        int len = 0;
        if (node == null)
            return 0;

        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    //将节点插入链表首部
    public static ListNode insertBefore(ListNode node, int data) {
        ListNode n = new ListNode(data);
        if (node != null) {
            n.next = node;
        }
        return n;
    }
}
