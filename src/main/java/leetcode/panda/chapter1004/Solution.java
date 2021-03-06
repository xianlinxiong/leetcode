package leetcode.panda.chapter1004;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(s.longestOnes(nums, 3));
    }

    public int longestOnes(int[] A, int K) {
        int count = 0;
        int begin = 0, end = 0, k = 0;
        for (; end < A.length; end++) {
            if (A[end] == 1) {
                continue;
            }
            if (k == K) {
                count = Math.max(count, end - begin);
                while (A[begin] != -1 && begin < end) {
                    begin++;
                }
                if (A[begin] == -1) {
                    A[begin] = 0;
                    k--;
                }
                begin++;
            }
            if (k < K) {
                A[end] = -1;
                k++;
            }
        }

        count = Math.max(count, end - begin);
        return count;
    }

}