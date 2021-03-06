package leetcode.panda.chapter1030;

import java.util.LinkedList;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.allCellsDistOrder(2, 2, 0, 1));

    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        int total = 1;
        result[0][0] = r0;
        result[0][1] = c0;
        int cur = 1;
        while (cur < result.length) {
            int start = r0 - total;
            if (start < 0) {
                start = 0;
            }
            int end = r0 + total;
            if (end >= R) {
                end = R - 1;
            }
            for (int i = start; i <= end; i++) {
                int d = total - Math.abs(r0 - i);
                if (d == 0) {
                    result[cur][0] = i;
                    result[cur][1] = c0;
                    cur++;
                    continue;
                }
                if (c0 - d >= 0) {
                    result[cur][0] = i;
                    result[cur][1] = c0 - d;
                    cur++;
                }
                if (c0 + d < C) {
                    result[cur][0] = i;
                    result[cur][1] = c0 + d;
                    cur++;
                }
            }
            total++;
        }
        return result;
    }
}