package com.alex.算法.动态规划;

import java.util.Arrays;

/**
 * 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
 * <p>
 * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
 * 输出：3
 * 解释：
 * 1 块石头放入背包 0 ，1 块石头放入背包 1 。
 * 每个背包中的石头总数是 [2,3,4,4] 。
 * 背包 0 、背包 1 和 背包 2 都装满石头。
 * 总计 3 个背包装满石头，所以返回 3 。
 * 可以证明不存在超过 3 个背包装满石头的情况。
 * 注意，可能存在其他放置石头的方案同样能够得到 3 这个结果。
 * 示例 2：
 * <p>
 * 输入：capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
 * capacity数组的每一个元素代表一个背包的容量.
 * rocks数组的每一个元素代表一个背包现在使用的情况.
 * 输出：3
 * 解释：
 * 8 块石头放入背包 0 ，2 块石头放入背包 2 。
 * 每个背包中的石头总数是 [10,2,2] 。
 * 背包 0 、背包 1 和背包 2 都装满石头。
 * 总计 3 个背包装满石头，所以返回 3 。
 * 可以证明不存在超过 3 个背包装满石头的情况。
 * 注意，不必用完所有的额外石头。
 */
public class 装满石头的背包最大数量_2279 {

    public static void main(String[] args) {
        装满石头的背包最大数量_2279 call = new 装满石头的背包最大数量_2279();
        int[] capacity = {10,2,2};
        int[] rocks = {2,2,0};
        int result = call.maximumBags(capacity, rocks, 100);
        System.out.println(result);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] a = new int[n];
        // 1.得到每个背包的剩余空间
        for (int i = 0; i < n; i++) {
            a[i] = capacity[i] - rocks[i];
        }
        // 空间从小到大排序
        Arrays.sort(a);//升序排列
        int num = 0;//次数
        for (int i = 0; i < n; i++) {
            // 不断尝试填充满背包
            if (a[i] <= additionalRocks) {
                num++;
                additionalRocks -= a[i];
            } else
                break;
        }
        return num;
    }
}
