package leetcode.panda.chapter0045;

/**
 *
 *给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 */
public class Solution {
    public static void main(String[] args) {
//        int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        int[] nums ={2,3,1,1,4};
        System.out.println(jump(nums));
    }


    /**
     * 贪心算法（滑动窗口）：每一步向后挑最大位置，当用户下一步超出范畴时，即得到最大步数
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int jumped = 1;
        int pre = 0;
        int next = nums[0];
        while(next < nums.length-1){
            int max = next;
            for(int i = pre; i<= next; i++){
                if(i + nums[i] > max){
                    max = i + nums[i];
                }
            }
            jumped++;
            pre = next;
            next=max;
        }

        return jumped;
    }


}
