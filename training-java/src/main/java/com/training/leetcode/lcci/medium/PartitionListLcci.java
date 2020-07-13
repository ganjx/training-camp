package com.training.leetcode.lcci.medium;

import com.training.leetcode.model.ListNode;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class PartitionListLcci {

    /**
     * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
     * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     * <p>
     * 示例:
     * <p>
     * 输入: head = 3->5->8->5->10->2->1, x = 5
     * 输出: 3->1->2->10->5->5->8
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(3);
//        ListNode listNode2 = new ListNode(5);
//        ListNode listNode3 = new ListNode(8);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(10);
//        ListNode listNode6 = new ListNode(2);
//        ListNode listNode7 = new ListNode(1);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;

        ListNode build = build(new int[]{1});

        ListNode partition = partition(build, 0);
        print(partition);

    }

    public static ListNode build(int[] ints){
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < ints.length; i++) {
            if(head == null){
                head = new ListNode(ints[i]);
            }
            else{
                ListNode temp = new ListNode(ints[i]);
                if(tail == null){
                    head.next = temp;
                }
                else{
                    tail.next = temp;
                }
                tail = temp;
            }
        }

        return head;
    }
    /**
     * 思路： 参考HashMap中resize方法中迁移链表的算法
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode loHead = null;
        ListNode loTail = null;
        ListNode hiHead = null;
        ListNode hiTail = null;

        ListNode temp= head;
        while (temp != null) {
            if(temp.val < x){
                if(loTail == null){
                    loHead = temp;
                }
                else{
                    loTail.next = temp;
                }
                loTail = temp;
            }
            else{
                if(hiTail == null){
                    hiHead = temp;
                }
                else{
                    hiTail.next = temp;
                }
                hiTail = temp;
            }

            ///////////
            temp = temp.next;
        }


        if(hiTail != null){
            hiTail.next = null;
        }

        if(loTail != null){
            loTail.next = hiHead;
        }

        return loHead !=null?loHead:hiHead;
    }

    public static void print(ListNode head) {
        System.out.println(head.val);
        if (head.next != null) {
            print(head.next);
        }
    }
}
