package leetcode.panda.chapter0034;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8};
        System.out.println(search(nums, 8));
    }

    /**
     * 折半查找优化：
     * 通过折半查找的方式找到目标元素在数组中的位置n；
     * 如果n不为-1，在0-n中查找起始位置，在n-length中查找结束位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] search(int[] nums, int target) {
        int[] result = {-1, -1};
        if (null == nums) {
            return result;
        }
        int index = Arrays.binarySearch(nums, target);
        if (index > -1) {
            result[1] = index;
            result[0] = index;
            do {
                result[0] = index;
                index = Arrays.binarySearch(nums, 0, index, target);
            } while (index > -1);
            index = result[1];
            do {
                index = Arrays.binarySearch(nums, index + 1, nums.length, target);
                if(index > -1){
                    result[1] = index;
                }
            } while (index <= nums.length - 1 && index > -1);
        }
        return result;

    }


}
