package com.alex.算法.链表;

public class 反转链表_24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // 反转元素：倒装了顺序.
        head.next.next = head;
        // 把原来的引用断开, 否则, 这里会产生环(4->5->null  -->  4->5->4->5->4->5....);
        head.next = null;
        return newHead;
    }
}
