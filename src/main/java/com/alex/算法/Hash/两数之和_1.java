package com.alex.算法.Hash;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class 两数之和_1 {

    public static void main(String[] args) {
        两数之和_1 call = new 两数之和_1();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] twoSum = call.twoSum(nums, target);
        System.out.printf("index: %d, %d", twoSum[0], twoSum[1]);
    }

    /**
     * 核心算法：使用Hash算法进行计算.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMaps = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            // 若Map里面已经存在target-nums[i], 则可以认为有符合元素的Map
            if (numMaps.containsKey(target - nums[i])) {
                // 第一个元素就是历史存储的元素下标; 第二个元素是代表符合的当前元素下标.
                return new int[] {numMaps.get(target - nums[i]), i};
            }

            // Map元素的key: 每个元素, value: 对应元素的下标.
            numMaps.put(nums[i], i);
        }

        return new int[]{0,0};
    }
}
