package leetcode.panda.chapter0048;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
        System.out.println(matrix);
    }

    /**
     * 双旋转：斜角对称转换，垂直对称转换
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        rotateAcross(matrix);
        rotateVerticle(matrix);
    }

    private static void rotateAcross(int[][] matrix){
        for(int x = 0; x < matrix.length; x++){
            for(int y = x; y < matrix[x].length; y++){

                int t = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = t;
            }
        }
    }

    private static void rotateVerticle(int[][] matrix){
        int i = 0;
        int j = matrix.length-1;

        while(i < j){
            for(int k = 0; k<matrix.length; k++){
                int t = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = t;
            }
            i++;
            j--;
        }
    }

}