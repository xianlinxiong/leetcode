package leetcode.panda.chapter0029;

/**
 * 进阶:倍数递归
 *
 */
public class Solution {
    public static void main(String[] args) {

//        System.out.println(strStr("hello", "hello"));
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        int sign = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long result = doDevide(ldividend, ldivisor);

        if (result > Integer.MAX_VALUE) {
            if (sign == 1) {
                result = Integer.MAX_VALUE;
            } else {
                result = Integer.MIN_VALUE;
            }
        } else {
            if (sign == - 1) {
                result = -result;
            }
        }
        return (int) result;
    }

    private static long doDevide(long dividen, long divisor){
        if(dividen < divisor){
            return 0;
        }
        long cur = divisor;
        long result = 1;
        while(dividen >= cur +cur){
            cur += cur;
            result += result;
        }

        return result + doDevide(dividen - cur, divisor);

    }

}
