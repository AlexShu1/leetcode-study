package com.alex.算法.链表;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode init(int[] source) {
        ListNode head = new ListNode(source[0]);
        ListNode cur = head;
        for (int i = 1; i < source.length; i++) {
            cur.next = new ListNode(source[i]);
            cur = cur.next;
        }

        return head;
    }
}
