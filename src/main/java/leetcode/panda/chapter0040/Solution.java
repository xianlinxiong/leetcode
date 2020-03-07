package leetcode.panda.chapter0040;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] candidate = {10,1,2,7,6,1,5};
        int target = 8;
        List result = combinationSum2(candidate, target);
        System.out.println(result);
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<String> result = getResult(candidates, 0, target,"");
        return result.stream()
                .map(s -> s.substring(1))
                .map(s -> Arrays.asList(s.split(",")))
                .map(list -> list.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

    }

    private static Set<String> getResult(int[] sorted, int start, int target, String prefix){
        Set<String> results = new HashSet<>();
        if(target == 0){
            results.add(prefix);
            return results;
        }
        if(start >= sorted.length || sorted[start] > target){
            return Collections.emptySet();
        }
        results.addAll(getResult(sorted,start+1, target, prefix));

        target -= sorted[start];
        results.addAll(getResult(sorted, start+1, target,prefix+","+sorted[start]));

        return results;
    }


}
