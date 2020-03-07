package leetcode.panda.chapter0072;

/**
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.minDistance("intention", "execution"));
    }

    /**
     * 动态规划问题：
     *  f(i,j)---- 若word1[i] == word2[j], 则=f(i-1,j-1)
     *        ---- 否则，min(f(i-1, j), f(i, j-1),f(i-1,j-1) + 1
     *              f(i-1, j) 代表插入元素
     *              f(i,j-1)  代表删除元素
     *              f(i-1,j-1) 代表替换元素
     *
     *  f(0,k) = f(k,0) = k;
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (null == word1 || word1.length() == 0) {
            return word2.length();
        }
        if (null == word2 || word2.length() == 0) {
            return word1.length();
        }
        int length1 = word1.length() + 1;
        int length2 = word2.length() + 1;

        int[][] distance = new int[length2][length1];
        for (int i = 0; i < length1; i++) {
            distance[0][i] = i;
        }
        for (int i = 1; i < length2; i++) {
            distance[i][0] = i;
        }
        for (int i = 1; i < length2; i++) {
            for (int j = 1; j < length1; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j - 1], distance[i - 1][j]), distance[i][j - 1]) + 1;
                }
            }
        }
        return distance[length2 - 1][length1 - 1];
    }
}