package com.alex.算法.链表;

import static com.alex.算法.链表.ListNode.init;

/**
  https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 
  给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 
  图示两个链表在节点 c1 开始相交：
 
  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
  输出：Intersected at '8'
  解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
  从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
  在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
  — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
  换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
 */
public class 相交链表_160 {

    public static void main(String[] args) {
        int[] arr = new int[] {4,1,8,4,5};
        int[] arr2 = new int[] {5,6};
        ListNode hA = init(arr);
        ListNode hB = init(arr2);

        相交链表_160 call = new 相交链表_160();
        ListNode intersectionNode = call.getIntersectionNode(hA, hB);
        while (intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }

    /**
     * 若需要测试相交的链表, 需要保证真的入参是相交的两个链表; 而不是说是不是存在相同得val;
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
