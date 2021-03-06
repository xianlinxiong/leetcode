package leetcode.panda.chapter0215;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums ={3,2,1, 5,6,4};
        System.out.println(s.findKthLargest(nums, 2));

    }

    public int findKthLargest(int[] nums, int k) {

        int index = quickSort(nums, 0, nums.length-1, k);
        return nums[index];
    }

    int quickSort(int[] nums, int start, int end, int k){
        if(start >= end){
            return end;
        }
        int l = start;
        int r = end;
        int current = nums[l];
        while(l < r){
            while(l<r && nums[r]>=current){
                r--;
            }
            if(l<r){
                nums[l] = nums[r];
                l++;
            }
            while(l<r && nums[l]< current){
                l++;
            }
            if(l<r){
                nums[r]=nums[l];
                r--;
            }
        }
        nums[l] = current;
        int re = l+k;
        if(re == nums.length){
            return l;
        }else if(re > nums.length){
            return quickSort(nums,start, l-1,k);
        }else{
            return quickSort(nums, l+1, end, k);
        }
    }
}