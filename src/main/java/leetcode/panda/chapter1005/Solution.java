package leetcode.panda.chapter1005;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * <p>
 * 以这种方式修改数组后，返回数组可能的最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * <p>
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * <p>
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, -3, -1, 5, -4};
        System.out.println(s.largestSumAfterKNegations(nums, 2));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (; i < A.length && K > 0 && A[i] <= 0; i++) {
            A[i] = -A[i];
            min = A[i];
            K--;
        }
        if (min > A[i]) {
            min = A[i];
        }
        if (K % 2 == 1) {
            min *= -2;
        } else {
            min = 0;
        }
        return Arrays.stream(A).sum() + min;
    }

}