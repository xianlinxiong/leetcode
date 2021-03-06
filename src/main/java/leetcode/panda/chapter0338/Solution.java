package leetcode.panda.chapter0338;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 5, 10};

        System.out.println(s.countBits2(8));
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }

        return res;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        if (num > 0) {
            res[1] = 1;
        }
        int i = 2;
        int end = 1;
        for (int j = 2; j <= num; j++) {
            i = 0;
            while (j <= num && i <= end) {
                res[j++] = res[i++] + 1;
            }
            end = j-1;
            j--;
        }

        return res;
    }


}