package com.alex.算法.普通数组;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class 最大子数组和_53 {

    public static void main(String[] args) {
        最大子数组和_53 call = new 最大子数组和_53();
        int[] nums = new int[] {5,4,-1,7,8};
        int maxSubArray = call.maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // 前面的sum是否大于当前元素; 若大于则可以认为当前元素的损益可控;
            // 若小于, 则认为前面的sum不符合要求, 重新开启子串
            pre = Math.max(pre + x, x);
            // 求取最大子串和
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
