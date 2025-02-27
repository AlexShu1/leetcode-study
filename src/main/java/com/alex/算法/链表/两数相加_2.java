package com.alex.算法.链表;

/**
 * 描述:给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @auth shufei
 * @date 2025/2/27
 */
public class 两数相加_2 {

    public static void main(String[] args) {
        两数相加_2 call = new 两数相加_2();
        ListNode l1 = ListNode.init(new int[]{2, 4, 3});
        ListNode l2 = ListNode.init(new int[]{5, 6, 4});
        ListNode listNode = call.addTwoNumbers(l1, l2);
        int sum = 0;
        int powIndex = 0;
        while (listNode != null) {
            System.out.printf(listNode.val + " -> ");
            // 得到对应的整数: 每一个位 * 10的N次方(从0开始==个位)
            sum += (listNode.val * (int) Math.pow(10, powIndex++));
            listNode = listNode.next;
        }

        System.out.println(sum);

        System.out.println("Finished!");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 虚拟头结点(保证头节点位置固定)
        ListNode dummy = new ListNode(-1);
        // 实际操作节点.
        ListNode head = new ListNode(0);
        // 虚拟头节点和实际头节点连接在一起
        dummy.next = head;

        int addNextValue = 0;
        // 循环终止条件分析: 只要有任意一个链表或者进位数据, 都应该再算一遍;
        while (l1 != null || l2 != null) {
            // 进位数据节点: 需要每次参数运算.
            int sum = head.val;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 进位标识
            addNextValue = sum / 10;
            // 余数
            head.val = sum % 10;

            if (l1 != null || l2 != null || addNextValue > 0) {
                // 进位作为下一次和L1 + L2的参数一起运算
                head.next = new ListNode(addNextValue);
                // 指针调节到下一个节点(也就是上一行的进位数据节点);
                head = head.next;
            }

            // 上一个步骤已经把最后一个进位加入到了下一个node节点, 因此, 当两个链表都为空的时候, 可以直接退出.
            if (l1 ==null && l2 == null) {
                break;
            }
        }

        return dummy.next;
    }
}
