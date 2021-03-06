package leetcode.panda.chapter0035;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 *
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] array ={1,3,5,6};
        System.out.println(searchInsert(array, 2));
    }

    /**
     * 折半查找优化：
     *  通过折半查找的方式找到目标元素在数组中的位置n；
     *  如果n存在，返回n
     *  如果n不存在，如果begin或end值小于0，返回0，否则比较middle对应元素与target的位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        int begin = 0;
        int end = nums.length - 1;
        int middle = (begin + end) / 2;
        while(begin<=end && nums[middle] != target){
            if(nums[middle] < target){
                begin = middle+1;
            }else{
                end = middle-1;
            }
            middle = (begin + end) / 2;
        }
        if(nums[middle] < target){
            middle++;
        }

        return middle;
    }

}
