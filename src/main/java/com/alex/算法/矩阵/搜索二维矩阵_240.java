package com.alex.算法.矩阵;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class 搜索二维矩阵_240 {

    public static void main(String[] args) {
        搜索二维矩阵_240 call = new 搜索二维矩阵_240();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        boolean searchMatrix = call.searchMatrix(matrix, 8);
        System.out.println(searchMatrix);

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            // 先找一层最大的数据, 若大于target, 则说明在这一行上.
            if (matrix[x][y] > target) {
                --y;
            } else {
                // 反之, 则可以认为是当前层不存在这个数据，进入到下一层.
                ++x;
            }
        }
        return false;
    }
}
