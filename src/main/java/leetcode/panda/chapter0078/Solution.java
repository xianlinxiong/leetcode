package leetcode.panda.chapter0078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {1,2,3};
        System.out.println(s.subsets(nums));
    }

    /**
     * 递归求解:一个元素一个元素的增加到解集中
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        return doSub(nums, 0, result);
    }

    private List<List<Integer>> doSub(int[] nums, int start, List<List<Integer>> result){
        List<List<Integer>> temp = new ArrayList<>();
        if(start == nums.length){
            return result;
        }
        for(List<Integer> list : result) {
            List<Integer> newList = list.stream().collect(Collectors.toList());
            newList.add(nums[start]);
            temp.add(list);
            temp.add(newList);
        }
        return doSub(nums, start+1, temp);
    }
}