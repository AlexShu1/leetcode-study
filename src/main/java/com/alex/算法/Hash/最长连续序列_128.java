package com.alex.算法.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class 最长连续序列_128 {

    public static void main(String[] args) {
        最长连续序列_128 call = new 最长连续序列_128();
        int[] nums = new int[] {100,4,200,1,3,2};
        int longestConsecutive = call.longestConsecutive(nums);
        System.out.println(longestConsecutive);
    }

    /**
     * 核心算法:
     */
    public int longestConsecutive(int[] nums) {
        // 1.去除重复的元素
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            // 不包含代表, num是连续序列的最后一个元素
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 不断探测, 是否有当前元素 + 1的连续串存在; 并更新连续串的长度
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // 进行MAX操作, 得到最长子串长度.
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
