package com.xiebiao.leetcode;

/**
 * https://leetcode-cn.com/problems/reorder-list/submissions/
 *
 * @author bjxieb
 * @date 7/14/21
 **/
public class _143 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reorderList(head);
        System.out.println(head);
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

    static class Solution {

        public void reorderList(ListNode head) {
            ListNode middle = middleNode(head);
            ListNode head2 = middle.next;
            middle.next = null;
            head2 = reverse(head2);

            merge(head, head2);
            System.out.println(head);
        }

        ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        ListNode reverse(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = pre;
                pre = curr;
                curr = temp;
            }
            return pre;
        }

        void merge(ListNode head1, ListNode head2) {
            ListNode next1;
            ListNode next2;
            while (head1 != null && head2 != null) {
                next1 = head1.next;
                next2 = head2.next;

                head1.next = head2;
                head1 = next1;//移动head1

                head2.next = next1;
                head2 = next2;//移动head2
            }
        }

    }
}
