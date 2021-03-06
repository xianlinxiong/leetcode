package leetcode.panda.chapter0068;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */

class Solution2 {
    public static void main(String[] args) {

        Solution2 s = new Solution2();
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(s.fullJustify(words, 16));
    }


    /**
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (; j < words.length; ) {
            int lineLength = 0;
            while (j < words.length && lineLength + words[j].length() + j - i <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            String s = words[i];
            if (j == words.length) {
                for (int k = i + 1; k < j; k++) {
                    s += " " + words[k];
                }
                for (int m = s.length(); m < maxWidth; m++) {
                    s += " ";
                }
            } else {
                if (i == j - 1) {
                    for (int k = words[i].length(); k < maxWidth; k++) {
                        s += " ";
                    }
                } else {
                    int more = maxWidth - lineLength;
                    int blank = more / (j - i - 1);
                    int left = more % (j - 1 - i);
                    for (int k = i + 1; k < j; k++) {
                        for (int m = 0; m < blank; m++) {
                            s += " ";
                        }
                        if (left > 0) {
                            s += " ";
                            left--;
                        }
                        s += words[k];
                    }
                }
                i = j;
            }
            result.add(s);
        }


        return result;
    }
}