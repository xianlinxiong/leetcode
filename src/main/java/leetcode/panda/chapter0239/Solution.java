package leetcode.panda.chapter0239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(s.maxSlidingWindow(nums, 3));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();

        int i = 0;
        for (; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.pollLast();
            }
            queue.add(i);
        }

        for (int j = 0; i < nums.length; i++) {
            result[j++] = nums[queue.getFirst()];
            if (i - queue.getFirst() == k) {
                queue.pop();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.pollLast();
            }
            queue.add(i);
        }
        result[result.length -1] = nums[queue.getFirst()];
        return result;

    }
}