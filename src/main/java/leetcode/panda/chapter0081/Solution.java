package leetcode.panda.chapter0081;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {3,1,1};
        System.out.println(s.search(nums, 3));
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return true;
            } else if (nums[middle] > nums[start]) { //start 》》 middle 升序
                if(target >= nums[start] && target < nums[middle]){
                    end = middle-1;
                }else{
                    start = middle+1;
                }

            }else if(nums[middle] < nums[start]){   //middle >> start 升序
                if(target >nums[middle] && target < nums[start]){
                    start = middle+1;
                }
                else{
                    end = middle-1;
                }
            }else{  //start = middle, start++;
                start++;
            }
        }

        return false;
    }

}