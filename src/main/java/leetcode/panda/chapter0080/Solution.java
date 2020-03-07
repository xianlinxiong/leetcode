package leetcode.panda.chapter0080;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(s.removeDuplicates(nums));
    }

    /**
     * 双标记法， 满足条件的位置是cur，向后跑的是i
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int cur = 1;
        int count = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                count++;
                if (count <= 2) {
                    nums[cur] = nums[i];
                    cur++;
                }
            } else {
                last = nums[i];
                count = 1;
                nums[cur] = nums[i];
                cur++;
            }
        }
        return cur;
    }

}