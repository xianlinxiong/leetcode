package leetcode.panda.chapter0125;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "0P";
        System.out.println(Character.isAlphabetic('A'));
        System.out.println(s.isPalindrome(ss));


    }
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            while(start < end && !judge(s.charAt(start))){
                start++;
            }
            while(start < end && !judge(s.charAt(end))){
                end--;
            }
            if(start < end) {
                char chStart = Character.toLowerCase(s.charAt(start));
                char chEnd = Character.toLowerCase(s.charAt(end));
                if (chEnd != chStart) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }
    private boolean judge(char ch){
        return Character.isDigit(ch) || Character.isAlphabetic(ch);
    }
}