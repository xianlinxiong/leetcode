package leetcode.panda.chapter0049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 两个考虑方式：排序之后map；统计串的各自字符数目匹配（进阶优化：用int[26]代替map）
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Object, List<String>> result = new HashMap<>();
        for(String s : strs){
            Map<Character, Integer> map = getCharMap(s);
            List<String> list = result.getOrDefault(map, new ArrayList<>());
            list.add(s);
            result.put(map, list);
        }
        return new ArrayList<>(result.values());
    }


    private static Map<Character, Integer> getCharMap(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(int i =0; i< s.length(); i++){
            char ch = s.charAt(i);
            int current = map.getOrDefault(ch, 0);
            map.put(ch, current+1);
        }

        return map;
    }
}