package leetcode.panda.chapter0026;

/**
 * 进阶:双标记法
 *
 */
public class Solution {
    public static void main(String[] args) {


    }
    public int removeDuplicates(int[] nums) {
        if(nums == null){
            return 0;
        }
        int start=1, flag=0;
        for(; start < nums.length; ){
            if(nums[start] == nums[start-1]){
                start++;
            }
            else{
                nums[++flag] = nums[start++];
            }
        }
        return flag+1;
    }
}
