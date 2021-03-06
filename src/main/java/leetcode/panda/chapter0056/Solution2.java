package leetcode.panda.chapter0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] nums = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(merge(nums));
    }

    public static int[][] merge(int[][] intervals) {
        if(null == intervals || intervals.length ==0 ){
            return intervals;
        }

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] result = new int[intervals.length][2];
        int j = 0;
        result[0]=intervals[0];
        for(int i = 1; i< intervals.length; i++){
            while(i < intervals.length &&result[j][1] >= intervals[i][0]){
                result[j][1] = Math.max(intervals[i][1], result[j][1]);
                i++;
            }
            if(i < intervals.length){
                j++;
                result[j] = intervals[i];
            }

        }
        int[][] f = new int[j+1][2];
        while(j >= 0){
            f[j] = result[j];
            j--;
        }
        return f;
    }

}
