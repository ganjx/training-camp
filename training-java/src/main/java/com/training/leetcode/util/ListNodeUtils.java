package com.training.leetcode.util;

import com.sun.org.apache.xpath.internal.operations.String;
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

    /**
     * print listNode
     */
    static StringBuilder stringBuilder = new StringBuilder();
    public static void print(ListNode head) {
        stringBuilder.append(head.val).append(",");
        if (head.next != null) {
            print(head.next);
        }
        else{
            // delete last one
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            // system print
            System.out.println(stringBuilder.toString());
            // clear to empty
            stringBuilder.delete(0,stringBuilder.length());
        }
    }
}
