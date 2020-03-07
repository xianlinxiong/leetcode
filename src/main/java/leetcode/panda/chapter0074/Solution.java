package leetcode.panda.chapter0074;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 *
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] matrix = {{}
    };
        System.out.println(s.searchMatrix1(matrix, 1));
    }


    /**
     * 从左上角出发，往下或者往右走
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length<=0 || matrix[0].length == 0){
            return false;
        }
        int y = matrix[0].length;
        int x = matrix.length;
        int row =0;
        for(int i =0; i<x;i++ ){
            if(matrix[i][y-1] == target){
                return true;
            }
            row=i;
            if(matrix[i][y-1] > target){
                break;
            }
        }

        for(int j =0; j<y;j++){
            if(matrix[row][j]== target){
                return true;
            }
        }

        return false;
    }
}