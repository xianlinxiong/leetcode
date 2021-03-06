package leetcode.panda.chapter0448;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {2, 2};
        System.out.println(s.findDisappearedNumbers(arr1));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            int x = num % n;
            nums[x] += n;
        }
        if (n > 0 &&nums[0] < n) {
            result.add(n);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= n) {
                result.add(i);
            }
        }

        return result;
    }


}