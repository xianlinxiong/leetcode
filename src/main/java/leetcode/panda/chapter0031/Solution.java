package leetcode.panda.chapter0031;

import java.util.Arrays;

/**
 * 进阶: 标记寻找法，从末端开始比较，当前元素小于后一元素时，将当前元素与最接近自己的元素相交换后排序即可
 */
public class Solution {
    public static void main(String[] args) {
        int[] ttt = {1, 3, 2};
        nextPermutation(ttt);
        System.out.println(ttt);
        Solution s = new Solution();
//        System.out.println(strStr("hello", "hello"));
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        boolean changed = false;
        int p = nums.length - 2;
        while (p >= 0) {
            if (nums[p] < nums[p + 1]) {
                int k = p+1;
                for(int i = p+2; i < nums.length; i++){
                    if(nums[k] > nums[i] && nums[p] < nums[i]){
                        k = i;
                    }
                }
                swap(nums, p, k);


                Arrays.sort(nums, p + 1, nums.length);
                changed = true;
                break;
            }
            p--;
        }
        if (!changed) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, nums.length - 1 - i);
            }
        }
    }

    private static void swap(int[] nums, int one, int two) {
        int t = nums[one];
        nums[one] = nums[two];
        nums[two] = t;
    }
}
