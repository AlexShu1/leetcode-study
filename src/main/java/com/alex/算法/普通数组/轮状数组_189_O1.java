package com.alex.算法.普通数组;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class 轮状数组_189_O1 {

    public static void main(String[] args) {
        轮状数组_189_O1 call = new 轮状数组_189_O1();
        int[] nums = new int[] {-1,-100,3,99};
        call.rotate(nums, 2);

        //Arrays.stream(nums).forEach(System.out::println);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        System.out.println(k);
        reverse(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(item -> {
            System.out.printf(item + ", ");
        });
        System.out.println();
        reverse(nums, 0, k - 1);
        Arrays.stream(nums).forEach(item -> {
            System.out.printf(item + ", ");
        });
        System.out.println();
        reverse(nums, k, nums.length - 1);
        Arrays.stream(nums).forEach(item -> {
            System.out.printf(item + ", ");
        });
        System.out.println();
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
