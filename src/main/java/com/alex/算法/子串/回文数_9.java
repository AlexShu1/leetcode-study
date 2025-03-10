package com.alex.算法.子串;

/**
 * 描述
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * Related Topics
 * 数学
 *
 * @auth shufei
 * @date 2025/3/3
 */
public class 回文数_9 {
    public static void main(String[] args) {
        回文数_9 call = new 回文数_9();
        boolean res = call.exec(121);
        System.out.println(res);
    }

    /**
     * 核心算法: 左右双指针, 不断的比较两个指针所属的元素是否一致; 最后右指针应该小于等于左指针.
     */
    private boolean exec(int source) {
        String number = String.valueOf(source);
        int left = 0, right = number.length() - 1;
        while (left <= right) {
            if (number.charAt(left) == number.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }


        return left >= right;
    }
}
