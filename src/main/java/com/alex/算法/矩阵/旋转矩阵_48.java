package com.alex.算法.矩阵;

/**
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class 旋转矩阵_48 {

    public static void main(String[] args) {
        旋转矩阵_48 call = new 旋转矩阵_48();
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        call.rotate(matrix);
        for (int[] items : matrix) {
            System.out.printf("[");
            for (int item : items) {
                System.out.printf(item + ", ");
            }
            System.out.printf("]");
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                // 0, 0
                int temp = matrix[i][j];
                // 0,0 = 2, 0
                matrix[i][j] = matrix[n - j - 1][i];
                // 2,0 = 2,2
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                // 2, 2 = 0, 2
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                // 0,2 = 0,0
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
