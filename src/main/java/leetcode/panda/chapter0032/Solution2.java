package leetcode.panda.chapter0032;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Solution2 {
    public static void main(String[] args) {
        String ss = "())";
        System.out.println(longestValidParentheses(ss));
    }

    /**
     * 从每个节点往后：累计当前左括号的剩余量count，括号匹配次数k，左括号+1，右括号-1，当count为0时cur= 2*k
     * <p>
     * 优化，考虑 动态规划
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (null == s) {
            return 0;
        }
        int max = 0;
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                if (stack.size() == 1) {
                    stack.pop();
                    stack.push(0);
                } else {
                    cur = stack.pop() + 1;
                    int k = stack.pop() + cur;
                    stack.push(k);
                    max = Math.max(max, k * 2);
                }
            }
        }


        return max;
    }
}
