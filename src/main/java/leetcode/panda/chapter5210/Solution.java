package leetcode.panda.chapter5210;

/**
 * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
 * <p>
 * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
 * <p>
 * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
 * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
 * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
 * <p>
 * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
 * 输出：[1,-1,-1,-1,-1]
 * 解释：示例如图：
 * b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
 * b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
 * b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
 * 示例 2：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：[-1]
 * 解释：球被卡在箱子左侧边上。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5};

        int[] arr2 = {3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
        //        System.out.println(s.minOperations(arr2, 894887480));
//        System.out.println(s.eatenApples(arr1, arr2));

    }

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0; i < result.length; i++) {
            int j = 0;
            int k = i;
            while (j < grid.length) {
            }
            if (j >= grid.length) {
                result[i] = k;
            } else {
                result[k] = -1;
            }
        }

        return result;

    }
}