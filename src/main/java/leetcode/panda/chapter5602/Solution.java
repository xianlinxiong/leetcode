package leetcode.panda.chapter5602;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
        int[] arr2 = {1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136};
//        System.out.println(s.minOperations(arr2, 894887480));
        System.out.println(s.minOperations(arr1, 134365));
        System.out.println(s.minOperations3(arr1, 134365));

    }

    public int minOperations(int[] nums, int x) {

        return doMiniOperation(nums, 0, nums.length-1, x);
    }

    public int minOperations3(int[] nums, int x) {
        int i= 0;
        int j = 0;
        int sum = nums[0];
        for(int k = 1; k< nums.length; k++){
            sum += nums[k];
        }
        x = sum -x;
        if(x == 0){
            return nums.length;
        }
        int max = -1;
        sum = 0;
        for(;j <nums.length;j++){
            sum += nums[j];
            while(i<=j && sum > x){
                sum -= nums[i++];
            }
            if(sum == x){
                max = Math.max(max, j-i+1);
                sum -= nums[i];
                i++;
            }
        }


        return nums.length-max;
    }

    //动态规划
    public int minOperations2(int[] nums, int x){
        int[][] sum = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum[i][j] = sum[i][j - 1] + nums[j];
            }
        }
        int left = sum[0][nums.length - 1] - x;
        if(left ==0 ){
            return nums.length;
        }
        int count = nums.length - 1;
        while (count >= 0) {
            for (int j = nums.length - 1; j >= count; j--) {
                if (sum[j-count][j] == left) {
                    return nums.length - 1 - count;
                }
            }
            count--;
        }
        return -1;
    }


    private int doMiniOperation(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start] == target ? 1 : -1;
        }
        if (nums[start] == target || nums[end] == target) {
            return 1;
        }
        int left = doMiniOperation(nums, start + 1, end, target - nums[start]);
        int right = doMiniOperation(nums, start, end - 1, target - nums[end]);
        if (left == -1) {
            return right == -1 ? -1 : right + 1;
        }
        return right == -1 ? left + 1 : Math.min(left, right) + 1;
    }
}