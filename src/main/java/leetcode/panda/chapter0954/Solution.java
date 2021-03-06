package leetcode.panda.chapter0954;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 * <p>
 * 输入：arr = [1,2,4,16,8,4]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-5, -2};
        System.out.println(s.canReorderDoubled(nums));

    }

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        double findedValue = 0;
        for (int i = 0; i < arr.length; i++) {
            while(i< arr.length && arr[i] ==1000000){
                i++;
            }
            if(i == arr.length){
                break;
            }
            findedValue = arr[i] < 0 ? arr[i] / 2.0 : arr[i] * 2.0;
            int j = i + 1;
            while (j < arr.length && (findedValue != arr[j] || arr[j] == 1000000) ){
                j++;
            }
            if (j == arr.length) {
                return false;
            }
            arr[j] = 1000000;
        }
        return true;

    }
}