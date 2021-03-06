package leetcode.panda.chapter0738;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * <p>
 *  
 * *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 4, 5};
        System.out.println(s.monotoneIncreasingDigits(120));

    }

    public int monotoneIncreasingDigits(int N) {
        int bits[] = new int[9];
        int i = 0;
        while (N > 0) {
            bits[i] = N % 10;
            N = N / 10;
            i++;
        }
        i--;
        int j = i;
        for (; j > 0; j--) {
            if (bits[j] > bits[j - 1]) {
                break;
            }
        }
        if (j > 0) {
            for (int k = 0; k < j; k++) {
                bits[k] = 9;
            }
            bits[j]--;
            while (j < i) {
                if (bits[j] == 0 || bits[j] < bits[j + 1]) {
                    bits[j] = 9;
                    j++;
                    bits[j]--;
                }else{
                    break;
                }
            }
        }
        int result = 0;
        for (j = i; j >= 0; j--) {
            result = result * 10 + bits[j];
        }

        return result;
    }
}