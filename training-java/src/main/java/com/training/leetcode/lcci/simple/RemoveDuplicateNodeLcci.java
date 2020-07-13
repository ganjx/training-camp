package com.training.leetcode.lcci.simple;

import com.training.leetcode.model.ListNode;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class RemoveDuplicateNodeLcci {

    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * <p>
     * 示例1:
     * <p>
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * 示例2:
     * <p>
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     * 提示：
     * <p>
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     * 进阶：
     * <p>
     * 如果不得使用临时缓冲区，该怎么解决？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;


        ListNode listNode = removeDuplicateNodes(listNode1);
        print(listNode);

    }

    public static void print(ListNode head) {
        System.out.println(head.val);
        if (head.next != null) {
            print(head.next);
        }
    }

    /**
     * 思路：不使用缓冲区
     *
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while(current != null) {

            //从当前节点开始查找
            ListNode p = current;
            while (p.next != null) {

                // 找到和当前val不同值的对象，当前next就等于找到的对象
                if (p.next.val == current.val) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            current = current.next;
        }

        return head;

    }


}
