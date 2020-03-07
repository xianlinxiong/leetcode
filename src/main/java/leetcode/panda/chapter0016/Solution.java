package leetcode.panda.chapter0016;

import java.util.*;

/**
 * 进阶：水平扫描，垂直扫描，分段查询，最短字符串二分扫描
 */
public class Solution {
    public static void main(String[] args) {

        String[] ss = {"dog", "racecar", "car"};
        int[] ii ={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSumClosest(ii, -18));
    }

    /**
     * 先排序，然后定点，两头移动
     * @param nums
     * @return
     */
    public static int threeSumClosest(int[] nums, int target){

        Arrays.sort(nums);
        int length = nums.length;
        int differ  = Integer.MAX_VALUE;
        int result =Integer.MIN_VALUE;
        for(int i = 0; i< length -2; i++){
            for(int j = i + 1, k= length-1;j<k;){
                int sum = nums[i] + nums[j] + nums[k];
                int newDiffer = Math.abs(sum - target);
                if(newDiffer <differ){
                    differ = newDiffer;
                    result = sum;
                }

                if(sum < target){
                    j++;
                }
                else{
                    k--;
                }

                while(j < k && j >i+1 && nums[j] == nums[j-1]){
                    j++;
                }
                while(j<k && k<length-1 && nums[k] == nums[k+1]) {
                    k--;
                }
            }
            while(i < length -2 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }


}
