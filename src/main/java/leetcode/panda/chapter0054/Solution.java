package leetcode.panda.chapter0054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
class Solution {

    /**
     * 左走右走，绕圈圈
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return Collections.emptyList();
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (up < down && left < right) {
            goRight(matrix, up, left, right, result);
            up++;
            goDown(matrix, right, up, down, result);
            right--;
            goLeft(matrix, down, left, right, result);
            down--;
            goUp(matrix, left, up, down, result);
            left++;
        }
        if (left < right && up == down) {
            goRight(matrix, up, left, right, result);
        } else if (up < down && left == right) {
            goDown(matrix, right, up, down, result);
        } else if (up == down && left == right) {
            goRight(matrix, up, left, right, result);
        }
        return result;
    }

    private static void goRight(int[][] matrix, int up, int left, int right, List<Integer> result) {
        for (int i = left; i <= right; i++) {
            result.add(matrix[up][i]);
        }
    }

    private static void goDown(int[][] matrix, int right, int up, int down, List<Integer> result) {
        for (int i = up; i <= down; i++) {
            result.add(matrix[i][right]);
        }
    }

    private static void goLeft(int[][] matrix, int down, int left, int right, List<Integer> result) {
        for (int i = right; i >= left; i--) {
            result.add(matrix[down][i]);
        }
    }

    private static void goUp(int[][] matrix, int left, int up, int down, List<Integer> result) {
        for (int i = down; i >= up; i--) {
            result.add(matrix[i][left]);
        }
    }

}