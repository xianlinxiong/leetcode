package leetcode.panda.chapter0059;

/**
 *给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

    /**
     * 左走右走，绕圈圈
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        int start =1;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (up < down && left < right) {
            start =goRight(matrix, up, left, right, start);
            up++;
            start =goDown(matrix, right, up, down, start);
            right--;
            start =goLeft(matrix, down, left, right, start);
            down--;
            start =goUp(matrix, left, up, down, start);
            left++;
        }
        if (left < right && up == down) {
            goRight(matrix, up, left, right, start);
        } else if (up < down && left == right) {
            goDown(matrix, right, up, down, start);
        } else if (up == down && left == right) {
            goRight(matrix, up, left, right, start);
        }
        return matrix;
    }

    private static int goRight(int[][] matrix, int up, int left, int right, int start) {
        for (int i = left; i <= right; i++) {
            matrix[up][i] =start++;
        }
        return start;
    }

    private static int goDown(int[][] matrix, int right, int up, int down, int start) {
        for (int i = up; i <= down; i++) {
            matrix[i][right] = start++;
        }
        
        return start;
    }

    private static int goLeft(int[][] matrix, int down, int left, int right, int start) {
        for (int i = right; i >= left; i--) {
            matrix[down][i] =start++;
        }
        return start;
    }

    private static int goUp(int[][] matrix, int left, int up, int down, int start) {
        for (int i = down; i >= up; i--) {
            matrix[i][left] = start++;
        }
        return start;
    }

}