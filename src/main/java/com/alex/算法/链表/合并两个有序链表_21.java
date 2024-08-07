package com.alex.算法.链表;

import java.util.Objects;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class 合并两个有序链表_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1)) {
            return list2;
        }

        if (Objects.isNull(list2)) {
            return list1;
        }

        ListNode newList = new ListNode(-1);
        ListNode cur = newList.next;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur = new ListNode(list2.val);
                list2 = list2.next;
            }

            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;
        return newList.next;
    }
}
