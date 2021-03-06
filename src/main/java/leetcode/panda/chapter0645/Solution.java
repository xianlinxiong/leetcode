package leetcode.panda.chapter0645;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,2};
        System.out.println(s.findErrorNums(nums
        ));
    }

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = (nums[i] - 1)%nums.length;
            if (nums[index] <= nums.length) {
                nums[index] += nums.length;
            } else {
                result[0] = index + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length) {
                nums[i] -= nums.length;
            } else {
                result[1] = i+1;
            }
        }

        return result;
    }
}