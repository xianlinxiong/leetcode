package leetcode.panda.chapter0304;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * <p>
 * <p>
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 */
class NumMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{}};
        NumMatrix obj = new NumMatrix(matrix);
        ;
        System.out.println(obj.sumRegion(0, 0, 0, 0));
    }

    int[][] sumArray;

    public NumMatrix(int[][] matrix) {
        if(matrix.length >1){}
        sumArray = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sumArray[i+1][j + 1] = sumArray[i+1][j] + matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= matrix[0].length; j++) {
                sumArray[i + 1][j] += sumArray[i][j];
            }
        }
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumArray[row2 + 1][col2 + 1] + sumArray[row1][col1] - sumArray[row1][col2+1] - sumArray[row2+1][col1];
    }
}