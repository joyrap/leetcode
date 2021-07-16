package com.xiebiao.leetcode;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author bjxieb
 * @date 7/16/21
 **/
public class _24 {

    public static void main(String[] args) {
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        //ListNode result = swapPairs(head);
        ListNode result = swapPairs2(head);
        System.out.println(result);
    }

    /**
     * 方法1：将链表分为两个数组，再将两个数组组合成链表。
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<ListNode> arr1 = new ArrayList<ListNode>();
        ArrayList<ListNode> arr2 = new ArrayList<ListNode>();
        int count = 1;

        //空间复杂度为n
        while (head != null) {
            if (count % 2 == 0) {
                arr2.add(new ListNode(head.val));
            } else {
                arr1.add(new ListNode(head.val));
            }
            count++;
            head = head.next;
        }
        for (int i = 0; i < arr2.size(); i++) {
            if (arr1.get(i) != null) {
                arr2.get(i).next = arr1.get(i);
                if (i + 1 != arr2.size()) {
                    arr1.get(i).next = arr2.get(i + 1);
                } else {
                    if (arr1.size() > arr2.size()) {
                        arr1.get(i).next = arr1.get(i + 1);
                    }
                }
            }
        }
        return arr2.get(0);
    }

    /**
     * 迭代法
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode newHead = new ListNode(-1);//新链表头
        newHead.next = head;
        ListNode pre = newHead;
        ListNode a;
        ListNode b;
        while (pre.next != null && pre.next.next != null) {//链表至少有两个元素
            a = pre.next;
            b = a.next;
            
            pre.next = b;//
            a.next = b.next;
            b.next = a;
            pre = a;

        }
        return newHead.next;
    }

    /**
     * 递归(递归代码简介，但是空间复杂度为n)
     */
    public static ListNode swapPairs3(ListNode head) {
        return null;
    }
}
