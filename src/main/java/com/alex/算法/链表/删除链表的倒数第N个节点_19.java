package com.alex.算法.链表;

/**
 * 描述
 *
 * @auth shufei
 * @date 2025/3/4
 */
public class 删除链表的倒数第N个节点_19 {
    public static void main(String[] args) {
        删除链表的倒数第N个节点_19 call = new 删除链表的倒数第N个节点_19();
        int[] data = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.init(data);
        ListNode listNode = call.removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 得到链表长度
        int length = getLength(head);
        ListNode cur = dummy;
        // 遍历要跳过的N个节点元素; 使得cur.next为删除元素.
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }

        // 删除第N个元素; N-1元素和N+1元素连接在一起
        cur.next = cur.next.next;
        // 使用dummy.next 返回记住的head
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

}
