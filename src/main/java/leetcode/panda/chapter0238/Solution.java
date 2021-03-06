package leetcode.panda.chapter0238;

/**
 *`给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};

    }
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int p =1;
        for(int i =1;i<nums.length;i++){
            result[i] = p;
            p *= nums[i];
        }
        p=1;
        for(int i = nums.length-1; i>=0; i--){
            result[i] *= p;
            p*=nums[i];
        }

        return result;
    }
}