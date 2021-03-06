package leetcode.panda.chapter0896;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：[1,1,1]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};

    }

    public boolean isMonotonic(int[] A) {
        boolean res = true;
        int i = 1;
        while (i < A.length && A[i] == A[i - 1]) {
            i++;
        }
        if (i < A.length) {
            boolean up = A[i] - A[i - 1] > 0;
            for (; i < A.length & res; i++) {
                if (up && A[i] - A[i - 1] < 0) {
                    res = false;
                } else if (!up && A[i] - A[i - 1] > 0) {
                    res = false;
                }
            }
        }

        return res;
    }
}