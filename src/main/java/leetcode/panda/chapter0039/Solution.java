package leetcode.panda.chapter0039;

import java.lang.reflect.Array;
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
public class Solution {
    public static void main(String[] args) {
       int[] candidate = {2,3,6,7};
       int target = 7;
       List result = combinationSum(candidate, target);
        System.out.println(result);
    }


    /**
     * 排序递归寻找
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<String> result = getResult(candidates, 0, target,"");
        return result.stream()
                .map(s -> s.substring(1))
                .map(s -> Arrays.asList(s.split(",")))
                .map(list -> list.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

    }

    private static List<String> getResult(int[] sorted, int start, int target, String prefix){
        List<String> results = new ArrayList<>();
        if(target == 0){
            results.add(prefix);
            return results;
        }
        if(start >= sorted.length || sorted[start] > target){
            return Collections.emptyList();
        }
        results.addAll(getResult(sorted,start+1, target, prefix));
        while(target > 0 ){
            prefix += "," +sorted[start];
            target -= sorted[start];
            results.addAll(getResult(sorted, start+1, target,prefix));
        }

        return results;
    }


}
