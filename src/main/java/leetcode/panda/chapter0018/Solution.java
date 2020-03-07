package leetcode.panda.chapter0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 进阶：双重循环判断， 双标记位（优化：考虑首尾倍数重叠，杜绝额外重复）
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};


        System.out.println(fourSum(nums, -11));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 3; i++) {
            for (int n = i + 1; n < length - 2; n++) {
                for (int j = n + 1, k = length - 1; j < k; ) {
                    boolean moveK = false, moveJ = false;
                    if (nums[i] + nums[n] + nums[j] + nums[k] == target) {
                        result.add(Arrays.asList(nums[i],nums[n], nums[j], nums[k]));
                        j++;
                        k--;
                        moveJ = true;
                        moveK = true;
                    } else if (nums[i] +nums[n] + nums[j] + nums[k] < target) {
                        j++;
                        moveJ = true;
                    } else {
                        k--;
                        moveK = true;
                    }
                    while (moveJ && j < k && j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (moveK && j < k && k < length - 1 && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }

                while (n < length - 3 && nums[n] == nums[n + 1]) {
                    n++;
                }
            }
            while (i < length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


}
