package leetcode.panda.chapter0115;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "rabbbit", T = "rabbit"
 * 输出：3
 * 解释：
 *
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 *
 * 输入：S = "babgbag", T = "bag"
 * 输出：5
 * 解释：
 *
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numDistinct("babgbag", "bag"));
    }


    public int numDistinct2(String S, String T) {
        int n = S.length();
        int m = T.length();
        int[][] dp = new int[n + 1][m + 1];

        //初始化，如果S是空串，但是T不是空串，那么出现次数为0
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        //初始化，如果S不是空串，但是T是空串，出现次数为1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //初始值就是不想等的情况
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    public int numDistinct1(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }

    public int numDistinct(String s, String t) {
        if(s == null || s.length() ==0 || t == null || t.length() == 0){
            return 0;
        }
        int[][] dis = new int[t.length()+1][s.length()+1];
        for(int i = 0; i < s.length()+1; i++){
            dis[0][i] = 1;
        }
        dis[0][s.length()] = dis[0][s.length()-1];
        for(int i = 1; i < t.length()+1; i++){
            for(int j = 1; j < s.length()+1; j++){
                dis[i][j] = dis[i][j-1];
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dis[i][j] += dis[i-1][j-1];
                }
            }
        }

        return dis[t.length()][s.length()];
    }
}