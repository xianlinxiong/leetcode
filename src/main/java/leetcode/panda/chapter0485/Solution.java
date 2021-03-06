package leetcode.panda.chapter0485;

import java.util.Arrays;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {1,0,1,1,0,1};
        System.out.println(s.findMaxConsecutiveOnes(arr1));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            left = right;
            while (right < nums.length && nums[right] == 1) {
                right++;
            }
            if(left != nums.length) {
                count = Math.max(count, right - left);
            }
        }

        return count;

    }

}