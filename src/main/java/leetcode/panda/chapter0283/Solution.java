package leetcode.panda.chapter0283;

/**
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};

    }
    public void moveZeroes(int[] nums) {
        if(nums == null){
            return;
        }
        int cur = 0;
        int end = nums.length-1;
        while(cur < end && nums[cur]!=0){
            cur++;
        }

        int start = cur+1;
        while(start <= end){
            if(nums[start] != 0){
                nums[cur++] = nums[start];
                nums[start]=0;
            }
            start++;
        }
    }
}