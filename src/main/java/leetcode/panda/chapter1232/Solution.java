package leetcode.panda.chapter1232;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {
                2, 1, 4, 3, 9, 6};

    }

    public boolean checkStraightLine(int[][] coordinates) {
        boolean result = true;
        int up = coordinates[1][1] - coordinates[0][1];
        int down = coordinates[1][0] - coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (((coordinates[i][1] - coordinates[1][1]) * down) != ((coordinates[i][0] - coordinates[1][0]) * up)) {
                result = false;
                break;
            }
        }
        return result;
    }
}