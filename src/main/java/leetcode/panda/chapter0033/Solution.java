package leetcode.panda.chapter0033;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(search(nums, 3));
    }

    /**
     * 折半查找优化：
     *  开始标记begin、结束标记end、中间标记middle
     *  middle = (begin + end)/2
     *  分情况讨论
     *      nums[middle] == target: return
     *      nums[middle] > target:
     *          判断nums[end] >= nums[middle]: middle-end升序，必然在前置数组中，end = middle -1
     *          判断nums[end] < target; begin-middle 升序，必然在前置数组中， end = middle -1;
     *          否则在后置数组中，begin = middle +1
     *      nums[middle] < target:
     *          判断nums[middle] > nums[begin]: begin-middle升序，必然在后置数组中，begin = middle +1
     *          判断nums[end] >= target; begin-middle 升序，必然在前置数组中， begin = middle +1;
     *          否则在前置数组中，end = middle -1
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if(null == nums){
            return -1;
        }
        int begin = 0;
        int end = nums.length-1;
        int middle = (begin+end)/2;
        while(begin <= end && begin >= 0 && end < nums.length){
            if(nums[middle] == target){
                return middle;
            }
            else if(nums[middle] > target){
                if(nums[end] >= nums[middle]){
                    end = middle - 1;
                }
                else{
                    if(nums[end] < target){
                        end = middle - 1;
                    }
                    else {
                        begin = middle + 1;
                    }
                }
            }
            else{
                if(nums[middle] >= nums[begin]){
                    begin = middle + 1;
                }
                else{
                    if(nums[end] >= target){
                        begin = middle +1;
                    }
                    else{
                        end = middle -1 ;
                    }
                }
            }
            middle = (begin + end) / 2;
        }
        return -1;

    }


}
