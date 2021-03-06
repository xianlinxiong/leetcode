package leetcode.panda.chapter0089;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.grayCode(3));
    }

    /**
     * 旋转倒序：
     *  G(n+1) = G(n) + 【G(n)逆序+首位为1（2^n）】
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(n);
        result.add(0);
        if (n == 0) {
            return result;
        }
        result.add(1);
        if (n == 1) {
            return result;
        }
        int p = 1;
        for (int i = 1; i < n; i++) {
            p <<= 1;
            for(int j =p-1; j>=0; j--){
                result.add(result.get(j)+p);
            }
        }
        return result;
    }

}