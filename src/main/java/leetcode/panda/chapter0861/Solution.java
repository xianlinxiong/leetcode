package leetcode.panda.chapter0861;

/**
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(s.matrixScore(nums));
        System.out.println(3<<3);

    }

    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        int result = 0;
        result += A.length << (A[0].length-1);
        for (int i = 1; i < A[0].length; i++) {
            int c = 0;
            for(int j =0; j<A.length;j++){
                if(A[j][i] == 1){
                    c++;
                }
            }
            result += Math.max(c, A.length-c) << (A[0].length-1-i);
        }
        return result;
    }
}