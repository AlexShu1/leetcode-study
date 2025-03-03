package com.alex.算法.双指针;

/**
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 */
public class 盛最多的水_11 {

    public static void main(String[] args) {
        盛最多的水_11 call = new 盛最多的水_11();
        int[] areas = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = call.maxArea(areas);
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        // 不能相等, 不然没有容积了, 没有宽度.
        while (l < r) {
            // Math.min(height[l], height[r]): 的含义是因为这是一个水杯, 只能取最小值, 若取最大值
            // 水会溢出来.
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            // 留存高一点的容器; 否则长度不断缩小; 高度只有更高的时候, 才可能出现更大的容积
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
