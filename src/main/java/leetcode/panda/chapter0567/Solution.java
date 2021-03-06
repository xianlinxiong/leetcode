package leetcode.panda.chapter0567;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("ab",
                "eidboaoo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        for (; right < s2.length(); right++) {
            if (cnt[s2.charAt(right) - 'a'] > 0) {
                cnt[s2.charAt(right) - 'a']--;
                if (right - left + 1 == s1.length()) {
                    return true;
                }
            } else {
                while (left < right && s2.charAt(left)!=s2.charAt(right)) {
                    cnt[s2.charAt(left++) - 'a']++;
                }
                left++;
            }
        }

        return right < s2.length() && right - left + 1 == s1.length();

    }
}