package leetcode.panda.chapter0978;

import java.util.Arrays;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(s.maxTurbulenceSize(nums));
    }

    public int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int up = 0;
        for (int begin = 0, end = 1; end < arr.length; end++) {
            if (arr[end] == arr[end - 1]) {
                begin = end;
                up = 0;
            } else if (arr[end] > arr[end - 1]) {
                if (up == 1) {
                    begin = end - 1;
                    up = 1;
                } else {
                    up = 1;
                }
            } else {
                if (up == -1) {
                    begin = end - 1;
                    up = -1;
                } else {
                    up = -1;
                }
            }
            max = Math.max(max, end - begin + 1);
        }

        return max;
    }

}