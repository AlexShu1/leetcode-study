package com.alex.算法.链表;


import static com.alex.算法.链表.ListNode.init;

/**
 * https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class 反转链表_206 {

    public static void main(String[] args) {
        反转链表_206 call = new 反转链表_206();
        int[] arr = new int[] {4,1,8,4,5};
        ListNode hA = init(arr);

        ListNode listNode = call.reverseList(hA);
        while (listNode != null) {
            System.out.printf( listNode.val  + " -> ");
            listNode = listNode.next;
        }
    }

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

        /**
         * eg:
         * 从最后一步推演:
         * 最后返回的head是5;
         * 回归上一层是4,
         * 那么, head -> next -> next : 4->5->Null;  赋值之和, 变为了4->5->4->5->4->5....
         * head.next = null 则把4->5之间的所有链接断开。 那么, 链表只剩下了5->4->Null.
         */
    }
}
