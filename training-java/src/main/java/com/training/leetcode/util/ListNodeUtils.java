package com.training.leetcode.util;

import com.training.leetcode.model.ListNode;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class ListNodeUtils {

    /**
     * 生成单向链表结构
     * @param ints
     * @return
     */
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

    public static void print(ListNode head) {
        System.out.println(head.val);
        if (head.next != null) {
            print(head.next);
        }
    }
}
