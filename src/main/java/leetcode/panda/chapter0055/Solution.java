package leetcode.panda.chapter0055;

/**
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(jump(nums));
    }


    /**
     * 贪心算法：每一步向后挑最大位置，当用户下一步超出范畴时，能到达最后，如果某一步原地踏步，则不能到达最后
     *
     * @param nums
     * @return
     */
    public static boolean jump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int pre = 0;
        int next = nums[0];
        while (next < nums.length - 1) {
            int max = next;
            for (int i = pre; i <= next; i++) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                }
            }
            pre = next;
            next = max;
            if (pre == next) {
                break;
            }
        }
        return next >= nums.length - 1;
    }


}
