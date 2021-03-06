package leetcode.panda.chapter0697;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * <p>
 *  
 * *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(s.findShortestSubArray(nums));

    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Counter> counterMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Counter c = counterMap.getOrDefault(nums[i], new Counter(i));
            c.count(i);
            counterMap.putIfAbsent(nums[i], c);
        }
        int maxCount = 0;
        int minLength = Integer.MAX_VALUE;
        for (Counter value : counterMap.values()) {
            if (maxCount < value.count) {
                maxCount = value.count;
                minLength = value.length();
            } else if (maxCount == value.count) {
                minLength = Math.min(minLength, value.length());
            }
        }

        return minLength;
    }

    class Counter {
        int count;
        int start;
        int end;

        Counter(int st) {
            start = st;
            count = 0;
            end = st;
        }

        void count(int en) {
            count++;
            end = en;
        }

        int length() {
            return end - start + 1;
        }

    }


}