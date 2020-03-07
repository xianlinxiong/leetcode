package leetcode.panda.chapter0073;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
  *
 *
 *
 */

class Solution {
    public static void main(String[] args) {
        int[][] array = {{1,0}};
        Solution s = new Solution();
        s.setZeroes(array);
    }

    /**
     * 动态规划：如果某matrix[i][j]==0将i行首元素置0，将j列首元素置0；根据首元素为零，设置对应的行和列
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        boolean zeroX = false;
        boolean zeroY = false;
        if(matrix[0][0]==0){
            zeroX = true;
            zeroY = true;
        }
        else{
            for(int i =0; i< x; i++){
                if(matrix[i][0]==0){
                    zeroY =true;
                    break;
                }
            }
            for(int j=0; j<y;j++){
                if(matrix[0][j]==0){
                    zeroX = true;
                    break;
                }
            }
        }
        for(int i =1; i< x; i++){
            for(int j =1; j< y; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i< x; i++){
            if(matrix[i][0] ==0){
                for(int j =1; j< y;j++){
                    matrix[i][j] =0;
                }
            }
        }

        for(int j =1; j< y; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i< x; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(zeroX){
            for(int j =0;j< y; j++){
                matrix[0][j] =0;
            }
        }
        if(zeroY){
            for(int i=0; i<x;i++){
                matrix[i][0]=0;
            }
        }

    }
}