package leetcode.panda.chapter0205;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg","add"));
    }


    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        int i = 0;
        for (; i < s.length(); i++) {
            if(!map1.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))){
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }else if(!map1.containsKey(s.charAt(i)) || !map2.containsKey(t.charAt(i)) || map1.get(s.charAt(i))!=t.charAt(i)){
                break;
            }

        }
        return i == s.length();
    }
}