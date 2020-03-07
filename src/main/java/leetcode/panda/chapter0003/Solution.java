package leetcode.panda.chapter0003;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
class Solution {
    //运用set保存无重复的字符，max记录最大值，cur记录当前最大值，begin记录起始位置
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        int cur = 0;
        int begin = 0;

        Set<Character> set = new HashSet<>();
        //循环判断，不存在set中，添加；存在后判断当前大小，并将begin位置移动到与当前字符等字符后面
        for(int i = 0; i< length; i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                cur++;
                set.add(ch);
            }
            else{
                if(cur > max){
                    max = cur;
                }
                while(s.charAt(begin) != ch){
                    set.remove(s.charAt(begin));
                    begin++;
                    cur--;
                }
                begin++;
            }
        }
        if(max < cur){
            max = cur;
        }
        return max;

    }
}