package leetcode.panda.chapter0231;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};

    }

    public boolean isPowerOfTwo(int n) {
        int k=1;
        int i = 0;
        do{
            if(k ==n){
                return true;
            }
            k <<=1;
            i++;
        }while(i<32);

        return false;
    }
}