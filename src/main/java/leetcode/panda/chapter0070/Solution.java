package leetcode.panda.chapter0070;

/**
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.climbStairs(10));
    }


    /**
     * 斐波那契数列：要达到第n位置只有两种方式，第n-1步迈一步，第n-2步迈两步
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n ==1 || n == 2){
            return n;
        }
        int[] result = new int[n];
        result[0]=1;
        result[1] = 2;
        for(int i = 2; i<n;i++){
            result[i]= result[i-1] + result[i-2];
        }
        return result[n-1];
    }

    /**
     * 斐波那契数列 递归实现
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public int climbStairs3(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int first =1;
        int second =2;
        for (int i = 2; i<=n;i++){
            int temp = second;
            second += first;
            first = temp;
        }
        return second;
    }
}