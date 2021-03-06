package leetcode.panda.chapter0976;

import java.util.Arrays;

/**
 *给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 *
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 *
 * 输入：[3,6,2,3]
 * 输出：8
 *
 *
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,2,1};
        System.out.println(s.largestPerimeter(nums));
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int sum =0;
        int index = A.length-1;
        while(sum ==0 && index >=2){
            if(A[index-2]+A[index-1] > A[index]){
                sum = A[index]+A[index-1]+A[index-2];
            }
            index--;
        }
        return sum;
    }

}