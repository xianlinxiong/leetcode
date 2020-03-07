package leetcode.panda.chapter0034;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,2,3};
        System.out.println(search(nums, 0));
    }

    /**
     * 折半查找优化：
     *  通过折半查找的方式找到目标元素在数组中的位置n；
     *  如果n不为-1，在0-n中查找起始位置，在n-length中查找结束位置
     * @param nums
     * @param target
     * @return
     */
    public static int[] search(int[] nums, int target) {
        int[] result = {-1, -1};
        if(null == nums){
            return result;
        }
        int begin = 0;
        int end = nums.length-1;
        int middle = (begin+end)/2;
        boolean finded = false;
        int n = -1;
        while(begin <= end && begin >= 0 && end < nums.length && !finded){
            if(nums[middle] == target){
                n = middle;
                finded = true;
            }
            else if(nums[middle] > target){
                end = middle -1;
            }
            else{
                begin = middle + 1;
            }
            middle = (begin + end) / 2;
        }
        if(n != -1){
            begin = 0;
            end = n;
            do{
                middle = (begin + end) / 2;
                if(nums[middle] == target){
                    result[0] = middle;
                    end = middle -1;
                }
                else{
                    begin = middle + 1;
                }
            }
            while (begin <= end && begin >=0);
            begin = n;
            end = nums.length -1;
            do{
                middle = (begin + end) /2 ;
                if(nums[middle] == target){
                    result[1] = middle;
                    begin = middle + 1;
                }
                else{
                    end = middle - 1;
                }
            }
            while(begin <= end && end < nums.length);
        }
        return result;

    }


}
