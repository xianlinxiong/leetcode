package leetcode.panda.chapter1624;

import leetcode.panda.UnionSearchSet;

/**
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * 示例 3：
 * <p>
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * 示例 4：
 * <p>
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 25, 35, 42, 68, 70};
        System.out.println(s.maxLengthBetweenEqualCharacters("cbzxy"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] cnt = new int[26][2];
        for (int j = 0; j < 26; j++) {
            cnt[j][0] = -1;
            cnt[j][1]=-1;
        }
        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (cnt[ind][0] == -1) {
                cnt[ind][0] = i;
            } else {
                cnt[ind][1] = i;
            }
        }
        int max = 0;
        for (int[] ints : cnt) {
            max = Math.max(max, ints[1]-ints[0]);
        }
        return max-1;
    }
}