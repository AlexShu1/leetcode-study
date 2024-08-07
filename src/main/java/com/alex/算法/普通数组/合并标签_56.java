package com.alex.算法.普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class 合并标签_56 {

    public static void main(String[] args) {
        合并标签_56 call = new 合并标签_56();
        int[][] intervals = new int[][] {{1,3},{8,10},{2,6}, {15,18}};
        int[][] merge = call.merge(intervals);
        for (int[] items : merge) {
            System.out.printf("[");
            for (int item : items) {
                System.out.printf(item + ", ");
            }
            System.out.printf("]");
        }
    }

    public int[][] merge(int[][] intervals) {
        // 判断数组是否为空
        if (intervals.length == 0) {
            return new int[0][2];
        }

        // 进行数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            // 若第一个元素, 或者是最后一个元素的右边界<当前元素的左边界, 则认为是断开的.
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                // 更新最后一个元素的有边界: 取最后一个元素的右边界和当前元素的右边界MAX
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
