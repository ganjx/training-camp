package com.training.leetcode.lcci.simple;

import com.training.leetcode.model.ListNode;
import com.training.leetcode.util.ListNodeUtils;

/**
 * @author ganjx
 * Copyright (c) 2012-2020 All Rights Reserved.
 */
public class PalindromeLinkedListLcci {

    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     * 示例 1：
     * 输入： 1->2
     * 输出： false
     * <p>
     * 示例 2：
     * 输入： 1->2->2->1
     * 输出： true
     * <p>
     * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(ListNodeUtils.build(new int[]{1, 2, 2, 1})));
    }

    /**
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        // 链表反转
        ListNode reversed = reverseAndClone(head);
        // 和原始列表对比
        return isEqual(head, reversed);

    }

    public static ListNode reverseAndClone(ListNode node) {
        ListNode head = null;
        while (node != null) {
            // 复制节点
            ListNode n = new ListNode(node.val);
            // 此时head指向上一个节点
            n.next = head;
            // head指向当前节点，当前n为链表最后一个节点
            head = n;
            // 正向遍历节点
            node = node.next;
        }
        return head;
    }

    /**
     * 比对每个节点的值是否相同
     * @param one
     * @param two
     * @return
     */
    public static boolean isEqual(ListNode one, ListNode two) {
        while (one != null && two != null) {
            if (one.val != two.val) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

}
