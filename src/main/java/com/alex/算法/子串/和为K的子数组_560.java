package com.alex.算法.子串;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class 和为K的子数组_560 {

    public static void main(String[] args) {
        和为K的子数组_560 call = new 和为K的子数组_560();
        int[] nums = new int[] {1,1,1};
        int subarraySum = call.subarraySum(nums, 2);
        System.out.println(subarraySum);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];

                // 保证在任何一个组合中, 主要出现可以出现等于k的时候, 就计数1次.
                // 若把if count, 放到for循环外面, 则每次都全部计算完成了每个整体子串的sum. 但是, 可能
                // 这个子串中的部分子串已经符合预期了.
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
