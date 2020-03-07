package leetcode.panda.chapter0044;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 */
public class Solution {
    public static void main(String[] args) {
        String num1 =
                "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        String num2 =
                "*bba*a*bbba*aab*b";
        System.out.println(isMatch(num1, num2));
    }

    /**
     * 动态规划问题：
     * dp[i][j]: s串中前i个元素和p串中前j个元素匹配情况
     * dp[0][0] = true 》》第0个元素和第0个元素匹配
     * dp[i][0]= = false 》》p串中取0个元素时，必然为false
     * dp[0][j]=true 当前仅当p的前j个元素为*时
     * dp[i][j] == dp[i-1][j-1] -----当s[i-1] == p[j-1] 或者p[j-1]='?'
     * dp[i-1][j] || dp[i][j-1] ------当p[j-1] ='*'
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];

        // Base cases:
        dp[0][0] = true;
        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if ((s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[sLen][pLen];
    }


    public static boolean isMatch2(String s, String p) {
        int[] nextP = next(p);
        return doMatch(s, 0, p, 0, nextP);
    }


    /**
     * 递归寻找：
     * 模式串和匹配串同时向后偏移
     * 根据模式串的三种类型做不同处理：
     * ？ 两者同时往后偏移1
     * *  前者偏移1或者后者偏移1
     * 其他 比较是否相等
     *
     * @param s
     * @param sStart
     * @param p
     * @param pStart
     * @return
     */
    static boolean doMatch(String s, int sStart, String p, int pStart, int[] nextP) {
        System.out.println("s start ：" + sStart);
        if (sStart == s.length()) {
            return check(p, pStart);
        }
        if (pStart == p.length()) {
            return false;
        }

        if ('?' == p.charAt(pStart)) {
            return doMatch(s, sStart + 1, p, nextP[pStart], nextP);
        } else if ('*' == p.charAt(pStart)) {
            while (sStart < s.length()) {
                boolean result = doMatch(s, sStart, p, nextP[pStart], nextP);
                if (result) {
                    return true;
                }
                result = doMatch(s, sStart + 1, p, pStart, nextP);
                if (result) {
                    return true;
                }
                sStart++;
            }
        } else if (s.charAt(sStart) == p.charAt(pStart)) {
            return doMatch(s, sStart + 1, p, nextP[pStart], nextP);
        }

        return false;
    }

    /**
     * 判断模式串是否只剩*
     *
     * @param s
     * @param start
     * @return
     */
    private static boolean check(String s, int start) {
        int end = s.length() - 1;
        while (end > 0 && s.charAt(end) == '*') {
            end--;
        }
        return end <= start && s.charAt(start) == '*';
    }


    private static int[] next(String p) {
        if (p.length() == 0) {
            return new int[0];
        }
        int[] next = new int[p.length()];
        next[p.length() - 1] = p.length();
        int k = p.length() - 1;
        for (int i = p.length() - 2; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                next[i] = k;
            } else {
                next[i] = i + 1;
                k = i;
            }
        }

        return next;
    }
}
