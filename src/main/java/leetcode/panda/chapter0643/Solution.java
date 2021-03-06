package leetcode.panda.chapter0643;

import java.util.Arrays;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

    }

    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        double sum = max;
        for(int i = k; i< nums.length; i++){
            sum += nums[i]-nums[i-k];
            if(sum > max){
                max = sum;
            }
        }

        return max / k;

    }
}