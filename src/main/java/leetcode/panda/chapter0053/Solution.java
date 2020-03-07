package leetcode.panda.chapter0053;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(nums));

        System.out.println(maxSubArrayNew(nums));
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (max < temp) {
                max = temp;
            }
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }

    public static int maxSubArrayNew(int[] nums) {

        return doDevide(nums, 0, nums.length-1);
    }

    public static int doDevide(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int middle = (start + end) /2;
        int left = doDevide(nums, start, middle);
        int right = doDevide(nums, middle+1, end);
        int max = Math.max(left, right);

        return Math.max(max,leftMax(nums, start, middle)+rightMax(nums, middle+1,end));
    }

    private static int leftMax(int[] nums, int start, int end){
        int temp = 0;
        int max = 0;
        while(end > start){
            temp += nums[end];
            if(temp > max){
                max = temp;
            }
            end--;
        }

        return max;
    }

    private static int rightMax(int[] nums, int start, int end){
        int temp = 0;
        int max = 0;
        while(end > start){
            temp += nums[start];
            if(temp > max){
                max = temp;
            }
            start++;
        }

        return max;
    }
}