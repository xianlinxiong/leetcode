package leetcode.panda.chapter0077;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.combine(13,13));

    }

    /**
     * 组合公式 C(m,n) = C(m, m-n) = C(m-1,n)+C(m-1,n-1)
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        //C(n, k-1),在每个元素后面添加n
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        //C(n-1,k)
        result.addAll(combine(n - 1, k));
        return result;

    }
}