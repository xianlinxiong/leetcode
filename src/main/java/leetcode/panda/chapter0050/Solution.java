package leetcode.panda.chapter0050;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 */
class Solution {
    public static void main(String[] args) {
        double d = 2.000000;
        int i =
                -2147483648;

        System.out.println(myPow(d, i));
    }

    /**
     * 折半法
     * @param x
     * @param n
     * @return
     */

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = 1 / x;
            n = Integer.MAX_VALUE;
            x = x < 0 ? -x : x;
        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x * x, n / 2);
    }
}