package com.alex.算法.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class 螺旋矩阵_54 {

    public static void main(String[] args) {
        螺旋矩阵_54 call = new 螺旋矩阵_54();
       int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = call.spiralOrder(matrix);
        for (Integer item : integers) {
            System.out.printf(item + ", ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 上边：头不动, 列动： 扫描一行
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }

            // 右边：右不动，行动: 扫描一列
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }

            //
            if (left < right && top < bottom) {

                // 下边：底不动，列动：倒着扫描一行
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }

                // 左边：左不动，行动：倒着扫描一列
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }

            // 每次执行一圈，进行递增 + 缩减
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
