package leetcode.panda.chapter0027;

/**
 * 进阶:双标记法
 *
 */
public class Solution {
    public static void main(String[] args) {


    }
    public int removeElement(int[] nums, int val) {
        if(nums == null){
            return 0;
        }
        int start=0, flag=0;
        for(; start < nums.length; ){
            if(nums[start] == val){
                start++;
            }
            else{
                nums[flag++] = nums[start++];
            }
        }
        return flag;
    }
}
