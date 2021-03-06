package leetcode.panda.chapter1749;

/**
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * abs(x) 定义如下：
 * <p>
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,-5,1,-4,3,-2};
        System.out.println(s.maxAbsoluteSum(nums));
    }

    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int begin = 0, end = 0; end < nums.length; end++) {
            cur += nums[end];
            while (begin <= end && cur < 0) {
                cur -= nums[begin++];
            }
            max = Math.max(max, cur);
        }

        int min = Integer.MAX_VALUE;
        cur = 0;
        for (int begin = 0, end = 0; end < nums.length; end++) {
            cur += nums[end];
            while (begin <= end && cur > 0) {
                cur -= nums[begin++];
            }
            min = Math.min(min, cur);
        }
        return Math.max(max, -min);
    }
}