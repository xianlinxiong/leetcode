package leetcode.panda.chapter0842;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * <p>
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * <p>
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * <p>
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * <p>
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(s.isValid("123456579", 0, 2));
        System.out.println(s.splitIntoFibonacci("1101111"));

    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        long first = 0L;
        long second = 0L;
        for (int i = 0; i < S.length() && i <= 10; i++) {
            if (!isValid(S, 0, i + 1)) {
                continue;
            }
            for (int j = i + 1; j < S.length() && j - i <= 10; j++) {
                if (!isValid(S, i + 1, j + 1)) {
                    continue;
                }
                first = Long.parseLong(S.substring(0, i + 1));
                second = Long.parseLong(S.substring(i + 1, j + 1));
                result.add((int) first);
                result.add((int) second);
                int k = j + 1;
                boolean broken = false;
                do {
                    long tmp = first + second;
                    if (tmp > Integer.MAX_VALUE) {
                        broken = true;
                        break;
                    }
                    int length = length(tmp);
                    if (k + length > S.length() || tmp != Long.parseLong(S.substring(k, k + length))) {
                        broken = true;
                        break;
                    }
                    k += length;
                    result.add((int) tmp);
                    first = second;
                    second = tmp;

                } while (k != S.length());

                if (!broken) {
                    return result;
                }
                result.clear();
            }
        }

        return result;
    }

    private boolean isValid(String s, int start, int end) {
        long value = Long.parseLong(s.substring(start, end));
        if (value > Integer.MAX_VALUE) {
            return false;
        }
        return (end - start == 1) || (value >= Math.pow(10, end - start - 1));
    }

    private int length(long key) {
        int count = 0;
        do {
            count++;
            key /= 10;
        } while (key > 0);
        return count;
    }
}