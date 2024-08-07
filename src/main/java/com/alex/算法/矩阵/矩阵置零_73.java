package com.alex.算法.矩阵;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class 矩阵置零_73 {

    public static void main(String[] args) {
        矩阵置零_73 call = new 矩阵置零_73();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        call.setZeroes(matrix);

        for (int[] items : matrix) {
            System.out.printf("[");
            for (int item : items) {
                System.out.printf(item + ", ");
            }
            System.out.printf("]");
        }
    }

    /**
     * 核心算法: 通过rows + cols的行列标记出现0的位置;
     * 再次遍历的时候, 若i or j符合标识位置, 则设置0.
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
