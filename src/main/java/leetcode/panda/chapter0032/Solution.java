package leetcode.panda.chapter0032;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 */
public class Solution {
    public static void main(String[] args) {
        String ss = "()(())";
        System.out.println(longestValidParentheses(ss));
    }

    /**
     *
     * 从每个节点往后：累计当前左括号的剩余量count，括号匹配次数k，左括号+1，右括号-1，当count为0时cur= 2*k
     *
     * 优化，考虑 动态规划
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if(null == s){
            return 0;
        }
        int length = s.length();
        int max = 0;
        int cur = 0;
        int count = 0;
        int k = 0;

        for(int i = 0; i < length; i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                continue;
            }
            cur = 0;
            count = 1;
            k = 0;
            for(int j = i+1; j < length; j++){
                char next = s.charAt(j);
                if('(' == next){
                    if(count == 0 && cur > max){
                        max = cur;
                    }
                    count++;
                }
                else{
                    if(count > 0){
                        count--;
                        k++;
                        if(count == 0) {
                            cur += 2 * k;
                            k = 0;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            if(max < cur){
                max = cur;
            }
        }
        return max;
    }
}
