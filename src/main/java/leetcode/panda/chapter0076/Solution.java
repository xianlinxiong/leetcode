package leetcode.panda.chapter0076;

import java.util.*;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {1, 2, 0, 0};
        System.out.println(s.minWindow("sasd", "ABC"));

    }

    /**
     * 采用字符窗口的设计：从begin》end这个字符窗口中
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        //t中每个字符的个数
        Map<Character, Integer> targetCharCountMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer count = targetCharCountMap.getOrDefault(ch, 0);
            targetCharCountMap.put(ch, count + 1);
        }
        //窗口开始位置
        int begin = 0;
        //窗口结束位置
        int end = 0;
        //最小长度
        int minTotal = Integer.MAX_VALUE;
        //已经凑够数量的字符
        int formed = 0;
        //需要处理的字符个数
        int required = targetCharCountMap.size();
        //记录开始位置
        int left = 0;
        //记录结束位置
        int right = 0;
        Map<Character, Integer> windowCount = new HashMap<>();
        Set<Character> characterSet = targetCharCountMap.keySet();
        while (end < s.length()) {
            char ch = s.charAt(end);
            //如果ch属于t
            if (characterSet.contains(ch)) {
                int count = windowCount.getOrDefault(ch, 0);
                //统计ch在t中出现频次
                windowCount.put(ch, count + 1);
                //若窗口中ch的数量等于t中ch的数量，ch已经准备好
                if (windowCount.get(ch).equals(targetCharCountMap.get(ch))) {
                    formed++;
                }
                //窗口左位置小于右位置，并且所有的字符都已经集齐
                while (begin <= end && formed == required) {
                    ch = s.charAt(begin);
                    //判断当前是否是最短长度
                    if (minTotal > end - begin + 1) {
                        minTotal = end - begin + 1;
                        left = begin;
                        right = end;
                    }
                    //左移动，更新ch统计次数
                    if (characterSet.contains(ch)) {
                        count = windowCount.get(ch) - 1;
                        windowCount.put(ch, count);
                        if (targetCharCountMap.containsKey(ch) && count < targetCharCountMap.get(ch)) {
                            formed--;
                        }
                    }
                    begin++;
                }
            }
            end++;
        }
        return minTotal == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}