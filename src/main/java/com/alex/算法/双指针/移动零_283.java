package com.alex.算法.双指针;

/**
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 */
public class 移动零_283 {

    public static void main(String[] args) {
        移动零_283 call = new 移动零_283();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        call.moveZeroes(nums);

        for (int num : nums) {
            System.out.printf(num + ", ");
        }
    }

    /**
     * 核心思想: 两个指针, right代表不为0的元素下标, left代表0的下标;
     * 遇到不为0的数据, 和0的下标进行交换; 最终, 0全部被交换到最后的元素了.
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
