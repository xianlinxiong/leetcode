package leetcode.panda.chapter0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 *
 */
public class Solution2 {
    public static void main(String[] args) {
       int[] candidate = {2,3,6,7};
       int target = 7;
        Solution2 solution2 = new Solution2();
       List result = solution2.combinationSum(candidate, target);
        System.out.println(result);
    }


    /**
     * 排序递归寻找
     * @param candidates
     * @param target
     * @return
     */
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        doCombinationSum(candidates, 0, target, result, new ArrayList<>());

        return result;
    }

    private void doCombinationSum(int candidates[], int start, int target, List<List<Integer>> result, List<Integer> list){
        if(target == 0){
            result.add(new ArrayList<>(list));
        }
        if(start >= candidates.length || candidates[start] > target){
            return;
        }
        for(int i = start; i< candidates.length; i++){
            list.add(candidates[i]);
            doCombinationSum(candidates, i, target-candidates[i], result, list);
            list.remove(list.size()-1);
        }
    }




}
