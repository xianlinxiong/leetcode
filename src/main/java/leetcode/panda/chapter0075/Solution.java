package leetcode.panda.chapter0075;

/**
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {1,2,0,0};
        s.sortColors(nums);
        System.out.println("");

    }

    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        while (zero < two && nums[zero] == 0) {
            zero++;
        }
        while (zero < two && nums[two] == 2) {
            two--;
        }
        int one = zero;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, one, zero);
                while (one < two && nums[zero] == 0) {
                    zero++;
                }

                if (nums[one] == 2) {
                    swap(nums, two, zero);
                    two--;
                }
                one++;
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, two, one);
                while (one < two && nums[two] == 2) {
                    two--;
                }
                if (nums[one] == 0) {
                    swap(nums, one, zero);
                    zero++;
                }
                one++;
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}