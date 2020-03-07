package leetcode.panda.chapter0011;

public class Solution {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }

    public static int maxArea(int[] height) {
        int size = height.length;
        int max=0;
        for(int i = 0; i < size; i++){
            for(int j = i +1; j < size; j++){
                int h = Math.min(height[i], height[j]);
                int m = h *(j-i);
                if(m > max){
                    max = m;
                }
            }
        }
        return max;
    }

    //动态规划算法
    public static int maxArea2(int[] height){
        int r = height.length -1;
        int l = 0;
        int max =0;
        while(l < r){
            max = Math.max(max, Math.min(height[r], height[l]) * (r-l));
            if(height[r] < height[l]){
                r--;
            }
            else{
                l++;
            }
        }
        return max;
    }

}
