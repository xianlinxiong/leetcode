package leetcode.panda.chapter0955;

/**
 * 给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。
 * <p>
 * 假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["ca","bb","ac"]
 * 输出：1
 * 解释：
 * 删除第一列后，strs = ["a", "b", "c"]。
 * 现在 strs 中元素是按字典排列的 (即，strs[0] <= strs[1] <= strs[2])。
 * 我们至少需要进行 1 次删除，因为最初 strs 不是按字典序排列的，所以答案是 1。
 * 示例 2：
 * <p>
 * 输入：strs = ["xc","yb","za"]
 * 输出：0
 * 解释：
 * strs 的列已经是按字典序排列了，所以我们不需要删除任何东西。
 * 注意 strs 的行不需要按字典序排列。
 * 也就是说，strs[0][0] <= strs[0][1] <= ... 不一定成立。
 * 示例 3：
 * <p>
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：
 * 我们必须删掉每一列。
 *  
 * <p>
 * 提示：
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 100
 * strs[i] 由小写英文字母组成
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-5, -2};
        String[] ss = {"zyx","wvu","tsr"};
        System.out.println(s.minDeletionSize(ss));
    }

    public int minDeletionSize(String[] strs) {
        if (strs.length == 1) {
            return 0;
        }
        int cnt = 0;
        int len = strs[0].length();
        boolean needNext = true;
        for (int i = 0; i < len; i++) {
            int i1 = 1;
            int c = 0;
            for (; i1 < strs.length && needNext; i1++) {
                if (strs[i1].charAt(i) < strs[i1 - 1].charAt(i)) {
                    cnt++;
                    break;
                } else if (strs[i1].charAt(i) == strs[i1 - 1].charAt(i)) {
                    c++;
                }
            }
            needNext = i1 < strs.length || c > 0;
        }

        return cnt;
    }
}