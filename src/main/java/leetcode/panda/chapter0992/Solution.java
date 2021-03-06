package leetcode.panda.chapter0992;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * <p>
 * 返回 A 中好子数组的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,1,2,3};
        System.out.println(s.subarraysWithKDistinct(nums, 2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int count = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int begin = 0;
        for (int end = 0; end < A.length; end++) {
            int cnt = cntMap.getOrDefault(A[end], 0);
            cntMap.put(A[end], cnt + 1);
            if (cntMap.size() == K) {
                count++;
            }
            while (cntMap.size() > K) {
                count++;
                cnt = cntMap.get(A[begin]);
                if (cnt == 1) {
                    cntMap.remove(A[begin]);
                } else {
                    cntMap.put(A[begin++], cnt - 1);
                }
            }
        }
        return count;
    }

}