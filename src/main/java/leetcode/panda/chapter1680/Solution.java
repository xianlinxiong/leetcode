package leetcode.panda.chapter1680;

/**
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 示例 3：
 * <p>
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 109 + 7 取余后，结果为 505379714 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 25, 35, 42, 68, 70};
        System.out.println(s.concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        int k = 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                k++;
            }
            result = ((result << k) + i) % mod;
        }

        return (int)result;

    }
}