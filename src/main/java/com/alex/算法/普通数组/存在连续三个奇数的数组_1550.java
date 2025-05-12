package com.alex.算法.普通数组;

import java.util.Arrays;

/**
 * 描述
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * <p>
 * 示例1：
 * 输入：arr = [2,6,4,1]输出：false解释：不存在连续三个元素都是奇数的情况。
 * <p>
 * 示例2：
 * 输入：arr = [1,2,34,3,4,5,7,23,12]输出：true解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 * 1 <= arr.length <= 10001 <= arr[i] <= 1000
 *
 * @auth shufei
 * @date 2025/5/12
 */
public class 存在连续三个奇数的数组_1550 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        boolean validateResult = validateArr(arr);
        System.out.println(validateResult);
    }

    private static boolean validateArr(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }

        int[] list = new int[3];
        for (int i = 1; i < n - 1; i++) {
            // 核心思想: 若中间元素是偶数, 那么左右两边的元素都无法达成3个素数
            // 这样可以减少遍历次数, 以及CPU运算
            if (arr[i] % 2 == 0) {
                i++;
                continue;
            }

            if (arr[i - 1] % 2 != 0 && arr[i + 1] % 2 != 0) {
                list = new int[]{arr[i - 1], arr[i], arr[i + 1]};
                Arrays.stream(list).forEach(System.out::println);
                return true;
            }
        }
        return false;
    }
}
