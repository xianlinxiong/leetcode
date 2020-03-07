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
class Solution {

    /**
     * 解法：递归构造，
     *      考虑关联关系（n! = n *(n-1)!）
     * @param args
     */
    public static void main(String[] args) {
        Solution s = new Solution();

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

        StringBuilder sb = new StringBuilder();
        int[] permutation = new int[n + 1];
        permutation[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            permutation[i] = i * permutation[i - 1];
        }
        //全排列输出
        if (permutation[n] == k) {
            for (int i = n; i > 0; i--) {
                sb.append(i);
            }
            return sb.toString();
        }
        boolean[] chosen = new boolean[n];
        int end = n - 1;
        while (k > 0) {
            //如果permutation[end] > k， 选取最小的一个未选择元素
            while (permutation[end] > k) {
                end--;
                int i = 0;
                while (chosen[i]) {
                    i++;
                }
                chosen[i] = true;
                sb.append(i + 1);
            }
            //计算属于第几个子排列
            int count = k / permutation[end];
            k = k % permutation[end];
            if(k !=0){
                //剩余不为0时，自排列数+1
                count++;
            }
            int next = 0;
            //查找第count 个未筛选元素
            for (int i = 0; i < n && count >0; i++) {
                if (!chosen[i]) {
                    next = i;
                    count--;
                }
            }
            sb.append(next + 1);
            chosen[next] = true;
            end--;
        }
        //x!，倒序排列剩余元素
        for(int i =n-1; i >=0; i--){
            if(!chosen[i]){
                sb.append(i+1);
            }
        }
        return sb.toString();
    }
}