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
public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{4,5},{1,4},{0,1}};
        System.out.println(merge(nums));
    }

    /**
     * 根据首元素排序，然后merge各段；
     * 此处采用的是比较排序，每次抽取最小值。
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return intervals;
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] flags = new boolean[length];
        for (int i = 0; i < length; i++) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < length; j++) {
                if (flags[j]) {
                    continue;
                }
                if (min > intervals[j][0]) {
                    min = intervals[j][0];
                    k = j;
                }
            }
            flags[k] = true;
            doMerge(result, Arrays.stream(intervals[k]).boxed().collect(Collectors.toList()));
        }
        int[][] r = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            r[i][0]= result.get(i).get(0);
            r[i][1]= result.get(i).get(1);
        }
        return r;

    }

    /**
     *
     * @param result
     * @param newOne
     */
    private static void doMerge(List<List<Integer>> result, List<Integer> newOne) {
        if(result.size() == 0){
            result.add(newOne);
        }
        int i = 0;
        for (; i < result.size(); i++) {
            List<Integer> t = result.get(i);
            if (newOne.get(0) > t.get(1)) {//在当前元素之后
                if(i ==result.size()-1){//放在最后元素
                    result.add(newOne);
                }
                continue;
            } else if (newOne.get(1) < t.get(0)) {//当前元素之前
                result.add(i, newOne);
                break;
            } else {
                if (newOne.get(0) < t.get(0)) {//更新档前元素起始值
                    t.set(0, newOne.get(0));
                }
                if (newOne.get(1) <= t.get(1)) {//在中间
                    break;
                } else {
                    t.set(1, newOne.get(1));//更新当前元素的末尾值，
                    if (i < result.size() - 1) {//往后跳
                        newOne = result.get(i + 1);
                    }
                }
            }
        }
    }

}
