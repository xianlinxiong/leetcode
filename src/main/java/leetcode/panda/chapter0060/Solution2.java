package leetcode.panda.chapter0060;

/**
 *给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 */
class Solution2 {

    /**
     * 解法：递归构造，
     *      考虑关联关系（n! = n *(n-1)!）
     * @param args
     */
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.getPermutation(3, 2));
    }


    /**
     * 优化点，可以使用list代替 boolean数组
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }
        int[] array = new int[n+1];
        for(int i =1; i<= n; i++){
            array[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        int left = 1;
        for(int i =2; i < n; i++){
            left *= i;
        }
        return sb.toString();
    }
}