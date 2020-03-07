package leetcode.panda.chapter0069;

/**
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.mySqrt2(2147395600));
    }


    /**
     * 循环累加相乘， 出口;相等， 大于，积为负数
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int i = 0;
        for (; ; i++) {
            int t = i*i;
            if (t == x) {
                return i;
            } else if (t > x || t< 0) {
                return i-1;
            }
        }

    }

    /**
     *折半处理方式
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int left =0;
        int right = x;
        while(left <= right){
            int midle = (left+right)/2;
            int t = x/midle;
            if(t == midle){
                return midle;
            }
            else if(t < midle){
                right = midle-1;
            }
            else{
                left = midle+1;
            }
        }
        return right;
    }
}