package leetcode.panda.chapter0058;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 */
class Solution {
    /**
     * 贪心算法，从最后开始找到非空字符，开始计数，知道再次找到空字符或者到达串首位置
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int length = s.length()-1;
        int count = 0;
        while(length >=0  &&s.charAt(length)==' '){
            length--;
        }
        while(length >= 0 && s.charAt(length) != ' '){
            count++;
            length--;
        }

        return count;

    }

}