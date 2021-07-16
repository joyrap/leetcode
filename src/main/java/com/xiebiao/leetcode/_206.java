package com.xiebiao.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author bjxieb
 * @date 7/16/21
 **/
public class _206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = reverseList(head);
        System.out.println(result);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            head.next = pre;
            pre = head;
            head = curr;

        }
        return pre;
    }

}
