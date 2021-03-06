package leetcode.panda.chapter0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {1, 2, 2};
        System.out.println(s.subsetsWithDup(nums));
    }

    /**
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                end = i;
            } else {
                int length = result.size();

                for (int n = 0; n < length; n++) {
                    List<Integer> li = result.get(n);
                    for (int m = start; m <= end; m++) {
                        li = new ArrayList<>(li);
                        li.add(nums[m]);
                        result.add(li);
                    }
                }
                start = i;
                end = i;
            }
        }

        int length = result.size();

        for (int n = 0; n < length; n++) {
            List<Integer> li = result.get(n);
            for (int m = start; m <= end; m++) {
                li = new ArrayList<>(li);
                li.add(nums[m]);
                result.add(li);
            }
        }
        return result;

    }

}